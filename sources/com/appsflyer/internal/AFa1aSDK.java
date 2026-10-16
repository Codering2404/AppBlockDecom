package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFa1aSDK {
    private static String AFInAppEventParameterName;

    public static synchronized String valueOf(AFc1zSDK aFc1zSDK, AFb1fSDK aFb1fSDK) {
        if (aFc1zSDK.values == null) {
            return AFInAppEventParameterName;
        }
        if (AFInAppEventParameterName == null) {
            String strAFKeystoreWrapper = aFb1fSDK.AFKeystoreWrapper("AF_INSTALLATION", null);
            if (strAFKeystoreWrapper != null) {
                AFInAppEventParameterName = strAFKeystoreWrapper;
            } else {
                try {
                    File file = new File(aFc1zSDK.values.getFilesDir(), "AF_INSTALLATION");
                    if (file.exists()) {
                        AFInAppEventParameterName = values(file);
                        file.delete();
                    } else {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        StringBuilder sb = new StringBuilder();
                        sb.append(jCurrentTimeMillis);
                        sb.append("-");
                        sb.append(Math.abs(new SecureRandom().nextLong()));
                        AFInAppEventParameterName = sb.toString();
                    }
                    aFb1fSDK.values("AF_INSTALLATION", AFInAppEventParameterName);
                } catch (Exception e3) {
                    AFLogger.afErrorLog("Error getting AF unique ID", e3);
                }
            }
            if (AFInAppEventParameterName != null) {
                AppsFlyerProperties.getInstance().set("uid", AFInAppEventParameterName);
            }
        }
        return AFInAppEventParameterName;
    }

    private static String values(File file) throws Throwable {
        byte[] bArr;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        byte[] bArr2 = null;
        randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
            } catch (IOException e3) {
                e = e3;
                bArr = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bArr2 = new byte[(int) randomAccessFile.length()];
            randomAccessFile.readFully(bArr2);
            randomAccessFile.close();
            try {
                randomAccessFile.close();
            } catch (IOException e4) {
                AFLogger.afErrorLog("Exception while trying to close the InstallationFile", e4);
            }
        } catch (IOException e5) {
            e = e5;
            bArr = bArr2;
            randomAccessFile2 = randomAccessFile;
            AFLogger.afErrorLog("Exception while reading InstallationFile: ", e);
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e6) {
                    AFLogger.afErrorLog("Exception while trying to close the InstallationFile", e6);
                }
            }
            bArr2 = bArr;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e7) {
                    AFLogger.afErrorLog("Exception while trying to close the InstallationFile", e7);
                }
            }
            throw th;
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return new String(bArr2, Charset.defaultCharset());
    }
}
