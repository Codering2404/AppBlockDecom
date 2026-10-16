package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzayd extends zzbdq implements zzbey {
    private static final zzayd zzh;
    private static volatile zzbff zzi;
    private int zzb;
    private int zze;
    private zzbhx zzf;
    private zzbfw zzg;

    static {
        zzayd zzaydVar = new zzayd();
        zzh = zzaydVar;
        zzbdq.D(zzayd.class, zzaydVar);
    }

    private zzayd() {
    }

    public final zzayc G() {
        zzayc zzaycVar;
        switch (this.zze) {
            case 0:
                zzaycVar = zzayc.FUEL_TYPE_UNSPECIFIED;
                break;
            case 1:
                zzaycVar = zzayc.DIESEL;
                break;
            case 2:
                zzaycVar = zzayc.REGULAR_UNLEADED;
                break;
            case 3:
                zzaycVar = zzayc.MIDGRADE;
                break;
            case 4:
                zzaycVar = zzayc.PREMIUM;
                break;
            case 5:
                zzaycVar = zzayc.SP91;
                break;
            case 6:
                zzaycVar = zzayc.SP91_E10;
                break;
            case 7:
                zzaycVar = zzayc.SP92;
                break;
            case 8:
                zzaycVar = zzayc.SP95;
                break;
            case 9:
                zzaycVar = zzayc.SP95_E10;
                break;
            case 10:
                zzaycVar = zzayc.SP98;
                break;
            case 11:
                zzaycVar = zzayc.SP99;
                break;
            case 12:
                zzaycVar = zzayc.SP100;
                break;
            case 13:
                zzaycVar = zzayc.LPG;
                break;
            case 14:
                zzaycVar = zzayc.E80;
                break;
            case 15:
                zzaycVar = zzayc.E85;
                break;
            case 16:
                zzaycVar = zzayc.METHANE;
                break;
            case 17:
                zzaycVar = zzayc.BIO_DIESEL;
                break;
            case 18:
                zzaycVar = zzayc.TRUCK_DIESEL;
                break;
            case 19:
                zzaycVar = zzayc.DIESEL_PLUS;
                break;
            case 20:
                zzaycVar = zzayc.E100;
                break;
            default:
                zzaycVar = null;
                break;
        }
        return zzaycVar == null ? zzayc.UNRECOGNIZED : zzaycVar;
    }

    public final zzbhx H() {
        zzbhx zzbhxVar = this.zzf;
        return zzbhxVar == null ? zzbhx.J() : zzbhxVar;
    }

    public final zzbfw I() {
        zzbfw zzbfwVar = this.zzg;
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
            return zzbdq.m(zzh, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzb", "zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzayd();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzayb(bArr);
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
        synchronized (zzayd.class) {
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
