package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdp extends zzfu implements zzhc {
    private static final zzdp zzb;
    private int zzd;
    private String zze = "";

    static {
        zzdp zzdpVar = new zzdp();
        zzb = zzdpVar;
        zzfu.zzB(zzdp.class, zzdpVar);
    }

    private zzdp() {
    }

    public static zzdp zzb() {
        return zzb;
    }

    public final String zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i4 == 3) {
            return new zzdp();
        }
        zzdo zzdoVar = null;
        if (i4 == 4) {
            return new zzdn(zzdoVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
