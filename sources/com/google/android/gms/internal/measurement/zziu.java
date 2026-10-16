package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zziu extends zzmf implements zznn {
    private static final zziu zzj;
    private int zzb;
    private long zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;

    static {
        zziu zziuVar = new zziu();
        zzj = zziuVar;
        zzmf.zzcp(zziu.class, zziuVar);
    }

    private zziu() {
    }

    public static zzit zzm() {
        return (zzit) zzj.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final long zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zze;
    }

    public final boolean zzd() {
        return (this.zzb & 4) != 0;
    }

    public final String zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return (this.zzb & 8) != 0;
    }

    public final long zzg() {
        return this.zzg;
    }

    public final boolean zzh() {
        return (this.zzb & 16) != 0;
    }

    public final float zzi() {
        return this.zzh;
    }

    public final boolean zzj() {
        return (this.zzb & 32) != 0;
    }

    public final double zzk() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    protected final Object zzl(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzmf.zzcq(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i4 == 3) {
            return new zziu();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzit(bArr);
        }
        if (i4 == 5) {
            return zzj;
        }
        throw null;
    }

    final /* synthetic */ void zzn(long j3) {
        this.zzb |= 1;
        this.zzd = j3;
    }

    final /* synthetic */ void zzo(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }

    final /* synthetic */ void zzp(String str) {
        str.getClass();
        this.zzb |= 4;
        this.zzf = str;
    }

    final /* synthetic */ void zzq() {
        this.zzb &= -5;
        this.zzf = zzj.zzf;
    }

    final /* synthetic */ void zzr(long j3) {
        this.zzb |= 8;
        this.zzg = j3;
    }

    final /* synthetic */ void zzs() {
        this.zzb &= -9;
        this.zzg = 0L;
    }

    final /* synthetic */ void zzt(double d3) {
        this.zzb |= 32;
        this.zzi = d3;
    }

    final /* synthetic */ void zzu() {
        this.zzb &= -33;
        this.zzi = 0.0d;
    }
}
