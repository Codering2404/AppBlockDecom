package com.appsflyer.internal;

import android.os.Build;
import com.appsflyer.AFKeystoreWrapper;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import java.security.KeyStoreException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AFb1rSDK {
    public static final AFb1rSDK INSTANCE = new AFb1rSDK();

    private AFb1rSDK() {
    }

    @JvmStatic
    public static final void AFKeystoreWrapper(AFc1zSDK aFc1zSDK, AFb1fSDK aFb1fSDK) {
        Intrinsics.checkNotNullParameter(aFc1zSDK, "");
        Intrinsics.checkNotNullParameter(aFb1fSDK, "");
        AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
        if (AFa1fSDK.valueOf()) {
            AFLogger.afRDLog("OPPO device found");
        }
        int i3 = Build.VERSION.SDK_INT;
        if (appsFlyerProperties.getBoolean(AppsFlyerProperties.DISABLE_KEYSTORE, true)) {
            StringBuilder sb = new StringBuilder("OS SDK is=");
            sb.append(i3);
            sb.append("; no KeyStore usage");
            AFLogger.afRDLog(sb.toString());
            return;
        }
        StringBuilder sb2 = new StringBuilder("OS SDK is=");
        sb2.append(i3);
        sb2.append("; use KeyStore");
        AFLogger.afRDLog(sb2.toString());
        AFKeystoreWrapper aFKeystoreWrapper = new AFKeystoreWrapper(aFc1zSDK.values);
        if (aFKeystoreWrapper.valueOf()) {
            String strAFInAppEventType = aFKeystoreWrapper.AFInAppEventType();
            synchronized (aFKeystoreWrapper.AFInAppEventType) {
                aFKeystoreWrapper.AFKeystoreWrapper++;
                AFLogger.afInfoLog("Deleting key with alias: ".concat(String.valueOf(strAFInAppEventType)));
                try {
                    synchronized (aFKeystoreWrapper.AFInAppEventType) {
                        aFKeystoreWrapper.values.deleteEntry(strAFInAppEventType);
                    }
                } catch (KeyStoreException e3) {
                    StringBuilder sb3 = new StringBuilder("Exception ");
                    sb3.append(e3.getMessage());
                    sb3.append(" occurred");
                    AFLogger.afErrorLog(sb3.toString(), e3);
                }
            }
            aFKeystoreWrapper.valueOf(aFKeystoreWrapper.AFInAppEventType());
        } else {
            aFKeystoreWrapper.AFInAppEventParameterName = AFa1aSDK.valueOf(aFc1zSDK, aFb1fSDK);
            aFKeystoreWrapper.AFKeystoreWrapper = 0;
            aFKeystoreWrapper.valueOf(aFKeystoreWrapper.AFInAppEventType());
        }
        appsFlyerProperties.set("KSAppsFlyerId", aFKeystoreWrapper.AFKeystoreWrapper());
        appsFlyerProperties.set("KSAppsFlyerRICounter", String.valueOf(aFKeystoreWrapper.AFInAppEventParameterName()));
    }

    public static String values() {
        return AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
    }

    public static String AFKeystoreWrapper() {
        return AppsFlyerProperties.getInstance().getString("KSAppsFlyerRICounter");
    }
}
