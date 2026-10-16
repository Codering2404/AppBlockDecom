package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzal extends zzbdq implements zzbey {
    private static final zzal zzw;
    private static volatile zzbff zzx;
    private int zzb;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private float zzi;
    private boolean zzj;
    private zzbea zzk = zzbdq.s();
    private zzbea zzl = zzbdq.s();
    private zzbea zzm = zzbdq.s();
    private zzbea zzn = zzbdq.s();
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private long zzv;

    static {
        zzal zzalVar = new zzal();
        zzw = zzalVar;
        zzbdq.D(zzal.class, zzalVar);
    }

    private zzal() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzw, "\u0001\u0012\u0000\u0001\u0001\u0012\u0012\u0000\u0004\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006ဇ\u0005\u0007\u001a\b\u001b\t\u001b\nင\u0006\u000bဂ\r\fင\u000b\rင\u0007\u000eင\b\u000fင\t\u0010င\n\u0011\u001b\u0012င\f", new Object[]{"zzb", "zze", zzav.f75901a, "zzf", "zzg", "zzh", "zzi", "zzj", "zzl", "zzm", zzau.class, "zzn", zzau.class, "zzo", "zzv", "zzt", "zzp", "zzq", "zzr", "zzs", "zzk", zzcp.class, "zzu"});
        }
        if (i4 == 3) {
            return new zzal();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzak(bArr);
        }
        if (i4 == 5) {
            return zzw;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzx;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzal.class) {
            try {
                zzbdlVar = zzx;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzw);
                    zzx = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
