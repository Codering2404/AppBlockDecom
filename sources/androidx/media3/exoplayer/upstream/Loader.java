package androidx.media3.exoplayer.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.util.ReleasableExecutor;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Loader implements LoaderErrorThrower {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LoadErrorAction f45534d = g(false, -9223372036854775807L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LoadErrorAction f45535e = g(true, -9223372036854775807L);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LoadErrorAction f45536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LoadErrorAction f45537g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReleasableExecutor f45538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LoadTask f45539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IOException f45540c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class LoadErrorAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f45541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f45542b;

        public boolean c() {
            int i3 = this.f45541a;
            return i3 == 0 || i3 == 1;
        }

        private LoadErrorAction(int i3, long j3) {
            this.f45541a = i3;
            this.f45542b = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class LoadTask<T extends Loadable> extends Handler implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f45543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Loadable f45544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f45545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Callback f45546d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private IOException f45547f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f45548g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Thread f45549h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f45550i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private volatile boolean f45551j;

        public LoadTask(Looper looper, Loadable loadable, Callback callback, int i3, long j3) {
            super(looper);
            this.f45544b = loadable;
            this.f45546d = callback;
            this.f45543a = i3;
            this.f45545c = j3;
        }

        private void b() {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ((Callback) Assertions.e(this.f45546d)).p(this.f45544b, jElapsedRealtime, jElapsedRealtime - this.f45545c, this.f45548g);
            this.f45547f = null;
            Loader.this.f45538a.execute((Runnable) Assertions.e(Loader.this.f45539b));
        }

        private void c() {
            Loader.this.f45539b = null;
        }

        private long d() {
            return Math.min((this.f45548g - 1) * 1000, 5000);
        }

        public void a(boolean z2) {
            this.f45551j = z2;
            this.f45547f = null;
            if (hasMessages(1)) {
                this.f45550i = true;
                removeMessages(1);
                if (!z2) {
                    sendEmptyMessage(2);
                }
            } else {
                synchronized (this) {
                    try {
                        this.f45550i = true;
                        this.f45544b.c();
                        Thread thread = this.f45549h;
                        if (thread != null) {
                            thread.interrupt();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (z2) {
                c();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ((Callback) Assertions.e(this.f45546d)).v(this.f45544b, jElapsedRealtime, jElapsedRealtime - this.f45545c, true);
                this.f45546d = null;
            }
        }

        public void e(int i3) throws IOException {
            IOException iOException = this.f45547f;
            if (iOException != null && this.f45548g > i3) {
                throw iOException;
            }
        }

        public void f(long j3) {
            Assertions.g(Loader.this.f45539b == null);
            Loader.this.f45539b = this;
            if (j3 > 0) {
                sendEmptyMessageDelayed(1, j3);
            } else {
                b();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f45551j) {
                return;
            }
            int i3 = message.what;
            if (i3 == 1) {
                b();
                return;
            }
            if (i3 == 4) {
                throw ((Error) message.obj);
            }
            c();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = jElapsedRealtime - this.f45545c;
            Callback callback = (Callback) Assertions.e(this.f45546d);
            if (this.f45550i) {
                callback.v(this.f45544b, jElapsedRealtime, j3, false);
                return;
            }
            int i4 = message.what;
            if (i4 == 2) {
                try {
                    callback.t(this.f45544b, jElapsedRealtime, j3);
                    return;
                } catch (RuntimeException e3) {
                    Log.e("LoadTask", "Unexpected exception handling load completed", e3);
                    Loader.this.f45540c = new UnexpectedLoaderException(e3);
                    return;
                }
            }
            if (i4 != 3) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f45547f = iOException;
            int i5 = this.f45548g + 1;
            this.f45548g = i5;
            LoadErrorAction loadErrorActionG = callback.g(this.f45544b, jElapsedRealtime, j3, iOException, i5);
            if (loadErrorActionG.f45541a == 3) {
                Loader.this.f45540c = this.f45547f;
            } else if (loadErrorActionG.f45541a != 2) {
                if (loadErrorActionG.f45541a == 1) {
                    this.f45548g = 1;
                }
                f(loadErrorActionG.f45542b != -9223372036854775807L ? loadErrorActionG.f45542b : d());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z2;
            try {
                synchronized (this) {
                    z2 = this.f45550i;
                    this.f45549h = Thread.currentThread();
                }
                if (!z2) {
                    TraceUtil.a("load:" + this.f45544b.getClass().getSimpleName());
                    try {
                        this.f45544b.a();
                        TraceUtil.b();
                    } catch (Throwable th) {
                        TraceUtil.b();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.f45549h = null;
                    Thread.interrupted();
                }
                if (this.f45551j) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e3) {
                if (this.f45551j) {
                    return;
                }
                obtainMessage(3, e3).sendToTarget();
            } catch (Error e4) {
                if (!this.f45551j) {
                    Log.e("LoadTask", "Unexpected error loading stream", e4);
                    obtainMessage(4, e4).sendToTarget();
                }
                throw e4;
            } catch (Exception e5) {
                if (this.f45551j) {
                    return;
                }
                Log.e("LoadTask", "Unexpected exception loading stream", e5);
                obtainMessage(3, new UnexpectedLoaderException(e5)).sendToTarget();
            } catch (OutOfMemoryError e6) {
                if (this.f45551j) {
                    return;
                }
                Log.e("LoadTask", "OutOfMemory error loading stream", e6);
                obtainMessage(3, new UnexpectedLoaderException(e6)).sendToTarget();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Loadable {
        void a();

        void c();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ReleaseCallback {
        void m();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ReleaseTask implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ReleaseCallback f45553a;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.f45553a = releaseCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45553a.m();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected ");
            sb.append(th.getClass().getSimpleName());
            if (th.getMessage() != null) {
                str = ": " + th.getMessage();
            } else {
                str = "";
            }
            sb.append(str);
            super(sb.toString(), th);
        }
    }

    static {
        long j3 = -9223372036854775807L;
        f45536f = new LoadErrorAction(2, j3);
        f45537g = new LoadErrorAction(3, j3);
    }

    public Loader(String str) {
        this(ReleasableExecutor.A0(Util.Q0("ExoPlayer:Loader:" + str), new Consumer() { // from class: androidx.media3.exoplayer.upstream.c
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((ExecutorService) obj).shutdown();
            }
        }));
    }

    public static LoadErrorAction g(boolean z2, long j3) {
        return new LoadErrorAction(z2 ? 1 : 0, j3);
    }

    public void e() {
        ((LoadTask) Assertions.i(this.f45539b)).a(false);
    }

    public void f() {
        this.f45540c = null;
    }

    public boolean h() {
        return this.f45540c != null;
    }

    public boolean i() {
        return this.f45539b != null;
    }

    public void j() throws IOException {
        k(Integer.MIN_VALUE);
    }

    public void k(int i3) throws IOException {
        IOException iOException = this.f45540c;
        if (iOException != null) {
            throw iOException;
        }
        LoadTask loadTask = this.f45539b;
        if (loadTask != null) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = loadTask.f45543a;
            }
            loadTask.e(i3);
        }
    }

    public void l() {
        m(null);
    }

    public void m(ReleaseCallback releaseCallback) {
        LoadTask loadTask = this.f45539b;
        if (loadTask != null) {
            loadTask.a(true);
        }
        if (releaseCallback != null) {
            this.f45538a.execute(new ReleaseTask(releaseCallback));
        }
        this.f45538a.release();
    }

    public long n(Loadable loadable, Callback callback, int i3) {
        Looper looper = (Looper) Assertions.i(Looper.myLooper());
        this.f45540c = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new LoadTask(looper, loadable, callback, i3, jElapsedRealtime).f(0L);
        return jElapsedRealtime;
    }

    public Loader(ReleasableExecutor releasableExecutor) {
        this.f45538a = releasableExecutor;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Callback<T extends Loadable> {
        LoadErrorAction g(Loadable loadable, long j3, long j4, IOException iOException, int i3);

        void t(Loadable loadable, long j3, long j4);

        void v(Loadable loadable, long j3, long j4, boolean z2);

        default void p(Loadable loadable, long j3, long j4, int i3) {
        }
    }
}
