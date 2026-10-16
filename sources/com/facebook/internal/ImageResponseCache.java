package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.Logger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
public final class ImageResponseCache {
    public static final ImageResponseCache INSTANCE = new ImageResponseCache();
    private static final String TAG = ImageResponseCache.class.getSimpleName();
    private static FileLruCache imageCache;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class BufferedHttpInputStream extends BufferedInputStream {
        private HttpURLConnection connection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BufferedHttpInputStream(InputStream inputStream, HttpURLConnection connection) {
            super(inputStream, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            Intrinsics.checkNotNullParameter(connection, "connection");
            this.connection = connection;
        }

        @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            Utility.disconnectQuietly(this.connection);
        }

        public final HttpURLConnection getConnection() {
            return this.connection;
        }

        public final void setConnection(HttpURLConnection httpURLConnection) {
            Intrinsics.checkNotNullParameter(httpURLConnection, "<set-?>");
            this.connection = httpURLConnection;
        }
    }

    private ImageResponseCache() {
    }

    @JvmStatic
    public static final void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e3) {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            companion.log(loggingBehavior, 5, TAG2, "clearCache failed " + e3.getMessage());
        }
    }

    @JvmStatic
    public static final synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        try {
            if (imageCache == null) {
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                imageCache = new FileLruCache(TAG2, new FileLruCache.Limits());
            }
            fileLruCache = imageCache;
            if (fileLruCache == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageCache");
                fileLruCache = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return fileLruCache;
    }

    @JvmStatic
    public static final InputStream getCachedImageStream(Uri uri) {
        if (uri != null && INSTANCE.isCDNURL(uri)) {
            try {
                FileLruCache cache = getCache();
                String string = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
                return FileLruCache.get$default(cache, string, null, 2, null);
            } catch (IOException e3) {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion.log(loggingBehavior, 5, TAG2, e3.toString());
            }
        }
        return null;
    }

    @JvmStatic
    public static final InputStream interceptAndCacheImageStream(HttpURLConnection connection) throws IOException {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (connection.getResponseCode() != 200) {
            return null;
        }
        Uri uri = Uri.parse(connection.getURL().toString());
        InputStream inputStream = connection.getInputStream();
        try {
            if (INSTANCE.isCDNURL(uri)) {
                FileLruCache cache = getCache();
                String string = uri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
                return cache.interceptAndPut(string, new BufferedHttpInputStream(inputStream, connection));
            }
        } catch (IOException unused) {
        }
        return inputStream;
    }

    private final boolean isCDNURL(Uri uri) {
        String host;
        return (uri == null || (host = uri.getHost()) == null || (!Intrinsics.areEqual(host, "fbcdn.net") && !StringsKt.E(host, ".fbcdn.net", false, 2, null) && (!StringsKt.U(host, "fbcdn", false, 2, null) || !StringsKt.E(host, ".akamaihd.net", false, 2, null)))) ? false : true;
    }

    public final String getTAG() {
        return TAG;
    }
}
