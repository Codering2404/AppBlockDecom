package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class NestedScrollingChildHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewParent f34420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewParent f34421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f34422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f34423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f34424e;

    public NestedScrollingChildHelper(View view) {
        this.f34422c = view;
    }

    private boolean g(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        ViewParent viewParentH;
        int i8;
        int i9;
        int[] iArr3;
        if (!l() || (viewParentH = h(i7)) == null) {
            return false;
        }
        if (i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f34422c.getLocationInWindow(iArr);
            i8 = iArr[0];
            i9 = iArr[1];
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (iArr2 == null) {
            int[] iArrI = i();
            iArrI[0] = 0;
            iArrI[1] = 0;
            iArr3 = iArrI;
        } else {
            iArr3 = iArr2;
        }
        ViewParentCompat.d(viewParentH, this.f34422c, i3, i4, i5, i6, i7, iArr3);
        if (iArr != null) {
            this.f34422c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i8;
            iArr[1] = iArr[1] - i9;
        }
        return true;
    }

    private ViewParent h(int i3) {
        if (i3 == 0) {
            return this.f34420a;
        }
        if (i3 != 1) {
            return null;
        }
        return this.f34421b;
    }

    private int[] i() {
        if (this.f34424e == null) {
            this.f34424e = new int[2];
        }
        return this.f34424e;
    }

    private void n(int i3, ViewParent viewParent) {
        if (i3 == 0) {
            this.f34420a = viewParent;
        } else {
            if (i3 != 1) {
                return;
            }
            this.f34421b = viewParent;
        }
    }

    public boolean a(float f3, float f4, boolean z2) {
        ViewParent viewParentH;
        if (!l() || (viewParentH = h(0)) == null) {
            return false;
        }
        return ViewParentCompat.a(viewParentH, this.f34422c, f3, f4, z2);
    }

    public boolean b(float f3, float f4) {
        ViewParent viewParentH;
        if (!l() || (viewParentH = h(0)) == null) {
            return false;
        }
        return ViewParentCompat.b(viewParentH, this.f34422c, f3, f4);
    }

    public boolean c(int i3, int i4, int[] iArr, int[] iArr2) {
        return d(i3, i4, iArr, iArr2, 0);
    }

    public boolean d(int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        ViewParent viewParentH;
        int i6;
        int i7;
        if (!l() || (viewParentH = h(i5)) == null) {
            return false;
        }
        if (i3 == 0 && i4 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f34422c.getLocationInWindow(iArr2);
            i6 = iArr2[0];
            i7 = iArr2[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr == null) {
            iArr = i();
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        ViewParentCompat.c(viewParentH, this.f34422c, i3, i4, iArr3, i5);
        if (iArr2 != null) {
            this.f34422c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i6;
            iArr2[1] = iArr2[1] - i7;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public void e(int i3, int i4, int i5, int i6, int[] iArr, int i7, int[] iArr2) {
        g(i3, i4, i5, i6, iArr, i7, iArr2);
    }

    public boolean f(int i3, int i4, int i5, int i6, int[] iArr) {
        return g(i3, i4, i5, i6, iArr, 0, null);
    }

    public boolean j() {
        return k(0);
    }

    public boolean k(int i3) {
        return h(i3) != null;
    }

    public boolean l() {
        return this.f34423d;
    }

    public void m(boolean z2) {
        if (this.f34423d) {
            ViewCompat.N0(this.f34422c);
        }
        this.f34423d = z2;
    }

    public boolean o(int i3) {
        return p(i3, 0);
    }

    public boolean p(int i3, int i4) {
        if (k(i4)) {
            return true;
        }
        if (!l()) {
            return false;
        }
        View view = this.f34422c;
        for (ViewParent parent = this.f34422c.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.f(parent, view, this.f34422c, i3, i4)) {
                n(i4, parent);
                ViewParentCompat.e(parent, view, this.f34422c, i3, i4);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void q() {
        r(0);
    }

    public void r(int i3) {
        ViewParent viewParentH = h(i3);
        if (viewParentH != null) {
            ViewParentCompat.g(viewParentH, this.f34422c, i3);
            n(i3, null);
        }
    }
}
