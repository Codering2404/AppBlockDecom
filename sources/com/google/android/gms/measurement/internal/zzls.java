package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzls {
    GOOGLE_ANALYTICS(0),
    GOOGLE_SIGNAL(1),
    SGTM(2),
    SGTM_CLIENT(3),
    GOOGLE_SIGNAL_PENDING(4),
    UNKNOWN(99);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f74182a;

    zzls(int i3) {
        this.f74182a = i3;
    }

    public static zzls a(int i3) {
        for (zzls zzlsVar : values()) {
            if (zzlsVar.f74182a == i3) {
                return zzlsVar;
            }
        }
        return UNKNOWN;
    }

    public final int zza() {
        return this.f74182a;
    }
}
