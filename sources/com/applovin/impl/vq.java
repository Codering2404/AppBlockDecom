package com.applovin.impl;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.facebook.internal.ServerProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class vq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q8 f64460a = new q8();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f64461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f64462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f64463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Surface f64464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f64465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f64466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f64467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f64468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f64469j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f64470k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f64471l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f64472m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f64473n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f64474o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f64475p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f64476q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {
        public static void a(Surface surface, float f3) {
            try {
                surface.setFrameRate(f3, f3 == 0.0f ? 0 : 1);
            } catch (IllegalStateException e3) {
                oc.a("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface b {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface a {
            void a(Display display);
        }

        void a();

        void a(a aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WindowManager f64477a;

        private c(WindowManager windowManager) {
            this.f64477a = windowManager;
        }

        @Override // com.applovin.impl.vq.b
        public void a() {
        }

        public static b a(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new c(windowManager);
            }
            return null;
        }

        @Override // com.applovin.impl.vq.b
        public void a(b.a aVar) {
            aVar.a(this.f64477a.getDefaultDisplay());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class e implements Choreographer.FrameCallback, Handler.Callback {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final e f64480g = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f64481a = -9223372036854775807L;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f64482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HandlerThread f64483c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Choreographer f64484d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f64485f;

        private e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f64483c = handlerThread;
            handlerThread.start();
            Handler handlerA = xp.a(handlerThread.getLooper(), (Handler.Callback) this);
            this.f64482b = handlerA;
            handlerA.sendEmptyMessage(0);
        }

        private void b() {
            int i3 = this.f64485f + 1;
            this.f64485f = i3;
            if (i3 == 1) {
                ((Choreographer) b1.a(this.f64484d)).postFrameCallback(this);
            }
        }

        private void c() {
            this.f64484d = Choreographer.getInstance();
        }

        public static e d() {
            return f64480g;
        }

        private void f() {
            int i3 = this.f64485f - 1;
            this.f64485f = i3;
            if (i3 == 0) {
                ((Choreographer) b1.a(this.f64484d)).removeFrameCallback(this);
                this.f64481a = -9223372036854775807L;
            }
        }

        public void a() {
            this.f64482b.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            this.f64481a = j3;
            ((Choreographer) b1.a(this.f64484d)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f64482b.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                c();
                return true;
            }
            if (i3 == 1) {
                b();
                return true;
            }
            if (i3 != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public vq(Context context) {
        b bVarA = a(context);
        this.f64461b = bVarA;
        this.f64462c = bVarA != null ? e.d() : null;
        this.f64470k = -9223372036854775807L;
        this.f64471l = -9223372036854775807L;
        this.f64465f = -1.0f;
        this.f64468i = 1.0f;
        this.f64469j = 0;
    }

    private void g() {
        this.f64472m = 0L;
        this.f64475p = -1L;
        this.f64473n = -1L;
    }

    private void h() {
        if (xp.f65027a < 30 || this.f64464e == null) {
            return;
        }
        float fB = this.f64460a.e() ? this.f64460a.b() : this.f64465f;
        float f3 = this.f64466g;
        if (fB == f3) {
            return;
        }
        if (fB != -1.0f && f3 != -1.0f) {
            if (Math.abs(fB - this.f64466g) < ((!this.f64460a.e() || this.f64460a.d() < 5000000000L) ? 1.0f : 0.02f)) {
                return;
            }
        } else if (fB == -1.0f && this.f64460a.c() < 30) {
            return;
        }
        this.f64466g = fB;
        a(false);
    }

    public void b() {
        b bVar = this.f64461b;
        if (bVar != null) {
            bVar.a();
            ((e) b1.a(this.f64462c)).e();
        }
    }

    public void c() {
        if (this.f64461b != null) {
            ((e) b1.a(this.f64462c)).a();
            this.f64461b.a(new b.a() { // from class: com.applovin.impl.b70
                @Override // com.applovin.impl.vq.b.a
                public final void a(Display display) {
                    this.f58571a.a(display);
                }
            });
        }
    }

    public void d() {
        g();
    }

    public void e() {
        this.f64463d = true;
        g();
        a(false);
    }

    public void f() {
        this.f64463d = false;
        a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class d implements b, DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisplayManager f64478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b.a f64479b;

        private d(DisplayManager displayManager) {
            this.f64478a = displayManager;
        }

        public static b a(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
            if (displayManager != null) {
                return new d(displayManager);
            }
            return null;
        }

        private Display b() {
            return this.f64478a.getDisplay(0);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i3) {
            b.a aVar = this.f64479b;
            if (aVar == null || i3 != 0) {
                return;
            }
            aVar.a(b());
        }

        @Override // com.applovin.impl.vq.b
        public void a(b.a aVar) {
            this.f64479b = aVar;
            this.f64478a.registerDisplayListener(this, xp.a());
            aVar.a(b());
        }

        @Override // com.applovin.impl.vq.b
        public void a() {
            this.f64478a.unregisterDisplayListener(this);
            this.f64479b = null;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i3) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i3) {
        }
    }

    public long a(long j3) {
        long j4;
        if (this.f64475p == -1 || !this.f64460a.e()) {
            j4 = j3;
        } else {
            long jA = this.f64476q + ((long) ((this.f64460a.a() * (this.f64472m - this.f64475p)) / this.f64468i));
            if (a(j3, jA)) {
                j4 = jA;
            } else {
                g();
                j4 = j3;
            }
        }
        this.f64473n = this.f64472m;
        this.f64474o = j4;
        e eVar = this.f64462c;
        if (eVar != null && this.f64470k != -9223372036854775807L) {
            long j5 = eVar.f64481a;
            if (j5 != -9223372036854775807L) {
                return a(j4, j5, this.f64470k) - this.f64471l;
            }
        }
        return j4;
    }

    public void b(long j3) {
        long j4 = this.f64473n;
        if (j4 != -1) {
            this.f64475p = j4;
            this.f64476q = this.f64474o;
        }
        this.f64472m++;
        this.f64460a.a(j3 * 1000);
        h();
    }

    public void b(float f3) {
        this.f64468i = f3;
        g();
        a(false);
    }

    private static boolean a(long j3, long j4) {
        return Math.abs(j3 - j4) <= 20000000;
    }

    private static long a(long j3, long j4, long j5) {
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

    private static b a(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            bVarA = xp.f65027a >= 17 ? d.a(applicationContext) : null;
            if (bVarA == null) {
                return c.a(applicationContext);
            }
        }
        return bVarA;
    }

    public void a(float f3) {
        this.f64465f = f3;
        this.f64460a.f();
        h();
    }

    public void a(Surface surface) {
        if (surface instanceof g7) {
            surface = null;
        }
        if (this.f64464e == surface) {
            return;
        }
        a();
        this.f64464e = surface;
        a(true);
    }

    public void a(int i3) {
        if (this.f64469j == i3) {
            return;
        }
        this.f64469j = i3;
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.f64470k = refreshRate;
            this.f64471l = (refreshRate * 80) / 100;
        } else {
            oc.d("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.f64470k = -9223372036854775807L;
            this.f64471l = -9223372036854775807L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(boolean r4) {
        /*
            r3 = this;
            int r0 = com.applovin.impl.xp.f65027a
            r1 = 30
            if (r0 < r1) goto L30
            android.view.Surface r0 = r3.f64464e
            if (r0 == 0) goto L30
            int r1 = r3.f64469j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L11
            goto L30
        L11:
            boolean r1 = r3.f64463d
            if (r1 == 0) goto L21
            float r1 = r3.f64466g
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L21
            float r2 = r3.f64468i
            float r1 = r1 * r2
            goto L22
        L21:
            r1 = 0
        L22:
            if (r4 != 0) goto L2b
            float r4 = r3.f64467h
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 != 0) goto L2b
            goto L30
        L2b:
            r3.f64467h = r1
            com.applovin.impl.vq.a.a(r0, r1)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.vq.a(boolean):void");
    }

    private void a() {
        Surface surface;
        if (xp.f65027a < 30 || (surface = this.f64464e) == null || this.f64469j == Integer.MIN_VALUE || this.f64467h == 0.0f) {
            return;
        }
        this.f64467h = 0.0f;
        a.a(surface, 0.0f);
    }
}
