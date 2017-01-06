package com.jia.train.listener;

import com.jia.train.data.Constants;
import com.jia.train.po.U12306;
import com.jia.train.ui.CaptchaUI;
import com.jia.train.ui.UI;
import com.jia.train.util.SessionCheck;
import com.jia.train.util.Utils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jiaxl on 2016/12/27.
 */
public class ButtonActionListener implements ActionListener {
    private UI ui;
    private CaptchaUI captchaUI;

    public ButtonActionListener(UI frame) {
        this.ui = frame;
    }

    public ButtonActionListener(CaptchaUI captchaUI) {
        this.captchaUI = captchaUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("事件：" + e.getActionCommand());
        //点击登录按钮显示验证码
        if (e.getActionCommand().equals("登录")) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        SessionCheck.stop();
                        ui.u12306.setUser(ui.usertext.getText().trim());
                        ui.u12306.setPsd(ui.psdtext.getText().trim());
                        Utils.setCookie(ui.u12306);
                        ui.showCaptchaUI("请选择验证码....");
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(ui, "请求超时");
                    }
                }
            }.start();

        /**
         * 点击验证码页面确认按钮
         */
        } else if (e.getActionCommand().equals("确定")) {
            //更新验证码坐标
            captchaUI.u12306.setCode("");
            for (Integer key : captchaUI.codeXY.keySet()) {
                if (captchaUI.codeXY.get(key) != null) {
                    captchaUI.u12306.setCode(captchaUI.u12306.getCode() + captchaUI.selectCode.get(key) + ",");
                }
            }
            System.out.println(captchaUI.u12306.getCode());
            //检查验证码
            if (Utils.validateCode(captchaUI.u12306)) {

                int code = Utils.login(captchaUI.u12306);

                if (code == Constants.LOGIN_SUCCESS) {
                    captchaUI.dispose();
                    Utils.initData(captchaUI.u12306);
                    //启动检测登录状态线程
                    SessionCheck.startCheck(captchaUI.u12306);
                } else if (code == Constants.USERNAME_ERROR) {
                    JOptionPane.showMessageDialog(captchaUI,"用户名不存在！");
                    captchaUI.refreshCaptcha(++(captchaUI.captchaVersion));
                }else if (code == Constants.PASSWORD_ERROR) {
                    JOptionPane.showMessageDialog(captchaUI,"密码错误！超过4次错误锁定20分钟！");
                    captchaUI.refreshCaptcha(++(captchaUI.captchaVersion));
                }else if(code==Constants.USERNAME_LOCKED){
                    JOptionPane.showMessageDialog(captchaUI,"账户已被锁定，稍后再试！");
                    captchaUI.refreshCaptcha(++(captchaUI.captchaVersion));
                }
            }else {
                captchaUI.refreshCaptcha(++(captchaUI.captchaVersion));
            }

        /**
         * 注销按钮
         */
        } else if (e.getActionCommand().equals("注销")) {
            ui.logoutButton.setVisible(false);
            ui.loginPanel.setVisible(true);
            ui.welcomeLabel.setText("");
            SessionCheck.stop();
        }
    }
}
