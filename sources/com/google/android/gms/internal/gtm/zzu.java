package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzu extends zzxv implements zzzh {
    private static final zzu zza;
    private int zzd;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private byte zzj = 2;
    private zzya zze = zzxv.zzag();

    static {
        zzu zzuVar = new zzu();
        zza = zzuVar;
        zzxv.zzan(zzu.class, zzuVar);
    }

    private zzu() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0001\u0001\u0001ဇ\u0003\u0002ᔄ\u0000\u0003\u0016\u0004င\u0001\u0006ဇ\u0002", new Object[]{"zzd", "zzi", "zzf", "zze", "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzu();
        }
        zzn zznVar = null;
        if (i4 == 4) {
            return new zzt(zznVar);
        }
        if (i4 == 5) {
            return zza;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final List zzc() {
        return this.zze;
    }
}
