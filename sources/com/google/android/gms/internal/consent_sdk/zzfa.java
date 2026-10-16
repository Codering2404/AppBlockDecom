package com.google.android.gms.internal.consent_sdk;

import coil.target.Yb.oUcQRqOVfOC;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfa extends zzqm implements zzrr {
    private static final zzfa zzb;
    private int zzd;
    private zzew zze;
    private zzey zzf;
    private String zzg = "";
    private String zzh = "";

    static {
        zzfa zzfaVar = new zzfa();
        zzb = zzfaVar;
        zzqm.zzz(zzfa.class, zzfaVar);
    }

    private zzfa() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", oUcQRqOVfOC.kdsLGFkMsTokr});
        }
        if (i4 == 3) {
            return new zzfa();
        }
        zzez zzezVar = null;
        if (i4 == 4) {
            return new zzek(zzezVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
