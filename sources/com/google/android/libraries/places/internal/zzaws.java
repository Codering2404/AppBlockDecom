package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaws extends zzbdq implements zzbey {
    private static final zzaws zzk;
    private static volatile zzbff zzl;
    private int zzb;
    private zzawq zzg;
    private zzawy zzh;
    private int zzj;
    private String zze = "";
    private String zzf = "";
    private zzbea zzi = zzbdq.s();

    static {
        zzaws zzawsVar = new zzaws();
        zzk = zzawsVar;
        zzbdq.D(zzaws.class, zzawsVar);
    }

    private zzaws() {
    }

    public static zzaws L() {
        return zzk;
    }

    public final String G() {
        return this.zzf;
    }

    public final zzawq H() {
        zzawq zzawqVar = this.zzg;
        return zzawqVar == null ? zzawq.I() : zzawqVar;
    }

    public final zzawy I() {
        zzawy zzawyVar = this.zzh;
        return zzawyVar == null ? zzawy.I() : zzawyVar;
    }

    public final List J() {
        return this.zzi;
    }

    public final int K() {
        return this.zzj;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzk, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000\u0004ဉ\u0001\u0005Ț\u0006\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i4 == 3) {
            return new zzaws();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzawr(bArr);
        }
        if (i4 == 5) {
            return zzk;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzl;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaws.class) {
            try {
                zzbdlVar = zzl;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzk);
                    zzl = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
