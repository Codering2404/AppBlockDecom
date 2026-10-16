package com.google.android.libraries.places.internal;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzadn extends zzbdq implements zzbey {
    private static final zzadn zzB;
    private static volatile zzbff zzC;
    private int zzA;
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
    private zzadu zzt;
    private zzadw zzu;
    private zzadk zzv;
    private zzadp zzw;
    private zzadr zzx;
    private int zzy;
    private int zzz;

    static {
        zzadn zzadnVar = new zzadn();
        zzB = zzadnVar;
        zzbdq.D(zzadn.class, zzadnVar);
    }

    private zzadn() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzB, "\u0001\u0017\u0000\u0001\u0001\u0017\u0017\u0000\u0000\u0000\u0001ဋ\u0001\u0002ဋ\u0002\u0003ဋ\u0003\u0004ဋ\u0004\u0005ဋ\u0005\u0006ဋ\u0006\u0007ဋ\u0007\bဋ\b\tဋ\t\nဋ\n\u000bဋ\u000b\fဋ\f\rဋ\r\u000eဋ\u000e\u000fဉ\u000f\u0010ဋ\u0000\u0011ဉ\u0010\u0012ဉ\u0011\u0013ဉ\u0012\u0014ဉ\u0013\u0015᠌\u0014\u0016ဋ\u0015\u0017ဋ\u0016", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zze", "zzu", "zzv", "zzw", "zzx", rnFwbPAQmQTnL.Xsss, zzadm.f75614a, "zzz", "zzA"});
        }
        if (i4 == 3) {
            return new zzadn();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzadl(bArr);
        }
        if (i4 == 5) {
            return zzB;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzC;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzadn.class) {
            try {
                zzbdlVar = zzC;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzB);
                    zzC = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
