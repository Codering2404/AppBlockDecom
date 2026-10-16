package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzx extends zzbdq implements zzbey {
    private static final zzx zzx;
    private static volatile zzbff zzy;
    private int zzb;
    private zzcp zze;
    private int zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private float zzm;
    private long zzn;
    private int zzo;
    private boolean zzp;
    private int zzq;
    private zzbea zzr = zzbdq.s();
    private zzbea zzs = zzbdq.s();
    private int zzt;
    private int zzu;
    private int zzv;
    private long zzw;

    static {
        zzx zzxVar = new zzx();
        zzx = zzxVar;
        zzbdq.D(zzx.class, zzxVar);
    }

    private zzx() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzx, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0002\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003ဂ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tခ\b\nဂ\t\u000bင\n\fဇ\u000b\r᠌\f\u000e\u001b\u000f\u001b\u0010င\r\u0011င\u000e\u0012ဂ\u0010\u0013င\u000f", new Object[]{"zzb", "zze", "zzf", zzw.f78715a, "zzg", "zzh", zzav.f75901a, "zzi", zzp.f78382a, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzae.f75616a, "zzr", zzau.class, "zzs", zzau.class, "zzt", "zzu", "zzw", "zzv"});
        }
        if (i4 == 3) {
            return new zzx();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzv(bArr);
        }
        if (i4 == 5) {
            return zzx;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzy;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzx.class) {
            try {
                zzbdlVar = zzy;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzx);
                    zzy = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
