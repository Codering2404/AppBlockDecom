package coil.fetch;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import coil.decode.ImageSources;
import coil.disk.DiskCache;
import coil.fetch.Fetcher;
import coil.network.CacheResponse;
import coil.network.CacheStrategy;
import coil.request.Options;
import coil.util.Utils;
import java.io.IOException;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;

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
public final class HttpUriFetcher implements Fetcher {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f55831f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final CacheControl f55832g = new CacheControl.Builder().d().e().a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final CacheControl f55833h = new CacheControl.Builder().d().f().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f55834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Options f55835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f55836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f55837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f55838e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory implements Fetcher.Factory<Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Lazy f55839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Lazy f55840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f55841c;

        public Factory(Lazy lazy, Lazy lazy2, boolean z2) {
            this.f55839a = lazy;
            this.f55840b = lazy2;
            this.f55841c = z2;
        }

        private final boolean c(Uri uri) {
            return Intrinsics.areEqual(uri.getScheme(), "http") || Intrinsics.areEqual(uri.getScheme(), "https");
        }

        @Override // coil.fetch.Fetcher.Factory
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Fetcher a(Uri uri, Options options, ImageLoader imageLoader) {
            if (c(uri)) {
                return new HttpUriFetcher(uri.toString(), options, this.f55839a, this.f55840b, this.f55841c);
            }
            return null;
        }
    }

    public HttpUriFetcher(String str, Options options, Lazy lazy, Lazy lazy2, boolean z2) {
        this.f55834a = str;
        this.f55835b = options;
        this.f55836c = lazy;
        this.f55837d = lazy2;
        this.f55838e = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(okhttp3.Request r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof coil.fetch.HttpUriFetcher$executeNetworkRequest$1
            if (r0 == 0) goto L13
            r0 = r6
            coil.fetch.HttpUriFetcher$executeNetworkRequest$1 r0 = (coil.fetch.HttpUriFetcher$executeNetworkRequest$1) r0
            int r1 = r0.f55844c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f55844c = r1
            goto L18
        L13:
            coil.fetch.HttpUriFetcher$executeNetworkRequest$1 r0 = new coil.fetch.HttpUriFetcher$executeNetworkRequest$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f55842a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f55844c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L72
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            boolean r6 = coil.util.Utils.s()
            if (r6 == 0) goto L5d
            coil.request.Options r6 = r4.f55835b
            coil.request.CachePolicy r6 = r6.k()
            boolean r6 = r6.b()
            if (r6 != 0) goto L57
            kotlin.Lazy r6 = r4.f55836c
            java.lang.Object r6 = r6.getValue()
            okhttp3.Call$Factory r6 = (okhttp3.Call.Factory) r6
            okhttp3.Call r5 = r6.a(r5)
            okhttp3.Response r5 = r5.d()
            goto L75
        L57:
            android.os.NetworkOnMainThreadException r5 = new android.os.NetworkOnMainThreadException
            r5.<init>()
            throw r5
        L5d:
            kotlin.Lazy r6 = r4.f55836c
            java.lang.Object r6 = r6.getValue()
            okhttp3.Call$Factory r6 = (okhttp3.Call.Factory) r6
            okhttp3.Call r5 = r6.a(r5)
            r0.f55844c = r3
            java.lang.Object r6 = coil.util.Calls.a(r5, r0)
            if (r6 != r1) goto L72
            return r1
        L72:
            r5 = r6
            okhttp3.Response r5 = (okhttp3.Response) r5
        L75:
            boolean r6 = r5.isSuccessful()
            if (r6 != 0) goto L92
            int r6 = r5.i()
            r0 = 304(0x130, float:4.26E-43)
            if (r6 == r0) goto L92
            okhttp3.ResponseBody r6 = r5.a()
            if (r6 == 0) goto L8c
            coil.util.Utils.d(r6)
        L8c:
            coil.network.HttpException r6 = new coil.network.HttpException
            r6.<init>(r5)
            throw r6
        L92:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.c(okhttp3.Request, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String d() {
        String strH = this.f55835b.h();
        return strH == null ? this.f55834a : strH;
    }

    private final FileSystem e() {
        Object value = this.f55837d.getValue();
        Intrinsics.checkNotNull(value);
        return ((DiskCache) value).getFileSystem();
    }

    private final boolean g(Request request, Response response) {
        if (this.f55835b.i().c()) {
            return !this.f55838e || CacheStrategy.f55984c.c(request, response);
        }
        return false;
    }

    private final Request h() {
        Request.Builder builderG = new Request.Builder().q(this.f55834a).g(this.f55835b.j());
        for (Map.Entry entry : this.f55835b.p().a().entrySet()) {
            Object key = entry.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            builderG.o((Class) key, entry.getValue());
        }
        boolean zB = this.f55835b.i().b();
        boolean zB2 = this.f55835b.k().b();
        if (!zB2 && zB) {
            builderG.c(CacheControl.f143913p);
        } else if (!zB2 || zB) {
            if (!zB2 && !zB) {
                builderG.c(f55833h);
            }
        } else if (this.f55835b.i().c()) {
            builderG.c(CacheControl.f143912o);
        } else {
            builderG.c(f55832g);
        }
        return builderG.b();
    }

    private final DiskCache.Snapshot i() {
        DiskCache diskCache;
        if (!this.f55835b.i().b() || (diskCache = (DiskCache) this.f55837d.getValue()) == null) {
            return null;
        }
        return diskCache.b(d());
    }

    private final CacheResponse j(DiskCache.Snapshot snapshot) throws Throwable {
        Throwable th;
        CacheResponse cacheResponse;
        try {
            BufferedSource bufferedSourceD = Okio.d(e().t(snapshot.o()));
            try {
                cacheResponse = new CacheResponse(bufferedSourceD);
                if (bufferedSourceD != null) {
                    try {
                        bufferedSourceD.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    th = null;
                }
            } catch (Throwable th3) {
                if (bufferedSourceD != null) {
                    try {
                        bufferedSourceD.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.a(th3, th4);
                    }
                }
                th = th3;
                cacheResponse = null;
            }
            if (th != null) {
                throw th;
            }
            Intrinsics.checkNotNull(cacheResponse);
            return cacheResponse;
        } catch (IOException unused) {
            return null;
        }
    }

    private final DataSource k(Response response) {
        return response.C() != null ? DataSource.NETWORK : DataSource.DISK;
    }

    private final ImageSource l(DiskCache.Snapshot snapshot) {
        return ImageSources.c(snapshot.getData(), e(), d(), snapshot);
    }

    private final ImageSource m(ResponseBody responseBody) {
        return ImageSources.a(responseBody.k(), this.f55835b.g());
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c2 A[Catch: all -> 0x007e, Exception -> 0x0081, TRY_LEAVE, TryCatch #10 {Exception -> 0x0081, blocks: (B:15:0x002b, B:18:0x0036, B:37:0x0089, B:71:0x0103, B:38:0x008e, B:30:0x007a, B:39:0x008f, B:55:0x00c2, B:70:0x0100, B:74:0x010b, B:67:0x00f8, B:75:0x010c, B:52:0x00bb), top: B:99:0x002b, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010c A[Catch: all -> 0x007e, Exception -> 0x0081, TRY_LEAVE, TryCatch #10 {Exception -> 0x0081, blocks: (B:15:0x002b, B:18:0x0036, B:37:0x0089, B:71:0x0103, B:38:0x008e, B:30:0x007a, B:39:0x008f, B:55:0x00c2, B:70:0x0100, B:74:0x010b, B:67:0x00f8, B:75:0x010c, B:52:0x00bb), top: B:99:0x002b, outer: #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final coil.disk.DiskCache.Snapshot n(coil.disk.DiskCache.Snapshot r6, okhttp3.Request r7, okhttp3.Response r8, coil.network.CacheResponse r9) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.n(coil.disk.DiskCache$Snapshot, okhttp3.Request, okhttp3.Response, coil.network.CacheResponse):coil.disk.DiskCache$Snapshot");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x012d A[Catch: Exception -> 0x0140, TryCatch #0 {Exception -> 0x0140, blocks: (B:72:0x0189, B:54:0x011f, B:56:0x012d, B:58:0x013b, B:61:0x0144, B:63:0x014e, B:65:0x0156, B:67:0x016e), top: B:81:0x011f }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014e A[Catch: Exception -> 0x0140, TryCatch #0 {Exception -> 0x0140, blocks: (B:72:0x0189, B:54:0x011f, B:56:0x012d, B:58:0x013b, B:61:0x0144, B:63:0x014e, B:65:0x0156, B:67:0x016e), top: B:81:0x011f }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // coil.fetch.Fetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlin.coroutines.Continuation r13) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.fetch.HttpUriFetcher.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String f(String str, MediaType mediaType) {
        String strK;
        String string = mediaType != null ? mediaType.toString() : null;
        if ((string == null || StringsKt.U(string, "text/plain", false, 2, null)) && (strK = Utils.k(MimeTypeMap.getSingleton(), str)) != null) {
            return strK;
        }
        if (string != null) {
            return StringsKt.m1(string, ';', null, 2, null);
        }
        return null;
    }
}
