package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbbw extends zzbdq implements zzbey {
    private static final zzbbw zzi;
    private static volatile zzbff zzj;
    private zzbea zzb = zzbdq.s();
    private zzbea zze = zzbdq.s();
    private zzbea zzf = zzbdq.s();
    private String zzg = "";
    private String zzh = "";

    static {
        zzbbw zzbbwVar = new zzbbw();
        zzi = zzbbwVar;
        zzbdq.D(zzbbw.class, zzbbwVar);
    }

    private zzbbw() {
    }

    public static zzbbw K() {
        return zzi;
    }

    public final List G() {
        return this.zzb;
    }

    public final List H() {
        return this.zze;
    }

    public final String I() {
        return this.zzg;
    }

    public final String J() {
        return this.zzh;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0003\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004Ȉ\u0005Ȉ", new Object[]{"zzb", zzbai.class, "zze", zzbbc.class, "zzf", zzaxs.class, "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzbbw();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbbv(bArr);
        }
        if (i4 == 5) {
            return zzi;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzj;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbbw.class) {
            try {
                zzbdlVar = zzj;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzi);
                    zzj = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
