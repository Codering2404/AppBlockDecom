package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzalr extends zzbdq implements zzbey {
    private static final zzalr zzj;
    private static volatile zzbff zzk;
    private int zzb;
    private zzbdy zze = zzbdq.p();
    private zzbea zzf = zzbdq.s();
    private String zzg = "";
    private boolean zzh;
    private int zzi;

    static {
        zzalr zzalrVar = new zzalr();
        zzj = zzalrVar;
        zzbdq.D(zzalr.class, zzalrVar);
    }

    private zzalr() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u0016\u0002\u001a\u0003ဈ\u0000\u0004ဇ\u0001\u0005ဋ\u0002", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i4 == 3) {
            return new zzalr();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzalq(bArr);
        }
        if (i4 == 5) {
            return zzj;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzk;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzalr.class) {
            try {
                zzbdlVar = zzk;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzj);
                    zzk = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
