package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzcl;
import com.google.android.gms.internal.p002firebaseauthapi.zzco;
import com.google.android.gms.internal.p002firebaseauthapi.zzcv;
import com.google.android.gms.internal.p002firebaseauthapi.zzmy;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzby {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static zzby f87945c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f87946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzmy f87947b;

    public zzby(String str, zzmy zzmyVar) {
        this.f87946a = str;
        this.f87947b = zzmyVar;
    }

    public static zzby a(Context context, String str) {
        zzby zzbyVar = f87945c;
        if (zzbyVar == null || !Objects.equals(zzbyVar.f87946a, str)) {
            f87945c = new zzby(str, e(context, str));
        }
        return f87945c;
    }

    public static zzmy c(Context context, String str) {
        return new zzmy.zza().zza(context, "StorageCryptoKeyset", f(str)).zza(zzcv.zzb).zza(String.format("android-keystore://firebear_main_key_id_for_storage_crypto.%s", str)).zza();
    }

    public static zzmy e(Context context, String str) {
        try {
            zzcl.zza();
            return c(context, str);
        } catch (IOException | GeneralSecurityException e3) {
            Log.e("FirebearStorageCryptoHelper", "Exception encountered during crypto setup:\n" + e3.getMessage());
            if (e3 instanceof GeneralSecurityException) {
                context.getSharedPreferences(f(str), 0).edit().remove("StorageCryptoKeyset").apply();
                try {
                    return c(context, str);
                } catch (IOException | GeneralSecurityException e4) {
                    Log.e("FirebearStorageCryptoHelper", "Exception encountered during second attempt to crypto setup:\n" + e4.getMessage());
                    return null;
                }
            }
            return null;
        }
    }

    public static String f(String str) {
        return String.format("com.google.firebase.auth.api.crypto.%s", str);
    }

    public final String b(String str) {
        String str2;
        Preconditions.m(str);
        zzmy zzmyVar = this.f87947b;
        if (zzmyVar == null) {
            Log.e("FirebearStorageCryptoHelper", "KeysetManager failed to initialize - unable to decrypt data");
            return null;
        }
        try {
            synchronized (zzmyVar) {
                str2 = new String(((com.google.android.gms.internal.p002firebaseauthapi.zzba) this.f87947b.zza().zza(zzco.zza(), com.google.android.gms.internal.p002firebaseauthapi.zzba.class)).zza(Base64.decode(str, 2), null), StandardCharsets.UTF_8);
            }
            return str2;
        } catch (IllegalArgumentException | GeneralSecurityException e3) {
            Log.e("FirebearStorageCryptoHelper", "Exception encountered while decrypting bytes:\n" + e3.getMessage());
            return null;
        }
    }

    public final String d(String str) {
        String strEncodeToString;
        Preconditions.m(str);
        zzmy zzmyVar = this.f87947b;
        if (zzmyVar == null) {
            Log.e("FirebearStorageCryptoHelper", "KeysetManager failed to initialize - unable to encrypt data");
            return null;
        }
        try {
            synchronized (zzmyVar) {
                strEncodeToString = Base64.encodeToString(((com.google.android.gms.internal.p002firebaseauthapi.zzba) this.f87947b.zza().zza(zzco.zza(), com.google.android.gms.internal.p002firebaseauthapi.zzba.class)).zzb(str.getBytes(StandardCharsets.UTF_8), null), 2);
            }
            return strEncodeToString;
        } catch (GeneralSecurityException e3) {
            Log.e("FirebearStorageCryptoHelper", "Exception encountered while encrypting bytes:\n" + e3.getMessage());
            return null;
        }
    }
}
