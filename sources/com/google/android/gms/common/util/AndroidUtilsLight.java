package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.google.android.gms.common.wrappers.Wrappers;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AndroidUtilsLight {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f72266a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f72267b = 0;

    public static byte[] a(Context context, String str) {
        MessageDigest messageDigestB;
        PackageInfo packageInfoF = Wrappers.a(context).f(str, 64);
        Signature[] signatureArr = packageInfoF.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (messageDigestB = b("SHA1")) == null) {
            return null;
        }
        return messageDigestB.digest(packageInfoF.signatures[0].toByteArray());
    }

    public static MessageDigest b(String str) {
        MessageDigest messageDigest;
        for (int i3 = 0; i3 < 2; i3++) {
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }
}
