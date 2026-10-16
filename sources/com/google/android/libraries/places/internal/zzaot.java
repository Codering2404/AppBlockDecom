package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaot extends zzbdq implements zzbey {
    private static final zzaot zzb;
    private static volatile zzbff zze;

    static {
        zzaot zzaotVar = new zzaot();
        zzb = zzaotVar;
        zzbdq.D(zzaot.class, zzaotVar);
    }

    private zzaot() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        byte[] bArr = null;
        if (i4 == 2) {
            return zzbdq.m(zzb, "\u0001\u0000", null);
        }
        if (i4 == 3) {
            return new zzaot();
        }
        if (i4 == 4) {
            return new zzaos(bArr);
        }
        if (i4 == 5) {
            return zzb;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zze;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaot.class) {
            try {
                zzbdlVar = zze;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzb);
                    zze = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
