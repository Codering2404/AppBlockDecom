package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

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
public final class Http2Connection implements Closeable {
    public static final Companion D = new Companion(null);
    private static final Settings E;
    private final Http2Writer A;
    private final ReaderRunnable B;
    private final Set C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f144621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Listener f144622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f144623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f144624d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f144625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f144626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f144627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TaskRunner f144628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TaskQueue f144629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final TaskQueue f144630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final TaskQueue f144631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final PushObserver f144632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f144633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f144634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f144635p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f144636q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f144637r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f144638s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Settings f144639t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Settings f144640u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f144641v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f144642w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f144643x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f144644y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Socket f144645z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f144646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TaskRunner f144647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Socket f144648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f144649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public BufferedSource f144650e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public BufferedSink f144651f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Listener f144652g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private PushObserver f144653h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f144654i;

        public Builder(boolean z2, TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            this.f144646a = z2;
            this.f144647b = taskRunner;
            this.f144652g = Listener.f144656b;
            this.f144653h = PushObserver.f144781b;
        }

        public final Http2Connection a() {
            return new Http2Connection(this);
        }

        public final boolean b() {
            return this.f144646a;
        }

        public final String c() {
            String str = this.f144649d;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            return null;
        }

        public final Listener d() {
            return this.f144652g;
        }

        public final int e() {
            return this.f144654i;
        }

        public final PushObserver f() {
            return this.f144653h;
        }

        public final BufferedSink g() {
            BufferedSink bufferedSink = this.f144651f;
            if (bufferedSink != null) {
                return bufferedSink;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sink");
            return null;
        }

        public final Socket h() {
            Socket socket = this.f144648c;
            if (socket != null) {
                return socket;
            }
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            return null;
        }

        public final BufferedSource i() {
            BufferedSource bufferedSource = this.f144650e;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            Intrinsics.throwUninitializedPropertyAccessException("source");
            return null;
        }

        public final TaskRunner j() {
            return this.f144647b;
        }

        public final Builder k(Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            n(listener);
            return this;
        }

        public final Builder l(int i3) {
            o(i3);
            return this;
        }

        public final void m(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f144649d = str;
        }

        public final void n(Listener listener) {
            Intrinsics.checkNotNullParameter(listener, "<set-?>");
            this.f144652g = listener;
        }

        public final void o(int i3) {
            this.f144654i = i3;
        }

        public final void p(BufferedSink bufferedSink) {
            Intrinsics.checkNotNullParameter(bufferedSink, "<set-?>");
            this.f144651f = bufferedSink;
        }

        public final void q(Socket socket) {
            Intrinsics.checkNotNullParameter(socket, "<set-?>");
            this.f144648c = socket;
        }

        public final void r(BufferedSource bufferedSource) {
            Intrinsics.checkNotNullParameter(bufferedSource, "<set-?>");
            this.f144650e = bufferedSource;
        }

        public final Builder s(Socket socket, String peerName, BufferedSource source, BufferedSink sink) {
            String strStringPlus;
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            q(socket);
            if (b()) {
                strStringPlus = Util.f144282i + ' ' + peerName;
            } else {
                strStringPlus = Intrinsics.stringPlus("MockWebServer ", peerName);
            }
            m(strStringPlus);
            r(source);
            p(sink);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Settings a() {
            return Http2Connection.E;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f144655a = new Companion(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Listener f144656b = new Listener() { // from class: okhttp3.internal.http2.Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void c(Http2Stream stream) {
                Intrinsics.checkNotNullParameter(stream, "stream");
                stream.d(ErrorCode.REFUSED_STREAM, null);
            }
        };

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public void b(Http2Connection connection, Settings settings) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        public abstract void c(Http2Stream http2Stream);
    }

    static {
        Settings settings = new Settings();
        settings.h(7, 65535);
        settings.h(5, 16384);
        E = settings;
    }

    public Http2Connection(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        boolean zB = builder.b();
        this.f144621a = zB;
        this.f144622b = builder.d();
        this.f144623c = new LinkedHashMap();
        String strC = builder.c();
        this.f144624d = strC;
        this.f144626g = builder.b() ? 3 : 2;
        TaskRunner taskRunnerJ = builder.j();
        this.f144628i = taskRunnerJ;
        TaskQueue taskQueueI = taskRunnerJ.i();
        this.f144629j = taskQueueI;
        this.f144630k = taskRunnerJ.i();
        this.f144631l = taskRunnerJ.i();
        this.f144632m = builder.f();
        Settings settings = new Settings();
        if (builder.b()) {
            settings.h(7, 16777216);
        }
        this.f144639t = settings;
        this.f144640u = E;
        this.f144644y = r2.c();
        this.f144645z = builder.h();
        this.A = new Http2Writer(builder.g(), zB);
        this.B = new ReaderRunnable(this, new Http2Reader(builder.i(), zB));
        this.C = new LinkedHashSet();
        if (builder.e() != 0) {
            final long nanos = TimeUnit.MILLISECONDS.toNanos(builder.e());
            final String strStringPlus = Intrinsics.stringPlus(strC, " ping");
            taskQueueI.i(new Task(strStringPlus, this, nanos) { // from class: okhttp3.internal.http2.Http2Connection$special$$inlined$schedule$1

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f144703e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ Http2Connection f144704f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ long f144705g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(strStringPlus, false, 2, null);
                    this.f144703e = strStringPlus;
                    this.f144704f = this;
                    this.f144705g = nanos;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long f() {
                    boolean z2;
                    synchronized (this.f144704f) {
                        if (this.f144704f.f144634o < this.f144704f.f144633n) {
                            z2 = true;
                        } else {
                            this.f144704f.f144633n++;
                            z2 = false;
                        }
                    }
                    if (z2) {
                        this.f144704f.O(null);
                        return -1L;
                    }
                    this.f144704f.c2(false, 1, 0);
                    return this.f144705g;
                }
            }, nanos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        N(errorCode, errorCode, iOException);
    }

    public static /* synthetic */ void T1(Http2Connection http2Connection, boolean z2, TaskRunner taskRunner, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        if ((i3 & 2) != 0) {
            taskRunner = TaskRunner.f144398i;
        }
        http2Connection.S1(z2, taskRunner);
    }

    private final Http2Stream h1(int i3, List list, boolean z2) throws Throwable {
        Throwable th;
        boolean z3 = !z2;
        synchronized (this.A) {
            try {
                try {
                    synchronized (this) {
                        try {
                            if (j0() > 1073741823) {
                                try {
                                    R1(ErrorCode.REFUSED_STREAM);
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            try {
                                if (this.f144627h) {
                                    throw new ConnectionShutdownException();
                                }
                                int iJ0 = j0();
                                L1(j0() + 2);
                                Http2Stream http2Stream = new Http2Stream(iJ0, this, z3, false, null);
                                boolean z4 = !z2 || U0() >= R0() || http2Stream.r() >= http2Stream.q();
                                if (http2Stream.u()) {
                                    O0().put(Integer.valueOf(iJ0), http2Stream);
                                }
                                Unit unit = Unit.f139807a;
                                if (i3 == 0) {
                                    X0().i(z3, iJ0, list);
                                } else {
                                    if (T()) {
                                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                                    }
                                    X0().h(i3, iJ0, list);
                                }
                                if (z4) {
                                    this.A.flush();
                                }
                                return http2Stream;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        th = th;
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                throw th;
            }
        }
    }

    public final synchronized Http2Stream A0(int i3) {
        return (Http2Stream) this.f144623c.get(Integer.valueOf(i3));
    }

    public final boolean A1(int i3) {
        return i3 != 0 && (i3 & 1) == 0;
    }

    public final synchronized Http2Stream B1(int i3) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.f144623c.remove(Integer.valueOf(i3));
        notifyAll();
        return http2Stream;
    }

    public final void I1() {
        synchronized (this) {
            long j3 = this.f144636q;
            long j4 = this.f144635p;
            if (j3 < j4) {
                return;
            }
            this.f144635p = j4 + 1;
            this.f144638s = System.nanoTime() + ((long) 1000000000);
            Unit unit = Unit.f139807a;
            TaskQueue taskQueue = this.f144629j;
            final String strStringPlus = Intrinsics.stringPlus(this.f144624d, " ping");
            final boolean z2 = true;
            taskQueue.i(new Task(strStringPlus, z2, this) { // from class: okhttp3.internal.http2.Http2Connection$sendDegradedPingLater$$inlined$execute$default$1

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f144700e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f144701f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ Http2Connection f144702g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(strStringPlus, z2);
                    this.f144700e = strStringPlus;
                    this.f144701f = z2;
                    this.f144702g = this;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long f() {
                    this.f144702g.c2(false, 2, 0);
                    return -1L;
                }
            }, 0L);
        }
    }

    public final void K1(int i3) {
        this.f144625f = i3;
    }

    public final void L1(int i3) {
        this.f144626g = i3;
    }

    public final void N(ErrorCode connectionCode, ErrorCode streamCode, IOException iOException) {
        int i3;
        Object[] array;
        Intrinsics.checkNotNullParameter(connectionCode, "connectionCode");
        Intrinsics.checkNotNullParameter(streamCode, "streamCode");
        if (Util.f144281h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        try {
            R1(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (O0().isEmpty()) {
                    array = null;
                } else {
                    array = O0().values().toArray(new Http2Stream[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    }
                    O0().clear();
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) array;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.d(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            X0().close();
        } catch (IOException unused3) {
        }
        try {
            z0().close();
        } catch (IOException unused4) {
        }
        this.f144629j.o();
        this.f144630k.o();
        this.f144631l.o();
    }

    public final Map O0() {
        return this.f144623c;
    }

    public final void Q1(Settings settings) {
        Intrinsics.checkNotNullParameter(settings, "<set-?>");
        this.f144640u = settings;
    }

    public final long R0() {
        return this.f144644y;
    }

    public final void R1(ErrorCode statusCode) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        synchronized (this.A) {
            Ref.IntRef intRef = new Ref.IntRef();
            synchronized (this) {
                if (this.f144627h) {
                    return;
                }
                this.f144627h = true;
                intRef.f140142a = e0();
                Unit unit = Unit.f139807a;
                X0().f(intRef.f140142a, statusCode, Util.f144274a);
            }
        }
    }

    public final void S1(boolean z2, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        if (z2) {
            this.A.d0();
            this.A.k(this.f144639t);
            if (this.f144639t.c() != 65535) {
                this.A.e(0, r5 - 65535);
            }
        }
        TaskQueue taskQueueI = taskRunner.i();
        final String str = this.f144624d;
        final ReaderRunnable readerRunnable = this.B;
        final boolean z3 = true;
        taskQueueI.i(new Task(str, z3, readerRunnable) { // from class: okhttp3.internal.concurrent.TaskQueue$execute$1

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f144393e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f144394f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Function0 f144395g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, z3);
                this.f144393e = str;
                this.f144394f = z3;
                this.f144395g = readerRunnable;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long f() {
                this.f144395g.invoke();
                return -1L;
            }
        }, 0L);
    }

    public final boolean T() {
        return this.f144621a;
    }

    public final long U0() {
        return this.f144643x;
    }

    public final String V() {
        return this.f144624d;
    }

    public final synchronized void V1(long j3) {
        long j4 = this.f144641v + j3;
        this.f144641v = j4;
        long j5 = j4 - this.f144642w;
        if (j5 >= this.f144639t.c() / 2) {
            k2(0, j5);
            this.f144642w += j5;
        }
    }

    public final Http2Writer X0() {
        return this.A;
    }

    public final void Y1(int i3, boolean z2, Buffer buffer, long j3) {
        int iMin;
        long j4;
        if (j3 == 0) {
            this.A.k0(z2, i3, buffer, 0);
            return;
        }
        while (j3 > 0) {
            synchronized (this) {
                while (U0() >= R0()) {
                    try {
                        try {
                            if (!O0().containsKey(Integer.valueOf(i3))) {
                                throw new IOException("stream closed");
                            }
                            wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                iMin = Math.min((int) Math.min(j3, R0() - U0()), X0().f1());
                j4 = iMin;
                this.f144643x = U0() + j4;
                Unit unit = Unit.f139807a;
            }
            j3 -= j4;
            this.A.k0(z2 && j3 == 0, i3, buffer, iMin);
        }
    }

    public final synchronized boolean a1(long j3) {
        if (this.f144627h) {
            return false;
        }
        if (this.f144636q < this.f144635p) {
            if (j3 >= this.f144638s) {
                return false;
            }
        }
        return true;
    }

    public final void b2(int i3, boolean z2, List alternating) {
        Intrinsics.checkNotNullParameter(alternating, "alternating");
        this.A.i(z2, i3, alternating);
    }

    public final void c2(boolean z2, int i3, int i4) {
        try {
            this.A.q(z2, i3, i4);
        } catch (IOException e3) {
            O(e3);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        N(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final int e0() {
        return this.f144625f;
    }

    public final void flush() {
        this.A.flush();
    }

    public final Listener g0() {
        return this.f144622b;
    }

    public final void g2(int i3, ErrorCode statusCode) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        this.A.j(i3, statusCode);
    }

    public final void h2(final int i3, final ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        TaskQueue taskQueue = this.f144629j;
        final String str = this.f144624d + '[' + i3 + "] writeSynReset";
        final boolean z2 = true;
        taskQueue.i(new Task(str, z2, this, i3, errorCode) { // from class: okhttp3.internal.http2.Http2Connection$writeSynResetLater$$inlined$execute$default$1

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f144706e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f144707f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Http2Connection f144708g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f144709h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ ErrorCode f144710i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, z2);
                this.f144706e = str;
                this.f144707f = z2;
                this.f144708g = this;
                this.f144709h = i3;
                this.f144710i = errorCode;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long f() {
                try {
                    this.f144708g.g2(this.f144709h, this.f144710i);
                    return -1L;
                } catch (IOException e3) {
                    this.f144708g.O(e3);
                    return -1L;
                }
            }
        }, 0L);
    }

    public final Http2Stream i1(List requestHeaders, boolean z2) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        return h1(0, requestHeaders, z2);
    }

    public final int j0() {
        return this.f144626g;
    }

    public final void k2(final int i3, final long j3) {
        TaskQueue taskQueue = this.f144629j;
        final String str = this.f144624d + '[' + i3 + "] windowUpdate";
        final boolean z2 = true;
        taskQueue.i(new Task(str, z2, this, i3, j3) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f144711e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f144712f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Http2Connection f144713g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f144714h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ long f144715i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, z2);
                this.f144711e = str;
                this.f144712f = z2;
                this.f144713g = this;
                this.f144714h = i3;
                this.f144715i = j3;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long f() {
                try {
                    this.f144713g.X0().e(this.f144714h, this.f144715i);
                    return -1L;
                } catch (IOException e3) {
                    this.f144713g.O(e3);
                    return -1L;
                }
            }
        }, 0L);
    }

    public final void o1(final int i3, BufferedSource source, final int i4, final boolean z2) {
        Intrinsics.checkNotNullParameter(source, "source");
        final Buffer buffer = new Buffer();
        long j3 = i4;
        source.g1(j3);
        source.t2(buffer, j3);
        TaskQueue taskQueue = this.f144630k;
        final String str = this.f144624d + '[' + i3 + "] onData";
        final boolean z3 = true;
        taskQueue.i(new Task(str, z3, this, i3, buffer, i4, z2) { // from class: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$default$1

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f144677e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f144678f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Http2Connection f144679g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f144680h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ Buffer f144681i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ int f144682j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ boolean f144683k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, z3);
                this.f144677e = str;
                this.f144678f = z3;
                this.f144679g = this;
                this.f144680h = i3;
                this.f144681i = buffer;
                this.f144682j = i4;
                this.f144683k = z2;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long f() {
                try {
                    boolean zC = this.f144679g.f144632m.c(this.f144680h, this.f144681i, this.f144682j, this.f144683k);
                    if (zC) {
                        this.f144679g.X0().j(this.f144680h, ErrorCode.CANCEL);
                    }
                    if (!zC && !this.f144683k) {
                        return -1L;
                    }
                    synchronized (this.f144679g) {
                        this.f144679g.C.remove(Integer.valueOf(this.f144680h));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
            }
        }, 0L);
    }

    public final Settings q0() {
        return this.f144639t;
    }

    public final void t1(final int i3, final List requestHeaders, final boolean z2) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        TaskQueue taskQueue = this.f144630k;
        final String str = this.f144624d + '[' + i3 + "] onHeaders";
        final boolean z3 = true;
        taskQueue.i(new Task(str, z3, this, i3, requestHeaders, z2) { // from class: okhttp3.internal.http2.Http2Connection$pushHeadersLater$$inlined$execute$default$1

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f144684e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f144685f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Http2Connection f144686g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f144687h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ List f144688i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ boolean f144689j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, z3);
                this.f144684e = str;
                this.f144685f = z3;
                this.f144686g = this;
                this.f144687h = i3;
                this.f144688i = requestHeaders;
                this.f144689j = z2;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long f() {
                boolean zB = this.f144686g.f144632m.b(this.f144687h, this.f144688i, this.f144689j);
                if (zB) {
                    try {
                        this.f144686g.X0().j(this.f144687h, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
                if (!zB && !this.f144689j) {
                    return -1L;
                }
                synchronized (this.f144686g) {
                    this.f144686g.C.remove(Integer.valueOf(this.f144687h));
                }
                return -1L;
            }
        }, 0L);
    }

    public final void u1(final int i3, final List requestHeaders) throws Throwable {
        Throwable th;
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        synchronized (this) {
            try {
                if (!this.C.contains(Integer.valueOf(i3))) {
                    this.C.add(Integer.valueOf(i3));
                    TaskQueue taskQueue = this.f144630k;
                    final String str = this.f144624d + '[' + i3 + "] onRequest";
                    final boolean z2 = true;
                    taskQueue.i(new Task(str, z2, this, i3, requestHeaders) { // from class: okhttp3.internal.http2.Http2Connection$pushRequestLater$$inlined$execute$default$1

                        /* JADX INFO: renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f144690e;

                        /* JADX INFO: renamed from: f, reason: collision with root package name */
                        final /* synthetic */ boolean f144691f;

                        /* JADX INFO: renamed from: g, reason: collision with root package name */
                        final /* synthetic */ Http2Connection f144692g;

                        /* JADX INFO: renamed from: h, reason: collision with root package name */
                        final /* synthetic */ int f144693h;

                        /* JADX INFO: renamed from: i, reason: collision with root package name */
                        final /* synthetic */ List f144694i;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(str, z2);
                            this.f144690e = str;
                            this.f144691f = z2;
                            this.f144692g = this;
                            this.f144693h = i3;
                            this.f144694i = requestHeaders;
                        }

                        @Override // okhttp3.internal.concurrent.Task
                        public long f() {
                            if (!this.f144692g.f144632m.a(this.f144693h, this.f144694i)) {
                                return -1L;
                            }
                            try {
                                this.f144692g.X0().j(this.f144693h, ErrorCode.CANCEL);
                                synchronized (this.f144692g) {
                                    this.f144692g.C.remove(Integer.valueOf(this.f144693h));
                                }
                                return -1L;
                            } catch (IOException unused) {
                                return -1L;
                            }
                        }
                    }, 0L);
                    return;
                }
                try {
                    h2(i3, ErrorCode.PROTOCOL_ERROR);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            throw th;
        }
    }

    public final Settings w0() {
        return this.f144640u;
    }

    public final void w1(final int i3, final ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        TaskQueue taskQueue = this.f144630k;
        final String str = this.f144624d + '[' + i3 + "] onReset";
        final boolean z2 = true;
        taskQueue.i(new Task(str, z2, this, i3, errorCode) { // from class: okhttp3.internal.http2.Http2Connection$pushResetLater$$inlined$execute$default$1

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f144695e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f144696f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Http2Connection f144697g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f144698h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ ErrorCode f144699i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, z2);
                this.f144695e = str;
                this.f144696f = z2;
                this.f144697g = this;
                this.f144698h = i3;
                this.f144699i = errorCode;
            }

            @Override // okhttp3.internal.concurrent.Task
            public long f() {
                this.f144697g.f144632m.d(this.f144698h, this.f144699i);
                synchronized (this.f144697g) {
                    this.f144697g.C.remove(Integer.valueOf(this.f144698h));
                    Unit unit = Unit.f139807a;
                }
                return -1L;
            }
        }, 0L);
    }

    public final Socket z0() {
        return this.f144645z;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class ReaderRunnable implements Http2Reader.Handler, Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Http2Reader f144657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Http2Connection f144658b;

        public ReaderRunnable(Http2Connection this$0, Http2Reader reader) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(reader, "reader");
            this.f144658b = this$0;
            this.f144657a = reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void c(final boolean z2, final Settings settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            TaskQueue taskQueue = this.f144658b.f144629j;
            final String strStringPlus = Intrinsics.stringPlus(this.f144658b.V(), " applyAndAckSettings");
            final boolean z3 = true;
            taskQueue.i(new Task(strStringPlus, z3, this, z2, settings) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f144672e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f144673f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ Http2Connection.ReaderRunnable f144674g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ boolean f144675h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                final /* synthetic */ Settings f144676i;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(strStringPlus, z3);
                    this.f144672e = strStringPlus;
                    this.f144673f = z3;
                    this.f144674g = this;
                    this.f144675h = z2;
                    this.f144676i = settings;
                }

                @Override // okhttp3.internal.concurrent.Task
                public long f() {
                    this.f144674g.u(this.f144675h, this.f144676i);
                    return -1L;
                }
            }, 0L);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void d(boolean z2, int i3, int i4, List headerBlock) {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            if (this.f144658b.A1(i3)) {
                this.f144658b.t1(i3, headerBlock, z2);
                return;
            }
            final Http2Connection http2Connection = this.f144658b;
            synchronized (http2Connection) {
                Http2Stream http2StreamA0 = http2Connection.A0(i3);
                if (http2StreamA0 != null) {
                    Unit unit = Unit.f139807a;
                    http2StreamA0.x(Util.Q(headerBlock), z2);
                    return;
                }
                if (http2Connection.f144627h) {
                    return;
                }
                if (i3 <= http2Connection.e0()) {
                    return;
                }
                if (i3 % 2 == http2Connection.j0() % 2) {
                    return;
                }
                final Http2Stream http2Stream = new Http2Stream(i3, http2Connection, false, z2, Util.Q(headerBlock));
                http2Connection.K1(i3);
                http2Connection.O0().put(Integer.valueOf(i3), http2Stream);
                TaskQueue taskQueueI = http2Connection.f144628i.i();
                final String str = http2Connection.V() + '[' + i3 + "] onStream";
                final boolean z3 = true;
                taskQueueI.i(new Task(str, z3, http2Connection, http2Stream) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$lambda-2$$inlined$execute$default$1

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f144663e;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ boolean f144664f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    final /* synthetic */ Http2Connection f144665g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    final /* synthetic */ Http2Stream f144666h;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(str, z3);
                        this.f144663e = str;
                        this.f144664f = z3;
                        this.f144665g = http2Connection;
                        this.f144666h = http2Stream;
                    }

                    @Override // okhttp3.internal.concurrent.Task
                    public long f() {
                        try {
                            this.f144665g.g0().c(this.f144666h);
                            return -1L;
                        } catch (IOException e3) {
                            Platform.f144818a.g().k(Intrinsics.stringPlus("Http2Connection.Listener failure for ", this.f144665g.V()), 4, e3);
                            try {
                                this.f144666h.d(ErrorCode.PROTOCOL_ERROR, e3);
                                return -1L;
                            } catch (IOException unused) {
                                return -1L;
                            }
                        }
                    }
                }, 0L);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void e(int i3, long j3) {
            if (i3 == 0) {
                Http2Connection http2Connection = this.f144658b;
                synchronized (http2Connection) {
                    http2Connection.f144644y = http2Connection.R0() + j3;
                    http2Connection.notifyAll();
                    Unit unit = Unit.f139807a;
                }
                return;
            }
            Http2Stream http2StreamA0 = this.f144658b.A0(i3);
            if (http2StreamA0 != null) {
                synchronized (http2StreamA0) {
                    http2StreamA0.a(j3);
                    Unit unit2 = Unit.f139807a;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void h(int i3, int i4, List requestHeaders) throws Throwable {
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            this.f144658b.u1(i4, requestHeaders);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() throws Throwable {
            x();
            return Unit.f139807a;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void m(int i3, ErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            if (this.f144658b.A1(i3)) {
                this.f144658b.w1(i3, errorCode);
                return;
            }
            Http2Stream http2StreamB1 = this.f144658b.B1(i3);
            if (http2StreamB1 == null) {
                return;
            }
            http2StreamB1.y(errorCode);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void p(int i3, ErrorCode errorCode, ByteString debugData) {
            int i4;
            Object[] array;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            Intrinsics.checkNotNullParameter(debugData, "debugData");
            debugData.C();
            Http2Connection http2Connection = this.f144658b;
            synchronized (http2Connection) {
                i4 = 0;
                array = http2Connection.O0().values().toArray(new Http2Stream[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                http2Connection.f144627h = true;
                Unit unit = Unit.f139807a;
            }
            Http2Stream[] http2StreamArr = (Http2Stream[]) array;
            int length = http2StreamArr.length;
            while (i4 < length) {
                Http2Stream http2Stream = http2StreamArr[i4];
                i4++;
                if (http2Stream.j() > i3 && http2Stream.t()) {
                    http2Stream.y(ErrorCode.REFUSED_STREAM);
                    this.f144658b.B1(http2Stream.j());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void q(boolean z2, final int i3, final int i4) {
            if (!z2) {
                TaskQueue taskQueue = this.f144658b.f144629j;
                final String strStringPlus = Intrinsics.stringPlus(this.f144658b.V(), " ping");
                final Http2Connection http2Connection = this.f144658b;
                final boolean z3 = true;
                taskQueue.i(new Task(strStringPlus, z3, http2Connection, i3, i4) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$ping$$inlined$execute$default$1

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f144667e;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ boolean f144668f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    final /* synthetic */ Http2Connection f144669g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    final /* synthetic */ int f144670h;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    final /* synthetic */ int f144671i;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(strStringPlus, z3);
                        this.f144667e = strStringPlus;
                        this.f144668f = z3;
                        this.f144669g = http2Connection;
                        this.f144670h = i3;
                        this.f144671i = i4;
                    }

                    @Override // okhttp3.internal.concurrent.Task
                    public long f() {
                        this.f144669g.c2(true, this.f144670h, this.f144671i);
                        return -1L;
                    }
                }, 0L);
                return;
            }
            Http2Connection http2Connection2 = this.f144658b;
            synchronized (http2Connection2) {
                try {
                    if (i3 == 1) {
                        http2Connection2.f144634o++;
                    } else if (i3 != 2) {
                        if (i3 == 3) {
                            http2Connection2.f144637r++;
                            http2Connection2.notifyAll();
                        }
                        Unit unit = Unit.f139807a;
                    } else {
                        http2Connection2.f144636q++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void u(boolean z2, Settings settings) {
            long jC;
            int i3;
            Http2Stream[] http2StreamArr;
            Intrinsics.checkNotNullParameter(settings, "settings");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Http2Writer http2WriterX0 = this.f144658b.X0();
            final Http2Connection http2Connection = this.f144658b;
            synchronized (http2WriterX0) {
                synchronized (http2Connection) {
                    try {
                        Settings settingsW0 = http2Connection.w0();
                        if (!z2) {
                            Settings settings2 = new Settings();
                            settings2.g(settingsW0);
                            settings2.g(settings);
                            settings = settings2;
                        }
                        objectRef.f140144a = settings;
                        jC = ((long) settings.c()) - ((long) settingsW0.c());
                        i3 = 0;
                        if (jC == 0 || http2Connection.O0().isEmpty()) {
                            http2StreamArr = null;
                        } else {
                            Object[] array = http2Connection.O0().values().toArray(new Http2Stream[0]);
                            if (array == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            }
                            http2StreamArr = (Http2Stream[]) array;
                        }
                        http2Connection.Q1((Settings) objectRef.f140144a);
                        TaskQueue taskQueue = http2Connection.f144631l;
                        final String strStringPlus = Intrinsics.stringPlus(http2Connection.V(), " onSettings");
                        final boolean z3 = true;
                        taskQueue.i(new Task(strStringPlus, z3, http2Connection, objectRef) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$lambda-7$lambda-6$$inlined$execute$default$1

                            /* JADX INFO: renamed from: e, reason: collision with root package name */
                            final /* synthetic */ String f144659e;

                            /* JADX INFO: renamed from: f, reason: collision with root package name */
                            final /* synthetic */ boolean f144660f;

                            /* JADX INFO: renamed from: g, reason: collision with root package name */
                            final /* synthetic */ Http2Connection f144661g;

                            /* JADX INFO: renamed from: h, reason: collision with root package name */
                            final /* synthetic */ Ref.ObjectRef f144662h;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(strStringPlus, z3);
                                this.f144659e = strStringPlus;
                                this.f144660f = z3;
                                this.f144661g = http2Connection;
                                this.f144662h = objectRef;
                            }

                            @Override // okhttp3.internal.concurrent.Task
                            public long f() {
                                this.f144661g.g0().b(this.f144661g, (Settings) this.f144662h.f140144a);
                                return -1L;
                            }
                        }, 0L);
                        Unit unit = Unit.f139807a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    http2Connection.X0().a((Settings) objectRef.f140144a);
                } catch (IOException e3) {
                    http2Connection.O(e3);
                }
                Unit unit2 = Unit.f139807a;
            }
            if (http2StreamArr != null) {
                int length = http2StreamArr.length;
                while (i3 < length) {
                    Http2Stream http2Stream = http2StreamArr[i3];
                    i3++;
                    synchronized (http2Stream) {
                        http2Stream.a(jC);
                        Unit unit3 = Unit.f139807a;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, okhttp3.internal.http2.Http2Reader] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void x() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e3 = null;
            try {
                try {
                    this.f144657a.c(this);
                    while (this.f144657a.b(false, this)) {
                    }
                    ErrorCode errorCode3 = ErrorCode.NO_ERROR;
                    try {
                        this.f144658b.N(errorCode3, ErrorCode.CANCEL, null);
                        errorCode = errorCode3;
                    } catch (IOException e4) {
                        e3 = e4;
                        ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                        Http2Connection http2Connection = this.f144658b;
                        http2Connection.N(errorCode4, errorCode4, e3);
                        errorCode = http2Connection;
                    }
                } catch (Throwable th) {
                    th = th;
                    this.f144658b.N(errorCode, errorCode2, e3);
                    Util.m(this.f144657a);
                    throw th;
                }
            } catch (IOException e5) {
                e3 = e5;
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode2;
                this.f144658b.N(errorCode, errorCode2, e3);
                Util.m(this.f144657a);
                throw th;
            }
            errorCode2 = this.f144657a;
            Util.m(errorCode2);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void z(boolean z2, int i3, BufferedSource source, int i4) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.f144658b.A1(i3)) {
                this.f144658b.o1(i3, source, i4, z2);
                return;
            }
            Http2Stream http2StreamA0 = this.f144658b.A0(i3);
            if (http2StreamA0 == null) {
                this.f144658b.h2(i3, ErrorCode.PROTOCOL_ERROR);
                long j3 = i4;
                this.f144658b.V1(j3);
                source.skip(j3);
                return;
            }
            http2StreamA0.w(source, i4);
            if (z2) {
                http2StreamA0.x(Util.f144275b, true);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void y() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void A(int i3, int i4, int i5, boolean z2) {
        }
    }
}
