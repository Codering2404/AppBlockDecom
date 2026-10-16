package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzag extends zzxv implements zzzh {
    public static final zzxt zza;
    private static final zzag zzd;
    private int zze;
    private int zzi;
    private int zzk;
    private int zzl;
    private zzya zzf = zzxv.zzag();
    private zzya zzg = zzxv.zzag();
    private zzya zzh = zzxv.zzag();
    private zzya zzj = zzxv.zzag();

    static {
        zzag zzagVar = new zzag();
        zzd = zzagVar;
        zzxv.zzan(zzag.class, zzagVar);
        zza = zzxv.zzab(zzam.zzj(), zzagVar, zzagVar, null, 101, zzaba.zzk, zzag.class);
    }

    private zzag() {
    }

    public final int zza() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzxv.zzak(zzd, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001\u0016\u0002\u0016\u0003\u0016\u0004င\u0000\u0005\u0016\u0006င\u0001\u0007င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i4 == 3) {
            return new zzag();
        }
        zzn zznVar = null;
        if (i4 == 4) {
            return new zzaf(zznVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zzd;
    }

    public final int zzc() {
        return this.zzg.size();
    }

    public final int zzd() {
        return this.zzh.size();
    }

    public final List zzf() {
        return this.zzf;
    }

    public final List zzg() {
        return this.zzg;
    }

    public final List zzh() {
        return this.zzh;
    }

    public final List zzi() {
        return this.zzj;
    }
}
