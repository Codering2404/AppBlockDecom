package com.google.android.gms.ads.nativead;

import com.google.android.gms.ads.VideoOptions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class NativeAdOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f70545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f70546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f70547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f70548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final VideoOptions f70549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f70550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f70551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f70552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f70553i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public @interface AdChoicesPlacement {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private VideoOptions f70557d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f70554a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f70555b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f70556c = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f70558e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f70559f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f70560g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f70561h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f70562i = 1;

        public NativeAdOptions a() {
            return new NativeAdOptions(this, null);
        }

        public Builder b(int i3, boolean z2) {
            this.f70560g = z2;
            this.f70561h = i3;
            return this;
        }

        public Builder c(int i3) {
            this.f70558e = i3;
            return this;
        }

        public Builder d(int i3) {
            this.f70555b = i3;
            return this;
        }

        public Builder e(boolean z2) {
            this.f70559f = z2;
            return this;
        }

        public Builder f(boolean z2) {
            this.f70556c = z2;
            return this;
        }

        public Builder g(boolean z2) {
            this.f70554a = z2;
            return this;
        }

        public Builder h(VideoOptions videoOptions) {
            this.f70557d = videoOptions;
            return this;
        }

        final /* synthetic */ boolean i() {
            return this.f70554a;
        }

        final /* synthetic */ int j() {
            return this.f70555b;
        }

        final /* synthetic */ boolean k() {
            return this.f70556c;
        }

        final /* synthetic */ VideoOptions l() {
            return this.f70557d;
        }

        final /* synthetic */ int m() {
            return this.f70558e;
        }

        final /* synthetic */ boolean n() {
            return this.f70559f;
        }

        final /* synthetic */ boolean o() {
            return this.f70560g;
        }

        final /* synthetic */ int p() {
            return this.f70561h;
        }

        public final Builder q(int i3) {
            this.f70562i = i3;
            return this;
        }

        final /* synthetic */ int r() {
            return this.f70562i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public @interface NativeMediaAspectRatio {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public @interface SwipeGestureDirection {
    }

    /* synthetic */ NativeAdOptions(Builder builder, byte[] bArr) {
        this.f70545a = builder.i();
        this.f70546b = builder.j();
        this.f70547c = builder.k();
        this.f70548d = builder.m();
        this.f70549e = builder.l();
        this.f70550f = builder.n();
        this.f70551g = builder.o();
        this.f70552h = builder.p();
        this.f70553i = builder.r();
    }

    public int a() {
        return this.f70548d;
    }

    public int b() {
        return this.f70546b;
    }

    public VideoOptions c() {
        return this.f70549e;
    }

    public boolean d() {
        return this.f70547c;
    }

    public boolean e() {
        return this.f70545a;
    }

    public final boolean f() {
        return this.f70550f;
    }

    public final int g() {
        return this.f70552h;
    }

    public final boolean h() {
        return this.f70551g;
    }

    public final int i() {
        return this.f70553i;
    }
}
