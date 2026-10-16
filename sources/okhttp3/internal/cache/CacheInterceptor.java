package okhttp3.internal.cache;

import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

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
public final class CacheInterceptor implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f144285b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Cache f144286a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers c(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                int i5 = i4 + 1;
                String strD = headers.d(i4);
                String strH = headers.h(i4);
                if ((!StringsKt.F("Warning", strD, true) || !StringsKt.U(strH, AppEventsConstants.EVENT_PARAM_VALUE_YES, false, 2, null)) && (d(strD) || !e(strD) || headers2.a(strD) == null)) {
                    builder.d(strD, strH);
                }
                i4 = i5;
            }
            int size2 = headers2.size();
            while (i3 < size2) {
                int i6 = i3 + 1;
                String strD2 = headers2.d(i3);
                if (!d(strD2) && e(strD2)) {
                    builder.d(strD2, headers2.h(i3));
                }
                i3 = i6;
            }
            return builder.f();
        }

        private final boolean d(String str) {
            return StringsKt.F(HttpHeaders.CONTENT_LENGTH, str, true) || StringsKt.F(GraphRequest.CONTENT_ENCODING_HEADER, str, true) || StringsKt.F("Content-Type", str, true);
        }

        private final boolean e(String str) {
            return (StringsKt.F("Connection", str, true) || StringsKt.F("Keep-Alive", str, true) || StringsKt.F("Proxy-Authenticate", str, true) || StringsKt.F("Proxy-Authorization", str, true) || StringsKt.F("TE", str, true) || StringsKt.F("Trailers", str, true) || StringsKt.F("Transfer-Encoding", str, true) || StringsKt.F("Upgrade", str, true)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Response f(Response response) {
            return (response == null ? null : response.a()) != null ? response.F().b(null).c() : response;
        }

        private Companion() {
        }
    }

    public CacheInterceptor(Cache cache) {
        this.f144286a = cache;
    }

    private final Response b(final CacheRequest cacheRequest, Response response) {
        if (cacheRequest == null) {
            return response;
        }
        Sink sinkBody = cacheRequest.body();
        ResponseBody responseBodyA = response.a();
        Intrinsics.checkNotNull(responseBodyA);
        final BufferedSource bufferedSourceK = responseBodyA.k();
        final BufferedSink bufferedSinkC = Okio.c(sinkBody);
        Source source = new Source() { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f144287a;

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                if (!this.f144287a && !Util.s(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f144287a = true;
                    cacheRequest.abort();
                }
                bufferedSourceK.close();
            }

            @Override // okio.Source
            public long t2(Buffer sink, long j3) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                try {
                    long jT2 = bufferedSourceK.t2(sink, j3);
                    if (jT2 != -1) {
                        sink.j(bufferedSinkC.u(), sink.size() - jT2, jT2);
                        bufferedSinkC.o0();
                        return jT2;
                    }
                    if (!this.f144287a) {
                        this.f144287a = true;
                        bufferedSinkC.close();
                    }
                    return -1L;
                } catch (IOException e3) {
                    if (this.f144287a) {
                        throw e3;
                    }
                    this.f144287a = true;
                    cacheRequest.abort();
                    throw e3;
                }
            }

            @Override // okio.Source
            public Timeout v() {
                return bufferedSourceK.v();
            }
        };
        return response.F().b(new RealResponseBody(Response.n(response, "Content-Type", null, 2, null), response.a().f(), Okio.d(source))).c();
    }

    @Override // okhttp3.Interceptor
    public Response a(Interceptor.Chain chain) {
        ResponseBody responseBodyA;
        ResponseBody responseBodyA2;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Call call = chain.call();
        Cache cache = this.f144286a;
        Response responseB = cache == null ? null : cache.b(chain.l());
        CacheStrategy cacheStrategyB = new CacheStrategy.Factory(System.currentTimeMillis(), chain.l(), responseB).b();
        Request requestB = cacheStrategyB.b();
        Response responseA = cacheStrategyB.a();
        Cache cache2 = this.f144286a;
        if (cache2 != null) {
            cache2.n(cacheStrategyB);
        }
        RealCall realCall = call instanceof RealCall ? (RealCall) call : null;
        EventListener eventListenerP = realCall != null ? realCall.p() : null;
        if (eventListenerP == null) {
            eventListenerP = EventListener.f144066b;
        }
        if (responseB != null && responseA == null && (responseBodyA2 = responseB.a()) != null) {
            Util.m(responseBodyA2);
        }
        if (requestB == null && responseA == null) {
            Response responseC = new Response.Builder().s(chain.l()).q(Protocol.HTTP_1_1).g(504).n("Unsatisfiable Request (only-if-cached)").b(Util.f144276c).t(-1L).r(System.currentTimeMillis()).c();
            eventListenerP.A(call, responseC);
            return responseC;
        }
        if (requestB == null) {
            Intrinsics.checkNotNull(responseA);
            Response responseC2 = responseA.F().d(f144285b.f(responseA)).c();
            eventListenerP.b(call, responseC2);
            return responseC2;
        }
        if (responseA != null) {
            eventListenerP.a(call, responseA);
        } else if (this.f144286a != null) {
            eventListenerP.c(call);
        }
        try {
            Response responseA2 = chain.a(requestB);
            if (responseA2 == null && responseB != null && responseBodyA != null) {
            }
            if (responseA != null) {
                if (responseA2 != null && responseA2.i() == 304) {
                    Response.Builder builderF = responseA.F();
                    Companion companion = f144285b;
                    Response responseC3 = builderF.l(companion.c(responseA.r(), responseA2.r())).t(responseA2.O()).r(responseA2.M()).d(companion.f(responseA)).o(companion.f(responseA2)).c();
                    ResponseBody responseBodyA3 = responseA2.a();
                    Intrinsics.checkNotNull(responseBodyA3);
                    responseBodyA3.close();
                    Cache cache3 = this.f144286a;
                    Intrinsics.checkNotNull(cache3);
                    cache3.m();
                    this.f144286a.r(responseA, responseC3);
                    eventListenerP.b(call, responseC3);
                    return responseC3;
                }
                ResponseBody responseBodyA4 = responseA.a();
                if (responseBodyA4 != null) {
                    Util.m(responseBodyA4);
                }
            }
            Intrinsics.checkNotNull(responseA2);
            Response.Builder builderF2 = responseA2.F();
            Companion companion2 = f144285b;
            Response responseC4 = builderF2.d(companion2.f(responseA)).o(companion2.f(responseA2)).c();
            if (this.f144286a != null) {
                if (okhttp3.internal.http.HttpHeaders.b(responseC4) && CacheStrategy.f144291c.a(responseC4, requestB)) {
                    Response responseB2 = b(this.f144286a.i(responseC4), responseC4);
                    if (responseA != null) {
                        eventListenerP.c(call);
                    }
                    return responseB2;
                }
                if (HttpMethod.f144520a.a(requestB.h())) {
                    try {
                        this.f144286a.j(requestB);
                    } catch (IOException unused) {
                    }
                }
            }
            return responseC4;
        } finally {
            if (responseB != null && (responseBodyA = responseB.a()) != null) {
                Util.m(responseBodyA);
            }
        }
    }
}
