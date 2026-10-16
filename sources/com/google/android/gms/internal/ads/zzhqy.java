package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhqy extends zziee implements zzifq {
    private static final zzhqy zzb;
    private static volatile zzifx zzc;
    private int zza;

    static {
        zzhqy zzhqyVar = new zzhqy();
        zzb = zzhqyVar;
        zziee.zzbu(zzhqy.class, zzhqyVar);
    }

    private zzhqy() {
    }

    public static zzhqx zzb() {
        return (zzhqx) zzb.zzbn();
    }

    public static zzhqy zzc() {
        return zzb;
    }

    public final int zza() {
        return this.zza;
    }

    final /* synthetic */ void zzd(int i3) {
        this.zza = i3;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhqy();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhqx(bArr);
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
        synchronized (zzhqy.class) {
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
