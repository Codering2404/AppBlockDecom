package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkc extends zzfu implements zzhc {
    private static final zzkc zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzkc zzkcVar = new zzkc();
        zzb = zzkcVar;
        zzfu.zzB(zzkc.class, zzkcVar);
    }

    private zzkc() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzkb.zza, "zzf"});
        }
        if (i4 == 3) {
            return new zzkc();
        }
        zzkd zzkdVar = null;
        if (i4 == 4) {
            return new zzka(zzkdVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
