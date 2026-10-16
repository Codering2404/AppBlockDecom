package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzif extends zzqm implements zzrr {
    private static final zzif zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private long zzg;
    private int zzh;

    static {
        zzif zzifVar = new zzif();
        zzb = zzifVar;
        zzqm.zzz(zzif.class, zzifVar);
    }

    private zzif() {
    }

    public static zzid zza() {
        return (zzid) zzb.zzp();
    }

    static /* synthetic */ void zzd(zzif zzifVar, zzhc zzhcVar) {
        zzhcVar.getClass();
        zzifVar.zzf = zzhcVar;
        zzifVar.zze = 38;
    }

    static /* synthetic */ void zze(zzif zzifVar, long j3) {
        zzifVar.zzd |= 1;
        zzifVar.zzg = j3;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzqm
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzqm.zzw(zzb, "\u0004\u0019\u0001\u0001\b&\u0019\u0000\u0000\u0000\b<\u0000\tဂ\u0000\u000b<\u0000\f<\u0000\r<\u0000\u000f<\u0000\u0011<\u0000\u0012<\u0000\u0013<\u0000\u0014<\u0000\u0015<\u0000\u0016<\u0000\u0019<\u0000\u001a<\u0000\u001b<\u0000\u001dင\u0001\u001e<\u0000\u001f<\u0000 <\u0000!<\u0000\"<\u0000#<\u0000$<\u0000%<\u0000&<\u0000", new Object[]{"zzf", "zze", "zzd", zzla.class, "zzg", zzlz.class, zziw.class, zzfa.class, zzkc.class, zzfo.class, zzic.class, zzfh.class, zzgg.class, zzjf.class, zzjo.class, zznp.class, zzlo.class, zzok.class, "zzh", zzoh.class, zzme.class, zzgr.class, zznb.class, zzmx.class, zzfr.class, zzoo.class, zznu.class, zzhc.class});
        }
        if (i4 == 3) {
            return new zzif();
        }
        zzie zzieVar = null;
        if (i4 == 4) {
            return new zzid(zzieVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
