package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhq extends zzmf implements zznn {
    private static final zzhq zzf;
    private int zzb;
    private int zzd;
    private long zze;

    static {
        zzhq zzhqVar = new zzhq();
        zzf = zzhqVar;
        zzmf.zzcp(zzhq.class, zzhqVar);
    }

    private zzhq() {
    }

    public static zzhp zze() {
        return (zzhp) zzf.zzck();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return (this.zzb & 2) != 0;
    }

    public final long zzd() {
        return this.zze;
    }

    final /* synthetic */ void zzf(int i3) {
        this.zzb |= 1;
        this.zzd = i3;
    }

    final /* synthetic */ void zzg(long j3) {
        this.zzb |= 2;
        this.zze = j3;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    protected final Object zzl(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzmf.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i4 == 3) {
            return new zzhq();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzhp(bArr);
        }
        if (i4 == 5) {
            return zzf;
        }
        throw null;
    }
}
