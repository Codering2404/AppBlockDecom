package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzafl extends zzbdq implements zzbey {
    private static final zzafl zzv;
    private static volatile zzbff zzw;
    private int zzb;
    private zzafi zze;
    private zzaeu zzg;
    private zzaeu zzh;
    private zzzt zzi;
    private int zzj;
    private zzaew zzk;
    private zzaes zzl;
    private zzaep zzm;
    private zzaey zzn;
    private zzaen zzp;
    private zzafa zzq;
    private zzaec zzr;
    private zzagc zzs;
    private zzage zzt;
    private zzaft zzu;
    private zzbea zzf = zzbdq.s();
    private zzbea zzo = zzbdq.s();

    static {
        zzafl zzaflVar = new zzafl();
        zzv = zzaflVar;
        zzbdq.D(zzafl.class, zzaflVar);
    }

    private zzafl() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzv, "\u0001\u0011\u0000\u0001\u0001\u0011\u0011\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဉ\u0001\u0004ဉ\u0002\u0005ဉ\u0003\u0006᠌\u0004\u0007ဉ\u0005\bဉ\u0006\tဉ\u0007\nဉ\b\u000b\u001b\fဉ\t\rဉ\n\u000eဉ\u000b\u000fဉ\f\u0010ဉ\r\u0011ဉ\u000e", new Object[]{"zzb", "zze", "zzf", zzafn.class, "zzg", "zzh", "zzi", "zzj", zzafk.f75623a, "zzk", "zzl", "zzm", "zzn", "zzo", zzafe.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu"});
        }
        if (i4 == 3) {
            return new zzafl();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzafj(bArr);
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
        synchronized (zzafl.class) {
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
