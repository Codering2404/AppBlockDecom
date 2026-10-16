package com.google.android.libraries.places.internal;

import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzafi extends zzbdq implements zzbey {
    private static final zzafi zzA;
    private static volatile zzbff zzB;
    private int zzb;
    private long zze;
    private long zzh;
    private long zzi;
    private long zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private int zzp;
    private long zzq;
    private zzaej zzr;
    private long zzs;
    private zzagg zzv;
    private zzagg zzw;
    private zzaea zzz;
    private zzbea zzf = zzbdq.s();
    private zzbea zzg = zzbdq.s();
    private zzbea zzt = zzbdq.s();
    private zzbea zzu = zzbdq.s();
    private zzbea zzx = zzbdq.s();
    private zzbea zzy = zzbdq.s();

    static {
        zzafi zzafiVar = new zzafi();
        zzA = zzafiVar;
        zzbdq.D(zzafi.class, zzafiVar);
    }

    private zzafi() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzA, "\u0001\u0016\u0000\u0001\u0001\u0019\u0016\u0000\u0006\u0000\u0001စ\u0000\u0003\u001b\u0004\u001b\u0005ဂ\u0001\u0006ဂ\u0002\u0007ဂ\u0003\bင\u0004\tင\u0005\nဂ\u0006\u000bဂ\u0007\fင\b\rင\t\u000eဂ\n\u000fဉ\u000b\u0010ဂ\f\u0011\u001b\u0012\u001b\u0013ဉ\r\u0014ဉ\u000e\u0015\u001b\u0016\u001b\u0019ဉ\u000f", new Object[]{"zzb", "zze", "zzf", zzafp.class, "zzg", zzafr.class, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", qRMDmh.XqEHQa, "zzr", "zzs", "zzt", zzafz.class, "zzu", zzafz.class, "zzv", "zzw", "zzx", zzafg.class, "zzy", zzafg.class, "zzz"});
        }
        if (i4 == 3) {
            return new zzafi();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzafh(bArr);
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
        synchronized (zzafi.class) {
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
