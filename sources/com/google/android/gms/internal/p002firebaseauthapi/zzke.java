package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzkb;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzke extends zzlj {
    private final zzkh zza;

    @Nullable
    private final zzaam zzb;

    @Nullable
    private final zzaal zzc;

    private zzke(zzkh zzkhVar, @Nullable zzaam zzaamVar, @Nullable zzaal zzaalVar) {
        this.zza = zzkhVar;
        this.zzb = zzaamVar;
        this.zzc = zzaalVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlj, com.google.android.gms.internal.p002firebaseauthapi.zzbi
    public final /* synthetic */ zzcb zza() {
        return (zzkb) zza();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlj, com.google.android.gms.internal.p002firebaseauthapi.zzce
    public final /* synthetic */ zzbi zzc() {
        return (zzkh) zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlj
    /* JADX INFO: renamed from: zzd */
    public final /* synthetic */ zzlg zza() {
        return (zzkb) ((zzlg) this.zza.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlj
    /* JADX INFO: renamed from: zze */
    public final /* synthetic */ zzli zzc() {
        return this.zza;
    }

    @Nullable
    public final zzaam zzf() {
        return this.zzb;
    }

    @Nullable
    public final zzaal zzg() {
        return this.zzc;
    }

    public static zzke zza(zzkh zzkhVar, zzaal zzaalVar) throws GeneralSecurityException {
        if (zzkhVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
        }
        if (zzkhVar.zze() == null) {
            throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
        }
        if (zzaalVar == null) {
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
        byte[] bArrZza = zzaalVar.zza(zzbf.zza());
        byte[] bArrZzb = zzkhVar.zze().zzb();
        if (bArrZza.length != 32) {
            throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
        }
        if (Arrays.equals(zzaah.zza(bArrZza), bArrZzb)) {
            return new zzke(zzkhVar, null, zzaalVar);
        }
        throw new GeneralSecurityException("Invalid private key for public key.");
    }

    public static zzke zza(zzkh zzkhVar, zzaam zzaamVar) throws GeneralSecurityException {
        if (zzkhVar != null) {
            if (zzkhVar.zzf() == null) {
                throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
            }
            if (zzaamVar != null) {
                BigInteger bigIntegerZza = zzaamVar.zza(zzbf.zza());
                ECPoint eCPointZzf = zzkhVar.zzf();
                zzkb.zzc zzcVarZzd = ((zzkb) ((zzlg) zzkhVar.zza())).zzd();
                BigInteger order = zza(zzcVarZzd).getOrder();
                if (bigIntegerZza.signum() > 0 && bigIntegerZza.compareTo(order) < 0) {
                    if (zznj.zza(bigIntegerZza, zza(zzcVarZzd)).equals(eCPointZzf)) {
                        return new zzke(zzkhVar, zzaamVar, null);
                    }
                    throw new GeneralSecurityException("Invalid private value");
                }
                throw new GeneralSecurityException("Invalid private value");
            }
            throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
        }
        throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
    }

    private static ECParameterSpec zza(zzkb.zzc zzcVar) {
        if (zzcVar == zzkb.zzc.zza) {
            return zznj.zza;
        }
        if (zzcVar == zzkb.zzc.zzb) {
            return zznj.zzb;
        }
        if (zzcVar == zzkb.zzc.zzc) {
            return zznj.zzc;
        }
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zzcVar));
    }
}
