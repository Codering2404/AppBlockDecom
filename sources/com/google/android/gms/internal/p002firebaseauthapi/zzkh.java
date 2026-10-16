package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.google.android.gms.internal.p002firebaseauthapi.zzkb;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkh extends zzli {
    private final zzkb zza;

    @Nullable
    private final ECPoint zzb;

    @Nullable
    private final zzaaj zzc;
    private final zzaaj zzd;

    @Nullable
    private final Integer zze;

    private zzkh(zzkb zzkbVar, @Nullable ECPoint eCPoint, @Nullable zzaaj zzaajVar, zzaaj zzaajVar2, @Nullable Integer num) {
        this.zza = zzkbVar;
        this.zzb = eCPoint;
        this.zzc = zzaajVar;
        this.zzd = zzaajVar2;
        this.zze = num;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzli, com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final /* synthetic */ zzcb zza() {
        return (zzkb) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbi
    @Nullable
    public final Integer zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzli
    /* JADX INFO: renamed from: zzc */
    public final /* synthetic */ zzlg zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzli
    public final zzaaj zzd() {
        return this.zzd;
    }

    @Nullable
    public final zzaaj zze() {
        return this.zzc;
    }

    @Nullable
    public final ECPoint zzf() {
        return this.zzb;
    }

    public static zzkh zza(zzkb zzkbVar, zzaaj zzaajVar, @Nullable Integer num) throws GeneralSecurityException {
        if (!zzkbVar.zzd().equals(zzkb.zzc.zzd)) {
            throw new GeneralSecurityException("createForCurveX25519 may only be called with parameters for curve X25519");
        }
        zzb(zzkbVar.zzg(), num);
        if (zzaajVar.zza() == 32) {
            return new zzkh(zzkbVar, null, zzaajVar, zza(zzkbVar.zzg(), num), num);
        }
        throw new GeneralSecurityException("Encoded public point byte length for X25519 curve must be 32");
    }

    private static void zzb(zzkb.zzd zzdVar, @Nullable Integer num) throws GeneralSecurityException {
        zzkb.zzd zzdVar2 = zzkb.zzd.zzc;
        if (zzdVar.equals(zzdVar2) || num != null) {
            if (zzdVar.equals(zzdVar2) && num != null) {
                throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
            }
        } else {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzdVar) + " variant.");
        }
    }

    public static zzkh zza(zzkb zzkbVar, ECPoint eCPoint, @Nullable Integer num) throws GeneralSecurityException {
        EllipticCurve curve;
        if (!zzkbVar.zzd().equals(zzkb.zzc.zzd)) {
            zzb(zzkbVar.zzg(), num);
            zzkb.zzc zzcVarZzd = zzkbVar.zzd();
            if (zzcVarZzd == zzkb.zzc.zza) {
                curve = zznj.zza.getCurve();
            } else if (zzcVarZzd == zzkb.zzc.zzb) {
                curve = zznj.zzb.getCurve();
            } else if (zzcVarZzd == zzkb.zzc.zzc) {
                curve = zznj.zzc.getCurve();
            } else {
                throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzcVarZzd));
            }
            zznj.zza(eCPoint, curve);
            return new zzkh(zzkbVar, eCPoint, null, zza(zzkbVar.zzg(), num), num);
        }
        throw new GeneralSecurityException("createForNistCurve may only be called with parameters for NIST curve");
    }

    private static zzaaj zza(zzkb.zzd zzdVar, @Nullable Integer num) {
        if (zzdVar == zzkb.zzd.zzc) {
            return zzpe.zza;
        }
        if (num != null) {
            if (zzdVar == zzkb.zzd.zzb) {
                return zzpe.zza(num.intValue());
            }
            if (zzdVar == zzkb.zzd.zza) {
                return zzpe.zzb(num.intValue());
            }
            throw new IllegalStateException(QaXmqxvjHhxVy.gSgpgKwPiwIBkA + String.valueOf(zzdVar));
        }
        throw new IllegalStateException("idRequirement must be non-null for EciesParameters.Variant: " + String.valueOf(zzdVar));
    }
}
