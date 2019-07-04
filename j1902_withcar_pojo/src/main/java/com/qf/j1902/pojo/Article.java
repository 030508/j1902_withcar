package com.qf.j1902.pojo;

public class Article {
    private Long id;

    private String title;

    private Integer categoryId;

    private String source;

    private String author;

    private String summary;

    private String coverPic;

    private String thumbPic;

    private String tags;

    private String content;

    private String previewUrl;

    private String qrcodeUrl;

    private Integer pvCount;

    private Integer uvCount;

    private Integer commentCount;

    private Integer likeCount;

    private Integer favCount;

    private Integer shareCount;

    private Byte channelTop;

    private Byte homeTop;

    private Integer createUid;

    private String createUname;

    private Integer createTime;

    private Integer submitUid;

    private Integer submitTime;

    private Integer states;

    private Integer stateOrder;

    private Integer lastAuditUid;

    private String lastAuditUsername;

    private Integer lastAuditTime;

    private String lastRejectReason;

    private Byte publishState;

    private Integer publishUid;

    private String publishUname;

    private Integer publishTime;

    private Integer unpublishUid;

    private String unpublishUname;

    private Integer unpublishTime;

    private String unpublishReason;

    private Integer lastUpdateUid;

    private String lastUpdateUname;

    private Integer lastUpdateTime;

    private String seoKeywords;

    private String seoDescription;

    private Byte allowUp;

    private Byte allowFav;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic == null ? null : coverPic.trim();
    }

    public String getThumbPic() {
        return thumbPic;
    }

    public void setThumbPic(String thumbPic) {
        this.thumbPic = thumbPic == null ? null : thumbPic.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl == null ? null : previewUrl.trim();
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl == null ? null : qrcodeUrl.trim();
    }

    public Integer getPvCount() {
        return pvCount;
    }

    public void setPvCount(Integer pvCount) {
        this.pvCount = pvCount;
    }

    public Integer getUvCount() {
        return uvCount;
    }

    public void setUvCount(Integer uvCount) {
        this.uvCount = uvCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getFavCount() {
        return favCount;
    }

    public void setFavCount(Integer favCount) {
        this.favCount = favCount;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Byte getChannelTop() {
        return channelTop;
    }

    public void setChannelTop(Byte channelTop) {
        this.channelTop = channelTop;
    }

    public Byte getHomeTop() {
        return homeTop;
    }

    public void setHomeTop(Byte homeTop) {
        this.homeTop = homeTop;
    }

    public Integer getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    public String getCreateUname() {
        return createUname;
    }

    public void setCreateUname(String createUname) {
        this.createUname = createUname == null ? null : createUname.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getSubmitUid() {
        return submitUid;
    }

    public void setSubmitUid(Integer submitUid) {
        this.submitUid = submitUid;
    }

    public Integer getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Integer submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public Integer getStateOrder() {
        return stateOrder;
    }

    public void setStateOrder(Integer stateOrder) {
        this.stateOrder = stateOrder;
    }

    public Integer getLastAuditUid() {
        return lastAuditUid;
    }

    public void setLastAuditUid(Integer lastAuditUid) {
        this.lastAuditUid = lastAuditUid;
    }

    public String getLastAuditUsername() {
        return lastAuditUsername;
    }

    public void setLastAuditUsername(String lastAuditUsername) {
        this.lastAuditUsername = lastAuditUsername == null ? null : lastAuditUsername.trim();
    }

    public Integer getLastAuditTime() {
        return lastAuditTime;
    }

    public void setLastAuditTime(Integer lastAuditTime) {
        this.lastAuditTime = lastAuditTime;
    }

    public String getLastRejectReason() {
        return lastRejectReason;
    }

    public void setLastRejectReason(String lastRejectReason) {
        this.lastRejectReason = lastRejectReason == null ? null : lastRejectReason.trim();
    }

    public Byte getPublishState() {
        return publishState;
    }

    public void setPublishState(Byte publishState) {
        this.publishState = publishState;
    }

    public Integer getPublishUid() {
        return publishUid;
    }

    public void setPublishUid(Integer publishUid) {
        this.publishUid = publishUid;
    }

    public String getPublishUname() {
        return publishUname;
    }

    public void setPublishUname(String publishUname) {
        this.publishUname = publishUname == null ? null : publishUname.trim();
    }

    public Integer getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Integer publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getUnpublishUid() {
        return unpublishUid;
    }

    public void setUnpublishUid(Integer unpublishUid) {
        this.unpublishUid = unpublishUid;
    }

    public String getUnpublishUname() {
        return unpublishUname;
    }

    public void setUnpublishUname(String unpublishUname) {
        this.unpublishUname = unpublishUname == null ? null : unpublishUname.trim();
    }

    public Integer getUnpublishTime() {
        return unpublishTime;
    }

    public void setUnpublishTime(Integer unpublishTime) {
        this.unpublishTime = unpublishTime;
    }

    public String getUnpublishReason() {
        return unpublishReason;
    }

    public void setUnpublishReason(String unpublishReason) {
        this.unpublishReason = unpublishReason == null ? null : unpublishReason.trim();
    }

    public Integer getLastUpdateUid() {
        return lastUpdateUid;
    }

    public void setLastUpdateUid(Integer lastUpdateUid) {
        this.lastUpdateUid = lastUpdateUid;
    }

    public String getLastUpdateUname() {
        return lastUpdateUname;
    }

    public void setLastUpdateUname(String lastUpdateUname) {
        this.lastUpdateUname = lastUpdateUname == null ? null : lastUpdateUname.trim();
    }

    public Integer getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Integer lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords == null ? null : seoKeywords.trim();
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription == null ? null : seoDescription.trim();
    }

    public Byte getAllowUp() {
        return allowUp;
    }

    public void setAllowUp(Byte allowUp) {
        this.allowUp = allowUp;
    }

    public Byte getAllowFav() {
        return allowFav;
    }

    public void setAllowFav(Byte allowFav) {
        this.allowFav = allowFav;
    }
}