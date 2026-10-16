package okhttp3;

import java.io.Closeable;
import java.io.EOFException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

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
public final class Response implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Request f144227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Protocol f144228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f144229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f144230d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handshake f144231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Headers f144232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ResponseBody f144233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Response f144234i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Response f144235j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Response f144236k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f144237l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f144238m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Exchange f144239n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CacheControl f144240o;

    public Response(Request request, Protocol protocol, String message, int i3, Handshake handshake, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j3, long j4, Exchange exchange) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.f144227a = request;
        this.f144228b = protocol;
        this.f144229c = message;
        this.f144230d = i3;
        this.f144231f = handshake;
        this.f144232g = headers;
        this.f144233h = responseBody;
        this.f144234i = response;
        this.f144235j = response2;
        this.f144236k = response3;
        this.f144237l = j3;
        this.f144238m = j4;
        this.f144239n = exchange;
    }

    public static /* synthetic */ String n(Response response, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return response.m(str, str2);
    }

    public final Response C() {
        return this.f144234i;
    }

    public final Builder F() {
        return new Builder(this);
    }

    public final ResponseBody J(long j3) throws EOFException {
        ResponseBody responseBody = this.f144233h;
        Intrinsics.checkNotNull(responseBody);
        BufferedSource bufferedSourcePeek = responseBody.k().peek();
        Buffer buffer = new Buffer();
        bufferedSourcePeek.y(j3);
        buffer.U0(bufferedSourcePeek, Math.min(j3, bufferedSourcePeek.u().size()));
        return ResponseBody.f144254b.b(buffer, this.f144233h.i(), buffer.size());
    }

    public final Response K() {
        return this.f144236k;
    }

    public final Protocol L() {
        return this.f144228b;
    }

    public final long M() {
        return this.f144238m;
    }

    public final Request N() {
        return this.f144227a;
    }

    public final long O() {
        return this.f144237l;
    }

    public final ResponseBody a() {
        return this.f144233h;
    }

    public final CacheControl b() {
        CacheControl cacheControl = this.f144240o;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControlB = CacheControl.f143911n.b(this.f144232g);
        this.f144240o = cacheControlB;
        return cacheControlB;
    }

    public final Response c() {
        return this.f144235j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.f144233h;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public final List f() {
        String str;
        Headers headers = this.f144232g;
        int i3 = this.f144230d;
        if (i3 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i3 != 407) {
                return CollectionsKt.emptyList();
            }
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.a(headers, str);
    }

    public final int i() {
        return this.f144230d;
    }

    public final boolean isSuccessful() {
        int i3 = this.f144230d;
        return 200 <= i3 && i3 < 300;
    }

    public final Exchange j() {
        return this.f144239n;
    }

    public final Handshake k() {
        return this.f144231f;
    }

    public final String l(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return n(this, name, null, 2, null);
    }

    public final String m(String name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        String strA = this.f144232g.a(name);
        return strA == null ? str : strA;
    }

    public final Headers r() {
        return this.f144232g;
    }

    public String toString() {
        return "Response{protocol=" + this.f144228b + ", code=" + this.f144230d + ", message=" + this.f144229c + ", url=" + this.f144227a.k() + '}';
    }

    public final String z() {
        return this.f144229c;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Request f144241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Protocol f144242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f144243c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f144244d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Handshake f144245e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Headers.Builder f144246f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ResponseBody f144247g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Response f144248h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Response f144249i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Response f144250j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f144251k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f144252l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Exchange f144253m;

        public Builder() {
            this.f144243c = -1;
            this.f144246f = new Headers.Builder();
        }

        private final void e(Response response) {
            if (response != null && response.a() != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private final void f(String str, Response response) {
            if (response == null) {
                return;
            }
            if (response.a() != null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".body != null").toString());
            }
            if (response.C() != null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".networkResponse != null").toString());
            }
            if (response.c() != null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".cacheResponse != null").toString());
            }
            if (response.K() != null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".priorResponse != null").toString());
            }
        }

        public final void A(Response response) {
            this.f144248h = response;
        }

        public final void B(Response response) {
            this.f144250j = response;
        }

        public final void C(Protocol protocol) {
            this.f144242b = protocol;
        }

        public final void D(long j3) {
            this.f144252l = j3;
        }

        public final void E(Request request) {
            this.f144241a = request;
        }

        public final void F(long j3) {
            this.f144251k = j3;
        }

        public Builder a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            i().a(name, value);
            return this;
        }

        public Builder b(ResponseBody responseBody) {
            u(responseBody);
            return this;
        }

        public Response c() {
            int i3 = this.f144243c;
            if (i3 < 0) {
                throw new IllegalStateException(Intrinsics.stringPlus("code < 0: ", Integer.valueOf(h())).toString());
            }
            Request request = this.f144241a;
            if (request == null) {
                throw new IllegalStateException("request == null");
            }
            Protocol protocol = this.f144242b;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null");
            }
            String str = this.f144244d;
            if (str != null) {
                return new Response(request, protocol, str, i3, this.f144245e, this.f144246f.f(), this.f144247g, this.f144248h, this.f144249i, this.f144250j, this.f144251k, this.f144252l, this.f144253m);
            }
            throw new IllegalStateException("message == null");
        }

        public Builder d(Response response) {
            f("cacheResponse", response);
            v(response);
            return this;
        }

        public Builder g(int i3) {
            w(i3);
            return this;
        }

        public final int h() {
            return this.f144243c;
        }

        public final Headers.Builder i() {
            return this.f144246f;
        }

        public Builder j(Handshake handshake) {
            x(handshake);
            return this;
        }

        public Builder k(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            i().j(name, value);
            return this;
        }

        public Builder l(Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            y(headers.f());
            return this;
        }

        public final void m(Exchange deferredTrailers) {
            Intrinsics.checkNotNullParameter(deferredTrailers, "deferredTrailers");
            this.f144253m = deferredTrailers;
        }

        public Builder n(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            z(message);
            return this;
        }

        public Builder o(Response response) {
            f("networkResponse", response);
            A(response);
            return this;
        }

        public Builder p(Response response) {
            e(response);
            B(response);
            return this;
        }

        public Builder q(Protocol protocol) {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            C(protocol);
            return this;
        }

        public Builder r(long j3) {
            D(j3);
            return this;
        }

        public Builder s(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            E(request);
            return this;
        }

        public Builder t(long j3) {
            F(j3);
            return this;
        }

        public final void u(ResponseBody responseBody) {
            this.f144247g = responseBody;
        }

        public final void v(Response response) {
            this.f144249i = response;
        }

        public final void w(int i3) {
            this.f144243c = i3;
        }

        public final void x(Handshake handshake) {
            this.f144245e = handshake;
        }

        public final void y(Headers.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<set-?>");
            this.f144246f = builder;
        }

        public final void z(String str) {
            this.f144244d = str;
        }

        public Builder(Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.f144243c = -1;
            this.f144241a = response.N();
            this.f144242b = response.L();
            this.f144243c = response.i();
            this.f144244d = response.z();
            this.f144245e = response.k();
            this.f144246f = response.r().f();
            this.f144247g = response.a();
            this.f144248h = response.C();
            this.f144249i = response.c();
            this.f144250j = response.K();
            this.f144251k = response.O();
            this.f144252l = response.M();
            this.f144253m = response.j();
        }
    }
}
