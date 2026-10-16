package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzec extends zzbdq implements zzbey {
    private static final zzec zzD;
    private static volatile zzbff zzE;
    private boolean zzA;
    private int zzB;
    private int zzC;
    private int zzb;
    private int zze;
    private int zzf;
    private float zzg;
    private int zzh;
    private int zzi;
    private float zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private float zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private float zzr;
    private float zzs;
    private float zzt;
    private float zzu;
    private float zzv;
    private boolean zzw;
    private int zzx;
    private int zzy;
    private int zzz;

    static {
        zzec zzecVar = new zzec();
        zzD = zzecVar;
        zzbdq.D(zzec.class, zzecVar);
    }

    private zzec() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzD, "\u0001\u0019\u0000\u0001\u0001\u0019\u0019\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ခ\u0002\u0004င\u0003\u0005င\u0004\u0006ခ\u0005\u0007င\u0006\bင\u0007\tင\b\nခ\t\u000bင\n\fင\u000b\rင\f\u000eခ\r\u000fခ\u000e\u0010ခ\u000f\u0011ခ\u0010\u0012ခ\u0011\u0013ဇ\u0012\u0014င\u0013\u0015င\u0014\u0016᠌\u0015\u0017ဇ\u0016\u0018င\u0017\u0019᠌\u0018", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", zzea.f77784a, "zzA", "zzB", "zzC", zzeb.f77785a});
        }
        if (i4 == 3) {
            return new zzec();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzdz(bArr);
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
        synchronized (zzec.class) {
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
