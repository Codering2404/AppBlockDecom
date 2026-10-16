package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcx implements zzpz<zzba, zzba> {
    private static final zzcx zza = new zzcx();
    private static final zzps<zzof, zzba> zzb = zzps.zza(new zzpu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzda
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpu
        public final Object zza(zzbi zzbiVar) {
            return zzia.zza((zzof) zzbiVar);
        }
    }, zzof.class, zzba.class);

    zzcx() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzpa.zza().zza(zza);
        zzpa.zza().zza(zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
    public final Class<zzba> zza() {
        return zzba.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
    public final Class<zzba> zzb() {
        return zzba.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
    public final /* synthetic */ zzba zza(zzob zzobVar, zzok zzokVar, zzqc<zzba> zzqcVar) throws GeneralSecurityException {
        zzoo zzooVar;
        zzoo zzooVarZza;
        zzaaj zzaajVarZzc;
        zzpn zzpnVar = new zzpn();
        for (int i3 = 0; i3 < zzobVar.zza(); i3++) {
            zzoa zzoaVarZza = zzobVar.zza(i3);
            if (zzoaVarZza.zzc().equals(zzbk.zza)) {
                zzbi zzbiVarZzb = zzoaVarZza.zzb();
                if (zzbiVarZzb instanceof zzcw) {
                    zzaajVarZzc = ((zzcw) zzbiVarZzb).zzd();
                } else {
                    if (!(zzbiVarZzb instanceof zzof)) {
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzbiVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzbiVarZzb.zza()));
                    }
                    zzaajVarZzc = ((zzof) zzbiVarZzb).zzc();
                }
                zzpnVar.zza(zzaajVarZzc, new zzcz(zzqcVar.zza(zzoaVarZza), zzoaVarZza.zza()));
            }
        }
        if (zzokVar.zza()) {
            zzooVar = zzon.zza;
            zzooVarZza = zzooVar;
        } else {
            zzol zzolVarZza = zzow.zzb().zza();
            zzoo zzooVarZza2 = zzolVarZza.zza(zzobVar, zzokVar, "aead", "encrypt");
            zzooVarZza = zzolVarZza.zza(zzobVar, zzokVar, "aead", "decrypt");
            zzooVar = zzooVarZza2;
        }
        return new zzdc(new zzcz(zzqcVar.zza(zzobVar.zzc()), zzobVar.zzc().zza()), zzpnVar.zza(), zzooVar, zzooVarZza);
    }

    public static void zza(zzpy zzpyVar) throws GeneralSecurityException {
        zzpyVar.zza(zza);
    }
}
