package okhttp3.internal.http1;

import com.google.android.gms.common.api.Api;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
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
public final class Http1ExchangeCodec implements ExchangeCodec {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f144543h = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OkHttpClient f144544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RealConnection f144545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BufferedSource f144546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BufferedSink f144547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f144548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HeadersReader f144549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Headers f144550g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private abstract class AbstractSource implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ForwardingTimeout f144551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f144552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Http1ExchangeCodec f144553c;

        public AbstractSource(Http1ExchangeCodec this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.f144553c = this$0;
            this.f144551a = new ForwardingTimeout(this$0.f144546c.v());
        }

        protected final boolean a() {
            return this.f144552b;
        }

        public final void b() {
            if (this.f144553c.f144548e == 6) {
                return;
            }
            if (this.f144553c.f144548e != 5) {
                throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(this.f144553c.f144548e)));
            }
            this.f144553c.r(this.f144551a);
            this.f144553c.f144548e = 6;
        }

        protected final void c(boolean z2) {
            this.f144552b = z2;
        }

        @Override // okio.Source
        public long t2(Buffer sink, long j3) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            try {
                return this.f144553c.f144546c.t2(sink, j3);
            } catch (IOException e3) {
                this.f144553c.c().A();
                b();
                throw e3;
            }
        }

        @Override // okio.Source
        public Timeout v() {
            return this.f144551a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class ChunkedSink implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ForwardingTimeout f144554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f144555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Http1ExchangeCodec f144556c;

        public ChunkedSink(Http1ExchangeCodec this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.f144556c = this$0;
            this.f144554a = new ForwardingTimeout(this$0.f144547d.v());
        }

        @Override // okio.Sink
        public void H0(Buffer source, long j3) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.f144555b) {
                throw new IllegalStateException("closed");
            }
            if (j3 == 0) {
                return;
            }
            this.f144556c.f144547d.e2(j3);
            this.f144556c.f144547d.C0("\r\n");
            this.f144556c.f144547d.H0(source, j3);
            this.f144556c.f144547d.C0("\r\n");
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f144555b) {
                return;
            }
            this.f144555b = true;
            this.f144556c.f144547d.C0("0\r\n\r\n");
            this.f144556c.r(this.f144554a);
            this.f144556c.f144548e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() {
            if (this.f144555b) {
                return;
            }
            this.f144556c.f144547d.flush();
        }

        @Override // okio.Sink
        public Timeout v() {
            return this.f144554a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class ChunkedSource extends AbstractSource {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final HttpUrl f144557d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f144558f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f144559g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Http1ExchangeCodec f144560h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChunkedSource(Http1ExchangeCodec this$0, HttpUrl url) {
            super(this$0);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(url, "url");
            this.f144560h = this$0;
            this.f144557d = url;
            this.f144558f = -1L;
            this.f144559g = true;
        }

        private final void f() throws ProtocolException {
            if (this.f144558f != -1) {
                this.f144560h.f144546c.Q0();
            }
            try {
                this.f144558f = this.f144560h.f144546c.F2();
                String string = StringsKt.t1(this.f144560h.f144546c.Q0()).toString();
                if (this.f144558f < 0 || (string.length() > 0 && !StringsKt.U(string, ";", false, 2, null))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f144558f + string + '\"');
                }
                if (this.f144558f == 0) {
                    this.f144559g = false;
                    Http1ExchangeCodec http1ExchangeCodec = this.f144560h;
                    http1ExchangeCodec.f144550g = http1ExchangeCodec.f144549f.a();
                    OkHttpClient okHttpClient = this.f144560h.f144544a;
                    Intrinsics.checkNotNull(okHttpClient);
                    CookieJar cookieJarO = okHttpClient.o();
                    HttpUrl httpUrl = this.f144557d;
                    Headers headers = this.f144560h.f144550g;
                    Intrinsics.checkNotNull(headers);
                    HttpHeaders.f(cookieJarO, httpUrl, headers);
                    b();
                }
            } catch (NumberFormatException e3) {
                throw new ProtocolException(e3.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a()) {
                return;
            }
            if (this.f144559g && !Util.s(this, 100, TimeUnit.MILLISECONDS)) {
                this.f144560h.c().A();
                b();
            }
            c(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long t2(Buffer sink, long j3) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j3 < 0) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j3)).toString());
            }
            if (a()) {
                throw new IllegalStateException("closed");
            }
            if (!this.f144559g) {
                return -1L;
            }
            long j4 = this.f144558f;
            if (j4 == 0 || j4 == -1) {
                f();
                if (!this.f144559g) {
                    return -1L;
                }
            }
            long jT2 = super.t2(sink, Math.min(j3, this.f144558f));
            if (jT2 != -1) {
                this.f144558f -= jT2;
                return jT2;
            }
            this.f144560h.c().A();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            b();
            throw protocolException;
        }
    }

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
    private final class FixedLengthSource extends AbstractSource {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f144561d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Http1ExchangeCodec f144562f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FixedLengthSource(Http1ExchangeCodec this$0, long j3) {
            super(this$0);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.f144562f = this$0;
            this.f144561d = j3;
            if (j3 == 0) {
                b();
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a()) {
                return;
            }
            if (this.f144561d != 0 && !Util.s(this, 100, TimeUnit.MILLISECONDS)) {
                this.f144562f.c().A();
                b();
            }
            c(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long t2(Buffer sink, long j3) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j3 < 0) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j3)).toString());
            }
            if (a()) {
                throw new IllegalStateException("closed");
            }
            long j4 = this.f144561d;
            if (j4 == 0) {
                return -1L;
            }
            long jT2 = super.t2(sink, Math.min(j4, j3));
            if (jT2 == -1) {
                this.f144562f.c().A();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                b();
                throw protocolException;
            }
            long j5 = this.f144561d - jT2;
            this.f144561d = j5;
            if (j5 == 0) {
                b();
            }
            return jT2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class KnownLengthSink implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ForwardingTimeout f144563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f144564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Http1ExchangeCodec f144565c;

        public KnownLengthSink(Http1ExchangeCodec this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.f144565c = this$0;
            this.f144563a = new ForwardingTimeout(this$0.f144547d.v());
        }

        @Override // okio.Sink
        public void H0(Buffer source, long j3) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.f144564b) {
                throw new IllegalStateException("closed");
            }
            Util.l(source.size(), 0L, j3);
            this.f144565c.f144547d.H0(source, j3);
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f144564b) {
                return;
            }
            this.f144564b = true;
            this.f144565c.r(this.f144563a);
            this.f144565c.f144548e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (this.f144564b) {
                return;
            }
            this.f144565c.f144547d.flush();
        }

        @Override // okio.Sink
        public Timeout v() {
            return this.f144563a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class UnknownLengthSource extends AbstractSource {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f144566d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Http1ExchangeCodec f144567f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownLengthSource(Http1ExchangeCodec this$0) {
            super(this$0);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.f144567f = this$0;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a()) {
                return;
            }
            if (!this.f144566d) {
                b();
            }
            c(true);
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long t2(Buffer sink, long j3) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j3 < 0) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j3)).toString());
            }
            if (a()) {
                throw new IllegalStateException("closed");
            }
            if (this.f144566d) {
                return -1L;
            }
            long jT2 = super.t2(sink, j3);
            if (jT2 != -1) {
                return jT2;
            }
            this.f144566d = true;
            b();
            return -1L;
        }
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, RealConnection connection, BufferedSource source, BufferedSink sink) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f144544a = okHttpClient;
        this.f144545b = connection;
        this.f144546c = source;
        this.f144547d = sink;
        this.f144549f = new HeadersReader(source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(ForwardingTimeout forwardingTimeout) {
        Timeout timeoutK = forwardingTimeout.k();
        forwardingTimeout.l(Timeout.f145128e);
        timeoutK.b();
        timeoutK.c();
    }

    private final boolean s(Request request) {
        return StringsKt.F("chunked", request.d("Transfer-Encoding"), true);
    }

    private final boolean t(Response response) {
        return StringsKt.F("chunked", Response.n(response, "Transfer-Encoding", null, 2, null), true);
    }

    private final Sink u() {
        int i3 = this.f144548e;
        if (i3 != 1) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i3)).toString());
        }
        this.f144548e = 2;
        return new ChunkedSink(this);
    }

    private final Source v(HttpUrl httpUrl) {
        int i3 = this.f144548e;
        if (i3 != 4) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i3)).toString());
        }
        this.f144548e = 5;
        return new ChunkedSource(this, httpUrl);
    }

    private final Source w(long j3) {
        int i3 = this.f144548e;
        if (i3 != 4) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i3)).toString());
        }
        this.f144548e = 5;
        return new FixedLengthSource(this, j3);
    }

    private final Sink x() {
        int i3 = this.f144548e;
        if (i3 != 1) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i3)).toString());
        }
        this.f144548e = 2;
        return new KnownLengthSink(this);
    }

    private final Source y() {
        int i3 = this.f144548e;
        if (i3 != 4) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i3)).toString());
        }
        this.f144548e = 5;
        c().A();
        return new UnknownLengthSource(this);
    }

    public final void A(Headers headers, String requestLine) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        int i3 = this.f144548e;
        if (i3 != 0) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i3)).toString());
        }
        this.f144547d.C0(requestLine).C0("\r\n");
        int size = headers.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f144547d.C0(headers.d(i4)).C0(": ").C0(headers.h(i4)).C0("\r\n");
        }
        this.f144547d.C0("\r\n");
        this.f144548e = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void a() {
        this.f144547d.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source b(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!HttpHeaders.b(response)) {
            return w(0L);
        }
        if (t(response)) {
            return v(response.N().k());
        }
        long jV = Util.v(response);
        return jV != -1 ? w(jV) : y();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection c() {
        return this.f144545b;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        c().e();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long d(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (!HttpHeaders.b(response)) {
            return 0L;
        }
        if (t(response)) {
            return -1L;
        }
        return Util.v(response);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink e(Request request, long j3) throws ProtocolException {
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.a() != null && request.a().e()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (s(request)) {
            return u();
        }
        if (j3 != -1) {
            return x();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void f(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        RequestLine requestLine = RequestLine.f144533a;
        Proxy.Type type = c().B().b().type();
        Intrinsics.checkNotNullExpressionValue(type, "connection.route().proxy.type()");
        A(request.f(), requestLine.a(request, type));
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder g(boolean z2) {
        int i3 = this.f144548e;
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            throw new IllegalStateException(Intrinsics.stringPlus("state: ", Integer.valueOf(i3)).toString());
        }
        try {
            StatusLine statusLineA = StatusLine.f144536d.a(this.f144549f.b());
            Response.Builder builderL = new Response.Builder().q(statusLineA.f144537a).g(statusLineA.f144538b).n(statusLineA.f144539c).l(this.f144549f.a());
            if (z2 && statusLineA.f144538b == 100) {
                return null;
            }
            int i4 = statusLineA.f144538b;
            if (i4 == 100) {
                this.f144548e = 3;
                return builderL;
            }
            if (102 > i4 || i4 >= 200) {
                this.f144548e = 4;
                return builderL;
            }
            this.f144548e = 3;
            return builderL;
        } catch (EOFException e3) {
            throw new IOException(Intrinsics.stringPlus("unexpected end of stream on ", c().B().a().l().p()), e3);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void h() {
        this.f144547d.flush();
    }

    public final void z(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        long jV = Util.v(response);
        if (jV == -1) {
            return;
        }
        Source sourceW = w(jV);
        Util.M(sourceW, Api.BaseClientBuilder.API_PRIORITY_OTHER, TimeUnit.MILLISECONDS);
        sourceW.close();
    }
}
