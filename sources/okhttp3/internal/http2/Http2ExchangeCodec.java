package okhttp3.internal.http2;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
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
public final class Http2ExchangeCodec implements ExchangeCodec {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f144716g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List f144717h = Util.w("connection", DiagnosticsTracker.HOST_KEY, "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final List f144718i = Util.w("connection", DiagnosticsTracker.HOST_KEY, "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RealConnection f144719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RealInterceptorChain f144720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Http2Connection f144721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Http2Stream f144722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Protocol f144723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f144724f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Headers headersF = request.f();
            ArrayList arrayList = new ArrayList(headersF.size() + 4);
            arrayList.add(new Header(Header.f144588g, request.h()));
            arrayList.add(new Header(Header.f144589h, RequestLine.f144533a.c(request.k())));
            String strD = request.d("Host");
            if (strD != null) {
                arrayList.add(new Header(Header.f144591j, strD));
            }
            arrayList.add(new Header(Header.f144590i, request.k().r()));
            int size = headersF.size();
            int i3 = 0;
            while (i3 < size) {
                int i4 = i3 + 1;
                String strD2 = headersF.d(i3);
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = strD2.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!Http2ExchangeCodec.f144717h.contains(lowerCase) || (Intrinsics.areEqual(lowerCase, "te") && Intrinsics.areEqual(headersF.h(i3), "trailers"))) {
                    arrayList.add(new Header(lowerCase, headersF.h(i3)));
                }
                i3 = i4;
            }
            return arrayList;
        }

        public final Response.Builder b(Headers headerBlock, Protocol protocol) throws ProtocolException {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            Headers.Builder builder = new Headers.Builder();
            int size = headerBlock.size();
            StatusLine statusLineA = null;
            int i3 = 0;
            while (i3 < size) {
                int i4 = i3 + 1;
                String strD = headerBlock.d(i3);
                String strH = headerBlock.h(i3);
                if (Intrinsics.areEqual(strD, ":status")) {
                    statusLineA = StatusLine.f144536d.a(Intrinsics.stringPlus("HTTP/1.1 ", strH));
                } else if (!Http2ExchangeCodec.f144718i.contains(strD)) {
                    builder.d(strD, strH);
                }
                i3 = i4;
            }
            if (statusLineA != null) {
                return new Response.Builder().q(protocol).g(statusLineA.f144538b).n(statusLineA.f144539c).l(builder.f());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }

        private Companion() {
        }
    }

    public Http2ExchangeCodec(OkHttpClient client, RealConnection connection, RealInterceptorChain chain, Http2Connection http2Connection) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(http2Connection, "http2Connection");
        this.f144719a = connection;
        this.f144720b = chain;
        this.f144721c = http2Connection;
        List listZ = client.z();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f144723e = listZ.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void a() {
        Http2Stream http2Stream = this.f144722d;
        Intrinsics.checkNotNull(http2Stream);
        http2Stream.n().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source b(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Http2Stream http2Stream = this.f144722d;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream.p();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection c() {
        return this.f144719a;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.f144724f = true;
        Http2Stream http2Stream = this.f144722d;
        if (http2Stream == null) {
            return;
        }
        http2Stream.f(ErrorCode.CANCEL);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long d(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (HttpHeaders.b(response)) {
            return Util.v(response);
        }
        return 0L;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink e(Request request, long j3) {
        Intrinsics.checkNotNullParameter(request, "request");
        Http2Stream http2Stream = this.f144722d;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream.n();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void f(Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.f144722d != null) {
            return;
        }
        this.f144722d = this.f144721c.i1(f144716g.a(request), request.a() != null);
        if (this.f144724f) {
            Http2Stream http2Stream = this.f144722d;
            Intrinsics.checkNotNull(http2Stream);
            http2Stream.f(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        Http2Stream http2Stream2 = this.f144722d;
        Intrinsics.checkNotNull(http2Stream2);
        Timeout timeoutV = http2Stream2.v();
        long jH = this.f144720b.h();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeoutV.h(jH, timeUnit);
        Http2Stream http2Stream3 = this.f144722d;
        Intrinsics.checkNotNull(http2Stream3);
        http2Stream3.G().h(this.f144720b.j(), timeUnit);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder g(boolean z2) throws IOException {
        Http2Stream http2Stream = this.f144722d;
        if (http2Stream == null) {
            throw new IOException("stream wasn't created");
        }
        Response.Builder builderB = f144716g.b(http2Stream.E(), this.f144723e);
        if (z2 && builderB.h() == 100) {
            return null;
        }
        return builderB;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void h() {
        this.f144721c.flush();
    }
}
