package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaco extends zzbdq implements zzbey {
    private static final zzaco zzv;
    private static volatile zzbff zzw;
    private int zzb;
    private Object zzf;
    private zzach zzg;
    private zzace zzh;
    private zzacl zzi;
    private int zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private int zzn;
    private long zzo;
    private int zzp;
    private long zzq;
    private long zzr;
    private int zze = 0;
    private zzbdz zzs = zzbdq.r();
    private zzbdz zzt = zzbdq.r();
    private zzbea zzu = zzbdq.s();

    static {
        zzaco zzacoVar = new zzaco();
        zzv = zzacoVar;
        zzbdq.D(zzaco.class, zzacoVar);
    }

    private zzaco() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            zzbdw zzbdwVar = zzacs.f75612a;
            zzbdw zzbdwVar2 = zzacr.f75611a;
            return zzbdq.m(zzv, "\u0001\u0012\u0001\u0001\u0001\u0012\u0012\u0000\u0003\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u00035\u0000\u0004᠌\u0003\u0005᠌\u0004\u0006\u083f\u0000\u00077\u0000\bဂ\u0005\t᠌\u0006\n᠌\u0007\u000bဂ\b\fင\t\rဂ\n\u000eဂ\u000b\u000f%\u0010%\u0011\u001b\u0012ဉ\u0002", new Object[]{"zzf", "zze", "zzb", "zzg", "zzh", "zzj", zzbdwVar, "zzk", zzbdwVar2, zzd.a(), "zzl", "zzm", zzbdwVar, "zzn", zzbdwVar2, "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", zzacn.class, "zzi"});
        }
        if (i4 == 3) {
            return new zzaco();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzacc(bArr);
        }
        if (i4 == 5) {
            return zzv;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzw;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaco.class) {
            try {
                zzbdlVar = zzw;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzv);
                    zzw = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
