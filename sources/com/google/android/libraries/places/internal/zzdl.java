package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzdl extends zzbdq implements zzbey {
    private static final zzdl zzv;
    private static volatile zzbff zzw;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private float zzi;
    private int zzj;
    private int zzk;
    private float zzl;
    private int zzm;
    private int zzn;
    private float zzo;
    private int zzp;
    private float zzq;
    private int zzr;
    private int zzs;
    private float zzt;
    private int zzu;

    static {
        zzdl zzdlVar = new zzdl();
        zzv = zzdlVar;
        zzbdq.D(zzdl.class, zzdlVar);
    }

    private zzdl() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzv, "\u0001\u0011\u0000\u0001\u0001\u0011\u0011\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004င\u0003\u0005ခ\u0004\u0006င\u0005\u0007င\u0006\bခ\u0007\tင\b\nင\t\u000bခ\n\fင\u000b\rခ\f\u000eင\r\u000fင\u000e\u0010ခ\u000f\u0011င\u0010", new Object[]{"zzb", "zze", zzda.a(), "zzf", zzdc.a(), "zzg", zzbhp.a(), "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu"});
        }
        if (i4 == 3) {
            return new zzdl();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzdk(bArr);
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
        synchronized (zzdl.class) {
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
