package com.qf.j1902.pojo;

public class Visitor {
    private Long id;

    private String visitorGuid;

    private Integer firstVisitTime;

    private String entryUrl;

    private String visitorIp;

    private String visitorDevice;

    private String visitorChannel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisitorGuid() {
        return visitorGuid;
    }

    public void setVisitorGuid(String visitorGuid) {
        this.visitorGuid = visitorGuid == null ? null : visitorGuid.trim();
    }

    public Integer getFirstVisitTime() {
        return firstVisitTime;
    }

    public void setFirstVisitTime(Integer firstVisitTime) {
        this.firstVisitTime = firstVisitTime;
    }

    public String getEntryUrl() {
        return entryUrl;
    }

    public void setEntryUrl(String entryUrl) {
        this.entryUrl = entryUrl == null ? null : entryUrl.trim();
    }

    public String getVisitorIp() {
        return visitorIp;
    }

    public void setVisitorIp(String visitorIp) {
        this.visitorIp = visitorIp == null ? null : visitorIp.trim();
    }

    public String getVisitorDevice() {
        return visitorDevice;
    }

    public void setVisitorDevice(String visitorDevice) {
        this.visitorDevice = visitorDevice == null ? null : visitorDevice.trim();
    }

    public String getVisitorChannel() {
        return visitorChannel;
    }

    public void setVisitorChannel(String visitorChannel) {
        this.visitorChannel = visitorChannel == null ? null : visitorChannel.trim();
    }
}