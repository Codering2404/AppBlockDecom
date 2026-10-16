package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhsy extends zziee implements zzifq {
    private static final zzhsy zzf;
    private static volatile zzifx zzg;
    private int zza;
    private zzhsq zzb;
    private int zzc;
    private int zzd;
    private int zze;

    static {
        zzhsy zzhsyVar = new zzhsy();
        zzf = zzhsyVar;
        zziee.zzbu(zzhsy.class, zzhsyVar);
    }

    private zzhsy() {
    }

    public static zzhsx zze() {
        return (zzhsx) zzf.zzbn();
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzhsq zzb() {
        zzhsq zzhsqVar = this.zzb;
        return zzhsqVar == null ? zzhsq.zze() : zzhsqVar;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzhtm zzd() {
        zzhtm zzhtmVarZzb = zzhtm.zzb(this.zze);
        return zzhtmVarZzb == null ? zzhtm.UNRECOGNIZED : zzhtmVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzhsy();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhsx(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzg;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzhsy.class) {
            try {
                zzidzVar = zzg;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzf);
                    zzg = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    final /* synthetic */ void zzg(zzhsq zzhsqVar) {
        zzhsqVar.getClass();
        this.zzb = zzhsqVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzh(int i3) {
        this.zzd = i3;
    }

    final /* synthetic */ void zzi(zzhtm zzhtmVar) {
        this.zze = zzhtmVar.zza();
    }

    public final int zzk() {
        int i3 = this.zzc;
        int i4 = i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? 0 : 5 : 4 : 3 : 2;
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }

    final /* synthetic */ void zzl(int i3) {
        this.zzc = zzhsr.zza(i3);
    }
}
