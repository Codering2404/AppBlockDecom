package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkh extends zzqm implements zzrr {
    private static final zzkh zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;

    static {
        zzkh zzkhVar = new zzkh();
        zzb = zzkhVar;
        zzqm.zzz(zzkh.class, zzkhVar);
    }

    private zzkh() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u000b\u0000\u0001\u0001\u0010\u000b\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0006\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0007\u000eဇ\b\u000fဇ\t\u0010ဇ\n", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzk", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo"});
        }
        if (i4 == 3) {
            return new zzkh();
        }
        zzkz zzkzVar = null;
        if (i4 == 4) {
            return new zzkg(zzkzVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
