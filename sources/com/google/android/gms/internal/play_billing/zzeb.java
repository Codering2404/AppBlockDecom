package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeb extends zzfu implements zzhc {
    private static final zzeb zzb;
    private int zzd;
    private String zze = "";

    static {
        zzeb zzebVar = new zzeb();
        zzb = zzebVar;
        zzfu.zzB(zzeb.class, zzebVar);
    }

    private zzeb() {
    }

    public static zzea zza() {
        return (zzea) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzeb zzebVar, String str) {
        zzebVar.zzd |= 1;
        zzebVar.zze = str;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i4 == 3) {
            return new zzeb();
        }
        zzec zzecVar = null;
        if (i4 == 4) {
            return new zzea(zzecVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
