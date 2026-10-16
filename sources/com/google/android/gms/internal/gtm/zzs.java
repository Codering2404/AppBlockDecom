package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzs extends zzxv implements zzzh {
    private static final zzs zza;
    private int zzd;
    private int zze = 1;
    private int zzf;
    private int zzg;

    static {
        zzs zzsVar = new zzs();
        zza = zzsVar;
        zzxv.zzan(zzs.class, zzsVar);
    }

    private zzs() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", zzq.zza, "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzs();
        }
        zzn zznVar = null;
        if (i4 == 4) {
            return new zzo(zznVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zza;
    }
}
