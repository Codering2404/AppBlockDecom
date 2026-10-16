package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgt extends zzqm implements zzrr {
    private static final zzgt zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzgt zzgtVar = new zzgt();
        zzb = zzgtVar;
        zzqm.zzz(zzgt.class, zzgtVar);
    }

    private zzgt() {
    }

    public static zzgs zza() {
        return (zzgs) zzb.zzp();
    }

    static /* synthetic */ void zzd(zzgt zzgtVar, String str) {
        str.getClass();
        zzgtVar.zzd |= 1;
        zzgtVar.zze = str;
    }

    static /* synthetic */ void zze(zzgt zzgtVar, String str) {
        str.getClass();
        zzgtVar.zzd |= 2;
        zzgtVar.zzf = str;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzgt();
        }
        zzhb zzhbVar = null;
        if (i4 == 4) {
            return new zzgs(zzhbVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
