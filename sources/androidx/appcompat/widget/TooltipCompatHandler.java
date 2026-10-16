package androidx.appcompat.widget;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static TooltipCompatHandler f2327l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static TooltipCompatHandler f2328m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f2329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f2330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Runnable f2332d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Runnable f2333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TooltipPopup f2336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2337j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2338k;

    private void a() {
        this.f2329a.removeCallbacks(this.f2332d);
    }

    private void b() {
        this.f2338k = true;
    }

    private void d() {
        this.f2329a.postDelayed(this.f2332d, ViewConfiguration.getLongPressTimeout());
    }

    private static void e(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = f2327l;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.a();
        }
        f2327l = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.d();
        }
    }

    private boolean g(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (!this.f2338k && Math.abs(x2 - this.f2334g) <= this.f2331c && Math.abs(y2 - this.f2335h) <= this.f2331c) {
            return false;
        }
        this.f2334g = x2;
        this.f2335h = y2;
        this.f2338k = false;
        return true;
    }

    void c() {
        if (f2328m == this) {
            f2328m = null;
            TooltipPopup tooltipPopup = this.f2336i;
            if (tooltipPopup != null) {
                tooltipPopup.c();
                this.f2336i = null;
                b();
                this.f2329a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f2327l == this) {
            e(null);
        }
        this.f2329a.removeCallbacks(this.f2333f);
    }

    void f(boolean z2) {
        long longPressTimeout;
        long j3;
        long j4;
        if (this.f2329a.isAttachedToWindow()) {
            e(null);
            TooltipCompatHandler tooltipCompatHandler = f2328m;
            if (tooltipCompatHandler != null) {
                tooltipCompatHandler.c();
            }
            f2328m = this;
            this.f2337j = z2;
            TooltipPopup tooltipPopup = new TooltipPopup(this.f2329a.getContext());
            this.f2336i = tooltipPopup;
            tooltipPopup.e(this.f2329a, this.f2334g, this.f2335h, this.f2337j, this.f2330b);
            this.f2329a.addOnAttachStateChangeListener(this);
            if (this.f2337j) {
                j4 = 2500;
            } else {
                if ((ViewCompat.K(this.f2329a) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j3 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j3 = 15000;
                }
                j4 = j3 - longPressTimeout;
            }
            this.f2329a.removeCallbacks(this.f2333f);
            this.f2329a.postDelayed(this.f2333f, j4);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f2336i != null && this.f2337j) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f2329a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f2329a.isEnabled() && this.f2336i == null && g(motionEvent)) {
            e(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f2334g = view.getWidth() / 2;
        this.f2335h = view.getHeight() / 2;
        f(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
