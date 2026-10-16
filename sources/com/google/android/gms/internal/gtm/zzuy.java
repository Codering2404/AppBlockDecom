package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzuy extends zzxv implements zzzh {
    private static final zzuy zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private boolean zzh;
    private boolean zzi;

    static {
        zzuy zzuyVar = new zzuy();
        zza = zzuyVar;
        zzxv.zzan(zzuy.class, zzuyVar);
    }

    private zzuy() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return new zzzr(zza, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0005ဇ\u0003\u0006ဇ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i4 == 3) {
            return new zzuy();
        }
        zzus zzusVar = null;
        if (i4 == 4) {
            return new zzux(zzusVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zza;
    }
}
