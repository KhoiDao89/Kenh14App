package com.example.kenh14app;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TinTuc {

    @SerializedName("LastUpdated")
    LastUpdated lastUpdated;
    @SerializedName("News")
    ArrayList<News> news;

    public TinTuc() {
        lastUpdated = new LastUpdated();
        news= new ArrayList<>();
    }

    public ArrayList<News> getNews(){
        return news;
    }

    @Override
    public String toString() {
        return news.get(0).newsRelations.get(0).title;
    }

//    public int getZoneId(int i) {
//        return news.get(i).zoneId;
//    }
//
//    public String getZoneName(int i) {
//        return news.get(i).zoneName;
//    }
//
//    public String getZoneShortURL(int i) {
//        return news.get(i).zoneShortURL;
//    }
//
//    public String getNewsId(int i) {
//        return news.get(i).newsId;
//    }
//
//    public String getTitle(int i) {
//        return news.get(i).title;
//    }
//
//    public String getSubTitle(int i) {
//        return news.get(i).subTitle;
//    }
//
//    public String getInitSapo(int i) {
//        return news.get(i).initSapo;
//    }
//
//    public String getSapo(int i) {
//        return news.get(i).sapo;
//    }
//
    public String getUrl(int i) {
        return news.get(i).url;
    }
//
//    public String getAvatar(int i) {
//        return news.get(i).avatar;
//    }
//
//    public String getDistributionDate(int i) {
//        return news.get(i).distributionDate;
//    }
//
//    public int getNewsType(int i) {
//        return news.get(i).newsType;
//    }
//
//    public int getType(int i) {
//        return news.get(i).type;
//    }

//    public ArrayList<News.NewsRelation> getNewsRelations(int i) {
//        return newsRelations;
//    }

//    public String getSourceLink(int i) {
//        return news.get(i).sourceLink;
//    }
//
//    public String getSource(int i) {
//        return news.get(i).source;
//    }
//
//    public int getCommentCount(int i) {
//        return news.get(i).commentCount;
//    }
//
//    public int getShareCount(int i) {
//        return news.get(i).shareCount;
//    }

    public class LastUpdated{
        @SerializedName("Data")
        String data;
    }
    public class News{
        @SerializedName("ZoneId")
        int zoneId;
        @SerializedName("ZoneName")
        String zoneName;
        @SerializedName("ZoneShortURL")
        String zoneShortURL;
        @SerializedName("NewsId")
        String newsId;
        @SerializedName("Title")
        String title;
        @SerializedName("SubTitle")
        String subTitle;
        @SerializedName("InitSapo")
        String initSapo;
        @SerializedName("Sapo")
        String sapo;
        @SerializedName("Url")
        String url;
        @SerializedName("Avatar")
        String avatar;
        @SerializedName("DistributionDate")
        String distributionDate;
        @SerializedName("NewsType")
        int newsType;
        @SerializedName("Type")
        int type;
        @SerializedName("NewsRelation")
        ArrayList<NewsRelation> newsRelations;
        @SerializedName("SourceLink")
        String sourceLink;
        @SerializedName("Source")
        String source;
        @SerializedName("CommentCount")
        int commentCount;
        @SerializedName("ShareCount")
        int shareCount;

        public News() {
            newsRelations = new ArrayList<>();
        }

        public int getZoneId() {
            return zoneId;
        }

        public String getZoneName() {
            return zoneName;
        }

        public String getZoneShortURL() {
            return zoneShortURL;
        }

        public String getNewsId() {
            return newsId;
        }

        public String getTitle() {
            return title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public String getInitSapo() {
            return initSapo;
        }

        public String getSapo() {
            return sapo;
        }

        public String getUrl() {
            return url;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getDistributionDate() {
            return distributionDate;
        }

        public int getNewsType() {
            return newsType;
        }

        public int getType() {
            return type;
        }

        public ArrayList<NewsRelation> getNewsRelations() {
            return newsRelations;
        }

        public String getSourceLink() {
            return sourceLink;
        }

        public String getSource() {
            return source;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public int getShareCount() {
            return shareCount;
        }

        public class NewsRelation{
            @SerializedName("NewsId")
            String newsId;
            @SerializedName("EncryptId")
            String encryptId;
            @SerializedName("ZoneId")
            int zoneId;
            @SerializedName("Type")
            int type;
            @SerializedName("Title")
            String title;
            @SerializedName("Url")
            String url;
            @SerializedName("Avatar")
            String avatar;
            @SerializedName("Avatar1")
            String avatar1;
            @SerializedName("Avatar2")
            String avatar2;
            @SerializedName("Avatar3")
            String avatar3;
            @SerializedName("Avatar4")
            String avatar4;
            @SerializedName("Avatar5")
            String avatar5;
            @SerializedName("DistributionDate")
            String distributionDate;
            @SerializedName("DisplayStyle")
            int displayStyle;
            @SerializedName("NewsRelationType")
            int newsRelationType;
            @SerializedName("ObjectType")
            int objectType;
            @SerializedName("AvatarPreload")
            String avatarPreLoad;
        }
    }
}
