package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdw extends zzfu implements zzhc {
    private static final zzdw zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzdw zzdwVar = new zzdw();
        zzb = zzdwVar;
        zzfu.zzB(zzdw.class, zzdwVar);
    }

    private zzdw() {
    }

    public static zzdw zzc(byte[] bArr) throws zzgc {
        return (zzdw) zzfu.zzt(zzb, bArr);
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzdw();
        }
        zzdz zzdzVar = null;
        if (i4 == 4) {
            return new zzdv(zzdzVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }

    public final String zze() {
        return this.zzf;
    }
}
