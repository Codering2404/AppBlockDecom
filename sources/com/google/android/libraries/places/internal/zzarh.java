package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzarh extends zzbdq implements zzbey {
    private static final zzarh zzk;
    private static volatile zzbff zzl;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private String zzh = "";
    private boolean zzi;
    private int zzj;

    static {
        zzarh zzarhVar = new zzarh();
        zzk = zzarhVar;
        zzbdq.D(zzarh.class, zzarhVar);
    }

    private zzarh() {
    }

    public static zzarg G() {
        return (zzarg) zzk.A();
    }

    final /* synthetic */ void H(int i3) {
        this.zzb |= 1;
        this.zze = i3;
    }

    final /* synthetic */ void I(int i3) {
        this.zzb |= 2;
        this.zzf = i3;
    }

    final /* synthetic */ void J(int i3) {
        this.zzb |= 4;
        this.zzg = i3;
    }

    final /* synthetic */ void K(boolean z2) {
        this.zzb |= 16;
        this.zzi = z2;
    }

    final /* synthetic */ void L(int i3) {
        this.zzb |= 32;
        this.zzj = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004ဈ\u0003\u0005ဇ\u0004\u0006င\u0005", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i4 == 3) {
            return new zzarh();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzarg(bArr);
        }
        if (i4 == 5) {
            return zzk;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzl;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzarh.class) {
            try {
                zzbdlVar = zzl;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzk);
                    zzl = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
