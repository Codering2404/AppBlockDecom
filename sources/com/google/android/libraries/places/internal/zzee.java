package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzee extends zzbdq implements zzbey {
    private static final zzee zzE;
    private static volatile zzbff zzF;
    private float zzA;
    private float zzB;
    private boolean zzC;
    private int zzD;
    private int zzb;
    private float zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private float zzm;
    private float zzn;
    private float zzo;
    private float zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private float zzt;
    private float zzu;
    private float zzv;
    private float zzw;
    private float zzx;
    private float zzy;
    private float zzz;

    static {
        zzee zzeeVar = new zzee();
        zzE = zzeeVar;
        zzbdq.D(zzee.class, zzeeVar);
    }

    private zzee() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzE, "\u0001\u001a\u0000\u0001\u0001\u001a\u001a\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ခ\u0006\bခ\u0007\tခ\b\nခ\t\u000bခ\n\fခ\u000b\rင\f\u000eင\r\u000fင\u000e\u0010ခ\u000f\u0011ခ\u0010\u0012ခ\u0011\u0013ခ\u0012\u0014ခ\u0013\u0015ခ\u0014\u0016ခ\u0015\u0017ခ\u0016\u0018ခ\u0017\u0019ဇ\u0018\u001aင\u0019", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD"});
        }
        if (i4 == 3) {
            return new zzee();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzed(bArr);
        }
        if (i4 == 5) {
            return zzE;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzF;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzee.class) {
            try {
                zzbdlVar = zzF;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzE);
                    zzF = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
