package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzy {
    private final zzz zza;
    private final zzcn zzb;
    private final zzcr zzc;
    private int zzd = 0;
    private ConsentInformation.PrivacyOptionsRequirementStatus zze = ConsentInformation.PrivacyOptionsRequirementStatus.UNKNOWN;

    zzy(zzz zzzVar, zzcn zzcnVar, zzcr zzcrVar) {
        this.zza = zzzVar;
        this.zzb = zzcnVar;
        this.zzc = zzcrVar;
    }

    final zzab zza() throws zzg {
        String str;
        zzcn zzcnVar = this.zzb;
        int i3 = zzcnVar.zzg;
        boolean z2 = i3 == 8;
        zzz zzzVar = this.zza;
        zzzVar.zzc.zzh(z2);
        int i4 = i3 - 1;
        if (i3 == 0) {
            throw null;
        }
        switch (i4) {
            case 1:
            case 2:
            case 3:
                this.zzd = 3;
                break;
            case 4:
                this.zzd = 2;
                break;
            case 5:
                this.zzd = 1;
                break;
            case 6:
                throw new zzg(1, "Invalid response from server: ".concat(String.valueOf(zzcnVar.zzc)));
            case 7:
                throw new zzg(3, "Publisher misconfiguration: ".concat(String.valueOf(zzcnVar.zzc)));
            default:
                throw new zzg(1, "Invalid response from server.");
        }
        int i5 = zzcnVar.zzh;
        int i6 = i5 - 1;
        if (i5 == 0) {
            throw null;
        }
        if (i6 == 1) {
            this.zze = ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED;
        } else {
            if (i6 != 2) {
                throw new zzg(1, "Invalid response from server.");
            }
            this.zze = ConsentInformation.PrivacyOptionsRequirementStatus.NOT_REQUIRED;
        }
        String str2 = zzcnVar.zza;
        zzbs zzbsVar = str2 == null ? null : new zzbs(zzcnVar.zzb, str2);
        this.zzc.zzk(zzcnVar.zzf);
        zzzVar.zzc.zzj(new HashSet(zzcnVar.zzd));
        for (zzcm zzcmVar : zzcnVar.zze) {
            int i7 = zzcmVar.zzb;
            int i8 = i7 - 1;
            if (i7 == 0) {
                throw null;
            }
            if (i8 == 0) {
                str = null;
            } else if (i8 == 1) {
                str = "write";
            } else {
                if (i8 != 2) {
                    throw new RuntimeException(null, null);
                }
                str = "clear";
            }
            if (str != null) {
                zzzVar.zza.zzb(str, zzcmVar.zza, zzzVar.zzb);
            }
        }
        return new zzab(this.zzd, this.zze, zzbsVar, null);
    }
}
