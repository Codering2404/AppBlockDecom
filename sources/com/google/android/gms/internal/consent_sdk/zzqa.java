package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqa extends zzqm implements zzrr {
    private static final zzqa zzb;
    private long zzd;
    private int zze;

    static {
        zzqa zzqaVar = new zzqa();
        zzb = zzqaVar;
        zzqm.zzz(zzqa.class, zzqaVar);
    }

    private zzqa() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return new zzrz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzd", "zze"});
        }
        if (i4 == 3) {
            return new zzqa();
        }
        zzpz zzpzVar = null;
        if (i4 == 4) {
            return new zzpy(zzpzVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
