package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhqq extends zziee implements zzifq {
    private static final zzhqq zze;
    private static volatile zzifx zzf;
    private int zza;
    private int zzb;
    private zzhqu zzc;
    private zzhsj zzd;

    static {
        zzhqq zzhqqVar = new zzhqq();
        zze = zzhqqVar;
        zziee.zzbu(zzhqq.class, zzhqqVar);
    }

    private zzhqq() {
    }

    public static zzhqq zzd(zzida zzidaVar, zzido zzidoVar) throws zziet {
        return (zzhqq) zziee.zzbT(zze, zzidaVar, zzidoVar);
    }

    public static zzhqp zze() {
        return (zzhqp) zze.zzbn();
    }

    public static zzifx zzg() {
        return zze.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhqu zzb() {
        zzhqu zzhquVar = this.zzc;
        return zzhquVar == null ? zzhqu.zze() : zzhquVar;
    }

    public final zzhsj zzc() {
        zzhsj zzhsjVar = this.zzd;
        return zzhsjVar == null ? zzhsj.zzg() : zzhsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhqq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhqp(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzf;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzhqq.class) {
            try {
                zzidzVar = zzf;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zze);
                    zzf = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    final /* synthetic */ void zzh(zzhqu zzhquVar) {
        zzhquVar.getClass();
        this.zzc = zzhquVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzi(zzhsj zzhsjVar) {
        zzhsjVar.getClass();
        this.zzd = zzhsjVar;
        this.zza |= 2;
    }
}
