
package com.example.test.samplemasterdetail.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Result implements Parcelable {

    @SerializedName("DefinitionSource")
    @Expose
    private String DefinitionSource;
    @SerializedName("Heading")
    @Expose
    private String Heading;
    @SerializedName("ImageWidth")
    @Expose
    private Integer ImageWidth;
    @SerializedName("RelatedTopics")
    @Expose
    private List<RelatedTopic> RelatedTopics = new ArrayList<RelatedTopic>();
    @SerializedName("Entity")
    @Expose
    private String Entity;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("Type")
    @Expose
    private String Type;
    @SerializedName("Redirect")
    @Expose
    private String Redirect;
    @SerializedName("DefinitionURL")
    @Expose
    private String DefinitionURL;
    @SerializedName("AbstractURL")
    @Expose
    private String AbstractURL;
    @SerializedName("Definition")
    @Expose
    private String Definition;
    @SerializedName("AbstractSource")
    @Expose
    private String AbstractSource;
    @SerializedName("Infobox")
    @Expose
    private String Infobox;
    @SerializedName("Image")
    @Expose
    private String Image;
    @SerializedName("ImageIsLogo")
    @Expose
    private Integer ImageIsLogo;
    @SerializedName("Abstract")
    @Expose
    private String Abstract;
    @SerializedName("AbstractText")
    @Expose
    private String AbstractText;
    @SerializedName("AnswerType")
    @Expose
    private String AnswerType;
    @SerializedName("ImageHeight")
    @Expose
    private Integer ImageHeight;
    @SerializedName("Answer")
    @Expose
    private String Answer;
    @SerializedName("Results")
    @Expose
    private List<Object> Results = new ArrayList<Object>();

    /**
     *
     * @return
     *     The DefinitionSource
     */
    public String getDefinitionSource() {
        return DefinitionSource;
    }

    /**
     *
     * @param DefinitionSource
     *     The DefinitionSource
     */
    public void setDefinitionSource(String DefinitionSource) {
        this.DefinitionSource = DefinitionSource;
    }

    /**
     *
     * @return
     *     The Heading
     */
    public String getHeading() {
        return Heading;
    }

    /**
     *
     * @param Heading
     *     The Heading
     */
    public void setHeading(String Heading) {
        this.Heading = Heading;
    }

    /**
     *
     * @return
     *     The ImageWidth
     */
    public Integer getImageWidth() {
        return ImageWidth;
    }

    /**
     *
     * @param ImageWidth
     *     The ImageWidth
     */
    public void setImageWidth(Integer ImageWidth) {
        this.ImageWidth = ImageWidth;
    }

    /**
     *
     * @return
     *     The RelatedTopics
     */
    public List<RelatedTopic> getRelatedTopics() {
        return RelatedTopics;
    }

    /**
     *
     * @param RelatedTopics
     *     The RelatedTopics
     */
    public void setRelatedTopics(List<RelatedTopic> RelatedTopics) {
        this.RelatedTopics = RelatedTopics;
    }

    /**
     *
     * @return
     *     The Entity
     */
    public String getEntity() {
        return Entity;
    }

    /**
     *
     * @param Entity
     *     The Entity
     */
    public void setEntity(String Entity) {
        this.Entity = Entity;
    }

    /**
     *
     * @return
     *     The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     *
     * @param meta
     *     The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     *
     * @return
     *     The Type
     */
    public String getType() {
        return Type;
    }

    /**
     *
     * @param Type
     *     The Type
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     *
     * @return
     *     The Redirect
     */
    public String getRedirect() {
        return Redirect;
    }

    /**
     *
     * @param Redirect
     *     The Redirect
     */
    public void setRedirect(String Redirect) {
        this.Redirect = Redirect;
    }

    /**
     *
     * @return
     *     The DefinitionURL
     */
    public String getDefinitionURL() {
        return DefinitionURL;
    }

    /**
     *
     * @param DefinitionURL
     *     The DefinitionURL
     */
    public void setDefinitionURL(String DefinitionURL) {
        this.DefinitionURL = DefinitionURL;
    }

    /**
     *
     * @return
     *     The AbstractURL
     */
    public String getAbstractURL() {
        return AbstractURL;
    }

    /**
     *
     * @param AbstractURL
     *     The AbstractURL
     */
    public void setAbstractURL(String AbstractURL) {
        this.AbstractURL = AbstractURL;
    }

    /**
     *
     * @return
     *     The Definition
     */
    public String getDefinition() {
        return Definition;
    }

    /**
     *
     * @param Definition
     *     The Definition
     */
    public void setDefinition(String Definition) {
        this.Definition = Definition;
    }

    /**
     *
     * @return
     *     The AbstractSource
     */
    public String getAbstractSource() {
        return AbstractSource;
    }

    /**
     *
     * @param AbstractSource
     *     The AbstractSource
     */
    public void setAbstractSource(String AbstractSource) {
        this.AbstractSource = AbstractSource;
    }

    /**
     *
     * @return
     *     The Infobox
     */
    public String getInfobox() {
        return Infobox;
    }

    /**
     *
     * @param Infobox
     *     The Infobox
     */
    public void setInfobox(String Infobox) {
        this.Infobox = Infobox;
    }

    /**
     *
     * @return
     *     The Image
     */
    public String getImage() {
        return Image;
    }

    /**
     *
     * @param Image
     *     The Image
     */
    public void setImage(String Image) {
        this.Image = Image;
    }

    /**
     *
     * @return
     *     The ImageIsLogo
     */
    public Integer getImageIsLogo() {
        return ImageIsLogo;
    }

    /**
     *
     * @param ImageIsLogo
     *     The ImageIsLogo
     */
    public void setImageIsLogo(Integer ImageIsLogo) {
        this.ImageIsLogo = ImageIsLogo;
    }

    /**
     *
     * @return
     *     The Abstract
     */
    public String getAbstract() {
        return Abstract;
    }

    /**
     *
     * @param Abstract
     *     The Abstract
     */
    public void setAbstract(String Abstract) {
        this.Abstract = Abstract;
    }

    /**
     *
     * @return
     *     The AbstractText
     */
    public String getAbstractText() {
        return AbstractText;
    }

    /**
     *
     * @param AbstractText
     *     The AbstractText
     */
    public void setAbstractText(String AbstractText) {
        this.AbstractText = AbstractText;
    }

    /**
     *
     * @return
     *     The AnswerType
     */
    public String getAnswerType() {
        return AnswerType;
    }

    /**
     *
     * @param AnswerType
     *     The AnswerType
     */
    public void setAnswerType(String AnswerType) {
        this.AnswerType = AnswerType;
    }

    /**
     *
     * @return
     *     The ImageHeight
     */
    public Integer getImageHeight() {
        return ImageHeight;
    }

    /**
     *
     * @param ImageHeight
     *     The ImageHeight
     */
    public void setImageHeight(Integer ImageHeight) {
        this.ImageHeight = ImageHeight;
    }

    /**
     *
     * @return
     *     The Answer
     */
    public String getAnswer() {
        return Answer;
    }

    /**
     *
     * @param Answer
     *     The Answer
     */
    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    /**
     *
     * @return
     *     The Results
     */
    public List<Object> getResults() {
        return Results;
    }

    /**
     *
     * @param Results
     *     The Results
     */
    public void setResults(List<Object> Results) {
        this.Results = Results;
    }


    protected Result(Parcel in) {
        DefinitionSource = in.readString();
        Heading = in.readString();
        ImageWidth = in.readByte() == 0x00 ? null : in.readInt();
        if (in.readByte() == 0x01) {
            RelatedTopics = new ArrayList<RelatedTopic>();
            in.readList(RelatedTopics, RelatedTopic.class.getClassLoader());
        } else {
            RelatedTopics = null;
        }
        Entity = in.readString();
        meta = (Meta) in.readValue(Meta.class.getClassLoader());
        Type = in.readString();
        Redirect = in.readString();
        DefinitionURL = in.readString();
        AbstractURL = in.readString();
        Definition = in.readString();
        AbstractSource = in.readString();
        Infobox = in.readString();
        Image = in.readString();
        ImageIsLogo = in.readByte() == 0x00 ? null : in.readInt();
        Abstract = in.readString();
        AbstractText = in.readString();
        AnswerType = in.readString();
        ImageHeight = in.readByte() == 0x00 ? null : in.readInt();
        Answer = in.readString();
        if (in.readByte() == 0x01) {
            Results = new ArrayList<Object>();
            in.readList(Results, Object.class.getClassLoader());
        } else {
            Results = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(DefinitionSource);
        dest.writeString(Heading);
        if (ImageWidth == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(ImageWidth);
        }
        if (RelatedTopics == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(RelatedTopics);
        }
        dest.writeString(Entity);
        dest.writeValue(meta);
        dest.writeString(Type);
        dest.writeString(Redirect);
        dest.writeString(DefinitionURL);
        dest.writeString(AbstractURL);
        dest.writeString(Definition);
        dest.writeString(AbstractSource);
        dest.writeString(Infobox);
        dest.writeString(Image);
        if (ImageIsLogo == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(ImageIsLogo);
        }
        dest.writeString(Abstract);
        dest.writeString(AbstractText);
        dest.writeString(AnswerType);
        if (ImageHeight == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(ImageHeight);
        }
        dest.writeString(Answer);
        if (Results == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(Results);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
}