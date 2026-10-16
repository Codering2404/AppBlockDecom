package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class NativeAdOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f69720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f69721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f69722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f69723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f69724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final VideoOptions f69725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f69726g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public @interface AdChoicesPlacement {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private VideoOptions f69731e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f69727a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f69728b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f69729c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f69730d = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f69732f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f69733g = false;

        public NativeAdOptions a() {
            return new NativeAdOptions(this, null);
        }

        public Builder b(int i3) {
            this.f69732f = i3;
            return this;
        }

        public Builder c(int i3) {
            this.f69728b = i3;
            return this;
        }

        public Builder d(int i3) {
            this.f69729c = i3;
            return this;
        }

        public Builder e(boolean z2) {
            this.f69733g = z2;
            return this;
        }

        public Builder f(boolean z2) {
            this.f69730d = z2;
            return this;
        }

        public Builder g(boolean z2) {
            this.f69727a = z2;
            return this;
        }

        public Builder h(VideoOptions videoOptions) {
            this.f69731e = videoOptions;
            return this;
        }

        final /* synthetic */ boolean i() {
            return this.f69727a;
        }

        final /* synthetic */ int j() {
            return this.f69728b;
        }

        final /* synthetic */ int k() {
            return this.f69729c;
        }

        final /* synthetic */ boolean l() {
            return this.f69730d;
        }

        final /* synthetic */ VideoOptions m() {
            return this.f69731e;
        }

        final /* synthetic */ int n() {
            return this.f69732f;
        }

        final /* synthetic */ boolean o() {
            return this.f69733g;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public @interface NativeMediaAspectRatio {
    }

    /* synthetic */ NativeAdOptions(Builder builder, byte[] bArr) {
        this.f69720a = builder.i();
        this.f69721b = builder.j();
        this.f69722c = builder.k();
        this.f69723d = builder.l();
        this.f69724e = builder.n();
        this.f69725f = builder.m();
        this.f69726g = builder.o();
    }

    public int a() {
        return this.f69724e;
    }

    public int b() {
        return this.f69721b;
    }

    public int c() {
        return this.f69722c;
    }

    public VideoOptions d() {
        return this.f69725f;
    }

    public boolean e() {
        return this.f69723d;
    }

    public boolean f() {
        return this.f69720a;
    }

    public final boolean g() {
        return this.f69726g;
    }
}
