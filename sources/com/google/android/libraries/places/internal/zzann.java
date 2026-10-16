package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzann extends zzbdq implements zzbey {
    private static final zzann zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private zzadi zzf;
    private zzamo zzg;
    private byte zzh = 2;
    private String zze = "";

    static {
        zzann zzannVar = new zzann();
        zzi = zzannVar;
        zzbdq.D(zzann.class, zzannVar);
    }

    private zzann() {
    }

    public static zzanm G() {
        return (zzanm) zzi.A();
    }

    final /* synthetic */ void H(zzamo zzamoVar) {
        this.zzg = zzamoVar;
        this.zzb |= 4;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᐉ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzann();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzanm(bArr);
        }
        if (i4 == 5) {
            return zzi;
        }
        if (i4 != 6) {
            this.zzh = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzbff zzbffVar = zzj;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzann.class) {
            try {
                zzbdlVar = zzj;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzi);
                    zzj = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
