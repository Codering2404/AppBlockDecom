package com.google.android.gms.ads.preload;

import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PreloadConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f70811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdFormat f70812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AdRequest f70813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f70814d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f70815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private AdFormat f70816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private AdRequest f70817c = new AdRequest.Builder().m();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f70818d;

        public Builder(String str, AdFormat adFormat) {
            this.f70815a = str;
            this.f70816b = adFormat;
        }

        public PreloadConfiguration a() {
            return new PreloadConfiguration(this, null);
        }

        public Builder b(AdRequest adRequest) {
            this.f70817c = adRequest;
            return this;
        }

        public Builder c(int i3) {
            this.f70818d = i3;
            return this;
        }

        final /* synthetic */ String d() {
            return this.f70815a;
        }

        final /* synthetic */ AdFormat e() {
            return this.f70816b;
        }

        final /* synthetic */ AdRequest f() {
            return this.f70817c;
        }

        final /* synthetic */ int g() {
            return this.f70818d;
        }
    }

    /* synthetic */ PreloadConfiguration(Builder builder, byte[] bArr) {
        this.f70811a = builder.d();
        this.f70812b = builder.e();
        this.f70813c = builder.f();
        this.f70814d = builder.g();
    }
}
