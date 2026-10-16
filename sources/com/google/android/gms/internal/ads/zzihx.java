package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzihx extends zziee implements zzifq {
    private static final zzihx zzd;
    private static volatile zzifx zze;
    private int zza;
    private long zzb;
    private long zzc;

    static {
        zzihx zzihxVar = new zzihx();
        zzd = zzihxVar;
        zziee.zzbu(zzihx.class, zzihxVar);
    }

    private zzihx() {
    }

    public static zzihw zzc() {
        return (zzihw) zzd.zzbn();
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
            return zziee.zzbv(zzd, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzihx();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzihw(bArr);
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
        synchronized (zzihx.class) {
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

    final /* synthetic */ void zze(long j3) {
        this.zzb = j3;
    }

    final /* synthetic */ void zzg(long j3) {
        this.zzc = j3;
    }
}
