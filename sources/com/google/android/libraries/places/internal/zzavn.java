package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzavn extends zzbdq implements zzbey {
    private static final zzavn zzj;
    private static volatile zzbff zzk;
    private Object zze;
    private int zzb = 0;
    private String zzf = "";
    private String zzg = "";
    private zzbea zzh = zzbdq.s();
    private zzbdy zzi = zzbdq.p();

    static {
        zzavn zzavnVar = new zzavn();
        zzj = zzavnVar;
        zzbdq.D(zzavn.class, zzavnVar);
    }

    private zzavn() {
    }

    public static zzavm G() {
        return (zzavm) zzj.A();
    }

    public static zzavn H() {
        return zzj;
    }

    final /* synthetic */ void I(String str) {
        this.zzb = 1;
        this.zze = str;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzj, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0002\u0000\u0001Ȼ\u0000\u0002<\u0000\u0003Ȉ\u0004Ȉ\u0005Ț\u0006,", new Object[]{"zze", "zzb", zzbht.class, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i4 == 3) {
            return new zzavn();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzavm(bArr);
        }
        if (i4 == 5) {
            return zzj;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzk;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzavn.class) {
            try {
                zzbdlVar = zzk;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzj);
                    zzk = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
