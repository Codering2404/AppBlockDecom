package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzlh extends zzqm implements zzrr {
    private static final zzlh zzb;
    private int zzd;
    private Object zzf;
    private int zze = 0;
    private String zzg = "";
    private String zzh = "";

    static {
        zzlh zzlhVar = new zzlh();
        zzb = zzlhVar;
        zzqm.zzz(zzlh.class, zzlhVar);
    }

    private zzlh() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003;\u0000\u0004;\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzlh();
        }
        zzli zzliVar = null;
        if (i4 == 4) {
            return new zzlg(zzliVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
