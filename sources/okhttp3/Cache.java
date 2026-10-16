package okhttp3;

import com.facebook.stetho.server.http.HttpHeaders;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Cache implements Closeable, Flushable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f143875h = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DiskLruCache f143876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f143877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f143878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f143879d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f143880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f143881g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class CacheResponseBody extends ResponseBody {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final DiskLruCache.Snapshot f143882c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f143883d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f143884f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final BufferedSource f143885g;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            this.f143882c = snapshot;
            this.f143883d = str;
            this.f143884f = str2;
            this.f143885g = Okio.d(new ForwardingSource(this) { // from class: okhttp3.Cache.CacheResponseBody.1

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ CacheResponseBody f143887c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(this.f143886b);
                    this.f143887c = this;
                }

                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    this.f143887c.m().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public long f() {
            String str = this.f143884f;
            if (str == null) {
                return -1L;
            }
            return Util.X(str, -1L);
        }

        @Override // okhttp3.ResponseBody
        public MediaType i() {
            String str = this.f143883d;
            if (str == null) {
                return null;
            }
            return MediaType.f144108e.b(str);
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource k() {
            return this.f143885g;
        }

        public final DiskLruCache.Snapshot m() {
            return this.f143882c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Set d(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            int i3 = 0;
            while (i3 < size) {
                int i4 = i3 + 1;
                if (StringsKt.F("Vary", headers.d(i3), true)) {
                    String strH = headers.h(i3);
                    if (treeSet == null) {
                        treeSet = new TreeSet(StringsKt.H(StringCompanionObject.f140150a));
                    }
                    Iterator it = StringsKt.U0(strH, new char[]{','}, false, 0, 6, null).iterator();
                    while (it.hasNext()) {
                        treeSet.add(StringsKt.t1((String) it.next()).toString());
                    }
                }
                i3 = i4;
            }
            return treeSet == null ? SetsKt.emptySet() : treeSet;
        }

        private final Headers e(Headers headers, Headers headers2) {
            Set setD = d(headers2);
            if (setD.isEmpty()) {
                return Util.f144275b;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            int i3 = 0;
            while (i3 < size) {
                int i4 = i3 + 1;
                String strD = headers.d(i3);
                if (setD.contains(strD)) {
                    builder.a(strD, headers.h(i3));
                }
                i3 = i4;
            }
            return builder.f();
        }

        public final boolean a(Response response) {
            Intrinsics.checkNotNullParameter(response, "<this>");
            return d(response.r()).contains("*");
        }

        public final String b(HttpUrl url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return ByteString.f144997d.d(url.toString()).u().l();
        }

        public final int c(BufferedSource source) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            try {
                long jM1 = source.M1();
                String strQ0 = source.Q0();
                if (jM1 >= 0 && jM1 <= 2147483647L && strQ0.length() <= 0) {
                    return (int) jM1;
                }
                throw new IOException("expected an int but was \"" + jM1 + strQ0 + '\"');
            } catch (NumberFormatException e3) {
                throw new IOException(e3.getMessage());
            }
        }

        public final Headers f(Response response) {
            Intrinsics.checkNotNullParameter(response, "<this>");
            Response responseC = response.C();
            Intrinsics.checkNotNull(responseC);
            return e(responseC.N().f(), response.r());
        }

        public final boolean g(Response cachedResponse, Headers cachedRequest, Request newRequest) {
            Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
            Intrinsics.checkNotNullParameter(cachedRequest, "cachedRequest");
            Intrinsics.checkNotNullParameter(newRequest, "newRequest");
            Set<String> setD = d(cachedResponse.r());
            if ((setD instanceof Collection) && setD.isEmpty()) {
                return true;
            }
            for (String str : setD) {
                if (!Intrinsics.areEqual(cachedRequest.l(str), newRequest.e(str))) {
                    return false;
                }
            }
            return true;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class RealCacheRequest implements CacheRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DiskLruCache.Editor f143901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Sink f143902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Sink f143903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f143904d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Cache f143905e;

        public RealCacheRequest(final Cache this$0, DiskLruCache.Editor editor) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(editor, "editor");
            this.f143905e = this$0;
            this.f143901a = editor;
            Sink sinkF = editor.f(1);
            this.f143902b = sinkF;
            this.f143903c = new ForwardingSink(sinkF) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Cache cache = this$0;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache) {
                        if (realCacheRequest.b()) {
                            return;
                        }
                        realCacheRequest.c(true);
                        cache.l(cache.f() + 1);
                        super.close();
                        this.f143901a.b();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache cache = this.f143905e;
            synchronized (cache) {
                if (b()) {
                    return;
                }
                c(true);
                cache.k(cache.c() + 1);
                Util.m(this.f143902b);
                try {
                    this.f143901a.a();
                } catch (IOException unused) {
                }
            }
        }

        public final boolean b() {
            return this.f143904d;
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public Sink body() {
            return this.f143903c;
        }

        public final void c(boolean z2) {
            this.f143904d = z2;
        }
    }

    private final void a(DiskLruCache.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.a();
        } catch (IOException unused) {
        }
    }

    public final Response b(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            DiskLruCache.Snapshot snapshotF = this.f143876a.F(f143875h.b(request.k()));
            if (snapshotF == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshotF.b(0));
                Response responseD = entry.d(snapshotF);
                if (entry.b(request, responseD)) {
                    return responseD;
                }
                ResponseBody responseBodyA = responseD.a();
                if (responseBodyA != null) {
                    Util.m(responseBodyA);
                }
                return null;
            } catch (IOException unused) {
                Util.m(snapshotF);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public final int c() {
        return this.f143878c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f143876a.close();
    }

    public final int f() {
        return this.f143877b;
    }

    @Override // java.io.Flushable
    public void flush() {
        this.f143876a.flush();
    }

    public final void j(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.f143876a.w0(f143875h.b(request.k()));
    }

    public final void k(int i3) {
        this.f143878c = i3;
    }

    public final void l(int i3) {
        this.f143877b = i3;
    }

    public final synchronized void m() {
        this.f143880f++;
    }

    public final synchronized void n(CacheStrategy cacheStrategy) {
        try {
            Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
            this.f143881g++;
            if (cacheStrategy.b() != null) {
                this.f143879d++;
            } else if (cacheStrategy.a() != null) {
                this.f143880f++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void r(Response cached, Response network) {
        DiskLruCache.Editor editorA;
        Intrinsics.checkNotNullParameter(cached, "cached");
        Intrinsics.checkNotNullParameter(network, "network");
        Entry entry = new Entry(network);
        ResponseBody responseBodyA = cached.a();
        if (responseBodyA == null) {
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        }
        try {
            editorA = ((CacheResponseBody) responseBodyA).m().a();
            if (editorA == null) {
                return;
            }
            try {
                entry.f(editorA);
                editorA.b();
            } catch (IOException unused) {
                a(editorA);
            }
        } catch (IOException unused2) {
            editorA = null;
        }
    }

    public final CacheRequest i(Response response) {
        DiskLruCache.Editor editorC;
        Intrinsics.checkNotNullParameter(response, FptyjHFU.HZZSkXmiH);
        String strH = response.N().h();
        if (HttpMethod.f144520a.a(response.N().h())) {
            try {
                j(response.N());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!Intrinsics.areEqual(strH, "GET")) {
            return null;
        }
        Companion companion = f143875h;
        if (companion.a(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            editorC = DiskLruCache.C(this.f143876a, companion.b(response.N().k()), 0L, 2, null);
            if (editorC == null) {
                return null;
            }
            try {
                entry.f(editorC);
                return new RealCacheRequest(this, editorC);
            } catch (IOException unused2) {
                a(editorC);
                return null;
            }
        } catch (IOException unused3) {
            editorC = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Entry {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final Companion f143888k = new Companion(null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f143889l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final String f143890m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HttpUrl f143891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Headers f143892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f143893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Protocol f143894d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f143895e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f143896f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Headers f143897g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Handshake f143898h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final long f143899i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final long f143900j;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Platform.Companion companion = Platform.f144818a;
            f143889l = Intrinsics.stringPlus(companion.g().g(), "-Sent-Millis");
            f143890m = Intrinsics.stringPlus(companion.g().g(), "-Received-Millis");
        }

        public Entry(Source rawSource) {
            Intrinsics.checkNotNullParameter(rawSource, "rawSource");
            try {
                BufferedSource bufferedSourceD = Okio.d(rawSource);
                String strQ0 = bufferedSourceD.Q0();
                HttpUrl httpUrlF = HttpUrl.f144085k.f(strQ0);
                if (httpUrlF == null) {
                    IOException iOException = new IOException(Intrinsics.stringPlus("Cache corruption for ", strQ0));
                    Platform.f144818a.g().k("cache corruption", 5, iOException);
                    throw iOException;
                }
                this.f143891a = httpUrlF;
                this.f143893c = bufferedSourceD.Q0();
                Headers.Builder builder = new Headers.Builder();
                int iC = Cache.f143875h.c(bufferedSourceD);
                int i3 = 0;
                int i4 = 0;
                while (i4 < iC) {
                    i4++;
                    builder.c(bufferedSourceD.Q0());
                }
                this.f143892b = builder.f();
                StatusLine statusLineA = StatusLine.f144536d.a(bufferedSourceD.Q0());
                this.f143894d = statusLineA.f144537a;
                this.f143895e = statusLineA.f144538b;
                this.f143896f = statusLineA.f144539c;
                Headers.Builder builder2 = new Headers.Builder();
                int iC2 = Cache.f143875h.c(bufferedSourceD);
                while (i3 < iC2) {
                    i3++;
                    builder2.c(bufferedSourceD.Q0());
                }
                String str = f143889l;
                String strG = builder2.g(str);
                String str2 = f143890m;
                String strG2 = builder2.g(str2);
                builder2.i(str);
                builder2.i(str2);
                long j3 = 0;
                this.f143899i = strG == null ? 0L : Long.parseLong(strG);
                if (strG2 != null) {
                    j3 = Long.parseLong(strG2);
                }
                this.f143900j = j3;
                this.f143897g = builder2.f();
                if (a()) {
                    String strQ02 = bufferedSourceD.Q0();
                    if (strQ02.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strQ02 + '\"');
                    }
                    this.f143898h = Handshake.f144074e.b(!bufferedSourceD.G1() ? TlsVersion.f144266b.a(bufferedSourceD.Q0()) : TlsVersion.SSL_3_0, CipherSuite.f143950b.b(bufferedSourceD.Q0()), c(bufferedSourceD), c(bufferedSourceD));
                } else {
                    this.f143898h = null;
                }
                Unit unit = Unit.f139807a;
                CloseableKt.a(rawSource, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.a(rawSource, th);
                    throw th2;
                }
            }
        }

        private final boolean a() {
            return Intrinsics.areEqual(this.f143891a.r(), "https");
        }

        private final List c(BufferedSource bufferedSource) throws IOException {
            int iC = Cache.f143875h.c(bufferedSource);
            if (iC == -1) {
                return CollectionsKt.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iC);
                int i3 = 0;
                while (i3 < iC) {
                    i3++;
                    String strQ0 = bufferedSource.Q0();
                    Buffer buffer = new Buffer();
                    ByteString byteStringA = ByteString.f144997d.a(strQ0);
                    Intrinsics.checkNotNull(byteStringA);
                    buffer.q2(byteStringA);
                    arrayList.add(certificateFactory.generateCertificate(buffer.H2()));
                }
                return arrayList;
            } catch (CertificateException e3) {
                throw new IOException(e3.getMessage());
            }
        }

        private final void e(BufferedSink bufferedSink, List list) throws IOException {
            try {
                bufferedSink.j1(list.size()).writeByte(10);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    byte[] bytes = ((Certificate) it.next()).getEncoded();
                    ByteString.Companion companion = ByteString.f144997d;
                    Intrinsics.checkNotNullExpressionValue(bytes, "bytes");
                    bufferedSink.C0(ByteString.Companion.g(companion, bytes, 0, 0, 3, null).a()).writeByte(10);
                }
            } catch (CertificateEncodingException e3) {
                throw new IOException(e3.getMessage());
            }
        }

        public final boolean b(Request request, Response response) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(response, "response");
            return Intrinsics.areEqual(this.f143891a, request.k()) && Intrinsics.areEqual(this.f143893c, request.h()) && Cache.f143875h.g(response, this.f143892b, request);
        }

        public final Response d(DiskLruCache.Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            String strA = this.f143897g.a("Content-Type");
            String strA2 = this.f143897g.a(HttpHeaders.CONTENT_LENGTH);
            return new Response.Builder().s(new Request.Builder().r(this.f143891a).h(this.f143893c, null).g(this.f143892b).b()).q(this.f143894d).g(this.f143895e).n(this.f143896f).l(this.f143897g).b(new CacheResponseBody(snapshot, strA, strA2)).j(this.f143898h).t(this.f143899i).r(this.f143900j).c();
        }

        public final void f(DiskLruCache.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "editor");
            BufferedSink bufferedSinkC = Okio.c(editor.f(0));
            try {
                bufferedSinkC.C0(this.f143891a.toString()).writeByte(10);
                bufferedSinkC.C0(this.f143893c).writeByte(10);
                bufferedSinkC.j1(this.f143892b.size()).writeByte(10);
                int size = this.f143892b.size();
                int i3 = 0;
                while (i3 < size) {
                    int i4 = i3 + 1;
                    bufferedSinkC.C0(this.f143892b.d(i3)).C0(": ").C0(this.f143892b.h(i3)).writeByte(10);
                    i3 = i4;
                }
                bufferedSinkC.C0(new StatusLine(this.f143894d, this.f143895e, this.f143896f).toString()).writeByte(10);
                bufferedSinkC.j1(this.f143897g.size() + 2).writeByte(10);
                int size2 = this.f143897g.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    bufferedSinkC.C0(this.f143897g.d(i5)).C0(": ").C0(this.f143897g.h(i5)).writeByte(10);
                }
                bufferedSinkC.C0(f143889l).C0(": ").j1(this.f143899i).writeByte(10);
                bufferedSinkC.C0(f143890m).C0(": ").j1(this.f143900j).writeByte(10);
                if (a()) {
                    bufferedSinkC.writeByte(10);
                    Handshake handshake = this.f143898h;
                    Intrinsics.checkNotNull(handshake);
                    bufferedSinkC.C0(handshake.a().c()).writeByte(10);
                    e(bufferedSinkC, this.f143898h.d());
                    e(bufferedSinkC, this.f143898h.c());
                    bufferedSinkC.C0(this.f143898h.e().b()).writeByte(10);
                }
                Unit unit = Unit.f139807a;
                CloseableKt.a(bufferedSinkC, null);
            } finally {
            }
        }

        public Entry(Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.f143891a = response.N().k();
            this.f143892b = Cache.f143875h.f(response);
            this.f143893c = response.N().h();
            this.f143894d = response.L();
            this.f143895e = response.i();
            this.f143896f = response.z();
            this.f143897g = response.r();
            this.f143898h = response.k();
            this.f143899i = response.O();
            this.f143900j = response.M();
        }
    }
}
