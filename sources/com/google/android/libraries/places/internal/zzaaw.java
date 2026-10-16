package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaaw extends zzbdq implements zzbey {
    private static final zzaaw zzO;
    private static volatile zzbff zzP;
    private int zzA;
    private int zzB;
    private int zzC;
    private int zzD;
    private int zzE;
    private int zzF;
    private int zzG;
    private int zzH;
    private int zzI;
    private int zzJ;
    private int zzK;
    private int zzL;
    private int zzM;
    private int zzN;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private int zzz;

    static {
        zzaaw zzaawVar = new zzaaw();
        zzO = zzaawVar;
        zzbdq.D(zzaaw.class, zzaawVar);
    }

    private zzaaw() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzO, "\u0001#\u0000\u0002\u0001##\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bင\n\fင\u000b\rင\f\u000eင\r\u000fင\u000e\u0010င\u000f\u0011င\u0010\u0012င\u0011\u0013င\u0012\u0014င\u0013\u0015င\u0014\u0016င\u0015\u0017င\u0016\u0018င\u0017\u0019င\u0018\u001aင\u0019\u001bင\u001a\u001cင\u001b\u001dင\u001c\u001eင\u001d\u001fင\u001e င\u001f!င \"င!#င\"", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN"});
        }
        if (i4 == 3) {
            return new zzaaw();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaav(bArr);
        }
        if (i4 == 5) {
            return zzO;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzP;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaaw.class) {
            try {
                zzbdlVar = zzP;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzO);
                    zzP = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
