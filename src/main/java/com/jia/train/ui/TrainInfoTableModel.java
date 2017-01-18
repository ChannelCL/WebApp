package com.jia.train.ui;

import com.jia.train.po.TrainInfo;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

/**
 * Created by jiaxl on 2017/1/7.
 */
public class TrainInfoTableModel implements TableModel {

    private List<TrainInfo> list; //要显示的TrainInfo对象列表

    //创建模型对象时，必须传入要显示的TrainInfo对象列表

    public TrainInfoTableModel(List<TrainInfo> list){

        this.list=list;

    }

    //得到行数:列表中有几个TrainInfo对象，就显示几行

    public int getRowCount(){

        return list.size();

    }

    //得到列数,TrainInfo对象的每个属性是一列，id,name,age,共3列

    public int getColumnCount(){

        return 17;

    }

    //指定某列的类型:暂时都是字符串类型，

    public Class<?> getColumnClass(int columnIndex){

        return JTextField.class;

    }

    //得到指定单元格的值:第几行，就是列表中的第几个TrainInfo对象

    public Object getValueAt(int rowIndex, int columnIndex){

        // 第几行，就是列表中的第几个TrainInfo对象
        TrainInfo info=list.get(rowIndex);
        switch (columnIndex){
            case 0:return info.getStation_train_code();
            case 1:return info.getFrom_station_name();
            case 2:return info.getTo_station_name();
            case 3:return info.getStart_time();
            case 4:return info.getArrive_time();
            case 5:return info.getLishi();
            case 6:return info.getSwz_num();
            case 7:return info.getTz_num();
            case 8:return info.getZy_num();
            case 9:return info.getZe_num();
            case 10:return info.getGr_num();
            case 11:return info.getRw_num();
            case 12:return info.getYw_num();
            case 13:return info.getRz_num();
            case 14:return info.getYz_num();
            case 15:return info.getWz_num();
            case 16:return info.getButtonTextInfo();
            default:return ":";
        }
    }

    //界面数据有变化时，模型对象的这个方法会被调用，暂时弹出说明框

    public void setValueAt(Object aValue, int rowIndex, int columnIndex){

        String info=rowIndex+"行"+columnIndex+"列的值改变: "+aValue.toString();

        javax.swing.JOptionPane.showMessageDialog(null,info);

    }

    //指定某单元格是否可编辑:第一列不可编缉，第一列是ID，是每个对象的唯一识别号

    public boolean isCellEditable(int rowIndex, int columnIndex){

        if(columnIndex!=0){

            return true;

        }

        return false;

    }

    //取每一列的列名

    public String getColumnName(int columnIndex){

        switch (columnIndex){
            case 0:return "车次";
            case 1:return "出发站";
            case 2:return "到达站";
            case 3:return "出发时间";
            case 4:return "到达时间";
            case 5:return "历时";
            case 6:return "商务座";
            case 7:return "特等座";
            case 8:return "一等座";
            case 9:return "二等座";
            case 10:return "高级软卧";
            case 11:return "软卧";
            case 12:return "硬卧";
            case 13:return "软座";
            case 14:return "硬座";
            case 15:return "无座";
            case 16:return "操作";
        }
        if(columnIndex==0){//第一列是TrainInfo对象的id值

            return "序号";

        }else if(columnIndex==1){//第二列是name属性值



            return "姓名";

        }else if(columnIndex==2){//第二列是age值

            return "年令";

        }else{//除非设计时逻辑错误，否则不会到这里

            return "出错!";

        }

    }

    //添加和移除监听器的方法暂不用，写为空的

    public void addTableModelListener(TableModelListener l){}

    public void removeTableModelListener(TableModelListener l){}

}
