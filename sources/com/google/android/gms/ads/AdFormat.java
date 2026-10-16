package com.google.android.gms.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum AdFormat {
    BANNER(0),
    INTERSTITIAL(1),
    REWARDED(2),
    REWARDED_INTERSTITIAL(3),
    NATIVE(4),
    APP_OPEN_AD(6);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f69638a;

    AdFormat(int i3) {
        this.f69638a = i3;
    }

    public static AdFormat a(int i3) {
        for (AdFormat adFormat : values()) {
            if (adFormat.b() == i3) {
                return adFormat;
            }
        }
        return null;
    }

    public int b() {
        return this.f69638a;
    }
}
