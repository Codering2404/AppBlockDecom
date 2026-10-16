package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzawd extends zzbdq implements zzbey {
    private static final zzawd zzl;
    private static volatile zzbff zzm;
    private int zzb;
    private zzbhv zzg;
    private int zzi;
    private float zzj;
    private float zzk;
    private String zze = "";
    private String zzf = "";
    private zzbea zzh = zzbdq.s();

    static {
        zzawd zzawdVar = new zzawd();
        zzl = zzawdVar;
        zzbdq.D(zzawd.class, zzawdVar);
    }

    private zzawd() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzl, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000\u0004Ț\u0005\f\u0006\u0001\u0007ခ\u0001", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i4 == 3) {
            return new zzawd();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzawc(bArr);
        }
        if (i4 == 5) {
            return zzl;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzm;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzawd.class) {
            try {
                zzbdlVar = zzm;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzl);
                    zzm = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
