package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzdj extends zzbdq implements zzbey {
    private static final zzdj zzD;
    private static volatile zzbff zzE;
    private int zzA;
    private float zzB;
    private float zzC;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private float zzj;
    private int zzk;
    private int zzl;
    private float zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private float zzr;
    private float zzs;
    private float zzt;
    private int zzu;
    private float zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private float zzz;

    static {
        zzdj zzdjVar = new zzdj();
        zzD = zzdjVar;
        zzbdq.D(zzdj.class, zzdjVar);
    }

    private zzdj() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzD, "\u0001\u0019\u0000\u0001\u0001\u0019\u0019\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005င\u0004\u0006ခ\u0005\u0007င\u0006\bင\u0007\tခ\b\nင\t\u000bင\n\fင\u000b\rင\f\u000eခ\r\u000fခ\u000e\u0010ခ\u000f\u0011င\u0010\u0012ခ\u0011\u0013င\u0012\u0014င\u0013\u0015င\u0014\u0016ခ\u0015\u0017င\u0016\u0018ခ\u0017\u0019ခ\u0018", new Object[]{"zzb", "zze", zzda.a(), "zzf", zzdc.a(), "zzg", zzdi.f77780a, "zzh", zzdh.f77779a, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC"});
        }
        if (i4 == 3) {
            return new zzdj();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzdg(bArr);
        }
        if (i4 == 5) {
            return zzD;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzE;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzdj.class) {
            try {
                zzbdlVar = zzE;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzD);
                    zzE = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
