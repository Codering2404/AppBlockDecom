package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzazx extends zzbdq implements zzbey {
    private static final zzazx zzl;
    private static volatile zzbff zzm;
    private int zzb;
    private boolean zze;
    private int zzh;
    private zzbfw zzj;
    private zzbfw zzk;
    private zzbea zzf = zzbdq.s();
    private zzbea zzg = zzbdq.s();
    private zzbea zzi = zzbdq.s();

    static {
        zzazx zzazxVar = new zzazx();
        zzl = zzazxVar;
        zzbdq.D(zzazx.class, zzazxVar);
    }

    private zzazx() {
    }

    public static zzazx Q() {
        return zzl;
    }

    public final boolean G() {
        return (this.zzb & 1) != 0;
    }

    public final boolean H() {
        return this.zze;
    }

    public final List I() {
        return this.zzf;
    }

    public final List J() {
        return this.zzg;
    }

    public final zzazu K() {
        zzazu zzazuVar;
        switch (this.zzh) {
            case 0:
                zzazuVar = zzazu.SECONDARY_HOURS_TYPE_UNSPECIFIED;
                break;
            case 1:
                zzazuVar = zzazu.DRIVE_THROUGH;
                break;
            case 2:
                zzazuVar = zzazu.HAPPY_HOUR;
                break;
            case 3:
                zzazuVar = zzazu.DELIVERY;
                break;
            case 4:
                zzazuVar = zzazu.TAKEOUT;
                break;
            case 5:
                zzazuVar = zzazu.KITCHEN;
                break;
            case 6:
                zzazuVar = zzazu.BREAKFAST;
                break;
            case 7:
                zzazuVar = zzazu.LUNCH;
                break;
            case 8:
                zzazuVar = zzazu.DINNER;
                break;
            case 9:
                zzazuVar = zzazu.BRUNCH;
                break;
            case 10:
                zzazuVar = zzazu.PICKUP;
                break;
            case 11:
                zzazuVar = zzazu.ACCESS;
                break;
            case 12:
                zzazuVar = zzazu.SENIOR_HOURS;
                break;
            case 13:
                zzazuVar = zzazu.ONLINE_SERVICE_HOURS;
                break;
            default:
                zzazuVar = null;
                break;
        }
        return zzazuVar == null ? zzazu.UNRECOGNIZED : zzazuVar;
    }

    public final List L() {
        return this.zzi;
    }

    public final boolean M() {
        return (this.zzb & 2) != 0;
    }

    public final zzbfw N() {
        zzbfw zzbfwVar = this.zzj;
        return zzbfwVar == null ? zzbfw.J() : zzbfwVar;
    }

    public final boolean O() {
        return (this.zzb & 4) != 0;
    }

    public final zzbfw P() {
        zzbfw zzbfwVar = this.zzk;
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
            return zzbdq.m(zzl, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0003\u0000\u0001ဇ\u0000\u0002\u001b\u0003Ț\u0004\f\u0005\u001b\u0006ဉ\u0001\u0007ဉ\u0002", new Object[]{"zzb", "zze", "zzf", zzazt.class, "zzg", "zzh", "zzi", zzazw.class, "zzj", "zzk"});
        }
        if (i4 == 3) {
            return new zzazx();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzazp(bArr);
        }
        if (i4 == 5) {
            return zzl;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzm;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzazx.class) {
            try {
                zzbdlVar = zzm;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzl);
                    zzm = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
