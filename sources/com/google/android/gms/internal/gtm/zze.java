package com.google.android.gms.internal.gtm;

import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zze extends zzxv implements zzzh {
    public static final zzxt zza;
    private static final zze zzd;
    private int zze;
    private zzm zzf;
    private zzg zzg;
    private byte zzh = 2;

    static {
        zze zzeVar = new zze();
        zzd = zzeVar;
        zzxv.zzan(zze.class, zzeVar);
        zza = zzxv.zzab(zzam.zzj(), zzeVar, zzeVar, null, 47497405, zzaba.zzk, zze.class);
    }

    private zze() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i4 == 2) {
            return zzxv.zzak(zzd, "\u0001\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0002\u0001ᐉ\u0000\u0003ᐉ\u0001", new Object[]{"zze", "zzf", CbYNFSEGaQj.fHJ});
        }
        if (i4 == 3) {
            return new zze();
        }
        zzc zzcVar = null;
        if (i4 == 4) {
            return new zzd(zzcVar);
        }
        if (i4 == 5) {
            return zzd;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
