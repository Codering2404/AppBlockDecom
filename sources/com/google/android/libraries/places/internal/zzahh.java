package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzahh extends zzbdq implements zzbey {
    private static final zzahh zzs;
    private static volatile zzbff zzt;
    private int zzb;
    private long zze;
    private zzagw zzf;
    private zzagw zzg;
    private zzahq zzh;
    private zzahc zzi;
    private zzagm zzj;
    private zzaht zzk;
    private zzahv zzl;
    private zzahj zzm;
    private zzagi zzn;
    private zzago zzo;
    private zzahf zzp;
    private zzahl zzq;
    private zzahn zzr;

    static {
        zzahh zzahhVar = new zzahh();
        zzs = zzahhVar;
        zzbdq.D(zzahh.class, zzahhVar);
    }

    private zzahh() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzs, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဉ\b\nဉ\t\u000bဉ\n\fဉ\u000b\rဉ\f\u000eဉ\r", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
        }
        if (i4 == 3) {
            return new zzahh();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzahg(bArr);
        }
        if (i4 == 5) {
            return zzs;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzt;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzahh.class) {
            try {
                zzbdlVar = zzt;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzs);
                    zzt = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
