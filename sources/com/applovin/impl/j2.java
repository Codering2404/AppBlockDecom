package com.applovin.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.View;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f60577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f60578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f60579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f60580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f60581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f60582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f60583g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Handler f60587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private HandlerThread f60588l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c f60590n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakReference f60584h = new WeakReference(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f60585i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Integer f60586j = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Runnable f60589m = new Runnable() { // from class: com.applovin.impl.jy
        @Override // java.lang.Runnable
        public final void run() {
            this.f60826a.a();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements PixelCopy.OnPixelCopyFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f60592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f60593b;

        b(d dVar, Bitmap bitmap) {
            this.f60592a = dVar;
            this.f60593b = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i3) {
            if (i3 == 0) {
                this.f60592a.a(this.f60593b);
                return;
            }
            com.applovin.impl.sdk.n unused = j2.this.f60578b;
            if (com.applovin.impl.sdk.n.a()) {
                j2.this.f60578b.b("BlackViewDetector", "Failed to capture screenshot with error code: " + i3);
            }
            this.f60592a.a(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface c {
        void a(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface d {
        void a(Bitmap bitmap);

        void a(boolean z2);
    }

    public j2(com.applovin.impl.sdk.j jVar) {
        this.f60577a = jVar;
        this.f60578b = jVar.I();
        this.f60579c = ((Long) jVar.a(sj.T5)).longValue();
        this.f60580d = ((Long) jVar.a(sj.S5)).longValue();
        this.f60581e = ((Integer) jVar.a(sj.U5)).intValue();
        this.f60582f = ((Integer) jVar.a(sj.V5)).intValue();
        this.f60583g = ((Integer) jVar.a(sj.W5)).intValue();
    }

    static /* synthetic */ int e(j2 j2Var) {
        int i3 = j2Var.f60585i;
        j2Var.f60585i = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f60590n = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long j3 = this.f60579c;
        if (j3 <= 0) {
            if (this.f60585i == 1) {
                e();
            }
            g();
        } else {
            if (this.f60585i > 1) {
                e();
                g();
                return;
            }
            Handler handler = this.f60587k;
            if (handler != null) {
                handler.postDelayed(this.f60589m, j3);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f60578b.k("BlackViewDetector", "Monitoring handler was unexpectedly null");
            }
            g();
        }
    }

    private void e() {
        final View view = (View) this.f60584h.get();
        if (com.applovin.impl.sdk.n.a()) {
            this.f60578b.k("BlackViewDetector", "Detected black view: " + view);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.hy
            @Override // java.lang.Runnable
            public final void run() {
                this.f60265a.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f60585i = 0;
        this.f60586j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f60584h.get() != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f60578b.a("BlackViewDetector", "Stopped monitoring view: " + this.f60584h.get());
            }
            this.f60584h.clear();
        }
        Handler handler = this.f60587k;
        if (handler != null) {
            handler.removeCallbacks(this.f60589m);
            this.f60587k = null;
        }
        if (this.f60590n != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.iy
                @Override // java.lang.Runnable
                public final void run() {
                    this.f60544a.c();
                }
            });
        }
    }

    public void b() {
        g();
        HandlerThread handlerThread = this.f60588l;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f60588l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ActivityManager.MemoryInfo memoryInfoA;
        View view = (View) this.f60584h.get();
        if (view == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f60578b.k("BlackViewDetector", "Monitored view no longer exists.");
            }
            g();
            return;
        }
        Long l3 = (Long) this.f60577a.a(sj.a6);
        if (l3.longValue() > 0 && (memoryInfoA = yp.a((ActivityManager) com.applovin.impl.sdk.j.m().getSystemService("activity"))) != null && memoryInfoA.availMem < l3.longValue()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f60578b.k("BlackViewDetector", "Cancelling black view detection due to low memory");
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f60578b.a("BlackViewDetector", "Checking for black view: " + view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth != 0 && measuredHeight != 0) {
            a(view, new a());
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f60578b.k("BlackViewDetector", "Monitored view is not visible due to dimensions (width = " + measuredWidth + ", height = " + measuredHeight + ")");
        }
        f();
        d();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements d {
        a() {
        }

        @Override // com.applovin.impl.j2.d
        public void a(Bitmap bitmap) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i3 = width / j2.this.f60581e;
                int i4 = height / j2.this.f60581e;
                int i5 = i3 / 2;
                for (int i6 = i4 / 2; i6 < height; i6 += i4) {
                    for (int i7 = i5; i7 < width; i7 += i3) {
                        int pixel = bitmap.getPixel(i7, i6);
                        if (j2.this.a(pixel)) {
                            bitmap.recycle();
                            j2.this.f();
                            j2.this.d();
                            return;
                        }
                        if (j2.this.f60586j == null) {
                            j2.this.f60586j = Integer.valueOf(pixel);
                        }
                    }
                }
                j2.e(j2.this);
                bitmap.recycle();
                j2.this.d();
            } catch (Exception e3) {
                j2.this.f60577a.D().a("BlackViewDetector", "onScreenshotCaptured", e3);
                j2.this.g();
            }
        }

        @Override // com.applovin.impl.j2.d
        public void a(boolean z2) {
            if (z2) {
                j2.this.g();
            } else {
                j2.this.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r9) {
        /*
            r8 = this;
            int r0 = android.graphics.Color.red(r9)
            int r1 = android.graphics.Color.green(r9)
            int r9 = android.graphics.Color.blue(r9)
            java.lang.Integer r2 = r8.f60586j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L4d
            int r2 = r2.intValue()
            int r2 = android.graphics.Color.red(r2)
            java.lang.Integer r5 = r8.f60586j
            int r5 = r5.intValue()
            int r5 = android.graphics.Color.green(r5)
            java.lang.Integer r6 = r8.f60586j
            int r6 = r6.intValue()
            int r6 = android.graphics.Color.blue(r6)
            int r2 = r0 - r2
            int r2 = java.lang.Math.abs(r2)
            int r7 = r8.f60583g
            if (r2 > r7) goto L4f
            int r2 = r1 - r5
            int r2 = java.lang.Math.abs(r2)
            int r5 = r8.f60583g
            if (r2 > r5) goto L4f
            int r2 = r9 - r6
            int r2 = java.lang.Math.abs(r2)
            int r5 = r8.f60583g
            if (r2 <= r5) goto L4d
            goto L4f
        L4d:
            r2 = r4
            goto L50
        L4f:
            r2 = r3
        L50:
            int r5 = r8.f60582f
            if (r0 > r5) goto L5c
            if (r1 > r5) goto L5c
            if (r9 > r5) goto L5c
            if (r2 == 0) goto L5b
            goto L5c
        L5b:
            return r4
        L5c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.j2.a(int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        c cVar = this.f60590n;
        if (cVar != null) {
            cVar.a(view);
        }
    }

    public void a(View view, c cVar) {
        if (((Boolean) this.f60577a.a(sj.R5)).booleanValue()) {
            View view2 = (View) this.f60584h.get();
            if (view2 != null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f60578b.k("BlackViewDetector", "Monitoring is already in progress for a view: " + view2);
                    return;
                }
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f60578b.a("BlackViewDetector", "Started monitoring view: " + view);
            }
            try {
                if (this.f60588l == null) {
                    HandlerThread handlerThread = new HandlerThread("AppLovinSdk:black_view_detector");
                    this.f60588l = handlerThread;
                    handlerThread.start();
                } else {
                    this.f60577a.D().a(ka.P, "BlackViewDetector:maybeStartMonitoring() unexpectedly called multiple times");
                    g();
                }
                this.f60590n = cVar;
                this.f60584h = new WeakReference(view);
                f();
                Handler handler = new Handler(this.f60588l.getLooper());
                this.f60587k = handler;
                handler.postDelayed(this.f60589m, this.f60580d);
            } catch (Throwable th) {
                g();
                this.f60577a.D().a("BlackViewDetector", "maybeStartMonitoring", th);
            }
        }
    }

    private void a(View view, d dVar) {
        Activity activityA = this.f60577a.e().a();
        if (activityA == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f60578b.b("BlackViewDetector", "Failed to capture screenshot due to no active activity");
            }
            dVar.a(false);
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        Rect rect = new Rect(i3, i4, i3 + measuredWidth, i4 + measuredHeight);
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            PixelCopy.request(activityA.getWindow(), rect, bitmapCreateBitmap, new b(dVar, bitmapCreateBitmap), new Handler());
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f60578b.b("BlackViewDetector", "Failed to capture screenshot due to exception: " + th);
            }
            dVar.a(true);
        }
    }
}
