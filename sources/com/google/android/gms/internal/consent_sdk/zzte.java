package com.google.android.gms.internal.consent_sdk;

import com.google.common.cache.LSNn.vfptEEmYY;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzte extends zzqm implements zzrr {
    private static final zzte zzb;
    private String zzd = "";
    private long zze;
    private int zzf;

    static {
        zzte zzteVar = new zzte();
        zzb = zzteVar;
        zzqm.zzz(zzte.class, zzteVar);
    }

    private zzte() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0004", new Object[]{vfptEEmYY.ZHQSwSDDHwu, "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzte();
        }
        zztd zztdVar = null;
        if (i4 == 4) {
            return new zztc(zztdVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
