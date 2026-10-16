package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzayg extends zzbdq implements zzbey {
    private static final zzayg zzh;
    private static volatile zzbff zzi;
    private String zzb = "";
    private int zze;
    private int zzf;
    private boolean zzg;

    static {
        zzayg zzaygVar = new zzayg();
        zzh = zzaygVar;
        zzbdq.D(zzayg.class, zzaygVar);
    }

    private zzayg() {
    }

    public static zzayf G() {
        return (zzayf) zzh.A();
    }

    public static zzayg H() {
        return zzh;
    }

    final /* synthetic */ void I(String str) {
        this.zzb = str;
    }

    final /* synthetic */ void J(int i3) {
        this.zze = i3;
    }

    final /* synthetic */ void K(int i3) {
        this.zzf = i3;
    }

    final /* synthetic */ void L(boolean z2) {
        this.zzg = true;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0004\u0004\u0007", new Object[]{"zzb", "zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzayg();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzayf(bArr);
        }
        if (i4 == 5) {
            return zzh;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzi;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzayg.class) {
            try {
                zzbdlVar = zzi;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzh);
                    zzi = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
