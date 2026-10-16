package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaut extends zzbdq implements zzbey {
    private static final zzaut zzu;
    private static volatile zzbff zzv;
    private int zzb;
    private int zze;
    private zzaud zzf;
    private zzaud zzg;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private zzaud zzn;
    private zzauf zzo;
    private zzauj zzp;
    private int zzq;
    private int zzr;
    private zzauh zzs;
    private byte zzt = 2;
    private zzbea zzh = zzbdq.s();

    static {
        zzaut zzautVar = new zzaut();
        zzu = zzautVar;
        zzbdq.D(zzaut.class, zzautVar);
    }

    private zzaut() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzt);
        }
        if (i4 == 2) {
            return zzbdq.m(zzu, "\u0001\u000f\u0000\u0001\u0002\u0010\u000f\u0000\u0001\u0001\u0002ᔄ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005\u001b\u0006င\u0003\u0007င\u0004\bင\u0005\tင\u0006\nင\u0007\u000bဉ\b\fဉ\t\rဉ\n\u000eင\u000b\u000fင\f\u0010ဉ\r", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", zzaur.class, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs"});
        }
        if (i4 == 3) {
            return new zzaut();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaus(bArr);
        }
        if (i4 == 5) {
            return zzu;
        }
        if (i4 != 6) {
            this.zzt = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzbff zzbffVar = zzv;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaut.class) {
            try {
                zzbdlVar = zzv;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzu);
                    zzv = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
