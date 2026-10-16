package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzijt extends zziee implements zzifq {
    private static final zzijt zzf;
    private static volatile zzifx zzg;
    private int zza;
    private int zzb;
    private String zzc = "";
    private zzida zzd;
    private zzida zze;

    static {
        zzijt zzijtVar = new zzijt();
        zzf = zzijtVar;
        zziee.zzbu(zzijt.class, zzijtVar);
    }

    private zzijt() {
        zzida zzidaVar = zzida.zza;
        this.zzd = zzidaVar;
        this.zze = zzidaVar;
    }

    public static zzijr zzc() {
        return (zzijr) zzf.zzbn();
    }

    final /* synthetic */ void zzd(String str) {
        this.zza |= 2;
        this.zzc = "image/png";
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zza", "zzb", zzijs.zza, "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzijt();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzijr(bArr);
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
        synchronized (zzijt.class) {
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

    final /* synthetic */ void zze(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zza |= 4;
        this.zzd = zzidaVar;
    }

    final /* synthetic */ void zzh(int i3) {
        this.zzb = 1;
        this.zza = 1 | this.zza;
    }
}
