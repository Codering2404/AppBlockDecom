package com.google.android.libraries.places.internal;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcf extends zzbdq implements zzbey {
    private static final zzcf zzu;
    private static volatile zzbff zzv;
    private int zzb;
    private zzcp zze;
    private zzby zzf;
    private zzbea zzg = zzbdq.s();
    private zzbea zzh = zzbdq.s();
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private int zzr;
    private boolean zzs;
    private boolean zzt;

    static {
        zzcf zzcfVar = new zzcf();
        zzu = zzcfVar;
        zzbdq.D(zzcf.class, zzcfVar);
    }

    private zzcf() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzu, "\u0001\u0010\u0000\u0001\u0001\u0010\u0010\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001b\u0005င\u0002\u0006င\u0003\u0007င\u0004\bင\u0005\tဂ\u0006\nဂ\u0007\u000bဂ\b\fဂ\t\rဂ\n\u000e᠌\u000b\u000fဇ\f\u0010ဇ\r", new Object[]{"zzb", "zze", "zzf", "zzg", zzcd.class, "zzh", zzcd.class, QaXmqxvjHhxVy.qENUEEbm, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", zzce.f77694a, "zzs", "zzt"});
        }
        if (i4 == 3) {
            return new zzcf();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzcb(bArr);
        }
        if (i4 == 5) {
            return zzu;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzv;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzcf.class) {
            try {
                zzbdlVar = zzv;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzu);
                    zzv = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
