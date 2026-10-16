package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaae extends zzbdq implements zzbey {
    private static final zzaae zzt;
    private static volatile zzbff zzu;
    private int zzb;
    private zzaaq zzf;
    private zzaas zzg;
    private zzaut zzh;
    private zzabn zzi;
    private zzaby zzj;
    private zzabp zzk;
    private zzaau zzl;
    private zzaao zzm;
    private zzabh zzn;
    private zzabj zzo;
    private zzaba zzp;
    private zzaai zzq;
    private zzabt zzr;
    private byte zzs = 2;
    private int zze = 1;

    static {
        zzaae zzaaeVar = new zzaae();
        zzt = zzaaeVar;
        zzbdq.D(zzaae.class, zzaaeVar);
    }

    private zzaae() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzs);
        }
        if (i4 == 2) {
            return zzbdq.m(zzt, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0001\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ᐉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဉ\b\nဉ\t\u000bဉ\n\fဉ\u000b\rဉ\f\u000eဉ\r", new Object[]{"zzb", "zze", zzaad.f75603a, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
        }
        if (i4 == 3) {
            return new zzaae();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaac(bArr);
        }
        if (i4 == 5) {
            return zzt;
        }
        if (i4 != 6) {
            this.zzs = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzbff zzbffVar = zzu;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaae.class) {
            try {
                zzbdlVar = zzu;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzt);
                    zzu = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
