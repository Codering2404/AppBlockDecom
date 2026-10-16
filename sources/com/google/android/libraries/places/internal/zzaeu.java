package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaeu extends zzbdq implements zzbey {
    private static final zzaeu zzu;
    private static volatile zzbff zzv;
    private int zzb;
    private long zze;
    private zzya zzf;
    private boolean zzg;
    private boolean zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private boolean zzn;
    private int zzo;
    private long zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;

    static {
        zzaeu zzaeuVar = new zzaeu();
        zzu = zzaeuVar;
        zzbdq.D(zzaeu.class, zzaeuVar);
    }

    private zzaeu() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzu, "\u0001\u0010\u0000\u0001\u0001\u0010\u0010\u0000\u0000\u0000\u0001စ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဇ\t\u000bင\n\fဂ\u000b\rင\f\u000eင\r\u000fင\u000e\u0010င\u000f", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
        }
        if (i4 == 3) {
            return new zzaeu();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaet(bArr);
        }
        if (i4 == 5) {
            return zzu;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzv;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaeu.class) {
            try {
                zzbdlVar = zzv;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzu);
                    zzv = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
