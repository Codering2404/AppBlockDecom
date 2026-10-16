package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ChildHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callback f51526a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f51530e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f51529d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Bucket f51527b = new Bucket();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List f51528c = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Bucket {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f51531a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Bucket f51532b;

        Bucket() {
        }

        private void c() {
            if (this.f51532b == null) {
                this.f51532b = new Bucket();
            }
        }

        void a(int i3) {
            if (i3 < 64) {
                this.f51531a &= ~(1 << i3);
                return;
            }
            Bucket bucket = this.f51532b;
            if (bucket != null) {
                bucket.a(i3 - 64);
            }
        }

        int b(int i3) {
            Bucket bucket = this.f51532b;
            return bucket == null ? i3 >= 64 ? Long.bitCount(this.f51531a) : Long.bitCount(this.f51531a & ((1 << i3) - 1)) : i3 < 64 ? Long.bitCount(this.f51531a & ((1 << i3) - 1)) : bucket.b(i3 - 64) + Long.bitCount(this.f51531a);
        }

        boolean d(int i3) {
            if (i3 < 64) {
                return (this.f51531a & (1 << i3)) != 0;
            }
            c();
            return this.f51532b.d(i3 - 64);
        }

        void e(int i3, boolean z2) {
            if (i3 >= 64) {
                c();
                this.f51532b.e(i3 - 64, z2);
                return;
            }
            long j3 = this.f51531a;
            boolean z3 = (Long.MIN_VALUE & j3) != 0;
            long j4 = (1 << i3) - 1;
            this.f51531a = ((j3 & (~j4)) << 1) | (j3 & j4);
            if (z2) {
                h(i3);
            } else {
                a(i3);
            }
            if (z3 || this.f51532b != null) {
                c();
                this.f51532b.e(0, z3);
            }
        }

        boolean f(int i3) {
            if (i3 >= 64) {
                c();
                return this.f51532b.f(i3 - 64);
            }
            long j3 = 1 << i3;
            long j4 = this.f51531a;
            boolean z2 = (j4 & j3) != 0;
            long j5 = j4 & (~j3);
            this.f51531a = j5;
            long j6 = j3 - 1;
            this.f51531a = (j5 & j6) | Long.rotateRight((~j6) & j5, 1);
            Bucket bucket = this.f51532b;
            if (bucket != null) {
                if (bucket.d(0)) {
                    h(63);
                }
                this.f51532b.f(0);
            }
            return z2;
        }

        void g() {
            this.f51531a = 0L;
            Bucket bucket = this.f51532b;
            if (bucket != null) {
                bucket.g();
            }
        }

        void h(int i3) {
            if (i3 < 64) {
                this.f51531a |= 1 << i3;
            } else {
                c();
                this.f51532b.h(i3 - 64);
            }
        }

        public String toString() {
            if (this.f51532b == null) {
                return Long.toBinaryString(this.f51531a);
            }
            return this.f51532b.toString() + "xx" + Long.toBinaryString(this.f51531a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Callback {
        View a(int i3);

        void addView(View view, int i3);

        void b(View view);

        int c();

        RecyclerView.ViewHolder d(View view);

        void e(int i3);

        void f();

        int g(View view);

        void h(View view);

        void i(int i3);

        void j(View view, int i3, ViewGroup.LayoutParams layoutParams);
    }

    ChildHelper(Callback callback) {
        this.f51526a = callback;
    }

    private int h(int i3) {
        if (i3 < 0) {
            return -1;
        }
        int iC = this.f51526a.c();
        int i4 = i3;
        while (i4 < iC) {
            int iB = i3 - (i4 - this.f51527b.b(i4));
            if (iB == 0) {
                while (this.f51527b.d(i4)) {
                    i4++;
                }
                return i4;
            }
            i4 += iB;
        }
        return -1;
    }

    private void l(View view) {
        this.f51528c.add(view);
        this.f51526a.b(view);
    }

    private boolean t(View view) {
        if (!this.f51528c.remove(view)) {
            return false;
        }
        this.f51526a.h(view);
        return true;
    }

    void a(View view, int i3, boolean z2) {
        int iC = i3 < 0 ? this.f51526a.c() : h(i3);
        this.f51527b.e(iC, z2);
        if (z2) {
            l(view);
        }
        this.f51526a.addView(view, iC);
    }

    void b(View view, boolean z2) {
        a(view, -1, z2);
    }

    void c(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z2) {
        int iC = i3 < 0 ? this.f51526a.c() : h(i3);
        this.f51527b.e(iC, z2);
        if (z2) {
            l(view);
        }
        this.f51526a.j(view, iC, layoutParams);
    }

    void d(int i3) {
        int iH = h(i3);
        this.f51527b.f(iH);
        this.f51526a.e(iH);
    }

    View e(int i3) {
        int size = this.f51528c.size();
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) this.f51528c.get(i4);
            RecyclerView.ViewHolder viewHolderD = this.f51526a.d(view);
            if (viewHolderD.getLayoutPosition() == i3 && !viewHolderD.isInvalid() && !viewHolderD.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    View f(int i3) {
        return this.f51526a.a(h(i3));
    }

    int g() {
        return this.f51526a.c() - this.f51528c.size();
    }

    View i(int i3) {
        return this.f51526a.a(i3);
    }

    int j() {
        return this.f51526a.c();
    }

    void k(View view) {
        int iG = this.f51526a.g(view);
        if (iG >= 0) {
            this.f51527b.h(iG);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int m(View view) {
        int iG = this.f51526a.g(view);
        if (iG == -1 || this.f51527b.d(iG)) {
            return -1;
        }
        return iG - this.f51527b.b(iG);
    }

    boolean n(View view) {
        return this.f51528c.contains(view);
    }

    void o() {
        this.f51527b.g();
        for (int size = this.f51528c.size() - 1; size >= 0; size--) {
            this.f51526a.h((View) this.f51528c.get(size));
            this.f51528c.remove(size);
        }
        this.f51526a.f();
    }

    void p(View view) {
        int i3 = this.f51529d;
        if (i3 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i3 == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            this.f51529d = 1;
            this.f51530e = view;
            int iG = this.f51526a.g(view);
            if (iG >= 0) {
                if (this.f51527b.f(iG)) {
                    t(view);
                }
                this.f51526a.i(iG);
            }
            this.f51529d = 0;
            this.f51530e = null;
        } catch (Throwable th) {
            this.f51529d = 0;
            this.f51530e = null;
            throw th;
        }
    }

    void q(int i3) {
        int i4 = this.f51529d;
        if (i4 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i4 == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            int iH = h(i3);
            View viewA = this.f51526a.a(iH);
            if (viewA != null) {
                this.f51529d = 1;
                this.f51530e = viewA;
                if (this.f51527b.f(iH)) {
                    t(viewA);
                }
                this.f51526a.i(iH);
            }
            this.f51529d = 0;
            this.f51530e = null;
        } catch (Throwable th) {
            this.f51529d = 0;
            this.f51530e = null;
            throw th;
        }
    }

    boolean r(View view) {
        int i3 = this.f51529d;
        if (i3 == 1) {
            if (this.f51530e == view) {
                return false;
            }
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeView(At) for a different view");
        }
        if (i3 == 2) {
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeViewIfHidden");
        }
        try {
            this.f51529d = 2;
            int iG = this.f51526a.g(view);
            if (iG == -1) {
                t(view);
                return true;
            }
            if (!this.f51527b.d(iG)) {
                return false;
            }
            this.f51527b.f(iG);
            t(view);
            this.f51526a.i(iG);
            return true;
        } finally {
            this.f51529d = 0;
        }
    }

    void s(View view) {
        int iG = this.f51526a.g(view);
        if (iG < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f51527b.d(iG)) {
            this.f51527b.a(iG);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f51527b.toString() + ", hidden list:" + this.f51528c.size();
    }
}
