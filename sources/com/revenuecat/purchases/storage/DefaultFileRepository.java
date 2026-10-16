package com.revenuecat.purchases.storage;

import android.content.Context;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.Checksum;
import com.revenuecat.purchases.utils.DefaultUrlConnectionFactory;
import com.revenuecat.purchases.utils.UrlConnection;
import com.revenuecat.purchases.utils.UrlConnectionFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.NonCancellable;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class DefaultFileRepository implements FileRepository {
    private final LocalFileCache fileCacheManager;
    private final CoroutineScope ioScope;
    private final LogHandler logHandler;
    private final KeyedDeferredValueStore<CacheKey, URI> store;
    private final UrlConnectionFactory urlConnectionFactory;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CacheKey {
        private final Checksum checksum;
        private final URL url;

        public CacheKey(URL url, Checksum checksum) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.checksum = checksum;
        }

        public static /* synthetic */ CacheKey copy$default(CacheKey cacheKey, URL url, Checksum checksum, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                url = cacheKey.url;
            }
            if ((i3 & 2) != 0) {
                checksum = cacheKey.checksum;
            }
            return cacheKey.copy(url, checksum);
        }

        public final URL component1() {
            return this.url;
        }

        public final Checksum component2() {
            return this.checksum;
        }

        public final CacheKey copy(URL url, Checksum checksum) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new CacheKey(url, checksum);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) obj;
            return Intrinsics.areEqual(this.url, cacheKey.url) && Intrinsics.areEqual(this.checksum, cacheKey.checksum);
        }

        public final Checksum getChecksum() {
            return this.checksum;
        }

        public final URL getUrl() {
            return this.url;
        }

        public int hashCode() {
            int iHashCode = this.url.hashCode() * 31;
            Checksum checksum = this.checksum;
            return iHashCode + (checksum == null ? 0 : checksum.hashCode());
        }

        public String toString() {
            return "CacheKey(url=" + this.url + ", checksum=" + this.checksum + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Error extends IOException {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ChecksumValidationFailed extends Error {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChecksumValidationFailed(String message) {
                super(message, null);
                Intrinsics.checkNotNullParameter(message, "message");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class FailedToCreateCacheDirectory extends Error {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FailedToCreateCacheDirectory(String url) {
                super("Failed to create cache directory for " + url, null);
                Intrinsics.checkNotNullParameter(url, "url");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class FailedToFetchFileFromRemoteSource extends Error {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FailedToFetchFileFromRemoteSource(String message) {
                super(message, null);
                Intrinsics.checkNotNullParameter(message, "message");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class FailedToSaveCachedFile extends Error {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FailedToSaveCachedFile(String message) {
                super(message, null);
                Intrinsics.checkNotNullParameter(message, "message");
            }
        }

        public /* synthetic */ Error(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        private Error(String str) {
            super(str);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.storage.DefaultFileRepository$downloadFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.storage.DefaultFileRepository", f = "DefaultFileRepository.kt", l = {132}, m = "downloadFile")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultFileRepository.this.downloadFile(null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.storage.DefaultFileRepository$downloadFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.storage.DefaultFileRepository$downloadFile$2", f = "DefaultFileRepository.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UrlConnection>, Object> {
        final /* synthetic */ URL $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(URL url, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$url = url;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DefaultFileRepository.this.new AnonymousClass2(this.$url, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            URL url = this.$url;
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.v("[Purchases] - " + logLevel.name(), "Downloading remote file from " + url);
            }
            UrlConnectionFactory urlConnectionFactory = DefaultFileRepository.this.urlConnectionFactory;
            String string = this.$url.toString();
            Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
            UrlConnection urlConnectionCreateConnection$default = UrlConnectionFactory.createConnection$default(urlConnectionFactory, string, null, 2, null);
            if (urlConnectionCreateConnection$default.getResponseCode() == 200) {
                return urlConnectionCreateConnection$default;
            }
            urlConnectionCreateConnection$default.disconnect();
            throw new IOException("HTTP " + urlConnectionCreateConnection$default.getResponseCode() + " when downloading file at: " + this.$url);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super UrlConnection> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.storage.DefaultFileRepository$prefetch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.storage.DefaultFileRepository$prefetch$1", f = "DefaultFileRepository.kt", l = {95}, m = "invokeSuspend")
    static final class C23671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Pair<URL, Checksum>> $urls;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ DefaultFileRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C23671(List<Pair<URL, Checksum>> list, DefaultFileRepository defaultFileRepository, Continuation<? super C23671> continuation) {
            super(2, continuation);
            this.$urls = list;
            this.this$0 = defaultFileRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23671(this.$urls, this.this$0, continuation);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005b -> B:13:0x0034). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Iterator it;
            DefaultFileRepository defaultFileRepository;
            URL url;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                List<Pair<URL, Checksum>> list = this.$urls;
                DefaultFileRepository defaultFileRepository2 = this.this$0;
                it = list.iterator();
                defaultFileRepository = defaultFileRepository2;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                url = (URL) this.L$2;
                it = (Iterator) this.L$1;
                defaultFileRepository = (DefaultFileRepository) this.L$0;
                try {
                    ResultKt.b(obj);
                } catch (IOException e3) {
                    defaultFileRepository.logHandler.e("FileRepository", "Prefetch failed for " + url + ": " + e3, e3);
                }
            }
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                url = (URL) pair.a();
                Checksum checksum = (Checksum) pair.b();
                this.L$0 = defaultFileRepository;
                this.L$1 = it;
                this.L$2 = url;
                this.label = 1;
                if (defaultFileRepository.generateOrGetCachedFileURL(url, checksum, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23671) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public DefaultFileRepository(KeyedDeferredValueStore<CacheKey, URI> store, LocalFileCache fileCacheManager, CoroutineScope ioScope, LogHandler logHandler, UrlConnectionFactory urlConnectionFactory) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(fileCacheManager, "fileCacheManager");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(logHandler, "logHandler");
        Intrinsics.checkNotNullParameter(urlConnectionFactory, SbbqvQlxi.tyrnwoLFpbUreBX);
        this.store = store;
        this.fileCacheManager = fileCacheManager;
        this.ioScope = ioScope;
        this.logHandler = logHandler;
        this.urlConnectionFactory = urlConnectionFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object downloadFile(java.net.URL r6, kotlin.coroutines.Continuation<? super com.revenuecat.purchases.utils.UrlConnection> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.revenuecat.purchases.storage.DefaultFileRepository.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.revenuecat.purchases.storage.DefaultFileRepository$downloadFile$1 r0 = (com.revenuecat.purchases.storage.DefaultFileRepository.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.storage.DefaultFileRepository$downloadFile$1 r0 = new com.revenuecat.purchases.storage.DefaultFileRepository$downloadFile$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$1
            java.net.URL r6 = (java.net.URL) r6
            java.lang.Object r0 = r0.L$0
            com.revenuecat.purchases.storage.DefaultFileRepository r0 = (com.revenuecat.purchases.storage.DefaultFileRepository) r0
            kotlin.ResultKt.b(r7)     // Catch: java.io.IOException -> L31
            goto L56
        L31:
            r7 = move-exception
            goto L5b
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.b()     // Catch: java.io.IOException -> L59
            com.revenuecat.purchases.storage.DefaultFileRepository$downloadFile$2 r2 = new com.revenuecat.purchases.storage.DefaultFileRepository$downloadFile$2     // Catch: java.io.IOException -> L59
            r4 = 0
            r2.<init>(r6, r4)     // Catch: java.io.IOException -> L59
            r0.L$0 = r5     // Catch: java.io.IOException -> L59
            r0.L$1 = r6     // Catch: java.io.IOException -> L59
            r0.label = r3     // Catch: java.io.IOException -> L59
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r7, r2, r0)     // Catch: java.io.IOException -> L59
            if (r7 != r1) goto L55
            return r1
        L55:
            r0 = r5
        L56:
            com.revenuecat.purchases.utils.UrlConnection r7 = (com.revenuecat.purchases.utils.UrlConnection) r7     // Catch: java.io.IOException -> L31
            return r7
        L59:
            r7 = move-exception
            r0 = r5
        L5b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to fetch file from remote source: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = ". Error: "
            r1.append(r6)
            java.lang.String r6 = r7.getLocalizedMessage()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            com.revenuecat.purchases.LogHandler r0 = r0.logHandler
            java.lang.String r1 = "FileRepository"
            r0.e(r1, r6, r7)
            com.revenuecat.purchases.storage.DefaultFileRepository$Error$FailedToFetchFileFromRemoteSource r7 = new com.revenuecat.purchases.storage.DefaultFileRepository$Error$FailedToFetchFileFromRemoteSource
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.storage.DefaultFileRepository.downloadFile(java.net.URL, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveCachedFile(URI uri, UrlConnection urlConnection, Checksum checksum) {
        try {
            try {
                InputStream inputStream = urlConnection.getInputStream();
                try {
                    this.fileCacheManager.saveData(inputStream, uri, checksum);
                    Unit unit = Unit.f139807a;
                    CloseableKt.a(inputStream, null);
                } finally {
                }
            } finally {
                urlConnection.disconnect();
            }
        } catch (Checksum.ChecksumValidationException e3) {
            String str = "Checksum validation failed for " + uri + ": " + e3.getMessage();
            this.logHandler.e("FileRepository", str, e3);
            throw new Error.ChecksumValidationFailed(str);
        } catch (IOException e4) {
            String str2 = "Failed to save cached file: " + uri + ". Error: " + e4.getLocalizedMessage();
            this.logHandler.e("FileRepository", str2, e4);
            throw new Error.FailedToSaveCachedFile(str2);
        }
    }

    @Override // com.revenuecat.purchases.storage.FileRepository
    public Object generateOrGetCachedFileURL(final URL url, final Checksum checksum, Continuation<? super URI> continuation) {
        return this.store.getOrPut(new CacheKey(url, checksum), new Function0<Deferred<? extends URI>>() { // from class: com.revenuecat.purchases.storage.DefaultFileRepository.generateOrGetCachedFileURL.2

            /* JADX INFO: renamed from: com.revenuecat.purchases.storage.DefaultFileRepository$generateOrGetCachedFileURL$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.revenuecat.purchases.storage.DefaultFileRepository$generateOrGetCachedFileURL$2$1", f = "DefaultFileRepository.kt", l = {119}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super URI>, Object> {
                final /* synthetic */ Checksum $checksum;
                final /* synthetic */ URL $url;
                Object L$0;
                int label;
                final /* synthetic */ DefaultFileRepository this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(DefaultFileRepository defaultFileRepository, URL url, Checksum checksum, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = defaultFileRepository;
                    this.$url = url;
                    this.$checksum = checksum;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$url, this.$checksum, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    URI uri;
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.b(obj);
                        URI uriGenerateLocalFilesystemURI = this.this$0.fileCacheManager.generateLocalFilesystemURI(this.$url, this.$checksum);
                        if (uriGenerateLocalFilesystemURI == null) {
                            String string = this.$url.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
                            Error.FailedToCreateCacheDirectory failedToCreateCacheDirectory = new Error.FailedToCreateCacheDirectory(string);
                            this.this$0.logHandler.e("FileRepository", "Failed to create cache directory for " + this.$url, failedToCreateCacheDirectory);
                            throw failedToCreateCacheDirectory;
                        }
                        if (this.this$0.fileCacheManager.cachedContentExists(uriGenerateLocalFilesystemURI)) {
                            return uriGenerateLocalFilesystemURI;
                        }
                        DefaultFileRepository defaultFileRepository = this.this$0;
                        URL url = this.$url;
                        this.L$0 = uriGenerateLocalFilesystemURI;
                        this.label = 1;
                        Object objDownloadFile = defaultFileRepository.downloadFile(url, this);
                        if (objDownloadFile == objF) {
                            return objF;
                        }
                        uri = uriGenerateLocalFilesystemURI;
                        obj = objDownloadFile;
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        uri = (URI) this.L$0;
                        ResultKt.b(obj);
                    }
                    this.this$0.saveCachedFile(uri, (UrlConnection) obj, this.$checksum);
                    return uri;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super URI> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Deferred<URI> invoke() {
                return BuildersKt__Builders_commonKt.b(DefaultFileRepository.this.ioScope, null, null, new AnonymousClass1(DefaultFileRepository.this, url, checksum, null), 3, null);
            }
        }).await(continuation);
    }

    @Override // com.revenuecat.purchases.storage.FileRepository
    public URI getFile(URL url, Checksum checksum) {
        Intrinsics.checkNotNullParameter(url, "url");
        URI uriGenerateLocalFilesystemURI = this.fileCacheManager.generateLocalFilesystemURI(url, checksum);
        if (uriGenerateLocalFilesystemURI == null || !this.fileCacheManager.cachedContentExists(uriGenerateLocalFilesystemURI)) {
            return null;
        }
        return uriGenerateLocalFilesystemURI;
    }

    public final KeyedDeferredValueStore<CacheKey, URI> getStore$purchases_defaultsBc8Release() {
        return this.store;
    }

    @Override // com.revenuecat.purchases.storage.FileRepository
    public void prefetch(List<Pair<URL, Checksum>> urls) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C23671(urls, this, null), 3, null);
    }

    public /* synthetic */ DefaultFileRepository(KeyedDeferredValueStore keyedDeferredValueStore, LocalFileCache localFileCache, CoroutineScope coroutineScope, LogHandler logHandler, UrlConnectionFactory urlConnectionFactory, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new KeyedDeferredValueStore(null, 1, null) : keyedDeferredValueStore, localFileCache, (i3 & 4) != 0 ? CoroutineScopeKt.a(Dispatchers.b().plus(NonCancellable.f141003a)) : coroutineScope, (i3 & 8) != 0 ? LogWrapperKt.getCurrentLogHandler() : logHandler, (i3 & 16) != 0 ? new DefaultUrlConnectionFactory() : urlConnectionFactory);
    }

    public /* synthetic */ DefaultFileRepository(Context context, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? DefaultFileCache.DEFAULT_SUBDIR : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultFileRepository(Context context, String subDir) {
        this(null, new DefaultFileCache(context, subDir), null, null, null, 29, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(subDir, "subDir");
    }
}
