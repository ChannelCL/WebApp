package com.jia.train.po;

/**
 * Created by jiaxl on 2017/1/1.
 * 车次信息详情
 */
public class TrainInfo {

    private String station_train_code;//车次
    private String from_station_name;//出发站
    private String to_station_name;//到达站
    private String lishi;//时长
    private String start_time;//出发时间
    private String arrive_time;//到达时间
    private String swz_num;//商务座
    private String tz_num;//特等座
    private String zy_num;//一等座
    private String ze_num;//二等座
    private String gr_num;//高级软卧
    private String rw_num;//软卧
    private String yw_num;//硬卧
    private String rz_num;//软座
    private String yz_num;//硬座
    private String wz_num;//无座
    private String train_no;//车次编号
    private String buttonTextInfo;//按钮信息
    private String secretStr;//车次签名
    private String canWebBuy;//是否可以购买
    public String getStation_train_code() {
        return station_train_code;
    }

    public void setStation_train_code(String station_train_code) {
        this.station_train_code = station_train_code;
    }

    public String getFrom_station_name() {
        return from_station_name;
    }

    public void setFrom_station_name(String from_station_name) {
        this.from_station_name = from_station_name;
    }

    public String getTo_station_name() {
        return to_station_name;
    }

    public void setTo_station_name(String to_station_name) {
        this.to_station_name = to_station_name;
    }

    public String getLishi() {
        return lishi;
    }

    public void setLishi(String lishi) {
        this.lishi = lishi;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(String arrive_time) {
        this.arrive_time = arrive_time;
    }

    public String getSwz_num() {
        return swz_num;
    }

    public void setSwz_num(String swz_num) {
        this.swz_num = swz_num;
    }

    public String getTz_num() {
        return tz_num;
    }

    public void setTz_num(String tz_num) {
        this.tz_num = tz_num;
    }

    public String getZy_num() {
        return zy_num;
    }

    public void setZy_num(String zy_num) {
        this.zy_num = zy_num;
    }

    public String getZe_num() {
        return ze_num;
    }

    public void setZe_num(String ze_num) {
        this.ze_num = ze_num;
    }

    public String getRw_num() {
        return rw_num;
    }

    public void setRw_num(String rw_num) {
        this.rw_num = rw_num;
    }

    public String getYw_num() {
        return yw_num;
    }

    public void setYw_num(String yw_num) {
        this.yw_num = yw_num;
    }

    public String getRz_num() {
        return rz_num;
    }

    public void setRz_num(String rz_num) {
        this.rz_num = rz_num;
    }

    public String getYz_num() {
        return yz_num;
    }

    public void setYz_num(String yz_num) {
        this.yz_num = yz_num;
    }

    public String getWz_num() {
        return wz_num;
    }

    public void setWz_num(String wz_num) {
        this.wz_num = wz_num;
    }

    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    public String getButtonTextInfo() {
        return buttonTextInfo.contains("维护")?"系统维护":buttonTextInfo;
    }

    public void setButtonTextInfo(String buttonTextInfo) {
        this.buttonTextInfo = buttonTextInfo;
    }

    public String getSecretStr() {
        return secretStr;
    }

    public void setSecretStr(String secretStr) {
        this.secretStr = secretStr;
    }

    public String getCanWebBuy() {
        return canWebBuy;
    }

    public void setCanWebBuy(String canWebBuy) {
        this.canWebBuy = canWebBuy;
    }

    public String getGr_num() {
        return gr_num;
    }

    public void setGr_num(String gr_num) {
        this.gr_num = gr_num;
    }

    @Override
    public String toString() {
        return "TrainInfo{" +
                "station_train_code='" + station_train_code + '\'' +
                ", from_station_name='" + from_station_name + '\'' +
                ", to_station_name='" + to_station_name + '\'' +
                ", lishi='" + lishi + '\'' +
                ", start_time='" + start_time + '\'' +
                ", arrive_time='" + arrive_time + '\'' +
                ", swz_num='" + swz_num + '\'' +
                ", tz_num='" + tz_num + '\'' +
                ", zy_num='" + zy_num + '\'' +
                ", ze_num='" + ze_num + '\'' +
                ", gr_num='" + gr_num + '\'' +
                ", rw_num='" + rw_num + '\'' +
                ", yw_num='" + yw_num + '\'' +
                ", rz_num='" + rz_num + '\'' +
                ", yz_num='" + yz_num + '\'' +
                ", wz_num='" + wz_num + '\'' +
                ", train_no='" + train_no + '\'' +
                ", buttonTextInfo='" + buttonTextInfo + '\'' +
                ", secretStr='" + secretStr + '\'' +
                ", canWebBuy='" + canWebBuy + '\'' +
                '}';
    }
}
