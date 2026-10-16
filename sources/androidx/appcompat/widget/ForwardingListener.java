package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f1980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f1982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final View f1983d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f1984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f1985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f1987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f1988j = new int[2];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DisallowIntercept implements Runnable {
        DisallowIntercept() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = ForwardingListener.this.f1983d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class TriggerLongPress implements Runnable {
        TriggerLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ForwardingListener.this.e();
        }
    }

    public ForwardingListener(View view) {
        this.f1983d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1980a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1981b = tapTimeout;
        this.f1982c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f1985g;
        if (runnable != null) {
            this.f1983d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1984f;
        if (runnable2 != null) {
            this.f1983d.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        DropDownListView dropDownListView;
        View view = this.f1983d;
        ShowableListMenu showableListMenuB = b();
        if (showableListMenuB != null && showableListMenuB.b() && (dropDownListView = (DropDownListView) showableListMenuB.o()) != null && dropDownListView.isShown()) {
            MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            i(view, motionEventObtainNoHistory);
            j(dropDownListView, motionEventObtainNoHistory);
            boolean zE = dropDownListView.e(motionEventObtainNoHistory, this.f1987i);
            motionEventObtainNoHistory.recycle();
            int actionMasked = motionEvent.getActionMasked();
            boolean z2 = (actionMasked == 1 || actionMasked == 3) ? false : true;
            if (zE && z2) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1983d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f1987i
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1980a
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f1987i = r6
            java.lang.Runnable r6 = r5.f1984f
            if (r6 != 0) goto L52
            androidx.appcompat.widget.ForwardingListener$DisallowIntercept r6 = new androidx.appcompat.widget.ForwardingListener$DisallowIntercept
            r6.<init>()
            r5.f1984f = r6
        L52:
            java.lang.Runnable r6 = r5.f1984f
            int r1 = r5.f1981b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1985g
            if (r6 != 0) goto L65
            androidx.appcompat.widget.ForwardingListener$TriggerLongPress r6 = new androidx.appcompat.widget.ForwardingListener$TriggerLongPress
            r6.<init>()
            r5.f1985g = r6
        L65:
            java.lang.Runnable r6 = r5.f1985g
            int r1 = r5.f1982c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ForwardingListener.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f3, float f4, float f5) {
        float f6 = -f5;
        return f3 >= f6 && f4 >= f6 && f3 < ((float) (view.getRight() - view.getLeft())) + f5 && f4 < ((float) (view.getBottom() - view.getTop())) + f5;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1988j);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1988j);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    public abstract ShowableListMenu b();

    protected boolean c() {
        ShowableListMenu showableListMenuB = b();
        if (showableListMenuB == null || showableListMenuB.b()) {
            return true;
        }
        showableListMenuB.show();
        return true;
    }

    protected boolean d() {
        ShowableListMenu showableListMenuB = b();
        if (showableListMenuB == null || !showableListMenuB.b()) {
            return true;
        }
        showableListMenuB.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f1983d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f1986h = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        boolean z3 = this.f1986h;
        if (z3) {
            z2 = f(motionEvent) || !d();
        } else {
            z2 = g(motionEvent) && c();
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1983d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f1986h = z2;
        return z2 || z3;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1986h = false;
        this.f1987i = -1;
        Runnable runnable = this.f1984f;
        if (runnable != null) {
            this.f1983d.removeCallbacks(runnable);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
