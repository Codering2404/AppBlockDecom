package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhts extends zziee implements zzifq {
    private static final zzhts zzb;
    private static volatile zzifx zzc;
    private int zza;

    static {
        zzhts zzhtsVar = new zzhts();
        zzb = zzhtsVar;
        zziee.zzbu(zzhts.class, zzhtsVar);
    }

    private zzhts() {
    }

    public static zzhtr zzb() {
        return (zzhtr) zzb.zzbn();
    }

    public static zzhts zzc() {
        return zzb;
    }

    public final zzhsh zza() {
        zzhsh zzhshVarZzb = zzhsh.zzb(this.zza);
        return zzhshVarZzb == null ? zzhsh.UNRECOGNIZED : zzhshVarZzb;
    }

    final /* synthetic */ void zzd(zzhsh zzhshVar) {
        this.zza = zzhshVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhts();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhtr(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzc;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzhts.class) {
            try {
                zzidzVar = zzc;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzb);
                    zzc = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
