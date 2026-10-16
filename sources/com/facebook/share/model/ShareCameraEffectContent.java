package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareContent;
import kotlin.Metadata;
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
public final class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Builder> {
    private CameraEffectArguments arguments;
    private String effectId;
    private CameraEffectTextures textures;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR = new Parcelable.Creator<ShareCameraEffectContent>() { // from class: com.facebook.share.model.ShareCameraEffectContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareCameraEffectContent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareCameraEffectContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareCameraEffectContent[] newArray(int i3) {
            return new ShareCameraEffectContent[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder extends ShareContent.Builder<ShareCameraEffectContent, Builder> {
        private CameraEffectArguments arguments;
        private String effectId;
        private CameraEffectTextures textures;

        public final CameraEffectArguments getArguments$facebook_common_release() {
            return this.arguments;
        }

        public final String getEffectId$facebook_common_release() {
            return this.effectId;
        }

        public final CameraEffectTextures getTextures$facebook_common_release() {
            return this.textures;
        }

        public final Builder setArguments(CameraEffectArguments cameraEffectArguments) {
            this.arguments = cameraEffectArguments;
            return this;
        }

        public final void setArguments$facebook_common_release(CameraEffectArguments cameraEffectArguments) {
            this.arguments = cameraEffectArguments;
        }

        public final Builder setEffectId(String str) {
            this.effectId = str;
            return this;
        }

        public final void setEffectId$facebook_common_release(String str) {
            this.effectId = str;
        }

        public final Builder setTextures(CameraEffectTextures cameraEffectTextures) {
            this.textures = cameraEffectTextures;
            return this;
        }

        public final void setTextures$facebook_common_release(CameraEffectTextures cameraEffectTextures) {
            this.textures = cameraEffectTextures;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareCameraEffectContent build() {
            return new ShareCameraEffectContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ShareCameraEffectContent shareCameraEffectContent) {
            return shareCameraEffectContent == null ? this : ((Builder) super.readFrom(shareCameraEffectContent)).setEffectId(shareCameraEffectContent.getEffectId()).setArguments(shareCameraEffectContent.getArguments()).setTextures(shareCameraEffectContent.getTextures());
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

    public /* synthetic */ ShareCameraEffectContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public final CameraEffectArguments getArguments() {
        return this.arguments;
    }

    public final String getEffectId() {
        return this.effectId;
    }

    public final CameraEffectTextures getTextures() {
        return this.textures;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i3);
        out.writeString(this.effectId);
        out.writeParcelable(this.arguments, 0);
        out.writeParcelable(this.textures, 0);
    }

    private ShareCameraEffectContent(Builder builder) {
        super(builder);
        this.effectId = builder.getEffectId$facebook_common_release();
        this.arguments = builder.getArguments$facebook_common_release();
        this.textures = builder.getTextures$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareCameraEffectContent(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.effectId = parcel.readString();
        this.arguments = new CameraEffectArguments.Builder().readFrom(parcel).build();
        this.textures = new CameraEffectTextures.Builder().readFrom(parcel).build();
    }
}
