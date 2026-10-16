package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
import java.util.ArrayList;
import java.util.Iterator;
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
public final class ShareMediaContent extends ShareContent<ShareMediaContent, Builder> {
    private final List<ShareMedia<?, ?>> media;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ShareMediaContent> CREATOR = new Parcelable.Creator<ShareMediaContent>() { // from class: com.facebook.share.model.ShareMediaContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareMediaContent createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new ShareMediaContent(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ShareMediaContent[] newArray(int i3) {
            return new ShareMediaContent[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder extends ShareContent.Builder<ShareMediaContent, Builder> {
        private final List<ShareMedia<?, ?>> media = new ArrayList();

        public final Builder addMedia(List<? extends ShareMedia<?, ?>> list) {
            if (list != null) {
                Iterator<? extends ShareMedia<?, ?>> it = list.iterator();
                while (it.hasNext()) {
                    addMedium(it.next());
                }
            }
            return this;
        }

        public final Builder addMedium(ShareMedia<?, ?> shareMedia) {
            ShareMedia<?, ?> shareMediaBuild;
            if (shareMedia == null) {
                return this;
            }
            if (shareMedia instanceof SharePhoto) {
                shareMediaBuild = new SharePhoto.Builder().readFrom((SharePhoto) shareMedia).build();
            } else {
                if (!(shareMedia instanceof ShareVideo)) {
                    throw new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
                }
                shareMediaBuild = new ShareVideo.Builder().readFrom((ShareVideo) shareMedia).build();
            }
            this.media.add(shareMediaBuild);
            return this;
        }

        public final List<ShareMedia<?, ?>> getMedia$facebook_common_release() {
            return this.media;
        }

        public final Builder setMedia(List<? extends ShareMedia<?, ?>> list) {
            this.media.clear();
            addMedia(list);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMediaContent build() {
            return new ShareMediaContent(this, null);
        }

        @Override // com.facebook.share.model.ShareContent.Builder, com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(ShareMediaContent shareMediaContent) {
            return shareMediaContent == null ? this : ((Builder) super.readFrom(shareMediaContent)).addMedia(shareMediaContent.getMedia());
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

    public /* synthetic */ ShareMediaContent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final List<ShareMedia<?, ?>> getMedia() {
        return this.media;
    }

    @Override // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i3);
        out.writeParcelableArray((Parcelable[]) this.media.toArray(new ShareMedia[0]), i3);
    }

    private ShareMediaContent(Builder builder) {
        super(builder);
        this.media = CollectionsKt.toList(builder.getMedia$facebook_common_release());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareMediaContent(Parcel source) {
        List<ShareMedia<?, ?>> listEmptyList;
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        Parcelable[] parcelableArray = source.readParcelableArray(ShareMedia.class.getClassLoader());
        if (parcelableArray != null) {
            listEmptyList = new ArrayList<>();
            for (Parcelable parcelable : parcelableArray) {
                ShareMedia<?, ?> shareMedia = (ShareMedia) parcelable;
                if (shareMedia != null) {
                    listEmptyList.add(shareMedia);
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        this.media = listEmptyList;
    }
}
