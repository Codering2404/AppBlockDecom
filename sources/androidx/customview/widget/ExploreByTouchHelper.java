package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Rect f35462n = new Rect(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final FocusStrategy.BoundsAdapter f35463o = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.1
        @Override // androidx.customview.widget.FocusStrategy.BoundsAdapter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.k(rect);
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final FocusStrategy.CollectionAdapter f35464p = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.2
        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public AccessibilityNodeInfoCompat a(SparseArrayCompat sparseArrayCompat, int i3) {
            return (AccessibilityNodeInfoCompat) sparseArrayCompat.r(i3);
        }

        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(SparseArrayCompat sparseArrayCompat) {
            return sparseArrayCompat.q();
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AccessibilityManager f35469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View f35470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MyNodeProvider f35471j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f35465d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f35466e = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f35467f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f35468g = new int[2];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f35472k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f35473l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f35474m = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat b(int i3) {
            return AccessibilityNodeInfoCompat.X(ExploreByTouchHelper.this.L(i3));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat d(int i3) {
            int i4 = i3 == 2 ? ExploreByTouchHelper.this.f35472k : ExploreByTouchHelper.this.f35473l;
            if (i4 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i4);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean f(int i3, int i4, Bundle bundle) {
            return ExploreByTouchHelper.this.T(i3, i4, bundle);
        }
    }

    public ExploreByTouchHelper(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f35470i = view;
        this.f35469h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (ViewCompat.w(view) == 0) {
            ViewCompat.w0(view, 1);
        }
    }

    private static Rect E(View view, int i3, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i3 == 17) {
            rect.set(width, 0, width, height);
            return rect;
        }
        if (i3 == 33) {
            rect.set(0, height, width, height);
            return rect;
        }
        if (i3 == 66) {
            rect.set(-1, 0, -1, height);
            return rect;
        }
        if (i3 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        rect.set(0, -1, width, -1);
        return rect;
    }

    private boolean I(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f35470i.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f35470i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int J(int i3) {
        if (i3 == 19) {
            return 33;
        }
        if (i3 != 21) {
            return i3 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean K(int i3, Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        SparseArrayCompat sparseArrayCompatY = y();
        int i4 = this.f35473l;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = i4 == Integer.MIN_VALUE ? null : (AccessibilityNodeInfoCompat) sparseArrayCompatY.g(i4);
        if (i3 == 1 || i3 == 2) {
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.d(sparseArrayCompatY, f35464p, f35463o, accessibilityNodeInfoCompat2, i3, ViewCompat.y(this.f35470i) == 1, false);
        } else {
            if (i3 != 17 && i3 != 33 && i3 != 66 && i3 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i5 = this.f35473l;
            if (i5 != Integer.MIN_VALUE) {
                z(i5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                E(this.f35470i, i3, rect2);
            }
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.c(sparseArrayCompatY, f35464p, f35463o, accessibilityNodeInfoCompat2, rect2, i3);
        }
        return X(accessibilityNodeInfoCompat != null ? sparseArrayCompatY.k(sparseArrayCompatY.j(accessibilityNodeInfoCompat)) : Integer.MIN_VALUE);
    }

    private boolean U(int i3, int i4, Bundle bundle) {
        return i4 != 1 ? i4 != 2 ? i4 != 64 ? i4 != 128 ? N(i3, i4, bundle) : n(i3) : W(i3) : o(i3) : X(i3);
    }

    private boolean V(int i3, Bundle bundle) {
        return ViewCompat.b0(this.f35470i, i3, bundle);
    }

    private boolean W(int i3) {
        int i4;
        if (!this.f35469h.isEnabled() || !this.f35469h.isTouchExplorationEnabled() || (i4 = this.f35472k) == i3) {
            return false;
        }
        if (i4 != Integer.MIN_VALUE) {
            n(i4);
        }
        this.f35472k = i3;
        this.f35470i.invalidate();
        Y(i3, 32768);
        return true;
    }

    private void Z(int i3) {
        int i4 = this.f35474m;
        if (i4 == i3) {
            return;
        }
        this.f35474m = i3;
        Y(i3, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        Y(i4, Function.MAX_NARGS);
    }

    private boolean n(int i3) {
        if (this.f35472k != i3) {
            return false;
        }
        this.f35472k = Integer.MIN_VALUE;
        this.f35470i.invalidate();
        Y(i3, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        return true;
    }

    private boolean p() {
        int i3 = this.f35473l;
        return i3 != Integer.MIN_VALUE && N(i3, 16, null);
    }

    private AccessibilityEvent q(int i3, int i4) {
        return i3 != -1 ? r(i3, i4) : s(i4);
    }

    private AccessibilityEvent r(int i3, int i4) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i4);
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatL = L(i3);
        accessibilityEventObtain.getText().add(accessibilityNodeInfoCompatL.y());
        accessibilityEventObtain.setContentDescription(accessibilityNodeInfoCompatL.r());
        accessibilityEventObtain.setScrollable(accessibilityNodeInfoCompatL.Q());
        accessibilityEventObtain.setPassword(accessibilityNodeInfoCompatL.P());
        accessibilityEventObtain.setEnabled(accessibilityNodeInfoCompatL.J());
        accessibilityEventObtain.setChecked(accessibilityNodeInfoCompatL.G());
        P(i3, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(accessibilityNodeInfoCompatL.o());
        AccessibilityRecordCompat.c(accessibilityEventObtain, this.f35470i, i3);
        accessibilityEventObtain.setPackageName(this.f35470i.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    private AccessibilityEvent s(int i3) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i3);
        this.f35470i.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    private AccessibilityNodeInfoCompat t(int i3) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatV = AccessibilityNodeInfoCompat.V();
        accessibilityNodeInfoCompatV.q0(true);
        accessibilityNodeInfoCompatV.s0(true);
        accessibilityNodeInfoCompatV.i0("android.view.View");
        Rect rect = f35462n;
        accessibilityNodeInfoCompatV.d0(rect);
        accessibilityNodeInfoCompatV.e0(rect);
        accessibilityNodeInfoCompatV.E0(this.f35470i);
        R(i3, accessibilityNodeInfoCompatV);
        if (accessibilityNodeInfoCompatV.y() == null && accessibilityNodeInfoCompatV.r() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoCompatV.k(this.f35466e);
        if (this.f35466e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int i4 = accessibilityNodeInfoCompatV.i();
        if ((i4 & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoCompatV.C0(this.f35470i.getContext().getPackageName());
        accessibilityNodeInfoCompatV.O0(this.f35470i, i3);
        if (this.f35472k == i3) {
            accessibilityNodeInfoCompatV.b0(true);
            accessibilityNodeInfoCompatV.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        } else {
            accessibilityNodeInfoCompatV.b0(false);
            accessibilityNodeInfoCompatV.a(64);
        }
        boolean z2 = this.f35473l == i3;
        if (z2) {
            accessibilityNodeInfoCompatV.a(2);
        } else if (accessibilityNodeInfoCompatV.K()) {
            accessibilityNodeInfoCompatV.a(1);
        }
        accessibilityNodeInfoCompatV.t0(z2);
        this.f35470i.getLocationOnScreen(this.f35468g);
        accessibilityNodeInfoCompatV.l(this.f35465d);
        if (this.f35465d.equals(rect)) {
            accessibilityNodeInfoCompatV.k(this.f35465d);
            if (accessibilityNodeInfoCompatV.f34566b != -1) {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompatV2 = AccessibilityNodeInfoCompat.V();
                for (int i5 = accessibilityNodeInfoCompatV.f34566b; i5 != -1; i5 = accessibilityNodeInfoCompatV2.f34566b) {
                    accessibilityNodeInfoCompatV2.F0(this.f35470i, -1);
                    accessibilityNodeInfoCompatV2.d0(f35462n);
                    R(i5, accessibilityNodeInfoCompatV2);
                    accessibilityNodeInfoCompatV2.k(this.f35466e);
                    Rect rect2 = this.f35465d;
                    Rect rect3 = this.f35466e;
                    rect2.offset(rect3.left, rect3.top);
                }
                accessibilityNodeInfoCompatV2.Z();
            }
            this.f35465d.offset(this.f35468g[0] - this.f35470i.getScrollX(), this.f35468g[1] - this.f35470i.getScrollY());
        }
        if (this.f35470i.getLocalVisibleRect(this.f35467f)) {
            this.f35467f.offset(this.f35468g[0] - this.f35470i.getScrollX(), this.f35468g[1] - this.f35470i.getScrollY());
            if (this.f35465d.intersect(this.f35467f)) {
                accessibilityNodeInfoCompatV.e0(this.f35465d);
                if (I(this.f35465d)) {
                    accessibilityNodeInfoCompatV.X0(true);
                }
            }
        }
        return accessibilityNodeInfoCompatV;
    }

    private AccessibilityNodeInfoCompat u() {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatW = AccessibilityNodeInfoCompat.W(this.f35470i);
        ViewCompat.Z(this.f35470i, accessibilityNodeInfoCompatW);
        ArrayList arrayList = new ArrayList();
        D(arrayList);
        if (accessibilityNodeInfoCompatW.n() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            accessibilityNodeInfoCompatW.d(this.f35470i, ((Integer) arrayList.get(i3)).intValue());
        }
        return accessibilityNodeInfoCompatW;
    }

    private SparseArrayCompat y() {
        ArrayList arrayList = new ArrayList();
        D(arrayList);
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            sparseArrayCompat.m(((Integer) arrayList.get(i3)).intValue(), t(((Integer) arrayList.get(i3)).intValue()));
        }
        return sparseArrayCompat;
    }

    private void z(int i3, Rect rect) {
        L(i3).k(rect);
    }

    public int A() {
        return x();
    }

    public final int B() {
        return this.f35473l;
    }

    protected abstract int C(float f3, float f4);

    protected abstract void D(List list);

    public final void F() {
        H(-1, 1);
    }

    public final void G(int i3) {
        H(i3, 0);
    }

    public final void H(int i3, int i4) {
        ViewParent parent;
        if (i3 == Integer.MIN_VALUE || !this.f35469h.isEnabled() || (parent = this.f35470i.getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventQ = q(i3, 2048);
        AccessibilityEventCompat.b(accessibilityEventQ, i4);
        parent.requestSendAccessibilityEvent(this.f35470i, accessibilityEventQ);
    }

    AccessibilityNodeInfoCompat L(int i3) {
        return i3 == -1 ? u() : t(i3);
    }

    public final void M(boolean z2, int i3, Rect rect) {
        int i4 = this.f35473l;
        if (i4 != Integer.MIN_VALUE) {
            o(i4);
        }
        if (z2) {
            K(i3, rect);
        }
    }

    protected abstract boolean N(int i3, int i4, Bundle bundle);

    protected abstract void R(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    boolean T(int i3, int i4, Bundle bundle) {
        return i3 != -1 ? U(i3, i4, bundle) : V(i4, bundle);
    }

    public final boolean X(int i3) {
        int i4;
        if ((!this.f35470i.isFocused() && !this.f35470i.requestFocus()) || (i4 = this.f35473l) == i3) {
            return false;
        }
        if (i4 != Integer.MIN_VALUE) {
            o(i4);
        }
        if (i3 == Integer.MIN_VALUE) {
            return false;
        }
        this.f35473l = i3;
        S(i3, true);
        Y(i3, 8);
        return true;
    }

    public final boolean Y(int i3, int i4) {
        ViewParent parent;
        if (i3 == Integer.MIN_VALUE || !this.f35469h.isEnabled() || (parent = this.f35470i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f35470i, q(i3, i4));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat b(View view) {
        if (this.f35471j == null) {
            this.f35471j = new MyNodeProvider();
        }
        return this.f35471j;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        O(accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.g(view, accessibilityNodeInfoCompat);
        Q(accessibilityNodeInfoCompat);
    }

    public final boolean o(int i3) {
        if (this.f35473l != i3) {
            return false;
        }
        this.f35473l = Integer.MIN_VALUE;
        S(i3, false);
        Y(i3, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (this.f35469h.isEnabled() && this.f35469h.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7 && action != 9) {
                if (action != 10 || this.f35474m == Integer.MIN_VALUE) {
                    return false;
                }
                Z(Integer.MIN_VALUE);
                return true;
            }
            int iC = C(motionEvent.getX(), motionEvent.getY());
            Z(iC);
            if (iC != Integer.MIN_VALUE) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean w(android.view.KeyEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L5d
            int r0 = r7.getKeyCode()
            r3 = 61
            r4 = 0
            if (r0 == r3) goto L46
            r3 = 66
            if (r0 == r3) goto L36
            switch(r0) {
                case 19: goto L19;
                case 20: goto L19;
                case 21: goto L19;
                case 22: goto L19;
                case 23: goto L36;
                default: goto L18;
            }
        L18:
            goto L5d
        L19:
            boolean r3 = r7.hasNoModifiers()
            if (r3 == 0) goto L5d
            int r0 = J(r0)
            int r7 = r7.getRepeatCount()
            int r7 = r7 + r2
            r3 = r1
        L29:
            if (r1 >= r7) goto L35
            boolean r5 = r6.K(r0, r4)
            if (r5 == 0) goto L35
            int r1 = r1 + 1
            r3 = r2
            goto L29
        L35:
            return r3
        L36:
            boolean r0 = r7.hasNoModifiers()
            if (r0 == 0) goto L5d
            int r7 = r7.getRepeatCount()
            if (r7 != 0) goto L5d
            r6.p()
            return r2
        L46:
            boolean r0 = r7.hasNoModifiers()
            if (r0 == 0) goto L52
            r7 = 2
            boolean r7 = r6.K(r7, r4)
            return r7
        L52:
            boolean r7 = r7.hasModifiers(r2)
            if (r7 == 0) goto L5d
            boolean r7 = r6.K(r2, r4)
            return r7
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ExploreByTouchHelper.w(android.view.KeyEvent):boolean");
    }

    public final int x() {
        return this.f35472k;
    }

    protected void O(AccessibilityEvent accessibilityEvent) {
    }

    protected void Q(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    protected void P(int i3, AccessibilityEvent accessibilityEvent) {
    }

    protected void S(int i3, boolean z2) {
    }
}
