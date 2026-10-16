package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzi extends zzxv implements zzzh {
    private static final zzi zza;
    private int zzd;
    private zzam zzf;
    private byte zzg = 2;
    private String zze = "";

    static {
        zzi zziVar = new zzi();
        zza = zziVar;
        zzxv.zzan(zzi.class, zziVar);
    }

    private zzi() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᐉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzi();
        }
        zzc zzcVar = null;
        if (i4 == 4) {
            return new zzh(zzcVar);
        }
        if (i4 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
