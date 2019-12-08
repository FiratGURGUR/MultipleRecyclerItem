package com.developer.multiplerecycleritem;

public class NotificationModel {

    private String userFullName;
    private String userName;
    private String userPhotoUrl;
    private String nDescription;
    private String rowType;
    private String isFollowing;
    private String likedPhotoUrl;


    public NotificationModel(String userFullName, String userName, String userPhotoUrl, String nDescription, String rowType, String isFollowing,String likedPhotoUrl) {
        this.userFullName = userFullName;
        this.userName = userName;
        this.userPhotoUrl = userPhotoUrl;
        this.nDescription = nDescription;
        this.rowType = rowType;
        this.isFollowing = isFollowing;
        this.likedPhotoUrl = likedPhotoUrl;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public String getnDescription() {
        return nDescription;
    }

    public String getRowType() {
        return rowType;
    }

    public String getIsFollowing() {
        return isFollowing;
    }

    public String getLikedPhotoUrl() {
        return likedPhotoUrl;
    }
}
