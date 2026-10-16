package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;
import java.util.ArrayList;
import java.util.List;
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
public final class SharePhoto extends ShareMedia<SharePhoto, Builder> {
    private final Bitmap bitmap;
    private final String caption;
    private final Uri imageUrl;
    private final ShareMedia.Type mediaType;
    private final boolean userGenerated;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<SharePhoto> CREATOR = new Parcelable.Creator<SharePhoto>() { // from class: com.facebook.share.model.SharePhoto$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SharePhoto createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new SharePhoto(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SharePhoto[] newArray(int i3) {
            return new SharePhoto[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder extends ShareMedia.Builder<SharePhoto, Builder> {
        public static final Companion Companion = new Companion(null);
        private Bitmap bitmap;
        private String caption;
        private Uri imageUrl;
        private boolean userGenerated;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final List<SharePhoto> readPhotoListFrom$facebook_common_release(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                List<ShareMedia<?, ?>> listFrom$facebook_common_release = ShareMedia.Builder.Companion.readListFrom$facebook_common_release(parcel);
                ArrayList arrayList = new ArrayList();
                for (Object obj : listFrom$facebook_common_release) {
                    if (obj instanceof SharePhoto) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }

            public final void writePhotoListTo$facebook_common_release(Parcel out, int i3, List<SharePhoto> photos) {
                Intrinsics.checkNotNullParameter(out, "out");
                Intrinsics.checkNotNullParameter(photos, "photos");
                out.writeParcelableArray((SharePhoto[]) photos.toArray(new SharePhoto[0]), i3);
            }

            private Companion() {
            }
        }

        public final Bitmap getBitmap$facebook_common_release() {
            return this.bitmap;
        }

        public final String getCaption$facebook_common_release() {
            return this.caption;
        }

        public final Uri getImageUrl$facebook_common_release() {
            return this.imageUrl;
        }

        public final boolean getUserGenerated$facebook_common_release() {
            return this.userGenerated;
        }

        public final Builder readFrom$facebook_common_release(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return readFrom((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
        }

        public final Builder setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
            return this;
        }

        public final Builder setCaption(String str) {
            this.caption = str;
            return this;
        }

        public final Builder setImageUrl(Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        public final Builder setUserGenerated(boolean z2) {
            this.userGenerated = z2;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public SharePhoto build() {
            return new SharePhoto(this, null);
        }

        @Override // com.facebook.share.model.ShareMedia.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(SharePhoto sharePhoto) {
            return sharePhoto == null ? this : ((Builder) super.readFrom(sharePhoto)).setBitmap(sharePhoto.getBitmap()).setImageUrl(sharePhoto.getImageUrl()).setUserGenerated(sharePhoto.getUserGenerated()).setCaption(sharePhoto.getCaption());
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

    public /* synthetic */ SharePhoto(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final String getCaption() {
        return this.caption;
    }

    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    @Override // com.facebook.share.model.ShareMedia
    public ShareMedia.Type getMediaType() {
        return this.mediaType;
    }

    public final boolean getUserGenerated() {
        return this.userGenerated;
    }

    @Override // com.facebook.share.model.ShareMedia, android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i3);
        out.writeParcelable(this.bitmap, 0);
        out.writeParcelable(this.imageUrl, 0);
        out.writeByte(this.userGenerated ? (byte) 1 : (byte) 0);
        out.writeString(this.caption);
    }

    private SharePhoto(Builder builder) {
        super(builder);
        this.mediaType = ShareMedia.Type.PHOTO;
        this.bitmap = builder.getBitmap$facebook_common_release();
        this.imageUrl = builder.getImageUrl$facebook_common_release();
        this.userGenerated = builder.getUserGenerated$facebook_common_release();
        this.caption = builder.getCaption$facebook_common_release();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePhoto(Parcel parcel) {
        super(parcel);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.mediaType = ShareMedia.Type.PHOTO;
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.userGenerated = parcel.readByte() != 0;
        this.caption = parcel.readString();
    }
}
