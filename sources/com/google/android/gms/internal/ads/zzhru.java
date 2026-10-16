package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhru extends zziee implements zzifq {
    private static final zzhru zzd;
    private static volatile zzifx zze;
    private int zza;
    private int zzb;
    private int zzc;

    static {
        zzhru zzhruVar = new zzhru();
        zzd = zzhruVar;
        zziee.zzbu(zzhru.class, zzhruVar);
    }

    private zzhru() {
    }

    public static zzhrt zzb() {
        return (zzhrt) zzd.zzbn();
    }

    public static zzhru zzc() {
        return zzd;
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
            return zziee.zzbv(zzd, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhru();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhrt(bArr);
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
        synchronized (zzhru.class) {
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

    public final int zzg() {
        int i3 = this.zzb;
        int i4 = i3 != 0 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? 0 : 7 : 6 : 5 : 4 : 2;
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }

    public final int zzh() {
        int i3 = this.zzc;
        int i4 = i3 != 0 ? i3 != 1 ? i3 != 2 ? 0 : 4 : 3 : 2;
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }

    final /* synthetic */ void zzi(int i3) {
        this.zzb = zzhsg.zza(i3);
    }

    final /* synthetic */ void zzj(int i3) {
        this.zzc = zzhrz.zza(i3);
    }
}
