package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxa extends zzxv implements zzzh {
    private static final zzxa zza;
    private int zzd;
    private boolean zzf;
    private byte zzg = 2;
    private String zze = "";

    static {
        zzxa zzxaVar = new zzxa();
        zza = zzxaVar;
        zzxv.zzan(zzxa.class, zzxaVar);
    }

    private zzxa() {
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i4 == 2) {
            return new zzzr(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzxa();
        }
        zzus zzusVar = null;
        if (i4 == 4) {
            return new zzwz(zzusVar);
        }
        if (i4 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
