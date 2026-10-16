package androidx.media3.exoplayer.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.facebook.internal.ServerProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoFrameReleaseHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FixedFrameRateEstimator f45841a = new FixedFrameRateEstimator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DisplayHelper f45842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final VSyncSampler f45843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f45844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Surface f45845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f45846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f45847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f45848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f45849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f45850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f45851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f45852l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f45853m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f45854n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f45855o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f45856p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f45857q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api30 {
        public static void a(Surface surface, float f3) {
            try {
                surface.setFrameRate(f3, f3 == 0.0f ? 0 : 1);
            } catch (IllegalStateException e3) {
                Log.e("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class VSyncSampler implements Choreographer.FrameCallback, Handler.Callback {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final VSyncSampler f45860g = new VSyncSampler();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f45861a = -9223372036854775807L;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f45862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HandlerThread f45863c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Choreographer f45864d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f45865f;

        private VSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f45863c = handlerThread;
            handlerThread.start();
            Handler handlerB = Util.B(handlerThread.getLooper(), this);
            this.f45862b = handlerB;
            handlerB.sendEmptyMessage(1);
        }

        private void b() {
            Choreographer choreographer = this.f45864d;
            if (choreographer != null) {
                int i3 = this.f45865f + 1;
                this.f45865f = i3;
                if (i3 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        private void c() {
            try {
                this.f45864d = Choreographer.getInstance();
            } catch (RuntimeException e3) {
                Log.j("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e3);
            }
        }

        public static VSyncSampler d() {
            return f45860g;
        }

        private void f() {
            Choreographer choreographer = this.f45864d;
            if (choreographer != null) {
                int i3 = this.f45865f - 1;
                this.f45865f = i3;
                if (i3 == 0) {
                    choreographer.removeFrameCallback(this);
                    this.f45861a = -9223372036854775807L;
                }
            }
        }

        public void a() {
            this.f45862b.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            this.f45861a = j3;
            ((Choreographer) Assertions.e(this.f45864d)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f45862b.sendEmptyMessage(3);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                c();
                return true;
            }
            if (i3 == 2) {
                b();
                return true;
            }
            if (i3 != 3) {
                return false;
            }
            f();
            return true;
        }
    }

    public VideoFrameReleaseHelper(Context context) {
        DisplayHelper displayHelperF = f(context);
        this.f45842b = displayHelperF;
        this.f45843c = displayHelperF != null ? VSyncSampler.d() : null;
        this.f45851k = -9223372036854775807L;
        this.f45852l = -9223372036854775807L;
        this.f45846f = -1.0f;
        this.f45849i = 1.0f;
        this.f45850j = 0;
    }

    private static boolean c(long j3, long j4) {
        return Math.abs(j3 - j4) <= 20000000;
    }

    private void d() {
        Surface surface;
        if (Util.f41609a < 30 || (surface = this.f45845e) == null || this.f45850j == Integer.MIN_VALUE || this.f45848h == 0.0f) {
            return;
        }
        this.f45848h = 0.0f;
        Api30.a(surface, 0.0f);
    }

    private static long e(long j3, long j4, long j5) {
        long j6;
        long j7 = j4 + (((j3 - j4) / j5) * j5);
        if (j3 <= j7) {
            j6 = j7 - j5;
        } else {
            long j8 = j5 + j7;
            j6 = j7;
            j7 = j8;
        }
        return j7 - j3 < j3 - j6 ? j7 : j6;
    }

    private DisplayHelper f(Context context) {
        DisplayManager displayManager;
        if (context == null || (displayManager = (DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY)) == null) {
            return null;
        }
        return new DisplayHelper(displayManager);
    }

    private void n() {
        this.f45853m = 0L;
        this.f45856p = -1L;
        this.f45854n = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.f45851k = refreshRate;
            this.f45852l = (refreshRate * 80) / 100;
        } else {
            Log.i("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.f45851k = -9223372036854775807L;
            this.f45852l = -9223372036854775807L;
        }
    }

    private void q() {
        if (Util.f41609a < 30 || this.f45845e == null) {
            return;
        }
        float fB = this.f45841a.e() ? this.f45841a.b() : this.f45846f;
        float f3 = this.f45847g;
        if (fB == f3) {
            return;
        }
        if (fB != -1.0f && f3 != -1.0f) {
            if (Math.abs(fB - this.f45847g) < ((!this.f45841a.e() || this.f45841a.d() < 5000000000L) ? 1.0f : 0.02f)) {
                return;
            }
        } else if (fB == -1.0f && this.f45841a.c() < 30) {
            return;
        }
        this.f45847g = fB;
        r(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void r(boolean r4) {
        /*
            r3 = this;
            int r0 = androidx.media3.common.util.Util.f41609a
            r1 = 30
            if (r0 < r1) goto L30
            android.view.Surface r0 = r3.f45845e
            if (r0 == 0) goto L30
            int r1 = r3.f45850j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L11
            goto L30
        L11:
            boolean r1 = r3.f45844d
            if (r1 == 0) goto L21
            float r1 = r3.f45847g
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L21
            float r2 = r3.f45849i
            float r1 = r1 * r2
            goto L22
        L21:
            r1 = 0
        L22:
            if (r4 != 0) goto L2b
            float r4 = r3.f45848h
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 != 0) goto L2b
            goto L30
        L2b:
            r3.f45848h = r1
            androidx.media3.exoplayer.video.VideoFrameReleaseHelper.Api30.a(r0, r1)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.VideoFrameReleaseHelper.r(boolean):void");
    }

    public long b(long j3) {
        long j4;
        if (this.f45856p == -1 || !this.f45841a.e()) {
            j4 = j3;
        } else {
            long jA = this.f45857q + ((long) ((this.f45841a.a() * (this.f45853m - this.f45856p)) / this.f45849i));
            if (c(j3, jA)) {
                j4 = jA;
            } else {
                n();
                j4 = j3;
            }
        }
        this.f45854n = this.f45853m;
        this.f45855o = j4;
        VSyncSampler vSyncSampler = this.f45843c;
        if (vSyncSampler != null && this.f45851k != -9223372036854775807L) {
            long j5 = vSyncSampler.f45861a;
            if (j5 != -9223372036854775807L) {
                return e(j4, j5, this.f45851k) - this.f45852l;
            }
        }
        return j4;
    }

    public void g(float f3) {
        this.f45846f = f3;
        this.f45841a.g();
        q();
    }

    public void h(long j3) {
        long j4 = this.f45854n;
        if (j4 != -1) {
            this.f45856p = j4;
            this.f45857q = this.f45855o;
        }
        this.f45853m++;
        this.f45841a.f(j3 * 1000);
        q();
    }

    public void i(float f3) {
        this.f45849i = f3;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.f45844d = true;
        n();
        if (this.f45842b != null) {
            ((VSyncSampler) Assertions.e(this.f45843c)).a();
            this.f45842b.b();
        }
        r(false);
    }

    public void l() {
        this.f45844d = false;
        DisplayHelper displayHelper = this.f45842b;
        if (displayHelper != null) {
            displayHelper.c();
            ((VSyncSampler) Assertions.e(this.f45843c)).e();
        }
        d();
    }

    public void m(Surface surface) {
        if (this.f45845e == surface) {
            return;
        }
        d();
        this.f45845e = surface;
        r(true);
    }

    public void o(int i3) {
        if (this.f45850j == i3) {
            return;
        }
        this.f45850j = i3;
        r(true);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class DisplayHelper implements DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisplayManager f45858a;

        public DisplayHelper(DisplayManager displayManager) {
            this.f45858a = displayManager;
        }

        private Display a() {
            return this.f45858a.getDisplay(0);
        }

        public void b() {
            this.f45858a.registerDisplayListener(this, Util.C());
            VideoFrameReleaseHelper.this.p(a());
        }

        public void c() {
            this.f45858a.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i3) {
            if (i3 == 0) {
                VideoFrameReleaseHelper.this.p(a());
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i3) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i3) {
        }
    }
}
