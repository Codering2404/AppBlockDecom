package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.bolts.AppLinks;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
@Metadata
public final class SourceApplicationInfo {
    private static final String CALL_APPLICATION_PACKAGE_KEY = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";
    public static final Companion Companion = new Companion(null);
    private static final String OPENED_BY_APP_LINK_KEY = "com.facebook.appevents.SourceApplicationInfo.openedByApplink";
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    private final String callingApplicationPackage;
    private final boolean isOpenedByAppLink;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void clearSavedSourceApplicationInfoFromDisk() {
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            editorEdit.remove(SourceApplicationInfo.CALL_APPLICATION_PACKAGE_KEY);
            editorEdit.remove(SourceApplicationInfo.OPENED_BY_APP_LINK_KEY);
            editorEdit.apply();
        }

        @JvmStatic
        public final SourceApplicationInfo getStoredSourceApplicatioInfo() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (defaultSharedPreferences.contains(SourceApplicationInfo.CALL_APPLICATION_PACKAGE_KEY)) {
                return new SourceApplicationInfo(defaultSharedPreferences.getString(SourceApplicationInfo.CALL_APPLICATION_PACKAGE_KEY, null), defaultSharedPreferences.getBoolean(SourceApplicationInfo.OPENED_BY_APP_LINK_KEY, false), defaultConstructorMarker);
            }
            return null;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory {
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        @JvmStatic
        public static final SourceApplicationInfo create(Activity activity) {
            String string;
            Intrinsics.checkNotNullParameter(activity, "activity");
            ComponentName callingActivity = activity.getCallingActivity();
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (callingActivity != null) {
                string = callingActivity.getPackageName();
                if (Intrinsics.areEqual(string, activity.getPackageName())) {
                    return null;
                }
            } else {
                string = "";
            }
            Intent intent = activity.getIntent();
            boolean z2 = false;
            if (intent != null && !intent.getBooleanExtra(SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, false)) {
                intent.putExtra(SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
                Bundle appLinkData = AppLinks.getAppLinkData(intent);
                if (appLinkData != null) {
                    Bundle bundle = appLinkData.getBundle("referer_app_link");
                    if (bundle != null) {
                        string = bundle.getString("package");
                    }
                    z2 = true;
                }
            }
            if (intent != null) {
                intent.putExtra(SourceApplicationInfo.SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
            }
            return new SourceApplicationInfo(string, z2, defaultConstructorMarker);
        }
    }

    public /* synthetic */ SourceApplicationInfo(String str, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z2);
    }

    @JvmStatic
    public static final void clearSavedSourceApplicationInfoFromDisk() {
        Companion.clearSavedSourceApplicationInfoFromDisk();
    }

    @JvmStatic
    public static final SourceApplicationInfo getStoredSourceApplicatioInfo() {
        return Companion.getStoredSourceApplicatioInfo();
    }

    public final String getCallingApplicationPackage() {
        return this.callingApplicationPackage;
    }

    public final boolean isOpenedByAppLink() {
        return this.isOpenedByAppLink;
    }

    public String toString() {
        String str = this.isOpenedByAppLink ? "Applink" : "Unclassified";
        if (this.callingApplicationPackage == null) {
            return str;
        }
        return str + '(' + this.callingApplicationPackage + ')';
    }

    public final void writeSourceApplicationInfoToDisk() {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        editorEdit.putString(CALL_APPLICATION_PACKAGE_KEY, this.callingApplicationPackage);
        editorEdit.putBoolean(OPENED_BY_APP_LINK_KEY, this.isOpenedByAppLink);
        editorEdit.apply();
    }

    private SourceApplicationInfo(String str, boolean z2) {
        this.callingApplicationPackage = str;
        this.isOpenedByAppLink = z2;
    }
}
