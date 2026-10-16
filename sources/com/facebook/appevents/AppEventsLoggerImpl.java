package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.gps.ara.GpsAraTriggersManager;
import com.facebook.appevents.gps.pa.PACustomAudienceClient;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InstallReferrerUtil;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
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
@Metadata
public final class AppEventsLoggerImpl {
    private static final String ACCOUNT_KIT_EVENT_NAME_PREFIX = "fb_ak";
    public static final String APP_EVENTS_KILLSWITCH = "app_events_killswitch";
    private static final String APP_EVENT_NAME_PUSH_OPENED = "fb_mobile_push_opened";
    private static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final String APP_EVENT_PUSH_PARAMETER_ACTION = "fb_push_action";
    private static final String APP_EVENT_PUSH_PARAMETER_CAMPAIGN = "fb_push_campaign";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    public static final Companion Companion = new Companion(null);
    private static final String PUSH_PAYLOAD_CAMPAIGN_KEY = "campaign";
    private static final String PUSH_PAYLOAD_KEY = "fb_push_payload";
    private static final String TAG;
    private static volatile String anonymousAppDeviceGUID;
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private static AppEventsLogger.FlushBehavior flushBehaviorField;
    private static final InstallReferrerUtil.Callback installReferrerCallback;
    private static boolean isActivateAppEventRequested;
    private static String pushNotificationsRegistrationIdField;
    private static final Object staticLock;
    private AccessTokenAppIdPair accessTokenAppId;
    private final String contextName;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initializeLib$lambda$4(Context context, AppEventsLoggerImpl logger) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(logger, "$logger");
            Bundle bundle = new Bundle();
            String[] strArr = {"com.facebook.core.Core", "com.facebook.login.Login", "com.facebook.share.Share", "com.facebook.places.Places", "com.facebook.messenger.Messenger", "com.facebook.applinks.AppLinks", "com.facebook.marketing.Marketing", "com.facebook.gamingservices.GamingServices", "com.facebook.all.All", InAppPurchaseConstants.CLASSNAME_BILLING_CLIENT, "com.android.vending.billing.IInAppBillingService"};
            String[] strArr2 = {"core_lib_included", "login_lib_included", "share_lib_included", "places_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "gamingservices_lib_included", "all_lib_included", "billing_client_lib_included", "billing_service_lib_included"};
            int i3 = 0;
            for (int i4 = 0; i4 < 11; i4++) {
                String str = strArr[i4];
                String str2 = strArr2[i4];
                try {
                    Class.forName(str);
                    bundle.putInt(str2, 1);
                    i3 |= 1 << i4;
                } catch (ClassNotFoundException unused) {
                }
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            if (sharedPreferences.getInt("kitsBitmask", 0) != i3) {
                sharedPreferences.edit().putInt("kitsBitmask", i3).apply();
                logger.logEventImplicitly(AnalyticsEvents.EVENT_SDK_INITIALIZE, null, bundle);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void initializeTimersIfNeeded() {
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                if (AppEventsLoggerImpl.access$getBackgroundExecutor$cp() != null) {
                    return;
                }
                AppEventsLoggerImpl.access$setBackgroundExecutor$cp(new ScheduledThreadPoolExecutor(1));
                Unit unit = Unit.f139807a;
                Runnable runnable = new Runnable() { // from class: com.facebook.appevents.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppEventsLoggerImpl.Companion.initializeTimersIfNeeded$lambda$6();
                    }
                };
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
                if (scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp.scheduleAtFixedRate(runnable, 0L, 86400L, TimeUnit.SECONDS);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initializeTimersIfNeeded$lambda$6() {
            HashSet hashSet = new HashSet();
            Iterator<AccessTokenAppIdPair> it = AppEventQueue.getKeySet().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getApplicationId());
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                FetchedAppSettingsManager.queryAppSettings((String) it2.next(), true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void logEvent(AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
            AppEventQueue.add(accessTokenAppIdPair, appEvent);
            if (FeatureManager.isEnabled(FeatureManager.Feature.OnDevicePostInstallEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                OnDeviceProcessingManager.sendCustomEventAsync(accessTokenAppIdPair.getApplicationId(), appEvent);
            }
            if (FeatureManager.isEnabled(FeatureManager.Feature.GPSARATriggers)) {
                GpsAraTriggersManager.INSTANCE.registerTriggerAsync(accessTokenAppIdPair.getApplicationId(), appEvent);
            }
            if (FeatureManager.isEnabled(FeatureManager.Feature.GPSPACAProcessing)) {
                PACustomAudienceClient.INSTANCE.joinCustomAudience(accessTokenAppIdPair.getApplicationId(), appEvent);
            }
            if (appEvent.getIsImplicit() || AppEventsLoggerImpl.access$isActivateAppEventRequested$cp()) {
                return;
            }
            if (Intrinsics.areEqual(appEvent.getName(), AppEventsConstants.EVENT_NAME_ACTIVATED_APP)) {
                AppEventsLoggerImpl.access$setActivateAppEventRequested$cp(true);
            } else {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void notifyDeveloperError(String str) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
        }

        private final String readInstallReferrerFromPrefs() {
            return FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("install_referrer", null);
        }

        @JvmStatic
        public final void activateApp(Application application, String str) {
            Intrinsics.checkNotNullParameter(application, "application");
            if (!FacebookSdk.isInitialized()) {
                throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
            }
            AnalyticsUserIDStore.initStore();
            UserDataStore.initStore();
            if (str == null) {
                str = FacebookSdk.getApplicationId();
            }
            FacebookSdk.publishInstallAsync(application, str);
            ActivityLifecycleTracker.startTracking(application, str);
            if (FeatureManager.isEnabled(FeatureManager.Feature.GPSPACAProcessing)) {
                PACustomAudienceClient.INSTANCE.joinCustomAudience(str, "fb_mobile_app_install");
            }
            if (FeatureManager.isEnabled(FeatureManager.Feature.GPSARATriggers)) {
                GpsAraTriggersManager.INSTANCE.registerTriggerAsync(str, new AppEvent("unknown", "MOBILE_INSTALL_EVENT", null, null, false, ActivityLifecycleTracker.isInBackground(), ActivityLifecycleTracker.getCurrentSessionGuid(), null));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final kotlin.Pair<android.os.Bundle, com.facebook.appevents.OperationalData> addImplicitPurchaseParameters(android.os.Bundle r14, com.facebook.appevents.OperationalData r15, boolean r16) {
            /*
                r13 = this;
                boolean r0 = com.facebook.appevents.internal.AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()
                java.lang.String r1 = "0"
                java.lang.String r2 = "1"
                if (r0 == 0) goto Lc
                r6 = r2
                goto Ld
            Lc:
                r6 = r1
            Ld:
                com.facebook.appevents.OperationalData$Companion r7 = com.facebook.appevents.OperationalData.Companion
                com.facebook.appevents.OperationalDataEnum r8 = com.facebook.appevents.OperationalDataEnum.IAPParameters
                java.lang.String r5 = "is_implicit_purchase_logging_enabled"
                r3 = r7
                r4 = r8
                r7 = r14
                r8 = r15
                kotlin.Pair r0 = r3.addParameterAndReturn(r4, r5, r6, r7, r8)
                r8 = r4
                java.lang.String r4 = "fb_iap_product_id"
                java.lang.Object r4 = r3.getParameter(r8, r4, r14, r15)
                boolean r5 = r4 instanceof java.lang.String
                r6 = 0
                if (r5 == 0) goto L2b
                java.lang.String r4 = (java.lang.String) r4
                r10 = r4
                goto L2c
            L2b:
                r10 = r6
            L2c:
                if (r16 != 0) goto L5a
                if (r14 == 0) goto L36
                java.lang.String r4 = "fb_content_id"
                java.lang.String r6 = r14.getString(r4)
            L36:
                if (r6 != 0) goto L5a
                if (r10 == 0) goto L5a
                java.lang.String r9 = "fb_content_id"
                r11 = r14
                r12 = r15
                r7 = r3
                kotlin.Pair r14 = r7.addParameterAndReturn(r8, r9, r10, r11, r12)
                java.lang.Object r0 = r14.e()
                r11 = r0
                android.os.Bundle r11 = (android.os.Bundle) r11
                java.lang.Object r14 = r14.f()
                r12 = r14
                com.facebook.appevents.OperationalData r12 = (com.facebook.appevents.OperationalData) r12
                java.lang.String r9 = "android_dynamic_ads_content_id"
                java.lang.String r10 = "client_manual"
                kotlin.Pair r0 = r7.addParameterAndReturn(r8, r9, r10, r11, r12)
                goto L5b
            L5a:
                r7 = r3
            L5b:
                java.lang.Object r14 = r0.e()
                r11 = r14
                android.os.Bundle r11 = (android.os.Bundle) r11
                java.lang.Object r14 = r0.f()
                r12 = r14
                com.facebook.appevents.OperationalData r12 = (com.facebook.appevents.OperationalData) r12
                boolean r14 = com.facebook.UserSettingsManager.getAutoLogAppEventsEnabled()
                if (r14 == 0) goto L71
                r10 = r2
                goto L72
            L71:
                r10 = r1
            L72:
                java.lang.String r9 = "is_autolog_app_events_enabled"
                kotlin.Pair r14 = r7.addParameterAndReturn(r8, r9, r10, r11, r12)
                java.lang.Object r0 = r14.e()
                android.os.Bundle r0 = (android.os.Bundle) r0
                java.lang.Object r14 = r14.f()
                com.facebook.appevents.OperationalData r14 = (com.facebook.appevents.OperationalData) r14
                kotlin.Pair r1 = new kotlin.Pair
                r1.<init>(r0, r14)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventsLoggerImpl.Companion.addImplicitPurchaseParameters(android.os.Bundle, com.facebook.appevents.OperationalData, boolean):kotlin.Pair");
        }

        @JvmStatic
        public final void augmentWebView(WebView webView, Context context) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            String RELEASE = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
            String[] strArr = (String[]) StringsKt.V0(RELEASE, new String[]{"."}, false, 0, 6, null).toArray(new String[0]);
            int i3 = !(strArr.length == 0) ? Integer.parseInt(strArr[0]) : 0;
            int i4 = strArr.length > 1 ? Integer.parseInt(strArr[1]) : 0;
            if (i3 < 4 || (i3 == 4 && i4 <= 1)) {
                Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, AppEventsLoggerImpl.access$getTAG$cp(), "augmentWebView is only available for Android SDK version >= 17 on devices running Android >= 4.2");
                return;
            }
            webView.addJavascriptInterface(new FacebookSDKJSInterface(context), "fbmq_" + FacebookSdk.getApplicationId());
        }

        public final void eagerFlush() {
            if (getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
            }
        }

        @JvmStatic
        public final void functionDEPRECATED(String extraMsg) {
            Intrinsics.checkNotNullParameter(extraMsg, "extraMsg");
            Log.w(AppEventsLoggerImpl.access$getTAG$cp(), "This function is deprecated. " + extraMsg);
        }

        @JvmStatic
        public final Executor getAnalyticsExecutor() {
            if (AppEventsLoggerImpl.access$getBackgroundExecutor$cp() == null) {
                initializeTimersIfNeeded();
            }
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
            if (scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp != null) {
                return scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp;
            }
            throw new IllegalStateException("Required value was null.");
        }

        @JvmStatic
        public final String getAnonymousAppDeviceGUID(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                    try {
                        if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                            AppEventsLoggerImpl.access$setAnonymousAppDeviceGUID$cp(context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null));
                            if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                                AppEventsLoggerImpl.access$setAnonymousAppDeviceGUID$cp("XZ" + UUID.randomUUID());
                                context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp()).apply();
                            }
                        }
                        Unit unit = Unit.f139807a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            String strAccess$getAnonymousAppDeviceGUID$cp = AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp();
            if (strAccess$getAnonymousAppDeviceGUID$cp != null) {
                return strAccess$getAnonymousAppDeviceGUID$cp;
            }
            throw new IllegalStateException("Required value was null.");
        }

        @JvmStatic
        public final AppEventsLogger.FlushBehavior getFlushBehavior() {
            AppEventsLogger.FlushBehavior flushBehaviorAccess$getFlushBehaviorField$cp;
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                flushBehaviorAccess$getFlushBehaviorField$cp = AppEventsLoggerImpl.access$getFlushBehaviorField$cp();
            }
            return flushBehaviorAccess$getFlushBehaviorField$cp;
        }

        @JvmStatic
        public final String getInstallReferrer() {
            InstallReferrerUtil.tryUpdateReferrerInfo(AppEventsLoggerImpl.access$getInstallReferrerCallback$cp());
            return readInstallReferrerFromPrefs();
        }

        @JvmStatic
        public final String getInstallReferrerBlocking() {
            InstallReferrerUtil.tryUpdateReferrerInfoBlocking(AppEventsLoggerImpl.access$getInstallReferrerCallback$cp());
            return readInstallReferrerFromPrefs();
        }

        @JvmStatic
        public final String getPushNotificationsRegistrationId() {
            String strAccess$getPushNotificationsRegistrationIdField$cp;
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                strAccess$getPushNotificationsRegistrationIdField$cp = AppEventsLoggerImpl.access$getPushNotificationsRegistrationIdField$cp();
            }
            return strAccess$getPushNotificationsRegistrationIdField$cp;
        }

        @JvmStatic
        public final void initializeLib(final Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                final AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(context, str, (AccessToken) null);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
                if (scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                scheduledThreadPoolExecutorAccess$getBackgroundExecutor$cp.execute(new Runnable() { // from class: com.facebook.appevents.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppEventsLoggerImpl.Companion.initializeLib$lambda$4(context, appEventsLoggerImpl);
                    }
                });
            }
        }

        @JvmStatic
        public final void onContextStop() {
            AppEventQueue.persistToDisk();
        }

        @JvmStatic
        public final void setFlushBehavior(AppEventsLogger.FlushBehavior flushBehavior) {
            Intrinsics.checkNotNullParameter(flushBehavior, "flushBehavior");
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                AppEventsLoggerImpl.access$setFlushBehaviorField$cp(flushBehavior);
                Unit unit = Unit.f139807a;
            }
        }

        @JvmStatic
        public final void setInstallReferrer(String str) {
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            if (str != null) {
                sharedPreferences.edit().putString("install_referrer", str).apply();
            }
        }

        @JvmStatic
        public final void setPushNotificationsRegistrationId(String str) {
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                try {
                    if (!Utility.stringsEqualOrEmpty(AppEventsLoggerImpl.access$getPushNotificationsRegistrationIdField$cp(), str)) {
                        AppEventsLoggerImpl.access$setPushNotificationsRegistrationIdField$cp(str);
                        AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(FacebookSdk.getApplicationContext(), (String) null, (AccessToken) null);
                        appEventsLoggerImpl.logEvent(AppEventsConstants.EVENT_NAME_PUSH_TOKEN_OBTAINED);
                        if (AppEventsLoggerImpl.Companion.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                            appEventsLoggerImpl.flush();
                        }
                    }
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private Companion() {
        }
    }

    static {
        String canonicalName = AppEventsLoggerImpl.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.AppEventsLoggerImpl";
        }
        TAG = canonicalName;
        flushBehaviorField = AppEventsLogger.FlushBehavior.AUTO;
        staticLock = new Object();
        installReferrerCallback = new InstallReferrerUtil.Callback() { // from class: com.facebook.appevents.i
            @Override // com.facebook.internal.InstallReferrerUtil.Callback
            public final void onReceiveReferrerUrl(String str) {
                AppEventsLoggerImpl.installReferrerCallback$lambda$0(str);
            }
        };
    }

    public AppEventsLoggerImpl(String activityName, String str, AccessToken accessToken) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Validate.sdkInitialized();
        this.contextName = activityName;
        accessToken = accessToken == null ? AccessToken.Companion.getCurrentAccessToken() : accessToken;
        if (accessToken == null || accessToken.isExpired() || !(str == null || Intrinsics.areEqual(str, accessToken.getApplicationId()))) {
            str = str == null ? Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext()) : str;
            if (str == null) {
                throw new IllegalStateException("Required value was null.");
            }
            this.accessTokenAppId = new AccessTokenAppIdPair(null, str);
        } else {
            this.accessTokenAppId = new AccessTokenAppIdPair(accessToken);
        }
        Companion.initializeTimersIfNeeded();
    }

    public static final /* synthetic */ String access$getAnonymousAppDeviceGUID$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return anonymousAppDeviceGUID;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    public static final /* synthetic */ ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return backgroundExecutor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    public static final /* synthetic */ AppEventsLogger.FlushBehavior access$getFlushBehaviorField$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return flushBehaviorField;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    public static final /* synthetic */ InstallReferrerUtil.Callback access$getInstallReferrerCallback$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return installReferrerCallback;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getPushNotificationsRegistrationIdField$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return pushNotificationsRegistrationIdField;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    public static final /* synthetic */ Object access$getStaticLock$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return staticLock;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    public static final /* synthetic */ boolean access$isActivateAppEventRequested$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return false;
        }
        try {
            return isActivateAppEventRequested;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return false;
        }
    }

    public static final /* synthetic */ void access$setActivateAppEventRequested$cp(boolean z2) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            isActivateAppEventRequested = z2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static final /* synthetic */ void access$setAnonymousAppDeviceGUID$cp(String str) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            anonymousAppDeviceGUID = str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static final /* synthetic */ void access$setBackgroundExecutor$cp(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            backgroundExecutor = scheduledThreadPoolExecutor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static final /* synthetic */ void access$setFlushBehaviorField$cp(AppEventsLogger.FlushBehavior flushBehavior) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            flushBehaviorField = flushBehavior;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static final /* synthetic */ void access$setPushNotificationsRegistrationIdField$cp(String str) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            pushNotificationsRegistrationIdField = str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    @JvmStatic
    public static final void activateApp(Application application, String str) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            Companion.activateApp(application, str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    @JvmStatic
    public static final Pair<Bundle, OperationalData> addImplicitPurchaseParameters(Bundle bundle, OperationalData operationalData, boolean z2) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return Companion.addImplicitPurchaseParameters(bundle, operationalData, z2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    @JvmStatic
    public static final void augmentWebView(WebView webView, Context context) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            Companion.augmentWebView(webView, context);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    @JvmStatic
    public static final void functionDEPRECATED(String str) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            Companion.functionDEPRECATED(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    @JvmStatic
    public static final Executor getAnalyticsExecutor() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return Companion.getAnalyticsExecutor();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    @JvmStatic
    public static final String getAnonymousAppDeviceGUID(Context context) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return Companion.getAnonymousAppDeviceGUID(context);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    @JvmStatic
    public static final AppEventsLogger.FlushBehavior getFlushBehavior() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return Companion.getFlushBehavior();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    @JvmStatic
    public static final String getInstallReferrer() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return Companion.getInstallReferrer();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    @JvmStatic
    public static final String getInstallReferrerBlocking() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return Companion.getInstallReferrerBlocking();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    @JvmStatic
    public static final String getPushNotificationsRegistrationId() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return Companion.getPushNotificationsRegistrationId();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    @JvmStatic
    public static final void initializeLib(Context context, String str) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            Companion.initializeLib(context, str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installReferrerCallback$lambda$0(String str) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            Companion.setInstallReferrer(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static /* synthetic */ void logEvent$default(AppEventsLoggerImpl appEventsLoggerImpl, String str, Bundle bundle, int i3, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        try {
            appEventsLoggerImpl.logEvent(str, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static /* synthetic */ void logEventImplicitly$default(AppEventsLoggerImpl appEventsLoggerImpl, String str, BigDecimal bigDecimal, Currency currency, Bundle bundle, OperationalData operationalData, int i3, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        if ((i3 & 16) != 0) {
            operationalData = null;
        }
        try {
            appEventsLoggerImpl.logEventImplicitly(str, bigDecimal, currency, bundle, operationalData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static /* synthetic */ void logPurchase$default(AppEventsLoggerImpl appEventsLoggerImpl, BigDecimal bigDecimal, Currency currency, Bundle bundle, int i3, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        if ((i3 & 4) != 0) {
            bundle = null;
        }
        try {
            appEventsLoggerImpl.logPurchase(bigDecimal, currency, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static /* synthetic */ void logPurchaseImplicitly$default(AppEventsLoggerImpl appEventsLoggerImpl, BigDecimal bigDecimal, Currency currency, Bundle bundle, OperationalData operationalData, int i3, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        if ((i3 & 8) != 0) {
            operationalData = null;
        }
        try {
            appEventsLoggerImpl.logPurchaseImplicitly(bigDecimal, currency, bundle, operationalData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    @JvmStatic
    public static final void onContextStop() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            Companion.onContextStop();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    @JvmStatic
    public static final void setFlushBehavior(AppEventsLogger.FlushBehavior flushBehavior) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            Companion.setFlushBehavior(flushBehavior);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    @JvmStatic
    public static final void setInstallReferrer(String str) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            Companion.setInstallReferrer(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    @JvmStatic
    public static final void setPushNotificationsRegistrationId(String str) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            Companion.setPushNotificationsRegistrationId(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public final void flush() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AppEventQueue.flush(FlushReason.EXPLICIT);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final String getApplicationId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.accessTokenAppId.getApplicationId();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final boolean isValidForAccessToken(AccessToken accessToken) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            return Intrinsics.areEqual(this.accessTokenAppId, new AccessTokenAppIdPair(accessToken));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public final void logEvent(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logEvent(str, (Bundle) null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logEventFromSE(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("_is_suggested_event", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            bundle.putString("_button_text", str2);
            logEvent(str, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logEventImplicitly(String str, Double d3, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            try {
                logEvent$default(this, str, d3, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid(), null, 32, null);
            } catch (Throwable th) {
                th = th;
                CrashShieldHandler.handleThrowable(th, this);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void logProductItem(String str, AppEventsLogger.ProductAvailability productAvailability, AppEventsLogger.ProductCondition productCondition, String str2, String str3, String str4, String str5, BigDecimal bigDecimal, Currency currency, String str6, String str7, String str8, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (str == null) {
                Companion.notifyDeveloperError("itemID cannot be null");
                return;
            }
            if (productAvailability == null) {
                Companion.notifyDeveloperError("availability cannot be null");
                return;
            }
            if (productCondition == null) {
                Companion.notifyDeveloperError("condition cannot be null");
                return;
            }
            if (str2 == null) {
                Companion.notifyDeveloperError("description cannot be null");
                return;
            }
            if (str3 == null) {
                Companion.notifyDeveloperError("imageLink cannot be null");
                return;
            }
            if (str4 == null) {
                Companion.notifyDeveloperError("link cannot be null");
                return;
            }
            if (str5 == null) {
                Companion.notifyDeveloperError("title cannot be null");
                return;
            }
            if (bigDecimal == null) {
                Companion.notifyDeveloperError("priceAmount cannot be null");
                return;
            }
            if (currency == null) {
                Companion.notifyDeveloperError("currency cannot be null");
                return;
            }
            if (str6 == null && str7 == null && str8 == null) {
                Companion.notifyDeveloperError("Either gtin, mpn or brand is required");
                return;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_ITEM_ID, str);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_AVAILABILITY, productAvailability.name());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_CONDITION, productCondition.name());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_DESCRIPTION, str2);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_IMAGE_LINK, str3);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_LINK, str4);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_TITLE, str5);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_AMOUNT, bigDecimal.setScale(3, RoundingMode.HALF_UP).toString());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_CURRENCY, currency.getCurrencyCode());
            if (str6 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_GTIN, str6);
            }
            if (str7 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_MPN, str7);
            }
            if (str8 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_BRAND, str8);
            }
            logEvent(AppEventsConstants.EVENT_NAME_PRODUCT_CATALOG_UPDATE, bundle);
            Companion.eagerFlush();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logPurchase(BigDecimal bigDecimal, Currency currency) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logPurchase(bigDecimal, currency, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logPurchaseImplicitly(BigDecimal bigDecimal, Currency currency, Bundle bundle, OperationalData operationalData) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logPurchase(bigDecimal, currency, bundle, true, operationalData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logPushNotificationOpen(Bundle payload, String str) {
        String string;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(payload, "payload");
            try {
                String string2 = payload.getString(PUSH_PAYLOAD_KEY);
                if (Utility.isNullOrEmpty(string2)) {
                    return;
                } else {
                    string = new JSONObject(string2).getString(PUSH_PAYLOAD_CAMPAIGN_KEY);
                }
            } catch (JSONException unused) {
                string = null;
            }
            if (string == null) {
                Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Malformed payload specified for logging a push notification open.");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(APP_EVENT_PUSH_PARAMETER_CAMPAIGN, string);
            if (str != null) {
                bundle.putString(APP_EVENT_PUSH_PARAMETER_ACTION, str);
            }
            logEvent(APP_EVENT_NAME_PUSH_OPENED, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logSdkEvent(String eventName, Double d3, Bundle bundle) {
        Throwable th;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                if (!StringsKt.U(eventName, ACCOUNT_KIT_EVENT_NAME_PREFIX, false, 2, null)) {
                    try {
                        Log.e(TAG, "logSdkEvent is deprecated and only supports account kit for legacy, please use logEvent instead");
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                    try {
                        logEvent$default(this, eventName, d3, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid(), null, 32, null);
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
            th = th;
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static /* synthetic */ void logEvent$default(AppEventsLoggerImpl appEventsLoggerImpl, String str, Double d3, Bundle bundle, boolean z2, UUID uuid, OperationalData operationalData, int i3, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        if ((i3 & 32) != 0) {
            operationalData = null;
        }
        try {
            appEventsLoggerImpl.logEvent(str, d3, bundle, z2, uuid, operationalData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static /* synthetic */ void logPurchase$default(AppEventsLoggerImpl appEventsLoggerImpl, BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z2, OperationalData operationalData, int i3, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        if ((i3 & 16) != 0) {
            operationalData = null;
        }
        try {
            appEventsLoggerImpl.logPurchase(bigDecimal, currency, bundle, z2, operationalData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public final void logEvent(String str, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            try {
                logEvent$default(this, str, null, bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid(), null, 32, null);
            } catch (Throwable th) {
                th = th;
                CrashShieldHandler.handleThrowable(th, this);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void logEventImplicitly(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle, OperationalData operationalData) {
        Throwable th;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (bigDecimal != null && currency != null) {
                if (bundle == null) {
                    try {
                        bundle = new Bundle();
                    } catch (Throwable th2) {
                        th = th2;
                        CrashShieldHandler.handleThrowable(th, this);
                        return;
                    }
                }
                Bundle bundle2 = bundle;
                try {
                    bundle2.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
                    logEvent(str, Double.valueOf(bigDecimal.doubleValue()), bundle2, true, ActivityLifecycleTracker.getCurrentSessionGuid(), operationalData);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    CrashShieldHandler.handleThrowable(th, this);
                    return;
                }
            }
            Utility.logd(TAG, "purchaseAmount and currency cannot be null");
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logPurchase$default(this, bigDecimal, currency, bundle, false, null, 16, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logEvent(String str, double d3) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logEvent(str, d3, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z2, OperationalData operationalData) {
        Throwable th;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (bigDecimal == null) {
                Companion.notifyDeveloperError("purchaseAmount cannot be null");
                return;
            }
            if (currency == null) {
                Companion.notifyDeveloperError("currency cannot be null");
                return;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            try {
                bundle2.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
                try {
                    logEvent(AppEventsConstants.EVENT_NAME_PURCHASED, Double.valueOf(bigDecimal.doubleValue()), bundle2, z2, ActivityLifecycleTracker.getCurrentSessionGuid(), operationalData);
                    Companion.eagerFlush();
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    CrashShieldHandler.handleThrowable(th, this);
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final void logEvent(String str, double d3, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            try {
                logEvent$default(this, str, Double.valueOf(d3), bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid(), null, 32, null);
            } catch (Throwable th) {
                th = th;
                CrashShieldHandler.handleThrowable(th, this);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void logEvent(java.lang.String r13, java.lang.Double r14, android.os.Bundle r15, boolean r16, java.util.UUID r17, com.facebook.appevents.OperationalData r18) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventsLoggerImpl.logEvent(java.lang.String, java.lang.Double, android.os.Bundle, boolean, java.util.UUID, com.facebook.appevents.OperationalData):void");
    }

    public AppEventsLoggerImpl(Context context, String str, AccessToken accessToken) {
        this(Utility.getActivityName(context), str, accessToken);
    }
}
