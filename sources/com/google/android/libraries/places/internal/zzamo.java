package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzamo extends zzbdq implements zzbey {
    private static final zzamo zzl;
    private static volatile zzbff zzm;
    private int zzb;
    private int zze;
    private boolean zzi;
    private int zzk;
    private zzbea zzf = zzbdq.s();
    private String zzg = "";
    private String zzh = "";
    private zzbea zzj = zzbdq.s();

    static {
        zzamo zzamoVar = new zzamo();
        zzl = zzamoVar;
        zzbdq.D(zzamo.class, zzamoVar);
    }

    private zzamo() {
    }

    public static zzamn G() {
        return (zzamn) zzl.A();
    }

    final /* synthetic */ void H(String str) {
        str.getClass();
        zzbea zzbeaVar = this.zzf;
        if (!zzbeaVar.zza()) {
            this.zzf = zzbdq.t(zzbeaVar);
        }
        this.zzf.add(str);
    }

    final /* synthetic */ void I(int i3) {
        this.zzb |= 16;
        this.zzk = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzl, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001င\u0000\u0002\u001a\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006\u001a\u0007င\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i4 == 3) {
            return new zzamo();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzamn(bArr);
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
        synchronized (zzamo.class) {
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
