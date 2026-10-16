package androidx.appcompat.widget;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class RtlSpacingHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2072a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2073b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2074c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2075d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2076e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2077f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2078g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2079h = false;

    RtlSpacingHelper() {
    }

    public int a() {
        return this.f2078g ? this.f2072a : this.f2073b;
    }

    public int b() {
        return this.f2072a;
    }

    public int c() {
        return this.f2073b;
    }

    public int d() {
        return this.f2078g ? this.f2073b : this.f2072a;
    }

    public void e(int i3, int i4) {
        this.f2079h = false;
        if (i3 != Integer.MIN_VALUE) {
            this.f2076e = i3;
            this.f2072a = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f2077f = i4;
            this.f2073b = i4;
        }
    }

    public void f(boolean z2) {
        if (z2 == this.f2078g) {
            return;
        }
        this.f2078g = z2;
        if (!this.f2079h) {
            this.f2072a = this.f2076e;
            this.f2073b = this.f2077f;
            return;
        }
        if (z2) {
            int i3 = this.f2075d;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f2076e;
            }
            this.f2072a = i3;
            int i4 = this.f2074c;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f2077f;
            }
            this.f2073b = i4;
            return;
        }
        int i5 = this.f2074c;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.f2076e;
        }
        this.f2072a = i5;
        int i6 = this.f2075d;
        if (i6 == Integer.MIN_VALUE) {
            i6 = this.f2077f;
        }
        this.f2073b = i6;
    }

    public void g(int i3, int i4) {
        this.f2074c = i3;
        this.f2075d = i4;
        this.f2079h = true;
        if (this.f2078g) {
            if (i4 != Integer.MIN_VALUE) {
                this.f2072a = i4;
            }
            if (i3 != Integer.MIN_VALUE) {
                this.f2073b = i3;
                return;
            }
            return;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f2072a = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f2073b = i4;
        }
    }
}
