package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzabv extends zzbdq implements zzbey {
    private static final zzabv zzo;
    private static volatile zzbff zzp;
    private int zzb;
    private int zzf;
    private long zzg;
    private float zzh;
    private int zzi;
    private boolean zzl;
    private boolean zzm;
    private int zzn;
    private String zze = "";
    private String zzj = "";
    private zzbcl zzk = zzbcl.f75997b;

    static {
        zzabv zzabvVar = new zzabv();
        zzo = zzabvVar;
        zzbdq.D(zzabv.class, zzabvVar);
    }

    private zzabv() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzo, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005င\u0004\u0006ဈ\u0005\u0007ည\u0006\bဇ\u0007\tဇ\b\n᠌\t", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", zzabx.f75607a});
        }
        if (i4 == 3) {
            return new zzabv();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzabu(bArr);
        }
        if (i4 == 5) {
            return zzo;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzp;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzabv.class) {
            try {
                zzbdlVar = zzp;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzo);
                    zzp = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
