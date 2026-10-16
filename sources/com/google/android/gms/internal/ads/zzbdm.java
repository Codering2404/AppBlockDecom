package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbdm extends zziee implements zzifq {
    private static final zzbdm zzd;
    private static volatile zzifx zze;
    private int zza;
    private zzbdx zzb;
    private zziem zzc = zziee.zzbC();

    static {
        zzbdm zzbdmVar = new zzbdm();
        zzd = zzbdmVar;
        zziee.zzbu(zzbdm.class, zzbdmVar);
    }

    private zzbdm() {
    }

    public static zzbdm zzc(byte[] bArr, zzido zzidoVar) throws zziet {
        return (zzbdm) zziee.zzbV(zzd, bArr, zzidoVar);
    }

    public final zzbdx zza() {
        zzbdx zzbdxVar = this.zzb;
        return zzbdxVar == null ? zzbdx.zze() : zzbdxVar;
    }

    public final List zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002'", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzbdm();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzbdl(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zze;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzbdm.class) {
            try {
                zzidzVar = zze;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzd);
                    zze = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
