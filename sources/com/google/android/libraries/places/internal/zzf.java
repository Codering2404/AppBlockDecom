package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzf extends zzbdq implements zzbey {
    private static final zzf zzq;
    private static volatile zzbff zzr;
    private int zzb;
    private zzcy zze;
    private zzaj zzf;
    private zzm zzg;
    private zzo zzh;
    private zzj zzi;
    private zzx zzj;
    private zzh zzk;
    private zzs zzl;
    private zzad zzm;
    private zzab zzn;
    private zzu zzo;
    private zzz zzp;

    static {
        zzf zzfVar = new zzf();
        zzq = zzfVar;
        zzbdq.D(zzf.class, zzfVar);
    }

    private zzf() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzq, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဉ\u0001\u0002ဉ\u0002\u0003ဉ\u0003\u0004ဉ\u0004\u0005ဉ\u0005\u0006ဉ\u0006\u0007ဉ\u0007\bဉ\b\tဉ\t\nဉ\u0000\u000bဉ\n\fဉ\u000b", new Object[]{"zzb", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zze", "zzo", "zzp"});
        }
        if (i4 == 3) {
            return new zzf();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zze(bArr);
        }
        if (i4 == 5) {
            return zzq;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzr;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzf.class) {
            try {
                zzbdlVar = zzr;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzq);
                    zzr = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
