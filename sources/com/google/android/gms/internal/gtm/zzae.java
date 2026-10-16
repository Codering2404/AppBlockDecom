package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzae extends zzxv implements zzzh {
    private static final zzae zza;
    private zzya zzd = zzxv.zzag();
    private zzya zze = zzxv.zzag();
    private zzya zzf = zzxv.zzag();
    private zzya zzg = zzxv.zzag();
    private zzya zzh = zzxv.zzag();
    private zzya zzi = zzxv.zzag();
    private zzya zzj = zzxv.zzag();
    private zzya zzk = zzxv.zzag();
    private zzya zzl = zzxv.zzag();
    private zzya zzm = zzxv.zzag();

    static {
        zzae zzaeVar = new zzae();
        zza = zzaeVar;
        zzxv.zzan(zzae.class, zzaeVar);
    }

    private zzae() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\n\u0000\u0000\u0001\n\n\u0000\n\u0000\u0001\u0016\u0002\u0016\u0003\u0016\u0004\u0016\u0005\u0016\u0006\u0016\u0007\u0016\b\u0016\t\u0016\n\u0016", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i4 == 3) {
            return new zzae();
        }
        zzn zznVar = null;
        if (i4 == 4) {
            return new zzad(zznVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zza;
    }

    public final List zzc() {
        return this.zzj;
    }

    public final List zzd() {
        return this.zzl;
    }

    public final List zze() {
        return this.zzf;
    }

    public final List zzf() {
        return this.zzh;
    }

    public final List zzg() {
        return this.zze;
    }

    public final List zzh() {
        return this.zzd;
    }

    public final List zzi() {
        return this.zzk;
    }

    public final List zzj() {
        return this.zzm;
    }

    public final List zzk() {
        return this.zzg;
    }

    public final List zzl() {
        return this.zzi;
    }
}
