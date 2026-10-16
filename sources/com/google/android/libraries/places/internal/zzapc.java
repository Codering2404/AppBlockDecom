package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzapc extends zzbdq implements zzbey {
    private static final zzapc zzl;
    private static volatile zzbff zzm;
    private int zzb;
    private int zze;
    private int zzg;
    private int zzh;
    private long zzi;
    private boolean zzk;
    private zzbea zzf = zzbdq.s();
    private String zzj = "";

    static {
        zzapc zzapcVar = new zzapc();
        zzl = zzapcVar;
        zzbdq.D(zzapc.class, zzapcVar);
    }

    private zzapc() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzl, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001a\u0003င\u0001\u0004᠌\u0002\u0005ဂ\u0003\u0006ဈ\u0004\u0007ဇ\u0005", new Object[]{"zzb", "zze", zzals.f75673a, "zzf", "zzg", "zzh", zzapf.f75772a, "zzi", "zzj", "zzk"});
        }
        if (i4 == 3) {
            return new zzapc();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzapb(bArr);
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
        synchronized (zzapc.class) {
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
