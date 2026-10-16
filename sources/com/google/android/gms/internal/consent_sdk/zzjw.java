package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjw extends zzqm implements zzrr {
    private static final zzjw zzb;

    static {
        zzjw zzjwVar = new zzjw();
        zzb = zzjwVar;
        zzqm.zzz(zzjw.class, zzjwVar);
    }

    private zzjw() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        zzkb zzkbVar = null;
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0000", null);
        }
        if (i4 == 3) {
            return new zzjw();
        }
        if (i4 == 4) {
            return new zzjv(zzkbVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
