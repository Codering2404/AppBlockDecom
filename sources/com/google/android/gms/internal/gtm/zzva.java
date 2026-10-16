package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzva extends zzxv implements zzzh {
    private static final zzva zza;
    private int zzd;
    private boolean zzg;
    private String zze = "";
    private String zzf = "";
    private String zzh = "";

    static {
        zzva zzvaVar = new zzva();
        zza = zzvaVar;
        zzxv.zzan(zzva.class, zzvaVar);
    }

    private zzva() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return new zzzr(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzva();
        }
        zzus zzusVar = null;
        if (i4 == 4) {
            return new zzuz(zzusVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zza;
    }
}
