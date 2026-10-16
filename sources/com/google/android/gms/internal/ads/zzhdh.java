package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhdh extends zziee implements zzifq {
    private static final zzhdh zzb;
    private static volatile zzifx zzc;
    private zzieq zza = zziee.zzbM();

    static {
        zzhdh zzhdhVar = new zzhdh();
        zzb = zzhdhVar;
        zziee.zzbu(zzhdh.class, zzhdhVar);
    }

    private zzhdh() {
    }

    public static zzhde zzb() {
        return (zzhde) zzb.zzbn();
    }

    public final int zza() {
        return this.zza.size();
    }

    final /* synthetic */ void zzc(zzhdg zzhdgVar) {
        zzhdgVar.getClass();
        zzieq zzieqVar = this.zza;
        if (!zzieqVar.zza()) {
            this.zza = zziee.zzbN(zzieqVar);
        }
        this.zza.add(zzhdgVar);
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zziee.zzbv(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzhdg.class});
        }
        if (iOrdinal == 3) {
            return new zzhdh();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhde(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzc;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzhdh.class) {
            try {
                zzidzVar = zzc;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzb);
                    zzc = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }
}
