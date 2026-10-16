package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzw extends zzxv implements zzzh {
    private static final zzw zza;
    private int zzd;
    private long zzf;
    private boolean zzh;
    private long zzi;
    private String zze = "";
    private long zzg = 2147483647L;

    static {
        zzw zzwVar = new zzw();
        zza = zzwVar;
        zzxv.zzan(zzw.class, zzwVar);
    }

    private zzw() {
    }

    public final long zza() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဇ\u0003\u0005ဂ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i4 == 3) {
            return new zzw();
        }
        zzn zznVar = null;
        if (i4 == 4) {
            return new zzv(zznVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zza;
    }

    public final long zzc() {
        return this.zzg;
    }

    public final long zzd() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return (this.zzd & 1) != 0;
    }
}
