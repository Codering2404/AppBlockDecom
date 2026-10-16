package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzm extends zzxv implements zzzh {
    private static final zzm zza;
    private byte zzf = 2;
    private zzyd zzd = zzxv.zzah();
    private zzyd zze = zzxv.zzah();

    static {
        zzm zzmVar = new zzm();
        zza = zzmVar;
        zzxv.zzan(zzm.class, zzmVar);
    }

    private zzm() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzf);
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0002\u0001Л\u0002Л", new Object[]{"zzd", zzk.class, "zze", zzg.class});
        }
        if (i4 == 3) {
            return new zzm();
        }
        zzc zzcVar = null;
        if (i4 == 4) {
            return new zzl(zzcVar);
        }
        if (i4 == 5) {
            return zza;
        }
        this.zzf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
