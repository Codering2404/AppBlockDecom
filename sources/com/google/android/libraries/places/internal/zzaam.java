package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaam extends zzbdq implements zzbey {
    private static final zzaam zzv;
    private static volatile zzbff zzw;
    private int zzb;
    private int zze;
    private long zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private int zzn;
    private zzbcl zzo;
    private zzbcl zzp;
    private zzbcl zzq;
    private long zzr;
    private double zzs;
    private zzbcl zzt;
    private zzbcl zzu;

    static {
        zzaam zzaamVar = new zzaam();
        zzv = zzaamVar;
        zzbdq.D(zzaam.class, zzaamVar);
    }

    private zzaam() {
        zzbcl zzbclVar = zzbcl.f75997b;
        this.zzo = zzbclVar;
        this.zzp = zzbclVar;
        this.zzq = zzbclVar;
        this.zzt = zzbclVar;
        this.zzu = zzbclVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzv, "\u0001\u0011\u0000\u0001\u0001\u0012\u0011\u0000\u0000\u0000\u0001င\u0002\u0002င\u0003\u0003ဇ\u0004\u0004ဇ\u0005\u0006ဂ\u0006\u0007ဂ\u0007\bဂ\b\tင\t\nည\n\u000bည\u000b\fည\f\rဂ\r\u000eက\u000e\u000fည\u000f\u0010ည\u0010\u0011᠌\u0000\u0012ဂ\u0001", new Object[]{"zzb", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zze", zzaax.f75604a, "zzf"});
        }
        if (i4 == 3) {
            return new zzaam();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaal(bArr);
        }
        if (i4 == 5) {
            return zzv;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzw;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaam.class) {
            try {
                zzbdlVar = zzw;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzv);
                    zzw = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
