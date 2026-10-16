package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzawm extends zzbdq implements zzbey {
    private static final zzawm zzr;
    private static volatile zzbff zzs;
    private int zzb;
    private zzawj zzf;
    private zzawl zzg;
    private zzbht zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzp;
    private boolean zzq;
    private String zze = "";
    private zzbea zzh = zzbdq.s();
    private zzbea zzi = zzbdq.s();
    private String zzj = "";
    private String zzk = "";
    private String zzo = "";

    static {
        zzawm zzawmVar = new zzawm();
        zzr = zzawmVar;
        zzbdq.D(zzawm.class, zzawmVar);
    }

    private zzawm() {
    }

    public static zzawh G() {
        return (zzawh) zzr.A();
    }

    public static zzawm H() {
        return zzr;
    }

    final /* synthetic */ void I(String str) {
        str.getClass();
        this.zze = str;
    }

    final /* synthetic */ void J(zzawj zzawjVar) {
        zzawjVar.getClass();
        this.zzf = zzawjVar;
        this.zzb |= 1;
    }

    final /* synthetic */ void K(zzawl zzawlVar) {
        zzawlVar.getClass();
        this.zzg = zzawlVar;
        this.zzb |= 2;
    }

    final /* synthetic */ void L(String str) {
        str.getClass();
        zzbea zzbeaVar = this.zzh;
        if (!zzbeaVar.zza()) {
            this.zzh = zzbdq.t(zzbeaVar);
        }
        this.zzh.add(str);
    }

    final /* synthetic */ void M(String str) {
        str.getClass();
        zzbea zzbeaVar = this.zzi;
        if (!zzbeaVar.zza()) {
            this.zzi = zzbdq.t(zzbeaVar);
        }
        this.zzi.add(str);
    }

    final /* synthetic */ void N(String str) {
        str.getClass();
        this.zzj = str;
    }

    final /* synthetic */ void O(String str) {
        this.zzk = str;
    }

    final /* synthetic */ void P(zzbht zzbhtVar) {
        zzbhtVar.getClass();
        this.zzl = zzbhtVar;
        this.zzb |= 4;
    }

    final /* synthetic */ void Q(int i3) {
        this.zzm = i3;
    }

    final /* synthetic */ void R(String str) {
        str.getClass();
        this.zzo = str;
    }

    final /* synthetic */ void S(boolean z2) {
        this.zzp = true;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzr, "\u0000\r\u0000\u0001\u0001\r\r\u0000\u0002\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004Ț\u0005Ț\u0006Ȉ\u0007Ȉ\bဉ\u0002\t\u0004\n\u0007\u000bȈ\f\u0007\r\u0007", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq"});
        }
        if (i4 == 3) {
            return new zzawm();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzawh(bArr);
        }
        if (i4 == 5) {
            return zzr;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzs;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzawm.class) {
            try {
                zzbdlVar = zzs;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzr);
                    zzs = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
