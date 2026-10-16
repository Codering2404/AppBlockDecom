package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxb extends zzxv implements zzzh {
    private static final zzxb zza;
    private int zzd;
    private long zzg;
    private long zzh;
    private double zzi;
    private byte zzl = 2;
    private zzyd zze = zzzq.zze();
    private String zzf = "";
    private zzud zzj = zzud.zzb;
    private String zzk = "";

    static {
        zzxb zzxbVar = new zzxb();
        zza = zzxbVar;
        zzxv.zzan(zzxb.class, zzxbVar);
    }

    private zzxb() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i4 == 2) {
            return new zzzr(zza, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"zzd", "zze", zzxa.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i4 == 3) {
            return new zzxb();
        }
        zzus zzusVar = null;
        if (i4 == 4) {
            return new zzwy(zzusVar);
        }
        if (i4 == 5) {
            return zza;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
