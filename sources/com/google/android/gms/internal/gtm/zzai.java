package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzai extends zzxv implements zzzh {
    private static final zzai zza;
    private int zzd;
    private zzam zzf;
    private zzy zzg;
    private byte zzh = 2;
    private String zze = "";

    static {
        zzai zzaiVar = new zzai();
        zza = zzaiVar;
        zzxv.zzan(zzai.class, zzaiVar);
    }

    private zzai() {
    }

    public final zzy zza() {
        zzy zzyVar = this.zzg;
        return zzyVar == null ? zzy.zzc() : zzyVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001ဈ\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzai();
        }
        zzn zznVar = null;
        if (i4 == 4) {
            return new zzah(zznVar);
        }
        if (i4 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final String zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzf() {
        return (this.zzd & 1) != 0;
    }
}
