package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkr extends zzfu implements zzhc {
    private static final zzkr zzb;
    private int zzd;
    private int zze;

    static {
        zzkr zzkrVar = new zzkr();
        zzb = zzkrVar;
        zzfu.zzB(zzkr.class, zzkrVar);
    }

    private zzkr() {
    }

    public static zzkr zzb() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzkp.zza});
        }
        if (i4 == 3) {
            return new zzkr();
        }
        zzkq zzkqVar = null;
        if (i4 == 4) {
            return new zzko(zzkqVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
