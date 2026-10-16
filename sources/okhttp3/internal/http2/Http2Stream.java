package okhttp3.internal.http2;

import androidx.glance.session.ecY.lisODU;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
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
public final class Http2Stream {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f144737o = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f144738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Http2Connection f144739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f144740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f144741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f144742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f144743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayDeque f144744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f144745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final FramingSource f144746i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final FramingSink f144747j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final StreamTimeout f144748k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final StreamTimeout f144749l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ErrorCode f144750m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private IOException f144751n;

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
    public final class FramingSink implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f144752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Buffer f144753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Headers f144754c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f144755d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Http2Stream f144756f;

        public FramingSink(Http2Stream this$0, boolean z2) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.f144756f = this$0;
            this.f144752a = z2;
            this.f144753b = new Buffer();
        }

        /* JADX WARN: Finally extract failed */
        private final void a(boolean z2) throws IOException {
            long jMin;
            boolean z3;
            Http2Stream http2Stream = this.f144756f;
            synchronized (http2Stream) {
                try {
                    http2Stream.s().x();
                    while (http2Stream.r() >= http2Stream.q() && !c() && !b() && http2Stream.h() == null) {
                        try {
                            http2Stream.F();
                        } catch (Throwable th) {
                            http2Stream.s().E();
                            throw th;
                        }
                    }
                    http2Stream.s().E();
                    http2Stream.c();
                    jMin = Math.min(http2Stream.q() - http2Stream.r(), this.f144753b.size());
                    http2Stream.D(http2Stream.r() + jMin);
                    z3 = z2 && jMin == this.f144753b.size();
                    Unit unit = Unit.f139807a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.f144756f.s().x();
            try {
                this.f144756f.g().Y1(this.f144756f.j(), z3, this.f144753b, jMin);
            } finally {
                this.f144756f.s().E();
            }
        }

        @Override // okio.Sink
        public void H0(Buffer source, long j3) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            Http2Stream http2Stream = this.f144756f;
            if (!Util.f144281h || !Thread.holdsLock(http2Stream)) {
                this.f144753b.H0(source, j3);
                while (this.f144753b.size() >= 16384) {
                    a(false);
                }
            } else {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
        }

        public final boolean b() {
            return this.f144755d;
        }

        public final boolean c() {
            return this.f144752a;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream http2Stream = this.f144756f;
            if (Util.f144281h && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = this.f144756f;
            synchronized (http2Stream2) {
                if (b()) {
                    return;
                }
                boolean z2 = http2Stream2.h() == null;
                Unit unit = Unit.f139807a;
                if (!this.f144756f.o().f144752a) {
                    boolean z3 = this.f144753b.size() > 0;
                    if (this.f144754c != null) {
                        while (this.f144753b.size() > 0) {
                            a(false);
                        }
                        Http2Connection http2ConnectionG = this.f144756f.g();
                        int iJ = this.f144756f.j();
                        Headers headers = this.f144754c;
                        Intrinsics.checkNotNull(headers);
                        http2ConnectionG.b2(iJ, z2, Util.P(headers));
                    } else if (z3) {
                        while (this.f144753b.size() > 0) {
                            a(true);
                        }
                    } else if (z2) {
                        this.f144756f.g().Y1(this.f144756f.j(), true, null, 0L);
                    }
                }
                synchronized (this.f144756f) {
                    f(true);
                    Unit unit2 = Unit.f139807a;
                }
                this.f144756f.g().flush();
                this.f144756f.b();
            }
        }

        public final void f(boolean z2) {
            this.f144755d = z2;
        }

        @Override // okio.Sink
        public Timeout v() {
            return this.f144756f.s();
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream http2Stream = this.f144756f;
            if (Util.f144281h && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + lisODU.rfZdlsymNnAzzJN + http2Stream);
            }
            Http2Stream http2Stream2 = this.f144756f;
            synchronized (http2Stream2) {
                http2Stream2.c();
                Unit unit = Unit.f139807a;
            }
            while (this.f144753b.size() > 0) {
                a(false);
                this.f144756f.g().flush();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class FramingSource implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f144757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f144758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Buffer f144759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Buffer f144760d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Headers f144761f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f144762g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Http2Stream f144763h;

        public FramingSource(Http2Stream this$0, long j3, boolean z2) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.f144763h = this$0;
            this.f144757a = j3;
            this.f144758b = z2;
            this.f144759c = new Buffer();
            this.f144760d = new Buffer();
        }

        private final void m(long j3) {
            Http2Stream http2Stream = this.f144763h;
            if (!Util.f144281h || !Thread.holdsLock(http2Stream)) {
                this.f144763h.g().V1(j3);
                return;
            }
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
        }

        public final boolean a() {
            return this.f144762g;
        }

        public final boolean b() {
            return this.f144758b;
        }

        public final Buffer c() {
            return this.f144760d;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            Http2Stream http2Stream = this.f144763h;
            synchronized (http2Stream) {
                j(true);
                size = c().size();
                c().a();
                http2Stream.notifyAll();
                Unit unit = Unit.f139807a;
            }
            if (size > 0) {
                m(size);
            }
            this.f144763h.b();
        }

        public final Buffer f() {
            return this.f144759c;
        }

        public final void i(BufferedSource source, long j3) throws EOFException {
            boolean zB;
            boolean z2;
            long size;
            Intrinsics.checkNotNullParameter(source, "source");
            Http2Stream http2Stream = this.f144763h;
            if (Util.f144281h && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            while (j3 > 0) {
                synchronized (this.f144763h) {
                    zB = b();
                    z2 = c().size() + j3 > this.f144757a;
                    Unit unit = Unit.f139807a;
                }
                if (z2) {
                    source.skip(j3);
                    this.f144763h.f(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (zB) {
                    source.skip(j3);
                    return;
                }
                long jT2 = source.t2(this.f144759c, j3);
                if (jT2 == -1) {
                    throw new EOFException();
                }
                j3 -= jT2;
                Http2Stream http2Stream2 = this.f144763h;
                synchronized (http2Stream2) {
                    try {
                        if (a()) {
                            size = f().size();
                            f().a();
                        } else {
                            boolean z3 = c().size() == 0;
                            c().K0(f());
                            if (z3) {
                                http2Stream2.notifyAll();
                            }
                            size = 0;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (size > 0) {
                    m(size);
                }
            }
        }

        public final void j(boolean z2) {
            this.f144762g = z2;
        }

        public final void k(boolean z2) {
            this.f144758b = z2;
        }

        public final void l(Headers headers) {
            this.f144761f = headers;
        }

        @Override // okio.Source
        public long t2(Buffer sink, long j3) throws IOException {
            IOException iOExceptionI;
            boolean z2;
            long jT2;
            Intrinsics.checkNotNullParameter(sink, "sink");
            long j4 = 0;
            if (j3 < 0) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j3)).toString());
            }
            while (true) {
                Http2Stream http2Stream = this.f144763h;
                synchronized (http2Stream) {
                    http2Stream.m().x();
                    try {
                        if (http2Stream.h() == null || b()) {
                            iOExceptionI = null;
                        } else {
                            iOExceptionI = http2Stream.i();
                            if (iOExceptionI == null) {
                                ErrorCode errorCodeH = http2Stream.h();
                                Intrinsics.checkNotNull(errorCodeH);
                                iOExceptionI = new StreamResetException(errorCodeH);
                            }
                        }
                        if (a()) {
                            throw new IOException("stream closed");
                        }
                        z2 = false;
                        if (c().size() > j4) {
                            jT2 = c().t2(sink, Math.min(j3, c().size()));
                            http2Stream.C(http2Stream.l() + jT2);
                            long jL = http2Stream.l() - http2Stream.k();
                            if (iOExceptionI == null && jL >= http2Stream.g().q0().c() / 2) {
                                http2Stream.g().k2(http2Stream.j(), jL);
                                http2Stream.B(http2Stream.l());
                            }
                        } else {
                            if (!b() && iOExceptionI == null) {
                                http2Stream.F();
                                z2 = true;
                            }
                            jT2 = -1;
                        }
                        http2Stream.m().E();
                        Unit unit = Unit.f139807a;
                    } finally {
                    }
                }
                if (!z2) {
                    if (jT2 != -1) {
                        m(jT2);
                        return jT2;
                    }
                    if (iOExceptionI == null) {
                        return -1L;
                    }
                    throw iOExceptionI;
                }
                j4 = 0;
            }
        }

        @Override // okio.Source
        public Timeout v() {
            return this.f144763h.m();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class StreamTimeout extends AsyncTimeout {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ Http2Stream f144764o;

        public StreamTimeout(Http2Stream this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.f144764o = this$0;
        }

        @Override // okio.AsyncTimeout
        protected void D() {
            this.f144764o.f(ErrorCode.CANCEL);
            this.f144764o.g().I1();
        }

        public final void E() throws IOException {
            if (y()) {
                throw z(null);
            }
        }

        @Override // okio.AsyncTimeout
        protected IOException z(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    public Http2Stream(int i3, Http2Connection connection, boolean z2, boolean z3, Headers headers) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.f144738a = i3;
        this.f144739b = connection;
        this.f144743f = connection.w0().c();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f144744g = arrayDeque;
        this.f144746i = new FramingSource(this, connection.q0().c(), z3);
        this.f144747j = new FramingSink(this, z2);
        this.f144748k = new StreamTimeout(this);
        this.f144749l = new StreamTimeout(this);
        if (headers == null) {
            if (!t()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (t()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(headers);
        }
    }

    private final boolean e(ErrorCode errorCode, IOException iOException) {
        if (Util.f144281h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (h() != null) {
                return false;
            }
            if (p().b() && o().c()) {
                return false;
            }
            z(errorCode);
            A(iOException);
            notifyAll();
            Unit unit = Unit.f139807a;
            this.f144739b.B1(this.f144738a);
            return true;
        }
    }

    public final void A(IOException iOException) {
        this.f144751n = iOException;
    }

    public final void B(long j3) {
        this.f144741d = j3;
    }

    public final void C(long j3) {
        this.f144740c = j3;
    }

    public final void D(long j3) {
        this.f144742e = j3;
    }

    public final synchronized Headers E() {
        Object objRemoveFirst;
        this.f144748k.x();
        while (this.f144744g.isEmpty() && this.f144750m == null) {
            try {
                F();
            } catch (Throwable th) {
                this.f144748k.E();
                throw th;
            }
        }
        this.f144748k.E();
        if (this.f144744g.isEmpty()) {
            IOException iOException = this.f144751n;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.f144750m;
            Intrinsics.checkNotNull(errorCode);
            throw new StreamResetException(errorCode);
        }
        objRemoveFirst = this.f144744g.removeFirst();
        Intrinsics.checkNotNullExpressionValue(objRemoveFirst, "headersQueue.removeFirst()");
        return (Headers) objRemoveFirst;
    }

    public final void F() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final Timeout G() {
        return this.f144749l;
    }

    public final void a(long j3) {
        this.f144743f += j3;
        if (j3 > 0) {
            notifyAll();
        }
    }

    public final void b() {
        boolean z2;
        boolean zU;
        if (Util.f144281h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                z2 = !p().b() && p().a() && (o().c() || o().b());
                zU = u();
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            d(ErrorCode.CANCEL, null);
        } else {
            if (zU) {
                return;
            }
            this.f144739b.B1(this.f144738a);
        }
    }

    public final void c() throws IOException {
        if (this.f144747j.b()) {
            throw new IOException("stream closed");
        }
        if (this.f144747j.c()) {
            throw new IOException("stream finished");
        }
        if (this.f144750m != null) {
            IOException iOException = this.f144751n;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.f144750m;
            Intrinsics.checkNotNull(errorCode);
            throw new StreamResetException(errorCode);
        }
    }

    public final void d(ErrorCode rstStatusCode, IOException iOException) {
        Intrinsics.checkNotNullParameter(rstStatusCode, "rstStatusCode");
        if (e(rstStatusCode, iOException)) {
            this.f144739b.g2(this.f144738a, rstStatusCode);
        }
    }

    public final void f(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (e(errorCode, null)) {
            this.f144739b.h2(this.f144738a, errorCode);
        }
    }

    public final Http2Connection g() {
        return this.f144739b;
    }

    public final synchronized ErrorCode h() {
        return this.f144750m;
    }

    public final IOException i() {
        return this.f144751n;
    }

    public final int j() {
        return this.f144738a;
    }

    public final long k() {
        return this.f144741d;
    }

    public final long l() {
        return this.f144740c;
    }

    public final StreamTimeout m() {
        return this.f144748k;
    }

    public final Sink n() {
        synchronized (this) {
            try {
                if (!this.f144745h && !t()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f144747j;
    }

    public final FramingSink o() {
        return this.f144747j;
    }

    public final FramingSource p() {
        return this.f144746i;
    }

    public final long q() {
        return this.f144743f;
    }

    public final long r() {
        return this.f144742e;
    }

    public final StreamTimeout s() {
        return this.f144749l;
    }

    public final boolean t() {
        return this.f144739b.T() == ((this.f144738a & 1) == 1);
    }

    public final synchronized boolean u() {
        try {
            if (this.f144750m != null) {
                return false;
            }
            if (this.f144746i.b() || this.f144746i.a()) {
                if (this.f144747j.c() || this.f144747j.b()) {
                    if (this.f144745h) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Timeout v() {
        return this.f144748k;
    }

    public final void w(BufferedSource source, int i3) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!Util.f144281h || !Thread.holdsLock(this)) {
            this.f144746i.i(source, i3);
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
    }

    public final void x(Headers headers, boolean z2) {
        boolean zU;
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (Util.f144281h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (this.f144745h && z2) {
                    p().l(headers);
                } else {
                    this.f144745h = true;
                    this.f144744g.add(headers);
                }
                if (z2) {
                    p().k(true);
                }
                zU = u();
                notifyAll();
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zU) {
            return;
        }
        this.f144739b.B1(this.f144738a);
    }

    public final synchronized void y(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.f144750m == null) {
            this.f144750m = errorCode;
            notifyAll();
        }
    }

    public final void z(ErrorCode errorCode) {
        this.f144750m = errorCode;
    }
}
