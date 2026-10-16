package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhxt implements zzhek {
    static final zzhli zza;
    static final zzhli zzb;
    static final zzhli zzc;
    public static final /* synthetic */ int zzd = 0;
    private static final byte[] zze = new byte[0];
    private static final byte[] zzf = {0};
    private final ECPublicKey zzg;
    private final String zzh;
    private final zzhzs zzi;
    private final byte[] zzj;
    private final byte[] zzk;

    @Nullable
    private final Provider zzl;

    static {
        zzhlh zzhlhVarZza = zzhli.zza();
        zzhlhVarZza.zza(zziai.SHA256, zzhur.zza);
        zzhlhVarZza.zza(zziai.SHA384, zzhur.zzb);
        zzhlhVarZza.zza(zziai.SHA512, zzhur.zzc);
        zza = zzhlhVarZza.zzb();
        zzhlh zzhlhVarZza2 = zzhli.zza();
        zzhlhVarZza2.zza(zzhzs.IEEE_P1363, zzhus.zza);
        zzhlhVarZza2.zza(zzhzs.DER, zzhus.zzb);
        zzb = zzhlhVarZza2.zzb();
        zzhlh zzhlhVarZza3 = zzhli.zza();
        zzhlhVarZza3.zza(zzhzr.NIST_P256, zzhuq.zza);
        zzhlhVarZza3.zza(zzhzr.NIST_P384, zzhuq.zzb);
        zzhlhVarZza3.zza(zzhzr.NIST_P521, zzhuq.zzc);
        zzc = zzhlhVarZza3.zzb();
    }

    private zzhxt(ECPublicKey eCPublicKey, zziai zziaiVar, zzhzs zzhzsVar, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!zzhkr.zza(2)) {
            throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
        }
        this.zzh = zziaw.zza(zziaiVar);
        this.zzg = eCPublicKey;
        this.zzi = zzhzsVar;
        this.zzj = bArr;
        this.zzk = bArr2;
        this.zzl = provider;
    }

    public static zzhek zzb(zzhuy zzhuyVar, @Nullable Provider provider) throws GeneralSecurityException {
        return new zzhxt((ECPublicKey) (provider != null ? KeyFactory.getInstance("EC", provider) : (KeyFactory) zzhzz.zzf.zzb("EC")).generatePublic(new ECPublicKeySpec(zzhuyVar.zzd(), zzhzt.zzb((zzhzr) zzc.zzb(zzhuyVar.zzf().zzd())))), (zziai) zza.zzb(zzhuyVar.zzf().zze()), (zzhzs) zzb.zzb(zzhuyVar.zzf().zzc()), zzhuyVar.zze().zzc(), zzhuyVar.zzf().zzf().equals(zzhut.zzc) ? zzf : zze, provider);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzc(byte[] r12, byte[] r13) throws java.security.GeneralSecurityException {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhxt.zzc(byte[], byte[]):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhek
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzj;
        int length = bArr3.length;
        if (length == 0) {
            zzc(bArr, bArr2);
        } else {
            if (!zzhnz.zze(bArr3, bArr)) {
                throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
            }
            zzc(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        }
    }
}
