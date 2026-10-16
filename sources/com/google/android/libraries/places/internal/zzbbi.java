package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbbi extends zzbdq implements zzbey {
    private static final zzbbi zzt;
    private static volatile zzbff zzu;
    private int zzb;
    private int zzk;
    private zzbbh zzl;
    private int zzm;
    private zzbay zzn;
    private boolean zzo;
    private double zzp;
    private boolean zzr;
    private boolean zzs;
    private String zze = "";
    private String zzf = "";
    private zzbea zzg = zzbdq.s();
    private zzbea zzh = zzbdq.s();
    private zzbea zzi = zzbdq.s();
    private zzbea zzj = zzbdq.s();
    private zzbdy zzq = zzbdq.p();

    static {
        zzbbi zzbbiVar = new zzbbi();
        zzt = zzbbiVar;
        zzbdq.D(zzbbi.class, zzbbiVar);
    }

    private zzbbi() {
    }

    public static zzbbd G() {
        return (zzbbd) zzt.A();
    }

    public static zzbbi H() {
        return zzt;
    }

    final /* synthetic */ void I(String str) {
        str.getClass();
        this.zze = str;
    }

    final /* synthetic */ void J(String str) {
        this.zzf = str;
    }

    final /* synthetic */ void K(Iterable iterable) {
        zzbea zzbeaVar = this.zzg;
        if (!zzbeaVar.zza()) {
            this.zzg = zzbdq.t(zzbeaVar);
        }
        zzbby.f(iterable, this.zzg);
    }

    final /* synthetic */ void L(Iterable iterable) {
        zzbea zzbeaVar = this.zzh;
        if (!zzbeaVar.zza()) {
            this.zzh = zzbdq.t(zzbeaVar);
        }
        zzbby.f(iterable, this.zzh);
    }

    final /* synthetic */ void M(Iterable iterable) {
        zzbea zzbeaVar = this.zzi;
        if (!zzbeaVar.zza()) {
            this.zzi = zzbdq.t(zzbeaVar);
        }
        zzbby.f(iterable, this.zzi);
    }

    final /* synthetic */ void N(Iterable iterable) {
        zzbea zzbeaVar = this.zzj;
        if (!zzbeaVar.zza()) {
            this.zzj = zzbdq.t(zzbeaVar);
        }
        zzbby.f(iterable, this.zzj);
    }

    final /* synthetic */ void O(int i3) {
        this.zzk = i3;
    }

    final /* synthetic */ void P(zzbbh zzbbhVar) {
        zzbbhVar.getClass();
        this.zzl = zzbbhVar;
        this.zzb |= 1;
    }

    final /* synthetic */ void Q(zzbay zzbayVar) {
        zzbayVar.getClass();
        this.zzn = zzbayVar;
        this.zzb |= 2;
    }

    final /* synthetic */ void S(int i3) {
        this.zzm = i3 - 2;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzt, "\u0000\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0005\u0000\u0001Ȉ\u0002Ȉ\u0003Ț\u0004Ț\u0005Ț\u0006Ț\u0007\u0004\bဉ\u0000\t\f\nဉ\u0001\u000b\u0007\f\u0000\r,\u000e\u0007\u000f\u0007", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs"});
        }
        if (i4 == 3) {
            return new zzbbi();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbbd(bArr);
        }
        if (i4 == 5) {
            return zzt;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzu;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbbi.class) {
            try {
                zzbdlVar = zzu;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzt);
                    zzu = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
