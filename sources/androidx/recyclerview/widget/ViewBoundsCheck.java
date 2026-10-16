package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ViewBoundsCheck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callback f52063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    BoundFlags f52064b = new BoundFlags();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BoundFlags {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f52065a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f52066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f52067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f52068d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f52069e;

        BoundFlags() {
        }

        void a(int i3) {
            this.f52065a = i3 | this.f52065a;
        }

        boolean b() {
            int i3 = this.f52065a;
            if ((i3 & 7) != 0 && (i3 & c(this.f52068d, this.f52066b)) == 0) {
                return false;
            }
            int i4 = this.f52065a;
            if ((i4 & 112) != 0 && (i4 & (c(this.f52068d, this.f52067c) << 4)) == 0) {
                return false;
            }
            int i5 = this.f52065a;
            if ((i5 & 1792) != 0 && (i5 & (c(this.f52069e, this.f52066b) << 8)) == 0) {
                return false;
            }
            int i6 = this.f52065a;
            return (i6 & 28672) == 0 || (i6 & (c(this.f52069e, this.f52067c) << 12)) != 0;
        }

        int c(int i3, int i4) {
            if (i3 > i4) {
                return 1;
            }
            return i3 == i4 ? 2 : 4;
        }

        void d() {
            this.f52065a = 0;
        }

        void e(int i3, int i4, int i5, int i6) {
            this.f52066b = i3;
            this.f52067c = i4;
            this.f52068d = i5;
            this.f52069e = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Callback {
        View a(int i3);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    ViewBoundsCheck(Callback callback) {
        this.f52063a = callback;
    }

    View a(int i3, int i4, int i5, int i6) {
        int iC = this.f52063a.c();
        int iD = this.f52063a.d();
        int i7 = i4 > i3 ? 1 : -1;
        View view = null;
        while (i3 != i4) {
            View viewA = this.f52063a.a(i3);
            this.f52064b.e(iC, iD, this.f52063a.b(viewA), this.f52063a.e(viewA));
            if (i5 != 0) {
                this.f52064b.d();
                this.f52064b.a(i5);
                if (this.f52064b.b()) {
                    return viewA;
                }
            }
            if (i6 != 0) {
                this.f52064b.d();
                this.f52064b.a(i6);
                if (this.f52064b.b()) {
                    view = viewA;
                }
            }
            i3 += i7;
        }
        return view;
    }

    boolean b(View view, int i3) {
        this.f52064b.e(this.f52063a.c(), this.f52063a.d(), this.f52063a.b(view), this.f52063a.e(view));
        if (i3 == 0) {
            return false;
        }
        this.f52064b.d();
        this.f52064b.a(i3);
        return this.f52064b.b();
    }
}
