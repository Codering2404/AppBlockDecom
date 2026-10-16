package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class Validate {
    private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
    private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
    public static final String CUSTOM_TAB_REDIRECT_URI_PREFIX = "fbconnect://cct.";
    private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
    private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
    public static final Validate INSTANCE = new Validate();
    private static final String TAG = Validate.class.getName();

    private Validate() {
    }

    @JvmStatic
    public static final void containsNoNullOrEmpty(Collection<String> container, String name) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        for (String str : container) {
            if (str == null) {
                throw new NullPointerException("Container '" + name + "' cannot contain null values");
            }
            if (str.length() <= 0) {
                throw new IllegalArgumentException(("Container '" + name + "' cannot contain empty values").toString());
            }
        }
    }

    @JvmStatic
    public static final <T> void containsNoNulls(Collection<? extends T> container, String name) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<? extends T> it = container.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("Container '" + name + "' cannot contain null values");
            }
        }
    }

    @JvmStatic
    public static final String hasAppID() {
        String applicationId = FacebookSdk.getApplicationId();
        if (applicationId != null) {
            return applicationId;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.");
    }

    @JvmStatic
    public static final boolean hasBluetoothPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return hasPermission(context, "android.permission.BLUETOOTH") && hasPermission(context, "android.permission.BLUETOOTH_ADMIN");
    }

    @JvmStatic
    public static final boolean hasChangeWifiStatePermission(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return hasPermission(context, "android.permission.CHANGE_WIFI_STATE");
    }

    @JvmStatic
    public static final String hasClientToken() {
        String clientToken = FacebookSdk.getClientToken();
        if (clientToken != null) {
            return clientToken;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token. Please follow https://developers.facebook.com/docs/android/getting-started/#client-access-token to get the token and fill it in AndroidManifest.xml");
    }

    @JvmStatic
    public static final void hasContentProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String strHasAppID = hasAppID();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String str = CONTENT_PROVIDER_BASE + strHasAppID;
            if (packageManager.resolveContentProvider(str, 0) != null) {
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str2 = String.format(CONTENT_PROVIDER_NOT_FOUND_REASON, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            throw new IllegalStateException(str2.toString());
        }
    }

    @JvmStatic
    public static final boolean hasCustomTabRedirectActivity(Context context, String redirectURI) {
        List<ResolveInfo> listQueryIntentActivities;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(redirectURI, "redirectURI");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(redirectURI));
            listQueryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        } else {
            listQueryIntentActivities = null;
        }
        if (listQueryIntentActivities == null) {
            return false;
        }
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (!Intrinsics.areEqual(activityInfo.name, "com.facebook.CustomTabActivity") || !Intrinsics.areEqual(activityInfo.packageName, context.getPackageName())) {
                return false;
            }
            z2 = true;
        }
        return z2;
    }

    @JvmStatic
    public static final void hasFacebookActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        hasFacebookActivity(context, true);
    }

    @JvmStatic
    public static final void hasInternetPermissions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        hasInternetPermissions(context, true);
    }

    @JvmStatic
    public static final boolean hasLocationPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION") || hasPermission(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    @JvmStatic
    public static final boolean hasPermission(Context context, String permission) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return context.checkCallingOrSelfPermission(permission) == 0;
    }

    @JvmStatic
    public static final boolean hasWiFiPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return hasPermission(context, "android.permission.ACCESS_WIFI_STATE");
    }

    @JvmStatic
    public static final <T> void notEmpty(Collection<? extends T> container, String name) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        if (container.isEmpty()) {
            throw new IllegalArgumentException(("Container '" + name + "' cannot be empty").toString());
        }
    }

    @JvmStatic
    public static final <T> void notEmptyAndContainsNoNulls(Collection<? extends T> container, String name) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        containsNoNulls(container, name);
        notEmpty(container, name);
    }

    @JvmStatic
    public static final void notNull(Object obj, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (obj != null) {
            return;
        }
        throw new NullPointerException("Argument '" + name + "' cannot be null");
    }

    @JvmStatic
    public static final String notNullOrEmpty(String str, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (str != null && str.length() > 0) {
            return str;
        }
        throw new IllegalArgumentException(("Argument '" + name + "' cannot be null or empty").toString());
    }

    @JvmStatic
    public static final void oneOf(Object obj, String name, Object... values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        for (Object obj2 : values) {
            if (Intrinsics.areEqual(obj2, obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Argument '" + name + "' was not one of the allowed values");
    }

    @JvmStatic
    public static final void runningOnUiThread() {
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            throw new FacebookException("This method should be called from the UI thread");
        }
    }

    @JvmStatic
    public static final void sdkInitialized() {
        if (!FacebookSdk.isInitialized()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    @JvmStatic
    public static final void hasFacebookActivity(Context context, boolean z2) {
        ActivityInfo activityInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                activityInfo = packageManager.getActivityInfo(new ComponentName(context, "com.facebook.FacebookActivity"), 1);
            } catch (PackageManager.NameNotFoundException unused) {
                activityInfo = null;
            }
        } else {
            activityInfo = null;
        }
        if (activityInfo == null) {
            if (z2) {
                throw new IllegalStateException(FACEBOOK_ACTIVITY_NOT_FOUND_REASON);
            }
            Log.w(TAG, FACEBOOK_ACTIVITY_NOT_FOUND_REASON);
        }
    }

    @JvmStatic
    public static final void hasInternetPermissions(Context context, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            if (z2) {
                throw new IllegalStateException(NO_INTERNET_PERMISSION_REASON);
            }
            Log.w(TAG, NO_INTERNET_PERMISSION_REASON);
        }
    }

    @JvmStatic
    public static final void notEmpty(String arg, String name) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        Intrinsics.checkNotNullParameter(name, "name");
        if (arg.length() > 0) {
            return;
        }
        throw new IllegalArgumentException(("Argument '" + name + "' cannot be empty").toString());
    }
}
