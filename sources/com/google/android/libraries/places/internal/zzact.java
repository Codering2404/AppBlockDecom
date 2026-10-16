package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzact extends zzbdq implements zzbey {
    private static final zzact zzj;
    private static volatile zzbff zzk;
    private int zzb;
    private zzcy zze;
    private zzacp zzf;
    private zzbea zzg = zzbdq.s();
    private int zzh;
    private int zzi;

    static {
        zzact zzactVar = new zzact();
        zzj = zzactVar;
        zzbdq.D(zzact.class, zzactVar);
    }

    private zzact() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0001\u0002\u001b\u0003᠌\u0002\u0004᠌\u0003\u0005ဉ\u0000", new Object[]{"zzb", "zzf", "zzg", zzaca.class, "zzh", zzacs.f75612a, "zzi", zzacr.f75611a, "zze"});
        }
        if (i4 == 3) {
            return new zzact();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzacq(bArr);
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
        synchronized (zzact.class) {
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
