package com.google.android.gms.internal.gtm;

import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzk extends zzxv implements zzzh {
    private static final zzk zza;
    private int zzd;
    private zzam zzk;
    private byte zzl = 2;
    private zzyd zze = zzxv.zzah();
    private zzyd zzf = zzxv.zzah();
    private zzyd zzg = zzxv.zzah();
    private zzyd zzh = zzxv.zzah();
    private zzyd zzi = zzxv.zzah();
    private zzyd zzj = zzxv.zzah();

    static {
        zzk zzkVar = new zzk();
        zza = zzkVar;
        zzxv.zzan(zzk.class, zzkVar);
    }

    private zzk() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0006\u0007\u0001Л\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007ᐉ\u0000", new Object[]{"zzd", "zze", zzg.class, "zzf", zzg.class, "zzg", zzg.class, "zzh", zzg.class, CbYNFSEGaQj.EVuhPYhWQO, zzg.class, "zzj", zzg.class, "zzk"});
        }
        if (i4 == 3) {
            return new zzk();
        }
        zzc zzcVar = null;
        if (i4 == 4) {
            return new zzj(zzcVar);
        }
        if (i4 == 5) {
            return zza;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
