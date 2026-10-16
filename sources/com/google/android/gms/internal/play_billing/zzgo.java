package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgo extends zzfu implements zzhc {
    private static final zzgo zzb;
    private zzfz zzd = zzhj.zze();

    static {
        zzgo zzgoVar = new zzgo();
        zzb = zzgoVar;
        zzfu.zzB(zzgo.class, zzgoVar);
    }

    private zzgo() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return new zzhk(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zziq.class});
        }
        if (i4 == 3) {
            return new zzgo();
        }
        zzgn zzgnVar = null;
        if (i4 == 4) {
            return new zzgm(zzgnVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
