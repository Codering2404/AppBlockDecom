package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.facebook.ads.AdError;
import com.sun.jna.Function;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFc1rSDK implements AFc1tSDK {
    private final AFc1uSDK AFInAppEventParameterName;

    public AFc1rSDK() {
    }

    public static String AFInAppEventParameterName(String str, String str2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(str2.getBytes(Charset.defaultCharset()), "HmacSHA256"));
            return AFInAppEventType(mac.doFinal(str.getBytes(Charset.defaultCharset()))).toLowerCase(Locale.getDefault());
        } catch (InvalidKeyException | NoSuchAlgorithmException e3) {
            AFLogger.afErrorLog(e3.getMessage(), e3, true);
            return e3.getMessage();
        }
    }

    private static String AFInAppEventType(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b3 : bArr) {
            sb.append(Integer.toString((b3 & 255) + Function.MAX_NARGS, 16).substring(1));
        }
        return sb.toString();
    }

    public static byte[] AFKeystoreWrapper(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(Charset.defaultCharset()));
            return messageDigest.digest();
        } catch (Exception e3) {
            AFLogger.afErrorLog("Error turning string to SHA-256 byte array", e3);
            return null;
        }
    }

    public static final List<StackTraceElement> values(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "");
            if (!StringsKt.U(className, "com.appsflyer", false, 2, null)) {
                stackTraceElement = null;
            }
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
        }
        return arrayList;
    }

    @Override // com.appsflyer.internal.AFc1tSDK
    public final void valueOf(byte[] bArr, Map<String, String> map, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        if (new AFc1pSDK(bArr, map, AdError.SERVER_ERROR_CODE).valueOf()) {
            this.AFInAppEventParameterName.AFInAppEventType();
        }
    }

    public AFc1rSDK(AFc1uSDK aFc1uSDK) {
        Intrinsics.checkNotNullParameter(aFc1uSDK, "");
        this.AFInAppEventParameterName = aFc1uSDK;
    }

    public static boolean AFInAppEventType(Map<String, Object> map, String[] strArr, AFb1gSDK aFb1gSDK) throws IllegalStateException {
        if (map == null || map.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (!map.containsKey(str)) {
                return false;
            }
        }
        String str2 = (String) map.remove("sig");
        if (str2 == null) {
            return false;
        }
        String strValueOf = AFb1gSDK.valueOf();
        StringBuilder sb = new StringBuilder();
        sb.append(new JSONObject(map));
        sb.append(strValueOf);
        return AFInAppEventParameterName(sb.toString(), AFa1aSDK.valueOf(aFb1gSDK.values, aFb1gSDK.valueOf)).equals(str2);
    }

    public static String values(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(Charset.defaultCharset()));
            return AFInAppEventType(messageDigest.digest());
        } catch (Exception e3) {
            AFLogger.afErrorLog("Error turning data to SHA-256 string", e3);
            return null;
        }
    }
}
