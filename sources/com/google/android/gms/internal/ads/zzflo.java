package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzflo {
    public zzflo() {
        try {
            zzhep.zza();
        } catch (GeneralSecurityException e3) {
            com.google.android.gms.ads.internal.util.zze.k("Failed to Configure Aead. ".concat(e3.toString()));
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        byte[] byteArray;
        try {
            zzheb zzhebVarZzg = zzheb.zzg(zzhdt.zzb(zzhmn.zza().zzc("AES128_GCM")));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzhdm.zzb(zzhebVarZzg, zzhdl.zzb(byteArrayOutputStream));
                byteArray = byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                throw new GeneralSecurityException("Serialize keyset failed");
            }
        } catch (GeneralSecurityException e3) {
            com.google.android.gms.ads.internal.util.zze.k("Failed to generate key".concat(e3.toString()));
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "CryptoUtils.generateKey");
            byteArray = new byte[0];
        }
        return Base64.encodeToString(byteArray, 11);
    }

    @Nullable
    public static final String zzb(byte[] bArr, byte[] bArr2, @Nullable String str, zzdzg zzdzgVar) {
        zzheb zzhebVarZzc;
        if (str != null && (zzhebVarZzc = zzc(str)) != null) {
            try {
                byte[] bArrZza = ((zzhdi) zzhebVarZzc.zzh(zzhkt.zza(), zzhdi.class)).zza(bArr, bArr2);
                zzdzgVar.zzc().put("ds", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                return new String(bArrZza, StandardCharsets.UTF_8);
            } catch (UnsupportedOperationException | GeneralSecurityException e3) {
                com.google.android.gms.ads.internal.util.zze.k("Failed to decrypt ".concat(e3.toString()));
                com.google.android.gms.ads.internal.zzt.l().zzg(e3, "CryptoUtils.decrypt");
                zzdzgVar.zzc().put("dsf", e3.toString());
            }
        }
        return null;
    }

    @Nullable
    private static final zzheb zzc(String str) {
        try {
            try {
                return zzhdm.zza(zzhdk.zza(Base64.decode(str, 11)));
            } catch (IOException unused) {
                throw new GeneralSecurityException("Parse keyset failed");
            }
        } catch (GeneralSecurityException e3) {
            com.google.android.gms.ads.internal.util.zze.k("Failed to get keysethandle".concat(e3.toString()));
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "CryptoUtils.getHandle");
            return null;
        }
    }
}
