package com.facebook.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.WorkQueue;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static Handler handler;
    public static final ImageDownloader INSTANCE = new ImageDownloader();
    private static final WorkQueue downloadQueue = new WorkQueue(8, null, 2, null);
    private static final WorkQueue cacheReadQueue = new WorkQueue(2, null, 2, null);
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class CacheReadWorkItem implements Runnable {
        private final boolean allowCachedRedirects;
        private final RequestKey key;

        public CacheReadWorkItem(RequestKey key, boolean z2) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.allowCachedRedirects = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                ImageDownloader.INSTANCE.readFromCache(this.key, this.allowCachedRedirects);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class DownloadImageWorkItem implements Runnable {
        private final RequestKey key;

        public DownloadImageWorkItem(RequestKey key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                ImageDownloader.INSTANCE.download(this.key);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DownloaderContext {
        private boolean isCancelled;
        private ImageRequest request;
        private WorkQueue.WorkItem workItem;

        public DownloaderContext(ImageRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
        }

        public final ImageRequest getRequest() {
            return this.request;
        }

        public final WorkQueue.WorkItem getWorkItem() {
            return this.workItem;
        }

        public final boolean isCancelled() {
            return this.isCancelled;
        }

        public final void setCancelled(boolean z2) {
            this.isCancelled = z2;
        }

        public final void setRequest(ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(imageRequest, "<set-?>");
            this.request = imageRequest;
        }

        public final void setWorkItem(WorkQueue.WorkItem workItem) {
            this.workItem = workItem;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestKey {
        public static final Companion Companion = new Companion(null);
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        private Object tag;
        private Uri uri;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public RequestKey(Uri uri, Object tag) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.uri = uri;
            this.tag = tag;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof RequestKey)) {
                RequestKey requestKey = (RequestKey) obj;
                if (Intrinsics.areEqual(requestKey.uri, this.uri) && Intrinsics.areEqual(requestKey.tag, this.tag)) {
                    return true;
                }
            }
            return false;
        }

        public final Object getTag() {
            return this.tag;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return ((1073 + this.uri.hashCode()) * 37) + this.tag.hashCode();
        }

        public final void setTag(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<set-?>");
            this.tag = obj;
        }

        public final void setUri(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "<set-?>");
            this.uri = uri;
        }
    }

    private ImageDownloader() {
    }

    @JvmStatic
    public static final boolean cancelRequest(ImageRequest request) {
        boolean z2;
        Intrinsics.checkNotNullParameter(request, "request");
        RequestKey requestKey = new RequestKey(request.getImageUri(), request.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            try {
                DownloaderContext downloaderContext = map.get(requestKey);
                if (downloaderContext != null) {
                    WorkQueue.WorkItem workItem = downloaderContext.getWorkItem();
                    z2 = true;
                    if (workItem == null || !workItem.cancel()) {
                        downloaderContext.setCancelled(true);
                    } else {
                        map.remove(requestKey);
                    }
                } else {
                    z2 = false;
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    @JvmStatic
    public static final void clearCache() {
        ImageResponseCache.clearCache();
        UrlRedirectCache.clearCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void download(com.facebook.internal.ImageDownloader.RequestKey r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.download(com.facebook.internal.ImageDownloader$RequestKey):void");
    }

    @JvmStatic
    public static final void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return;
        }
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            try {
                DownloaderContext downloaderContext = map.get(requestKey);
                if (downloaderContext != null) {
                    downloaderContext.setRequest(imageRequest);
                    downloaderContext.setCancelled(false);
                    WorkQueue.WorkItem workItem = downloaderContext.getWorkItem();
                    if (workItem != null) {
                        workItem.moveToFront();
                        Unit unit = Unit.f139807a;
                    }
                } else {
                    INSTANCE.enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
                    Unit unit2 = Unit.f139807a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z2) {
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(requestKey, z2));
    }

    private final void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(requestKey));
    }

    private final void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = new DownloaderContext(imageRequest);
            map.put(requestKey, downloaderContext);
            downloaderContext.setWorkItem(WorkQueue.addActiveWorkItem$default(workQueue, runnable, false, 2, null));
            Unit unit = Unit.f139807a;
        }
    }

    private final synchronized Handler getHandler() {
        try {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
        } catch (Throwable th) {
            throw th;
        }
        return handler;
    }

    private final void issueResponse(RequestKey requestKey, final Exception exc, final Bitmap bitmap, final boolean z2) {
        Handler handler2;
        DownloaderContext downloaderContextRemovePendingRequest = removePendingRequest(requestKey);
        if (downloaderContextRemovePendingRequest == null || downloaderContextRemovePendingRequest.isCancelled()) {
            return;
        }
        final ImageRequest request = downloaderContextRemovePendingRequest.getRequest();
        final ImageRequest.Callback callback = request != null ? request.getCallback() : null;
        if (callback == null || (handler2 = getHandler()) == null) {
            return;
        }
        handler2.post(new Runnable() { // from class: com.facebook.internal.n
            @Override // java.lang.Runnable
            public final void run() {
                ImageDownloader.issueResponse$lambda$4(request, exc, z2, bitmap, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void issueResponse$lambda$4(ImageRequest request, Exception exc, boolean z2, Bitmap bitmap, ImageRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(request, "$request");
        callback.onCompleted(new ImageResponse(request, exc, z2, bitmap));
    }

    @JvmStatic
    public static final void prioritizeRequest(ImageRequest request) {
        WorkQueue.WorkItem workItem;
        Intrinsics.checkNotNullParameter(request, "request");
        RequestKey requestKey = new RequestKey(request.getImageUri(), request.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            try {
                DownloaderContext downloaderContext = map.get(requestKey);
                if (downloaderContext != null && (workItem = downloaderContext.getWorkItem()) != null) {
                    workItem.moveToFront();
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void readFromCache(RequestKey requestKey, boolean z2) {
        InputStream cachedImageStream;
        Uri redirectedUri;
        boolean z3 = false;
        if (!z2 || (redirectedUri = UrlRedirectCache.getRedirectedUri(requestKey.getUri())) == null) {
            cachedImageStream = null;
        } else {
            cachedImageStream = ImageResponseCache.getCachedImageStream(redirectedUri);
            if (cachedImageStream != null) {
                z3 = true;
            }
        }
        if (!z3) {
            cachedImageStream = ImageResponseCache.getCachedImageStream(requestKey.getUri());
        }
        if (cachedImageStream != null) {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(cachedImageStream);
            Utility.closeQuietly(cachedImageStream);
            issueResponse(requestKey, null, bitmapDecodeStream, z3);
            return;
        }
        DownloaderContext downloaderContextRemovePendingRequest = removePendingRequest(requestKey);
        ImageRequest request = downloaderContextRemovePendingRequest != null ? downloaderContextRemovePendingRequest.getRequest() : null;
        if (downloaderContextRemovePendingRequest == null || downloaderContextRemovePendingRequest.isCancelled() || request == null) {
            return;
        }
        enqueueDownload(request, requestKey);
    }

    private final DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext downloaderContextRemove;
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            downloaderContextRemove = map.remove(requestKey);
        }
        return downloaderContextRemove;
    }

    public final Map<RequestKey, DownloaderContext> getPendingRequests() {
        return pendingRequests;
    }
}
