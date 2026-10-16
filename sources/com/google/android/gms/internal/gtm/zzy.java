package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzy extends zzxv implements zzzh {
    private static final zzy zza;
    private byte zzg = 2;
    private zzyd zzd = zzxv.zzah();
    private zzyd zze = zzxv.zzah();
    private zzyd zzf = zzxv.zzah();

    static {
        zzy zzyVar = new zzy();
        zza = zzyVar;
        zzxv.zzan(zzy.class, zzyVar);
    }

    private zzy() {
    }

    public static zzy zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0003\u0002\u0001Л\u0002Л\u0003\u001b", new Object[]{"zzd", zzam.class, "zze", zzam.class, "zzf", zzw.class});
        }
        if (i4 == 3) {
            return new zzy();
        }
        zzn zznVar = null;
        if (i4 == 4) {
            return new zzx(zznVar);
        }
        if (i4 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final List zzd() {
        return this.zzf;
    }

    public final List zze() {
        return this.zze;
    }

    public final List zzf() {
        return this.zzd;
    }
}
