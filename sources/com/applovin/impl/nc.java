package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class nc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f62000d = a(false, -9223372036854775807L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f62001e = a(true, -9223372036854775807L);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f62002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f62003g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f62004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f62005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IOException f62006c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        c a(e eVar, long j3, long j4, IOException iOException, int i3);

        void a(e eVar, long j3, long j4);

        void a(e eVar, long j3, long j4, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f62007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f62008b;

        private c(int i3, long j3) {
            this.f62007a = i3;
            this.f62008b = j3;
        }

        public boolean a() {
            int i3 = this.f62007a;
            return i3 == 0 || i3 == 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface e {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface f {
        void d();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f62019a;

        public g(f fVar) {
            this.f62019a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f62019a.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class h extends IOException {
        public h(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    static {
        long j3 = -9223372036854775807L;
        f62002f = new c(2, j3);
        f62003g = new c(3, j3);
    }

    public nc(String str) {
        this.f62004a = xp.e("ExoPlayer:Loader:" + str);
    }

    public boolean c() {
        return this.f62006c != null;
    }

    public boolean d() {
        return this.f62005b != null;
    }

    public void b() {
        this.f62006c = null;
    }

    public void a() {
        ((d) b1.b(this.f62005b)).a(false);
    }

    public void a(int i3) throws IOException {
        IOException iOException = this.f62006c;
        if (iOException == null) {
            d dVar = this.f62005b;
            if (dVar != null) {
                if (i3 == Integer.MIN_VALUE) {
                    i3 = dVar.f62009a;
                }
                dVar.a(i3);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void a(f fVar) {
        d dVar = this.f62005b;
        if (dVar != null) {
            dVar.a(true);
        }
        if (fVar != null) {
            this.f62004a.execute(new g(fVar));
        }
        this.f62004a.shutdown();
    }

    public long a(e eVar, b bVar, int i3) {
        Looper looper = (Looper) b1.b(Looper.myLooper());
        this.f62006c = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new d(looper, eVar, bVar, i3, jElapsedRealtime).a(0L);
        return jElapsedRealtime;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class d extends Handler implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f62009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f62010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f62011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private b f62012d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private IOException f62013f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f62014g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Thread f62015h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f62016i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private volatile boolean f62017j;

        public d(Looper looper, e eVar, b bVar, int i3, long j3) {
            super(looper);
            this.f62010b = eVar;
            this.f62012d = bVar;
            this.f62009a = i3;
            this.f62011c = j3;
        }

        private void b() {
            nc.this.f62005b = null;
        }

        private long c() {
            return Math.min((this.f62014g - 1) * 1000, 5000);
        }

        public void a(boolean z2) {
            this.f62017j = z2;
            this.f62013f = null;
            if (hasMessages(0)) {
                this.f62016i = true;
                removeMessages(0);
                if (!z2) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    try {
                        this.f62016i = true;
                        this.f62010b.b();
                        Thread thread = this.f62015h;
                        if (thread != null) {
                            thread.interrupt();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (z2) {
                b();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((b) b1.a(this.f62012d)).a(this.f62010b, jElapsedRealtime, jElapsedRealtime - this.f62011c, true);
                this.f62012d = null;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f62017j) {
                return;
            }
            int i3 = message.what;
            if (i3 == 0) {
                a();
                return;
            }
            if (i3 == 3) {
                throw ((Error) message.obj);
            }
            b();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = jElapsedRealtime - this.f62011c;
            b bVar = (b) b1.a(this.f62012d);
            if (this.f62016i) {
                bVar.a(this.f62010b, jElapsedRealtime, j3, false);
                return;
            }
            int i4 = message.what;
            if (i4 == 1) {
                try {
                    bVar.a(this.f62010b, jElapsedRealtime, j3);
                    return;
                } catch (RuntimeException e3) {
                    oc.a("LoadTask", "Unexpected exception handling load completed", e3);
                    nc.this.f62006c = new h(e3);
                    return;
                }
            }
            if (i4 != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f62013f = iOException;
            int i5 = this.f62014g + 1;
            this.f62014g = i5;
            c cVarA = bVar.a(this.f62010b, jElapsedRealtime, j3, iOException, i5);
            if (cVarA.f62007a == 3) {
                nc.this.f62006c = this.f62013f;
            } else if (cVarA.f62007a != 2) {
                if (cVarA.f62007a == 1) {
                    this.f62014g = 1;
                }
                a(cVarA.f62008b != -9223372036854775807L ? cVarA.f62008b : c());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z2;
            try {
                synchronized (this) {
                    z2 = this.f62016i;
                    this.f62015h = Thread.currentThread();
                }
                if (!z2) {
                    ko.a("load:" + this.f62010b.getClass().getSimpleName());
                    try {
                        this.f62010b.a();
                        ko.a();
                    } catch (Throwable th) {
                        ko.a();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.f62015h = null;
                    Thread.interrupted();
                }
                if (this.f62017j) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e3) {
                if (this.f62017j) {
                    return;
                }
                obtainMessage(2, e3).sendToTarget();
            } catch (Error e4) {
                if (!this.f62017j) {
                    oc.a("LoadTask", "Unexpected error loading stream", e4);
                    obtainMessage(3, e4).sendToTarget();
                }
                throw e4;
            } catch (Exception e5) {
                if (this.f62017j) {
                    return;
                }
                oc.a("LoadTask", "Unexpected exception loading stream", e5);
                obtainMessage(2, new h(e5)).sendToTarget();
            } catch (OutOfMemoryError e6) {
                if (this.f62017j) {
                    return;
                }
                oc.a("LoadTask", "OutOfMemory error loading stream", e6);
                obtainMessage(2, new h(e6)).sendToTarget();
            }
        }

        private void a() {
            this.f62013f = null;
            nc.this.f62004a.execute((Runnable) b1.a(nc.this.f62005b));
        }

        public void a(int i3) throws IOException {
            IOException iOException = this.f62013f;
            if (iOException != null && this.f62014g > i3) {
                throw iOException;
            }
        }

        public void a(long j3) {
            b1.b(nc.this.f62005b == null);
            nc.this.f62005b = this;
            if (j3 > 0) {
                sendEmptyMessageDelayed(0, j3);
            } else {
                a();
            }
        }
    }

    public static c a(boolean z2, long j3) {
        return new c(z2 ? 1 : 0, j3);
    }
}
