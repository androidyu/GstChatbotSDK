package com.gst.gstapplet.retrofit.bean;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.gst.gstapplet.adapter.ChatBotItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.gst.gstapplet.util.Constant.MULTI_CARD;
import static com.gst.gstapplet.util.Constant.SINGLE_LEFT_TEXT_RIGHT_PHOTO;
import static com.gst.gstapplet.util.Constant.SINGLE_RIGHT_PHOTO_LEFT_TEXT;
import static com.gst.gstapplet.util.Constant.SINGLE_TOP_PHOTO_BOTTOM_TEXT;
import static com.gst.gstapplet.util.Constant.TEXT;


@Entity(tableName = "rcsinfo_table")
public class RcsInfoBean implements ChatBotItem {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "rcs_id")
    private Long rcs_id;

    private Long id;

    private String modelName;//模版名称

    private String nav;//导航语

    private String pageTitle;//页面标题

    private Integer modelType;//模版类型 (0:静态，1:动态)
    private Integer modelStyle;//模版样式 (0：文本，1：单卡片，2：多卡片)

    private List<Card> multipleCard;//模版卡片

    private List<Button> floatBtn;//悬浮按钮

    private String groupId;

    private String groupName;

    private String chatbotCode;

    private String chatbotName;

    private String chatbotLogo;

    private String touchText;

    private Long templateId;

    private String templateName;

    private Date createTime;

    private Date templateUpdateTime;

    private Integer singleCardLayout = 0;

    private Integer multiCardWidth = 0;//多卡片宽度，0：小，1：中

    private String cssMessage;

    private String cssMessageTitle;

    private String cssMessageDescription;

    private String cssMessageSuggestions;

    private String cssUrl;

    public RcsInfoBean() {
    }

    @Ignore
    public RcsInfoBean(Long id, String modelName, String nav, String pageTitle, Integer modelType, Integer modelStyle, List<Card> multipleCard, List<Button> floatBtn, String groupId, String groupName, String chatbotCode, String chatbotName, String chatbotLogo, String touchText, Long templateId, String templateName, Date createTime, Date templateUpdateTime, Integer singleCardLayout, Integer multiCardWidth, String cssMessage, String cssMessageTitle, String cssMessageDescription, String cssMessageSuggestions, String cssUrl) {
        this.id = id;
        this.modelName = modelName;
        this.nav = nav;
        this.pageTitle = pageTitle;
        this.modelType = modelType;
        this.modelStyle = modelStyle;
        this.multipleCard = multipleCard;
        this.floatBtn = floatBtn;
        this.groupId = groupId;
        this.groupName = groupName;
        this.chatbotCode = chatbotCode;
        this.chatbotName = chatbotName;
        this.chatbotLogo = chatbotLogo;
        this.touchText = touchText;
        this.templateId = templateId;
        this.templateName = templateName;
        this.createTime = createTime;
        this.templateUpdateTime = templateUpdateTime;
        this.singleCardLayout = singleCardLayout;
        this.multiCardWidth = multiCardWidth;
        this.cssMessage = cssMessage;
        this.cssMessageTitle = cssMessageTitle;
        this.cssMessageDescription = cssMessageDescription;
        this.cssMessageSuggestions = cssMessageSuggestions;
        this.cssUrl = cssUrl;
    }

    @NonNull
    public Long getRcs_id() {
        return rcs_id;
    }

    public void setRcs_id(@NonNull Long rcs_id) {
        this.rcs_id = rcs_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public Integer getModelType() {
        return modelType;
    }

    public void setModelType(Integer modelType) {
        this.modelType = modelType;
    }

    public Integer getModelStyle() {
        return modelStyle;
    }

    public void setModelStyle(Integer modelStyle) {
        this.modelStyle = modelStyle;
    }

    public List<Card> getMultipleCard() {
        return multipleCard;
    }

    public void setMultipleCard(List<Card> multipleCard) {
        this.multipleCard = multipleCard;
    }

    public List<Button> getFloatBtn() {
        return floatBtn;
    }

    public void setFloatBtn(List<Button> floatBtn) {
        this.floatBtn = floatBtn;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getChatbotCode() {
        return chatbotCode;
    }

    public void setChatbotCode(String chatbotCode) {
        this.chatbotCode = chatbotCode;
    }

    public String getChatbotName() {
        return chatbotName;
    }

    public void setChatbotName(String chatbotName) {
        this.chatbotName = chatbotName;
    }

    public String getChatbotLogo() {
        return chatbotLogo;
    }

    public void setChatbotLogo(String chatbotLogo) {
        this.chatbotLogo = chatbotLogo;
    }

    public String getTouchText() {
        return touchText;
    }

    public void setTouchText(String touchText) {
        this.touchText = touchText;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getTemplateUpdateTime() {
        return templateUpdateTime;
    }

    public void setTemplateUpdateTime(Date templateUpdateTime) {
        this.templateUpdateTime = templateUpdateTime;
    }

    public Integer getSingleCardLayout() {
        return singleCardLayout;
    }

    public void setSingleCardLayout(Integer singleCardLayout) {
        this.singleCardLayout = singleCardLayout;
    }

    public Integer getMultiCardWidth() {
        return multiCardWidth;
    }

    public void setMultiCardWidth(Integer multiCardWidth) {
        this.multiCardWidth = multiCardWidth;
    }

    public String getCssMessage() {
        return cssMessage;
    }

    public void setCssMessage(String cssMessage) {
        this.cssMessage = cssMessage;
    }

    public String getCssMessageTitle() {
        return cssMessageTitle;
    }

    public void setCssMessageTitle(String cssMessageTitle) {
        this.cssMessageTitle = cssMessageTitle;
    }

    public String getCssMessageDescription() {
        return cssMessageDescription;
    }

    public void setCssMessageDescription(String cssMessageDescription) {
        this.cssMessageDescription = cssMessageDescription;
    }

    public String getCssMessageSuggestions() {
        return cssMessageSuggestions;
    }

    public void setCssMessageSuggestions(String cssMessageSuggestions) {
        this.cssMessageSuggestions = cssMessageSuggestions;
    }

    public String getCssUrl() {
        return cssUrl;
    }

    public void setCssUrl(String cssUrl) {
        this.cssUrl = cssUrl;
    }

    @Override
    public int viewType() {
        switch (modelStyle) {
            case 0:
                return TEXT;
            case 1:
                switch (singleCardLayout) {
                    case 0:
                        return SINGLE_TOP_PHOTO_BOTTOM_TEXT;
                    case 1:
                        return SINGLE_LEFT_TEXT_RIGHT_PHOTO;
                    case 2:
                        return SINGLE_RIGHT_PHOTO_LEFT_TEXT;
                }
                break;
            case 2:
                return MULTI_CARD;
        }
        return 0;
    }

    /**
     * 卡片
     */
    public static class Card {
        public Card() {
        }

        public Card(Material material, String title, String abstractContext, Integer rank, List<Button> btnGroup) {
            this.material = material;
            this.title = title;
            this.abstractContext = abstractContext;
            this.rank = rank;
            this.btnGroup = btnGroup;
        }

        private Material material;//素材

        private String title;//卡片标题

        private String abstractContext;//卡片摘要

        private Integer rank;//序号

        private List<Button> btnGroup = new ArrayList<>();//"卡片按钮组"

        public Material getMaterial() {
            return material;
        }

        public void setMaterial(Material material) {
            this.material = material;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAbstractContext() {
            return abstractContext;
        }

        public void setAbstractContext(String abstractContext) {
            this.abstractContext = abstractContext;
        }

        public Integer getRank() {
            return rank;
        }

        public void setRank(Integer rank) {
            this.rank = rank;
        }

        public List<Button> getBtnGroup() {
            return btnGroup;
        }

        public void setBtnGroup(List<Button> btnGroup) {
            this.btnGroup = btnGroup;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "material=" + material +
                    ", title='" + title + '\'' +
                    ", abstractContext='" + abstractContext + '\'' +
                    ", rank=" + rank +
                    ", btnGroup=" + btnGroup +
                    '}';
        }
    }

    /**
     * 按钮
     */
    public static class Button {
        public Button() {
        }

        public Button(Long id, String btnName, String btnUrl, Integer btnType, Long msgWindowId, Long zdServeId, Long templateId, String zdServeUrl, Integer rank) {
            this.id = id;
            this.btnName = btnName;
            this.btnUrl = btnUrl;
            this.btnType = btnType;
            this.msgWindowId = msgWindowId;
            this.zdServeId = zdServeId;
            this.templateId = templateId;
            this.zdServeUrl = zdServeUrl;
            this.rank = rank;
        }

        private Long id;

        private String btnName;//按钮名称

        private String btnUrl;//跳转地址

        private Integer btnType;//按钮类型

        private Long msgWindowId;

        private Long zdServeId;

        private Long templateId;

        private String zdServeUrl;

        private Integer rank;//序号

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getBtnName() {
            return btnName;
        }

        public void setBtnName(String btnName) {
            this.btnName = btnName;
        }

        public String getBtnUrl() {
            return btnUrl;
        }

        public void setBtnUrl(String btnUrl) {
            this.btnUrl = btnUrl;
        }

        public Integer getBtnType() {
            return btnType;
        }

        public void setBtnType(Integer btnType) {
            this.btnType = btnType;
        }

        public Long getMsgWindowId() {
            return msgWindowId;
        }

        public void setMsgWindowId(Long msgWindowId) {
            this.msgWindowId = msgWindowId;
        }

        public Long getZdServeId() {
            return zdServeId;
        }

        public void setZdServeId(Long zdServeId) {
            this.zdServeId = zdServeId;
        }

        public Long getTemplateId() {
            return templateId;
        }

        public void setTemplateId(Long templateId) {
            this.templateId = templateId;
        }

        public String getZdServeUrl() {
            return zdServeUrl;
        }

        public void setZdServeUrl(String zdServeUrl) {
            this.zdServeUrl = zdServeUrl;
        }

        public Integer getRank() {
            return rank;
        }

        public void setRank(Integer rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Button{" +
                    "id=" + id +
                    ", btnName='" + btnName + '\'' +
                    ", btnUrl='" + btnUrl + '\'' +
                    ", btnType=" + btnType +
                    ", msgWindowId=" + msgWindowId +
                    ", zdServeId=" + zdServeId +
                    ", templateId=" + templateId +
                    ", zdServeUrl='" + zdServeUrl + '\'' +
                    ", rank=" + rank +
                    '}';
        }
    }

    public static class Material {
        public Material() {
        }

        public Material(Long id, String fileUrl, String materialName, Integer fileType, Integer imgType, String videoExplain, String videoCoverUrl, String extraLink) {
            this.id = id;
            this.fileUrl = fileUrl;
            this.materialName = materialName;
            this.fileType = fileType;
            this.imgType = imgType;
            this.videoExplain = videoExplain;
            this.videoCoverUrl = videoCoverUrl;
            this.extraLink = extraLink;
        }

        private Long id;

        private String fileUrl;//文件地址

        private String materialName;//素材名称

        private Integer fileType;//文件类型(1图片，2视频，3音频)

        private Integer imgType;//图片类型0单卡片,1多卡片,2封面

        private String videoExplain;//视频介绍

        private String videoCoverUrl;//视频封面

        private String extraLink;//素材外链

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public String getMaterialName() {
            return materialName;
        }

        public void setMaterialName(String materialName) {
            this.materialName = materialName;
        }

        public Integer getFileType() {
            return fileType;
        }

        public void setFileType(Integer fileType) {
            this.fileType = fileType;
        }

        public Integer getImgType() {
            return imgType;
        }

        public void setImgType(Integer imgType) {
            this.imgType = imgType;
        }

        public String getVideoExplain() {
            return videoExplain;
        }

        public void setVideoExplain(String videoExplain) {
            this.videoExplain = videoExplain;
        }

        public String getVideoCoverUrl() {
            return videoCoverUrl;
        }

        public void setVideoCoverUrl(String videoCoverUrl) {
            this.videoCoverUrl = videoCoverUrl;
        }

        public String getExtraLink() {
            return extraLink;
        }

        public void setExtraLink(String extraLink) {
            this.extraLink = extraLink;
        }

        @Override
        public String toString() {
            return "Material{" +
                    "id=" + id +
                    ", fileUrl='" + fileUrl + '\'' +
                    ", materialName='" + materialName + '\'' +
                    ", fileType=" + fileType +
                    ", imgType=" + imgType +
                    ", videoExplain='" + videoExplain + '\'' +
                    ", videoCoverUrl='" + videoCoverUrl + '\'' +
                    ", extraLink='" + extraLink + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RcsInfoBean{" +
                "rcs_id=" + rcs_id +
                ", id=" + id +
                ", modelName='" + modelName + '\'' +
                ", nav='" + nav + '\'' +
                ", pageTitle='" + pageTitle + '\'' +
                ", modelType=" + modelType +
                ", modelStyle=" + modelStyle +
                ", multipleCard=" + multipleCard +
                ", floatBtn=" + floatBtn +
                ", groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", chatbotCode='" + chatbotCode + '\'' +
                ", chatbotName='" + chatbotName + '\'' +
                ", chatbotLogo='" + chatbotLogo + '\'' +
                ", touchText='" + touchText + '\'' +
                ", templateId=" + templateId +
                ", templateName='" + templateName + '\'' +
                ", createTime=" + createTime +
                ", templateUpdateTime=" + templateUpdateTime +
                ", singleCardLayout=" + singleCardLayout +
                ", multiCardWidth=" + multiCardWidth +
                ", cssMessage='" + cssMessage + '\'' +
                ", cssMessageTitle='" + cssMessageTitle + '\'' +
                ", cssMessageDescription='" + cssMessageDescription + '\'' +
                ", cssMessageSuggestions='" + cssMessageSuggestions + '\'' +
                ", cssUrl='" + cssUrl + '\'' +
                '}';
    }
}
