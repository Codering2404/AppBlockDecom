package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzte extends zznd implements zzoj {
    private static final zzte zzb;
    private static volatile zzoq zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private zztc zzj;
    private int zzk;
    private zztl zzl;

    static {
        zzte zzteVar = new zzte();
        zzb = zzteVar;
        zznd.zzI(zzte.class, zzteVar);
    }

    private zzte() {
    }

    static /* synthetic */ void zzM(zzte zzteVar, int i3) {
        if (i3 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzteVar.zzh = i3 - 2;
    }

    static /* synthetic */ void zzN(zzte zzteVar, int i3) {
        if (i3 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzteVar.zzf = i3 - 2;
    }

    public static zztd zzf() {
        return (zztd) zzb.zzq();
    }

    @Override // com.google.android.recaptcha.internal.zznd
    protected final Object zzh(int i3, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zznd.zzF(zzb, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\f\u0002\u000b\u0003\f\u0004\f\u0005ဉ\u0000\u0006\u000b\u0007ဉ\u0001", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i4 == 3) {
            return new zzte();
        }
        zztj zztjVar = null;
        if (i4 == 4) {
            return new zztd(zztjVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        if (i4 != 6) {
            return null;
        }
        zzoq zzoqVar = zzd;
        if (zzoqVar != null) {
            return zzoqVar;
        }
        synchronized (zzte.class) {
            try {
                zzmyVar = zzd;
                if (zzmyVar == null) {
                    zzmyVar = new zzmy(zzb);
                    zzd = zzmyVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzmyVar;
    }

    public final int zzk() {
        int i3;
        switch (this.zzh) {
            case 0:
                i3 = 2;
                break;
            case 1:
                i3 = 3;
                break;
            case 2:
                i3 = 4;
                break;
            case 3:
                i3 = 5;
                break;
            case 4:
                i3 = 6;
                break;
            case 5:
                i3 = 7;
                break;
            case 6:
                i3 = 8;
                break;
            case 7:
                i3 = 9;
                break;
            case 8:
                i3 = 10;
                break;
            case 9:
                i3 = 11;
                break;
            case 10:
                i3 = 12;
                break;
            case 11:
                i3 = 13;
                break;
            case 12:
                i3 = 14;
                break;
            case 13:
                i3 = 15;
                break;
            case 14:
                i3 = 16;
                break;
            case 15:
                i3 = 17;
                break;
            case 16:
                i3 = 18;
                break;
            case 17:
                i3 = 19;
                break;
            case 18:
                i3 = 20;
                break;
            case 19:
                i3 = 21;
                break;
            case 20:
                i3 = 22;
                break;
            case 21:
                i3 = 23;
                break;
            case 22:
                i3 = 24;
                break;
            case 23:
                i3 = 25;
                break;
            case 24:
                i3 = 26;
                break;
            case 25:
                i3 = 27;
                break;
            case 26:
                i3 = 28;
                break;
            case 27:
                i3 = 29;
                break;
            case 28:
                i3 = 30;
                break;
            case 29:
                i3 = 31;
                break;
            case 30:
                i3 = 32;
                break;
            case 31:
                i3 = 33;
                break;
            case 32:
                i3 = 34;
                break;
            case 33:
                i3 = 35;
                break;
            case 34:
                i3 = 36;
                break;
            case 35:
                i3 = 37;
                break;
            case 36:
                i3 = 38;
                break;
            case 37:
                i3 = 39;
                break;
            case 38:
                i3 = 40;
                break;
            case 39:
                i3 = 41;
                break;
            case 40:
                i3 = 42;
                break;
            case 41:
                i3 = 43;
                break;
            case 42:
                i3 = 44;
                break;
            case 43:
                i3 = 45;
                break;
            case 44:
                i3 = 46;
                break;
            case 45:
                i3 = 47;
                break;
            case 46:
                i3 = 48;
                break;
            case 47:
                i3 = 49;
                break;
            case 48:
                i3 = 50;
                break;
            case 49:
                i3 = 51;
                break;
            case 50:
                i3 = 52;
                break;
            case 51:
                i3 = 53;
                break;
            case 52:
                i3 = 54;
                break;
            case 53:
                i3 = 55;
                break;
            case 54:
                i3 = 56;
                break;
            case 55:
                i3 = 57;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public final int zzl() {
        int i3;
        switch (this.zzf) {
            case 0:
                i3 = 2;
                break;
            case 1:
                i3 = 3;
                break;
            case 2:
                i3 = 4;
                break;
            case 3:
                i3 = 5;
                break;
            case 4:
                i3 = 6;
                break;
            case 5:
                i3 = 7;
                break;
            case 6:
                i3 = 8;
                break;
            case 7:
                i3 = 9;
                break;
            case 8:
                i3 = 10;
                break;
            case 9:
                i3 = 11;
                break;
            case 10:
                i3 = 12;
                break;
            case 11:
                i3 = 13;
                break;
            case 12:
                i3 = 14;
                break;
            case 13:
                i3 = 15;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }
}
