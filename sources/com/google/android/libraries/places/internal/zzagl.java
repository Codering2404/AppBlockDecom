package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzagl extends zzbdq implements zzbey {
    private static final zzagl zzn;
    private static volatile zzbff zzo;
    private int zzb;
    private float zze;
    private float zzf;
    private float zzg;
    private int zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;

    static {
        zzagl zzaglVar = new zzagl();
        zzn = zzaglVar;
        zzbdq.D(zzagl.class, zzaglVar);
    }

    private zzagl() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004င\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i4 == 3) {
            return new zzagl();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzagk(bArr);
        }
        if (i4 == 5) {
            return zzn;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzo;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzagl.class) {
            try {
                zzbdlVar = zzo;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzn);
                    zzo = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
