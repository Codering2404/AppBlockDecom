package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjo extends zzfu implements zzhc {
    private static final zzjo zzb;
    private int zzd;
    private int zzf;
    private zzjf zzi;
    private boolean zzj;
    private boolean zzk;
    private String zze = "";
    private zzfy zzg = zzfu.zzu();
    private zzfz zzh = zzfu.zzv();

    static {
        zzjo zzjoVar = new zzjo();
        zzb = zzjoVar;
        zzfu.zzB(zzjo.class, zzjoVar);
    }

    private zzjo() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001b\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"zzd", "zze", "zzf", zzjm.zza, "zzg", zzjj.zza, "zzh", zzkk.class, "zzi", "zzj", "zzk"});
        }
        if (i4 == 3) {
            return new zzjo();
        }
        zzjn zzjnVar = null;
        if (i4 == 4) {
            return new zzjl(zzjnVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
