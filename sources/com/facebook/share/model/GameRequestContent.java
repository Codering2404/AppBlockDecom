package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class GameRequestContent implements ShareModel {
    private final ActionType actionType;
    private final String cta;
    private final String data;
    private final Filters filters;
    private final String message;
    private final String objectId;
    private final List<String> recipients;
    private final List<String> suggestions;
    private final String title;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<GameRequestContent> CREATOR = new Parcelable.Creator<GameRequestContent>() { // from class: com.facebook.share.model.GameRequestContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameRequestContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GameRequestContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameRequestContent[] newArray(int i3) {
            return new GameRequestContent[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum ActionType {
        SEND,
        ASKFOR,
        TURN,
        INVITE
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder implements ShareModelBuilder<GameRequestContent, Builder> {
        private ActionType actionType;
        private String cta;
        private String data;
        private Filters filters;
        private String message;
        private String objectId;
        private List<String> recipients;
        private List<String> suggestions;
        private String title;

        public final ActionType getActionType$facebook_common_release() {
            return this.actionType;
        }

        public final String getCta$facebook_common_release() {
            return this.cta;
        }

        public final String getData$facebook_common_release() {
            return this.data;
        }

        public final Filters getFilters$facebook_common_release() {
            return this.filters;
        }

        public final String getMessage$facebook_common_release() {
            return this.message;
        }

        public final String getObjectId$facebook_common_release() {
            return this.objectId;
        }

        public final List<String> getRecipients$facebook_common_release() {
            return this.recipients;
        }

        public final List<String> getSuggestions$facebook_common_release() {
            return this.suggestions;
        }

        public final String getTitle$facebook_common_release() {
            return this.title;
        }

        public final Builder readFrom$facebook_common_release(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((GameRequestContent) parcel.readParcelable(GameRequestContent.class.getClassLoader()));
        }

        public final Builder setActionType(ActionType actionType) {
            this.actionType = actionType;
            return this;
        }

        public final void setActionType$facebook_common_release(ActionType actionType) {
            this.actionType = actionType;
        }

        public final Builder setCta(String str) {
            this.cta = str;
            return this;
        }

        public final void setCta$facebook_common_release(String str) {
            this.cta = str;
        }

        public final Builder setData(String str) {
            this.data = str;
            return this;
        }

        public final void setData$facebook_common_release(String str) {
            this.data = str;
        }

        public final Builder setFilters(Filters filters) {
            this.filters = filters;
            return this;
        }

        public final void setFilters$facebook_common_release(Filters filters) {
            this.filters = filters;
        }

        public final Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        public final void setMessage$facebook_common_release(String str) {
            this.message = str;
        }

        public final Builder setObjectId(String str) {
            this.objectId = str;
            return this;
        }

        public final void setObjectId$facebook_common_release(String str) {
            this.objectId = str;
        }

        public final Builder setRecipients(List<String> list) {
            this.recipients = list;
            return this;
        }

        public final void setRecipients$facebook_common_release(List<String> list) {
            this.recipients = list;
        }

        public final Builder setSuggestions(List<String> list) {
            this.suggestions = list;
            return this;
        }

        public final void setSuggestions$facebook_common_release(List<String> list) {
            this.suggestions = list;
        }

        public final Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public final void setTitle$facebook_common_release(String str) {
            this.title = str;
        }

        @Deprecated
        public final Builder setTo(String str) {
            if (str != null) {
                this.recipients = CollectionsKt.toList(StringsKt.U0(str, new char[]{','}, false, 0, 6, null));
            }
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public GameRequestContent build() {
            return new GameRequestContent(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(GameRequestContent gameRequestContent) {
            return gameRequestContent == null ? this : setMessage(gameRequestContent.getMessage()).setCta(gameRequestContent.getCta()).setRecipients(gameRequestContent.getRecipients()).setTitle(gameRequestContent.getTitle()).setData(gameRequestContent.getData()).setActionType(gameRequestContent.getActionType()).setObjectId(gameRequestContent.getObjectId()).setFilters(gameRequestContent.getFilters()).setSuggestions(gameRequestContent.getSuggestions());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Filters {
        APP_USERS,
        APP_NON_USERS,
        EVERYBODY
    }

    public /* synthetic */ GameRequestContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final ActionType getActionType() {
        return this.actionType;
    }

    public final String getCta() {
        return this.cta;
    }

    public final String getData() {
        return this.data;
    }

    public final Filters getFilters() {
        return this.filters;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final List<String> getRecipients() {
        return this.recipients;
    }

    public final List<String> getSuggestions() {
        return this.suggestions;
    }

    public final String getTitle() {
        return this.title;
    }

    @Deprecated
    public final String getTo() {
        List<String> list = this.recipients;
        if (list != null) {
            return TextUtils.join(",", list);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.message);
        out.writeString(this.cta);
        out.writeStringList(this.recipients);
        out.writeString(this.title);
        out.writeString(this.data);
        out.writeSerializable(this.actionType);
        out.writeString(this.objectId);
        out.writeSerializable(this.filters);
        out.writeStringList(this.suggestions);
    }

    private GameRequestContent(Builder builder) {
        this.message = builder.getMessage$facebook_common_release();
        this.cta = builder.getCta$facebook_common_release();
        this.recipients = builder.getRecipients$facebook_common_release();
        this.title = builder.getTitle$facebook_common_release();
        this.data = builder.getData$facebook_common_release();
        this.actionType = builder.getActionType$facebook_common_release();
        this.objectId = builder.getObjectId$facebook_common_release();
        this.filters = builder.getFilters$facebook_common_release();
        this.suggestions = builder.getSuggestions$facebook_common_release();
    }

    public GameRequestContent(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.message = parcel.readString();
        this.cta = parcel.readString();
        this.recipients = parcel.createStringArrayList();
        this.title = parcel.readString();
        this.data = parcel.readString();
        this.actionType = (ActionType) parcel.readSerializable();
        this.objectId = parcel.readString();
        this.filters = (Filters) parcel.readSerializable();
        this.suggestions = parcel.createStringArrayList();
    }
}
