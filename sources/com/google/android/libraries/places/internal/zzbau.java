package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbau extends zzbdq implements zzbey {
    private static final zzbau zzo;
    private static volatile zzbff zzp;
    private int zzb;
    private zzbhv zzg;
    private zzbhv zzh;
    private double zzi;
    private zzawg zzj;
    private zzbfw zzk;
    private zzbhr zzn;
    private String zze = "";
    private String zzf = "";
    private String zzl = "";
    private String zzm = "";

    static {
        zzbau zzbauVar = new zzbau();
        zzo = zzbauVar;
        zzbdq.D(zzbau.class, zzbauVar);
    }

    private zzbau() {
    }

    public final String G() {
        return this.zzf;
    }

    public final boolean H() {
        return (this.zzb & 1) != 0;
    }

    public final zzbhv I() {
        zzbhv zzbhvVar = this.zzg;
        return zzbhvVar == null ? zzbhv.I() : zzbhvVar;
    }

    public final boolean J() {
        return (this.zzb & 2) != 0;
    }

    public final zzbhv K() {
        zzbhv zzbhvVar = this.zzh;
        return zzbhvVar == null ? zzbhv.I() : zzbhvVar;
    }

    public final double L() {
        return this.zzi;
    }

    public final boolean M() {
        return (this.zzb & 4) != 0;
    }

    public final zzawg N() {
        zzawg zzawgVar = this.zzj;
        return zzawgVar == null ? zzawg.J() : zzawgVar;
    }

    public final boolean O() {
        return (this.zzb & 8) != 0;
    }

    public final zzbfw P() {
        zzbfw zzbfwVar = this.zzk;
        return zzbfwVar == null ? zzbfw.J() : zzbfwVar;
    }

    public final String Q() {
        return this.zzl;
    }

    public final boolean R() {
        return (this.zzb & 16) != 0;
    }

    public final zzbhr S() {
        zzbhr zzbhrVar = this.zzn;
        return zzbhrVar == null ? zzbhr.J() : zzbhrVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzo, "\u0000\n\u0000\u0001\u0001\u0011\n\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0007\u0000\tဉ\u0000\fဉ\u0001\rဉ\u0002\u000eဉ\u0003\u000fȈ\u0010Ȉ\u0011ဉ\u0004", new Object[]{"zzb", "zze", "zzf", "zzi", "zzg", "zzh", "zzj", "zzk", "zzl", "zzm", "zzn"});
        }
        if (i4 == 3) {
            return new zzbau();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbat(bArr);
        }
        if (i4 == 5) {
            return zzo;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzp;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbau.class) {
            try {
                zzbdlVar = zzp;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzo);
                    zzp = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
