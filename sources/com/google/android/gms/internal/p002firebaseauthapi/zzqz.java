package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqz implements zzpz<zzqw, zzqw> {
    private static final zzqz zza = new zzqz();

    private zzqz() {
    }

    static void zzc() throws GeneralSecurityException {
        zzpa.zza().zza(zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
    public final Class<zzqw> zza() {
        return zzqw.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
    public final Class<zzqw> zzb() {
        return zzqw.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
    public final /* synthetic */ zzqw zza(zzob zzobVar, zzok zzokVar, zzqc<zzqw> zzqcVar) throws GeneralSecurityException {
        zzaaj zzaajVarZzc;
        zzoa zzoaVarZzc = zzobVar.zzc();
        if (zzoaVarZzc == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        zzpn zzpnVar = new zzpn();
        for (int i3 = 0; i3 < zzobVar.zza(); i3++) {
            zzoa zzoaVarZza = zzobVar.zza(i3);
            if (zzoaVarZza.zzc().equals(zzbk.zza)) {
                zzqw zzqwVarZza = zzqcVar.zza(zzoaVarZza);
                zzbi zzbiVarZzb = zzoaVarZza.zzb();
                if (zzbiVarZzb instanceof zzrk) {
                    zzaajVarZzc = ((zzrk) zzbiVarZzb).zze();
                } else {
                    if (!(zzbiVarZzb instanceof zzof)) {
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzbiVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzbiVarZzb.zza()));
                    }
                    zzaajVarZzc = ((zzof) zzbiVarZzb).zzc();
                }
                zzpnVar.zza(zzaajVarZzc, zzqwVarZza);
            }
        }
        return new zzqy(zzpnVar.zza(), zzqcVar.zza(zzoaVarZzc));
    }
}
