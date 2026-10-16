package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Process;
import com.appsflyer.AFLogger;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFa1fSDK {
    public final String[] AFKeystoreWrapper;

    public AFa1fSDK() {
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.util.Map<java.lang.String, java.lang.String> AFInAppEventParameterName(android.content.Context r9, java.util.Map<java.lang.String, java.lang.String> r10, android.net.Uri r11) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1fSDK.AFInAppEventParameterName(android.content.Context, java.util.Map, android.net.Uri):java.util.Map");
    }

    public static boolean AFInAppEventType(Context context, String str) {
        int iCheckPermission = context.checkPermission(str, Process.myPid(), Process.myUid());
        StringBuilder sb = new StringBuilder("is Permission Available: ");
        sb.append(str);
        sb.append("; res: ");
        sb.append(iCheckPermission);
        AFLogger.afRDLog(sb.toString());
        return iCheckPermission == 0;
    }

    public static boolean AFKeystoreWrapper(Context context, Intent intent) {
        return context.getPackageManager().queryIntentServices(intent, 0).size() > 0;
    }

    public static boolean valueOf() {
        return Build.BRAND.equals("OPPO");
    }

    public AFa1fSDK(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            this.AFKeystoreWrapper = null;
            return;
        }
        Pattern patternCompile = Pattern.compile("[\\w]{1,45}");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str == null || !patternCompile.matcher(str).matches()) {
                AFLogger.afWarnLog("Invalid partner name: ".concat(String.valueOf(str)));
            } else {
                arrayList.add(str.toLowerCase(Locale.getDefault()));
            }
        }
        if (arrayList.contains("all")) {
            this.AFKeystoreWrapper = new String[]{"all"};
        } else if (arrayList.isEmpty()) {
            this.AFKeystoreWrapper = null;
        } else {
            this.AFKeystoreWrapper = (String[]) arrayList.toArray(new String[0]);
        }
    }

    public static String AFKeystoreWrapper(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e3) {
            AFLogger.afErrorLog(e3.getMessage(), e3);
            return "";
        }
    }

    public static String AFInAppEventParameterName(PackageManager packageManager, String str) throws NoSuchAlgorithmException, PackageManager.NameNotFoundException, CertificateException {
        Signature[] signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        if (signatureArr == null) {
            return null;
        }
        X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
        MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
        messageDigest.update(x509Certificate.getEncoded());
        return String.format("%032X", new BigInteger(1, messageDigest.digest()));
    }

    public static long AFInAppEventParameterName(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).getLongVersionCode();
        } catch (PackageManager.NameNotFoundException e3) {
            AFLogger.afErrorLog(e3.getMessage(), e3);
            return 0L;
        }
    }
}
