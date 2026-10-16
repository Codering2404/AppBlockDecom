package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkk extends zzfu implements zzhc {
    private static final zzkk zzb;
    private int zzd;
    private int zzf;
    private zzfz zze = zzfu.zzv();
    private String zzg = "";

    static {
        zzkk zzkkVar = new zzkk();
        zzb = zzkkVar;
        zzfu.zzB(zzkk.class, zzkkVar);
    }

    private zzkk() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzkk();
        }
        zzkj zzkjVar = null;
        if (i4 == 4) {
            return new zzki(zzkjVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
