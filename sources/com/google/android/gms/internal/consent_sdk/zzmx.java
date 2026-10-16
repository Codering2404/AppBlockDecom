package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmx extends zzqm implements zzrr {
    private static final zzmx zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        zzmx zzmxVar = new zzmx();
        zzb = zzmxVar;
        zzqm.zzz(zzmx.class, zzmxVar);
    }

    private zzmx() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\b\u0001\u0001\u0001\b\b\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", "zzh", zzoq.zza(), "zzi", zzmp.zza, zzmi.class, zzml.class, zzmv.class, zzmo.class, zzms.class});
        }
        if (i4 == 3) {
            return new zzmx();
        }
        zzmw zzmwVar = null;
        if (i4 == 4) {
            return new zzmf(zzmwVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
