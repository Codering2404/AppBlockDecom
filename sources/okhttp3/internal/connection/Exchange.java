package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.EventListener;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
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
public final class Exchange {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RealCall f144414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EventListener f144415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExchangeFinder f144416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ExchangeCodec f144417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f144418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f144419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RealConnection f144420g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class RequestBodySink extends ForwardingSink {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f144421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f144422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f144423d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f144424f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Exchange f144425g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange this$0, Sink delegate, long j3) {
            super(delegate);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f144425g = this$0;
            this.f144421b = j3;
        }

        private final IOException a(IOException iOException) {
            if (this.f144422c) {
                return iOException;
            }
            this.f144422c = true;
            return this.f144425g.a(this.f144423d, false, true, iOException);
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void H0(Buffer source, long j3) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.f144424f) {
                throw new IllegalStateException("closed");
            }
            long j4 = this.f144421b;
            if (j4 == -1 || this.f144423d + j3 <= j4) {
                try {
                    super.H0(source, j3);
                    this.f144423d += j3;
                    return;
                } catch (IOException e3) {
                    throw a(e3);
                }
            }
            throw new ProtocolException("expected " + this.f144421b + " bytes but received " + (this.f144423d + j3));
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f144424f) {
                return;
            }
            this.f144424f = true;
            long j3 = this.f144421b;
            if (j3 != -1 && this.f144423d != j3) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e3) {
                throw a(e3);
            }
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e3) {
                throw a(e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class ResponseBodySource extends ForwardingSource {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f144426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f144427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f144428d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f144429f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f144430g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Exchange f144431h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange this$0, Source delegate, long j3) {
            super(delegate);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            this.f144431h = this$0;
            this.f144426b = j3;
            this.f144428d = true;
            if (j3 == 0) {
                b(null);
            }
        }

        public final IOException b(IOException iOException) {
            if (this.f144429f) {
                return iOException;
            }
            this.f144429f = true;
            if (iOException == null && this.f144428d) {
                this.f144428d = false;
                this.f144431h.i().w(this.f144431h.g());
            }
            return this.f144431h.a(this.f144427c, true, false, iOException);
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f144430g) {
                return;
            }
            this.f144430g = true;
            try {
                super.close();
                b(null);
            } catch (IOException e3) {
                throw b(e3);
            }
        }

        @Override // okio.ForwardingSource, okio.Source
        public long t2(Buffer sink, long j3) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (this.f144430g) {
                throw new IllegalStateException("closed");
            }
            try {
                long jT2 = a().t2(sink, j3);
                if (this.f144428d) {
                    this.f144428d = false;
                    this.f144431h.i().w(this.f144431h.g());
                }
                if (jT2 == -1) {
                    b(null);
                    return -1L;
                }
                long j4 = this.f144427c + jT2;
                long j5 = this.f144426b;
                if (j5 != -1 && j4 > j5) {
                    throw new ProtocolException("expected " + this.f144426b + " bytes but received " + j4);
                }
                this.f144427c = j4;
                if (j4 == j5) {
                    b(null);
                }
                return jT2;
            } catch (IOException e3) {
                throw b(e3);
            }
        }
    }

    public Exchange(RealCall call, EventListener eventListener, ExchangeFinder finder, ExchangeCodec codec) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(finder, "finder");
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.f144414a = call;
        this.f144415b = eventListener;
        this.f144416c = finder;
        this.f144417d = codec;
        this.f144420g = codec.c();
    }

    private final void u(IOException iOException) {
        this.f144419f = true;
        this.f144416c.h(iOException);
        this.f144417d.c().I(this.f144414a, iOException);
    }

    public final IOException a(long j3, boolean z2, boolean z3, IOException iOException) {
        if (iOException != null) {
            u(iOException);
        }
        if (z3) {
            if (iOException != null) {
                this.f144415b.s(this.f144414a, iOException);
            } else {
                this.f144415b.q(this.f144414a, j3);
            }
        }
        if (z2) {
            if (iOException != null) {
                this.f144415b.x(this.f144414a, iOException);
            } else {
                this.f144415b.v(this.f144414a, j3);
            }
        }
        return this.f144414a.v(this, z3, z2, iOException);
    }

    public final void b() {
        this.f144417d.cancel();
    }

    public final Sink c(Request request, boolean z2) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.f144418e = z2;
        RequestBody requestBodyA = request.a();
        Intrinsics.checkNotNull(requestBodyA);
        long jA = requestBodyA.a();
        this.f144415b.r(this.f144414a);
        return new RequestBodySink(this, this.f144417d.e(request, jA), jA);
    }

    public final void d() {
        this.f144417d.cancel();
        this.f144414a.v(this, true, true, null);
    }

    public final void e() throws IOException {
        try {
            this.f144417d.a();
        } catch (IOException e3) {
            this.f144415b.s(this.f144414a, e3);
            u(e3);
            throw e3;
        }
    }

    public final void f() throws IOException {
        try {
            this.f144417d.h();
        } catch (IOException e3) {
            this.f144415b.s(this.f144414a, e3);
            u(e3);
            throw e3;
        }
    }

    public final RealCall g() {
        return this.f144414a;
    }

    public final RealConnection h() {
        return this.f144420g;
    }

    public final EventListener i() {
        return this.f144415b;
    }

    public final ExchangeFinder j() {
        return this.f144416c;
    }

    public final boolean k() {
        return this.f144419f;
    }

    public final boolean l() {
        return !Intrinsics.areEqual(this.f144416c.d().l().i(), this.f144420g.B().a().l().i());
    }

    public final boolean m() {
        return this.f144418e;
    }

    public final RealWebSocket.Streams n() {
        this.f144414a.B();
        return this.f144417d.c().y(this);
    }

    public final void o() {
        this.f144417d.c().A();
    }

    public final void p() {
        this.f144414a.v(this, true, false, null);
    }

    public final ResponseBody q(Response response) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            String strN = Response.n(response, "Content-Type", null, 2, null);
            long jD = this.f144417d.d(response);
            return new RealResponseBody(strN, jD, Okio.d(new ResponseBodySource(this, this.f144417d.b(response), jD)));
        } catch (IOException e3) {
            this.f144415b.x(this.f144414a, e3);
            u(e3);
            throw e3;
        }
    }

    public final Response.Builder r(boolean z2) throws IOException {
        try {
            Response.Builder builderG = this.f144417d.g(z2);
            if (builderG == null) {
                return builderG;
            }
            builderG.m(this);
            return builderG;
        } catch (IOException e3) {
            this.f144415b.x(this.f144414a, e3);
            u(e3);
            throw e3;
        }
    }

    public final void s(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.f144415b.y(this.f144414a, response);
    }

    public final void t() {
        this.f144415b.z(this.f144414a);
    }

    public final void v() {
        a(-1L, true, true, null);
    }

    public final void w(Request request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            this.f144415b.u(this.f144414a);
            this.f144417d.f(request);
            this.f144415b.t(this.f144414a, request);
        } catch (IOException e3) {
            this.f144415b.s(this.f144414a, e3);
            u(e3);
            throw e3;
        }
    }
}
