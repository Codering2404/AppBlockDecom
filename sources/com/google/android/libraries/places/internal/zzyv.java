package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzyv extends zzbdq implements zzbey {
    private static final zzyv zzy;
    private static volatile zzbff zzz;
    private int zzb;
    private boolean zze;
    private int zzf;
    private boolean zzg;
    private int zzh;
    private boolean zzi;
    private int zzj;
    private boolean zzk;
    private int zzl;
    private boolean zzm;
    private int zzn;
    private boolean zzo;
    private int zzp;
    private boolean zzq;
    private int zzr;
    private boolean zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private int zzx;

    static {
        zzyv zzyvVar = new zzyv();
        zzy = zzyvVar;
        zzbdq.D(zzyv.class, zzyvVar);
    }

    private zzyv() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzy, "\u0001\u0014\u0000\u0001\u0001\u0014\u0014\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004င\u0003\u0005ဇ\u0004\u0006င\u0005\u0007ဇ\u0006\bင\u0007\tဇ\b\nင\t\u000bဇ\n\fင\u000b\rဇ\f\u000eင\r\u000fဇ\u000e\u0010င\u000f\u0011င\u0010\u0012င\u0011\u0013င\u0012\u0014ဋ\u0013", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx"});
        }
        if (i4 == 3) {
            return new zzyv();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzyu(bArr);
        }
        if (i4 == 5) {
            return zzy;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzz;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzyv.class) {
            try {
                zzbdlVar = zzz;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzy);
                    zzz = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
