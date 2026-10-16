package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfqq extends zziee implements zzifq {
    private static final zzfqq zzd;
    private static volatile zzifx zze;
    private int zza;
    private zzieq zzb = zziee.zzbM();
    private zzihr zzc;

    static {
        zzfqq zzfqqVar = new zzfqq();
        zzd = zzfqqVar;
        zziee.zzbu(zzfqq.class, zzfqqVar);
    }

    private zzfqq() {
    }

    public static zzfqn zzb() {
        return (zzfqn) zzd.zzbn();
    }

    public final int zza() {
        return this.zzb.size();
    }

    final /* synthetic */ void zzc(zzfqp zzfqpVar) {
        zzfqpVar.getClass();
        zzieq zzieqVar = this.zzb;
        if (!zzieqVar.zza()) {
            this.zzb = zziee.zzbN(zzieqVar);
        }
        this.zzb.add(zzfqpVar);
    }

    final /* synthetic */ void zzd() {
        this.zzb = zziee.zzbM();
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zza", "zzb", zzfqp.class, "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzfqq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfqn(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zze;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzfqq.class) {
            try {
                zzidzVar = zze;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzd);
                    zze = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
