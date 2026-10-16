package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzabn extends zzbdq implements zzbey {
    private static volatile zzbff zzA;
    private static final zzabn zzz;
    private int zzb;
    private int zze;
    private long zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private boolean zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private boolean zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private float zzs;
    private float zzt;
    private int zzu;
    private zzbcl zzv = zzbcl.f75997b;
    private long zzw;
    private boolean zzx;
    private boolean zzy;

    static {
        zzabn zzabnVar = new zzabn();
        zzz = zzabnVar;
        zzbdq.D(zzabn.class, zzabnVar);
    }

    private zzabn() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzz, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001င\u0002\u0002င\u0003\u0003င\u0004\u0004ဇ\u0005\u0005င\u0006\u0006င\u0007\u0007င\b\bင\t\tဇ\n\nင\u000b\u000bင\f\fင\r\rခ\u000e\u000eခ\u000f\u000fင\u0010\u0010᠌\u0000\u0011ဂ\u0001\u0012ည\u0011\u0013ဂ\u0012\u0014ဇ\u0013\u0015ဇ\u0014", new Object[]{"zzb", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zze", zzaax.f75604a, "zzf", "zzv", "zzw", "zzx", "zzy"});
        }
        if (i4 == 3) {
            return new zzabn();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzabm(bArr);
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
        synchronized (zzabn.class) {
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
