package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzack extends zzxr implements zzzh {
    private static final zzack zzd;
    private int zze;
    private zzacm zzf;
    private byte zzg = 2;

    static {
        zzack zzackVar = new zzack();
        zzd = zzackVar;
        zzxv.zzan(zzack.class, zzackVar);
    }

    private zzack() {
    }

    public static zzack zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i4 == 2) {
            return zzxv.zzak(zzd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzack();
        }
        zzaci zzaciVar = null;
        if (i4 == 4) {
            return new zzacj(zzaciVar);
        }
        if (i4 == 5) {
            return zzd;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
