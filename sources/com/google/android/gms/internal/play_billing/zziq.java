package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zziq extends zzfu implements zzhc {
    private static final zziq zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zziq zziqVar = new zziq();
        zzb = zziqVar;
        zzfu.zzB(zziq.class, zziqVar);
    }

    private zziq() {
    }

    public static zzio zza() {
        return (zzio) zzb.zzp();
    }

    public static zziq zzc() {
        return zzb;
    }

    static /* synthetic */ void zze(zziq zziqVar, String str) {
        str.getClass();
        zziqVar.zzd = 3;
        zziqVar.zze = str;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return new zzhk(zzb, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001?\u0000\u00023\u0000\u0003Ȼ\u0000\u0004:\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"zze", "zzd", zzhx.class, zzgo.class});
        }
        if (i4 == 3) {
            return new zziq();
        }
        zzip zzipVar = null;
        if (i4 == 4) {
            return new zzio(zzipVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
