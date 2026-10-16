package com.squareup.okhttp.internal.framed;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.api.Api;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.FrameReader;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FramedConnection implements Closeable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final ExecutorService f93146y = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.s("OkHttp FramedConnection", true));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Protocol f93147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f93148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Listener f93149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f93150d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f93151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f93152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f93153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f93154i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f93155j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ExecutorService f93156k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Map f93157l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final PushObserver f93158m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f93159n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    long f93160o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    long f93161p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Settings f93162q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final Settings f93163r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f93164s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final Variant f93165t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final Socket f93166u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final FrameWriter f93167v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final Reader f93168w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Set f93169x;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Socket f93196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f93197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private BufferedSource f93198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private BufferedSink f93199d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Listener f93200e = Listener.f93204a;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Protocol f93201f = Protocol.SPDY_3;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private PushObserver f93202g = PushObserver.f93296a;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f93203h;

        public Builder(boolean z2) {
            this.f93203h = z2;
        }

        public FramedConnection i() {
            return new FramedConnection(this);
        }

        public Builder j(Protocol protocol) {
            this.f93201f = protocol;
            return this;
        }

        public Builder k(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f93196a = socket;
            this.f93197b = str;
            this.f93198c = bufferedSource;
            this.f93199d = bufferedSink;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class Reader extends NamedRunnable implements FrameReader.Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final FrameReader f93205b;

        private void b(final Settings settings) {
            FramedConnection.f93146y.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{FramedConnection.this.f93151f}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Reader.3
                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void a() {
                    try {
                        FramedConnection.this.f93167v.d2(settings);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void B(boolean z2, Settings settings) {
            FramedStream[] framedStreamArr;
            long j3;
            synchronized (FramedConnection.this) {
                try {
                    int iE = FramedConnection.this.f93163r.e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                    if (z2) {
                        FramedConnection.this.f93163r.a();
                    }
                    FramedConnection.this.f93163r.j(settings);
                    if (FramedConnection.this.j0() == Protocol.HTTP_2) {
                        b(settings);
                    }
                    int iE2 = FramedConnection.this.f93163r.e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                    framedStreamArr = null;
                    if (iE2 == -1 || iE2 == iE) {
                        j3 = 0;
                    } else {
                        j3 = iE2 - iE;
                        if (!FramedConnection.this.f93164s) {
                            FramedConnection.this.e0(j3);
                            FramedConnection.this.f93164s = true;
                        }
                        if (!FramedConnection.this.f93150d.isEmpty()) {
                            framedStreamArr = (FramedStream[]) FramedConnection.this.f93150d.values().toArray(new FramedStream[FramedConnection.this.f93150d.size()]);
                        }
                    }
                    FramedConnection.f93146y.execute(new NamedRunnable("OkHttp %s settings", FramedConnection.this.f93151f) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Reader.2
                        @Override // com.squareup.okhttp.internal.NamedRunnable
                        public void a() {
                            FramedConnection.this.f93149c.a(FramedConnection.this);
                        }
                    });
                } finally {
                }
            }
            if (framedStreamArr == null || j3 == 0) {
                return;
            }
            for (FramedStream framedStream : framedStreamArr) {
                synchronized (framedStream) {
                    framedStream.i(j3);
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void C(boolean z2, boolean z3, int i3, int i4, List list, HeadersMode headersMode) {
            if (FramedConnection.this.a1(i3)) {
                FramedConnection.this.R0(i3, list, z3);
                return;
            }
            synchronized (FramedConnection.this) {
                try {
                    if (FramedConnection.this.f93154i) {
                        return;
                    }
                    FramedStream framedStreamQ0 = FramedConnection.this.q0(i3);
                    if (framedStreamQ0 != null) {
                        if (headersMode.d()) {
                            framedStreamQ0.n(ErrorCode.PROTOCOL_ERROR);
                            FramedConnection.this.i1(i3);
                            return;
                        } else {
                            framedStreamQ0.x(list, headersMode);
                            if (z3) {
                                framedStreamQ0.w();
                                return;
                            }
                            return;
                        }
                    }
                    if (headersMode.c()) {
                        FramedConnection.this.K1(i3, ErrorCode.INVALID_STREAM);
                        return;
                    }
                    if (i3 <= FramedConnection.this.f93152g) {
                        return;
                    }
                    if (i3 % 2 == FramedConnection.this.f93153h % 2) {
                        return;
                    }
                    final FramedStream framedStream = new FramedStream(i3, FramedConnection.this, z2, z3, list);
                    FramedConnection.this.f93152g = i3;
                    FramedConnection.this.f93150d.put(Integer.valueOf(i3), framedStream);
                    FramedConnection.f93146y.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{FramedConnection.this.f93151f, Integer.valueOf(i3)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Reader.1
                        @Override // com.squareup.okhttp.internal.NamedRunnable
                        public void a() {
                            try {
                                FramedConnection.this.f93149c.b(framedStream);
                            } catch (IOException e3) {
                                Internal.f93097a.log(Level.INFO, "FramedConnection.Listener failure for " + FramedConnection.this.f93151f, (Throwable) e3);
                                try {
                                    framedStream.l(ErrorCode.PROTOCOL_ERROR);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void D(int i3, ErrorCode errorCode, ByteString byteString) {
            FramedStream[] framedStreamArr;
            byteString.C();
            synchronized (FramedConnection.this) {
                framedStreamArr = (FramedStream[]) FramedConnection.this.f93150d.values().toArray(new FramedStream[FramedConnection.this.f93150d.size()]);
                FramedConnection.this.f93154i = true;
            }
            for (FramedStream framedStream : framedStreamArr) {
                if (framedStream.o() > i3 && framedStream.s()) {
                    framedStream.y(ErrorCode.REFUSED_STREAM);
                    FramedConnection.this.i1(framedStream.o());
                }
            }
        }

        @Override // com.squareup.okhttp.internal.NamedRunnable
        protected void a() throws Throwable {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            try {
                try {
                    if (!FramedConnection.this.f93148b) {
                        this.f93205b.N0();
                    }
                    while (this.f93205b.y0(this)) {
                    }
                    errorCode2 = ErrorCode.NO_ERROR;
                    try {
                        try {
                            FramedConnection.this.g0(errorCode2, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                            FramedConnection.this.g0(errorCode4, errorCode4);
                        }
                    } catch (Throwable th) {
                        errorCode = errorCode2;
                        th = th;
                        try {
                            FramedConnection.this.g0(errorCode, errorCode3);
                        } catch (IOException unused2) {
                        }
                        Util.c(this.f93205b);
                        throw th;
                    }
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
                errorCode2 = errorCode3;
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode3;
                FramedConnection.this.g0(errorCode, errorCode3);
                Util.c(this.f93205b);
                throw th;
            }
            Util.c(this.f93205b);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void e(int i3, long j3) {
            if (i3 == 0) {
                synchronized (FramedConnection.this) {
                    FramedConnection framedConnection = FramedConnection.this;
                    framedConnection.f93161p += j3;
                    framedConnection.notifyAll();
                }
                return;
            }
            FramedStream framedStreamQ0 = FramedConnection.this.q0(i3);
            if (framedStreamQ0 != null) {
                synchronized (framedStreamQ0) {
                    framedStreamQ0.i(j3);
                }
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void h(int i3, int i4, List list) throws Throwable {
            FramedConnection.this.U0(i4, list);
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void q(boolean z2, int i3, int i4) {
            if (!z2) {
                FramedConnection.this.B1(true, i3, i4, null);
                return;
            }
            Ping pingH1 = FramedConnection.this.h1(i3);
            if (pingH1 != null) {
                pingH1.b();
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void x(int i3, ErrorCode errorCode) {
            if (FramedConnection.this.a1(i3)) {
                FramedConnection.this.X0(i3, errorCode);
                return;
            }
            FramedStream framedStreamI1 = FramedConnection.this.i1(i3);
            if (framedStreamI1 != null) {
                framedStreamI1.y(errorCode);
            }
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void z(boolean z2, int i3, BufferedSource bufferedSource, int i4) throws IOException {
            if (FramedConnection.this.a1(i3)) {
                FramedConnection.this.O0(i3, bufferedSource, i4, z2);
                return;
            }
            FramedStream framedStreamQ0 = FramedConnection.this.q0(i3);
            if (framedStreamQ0 == null) {
                FramedConnection.this.K1(i3, ErrorCode.INVALID_STREAM);
                bufferedSource.skip(i4);
            } else {
                framedStreamQ0.v(bufferedSource, i4);
                if (z2) {
                    framedStreamQ0.w();
                }
            }
        }

        private Reader(FrameReader frameReader) {
            super("OkHttp %s", FramedConnection.this.f93151f);
            this.f93205b = frameReader;
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void y() {
        }

        @Override // com.squareup.okhttp.internal.framed.FrameReader.Handler
        public void A(int i3, int i4, int i5, boolean z2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1(boolean z2, int i3, int i4, Ping ping) {
        synchronized (this.f93167v) {
            if (ping != null) {
                try {
                    ping.c();
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f93167v.q(z2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1(final boolean z2, final int i3, final int i4, final Ping ping) {
        f93146y.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.f93151f, Integer.valueOf(i3), Integer.valueOf(i4)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.3
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void a() {
                try {
                    FramedConnection.this.A1(z2, i3, i4, ping);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(final int i3, BufferedSource bufferedSource, final int i4, final boolean z2) throws IOException {
        final Buffer buffer = new Buffer();
        long j3 = i4;
        bufferedSource.g1(j3);
        bufferedSource.t2(buffer, j3);
        if (buffer.size() == j3) {
            this.f93156k.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.f93151f, Integer.valueOf(i3)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.6
                @Override // com.squareup.okhttp.internal.NamedRunnable
                public void a() {
                    try {
                        boolean zC = FramedConnection.this.f93158m.c(i3, buffer, i4, z2);
                        if (zC) {
                            FramedConnection.this.f93167v.x(i3, ErrorCode.CANCEL);
                        }
                        if (zC || z2) {
                            synchronized (FramedConnection.this) {
                                FramedConnection.this.f93169x.remove(Integer.valueOf(i3));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
        } else {
            throw new IOException(buffer.size() + " != " + i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(final int i3, final List list, final boolean z2) {
        this.f93156k.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.f93151f, Integer.valueOf(i3)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.5
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void a() {
                boolean zB = FramedConnection.this.f93158m.b(i3, list, z2);
                if (zB) {
                    try {
                        FramedConnection.this.f93167v.x(i3, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (zB || z2) {
                    synchronized (FramedConnection.this) {
                        FramedConnection.this.f93169x.remove(Integer.valueOf(i3));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:19:0x0041
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public void U0(final int r8, final java.util.List r9) throws java.lang.Throwable {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.Set r0 = r7.f93169x     // Catch: java.lang.Throwable -> L3c
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L3c
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L3c
            if (r0 == 0) goto L18
            com.squareup.okhttp.internal.framed.ErrorCode r9 = com.squareup.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR     // Catch: java.lang.Throwable -> L14
            r7.K1(r8, r9)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L14
            return
        L14:
            r0 = move-exception
            r8 = r0
            r2 = r7
            goto L3f
        L18:
            java.util.Set r0 = r7.f93169x     // Catch: java.lang.Throwable -> L3c
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L3c
            r0.add(r1)     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L3c
            java.util.concurrent.ExecutorService r0 = r7.f93156k
            com.squareup.okhttp.internal.framed.FramedConnection$4 r1 = new com.squareup.okhttp.internal.framed.FramedConnection$4
            java.lang.String r3 = "OkHttp %s Push Request[%s]"
            java.lang.String r2 = r7.f93151f
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            java.lang.Object[] r4 = new java.lang.Object[]{r2, r4}
            r2 = r7
            r5 = r8
            r6 = r9
            r1.<init>(r3, r4)
            r0.execute(r1)
            return
        L3c:
            r0 = move-exception
            r2 = r7
        L3e:
            r8 = r0
        L3f:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L41
            throw r8
        L41:
            r0 = move-exception
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.framed.FramedConnection.U0(int, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(final int i3, final ErrorCode errorCode) {
        this.f93156k.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.f93151f, Integer.valueOf(i3)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.7
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void a() {
                FramedConnection.this.f93158m.d(i3, errorCode);
                synchronized (FramedConnection.this) {
                    FramedConnection.this.f93169x.remove(Integer.valueOf(i3));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a1(int i3) {
        return this.f93147a == Protocol.HTTP_2 && i3 != 0 && (i3 & 1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        int i3;
        FramedStream[] framedStreamArr;
        Ping[] pingArr = null;
        try {
            u1(errorCode);
            e = null;
        } catch (IOException e3) {
            e = e3;
        }
        synchronized (this) {
            try {
                if (this.f93150d.isEmpty()) {
                    framedStreamArr = null;
                } else {
                    framedStreamArr = (FramedStream[]) this.f93150d.values().toArray(new FramedStream[this.f93150d.size()]);
                    this.f93150d.clear();
                    t1(false);
                }
                Map map = this.f93157l;
                if (map != null) {
                    Ping[] pingArr2 = (Ping[]) map.values().toArray(new Ping[this.f93157l.size()]);
                    this.f93157l = null;
                    pingArr = pingArr2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (framedStreamArr != null) {
            for (FramedStream framedStream : framedStreamArr) {
                try {
                    framedStream.l(errorCode2);
                } catch (IOException e4) {
                    if (e != null) {
                        e = e4;
                    }
                }
            }
        }
        if (pingArr != null) {
            for (Ping ping : pingArr) {
                ping.a();
            }
        }
        try {
            this.f93167v.close();
        } catch (IOException e5) {
            if (e == null) {
                e = e5;
            }
        }
        try {
            this.f93166u.close();
        } catch (IOException e6) {
            e = e6;
        }
        if (e != null) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Ping h1(int i3) {
        Map map;
        map = this.f93157l;
        return map != null ? (Ping) map.remove(Integer.valueOf(i3)) : null;
    }

    private synchronized void t1(boolean z2) {
        long jNanoTime;
        if (z2) {
            try {
                jNanoTime = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            jNanoTime = Long.MAX_VALUE;
        }
        this.f93155j = jNanoTime;
    }

    private FramedStream z0(int i3, List list, boolean z2, boolean z3) throws Throwable {
        boolean z4 = !z2;
        boolean z5 = !z3;
        synchronized (this.f93167v) {
            try {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                synchronized (this) {
                    try {
                        if (this.f93154i) {
                            throw new IOException("shutdown");
                        }
                        int i4 = this.f93153h;
                        this.f93153h = i4 + 2;
                        try {
                            FramedStream framedStream = new FramedStream(i4, this, z4, z5, list);
                            if (framedStream.t()) {
                                this.f93150d.put(Integer.valueOf(i4), framedStream);
                                t1(false);
                            }
                            if (i3 == 0) {
                                this.f93167v.y2(z4, z5, i4, i3, list);
                            } else {
                                if (this.f93148b) {
                                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                                }
                                this.f93167v.h(i3, i4, list);
                            }
                            if (!z2) {
                                this.f93167v.flush();
                            }
                            return framedStream;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    public FramedStream A0(List list, boolean z2, boolean z3) {
        return z0(0, list, z2, z3);
    }

    void I1(int i3, ErrorCode errorCode) {
        this.f93167v.x(i3, errorCode);
    }

    void K1(final int i3, final ErrorCode errorCode) {
        f93146y.submit(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.f93151f, Integer.valueOf(i3)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.1
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void a() {
                try {
                    FramedConnection.this.I1(i3, errorCode);
                } catch (IOException unused) {
                }
            }
        });
    }

    void L1(final int i3, final long j3) {
        f93146y.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.f93151f, Integer.valueOf(i3)}) { // from class: com.squareup.okhttp.internal.framed.FramedConnection.2
            @Override // com.squareup.okhttp.internal.NamedRunnable
            public void a() {
                try {
                    FramedConnection.this.f93167v.e(i3, j3);
                } catch (IOException unused) {
                }
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        g0(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    void e0(long j3) {
        this.f93161p += j3;
        if (j3 > 0) {
            notifyAll();
        }
    }

    public void flush() {
        this.f93167v.flush();
    }

    synchronized FramedStream i1(int i3) {
        FramedStream framedStream;
        try {
            framedStream = (FramedStream) this.f93150d.remove(Integer.valueOf(i3));
            if (framedStream != null && this.f93150d.isEmpty()) {
                t1(true);
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
        return framedStream;
    }

    public Protocol j0() {
        return this.f93147a;
    }

    public void o1() {
        this.f93167v.d0();
        this.f93167v.E2(this.f93162q);
        if (this.f93162q.e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 65536) {
            this.f93167v.e(0, r0 - NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        }
    }

    synchronized FramedStream q0(int i3) {
        return (FramedStream) this.f93150d.get(Integer.valueOf(i3));
    }

    public void u1(ErrorCode errorCode) {
        synchronized (this.f93167v) {
            synchronized (this) {
                if (this.f93154i) {
                    return;
                }
                this.f93154i = true;
                this.f93167v.Y(this.f93152g, errorCode, Util.f93119a);
            }
        }
    }

    public synchronized int w0() {
        return this.f93163r.f(Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.f93167v.f1());
        r6 = r2;
        r8.f93161p -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void w1(int r9, boolean r10, okio.Buffer r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            com.squareup.okhttp.internal.framed.FrameWriter r12 = r8.f93167v
            r12.k0(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r4 = r8.f93161p     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L32
            java.util.Map r2 = r8.f93150d     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r2 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L5e
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L28
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L28
            com.squareup.okhttp.internal.framed.FrameWriter r4 = r8.f93167v     // Catch: java.lang.Throwable -> L28
            int r4 = r4.f1()     // Catch: java.lang.Throwable -> L28
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.f93161p     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.f93161p = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            com.squareup.okhttp.internal.framed.FrameWriter r4 = r8.f93167v
            if (r10 == 0) goto L53
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = r3
        L54:
            r4.k0(r5, r9, r11, r2)
            goto Ld
        L58:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L5e:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.framed.FramedConnection.w1(int, boolean, okio.Buffer, long):void");
    }

    private FramedConnection(Builder builder) {
        this.f93150d = new HashMap();
        this.f93155j = System.nanoTime();
        this.f93160o = 0L;
        this.f93162q = new Settings();
        Settings settings = new Settings();
        this.f93163r = settings;
        this.f93164s = false;
        this.f93169x = new LinkedHashSet();
        Protocol protocol = builder.f93201f;
        this.f93147a = protocol;
        this.f93158m = builder.f93202g;
        boolean z2 = builder.f93203h;
        this.f93148b = z2;
        this.f93149c = builder.f93200e;
        this.f93153h = builder.f93203h ? 1 : 2;
        if (builder.f93203h && protocol == Protocol.HTTP_2) {
            this.f93153h += 2;
        }
        this.f93159n = builder.f93203h ? 1 : 2;
        if (builder.f93203h) {
            this.f93162q.l(7, 0, 16777216);
        }
        String str = builder.f93197b;
        this.f93151f = str;
        if (protocol == Protocol.HTTP_2) {
            this.f93165t = new Http2();
            this.f93156k = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.s(String.format("OkHttp %s Push Observer", str), true));
            settings.l(7, 0, 65535);
            settings.l(5, 0, 16384);
        } else {
            if (protocol != Protocol.SPDY_3) {
                throw new AssertionError(protocol);
            }
            this.f93165t = new Spdy3();
            this.f93156k = null;
        }
        this.f93161p = settings.e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        this.f93166u = builder.f93196a;
        this.f93167v = this.f93165t.b(builder.f93199d, z2);
        Reader reader = new Reader(this.f93165t.a(builder.f93198c, z2));
        this.f93168w = reader;
        new Thread(reader).start();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Listener f93204a = new Listener() { // from class: com.squareup.okhttp.internal.framed.FramedConnection.Listener.1
            @Override // com.squareup.okhttp.internal.framed.FramedConnection.Listener
            public void b(FramedStream framedStream) {
                framedStream.l(ErrorCode.REFUSED_STREAM);
            }
        };

        public abstract void b(FramedStream framedStream);

        public void a(FramedConnection framedConnection) {
        }
    }
}
