package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaym extends zzbdq implements zzbey {
    private static final zzaym zzj;
    private static volatile zzbff zzk;
    private int zze;
    private int zzf;
    private String zzb = "";
    private zzbea zzg = zzbdq.s();
    private String zzh = "";
    private String zzi = "";

    static {
        zzaym zzaymVar = new zzaym();
        zzj = zzaymVar;
        zzbdq.D(zzaym.class, zzaymVar);
    }

    private zzaym() {
    }

    public final String G() {
        return this.zzb;
    }

    public final int H() {
        return this.zze;
    }

    public final int I() {
        return this.zzf;
    }

    public final List J() {
        return this.zzg;
    }

    public final String K() {
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
            return zzbdq.m(zzj, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\u0004\u0004\u001b\u0005Ȉ\u0006Ȉ", new Object[]{"zzb", "zze", "zzf", "zzg", zzawg.class, "zzh", "zzi"});
        }
        if (i4 == 3) {
            return new zzaym();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzayl(bArr);
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
        synchronized (zzaym.class) {
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
