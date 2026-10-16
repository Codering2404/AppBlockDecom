package com.facebook.messenger;

import android.net.Uri;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.applovin.sdk.AppLovinEventTypes;
import java.util.HashSet;
import java.util.Set;
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
public final class ShareToMessengerParams {
    public static final Companion Companion = new Companion(null);
    private static final Set<String> VALID_EXTERNAL_URI_SCHEMES;
    private static final Set<String> VALID_MIME_TYPES;
    private static final Set<String> VALID_URI_SCHEMES;
    private final Uri externalUri;
    private final String metaData;
    private final String mimeType;
    private final Uri uri;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<String> getVALID_EXTERNAL_URI_SCHEMES() {
            return ShareToMessengerParams.VALID_EXTERNAL_URI_SCHEMES;
        }

        public final Set<String> getVALID_MIME_TYPES() {
            return ShareToMessengerParams.VALID_MIME_TYPES;
        }

        public final Set<String> getVALID_URI_SCHEMES() {
            return ShareToMessengerParams.VALID_URI_SCHEMES;
        }

        @JvmStatic
        public final ShareToMessengerParamsBuilder newBuilder(Uri uri, String mimeType) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            return new ShareToMessengerParamsBuilder(uri, mimeType);
        }

        private Companion() {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("image/*");
        hashSet.add("image/jpeg");
        hashSet.add("image/png");
        hashSet.add("image/gif");
        hashSet.add("image/webp");
        hashSet.add("video/*");
        hashSet.add("video/mp4");
        hashSet.add("audio/*");
        hashSet.add("audio/mpeg");
        VALID_MIME_TYPES = CollectionsKt.toSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(AppLovinEventTypes.USER_VIEWED_CONTENT);
        hashSet2.add("android.resource");
        hashSet2.add("file");
        VALID_URI_SCHEMES = CollectionsKt.toSet(hashSet2);
        HashSet hashSet3 = new HashSet();
        hashSet3.add("http");
        hashSet3.add("https");
        VALID_EXTERNAL_URI_SCHEMES = CollectionsKt.toSet(hashSet3);
    }

    @JvmStatic
    public static final ShareToMessengerParamsBuilder newBuilder(Uri uri, String str) {
        return Companion.newBuilder(uri, str);
    }

    public final Uri getExternalUri() {
        return this.externalUri;
    }

    public final String getMetaData() {
        return this.metaData;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public ShareToMessengerParams(ShareToMessengerParamsBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Uri uri = builder.getUri();
        if (uri == null) {
            throw new IllegalStateException(jTYhJgqLBN.qTmkLook);
        }
        this.uri = uri;
        String mimeType = builder.getMimeType();
        if (mimeType == null) {
            throw new IllegalStateException("Must provide mimeType");
        }
        this.mimeType = mimeType;
        this.metaData = builder.getMetaData();
        Uri externalUri = builder.getExternalUri();
        this.externalUri = externalUri;
        if (!CollectionsKt.contains(VALID_URI_SCHEMES, uri.getScheme())) {
            throw new IllegalArgumentException(("Unsupported URI scheme: " + uri.getScheme()).toString());
        }
        if (!VALID_MIME_TYPES.contains(mimeType)) {
            throw new IllegalArgumentException(("Unsupported mime-type: " + mimeType).toString());
        }
        if (externalUri == null || CollectionsKt.contains(VALID_EXTERNAL_URI_SCHEMES, externalUri.getScheme())) {
            return;
        }
        throw new IllegalArgumentException(("Unsupported external uri scheme: " + externalUri.getScheme()).toString());
    }
}
