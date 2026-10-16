package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzacy extends zzbdq implements zzbey {
    private static final zzacy zzb;
    private static volatile zzbff zze;

    static {
        zzacy zzacyVar = new zzacy();
        zzb = zzacyVar;
        zzbdq.D(zzacy.class, zzacyVar);
    }

    private zzacy() {
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
            return new zzacy();
        }
        if (i4 == 4) {
            return new zzacx(bArr);
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
        synchronized (zzacy.class) {
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
