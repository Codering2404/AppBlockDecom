package com.google.android.libraries.places.internal;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.common.io.BaseEncoding;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzmr {
    public static String a(PackageManager packageManager, String str) {
        Signature[] signatureArr;
        Signature signature;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0 && (signature = signatureArr[0]) != null) {
                return b(signature);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.e("CredentialsHelper", "Unable to get certificate fingerprint for package: ".concat(String.valueOf(str)), e3);
            return null;
        }
    }

    private static String b(Signature signature) {
        try {
            return BaseEncoding.a().g(MessageDigest.getInstance("SHA-1").digest(signature.toByteArray()));
        } catch (NoSuchAlgorithmException e3) {
            Log.e("CredentialsHelper", "Unable to get certificate fingerprint.", e3);
            return null;
        }
    }
}
