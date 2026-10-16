package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzla extends zzqm implements zzrr {
    private static final zzla zzb;
    private int zzd;
    private zzkh zze;
    private zzkr zzf;
    private zzkj zzg;
    private zzkt zzh;
    private zzke zzi;
    private zzky zzj;
    private zzkw zzk;

    static {
        zzla zzlaVar = new zzla();
        zzb = zzlaVar;
        zzqm.zzz(zzla.class, zzlaVar);
    }

    private zzla() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i4 == 3) {
            return new zzla();
        }
        zzkz zzkzVar = null;
        if (i4 == 4) {
            return new zzkf(zzkzVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
