package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcw extends zzbdq implements zzbey {
    private static volatile zzbff zzA;
    private static final zzcw zzz;
    private int zzb;
    private int zze;
    private int zzf;
    private float zzg;
    private int zzh;
    private int zzi;
    private float zzj;
    private int zzk;
    private int zzl;
    private float zzm;
    private int zzn;
    private int zzo;
    private float zzp;
    private int zzq;
    private float zzr;
    private float zzs;
    private double zzt;
    private int zzu;
    private boolean zzv;
    private int zzw;
    private boolean zzx;
    private int zzy;

    static {
        zzcw zzcwVar = new zzcw();
        zzz = zzcwVar;
        zzbdq.D(zzcw.class, zzcwVar);
    }

    private zzcw() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzz, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ခ\u0002\u0004င\u0003\u0005င\u0004\u0006ခ\u0005\u0007င\u0006\bင\u0007\tခ\b\nင\t\u000bင\n\fခ\u000b\rင\f\u000eခ\r\u000fခ\u000e\u0010က\u000f\u0011᠌\u0010\u0012ဇ\u0011\u0013᠌\u0012\u0014ဇ\u0013\u0015᠌\u0014", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", zzcv.f77775a, "zzv", "zzw", zzct.f77773a, "zzx", "zzy", zzcu.f77774a});
        }
        if (i4 == 3) {
            return new zzcw();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzcs(bArr);
        }
        if (i4 == 5) {
            return zzz;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzA;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzcw.class) {
            try {
                zzbdlVar = zzA;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzz);
                    zzA = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
