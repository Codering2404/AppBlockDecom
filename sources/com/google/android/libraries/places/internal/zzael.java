package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzael extends zzbdq implements zzbey {
    private static final zzael zzs;
    private static volatile zzbff zzt;
    private int zzb;
    private long zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private zzbdz zzk = zzbdq.r();
    private long zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private long zzp;
    private int zzq;
    private long zzr;

    static {
        zzael zzaelVar = new zzael();
        zzs = zzaelVar;
        zzbdq.D(zzael.class, zzaelVar);
    }

    private zzael() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            zzbdw zzbdwVar = zzaei.f75619a;
            zzbdw zzbdwVar2 = zzaeh.f75618a;
            zzbdw zzbdwVar3 = zzaef.f75617a;
            return zzbdq.m(zzs, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0001\u0000\u0001ဂ\u0000\u0002င\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006င\u0005\u0007\u0014\bဂ\u0006\t᠌\u0007\n᠌\b\u000b᠌\t\fဂ\n\rင\u000b\u000eဂ\f", new Object[]{"zzb", "zze", "zzf", "zzg", zzbdwVar, "zzh", zzbdwVar2, "zzi", zzbdwVar3, "zzj", "zzk", "zzl", "zzm", zzbdwVar, "zzn", zzbdwVar2, "zzo", zzbdwVar3, "zzp", "zzq", "zzr"});
        }
        if (i4 == 3) {
            return new zzael();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaek(bArr);
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
        synchronized (zzael.class) {
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
