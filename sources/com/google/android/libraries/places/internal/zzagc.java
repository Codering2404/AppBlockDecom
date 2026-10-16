package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzagc extends zzbdq implements zzbey {
    private static final zzagc zzB;
    private static volatile zzbff zzC;
    private boolean zzA;
    private int zzb;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private float zzh;
    private float zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private int zzq;
    private float zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private zzbea zzx = zzbdq.s();
    private int zzy;
    private float zzz;

    static {
        zzagc zzagcVar = new zzagc();
        zzB = zzagcVar;
        zzbdq.D(zzagc.class, zzagcVar);
    }

    private zzagc() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            zzbdw zzbdwVar = zzagb.f75624a;
            zzbdw zzbdwVar2 = zzaaa.f75601a;
            return zzbdq.m(zzB, "\u0001\u0017\u0000\u0001\u0001\u0017\u0017\u0000\u0001\u0000\u0001င\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\tဇ\b\nင\t\u000bင\n\fဇ\u000b\r᠌\f\u000eခ\r\u000f᠌\u000e\u0010᠌\u000f\u0011᠌\u0010\u0012᠌\u0011\u0013᠌\u0012\u0014\u001b\u0015င\u0013\u0016ခ\u0014\u0017ဇ\u0015", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzbdwVar, "zzr", "zzs", zzbdwVar2, "zzt", zzbdwVar2, "zzu", zzbdwVar2, "zzv", zzbdwVar2, "zzw", zzaab.f75602a, "zzx", zzafv.class, "zzy", "zzz", "zzA"});
        }
        if (i4 == 3) {
            return new zzagc();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaga(bArr);
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
        synchronized (zzagc.class) {
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
