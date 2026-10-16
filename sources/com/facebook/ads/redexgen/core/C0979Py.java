package com.facebook.ads.redexgen.core;

import android.view.WindowInsets;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Py, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0979Py {
    public final Object A00;

    public C0979Py(Object obj) {
        this.A00 = obj;
    }

    public static C0979Py A00(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C0979Py(obj);
    }

    public static Object A01(C0979Py c0979Py) {
        if (c0979Py == null) {
            return null;
        }
        return c0979Py.A00;
    }

    public final int A02() {
        return ((WindowInsets) this.A00).getSystemWindowInsetBottom();
    }

    public final int A03() {
        return ((WindowInsets) this.A00).getSystemWindowInsetLeft();
    }

    public final int A04() {
        return ((WindowInsets) this.A00).getSystemWindowInsetRight();
    }

    public final int A05() {
        return ((WindowInsets) this.A00).getSystemWindowInsetTop();
    }

    public final C0979Py A06(int i3, int i4, int i5, int i6) {
        return new C0979Py(((WindowInsets) this.A00).replaceSystemWindowInsets(i3, i4, i5, i6));
    }

    public final boolean A07() {
        return ((WindowInsets) this.A00).isConsumed();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0979Py c0979Py = (C0979Py) obj;
        return this.A00 == null ? c0979Py.A00 == null : this.A00.equals(c0979Py.A00);
    }

    public final int hashCode() {
        if (this.A00 == null) {
            return 0;
        }
        return this.A00.hashCode();
    }
}
