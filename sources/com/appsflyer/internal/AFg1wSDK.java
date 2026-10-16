package com.appsflyer.internal;

import android.net.Uri;
import com.appsflyer.AFLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class AFg1wSDK {
    public static final String AFInAppEventParameterName;
    public static final String AFKeystoreWrapper;
    public static final String AFLogger;
    public static final String AFLogger$LogLevel;
    public static String AFVersionDeclaration;
    public static final AFa1vSDK AFa1vSDK = new AFa1vSDK(null);
    public static String AppsFlyer2dXConversionCallback;
    public static final String afDebugLog;
    public static final String afErrorLog;
    public static String afErrorLogForExcManagerOnly;
    public static final String afInfoLog;
    public static final String afRDLog;
    public static final String afWarnLog;
    public static String getLevel;
    public static String init;
    public static String onAppOpenAttribution;
    public static String onAppOpenAttributionNative;
    public static String onAttributionFailure;
    public static String onAttributionFailureNative;
    public static String onConversionDataFail;
    public static String onConversionDataSuccess;
    private static final String onDeepLinking;
    public static String onDeepLinkingNative;
    public static String onInstallConversionDataLoadedNative;
    public static String onInstallConversionFailureNative;
    public static String onResponseErrorNative;
    public static String onResponseNative;
    public static final String values;
    public final AFb1gSDK AFInAppEventType;
    public final AFg1xSDK valueOf;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AFa1vSDK {
        private AFa1vSDK() {
        }

        public /* synthetic */ AFa1vSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = AFa1bSDK.AFInAppEventType;
        sb.append(str);
        sb.append("/androidevent?app_id=");
        String string = sb.toString();
        onDeepLinking = string;
        StringBuilder sb2 = new StringBuilder("https://%sattr.%s/api/v");
        sb2.append(string);
        AFInAppEventParameterName = sb2.toString();
        values = "https://%sadrevenue.%s/api/v2/generic/v6.12.3/android?app_id=";
        AFKeystoreWrapper = "https://%sadrevenue.%s/api/v2/log/AdImpression/v6.12.3/android?app_id=";
        StringBuilder sb3 = new StringBuilder("https://%sconversions.%s/api/v");
        sb3.append(string);
        afDebugLog = sb3.toString();
        StringBuilder sb4 = new StringBuilder("https://%slaunches.%s/api/v");
        sb4.append(string);
        AFLogger = sb4.toString();
        StringBuilder sb5 = new StringBuilder("https://%sinapps.%s/api/v");
        sb5.append(string);
        afErrorLog = sb5.toString();
        afRDLog = "https://%sars.%s/api/v2/android/validate_subscription?app_id=";
        afInfoLog = "https://%sviap.%s/api/v1/android/validate_purchase?app_id=";
        AFLogger$LogLevel = "https://%sars.%s/api/v2/android/validate_subscription_v2?app_id=";
        afWarnLog = "https://%sviap.%s/api/v1/android/validate_purchase_v2?app_id=";
        getLevel = "https://%sdlsdk.%s/v1.0/android/";
        afErrorLogForExcManagerOnly = "https://%ssdk-services.%s/validate-android-signature";
        StringBuilder sb6 = new StringBuilder("https://%svalidate.%s/api/v");
        sb6.append(str);
        sb6.append("/androidevent?buildnumber=6.12.3&app_id=");
        AFVersionDeclaration = sb6.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AFg1wSDK(AFb1gSDK aFb1gSDK) {
        this(aFb1gSDK, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(aFb1gSDK, "");
    }

    private static Uri.Builder valueOf(Uri.Builder builder, String str, String str2) {
        if (str != null && str2 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            builder.appendQueryParameter("af_sig", AFc1rSDK.AFInAppEventParameterName(sb.toString(), str));
            return builder;
        }
        String str3 = str == null ? "devKey" : "timestamp";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        sb2.append(" is null at attempt to generate ddl event url");
        AFLogger.afErrorLog(sb2.toString(), new IllegalStateException());
        return builder;
    }

    public final String AFInAppEventParameterName(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String strAFKeystoreWrapper = this.AFInAppEventType.AFKeystoreWrapper();
        String strConcat = strAFKeystoreWrapper != null ? "&channel=".concat(strAFKeystoreWrapper) : null;
        if (strConcat == null) {
            strConcat = "";
        }
        sb.append(strConcat);
        return sb.toString();
    }

    public final String AFInAppEventType(String str, String str2) {
        String packageName = this.AFInAppEventType.values.values.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "");
        String strAFKeystoreWrapper = this.AFInAppEventType.AFKeystoreWrapper();
        if (strAFKeystoreWrapper != null && !StringsKt.p0(strAFKeystoreWrapper)) {
            strAFKeystoreWrapper = "-".concat(String.valueOf(StringsKt.t1(strAFKeystoreWrapper).toString()));
        }
        if (strAFKeystoreWrapper == null) {
            strAFKeystoreWrapper = "";
        }
        String string = StringsKt.t1(strAFKeystoreWrapper).toString();
        String strAFInAppEventParameterName = onAppOpenAttribution;
        if (strAFInAppEventParameterName == null) {
            strAFInAppEventParameterName = this.valueOf.AFInAppEventParameterName(getLevel);
        }
        Uri.Builder builderBuildUpon = Uri.parse(strAFInAppEventParameterName).buildUpon();
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(string);
        Uri.Builder builderAppendPath = builderBuildUpon.appendPath(sb.toString());
        Intrinsics.checkNotNullExpressionValue(builderAppendPath, "");
        String string2 = valueOf(builderAppendPath, str, str2).appendQueryParameter("sdk_version", AFa1bSDK.AFInAppEventType).build().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "");
        return string2;
    }

    private AFg1wSDK(AFb1gSDK aFb1gSDK, AFg1xSDK aFg1xSDK) {
        Intrinsics.checkNotNullParameter(aFb1gSDK, "");
        Intrinsics.checkNotNullParameter(aFg1xSDK, "");
        this.AFInAppEventType = aFb1gSDK;
        this.valueOf = aFg1xSDK;
    }

    public final String valueOf(AFf1xSDK aFf1xSDK) {
        Intrinsics.checkNotNullParameter(aFf1xSDK, "");
        if (aFf1xSDK instanceof AFf1wSDK) {
            String str = onAttributionFailure;
            return str == null ? this.valueOf.AFInAppEventParameterName(afErrorLogForExcManagerOnly) : str;
        }
        if (aFf1xSDK instanceof AFf1zSDK) {
            String strAFInAppEventParameterName = onConversionDataFail;
            if (strAFInAppEventParameterName == null) {
                strAFInAppEventParameterName = this.valueOf.AFInAppEventParameterName(AFVersionDeclaration);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(strAFInAppEventParameterName);
            sb.append(this.AFInAppEventType.values.values.getPackageName());
            return sb.toString();
        }
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ AFg1wSDK(AFb1gSDK aFb1gSDK, AFg1xSDK aFg1xSDK, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFb1gSDK, (i3 & 2) != 0 ? new AFf1aSDK() : aFg1xSDK);
    }

    public static String AFInAppEventType(String str, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(!z2 ? "&buildnumber=6.12.3" : "");
        return sb.toString();
    }
}
