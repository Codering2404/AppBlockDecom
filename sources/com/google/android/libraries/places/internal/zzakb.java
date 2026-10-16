package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzakb extends zzbdq implements zzbey {
    private static final zzakb zzx;
    private static volatile zzbff zzy;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private zzbdy zzj = zzbdq.p();
    private int zzk;
    private zzajh zzl;
    private zzajx zzm;
    private zzaii zzn;
    private zzajr zzo;
    private zzajn zzp;
    private zzajt zzq;
    private zzail zzr;
    private zzaiq zzs;
    private zzaki zzt;
    private zzakp zzu;
    private zzaiz zzv;
    private zzaiv zzw;

    static {
        zzakb zzakbVar = new zzakb();
        zzx = zzakbVar;
        zzbdq.D(zzakb.class, zzakbVar);
    }

    private zzakb() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzx, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0001\u0000\u0001᠌\u0001\u0002᠌\u0002\u0003င\u0003\u0004ဉ\u0006\u0005ဉ\u0007\u0006ဉ\b\u0007ဉ\t\bဇ\u0004\tဉ\n\nဉ\u000b\u000b\u0016\fင\u0005\rဉ\f\u000eဉ\r\u000fဉ\u000e\u0010ဉ\u000f\u0011င\u0000\u0012ဉ\u0010\u0013ဉ\u0011", new Object[]{"zzb", "zzf", zzajz.f75647a, "zzg", zzaka.f75648a, "zzh", "zzl", "zzm", "zzn", "zzo", "zzi", "zzp", "zzq", "zzj", "zzk", "zzr", "zzs", "zzt", "zzu", "zze", "zzv", "zzw"});
        }
        if (i4 == 3) {
            return new zzakb();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzajy(bArr);
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
        synchronized (zzakb.class) {
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
