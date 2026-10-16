package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzve extends zzxr implements zzzh {
    private static final zzve zzd;
    private int zze;
    private zzva zzg;
    private zzvy zzi;
    private byte zzk = 2;
    private zzyd zzf = zzzq.zze();
    private zzyd zzh = zzzq.zze();
    private int zzj = 1;

    static {
        zzve zzveVar = new zzve();
        zzd = zzveVar;
        zzxv.zzan(zzve.class, zzveVar);
    }

    private zzve() {
    }

    public static zzve zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i4 == 2) {
            return new zzzr(zzd, "\u0001\u0005\u0000\u0001\u0001ϧ\u0005\u0000\u0002\u0002\u0001ဉ\u0000\u0002\u001b\u0003᠌\u00022ᐉ\u0001ϧЛ", new Object[]{"zze", "zzg", "zzh", zzuy.class, "zzj", zzvc.zza, "zzi", "zzf", zzxb.class});
        }
        if (i4 == 3) {
            return new zzve();
        }
        zzus zzusVar = null;
        if (i4 == 4) {
            return new zzuw(zzusVar);
        }
        if (i4 == 5) {
            return zzd;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
