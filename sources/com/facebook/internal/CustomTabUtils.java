package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
public final class CustomTabUtils {
    public static final CustomTabUtils INSTANCE = new CustomTabUtils();
    private static final String[] CHROME_PACKAGES = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};

    private CustomTabUtils() {
    }

    @JvmStatic
    public static final String getChromePackage() {
        if (CrashShieldHandler.isObjectCrashing(CustomTabUtils.class)) {
            return null;
        }
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            List<ResolveInfo> listQueryIntentServices = applicationContext.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentServices, "context.packageManager.q…ervices(serviceIntent, 0)");
            HashSet hashSet = ArraysKt.toHashSet(CHROME_PACKAGES);
            Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
            while (it.hasNext()) {
                ServiceInfo serviceInfo = it.next().serviceInfo;
                if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                    return serviceInfo.packageName;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CustomTabUtils.class);
            return null;
        }
    }

    @JvmStatic
    public static final String getDefaultRedirectURI() {
        if (CrashShieldHandler.isObjectCrashing(CustomTabUtils.class)) {
            return null;
        }
        try {
            return Validate.CUSTOM_TAB_REDIRECT_URI_PREFIX + FacebookSdk.getApplicationContext().getPackageName();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CustomTabUtils.class);
            return null;
        }
    }

    @JvmStatic
    public static final String getValidRedirectURI(String developerDefinedRedirectURI) {
        if (CrashShieldHandler.isObjectCrashing(CustomTabUtils.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(developerDefinedRedirectURI, "developerDefinedRedirectURI");
            return Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), developerDefinedRedirectURI) ? developerDefinedRedirectURI : Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), getDefaultRedirectURI()) ? getDefaultRedirectURI() : "";
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CustomTabUtils.class);
            return null;
        }
    }
}
