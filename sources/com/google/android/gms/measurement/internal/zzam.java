package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
enum zzam {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f73413a;

    zzam(char c3) {
        this.f73413a = c3;
    }

    public static zzam a(char c3) {
        for (zzam zzamVar : values()) {
            if (zzamVar.f73413a == c3) {
                return zzamVar;
            }
        }
        return UNSET;
    }

    final /* synthetic */ char b() {
        return this.f73413a;
    }
}
