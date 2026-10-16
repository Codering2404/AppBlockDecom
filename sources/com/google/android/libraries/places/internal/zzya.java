package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzya extends zzbdq implements zzbey {
    private static final zzya zzn;
    private static volatile zzbff zzo;
    private int zzb;
    private int zzf;
    private int zzg;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private String zze = "";
    private String zzh = "";

    static {
        zzya zzyaVar = new zzya();
        zzn = zzyaVar;
        zzbdq.D(zzya.class, zzyaVar);
    }

    private zzya() {
    }

    public static zzxv G() {
        return (zzxv) zzn.A();
    }

    final /* synthetic */ void H(String str) {
        this.zzb |= 1;
        this.zze = str;
    }

    final /* synthetic */ void I(int i3) {
        this.zzb |= 2;
        this.zzf = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0002\u0004ဈ\u0003\u0005င\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007\t᠌\b", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzxw.f78838a, "zzk", zzxy.f78840a, "zzl", zzxx.f78839a, "zzm", zzxz.f78841a});
        }
        if (i4 == 3) {
            return new zzya();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzxv(bArr);
        }
        if (i4 == 5) {
            return zzn;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzo;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzya.class) {
            try {
                zzbdlVar = zzo;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzn);
                    zzo = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
