package com.jia.train.listener;

import com.jia.train.po.TrainInfo;
import com.jia.train.ui.TicketInfoPanel;
import com.jia.train.ui.TrainInfoTableModel;
import com.jia.train.util.Utils;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by jiaxl on 2017/1/1.
 */
public class QueryTicketActionListener implements ActionListener {
    TicketInfoPanel ticketInfoPanel;
    public QueryTicketActionListener(TicketInfoPanel ticketInfoPanel){
        this.ticketInfoPanel=ticketInfoPanel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(!ticketInfoPanel.queryInfo.check()){
            JOptionPane.showMessageDialog(ticketInfoPanel,"查询条件错误");
            return;
        }
        new Thread(){
            @Override
            public void run() {
                try {
                    List<TrainInfo>list=Utils.queryTicket(ticketInfoPanel.queryInfo);
                    ticketInfoPanel.tableModel=new TrainInfoTableModel(list);
                    System.out.println("ssssss"+list);
                    ticketInfoPanel.table.setModel(ticketInfoPanel.tableModel);
                    ticketInfoPanel.table.validate();
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(ticketInfoPanel,e1.getMessage());
                }
            }
        }.start();

    }
}
