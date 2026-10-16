package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzadk extends zzbdq implements zzbey {
    private static final zzadk zzr;
    private static volatile zzbff zzs;
    private int zzb;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
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

    static {
        zzadk zzadkVar = new zzadk();
        zzr = zzadkVar;
        zzbdq.D(zzadk.class, zzadkVar);
    }

    private zzadk() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzr, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ဋ\u0005\u0007ဋ\u0006\bဋ\u0007\tဋ\b\nဋ\t\u000bဋ\n\fဋ\u000b\rဋ\f", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq"});
        }
        if (i4 == 3) {
            return new zzadk();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzadj(bArr);
        }
        if (i4 == 5) {
            return zzr;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzs;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzadk.class) {
            try {
                zzbdlVar = zzs;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzr);
                    zzs = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
