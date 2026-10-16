package com.google.android.gms.internal.measurement;

import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgn extends zzmf implements zznn {
    private static final zzgn zzd;
    private zzmo zzb = zzmf.zzcv();

    static {
        zzgn zzgnVar = new zzgn();
        zzd = zzgnVar;
        zzmf.zzcp(zzgn.class, zzgnVar);
    }

    private zzgn() {
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    protected final Object zzl(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzmf.zzcq(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{MrGIhy.viHd});
        }
        if (i4 == 3) {
            return new zzgn();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzgm(bArr);
        }
        if (i4 == 5) {
            return zzd;
        }
        throw null;
    }
}
