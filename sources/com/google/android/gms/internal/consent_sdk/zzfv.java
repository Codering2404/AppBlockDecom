package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfv extends zzqm implements zzrr {
    private static final zzfv zzb;
    private int zzd;
    private int zze;

    static {
        zzfv zzfvVar = new zzfv();
        zzb = zzfvVar;
        zzqm.zzz(zzfv.class, zzfvVar);
    }

    private zzfv() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzft.zza});
        }
        if (i4 == 3) {
            return new zzfv();
        }
        zzfu zzfuVar = null;
        if (i4 == 4) {
            return new zzfs(zzfuVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
