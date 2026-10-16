package com.applovin.impl;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class hl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap f60216a = new WeakHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f60217b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f60218c = new Handler();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f60219d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WeakReference f60220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f60221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f60222g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(int i3, int i4);
    }

    public hl(View view) {
        this.f60220e = new WeakReference(view);
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            this.f60221f = null;
            return;
        }
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.applovin.impl.tx
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return this.f64002a.b();
            }
        };
        this.f60221f = onPreDrawListener;
        viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        synchronized (this.f60217b) {
            try {
                this.f60219d = false;
                int iMin = -1;
                int iMax = -1;
                for (Map.Entry entry : this.f60216a.entrySet()) {
                    if (a((View) entry.getKey())) {
                        Integer num = (Integer) entry.getValue();
                        if (iMin == -1 && iMax == -1) {
                            iMin = num.intValue();
                            iMax = num.intValue();
                        } else {
                            iMin = Math.min(iMin, ((Integer) entry.getValue()).intValue());
                            iMax = Math.max(iMax, ((Integer) entry.getValue()).intValue());
                        }
                    }
                }
                a aVar = this.f60222g;
                if (aVar != null) {
                    aVar.a(iMin, iMax);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void d() {
        if (this.f60219d) {
            return;
        }
        this.f60219d = true;
        this.f60218c.postDelayed(new Runnable() { // from class: com.applovin.impl.ux
            @Override // java.lang.Runnable
            public final void run() {
                this.f64356a.c();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b() {
        d();
        return true;
    }

    public void a() {
        ViewTreeObserver.OnPreDrawListener onPreDrawListener;
        this.f60222g = null;
        View view = (View) this.f60220e.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive() && (onPreDrawListener = this.f60221f) != null) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            }
            this.f60220e.clear();
        }
    }

    public void b(View view) {
        synchronized (this.f60217b) {
            this.f60216a.remove(view);
        }
    }

    private boolean a(View view) {
        return (view == null || view.getVisibility() != 0 || view.getParent() == null) ? false : true;
    }

    public void a(a aVar) {
        this.f60222g = aVar;
    }

    public void a(View view, int i3) {
        synchronized (this.f60217b) {
            this.f60216a.put(view, Integer.valueOf(i3));
            d();
        }
    }
}
