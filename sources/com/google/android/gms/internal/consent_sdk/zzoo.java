package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzoo extends zzqm implements zzrr {
    private static final zzoo zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzqq zzg = zzqm.zzs();

    static {
        zzoo zzooVar = new zzoo();
        zzb = zzooVar;
        zzqm.zzz(zzoo.class, zzooVar);
    }

    private zzoo() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            zzqp zzqpVar = zzom.zza;
            return zzqm.zzw(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002ࠬ\u0003᠌\u0001", new Object[]{"zzd", "zze", "zzg", zzqpVar, "zzf", zzqpVar});
        }
        if (i4 == 3) {
            return new zzoo();
        }
        zzon zzonVar = null;
        if (i4 == 4) {
            return new zzol(zzonVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
