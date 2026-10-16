package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.internal.p002firebaseauthapi.zzks;
import com.google.android.gms.internal.p002firebaseauthapi.zzkt;
import com.google.android.gms.internal.p002firebaseauthapi.zzlh;
import com.google.android.gms.internal.p002firebaseauthapi.zzmy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzq {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static zzq f87994c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f87995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzmy f87996b;

    public zzq(Context context, String str, boolean z2) {
        zzmy zzmyVarZza;
        this.f87995a = str;
        try {
            zzkt.zza();
            zzmy.zza zzaVarZza = new zzmy.zza().zza(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", str)).zza(zzlh.zza);
            zzaVarZza.zza(String.format("android-keystore://firebear_master_key_id.%s", str));
            zzmyVarZza = zzaVarZza.zza();
        } catch (IOException | GeneralSecurityException e3) {
            Log.e("FirebearCryptoHelper", "Exception encountered during crypto setup:\n" + e3.getMessage());
            zzmyVarZza = null;
        }
        this.f87996b = zzmyVarZza;
    }

    public static zzq a(Context context, String str) {
        zzq zzqVar = f87994c;
        if (zzqVar == null || !Objects.equals(zzqVar.f87995a, str)) {
            f87994c = new zzq(context, str, true);
        }
        return f87994c;
    }

    public final String b() {
        if (this.f87996b == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to get Public key");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.google.android.gms.internal.p002firebaseauthapi.zzby zzbyVarZza = com.google.android.gms.internal.p002firebaseauthapi.zzbc.zza(byteArrayOutputStream);
        try {
            synchronized (this.f87996b) {
                this.f87996b.zza().zzb().zza(zzbyVarZza);
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e3) {
            Log.e("FirebearCryptoHelper", "Exception encountered when attempting to get Public Key:\n" + e3.getMessage());
            return null;
        }
    }

    public final String c(String str) {
        String str2;
        zzmy zzmyVar = this.f87996b;
        if (zzmyVar == null) {
            Log.e("FirebearCryptoHelper", "KeysetManager failed to initialize - unable to decrypt payload");
            return null;
        }
        try {
            synchronized (zzmyVar) {
                str2 = new String(((com.google.android.gms.internal.p002firebaseauthapi.zzbd) this.f87996b.zza().zza(zzks.zza(), com.google.android.gms.internal.p002firebaseauthapi.zzbd.class)).zza(Base64.decode(str, 8), null), Utf8Charset.NAME);
            }
            return str2;
        } catch (UnsupportedEncodingException | GeneralSecurityException e3) {
            Log.e("FirebearCryptoHelper", "Exception encountered while decrypting bytes:\n" + e3.getMessage());
            return null;
        }
    }
}
