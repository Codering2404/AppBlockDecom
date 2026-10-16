package com.google.android.libraries.places.internal;

import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzyk extends zzbdq implements zzbey {
    private static final zzyk zzt;
    private static volatile zzbff zzu;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;

    static {
        zzyk zzykVar = new zzyk();
        zzt = zzykVar;
        zzbdq.D(zzyk.class, zzykVar);
    }

    private zzyk() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzt, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003ဋ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ဋ\u0005\u0007ဋ\u0006\bဋ\u0007\tဋ\b\nဋ\t\u000bဋ\n\fဋ\u000b\rဋ\f\u000eဋ\r\u000fဋ\u000e", new Object[]{MrGIhy.qdkLcPaGpYvQ, "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs"});
        }
        if (i4 == 3) {
            return new zzyk();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzyj(bArr);
        }
        if (i4 == 5) {
            return zzt;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzu;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzyk.class) {
            try {
                zzbdlVar = zzu;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzt);
                    zzu = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
