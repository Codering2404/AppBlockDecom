package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzg extends zzxv implements zzzh {
    private static final zzg zza;
    private int zzd;
    private zzam zzf;
    private byte zzh = 2;
    private zzyd zze = zzxv.zzah();
    private String zzg = "";

    static {
        zzg zzgVar = new zzg();
        zza = zzgVar;
        zzxv.zzan(zzg.class, zzgVar);
    }

    private zzg() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001Л\u0002ᐉ\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", zzi.class, "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzg();
        }
        zzc zzcVar = null;
        if (i4 == 4) {
            return new zzf(zzcVar);
        }
        if (i4 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
