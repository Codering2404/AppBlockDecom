package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzlm extends zzqm implements zzrr {
    private static final zzlm zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        zzlm zzlmVar = new zzlm();
        zzb = zzlmVar;
        zzqm.zzz(zzlm.class, zzlmVar);
    }

    private zzlm() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i4 == 3) {
            return new zzlm();
        }
        zzln zzlnVar = null;
        if (i4 == 4) {
            return new zzll(zzlnVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
