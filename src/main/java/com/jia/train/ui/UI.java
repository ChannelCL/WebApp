package com.jia.train.ui;

import com.jia.train.data.UserData;
import com.jia.train.listener.ButtonActionListener;
import com.jia.train.listener.SessionListener;
import com.jia.train.po.U12306;
import com.jia.train.util.SessionCheck;
import com.jia.train.util.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by jiaxl on 2016/12/27.
 */
public class UI extends JFrame implements SessionListener {
    public JTextField usertext = new JTextField("***", 10);
    public JLabel userlabel = new JLabel("12306账号:");
    public JPanel loginPanel = new JPanel();
    public JPasswordField psdtext = new JPasswordField("***");
    public JLabel psdlabel = new JLabel("密码:");
    public JButton loginButton = new JButton("登录");
    public ButtonActionListener listen = new ButtonActionListener(this);
    public JLabel welcomeLabel = new JLabel("");
    public JButton logoutButton = new JButton("注销");
    public U12306 u12306 = new U12306();
    TicketInfoPanel ticketPanel;

    public UI() throws IOException {
        initListener();
        initUI();
        ticketPanel = new TicketInfoPanel(this.getWidth(),this.getHeight());
        this.add(ticketPanel);
        this.setVisible(true);
    }

    private void initListener() {
        loginButton.addActionListener(listen);
        SessionCheck.addSessionListener(this);
        logoutButton.addActionListener(listen);
    }

    private void initUI() throws IOException {
        this.setLayout(null);

        this.setTitle("简易12306助手");
        this.setIconImage(ImageIO.read(this.getClass().getResourceAsStream("/12306.png")));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 20, 1100, 700);
        welcomeLabel.setFont(new Font("宋体", Font.PLAIN, 14));
        welcomeLabel.setBounds(this.getWidth() - 230, 10, 100, 30);
        this.add(welcomeLabel);
        logoutButton.setFont(new Font("宋体", Font.PLAIN, 14));
        logoutButton.setBounds(this.getWidth() - 120, 13, 60, 25);
        logoutButton.setVisible(false);
        this.add(logoutButton);
        usertext.setFont(new Font("宋体", Font.PLAIN, 16));
        userlabel.setFont(new Font("宋体", Font.PLAIN, 14));
        usertext.setBounds(100, 10, 150, 25);
        userlabel.setBounds(20, 13, 100, 20);
        loginPanel.setLayout(null);
        loginPanel.setBounds(0, 0, this.getWidth() - 200, 50);
        loginPanel.add(userlabel);
        loginPanel.add(usertext);
        psdlabel.setBounds(260, 10, 150, 25);
        psdlabel.setFont(new Font("宋体", Font.PLAIN, 14));
        psdtext.setBounds(300, 10, 150, 26);
        psdtext.setFont(new Font("宋体", Font.PLAIN, 10));

        loginButton.setFont(new Font("宋体", Font.PLAIN, 15));
        loginButton.setBounds(500, 10, 80, 30);
        loginPanel.add(loginButton);
        loginPanel.add(psdlabel);
        loginPanel.add(psdtext);
        this.add(loginPanel);
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new UI();
    }

    @Override
    public void dealSessionExpired(boolean status, String msg) {
        try {
            if (status) {
                welcomeLabel.setText("欢迎你，" + UserData.getName());
                logoutButton.setVisible(true);
                loginPanel.setVisible(false);
            } else {
                Utils.setCookie(u12306);
                loginPanel.setVisible(true);
                showCaptchaUI("已掉线，重新登录...");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void showCaptchaUI(String title) {
        try {
            new CaptchaUI(this,title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
