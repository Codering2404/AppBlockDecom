package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzlf extends zzqm implements zzrr {
    private static final zzlf zzb;
    private int zzd;
    private zzrk zzh = zzrk.zza();
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        zzlf zzlfVar = new zzlf();
        zzb = zzlfVar;
        zzqm.zzz(zzlf.class, zzlfVar);
    }

    private zzlf() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0001\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u00042", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzle.zza});
        }
        if (i4 == 3) {
            return new zzlf();
        }
        zzli zzliVar = null;
        if (i4 == 4) {
            return new zzld(zzliVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
