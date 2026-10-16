package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzabp extends zzbdq implements zzbey {
    private static final zzabp zze;
    private static volatile zzbff zzf;
    private zzbea zzb = zzbdq.s();

    static {
        zzabp zzabpVar = new zzabp();
        zze = zzabpVar;
        zzbdq.D(zzabp.class, zzabpVar);
    }

    private zzabp() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzabn.class});
        }
        if (i4 == 3) {
            return new zzabp();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzabo(bArr);
        }
        if (i4 == 5) {
            return zze;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzf;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzabp.class) {
            try {
                zzbdlVar = zzf;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zze);
                    zzf = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
