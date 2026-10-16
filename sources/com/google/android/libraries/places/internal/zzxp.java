package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzxp extends zzbdq implements zzbey {
    private static final zzxp zzN;
    private static volatile zzbff zzO;
    private zzag zzA;
    private zzcr zzB;
    private zzbj zzC;
    private zzahy zzD;
    private zzca zzE;
    private zzch zzF;
    private zzash zzG;
    private zzacv zzH;
    private zzary zzI;
    private zzaru zzJ;
    private zzar zzK;
    private zzxr zzL;
    private int zzb;
    private int zze;
    private zzaoj zzg;
    private zzaae zzh;
    private zzasj zzi;
    private zzakb zzj;
    private zzafl zzk;
    private zzbs zzl;
    private zzzz zzm;
    private zzzh zzn;
    private zzact zzo;
    private zzahh zzp;
    private zzaib zzq;
    private zzaid zzr;
    private zzyi zzs;
    private zzadn zzt;
    private zzf zzu;
    private zzan zzv;
    private zzax zzw;
    private zzdf zzx;
    private zzaz zzy;
    private zzbe zzz;
    private byte zzM = 2;
    private int zzf = 1;

    static {
        zzxp zzxpVar = new zzxp();
        zzN = zzxpVar;
        zzbdq.D(zzxp.class, zzxpVar);
    }

    private zzxp() {
    }

    public static zzxn G() {
        return (zzxn) zzN.A();
    }

    final /* synthetic */ void H(zzaoj zzaojVar) {
        zzaojVar.getClass();
        this.zzg = zzaojVar;
        this.zzb |= 2;
    }

    final /* synthetic */ void J(int i3) {
        this.zzf = 1;
        this.zzb = 1 | this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzM);
        }
        if (i4 == 2) {
            return zzbdq.m(zzN, "\u0001!\u0000\u0002\u0001\"!\u0000\u0000\u0002\u0001᠌\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဉ\b\nဉ\t\u000bဉ\n\fဉ\u000b\rဉ\f\u000fဉ\r\u0010ဉ\u000e\u0011ဉ\u000f\u0012ဉ\u0010\u0013ဉ\u0011\u0014ဉ\u0012\u0015ဉ\u0013\u0016ဉ\u0014\u0017ဉ\u0015\u0018ဉ\u0016\u0019ဉ\u0017\u001aဉ\u0018\u001bဉ\u0019\u001cဉ\u001a\u001dဉ\u001b\u001eဉ\u001c\u001fဉ\u001d ဉ\u001e!ဉ\u001f\"ဉ ", new Object[]{"zzb", "zze", "zzf", zzxo.f78836a, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK", "zzL"});
        }
        if (i4 == 3) {
            return new zzxp();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzxn(bArr);
        }
        if (i4 == 5) {
            return zzN;
        }
        if (i4 != 6) {
            this.zzM = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzbff zzbffVar = zzO;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzxp.class) {
            try {
                zzbdlVar = zzO;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzN);
                    zzO = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
