package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzarx extends zzbdq implements zzbey {
    private static final zzarx zzs;
    private static volatile zzbff zzt;
    private int zzb;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private zzbcl zzn;
    private zzbcl zzo;
    private float zzp;
    private int zzq;
    private int zzr;

    static {
        zzarx zzarxVar = new zzarx();
        zzs = zzarxVar;
        zzbdq.D(zzarx.class, zzarxVar);
    }

    private zzarx() {
        zzbcl zzbclVar = zzbcl.f75997b;
        this.zzn = zzbclVar;
        this.zzo = zzbclVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzs, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0007\u0004င\b\u0005ဂ\u0002\u0006ည\t\u0007ဂ\u0003\bည\n\tင\u0004\nင\u0005\u000bခ\u000b\fင\f\rင\u0006\u000eင\r", new Object[]{"zzb", "zze", "zzf", "zzl", "zzm", "zzg", "zzn", "zzh", "zzo", "zzi", "zzj", "zzp", "zzq", "zzk", "zzr"});
        }
        if (i4 == 3) {
            return new zzarx();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzarw(bArr);
        }
        if (i4 == 5) {
            return zzs;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzt;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzarx.class) {
            try {
                zzbdlVar = zzt;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzs);
                    zzt = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
