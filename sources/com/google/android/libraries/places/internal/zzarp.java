package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzarp extends zzbdq implements zzbey {
    private static final zzarp zzJ;
    private static volatile zzbff zzK;
    private double zzA;
    private zzart zzB;
    private zzart zzC;
    private zzart zzD;
    private zzart zzE;
    private zzart zzF;
    private zzart zzG;
    private zzbdy zzH = zzbdq.p();
    private int zzI;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private long zzi;
    private zzarr zzj;
    private zzarr zzk;
    private zzarr zzl;
    private zzarr zzm;
    private zzarr zzn;
    private zzarr zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private float zzt;
    private int zzu;
    private double zzv;
    private int zzw;
    private int zzx;
    private float zzy;
    private long zzz;

    static {
        zzarp zzarpVar = new zzarp();
        zzJ = zzarpVar;
        zzbdq.D(zzarp.class, zzarpVar);
    }

    private zzarp() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzJ, "\u0001\u001f\u0000\u0001\u0001\u001f\u001f\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005ဂ\u0004\u0006င\r\u0007င\u000e\bခ\u000f\tင\u0010\nက\u0011\u000bင\u0012\fင\u0013\rခ\u0014\u000eဂ\u0015\u000fက\u0016\u0010ဉ\u0005\u0011ဉ\u0006\u0012ဉ\u0007\u0013ဉ\b\u0014ဉ\t\u0015ဉ\n\u0016ဉ\u0017\u0017ဉ\u0018\u0018ဉ\u0019\u0019ဉ\u001a\u001aဉ\u001b\u001bဉ\u001c\u001cင\u000b\u001d'\u001eင\f\u001fင\u001d", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzB", "zzC", "zzD", "zzE", "zzF", "zzG", "zzp", "zzH", "zzq", "zzI"});
        }
        if (i4 == 3) {
            return new zzarp();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaro(bArr);
        }
        if (i4 == 5) {
            return zzJ;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzK;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzarp.class) {
            try {
                zzbdlVar = zzK;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzJ);
                    zzK = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
