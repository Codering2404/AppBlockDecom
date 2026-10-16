package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzauh extends zzbdq implements zzbey {
    private static final zzauh zzaa;
    private static volatile zzbff zzab;
    private int zzA;
    private int zzB;
    private int zzC;
    private int zzD;
    private int zzE;
    private int zzF;
    private int zzG;
    private boolean zzH;
    private int zzI;
    private int zzJ;
    private int zzK;
    private int zzL;
    private int zzM;
    private int zzN;
    private int zzO;
    private int zzP;
    private int zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private int zzW;
    private int zzX;
    private int zzY;
    private zzaux zzZ;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private boolean zzj;
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
        zzauh zzauhVar = new zzauh();
        zzaa = zzauhVar;
        zzbdq.D(zzauh.class, zzauhVar);
    }

    private zzauh() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzaa, "\u0001/\u0000\u0002\u0001//\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005ဇ\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bင\u000b\fင\f\rင\r\u000eင\u000e\u000fင\u000f\u0010င\u0010\u0011င\n\u0012င\u0011\u0013င\u0012\u0014င\u0013\u0015င\u0014\u0016င\u0015\u0017င\u0016\u0018င\u0017\u0019င\u0018\u001aင\u0019\u001bင\u001a\u001cင\u001b\u001dဇ\u001c\u001eင\u001d\u001fင\u001e င\u001f!င \"င!#င\"$င#%င$&င%'င&(င')င(*င)+င*,င+-င,.င-/ဉ.", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzp", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", "zzZ"});
        }
        if (i4 == 3) {
            return new zzauh();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaug(bArr);
        }
        if (i4 == 5) {
            return zzaa;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzab;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzauh.class) {
            try {
                zzbdlVar = zzab;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzaa);
                    zzab = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
