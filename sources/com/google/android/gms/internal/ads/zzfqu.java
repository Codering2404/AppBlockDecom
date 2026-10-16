package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfqu extends zziee implements zzifq {
    private static final zzfqu zzi;
    private static volatile zzifx zzj;
    private long zzb;
    private long zzc;
    private boolean zzd;
    private long zze;
    private long zzf;
    private int zzh;
    private String zza = "";
    private String zzg = "";

    static {
        zzfqu zzfquVar = new zzfqu();
        zzi = zzfquVar;
        zziee.zzbu(zzfqu.class, zzfquVar);
    }

    private zzfqu() {
    }

    public static zzfqt zza() {
        return (zzfqt) zzi.zzbn();
    }

    final /* synthetic */ void zzb(String str) {
        str.getClass();
        this.zza = str;
    }

    final /* synthetic */ void zzc(long j3) {
        this.zzb = j3;
    }

    final /* synthetic */ void zzd(long j3) {
        this.zzc = j3;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzi, "\u0004\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0002\u0004\u0007\u0005\u0002\u0006\u0002\u0007Ȉ\b\f", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (iOrdinal == 3) {
            return new zzfqu();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfqt(bArr);
        }
        if (iOrdinal == 5) {
            return zzi;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzj;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzfqu.class) {
            try {
                zzidzVar = zzj;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzi);
                    zzj = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    final /* synthetic */ void zze(boolean z2) {
        this.zzd = z2;
    }

    final /* synthetic */ void zzg(long j3) {
        this.zze = j3;
    }

    final /* synthetic */ void zzh(long j3) {
        this.zzf = j3;
    }

    final /* synthetic */ void zzi(String str) {
        str.getClass();
        this.zzg = str;
    }

    final /* synthetic */ void zzk(int i3) {
        this.zzh = i3 - 2;
    }
}
