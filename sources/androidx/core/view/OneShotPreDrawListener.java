package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f34427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f34428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f34429c;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.f34427a = view;
        this.f34428b = view.getViewTreeObserver();
        this.f34429c = runnable;
    }

    public static OneShotPreDrawListener a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
        view.addOnAttachStateChangeListener(oneShotPreDrawListener);
        return oneShotPreDrawListener;
    }

    public void b() {
        if (this.f34428b.isAlive()) {
            this.f34428b.removeOnPreDrawListener(this);
        } else {
            this.f34427a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f34427a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f34429c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f34428b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
