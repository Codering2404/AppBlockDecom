package com.applovin.impl;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f58765a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f58769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f58770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference f58771g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f58772h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f58775k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f58776l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f58777m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f58778n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f58766b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f58767c = new Rect();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private WeakReference f58773i = new WeakReference(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private WeakReference f58774j = new WeakReference(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f58779o = Long.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f58768d = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void onLogVisibilityImpression();
    }

    public br(final View view, com.applovin.impl.sdk.j jVar, a aVar) {
        this.f58765a = jVar.I();
        this.f58772h = ((Long) jVar.a(sj.G1)).longValue();
        this.f58771g = new WeakReference(view);
        final WeakReference weakReference = new WeakReference(aVar);
        this.f58769e = new Runnable() { // from class: com.applovin.impl.bu
            @Override // java.lang.Runnable
            public final void run() {
                this.f58781a.a(weakReference);
            }
        };
        this.f58770f = new ViewTreeObserver.OnPreDrawListener() { // from class: com.applovin.impl.cu
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.f59027a.a(view);
            }
        };
    }

    private void c(View view) {
        View viewB = zq.b((View) this.f58771g.get());
        if (viewB == null) {
            viewB = zq.b(view);
        }
        if (viewB == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58765a.a("VisibilityTracker", "Unable to set view tree observer due to no root view.");
                return;
            }
            return;
        }
        ViewTreeObserver viewTreeObserver = viewB.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.f58773i = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnPreDrawListener(this.f58770f);
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f58765a.k("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
        }
    }

    private boolean a(View view, View view2) {
        if (b(view, view2)) {
            if (this.f58779o == Long.MIN_VALUE) {
                this.f58779o = SystemClock.uptimeMillis();
            }
            if (SystemClock.uptimeMillis() - this.f58779o >= this.f58778n) {
                return true;
            }
        }
        return false;
    }

    private boolean b(View view, View view2) {
        if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || view2.getWidth() <= 0 || view2.getHeight() <= 0 || !view2.getGlobalVisibleRect(this.f58767c)) {
            return false;
        }
        long jPxToDp = AppLovinSdkUtils.pxToDp(view2.getContext(), this.f58767c.width()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.f58767c.height());
        if (jPxToDp < this.f58775k) {
            return false;
        }
        if ((jPxToDp / (AppLovinSdkUtils.pxToDp(view2.getContext(), view2.getWidth()) * AppLovinSdkUtils.pxToDp(view2.getContext(), view2.getHeight()))) * 100.0f < this.f58776l) {
            return false;
        }
        return (((float) ((long) (this.f58767c.width() * this.f58767c.height()))) / ((float) ((long) (view2.getWidth() * view2.getHeight())))) * 100.0f >= this.f58777m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(WeakReference weakReference) {
        View view = (View) this.f58771g.get();
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        View view2 = (View) this.f58774j.get();
        if (viewGroup == null || view2 == null) {
            return;
        }
        if (a(viewGroup, view2)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58765a.a("VisibilityTracker", "View met visibility requirements. Logging visibility impression..");
            }
            b();
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.onLogVisibilityImpression();
                return;
            }
            return;
        }
        a();
    }

    private void b(View view) {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f58773i.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f58770f);
        } else if (view != null) {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnPreDrawListener(this.f58770f);
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f58765a.a("VisibilityTracker", "Could not remove on pre-draw listener. View tree observer is not alive.");
            }
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f58765a.a("VisibilityTracker", "Could not remove on pre-draw listener. Root view is null.");
        }
        this.f58773i.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view) {
        a();
        b(view);
        return true;
    }

    private void a() {
        this.f58768d.postDelayed(this.f58769e, this.f58772h);
    }

    public void a(int i3, float f3, float f4, long j3, View view) {
        synchronized (this.f58766b) {
            try {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f58765a.a("VisibilityTracker", "Tracking visibility for " + view);
                }
                b();
                WeakReference weakReference = new WeakReference(view);
                this.f58774j = weakReference;
                this.f58775k = i3;
                this.f58776l = f3;
                this.f58777m = f4;
                this.f58778n = j3;
                c((View) weakReference.get());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.f58766b) {
            this.f58768d.removeMessages(0);
            b((View) this.f58771g.get());
            this.f58779o = Long.MIN_VALUE;
            this.f58774j.clear();
        }
    }

    public void a(me meVar) {
        View viewO0;
        if (meVar instanceof ge) {
            viewO0 = meVar.y();
        } else if (!(meVar instanceof ie)) {
            return;
        } else {
            viewO0 = ((ie) meVar).o0();
        }
        a(meVar.g0(), meVar.i0(), meVar.j0(), meVar.k0(), viewO0);
    }
}
