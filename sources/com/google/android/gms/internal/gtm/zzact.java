package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzact extends zzxv implements zzzh {
    private static final zzact zza;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzact zzactVar = new zzact();
        zza = zzactVar;
        zzxv.zzan(zzact.class, zzactVar);
    }

    private zzact() {
    }

    public static zzact zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzact();
        }
        zzacr zzacrVar = null;
        if (i4 == 4) {
            return new zzacs(zzacrVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zza;
    }
}
