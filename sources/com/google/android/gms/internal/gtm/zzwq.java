package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwq extends zzxv implements zzzh {
    private static final zzwq zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzwq zzwqVar = new zzwq();
        zza = zzwqVar;
        zzxv.zzan(zzwq.class, zzwqVar);
    }

    private zzwq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return new zzzr(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzwq();
        }
        zzus zzusVar = null;
        if (i4 == 4) {
            return new zzwp(zzusVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zza;
    }
}
