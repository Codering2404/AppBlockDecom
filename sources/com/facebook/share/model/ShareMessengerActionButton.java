package com.facebook.share.model;

import android.os.Parcel;
import kotlin.Metadata;
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
public abstract class ShareMessengerActionButton implements ShareModel {
    private final String title;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {
        private String title;

        public final String getTitle$facebook_common_release() {
            return this.title;
        }

        public final B setTitle(String str) {
            this.title = str;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareMessengerActionButton.Builder");
            return this;
        }

        public final void setTitle$facebook_common_release(String str) {
            this.title = str;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public B readFrom(M m3) {
            if (m3 != null) {
                return (B) setTitle(m3.getTitle());
            }
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareMessengerActionButton.Builder");
            return this;
        }
    }

    protected ShareMessengerActionButton(Builder<?, ?> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.title = builder.getTitle$facebook_common_release();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.title);
    }

    public ShareMessengerActionButton(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.title = parcel.readString();
    }
}
