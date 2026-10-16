package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMedia.Builder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
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
public abstract class ShareMedia<M extends ShareMedia<M, B>, B extends Builder<M, B>> implements ShareModel {
    private final Bundle params;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Builder<M extends ShareMedia<M, B>, B extends Builder<M, B>> implements ShareModelBuilder<M, B> {
        public static final Companion Companion = new Companion(null);
        private Bundle params = new Bundle();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final List<ShareMedia<?, ?>> readListFrom$facebook_common_release(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Parcelable[] parcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
                if (parcelableArray == null) {
                    return CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    if (parcelable instanceof ShareMedia) {
                        arrayList.add(parcelable);
                    }
                }
                return arrayList;
            }

            @JvmStatic
            public final void writeListTo$facebook_common_release(Parcel out, int i3, List<? extends ShareMedia<?, ?>> media) {
                Intrinsics.checkNotNullParameter(out, "out");
                Intrinsics.checkNotNullParameter(media, "media");
                out.writeParcelableArray((Parcelable[]) media.toArray(new ShareMedia[0]), i3);
            }

            private Companion() {
            }
        }

        public final Bundle getParams$facebook_common_release() {
            return this.params;
        }

        @Deprecated
        public final B setParameter(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.params.putString(key, value);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareMedia.Builder");
            return this;
        }

        @Deprecated
        public final B setParameters(Bundle parameters) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.params.putAll(parameters);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type B of com.facebook.share.model.ShareMedia.Builder");
            return this;
        }

        public final void setParams$facebook_common_release(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "<set-?>");
            this.params = bundle;
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public B readFrom(M m3) {
            if (m3 != null) {
                return (B) setParameters(((ShareMedia) m3).params);
            }
            Intrinsics.checkNotNull(this, muQRKXGtpOhe.VnukCnKjlLcIRKp);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Type {
        PHOTO,
        VIDEO
    }

    protected ShareMedia(Builder<M, B> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.params = new Bundle(builder.getParams$facebook_common_release());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract Type getMediaType();

    @Deprecated
    public final Bundle getParameters() {
        return new Bundle(this.params);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeBundle(this.params);
    }

    public ShareMedia(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Bundle bundle = parcel.readBundle(getClass().getClassLoader());
        this.params = bundle == null ? new Bundle() : bundle;
    }
}
