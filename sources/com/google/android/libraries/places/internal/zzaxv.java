package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaxv extends zzbdq implements zzbey {
    private static final zzaxv zzk;
    private static volatile zzbff zzl;
    private int zzb;
    private int zze;
    private double zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private zzbfw zzj;

    static {
        zzaxv zzaxvVar = new zzaxv();
        zzk = zzaxvVar;
        zzbdq.D(zzaxv.class, zzaxvVar);
    }

    private zzaxv() {
    }

    public final zzaxz G() {
        zzaxz zzaxzVar;
        switch (this.zze) {
            case 0:
                zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_UNSPECIFIED;
                break;
            case 1:
                zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_OTHER;
                break;
            case 2:
                zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_J1772;
                break;
            case 3:
                zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_TYPE_2;
                break;
            case 4:
                zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_CHADEMO;
                break;
            case 5:
                zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_CCS_COMBO_1;
                break;
            case 6:
                zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_CCS_COMBO_2;
                break;
            case 7:
                zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_TESLA;
                break;
            case 8:
                zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_UNSPECIFIED_GB_T;
                break;
            case 9:
                zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_UNSPECIFIED_WALL_OUTLET;
                break;
            case 10:
                zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_NACS;
                break;
            default:
                zzaxzVar = null;
                break;
        }
        return zzaxzVar == null ? zzaxz.UNRECOGNIZED : zzaxzVar;
    }

    public final double H() {
        return this.zzf;
    }

    public final int I() {
        return this.zzg;
    }

    public final boolean J() {
        return (this.zzb & 1) != 0;
    }

    public final int K() {
        return this.zzh;
    }

    public final boolean L() {
        return (this.zzb & 2) != 0;
    }

    public final int M() {
        return this.zzi;
    }

    public final boolean N() {
        return (this.zzb & 4) != 0;
    }

    public final zzbfw O() {
        zzbfw zzbfwVar = this.zzj;
        return zzbfwVar == null ? zzbfw.J() : zzbfwVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzk, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0002\u0000\u0003\u0004\u0004င\u0000\u0005င\u0001\u0006ဉ\u0002", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i4 == 3) {
            return new zzaxv();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaxu(bArr);
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
        synchronized (zzaxv.class) {
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
