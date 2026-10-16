package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhx extends zzqm implements zzrr {
    private static final zzhx zzb;
    private int zzd;
    private zzhw zze;
    private zzhp zzf;

    static {
        zzhx zzhxVar = new zzhx();
        zzb = zzhxVar;
        zzqm.zzz(zzhx.class, zzhxVar);
    }

    private zzhx() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzhx();
        }
        zzib zzibVar = null;
        if (i4 == 4) {
            return new zzhn(zzibVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
