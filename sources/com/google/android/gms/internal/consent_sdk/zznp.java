package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznp extends zzqm implements zzrr {
    private static final zznp zzb;
    private int zzd;
    private zznl zze;
    private zznn zzf;
    private zznh zzg;
    private int zzh;

    static {
        zznp zznpVar = new zznp();
        zzb = zznpVar;
        zzqm.zzz(zznp.class, zznpVar);
    }

    private zznp() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001ဉ\u0001\u0002ဉ\u0002\u0003ဉ\u0000\u0005᠌\u0003", new Object[]{"zzd", "zzf", "zzg", "zze", "zzh", zzoy.zza()});
        }
        if (i4 == 3) {
            return new zznp();
        }
        zzno zznoVar = null;
        if (i4 == 4) {
            return new zznc(zznoVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
