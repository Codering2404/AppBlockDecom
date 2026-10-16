package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaze extends zzbdq implements zzbey {
    private static final zzaze zzh;
    private static volatile zzbff zzi;
    private int zzb;
    private zzazd zzf;
    private String zze = "";
    private String zzg = "";

    static {
        zzaze zzazeVar = new zzaze();
        zzh = zzazeVar;
        zzbdq.D(zzaze.class, zzazeVar);
    }

    private zzaze() {
    }

    public static zzaze K() {
        return zzh;
    }

    public final String G() {
        return this.zze;
    }

    public final boolean H() {
        return (this.zzb & 1) != 0;
    }

    public final zzazd I() {
        zzazd zzazdVar = this.zzf;
        return zzazdVar == null ? zzazd.J() : zzazdVar;
    }

    public final String J() {
        return this.zzg;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzh, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003Ȉ", new Object[]{"zzb", "zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzaze();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzayz(bArr);
        }
        if (i4 == 5) {
            return zzh;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzi;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaze.class) {
            try {
                zzbdlVar = zzi;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzh);
                    zzi = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
