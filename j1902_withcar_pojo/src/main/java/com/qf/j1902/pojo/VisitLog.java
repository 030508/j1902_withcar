package com.qf.j1902.pojo;

public class VisitLog {
    private Long id;

    private Long visitorId;

    private Long memberId;

    private String visitUrl;

    private String visitIp;

    private String visitDevice;

    private String visitSource;

    private Integer enterTime;

    private Integer exitTime;

    private Integer stay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getVisitUrl() {
        return visitUrl;
    }

    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl == null ? null : visitUrl.trim();
    }

    public String getVisitIp() {
        return visitIp;
    }

    public void setVisitIp(String visitIp) {
        this.visitIp = visitIp == null ? null : visitIp.trim();
    }

    public String getVisitDevice() {
        return visitDevice;
    }

    public void setVisitDevice(String visitDevice) {
        this.visitDevice = visitDevice == null ? null : visitDevice.trim();
    }

    public String getVisitSource() {
        return visitSource;
    }

    public void setVisitSource(String visitSource) {
        this.visitSource = visitSource == null ? null : visitSource.trim();
    }

    public Integer getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Integer enterTime) {
        this.enterTime = enterTime;
    }

    public Integer getExitTime() {
        return exitTime;
    }

    public void setExitTime(Integer exitTime) {
        this.exitTime = exitTime;
    }

    public Integer getStay() {
        return stay;
    }

    public void setStay(Integer stay) {
        this.stay = stay;
    }
}