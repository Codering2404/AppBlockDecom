package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgc extends zzmf implements zznn {
    private static final zzgc zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzgc zzgcVar = new zzgc();
        zzf = zzgcVar;
        zzmf.zzcp(zzgc.class, zzgcVar);
    }

    private zzgc() {
    }

    public final String zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    protected final Object zzl(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzmf.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i4 == 3) {
            return new zzgc();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzgb(bArr);
        }
        if (i4 == 5) {
            return zzf;
        }
        throw null;
    }
}
