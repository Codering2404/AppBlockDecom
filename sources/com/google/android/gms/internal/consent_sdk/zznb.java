package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznb extends zzqm implements zzrr {
    private static final zznb zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zznb zznbVar = new zznb();
        zzb = zznbVar;
        zzqm.zzz(zznb.class, zznbVar);
    }

    private zznb() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", zzos.zza(), "zzf", zzmz.zza});
        }
        if (i4 == 3) {
            return new zznb();
        }
        zzna zznaVar = null;
        if (i4 == 4) {
            return new zzmy(zznaVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
