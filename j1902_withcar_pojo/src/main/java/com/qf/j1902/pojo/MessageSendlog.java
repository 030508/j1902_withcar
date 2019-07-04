package com.qf.j1902.pojo;

public class MessageSendlog {
    private Long id;

    private Long messageId;

    private Integer sendTime;

    private Long toMid;

    private Integer received;

    private Integer receiveTime;

    private Byte viewed;

    private Integer viewTime;

    private Byte viewDetail;

    private Integer viewDetailTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Integer getSendTime() {
        return sendTime;
    }

    public void setSendTime(Integer sendTime) {
        this.sendTime = sendTime;
    }

    public Long getToMid() {
        return toMid;
    }

    public void setToMid(Long toMid) {
        this.toMid = toMid;
    }

    public Integer getReceived() {
        return received;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }

    public Integer getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Integer receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Byte getViewed() {
        return viewed;
    }

    public void setViewed(Byte viewed) {
        this.viewed = viewed;
    }

    public Integer getViewTime() {
        return viewTime;
    }

    public void setViewTime(Integer viewTime) {
        this.viewTime = viewTime;
    }

    public Byte getViewDetail() {
        return viewDetail;
    }

    public void setViewDetail(Byte viewDetail) {
        this.viewDetail = viewDetail;
    }

    public Integer getViewDetailTime() {
        return viewDetailTime;
    }

    public void setViewDetailTime(Integer viewDetailTime) {
        this.viewDetailTime = viewDetailTime;
    }
}