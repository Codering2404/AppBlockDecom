package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwx extends zzxr implements zzzh {
    private static final zzwx zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzk;
    private zzvy zzl;
    private byte zzn = 2;
    private String zzj = "";
    private zzyd zzm = zzzq.zze();

    static {
        zzwx zzwxVar = new zzwx();
        zzd = zzwxVar;
        zzxv.zzan(zzwx.class, zzwxVar);
    }

    private zzwx() {
    }

    public static zzwx zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzn);
        }
        if (i4 == 2) {
            return new zzzr(zzd, "\u0001\b\u0000\u0001\u0001ϧ\b\u0000\u0001\u0002\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0007ဇ\u0003\nဈ\u0004\u000bဇ\u0005\fᐉ\u0006ϧЛ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzxb.class});
        }
        if (i4 == 3) {
            return new zzwx();
        }
        zzus zzusVar = null;
        if (i4 == 4) {
            return new zzww(zzusVar);
        }
        if (i4 == 5) {
            return zzd;
        }
        this.zzn = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
