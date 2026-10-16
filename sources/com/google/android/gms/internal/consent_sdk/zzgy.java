package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgy extends zzqm implements zzrr {
    private static final zzgy zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private long zzg;

    static {
        zzgy zzgyVar = new zzgy();
        zzb = zzgyVar;
        zzqm.zzz(zzgy.class, zzgyVar);
    }

    private zzgy() {
    }

    public static zzgx zza() {
        return (zzgx) zzb.zzp();
    }

    static /* synthetic */ void zzd(zzgy zzgyVar, String str) {
        zzgyVar.zzd |= 2;
        zzgyVar.zzf = str;
    }

    static /* synthetic */ void zze(zzgy zzgyVar, long j3) {
        zzgyVar.zzd |= 4;
        zzgyVar.zzg = j3;
    }

    static /* synthetic */ void zzf(zzgy zzgyVar, int i3) {
        zzgyVar.zze = i3 - 2;
        zzgyVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ለ\u0001\u0003ဂ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzgy();
        }
        zzhb zzhbVar = null;
        if (i4 == 4) {
            return new zzgx(zzhbVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
