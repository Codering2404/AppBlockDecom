package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwf extends zzxv implements zzzh {
    private static final zzwf zza;
    private int zzd;
    private int zze;
    private int zzg;
    private String zzf = "";
    private String zzh = "";

    static {
        zzwf zzwfVar = new zzwf();
        zza = zzwfVar;
        zzxv.zzan(zzwf.class, zzwfVar);
    }

    private zzwf() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            zzxz zzxzVar = zzuu.zza;
            return new zzzr(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0003\u0002ဈ\u0001\u0003᠌\u0000\u0004᠌\u0002", new Object[]{"zzd", "zzh", "zzf", "zze", zzxzVar, "zzg", zzxzVar});
        }
        if (i4 == 3) {
            return new zzwf();
        }
        zzus zzusVar = null;
        if (i4 == 4) {
            return new zzwe(zzusVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zza;
    }
}
