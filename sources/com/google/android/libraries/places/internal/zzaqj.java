package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaqj extends zzbdq implements zzbey {
    private static final zzaqj zzn;
    private static volatile zzbff zzo;
    private int zzb;
    private int zze;
    private zzbea zzf = zzbdq.s();
    private zzbea zzg = zzbdq.s();
    private zzbea zzh = zzbdq.s();
    private zzbea zzi = zzbdq.s();
    private int zzj;
    private zzapp zzk;
    private zzaqu zzl;
    private boolean zzm;

    static {
        zzaqj zzaqjVar = new zzaqj();
        zzn = zzaqjVar;
        zzbdq.D(zzaqj.class, zzaqjVar);
    }

    private zzaqj() {
    }

    public static zzaqh G() {
        return (zzaqh) zzn.A();
    }

    final /* synthetic */ void H(Iterable iterable) {
        zzbea zzbeaVar = this.zzf;
        if (!zzbeaVar.zza()) {
            this.zzf = zzbdq.t(zzbeaVar);
        }
        zzbby.f(iterable, this.zzf);
    }

    final /* synthetic */ void I(Iterable iterable) {
        zzbea zzbeaVar = this.zzg;
        if (!zzbeaVar.zza()) {
            this.zzg = zzbdq.t(zzbeaVar);
        }
        zzbby.f(iterable, this.zzg);
    }

    final /* synthetic */ void J(Iterable iterable) {
        zzbea zzbeaVar = this.zzh;
        if (!zzbeaVar.zza()) {
            this.zzh = zzbdq.t(zzbeaVar);
        }
        zzbby.f(iterable, this.zzh);
    }

    final /* synthetic */ void K(Iterable iterable) {
        zzbea zzbeaVar = this.zzi;
        if (!zzbeaVar.zza()) {
            this.zzi = zzbdq.t(zzbeaVar);
        }
        zzbby.f(iterable, this.zzi);
    }

    final /* synthetic */ void L(int i3) {
        this.zzb |= 2;
        this.zzj = i3;
    }

    final /* synthetic */ void M(zzapp zzappVar) {
        zzappVar.getClass();
        this.zzk = zzappVar;
        this.zzb |= 4;
    }

    final /* synthetic */ void N(zzaqu zzaquVar) {
        zzaquVar.getClass();
        this.zzl = zzaquVar;
        this.zzb |= 8;
    }

    final /* synthetic */ void O(boolean z2) {
        this.zzb |= 16;
        this.zzm = z2;
    }

    final /* synthetic */ void Q(int i3) {
        this.zze = i3 - 1;
        this.zzb |= 1;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001᠌\u0000\u0002\u001a\u0003\u001a\u0004\u001a\u0005\u001a\u0006င\u0001\u0007ဉ\u0002\bဉ\u0003\tဇ\u0004", new Object[]{"zzb", "zze", zzaqi.f75778a, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i4 == 3) {
            return new zzaqj();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaqh(bArr);
        }
        if (i4 == 5) {
            return zzn;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzo;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaqj.class) {
            try {
                zzbdlVar = zzo;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzn);
                    zzo = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
