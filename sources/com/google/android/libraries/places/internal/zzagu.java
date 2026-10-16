package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzagu extends zzbdq implements zzbey {
    private static final zzagu zzv;
    private static volatile zzbff zzw;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private zzbea zzj = zzbdq.s();
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;

    static {
        zzagu zzaguVar = new zzagu();
        zzv = zzaguVar;
        zzbdq.D(zzagu.class, zzaguVar);
    }

    private zzagu() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzv, "\u0001\u0011\u0000\u0001\u0001\u0011\u0011\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006\u001b\u0007င\u0005\bင\u0006\tင\u0007\nင\b\u000bင\t\fင\n\rင\u000b\u000eင\f\u000fင\r\u0010င\u000e\u0011င\u000f", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzagt.class, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu"});
        }
        if (i4 == 3) {
            return new zzagu();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzagr(bArr);
        }
        if (i4 == 5) {
            return zzv;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzw;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzagu.class) {
            try {
                zzbdlVar = zzw;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzv);
                    zzw = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
