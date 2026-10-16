package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
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
public final class CameraEffectTextures implements ShareModel {
    private final Bundle textures;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<CameraEffectTextures> CREATOR = new Parcelable.Creator<CameraEffectTextures>() { // from class: com.facebook.share.model.CameraEffectTextures$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraEffectTextures createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CameraEffectTextures(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CameraEffectTextures[] newArray(int i3) {
            return new CameraEffectTextures[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder implements ShareModelBuilder<CameraEffectTextures, Builder> {
        private final Bundle textures = new Bundle();

        private final Builder putParcelableTexture(String str, Parcelable parcelable) {
            if (str.length() > 0 && parcelable != null) {
                this.textures.putParcelable(str, parcelable);
            }
            return this;
        }

        public final Bundle getTextures$facebook_common_release() {
            return this.textures;
        }

        public final Builder putTexture(String key, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(key, "key");
            return putParcelableTexture(key, bitmap);
        }

        @Override // com.facebook.share.ShareBuilder
        public CameraEffectTextures build() {
            return new CameraEffectTextures(this, null);
        }

        public final Builder putTexture(String key, Uri uri) {
            Intrinsics.checkNotNullParameter(key, "key");
            return putParcelableTexture(key, uri);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(CameraEffectTextures cameraEffectTextures) {
            if (cameraEffectTextures != null) {
                this.textures.putAll(cameraEffectTextures.textures);
            }
            return this;
        }

        public final Builder readFrom(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
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

    public /* synthetic */ CameraEffectTextures(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Object get(String str) {
        Bundle bundle = this.textures;
        if (bundle != null) {
            return bundle.get(str);
        }
        return null;
    }

    public final Bitmap getTextureBitmap(String str) {
        Bundle bundle = this.textures;
        Object obj = bundle != null ? bundle.get(str) : null;
        if (obj instanceof Bitmap) {
            return (Bitmap) obj;
        }
        return null;
    }

    public final Uri getTextureUri(String str) {
        Bundle bundle = this.textures;
        Object obj = bundle != null ? bundle.get(str) : null;
        if (obj instanceof Uri) {
            return (Uri) obj;
        }
        return null;
    }

    public final Set<String> keySet() {
        Bundle bundle = this.textures;
        Set<String> setKeySet = bundle != null ? bundle.keySet() : null;
        return setKeySet == null ? SetsKt.emptySet() : setKeySet;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeBundle(this.textures);
    }

    private CameraEffectTextures(Builder builder) {
        this.textures = builder.getTextures$facebook_common_release();
    }

    public CameraEffectTextures(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.textures = parcel.readBundle(CameraEffectTextures.class.getClassLoader());
    }
}
