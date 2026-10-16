package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzke extends zzfu implements zzhc {
    private static final zzke zzb;
    private int zzd;
    private zzfz zze = zzfu.zzv();
    private String zzf = "";
    private boolean zzg;

    static {
        zzke zzkeVar = new zzke();
        zzb = zzkeVar;
        zzfu.zzB(zzke.class, zzkeVar);
    }

    private zzke() {
    }

    public static zzke zzb() {
        return zzb;
    }

    static /* synthetic */ void zzc(zzke zzkeVar, boolean z2) {
        zzkeVar.zzd |= 2;
        zzkeVar.zzg = z2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဇ\u0001", new Object[]{"zzd", "zze", zzkc.class, "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzke();
        }
        zzkd zzkdVar = null;
        if (i4 == 4) {
            return new zzjz(zzkdVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
