package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class ShareStoryContent extends ShareContent<ShareStoryContent, Builder> {
    private final String attributionLink;
    private final ShareMedia<?, ?> backgroundAsset;
    private final List<String> backgroundColorList;
    private final SharePhoto stickerAsset;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ShareStoryContent> CREATOR = new Parcelable.Creator<ShareStoryContent>() { // from class: com.facebook.share.model.ShareStoryContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareStoryContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareStoryContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareStoryContent[] newArray(int i3) {
            return new ShareStoryContent[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder extends ShareContent.Builder<ShareStoryContent, Builder> {
        private String attributionLink;
        private ShareMedia<?, ?> backgroundAsset;
        private List<String> backgroundColorList;
        private SharePhoto stickerAsset;

        public final String getAttributionLink$facebook_common_release() {
            return this.attributionLink;
        }

        public final ShareMedia<?, ?> getBackgroundAsset$facebook_common_release() {
            return this.backgroundAsset;
        }

        public final List<String> getBackgroundColorList$facebook_common_release() {
            return this.backgroundColorList;
        }

        public final SharePhoto getStickerAsset$facebook_common_release() {
            return this.stickerAsset;
        }

        public final Builder setAttributionLink(String str) {
            this.attributionLink = str;
            return this;
        }

        public final void setAttributionLink$facebook_common_release(String str) {
            this.attributionLink = str;
        }

        public final Builder setBackgroundAsset(ShareMedia<?, ?> shareMedia) {
            this.backgroundAsset = shareMedia;
            return this;
        }

        public final void setBackgroundAsset$facebook_common_release(ShareMedia<?, ?> shareMedia) {
            this.backgroundAsset = shareMedia;
        }

        public final Builder setBackgroundColorList(List<String> list) {
            this.backgroundColorList = list != null ? CollectionsKt.toList(list) : null;
            return this;
        }

        public final void setBackgroundColorList$facebook_common_release(List<String> list) {
            this.backgroundColorList = list;
        }

        public final Builder setStickerAsset(SharePhoto sharePhoto) {
            this.stickerAsset = sharePhoto;
            return this;
        }

        public final void setStickerAsset$facebook_common_release(SharePhoto sharePhoto) {
            this.stickerAsset = sharePhoto;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareStoryContent build() {
            return new ShareStoryContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ShareStoryContent shareStoryContent) {
            return shareStoryContent == null ? this : ((Builder) super.readFrom(shareStoryContent)).setBackgroundAsset(shareStoryContent.getBackgroundAsset()).setStickerAsset(shareStoryContent.getStickerAsset()).setBackgroundColorList(shareStoryContent.getBackgroundColorList()).setAttributionLink(shareStoryContent.getAttributionLink());
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

    public /* synthetic */ ShareStoryContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private final List<String> readUnmodifiableStringList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return CollectionsKt.toList(arrayList);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getAttributionLink() {
        return this.attributionLink;
    }

    public final ShareMedia<?, ?> getBackgroundAsset() {
        return this.backgroundAsset;
    }

    public final List<String> getBackgroundColorList() {
        List<String> list = this.backgroundColorList;
        if (list != null) {
            return CollectionsKt.toList(list);
        }
        return null;
    }

    public final SharePhoto getStickerAsset() {
        return this.stickerAsset;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i3);
        out.writeParcelable(this.backgroundAsset, 0);
        out.writeParcelable(this.stickerAsset, 0);
        out.writeStringList(getBackgroundColorList());
        out.writeString(this.attributionLink);
    }

    private ShareStoryContent(Builder builder) {
        super(builder);
        this.backgroundAsset = builder.getBackgroundAsset$facebook_common_release();
        this.stickerAsset = builder.getStickerAsset$facebook_common_release();
        this.backgroundColorList = builder.getBackgroundColorList$facebook_common_release();
        this.attributionLink = builder.getAttributionLink$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareStoryContent(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.backgroundAsset = (ShareMedia) parcel.readParcelable(ShareMedia.class.getClassLoader());
        this.stickerAsset = (SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader());
        this.backgroundColorList = readUnmodifiableStringList(parcel);
        this.attributionLink = parcel.readString();
    }
}
