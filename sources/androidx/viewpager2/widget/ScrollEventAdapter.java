package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f53834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewPager2 f53835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView f53836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayoutManager f53837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f53838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f53839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ScrollEventValues f53840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f53841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f53842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f53843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f53844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f53845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f53846m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ScrollEventValues {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f53847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f53848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f53849c;

        ScrollEventValues() {
        }

        void a() {
            this.f53847a = -1;
            this.f53848b = 0.0f;
            this.f53849c = 0;
        }
    }

    ScrollEventAdapter(ViewPager2 viewPager2) {
        this.f53835b = viewPager2;
        RecyclerView recyclerView = viewPager2.f53860k;
        this.f53836c = recyclerView;
        this.f53837d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f53840g = new ScrollEventValues();
        n();
    }

    private void c(int i3, float f3, int i4) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f53834a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.b(i3, f3, i4);
        }
    }

    private void d(int i3) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f53834a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.c(i3);
        }
    }

    private void e(int i3) {
        if ((this.f53838e == 3 && this.f53839f == 0) || this.f53839f == i3) {
            return;
        }
        this.f53839f = i3;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f53834a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.a(i3);
        }
    }

    private int f() {
        return this.f53837d.d2();
    }

    private boolean k() {
        int i3 = this.f53838e;
        return i3 == 1 || i3 == 4;
    }

    private void n() {
        this.f53838e = 0;
        this.f53839f = 0;
        this.f53840g.a();
        this.f53841h = -1;
        this.f53842i = -1;
        this.f53843j = false;
        this.f53844k = false;
        this.f53846m = false;
        this.f53845l = false;
    }

    private void p(boolean z2) {
        this.f53846m = z2;
        this.f53838e = z2 ? 4 : 1;
        int i3 = this.f53842i;
        if (i3 != -1) {
            this.f53841h = i3;
            this.f53842i = -1;
        } else if (this.f53841h == -1) {
            this.f53841h = f();
        }
        e(1);
    }

    private void q() {
        int top;
        ScrollEventValues scrollEventValues = this.f53840g;
        int iD2 = this.f53837d.d2();
        scrollEventValues.f53847a = iD2;
        if (iD2 == -1) {
            scrollEventValues.a();
            return;
        }
        View viewI = this.f53837d.I(iD2);
        if (viewI == null) {
            scrollEventValues.a();
            return;
        }
        int iF0 = this.f53837d.f0(viewI);
        int iO0 = this.f53837d.o0(viewI);
        int iR0 = this.f53837d.r0(viewI);
        int iN = this.f53837d.N(viewI);
        ViewGroup.LayoutParams layoutParams = viewI.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            iF0 += marginLayoutParams.leftMargin;
            iO0 += marginLayoutParams.rightMargin;
            iR0 += marginLayoutParams.topMargin;
            iN += marginLayoutParams.bottomMargin;
        }
        int height = viewI.getHeight() + iR0 + iN;
        int width = viewI.getWidth() + iF0 + iO0;
        if (this.f53837d.q2() == 0) {
            top = (viewI.getLeft() - iF0) - this.f53836c.getPaddingLeft();
            if (this.f53835b.d()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewI.getTop() - iR0) - this.f53836c.getPaddingTop();
        }
        int i3 = -top;
        scrollEventValues.f53849c = i3;
        if (i3 >= 0) {
            scrollEventValues.f53848b = height == 0 ? 0.0f : i3 / height;
        } else {
            if (!new AnimateLayoutChangeDetector(this.f53837d).d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f53849c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void a(RecyclerView recyclerView, int i3) {
        if (!(this.f53838e == 1 && this.f53839f == 1) && i3 == 1) {
            p(false);
            return;
        }
        if (k() && i3 == 2) {
            if (this.f53844k) {
                e(2);
                this.f53843j = true;
                return;
            }
            return;
        }
        if (k() && i3 == 0) {
            q();
            if (this.f53844k) {
                ScrollEventValues scrollEventValues = this.f53840g;
                if (scrollEventValues.f53849c == 0) {
                    int i4 = this.f53841h;
                    int i5 = scrollEventValues.f53847a;
                    if (i4 != i5) {
                        d(i5);
                    }
                }
            } else {
                int i6 = this.f53840g.f53847a;
                if (i6 != -1) {
                    c(i6, 0.0f, 0);
                }
            }
            e(0);
            n();
        }
        if (this.f53838e == 2 && i3 == 0 && this.f53845l) {
            q();
            ScrollEventValues scrollEventValues2 = this.f53840g;
            if (scrollEventValues2.f53849c == 0) {
                int i7 = this.f53842i;
                int i8 = scrollEventValues2.f53847a;
                if (i7 != i8) {
                    if (i8 == -1) {
                        i8 = 0;
                    }
                    d(i8);
                }
                e(0);
                n();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f53844k = r4
            r3.q()
            boolean r0 = r3.f53843j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L37
            r3.f53843j = r2
            if (r6 > 0) goto L1f
            if (r6 != 0) goto L29
            if (r5 >= 0) goto L16
            r5 = r4
            goto L17
        L16:
            r5 = r2
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f53835b
            boolean r6 = r6.d()
            if (r5 != r6) goto L29
        L1f:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f53840g
            int r6 = r5.f53849c
            if (r6 == 0) goto L29
            int r5 = r5.f53847a
            int r5 = r5 + r4
            goto L2d
        L29:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f53840g
            int r5 = r5.f53847a
        L2d:
            r3.f53842i = r5
            int r6 = r3.f53841h
            if (r6 == r5) goto L45
            r3.d(r5)
            goto L45
        L37:
            int r5 = r3.f53838e
            if (r5 != 0) goto L45
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f53840g
            int r5 = r5.f53847a
            if (r5 != r1) goto L42
            r5 = r2
        L42:
            r3.d(r5)
        L45:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f53840g
            int r6 = r5.f53847a
            if (r6 != r1) goto L4c
            r6 = r2
        L4c:
            float r0 = r5.f53848b
            int r5 = r5.f53849c
            r3.c(r6, r0, r5)
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f53840g
            int r6 = r5.f53847a
            int r0 = r3.f53842i
            if (r6 == r0) goto L5d
            if (r0 != r1) goto L6b
        L5d:
            int r5 = r5.f53849c
            if (r5 != 0) goto L6b
            int r5 = r3.f53839f
            if (r5 == r4) goto L6b
            r3.e(r2)
            r3.n()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.b(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    double g() {
        q();
        ScrollEventValues scrollEventValues = this.f53840g;
        return ((double) scrollEventValues.f53847a) + ((double) scrollEventValues.f53848b);
    }

    int h() {
        return this.f53839f;
    }

    boolean i() {
        return this.f53846m;
    }

    boolean j() {
        return this.f53839f == 0;
    }

    void l() {
        this.f53845l = true;
    }

    void m(int i3, boolean z2) {
        this.f53838e = z2 ? 2 : 3;
        this.f53846m = false;
        boolean z3 = this.f53842i != i3;
        this.f53842i = i3;
        e(2);
        if (z3) {
            d(i3);
        }
    }

    void o(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f53834a = onPageChangeCallback;
    }
}
