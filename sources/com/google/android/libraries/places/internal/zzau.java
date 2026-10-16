package com.google.android.libraries.places.internal;

import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzau extends zzbdq implements zzbey {
    private static final zzau zzA;
    private static volatile zzbff zzB;
    private int zzb;
    private boolean zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private float zzi;
    private float zzj;
    private boolean zzk;
    private float zzl;
    private double zzm;
    private int zzn;
    private long zzo;
    private float zzp;
    private float zzq;
    private float zzr;
    private float zzs;
    private float zzt;
    private float zzu;
    private float zzv;
    private float zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    static {
        zzau zzauVar = new zzau();
        zzA = zzauVar;
        zzbdq.D(zzau.class, zzauVar);
    }

    private zzau() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            String str = MrGIhy.kwdskUr;
            zzbdw zzbdwVar = zzat.f75813a;
            return zzbdq.m(zzA, "\u0001\u0016\u0000\u0001\u0001\u0016\u0016\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004᠌\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ဇ\u0006\bခ\u0007\tက\b\n᠌\t\u000bဂ\n\fခ\u000b\rခ\f\u000eခ\r\u000fခ\u000e\u0010ခ\u000f\u0011ခ\u0010\u0012ခ\u0011\u0013ခ\u0012\u0014ဇ\u0013\u0015ဇ\u0014\u0016ဇ\u0015", new Object[]{"zzb", str, "zzf", "zzg", "zzh", zzbdwVar, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", zzbdwVar, "zzo", "zzp", "zzq", "zzr", YgVrd.mnOcFqBV, "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz"});
        }
        if (i4 == 3) {
            return new zzau();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzas(bArr);
        }
        if (i4 == 5) {
            return zzA;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzB;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzau.class) {
            try {
                zzbdlVar = zzB;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzA);
                    zzB = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
