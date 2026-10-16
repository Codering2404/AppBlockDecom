package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import com.facebook.AccessToken;
import java.math.BigDecimal;
import java.util.Currency;
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
public final class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = AppEventsLogger.class.getCanonicalName();
    private final AppEventsLoggerImpl loggerImpl;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void activateApp(Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            AppEventsLoggerImpl.Companion.activateApp(application, null);
        }

        @JvmStatic
        public final void augmentWebView(WebView webView, Context context) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            AppEventsLoggerImpl.Companion.augmentWebView(webView, context);
        }

        @JvmStatic
        public final void clearUserData() {
            UserDataStore.clear();
        }

        @JvmStatic
        public final void clearUserID() {
            AnalyticsUserIDStore.setUserID(null);
        }

        @JvmStatic
        public final String getAnonymousAppDeviceGUID(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return AppEventsLoggerImpl.Companion.getAnonymousAppDeviceGUID(context);
        }

        @JvmStatic
        public final FlushBehavior getFlushBehavior() {
            return AppEventsLoggerImpl.Companion.getFlushBehavior();
        }

        @JvmStatic
        public final String getUserData() {
            return UserDataStore.getHashedUserData$facebook_core_release();
        }

        @JvmStatic
        public final String getUserID() {
            return AnalyticsUserIDStore.getUserID();
        }

        @JvmStatic
        public final void initializeLib(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppEventsLoggerImpl.Companion.initializeLib(context, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final AppEventsLogger newLogger(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new AppEventsLogger(context, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
        }

        @JvmStatic
        public final void onContextStop() {
            AppEventsLoggerImpl.Companion.onContextStop();
        }

        @JvmStatic
        public final void setFlushBehavior(FlushBehavior flushBehavior) {
            Intrinsics.checkNotNullParameter(flushBehavior, "flushBehavior");
            AppEventsLoggerImpl.Companion.setFlushBehavior(flushBehavior);
        }

        @JvmStatic
        public final void setInstallReferrer(String str) {
            AppEventsLoggerImpl.Companion.setInstallReferrer(str);
        }

        @JvmStatic
        public final void setPushNotificationsRegistrationId(String str) {
            AppEventsLoggerImpl.Companion.setPushNotificationsRegistrationId(str);
        }

        @JvmStatic
        public final void setUserData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
            UserDataStore.setUserDataAndHash$default(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, null, 1024, null);
        }

        @JvmStatic
        public final void setUserID(String str) {
            AnalyticsUserIDStore.setUserID(str);
        }

        private Companion() {
        }

        @JvmStatic
        public final void activateApp(Application application, String str) {
            Intrinsics.checkNotNullParameter(application, "application");
            AppEventsLoggerImpl.Companion.activateApp(application, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final AppEventsLogger newLogger(Context context, AccessToken accessToken) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new AppEventsLogger(context, null, accessToken, 0 == true ? 1 : 0);
        }

        @JvmStatic
        public final void setUserData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
            UserDataStore.setUserDataAndHash(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
        }

        @JvmStatic
        public final AppEventsLogger newLogger(Context context, String str, AccessToken accessToken) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new AppEventsLogger(context, str, accessToken, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final AppEventsLogger newLogger(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new AppEventsLogger(context, str, null, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum ProductAvailability {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        AVALIABLE_FOR_ORDER,
        DISCONTINUED
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum ProductCondition {
        NEW,
        REFURBISHED,
        USED
    }

    public /* synthetic */ AppEventsLogger(Context context, String str, AccessToken accessToken, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, accessToken);
    }

    @JvmStatic
    public static final void activateApp(Application application) {
        Companion.activateApp(application);
    }

    @JvmStatic
    public static final void augmentWebView(WebView webView, Context context) {
        Companion.augmentWebView(webView, context);
    }

    @JvmStatic
    public static final void clearUserData() {
        Companion.clearUserData();
    }

    @JvmStatic
    public static final void clearUserID() {
        Companion.clearUserID();
    }

    @JvmStatic
    public static final String getAnonymousAppDeviceGUID(Context context) {
        return Companion.getAnonymousAppDeviceGUID(context);
    }

    @JvmStatic
    public static final FlushBehavior getFlushBehavior() {
        return Companion.getFlushBehavior();
    }

    @JvmStatic
    public static final String getUserData() {
        return Companion.getUserData();
    }

    @JvmStatic
    public static final String getUserID() {
        return Companion.getUserID();
    }

    @JvmStatic
    public static final void initializeLib(Context context, String str) {
        Companion.initializeLib(context, str);
    }

    @JvmStatic
    public static final AppEventsLogger newLogger(Context context) {
        return Companion.newLogger(context);
    }

    @JvmStatic
    public static final void onContextStop() {
        Companion.onContextStop();
    }

    @JvmStatic
    public static final void setFlushBehavior(FlushBehavior flushBehavior) {
        Companion.setFlushBehavior(flushBehavior);
    }

    @JvmStatic
    public static final void setInstallReferrer(String str) {
        Companion.setInstallReferrer(str);
    }

    @JvmStatic
    public static final void setPushNotificationsRegistrationId(String str) {
        Companion.setPushNotificationsRegistrationId(str);
    }

    @JvmStatic
    public static final void setUserData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Companion.setUserData(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    @JvmStatic
    public static final void setUserID(String str) {
        Companion.setUserID(str);
    }

    public final void flush() {
        this.loggerImpl.flush();
    }

    public final String getApplicationId() {
        return this.loggerImpl.getApplicationId();
    }

    public final boolean isValidForAccessToken(AccessToken accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        return this.loggerImpl.isValidForAccessToken(accessToken);
    }

    public final void logEvent(String str) {
        this.loggerImpl.logEvent(str);
    }

    public final void logProductItem(String str, ProductAvailability productAvailability, ProductCondition productCondition, String str2, String str3, String str4, String str5, BigDecimal bigDecimal, Currency currency, String str6, String str7, String str8, Bundle bundle) {
        this.loggerImpl.logProductItem(str, productAvailability, productCondition, str2, str3, str4, str5, bigDecimal, currency, str6, str7, str8, bundle);
    }

    public final void logPurchase(BigDecimal bigDecimal, Currency currency) {
        this.loggerImpl.logPurchase(bigDecimal, currency);
    }

    public final void logPushNotificationOpen(Bundle payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.loggerImpl.logPushNotificationOpen(payload, null);
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this.loggerImpl = new AppEventsLoggerImpl(context, str, accessToken);
    }

    @JvmStatic
    public static final void activateApp(Application application, String str) {
        Companion.activateApp(application, str);
    }

    @JvmStatic
    public static final AppEventsLogger newLogger(Context context, AccessToken accessToken) {
        return Companion.newLogger(context, accessToken);
    }

    @JvmStatic
    public static final void setUserData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Companion.setUserData(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public final void logEvent(String str, double d3) {
        this.loggerImpl.logEvent(str, d3);
    }

    public final void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        this.loggerImpl.logPurchase(bigDecimal, currency, bundle);
    }

    public final void logPushNotificationOpen(Bundle payload, String str) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.loggerImpl.logPushNotificationOpen(payload, str);
    }

    @JvmStatic
    public static final AppEventsLogger newLogger(Context context, String str) {
        return Companion.newLogger(context, str);
    }

    public final void logEvent(String str, Bundle bundle) {
        this.loggerImpl.logEvent(str, bundle);
    }

    @JvmStatic
    public static final AppEventsLogger newLogger(Context context, String str, AccessToken accessToken) {
        return Companion.newLogger(context, str, accessToken);
    }

    public final void logEvent(String str, double d3, Bundle bundle) {
        this.loggerImpl.logEvent(str, d3, bundle);
    }
}
