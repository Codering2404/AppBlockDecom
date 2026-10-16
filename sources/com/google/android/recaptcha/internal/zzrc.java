package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzrc extends zznd implements zzoj {
    private static final zzrc zzb;
    private static volatile zzoq zzd;
    private int zze;
    private Object zzg;
    private int zzh;
    private int zzi;
    private long zzn;
    private zzml zzo;
    private int zzp;
    private zzqq zzq;
    private zzro zzr;
    private zzpj zzt;
    private zzml zzu;
    private int zzw;
    private int zzf = 0;
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private String zzs = "";
    private zzni zzv = zznd.zzy();

    static {
        zzrc zzrcVar = new zzrc();
        zzb = zzrcVar;
        zznd.zzI(zzrc.class, zzrcVar);
    }

    private zzrc() {
    }

    static /* synthetic */ void zzO(zzrc zzrcVar, int i3) {
        zzni zzniVar = zzrcVar.zzv;
        if (!zzniVar.zzc()) {
            zzrcVar.zzv = zznd.zzz(zzniVar);
        }
        zzrcVar.zzv.zzh(0);
    }

    static /* synthetic */ void zzP(zzrc zzrcVar, String str) {
        str.getClass();
        zzrcVar.zzj = str;
    }

    static /* synthetic */ void zzR(zzrc zzrcVar, zzqq zzqqVar) {
        zzrcVar.zzq = zzqqVar;
        zzrcVar.zze |= 2;
    }

    static /* synthetic */ void zzS(zzrc zzrcVar, String str) {
        str.getClass();
        zzrcVar.zzk = str;
    }

    static /* synthetic */ void zzT(zzrc zzrcVar, zzro zzroVar) {
        zzroVar.getClass();
        zzrcVar.zzr = zzroVar;
        zzrcVar.zze |= 4;
    }

    static /* synthetic */ void zzU(zzrc zzrcVar, int i3) {
        zzrcVar.zze |= 32;
        zzrcVar.zzw = i3;
    }

    static /* synthetic */ void zzab(zzrc zzrcVar, int i3) {
        if (i3 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzrcVar.zzi = i3 - 2;
    }

    public static zzra zzi() {
        return (zzra) zzb.zzq();
    }

    public static zzrc zzk() {
        return zzb;
    }

    public static zzrc zzl(byte[] bArr) throws zznn {
        return (zzrc) zznd.zzx(zzb, bArr);
    }

    public final String zzM() {
        return this.zzk;
    }

    public final String zzN() {
        return this.zzl;
    }

    public final boolean zzX() {
        return (this.zze & 2) != 0;
    }

    public final int zzY() {
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
            default:
                i3 = 0;
                break;
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public final int zzZ() {
        int i3 = this.zzp;
        int i4 = i3 != 0 ? i3 != 1 ? i3 != 2 ? 0 : 4 : 3 : 2;
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }

    @Deprecated
    public final long zzf() {
        return this.zzn;
    }

    public final zzqq zzg() {
        zzqq zzqqVar = this.zzq;
        return zzqqVar == null ? zzqq.zzj() : zzqqVar;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    protected final Object zzh(int i3, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zznd.zzF(zzb, "\u0000\u0011\u0001\u0001\u0001\u0013\u0011\u0000\u0001\u0000\u0001\f\u0002Ȉ\u0003\u0003\u0004\f\u0005ဉ\u0001\u0006ဉ\u0002\u0007Ȉ\bȈ\tȈ\nဉ\u0000\u000bဉ\u0003\rဉ\u0004\u000eȈ\u000f<\u0000\u0011'\u0012င\u0005\u0013\f", new Object[]{"zzg", "zzf", "zze", "zzh", "zzk", "zzn", "zzp", "zzq", "zzr", "zzs", "zzl", "zzm", "zzo", "zzt", "zzu", "zzj", zzqg.class, "zzv", "zzw", "zzi"});
        }
        if (i4 == 3) {
            return new zzrc();
        }
        zzrb zzrbVar = null;
        if (i4 == 4) {
            return new zzra(zzrbVar);
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
        synchronized (zzrc.class) {
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
}
