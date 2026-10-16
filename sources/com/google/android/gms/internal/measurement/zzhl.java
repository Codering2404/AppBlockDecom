package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhl extends zzmf implements zznn {
    private static final zzhl zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        zzhl zzhlVar = new zzhl();
        zzf = zzhlVar;
        zzmf.zzcp(zzhl.class, zzhlVar);
    }

    private zzhl() {
    }

    public static zzhk zza() {
        return (zzhk) zzf.zzck();
    }

    public final int zzc() {
        int iZza = zzhj.zza(this.zzd);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zzd() {
        int iZza = zzhn.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    final /* synthetic */ void zze(int i3) {
        this.zzd = i3 - 1;
        this.zzb |= 1;
    }

    final /* synthetic */ void zzf(int i3) {
        this.zze = i3 - 1;
        this.zzb |= 2;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    protected final Object zzl(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzmf.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", zzhi.zza, "zze", zzhm.zza});
        }
        if (i4 == 3) {
            return new zzhl();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzhk(bArr);
        }
        if (i4 == 5) {
            return zzf;
        }
        throw null;
    }
}
