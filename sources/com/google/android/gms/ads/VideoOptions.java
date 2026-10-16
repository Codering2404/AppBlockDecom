package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzfw;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class VideoOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f69703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f69704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f69705c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f69706a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f69707b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f69708c = false;

        public VideoOptions a() {
            return new VideoOptions(this, null);
        }

        public Builder b(boolean z2) {
            this.f69708c = z2;
            return this;
        }

        public Builder c(boolean z2) {
            this.f69707b = z2;
            return this;
        }

        public Builder d(boolean z2) {
            this.f69706a = z2;
            return this;
        }

        final /* synthetic */ boolean e() {
            return this.f69706a;
        }

        final /* synthetic */ boolean f() {
            return this.f69707b;
        }

        final /* synthetic */ boolean g() {
            return this.f69708c;
        }
    }

    /* synthetic */ VideoOptions(Builder builder, byte[] bArr) {
        this.f69703a = builder.e();
        this.f69704b = builder.f();
        this.f69705c = builder.g();
    }

    public boolean a() {
        return this.f69705c;
    }

    public boolean b() {
        return this.f69704b;
    }

    public boolean c() {
        return this.f69703a;
    }

    public VideoOptions(zzfw zzfwVar) {
        this.f69703a = zzfwVar.f69956a;
        this.f69704b = zzfwVar.f69957b;
        this.f69705c = zzfwVar.f69958c;
    }
}
