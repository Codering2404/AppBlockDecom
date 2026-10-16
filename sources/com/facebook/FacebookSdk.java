package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import com.facebook.FacebookActivity;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.iap.InAppPurchaseLoggerManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AppLinkManager;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import d.qFm.sECyKyO;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
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
public final class FacebookSdk {
    public static final String ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY = "com.facebook.sdk.AdvertiserIDCollectionEnabled";
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    public static final String APPLICATION_INTENT_URI_PACKAGE_TARGET = "com.facebook.sdk.IntentUriPackageTarget";
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    public static final String APPLICATION_REDIRECT_URI = "com.facebook.sdk.RedirectURI";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    public static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    public static final String AUTO_INIT_ENABLED_PROPERTY = "com.facebook.sdk.AutoInitEnabled";
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
    public static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";
    public static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    public static final String CLOUDBRIDGE_SAVED_CREDENTIALS = "com.facebook.sdk.CloudBridgeSavedCredentials";
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";
    public static final String DATA_PROCESSING_OPTIONS = "data_processing_options";
    public static final String DATA_PROCESSING_OPTIONS_COUNTRY = "data_processing_options_country";
    public static final String DATA_PROCESSING_OPTIONS_PREFERENCES = "com.facebook.sdk.DataProcessingOptions";
    public static final String DATA_PROCESSING_OPTIONS_STATE = "data_processing_options_state";
    public static final String FB_GG = "fb.gg";
    public static final String GAMING = "gaming";
    public static final String INSTAGRAM = "instagram";
    public static final int MAX_REQUEST_CODE_RANGE = 100;
    public static final String MONITOR_ENABLED_PROPERTY = "com.facebook.sdk.MonitorEnabled";
    public static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    public static volatile String appClientToken;
    public static Context applicationContext;
    public static volatile String applicationId;
    public static volatile String applicationName;
    public static boolean bypassAppSwitch;
    public static LockOnGetVariable<File> cacheDir;
    public static volatile Boolean codelessDebugLogEnabled;
    public static Executor executor;
    public static boolean hasCustomTabsPrefetching;
    public static boolean ignoreAppSwitchToLoggedOut;
    public static String intentUriPackageTarget;
    public static volatile boolean isDebugEnabledField;
    public static boolean isFullyInitialized;
    public static boolean isLegacyTokenUpgradeSupported;
    public static String redirectURI;
    public static final FacebookSdk INSTANCE = new FacebookSdk();
    public static final String TAG = FacebookSdk.class.getCanonicalName();
    public static final HashSet<LoggingBehavior> loggingBehaviors = SetsKt.hashSetOf(LoggingBehavior.DEVELOPER_ERRORS);
    public static AtomicLong onProgressThreshold = new AtomicLong(65536);
    public static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
    public static int callbackRequestCodeOffset = DEFAULT_CALLBACK_REQUEST_CODE_OFFSET;
    public static final ReentrantLock LOCK = new ReentrantLock();
    public static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    public static final AtomicBoolean sdkInitialized = new AtomicBoolean(false);
    public static final String INSTAGRAM_COM = "instagram.com";
    public static volatile String instagramDomain = INSTAGRAM_COM;
    public static final String FACEBOOK_COM = "facebook.com";
    public static volatile String facebookDomain = FACEBOOK_COM;
    public static GraphRequestCreator graphRequestCreator = new GraphRequestCreator() { // from class: com.facebook.j
        @Override // com.facebook.FacebookSdk.GraphRequestCreator
        public final GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
            return FacebookSdk.graphRequestCreator$lambda$0(accessToken, str, jSONObject, callback);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface GraphRequestCreator {
        GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface InitializeCallback {
        void onInitialized();
    }

    @JvmStatic
    public static final void addLoggingBehavior(LoggingBehavior behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.add(behavior);
            INSTANCE.updateGraphDebugBehavior();
            Unit unit = Unit.f139807a;
        }
    }

    @JvmStatic
    public static final void clearLoggingBehaviors() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.clear();
            Unit unit = Unit.f139807a;
        }
    }

    @JvmStatic
    public static final void fullyInitialize() {
        isFullyInitialized = true;
    }

    @JvmStatic
    public static final boolean getAdvertiserIDCollectionEnabled() {
        return UserSettingsManager.getAdvertiserIDCollectionEnabled();
    }

    @JvmStatic
    public static final Context getApplicationContext() {
        Validate.sdkInitialized();
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        return null;
    }

    @JvmStatic
    public static final String getApplicationId() {
        Validate.sdkInitialized();
        String str = applicationId;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }

    @JvmStatic
    public static final String getApplicationName() {
        Validate.sdkInitialized();
        return applicationName;
    }

    @JvmStatic
    public static final String getApplicationSignature(Context context) {
        PackageManager packageManager;
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return null;
        }
        try {
            Validate.sdkInitialized();
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null && signatureArr.length != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    messageDigest.update(packageInfo.signatures[0].toByteArray());
                    return Base64.encodeToString(messageDigest.digest(), 9);
                }
            } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean getAutoInitEnabled() {
        return UserSettingsManager.getAutoInitEnabled();
    }

    @JvmStatic
    public static final boolean getAutoLogAppEventsEnabled() {
        return UserSettingsManager.getAutoLogAppEventsEnabled();
    }

    @JvmStatic
    public static final File getCacheDir() {
        Validate.sdkInitialized();
        LockOnGetVariable<File> lockOnGetVariable = cacheDir;
        if (lockOnGetVariable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheDir");
            lockOnGetVariable = null;
        }
        return lockOnGetVariable.getValue();
    }

    @JvmStatic
    public static final int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    @JvmStatic
    public static final String getClientToken() {
        Validate.sdkInitialized();
        String str = appClientToken;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
    }

    @JvmStatic
    public static final boolean getCodelessDebugLogEnabled() {
        Validate.sdkInitialized();
        Boolean bool = codelessDebugLogEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final boolean getCodelessSetupEnabled() {
        return UserSettingsManager.getCodelessSetupEnabled();
    }

    @JvmStatic
    public static final Executor getExecutor() {
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
            Executor executor2 = executor;
            if (executor2 != null) {
                return executor2;
            }
            throw new IllegalStateException("Required value was null.");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @JvmStatic
    public static final String getFacebookDomain() {
        return facebookDomain;
    }

    @JvmStatic
    public static final String getFacebookGamingDomain() {
        return "fb.gg";
    }

    @JvmStatic
    public static final String getGraphApiVersion() {
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str2 = String.format("getGraphApiVersion: %s", Arrays.copyOf(new Object[]{graphApiVersion}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        Utility.logd(str, str2);
        return graphApiVersion;
    }

    @JvmStatic
    public static final String getGraphDomain() {
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        return Utility.getGraphDomainFromTokenDomain(currentAccessToken != null ? currentAccessToken.getGraphDomain() : null);
    }

    @JvmStatic
    public static final String getInstagramDomain() {
        return instagramDomain;
    }

    @JvmStatic
    public static final String getIntentUriPackageTarget() {
        Validate.sdkInitialized();
        String str = intentUriPackageTarget;
        return str == null ? "" : str;
    }

    @JvmStatic
    public static final boolean getLimitEventAndDataUsage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Validate.sdkInitialized();
        return context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    @JvmStatic
    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> setUnmodifiableSet;
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(hashSet));
            Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(HashSet(loggingBehaviors))");
        }
        return setUnmodifiableSet;
    }

    @JvmStatic
    public static final boolean getMonitorEnabled() {
        return UserSettingsManager.getMonitorEnabled();
    }

    @JvmStatic
    public static final long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    @JvmStatic
    public static final String getRedirectURI() {
        Validate.sdkInitialized();
        String str = redirectURI;
        return str == null ? "" : str;
    }

    @JvmStatic
    public static final String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    public static final GraphRequest graphRequestCreator$lambda$0(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
        return GraphRequest.Companion.newPostRequest(accessToken, str, jSONObject, callback);
    }

    @JvmStatic
    public static final boolean isDebugEnabled() {
        return isDebugEnabledField;
    }

    @JvmStatic
    public static final boolean isFacebookRequestCode(int i3) {
        int i4 = callbackRequestCodeOffset;
        return i3 >= i4 && i3 < i4 + 100;
    }

    @JvmStatic
    public static final synchronized boolean isFullyInitialized() {
        return isFullyInitialized;
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return sdkInitialized.get();
    }

    @JvmStatic
    public static final boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isLoggingBehaviorEnabled(com.facebook.LoggingBehavior r2) {
        /*
            java.lang.String r0 = "behavior"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.util.HashSet<com.facebook.LoggingBehavior> r0 = com.facebook.FacebookSdk.loggingBehaviors
            monitor-enter(r0)
            boolean r1 = isDebugEnabled()     // Catch: java.lang.Throwable -> L16
            if (r1 == 0) goto L18
            boolean r2 = r0.contains(r2)     // Catch: java.lang.Throwable -> L16
            if (r2 == 0) goto L18
            r2 = 1
            goto L19
        L16:
            r2 = move-exception
            goto L1b
        L18:
            r2 = 0
        L19:
            monitor-exit(r0)
            return r2
        L1b:
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.isLoggingBehaviorEnabled(com.facebook.LoggingBehavior):boolean");
    }

    private final void publishInstallAndWaitForResponse(Context context, String str) {
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
                String str2 = str + "ping";
                long j3 = sharedPreferences.getLong(str2, 0L);
                try {
                    JSONObject jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.Companion.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context);
                    String installReferrer = AppEventsLoggerImpl.Companion.getInstallReferrer();
                    if (installReferrer != null) {
                        jSONObjectForGraphAPICall.put("install_referrer", installReferrer);
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                    String str3 = String.format(PUBLISH_ACTIVITY_PATH, Arrays.copyOf(new Object[]{str}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
                    GraphRequest graphRequestCreatePostRequest = graphRequestCreator.createPostRequest(null, str3, jSONObjectForGraphAPICall, null);
                    if (j3 == 0 && graphRequestCreatePostRequest.executeAndWait().getError() == null) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putLong(str2, System.currentTimeMillis());
                        editorEdit.apply();
                        Logger.Companion companion = Logger.Companion;
                        LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                        String TAG2 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        companion.log(loggingBehavior, TAG2, "MOBILE_APP_INSTALL has been logged");
                    }
                } catch (JSONException e3) {
                    throw new FacebookException("An error occurred while publishing install.", e3);
                }
            } catch (Exception e4) {
                Utility.logd("Facebook-publish", e4);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final void publishInstallAsync(Context context, final String applicationId2) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(applicationId2, "applicationId");
            final Context applicationContext2 = context.getApplicationContext();
            if (applicationContext2 == null) {
                return;
            }
            if (!FetchedAppGateKeepersManager.getGateKeeperForKey(AppEventsLoggerImpl.APP_EVENTS_KILLSWITCH, getApplicationId(), false)) {
                getExecutor().execute(new Runnable() { // from class: com.facebook.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        FacebookSdk.publishInstallAsync$lambda$15(applicationContext2, applicationId2);
                    }
                });
            }
            if (FeatureManager.isEnabled(FeatureManager.Feature.OnDeviceEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                OnDeviceProcessingManager.sendInstallEventAsync(applicationId2, ATTRIBUTION_PREFERENCES);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
        }
    }

    public static final void publishInstallAsync$lambda$15(Context applicationContext2, String applicationId2) {
        Intrinsics.checkNotNullParameter(applicationContext2, "$applicationContext");
        Intrinsics.checkNotNullParameter(applicationId2, "$applicationId");
        INSTANCE.publishInstallAndWaitForResponse(applicationContext2, applicationId2);
    }

    @JvmStatic
    public static final void removeLoggingBehavior(LoggingBehavior behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.remove(behavior);
        }
    }

    @Deprecated
    @JvmStatic
    public static final synchronized void sdkInitialize(Context applicationContext2, int i3) {
        Intrinsics.checkNotNullParameter(applicationContext2, "applicationContext");
        sdkInitialize(applicationContext2, i3, null);
    }

    public static final File sdkInitialize$lambda$3() {
        Context context = applicationContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            context = null;
        }
        return context.getCacheDir();
    }

    public static final void sdkInitialize$lambda$4(boolean z2) {
        if (z2) {
            InstrumentManager.start();
        }
    }

    public static final void sdkInitialize$lambda$5(boolean z2) {
        if (z2) {
            AppEventsManager.start();
        }
    }

    public static final void sdkInitialize$lambda$6(boolean z2) {
        if (z2) {
            hasCustomTabsPrefetching = true;
        }
    }

    public static final void sdkInitialize$lambda$7(boolean z2) {
        if (z2) {
            ignoreAppSwitchToLoggedOut = true;
        }
    }

    public static final void sdkInitialize$lambda$8(boolean z2) {
        if (z2) {
            bypassAppSwitch = true;
        }
    }

    public static final Void sdkInitialize$lambda$9(InitializeCallback initializeCallback) {
        AccessTokenManager.Companion.getInstance().loadCurrentAccessToken();
        ProfileManager.Companion.getInstance().loadCurrentProfile();
        if (AccessToken.Companion.isCurrentAccessTokenActive()) {
            Profile.Companion companion = Profile.Companion;
            if (companion.getCurrentProfile() == null) {
                companion.fetchProfileForCurrentAccessToken();
            }
        }
        if (initializeCallback != null) {
            initializeCallback.onInitialized();
        }
        AppEventsLogger.Companion companion2 = AppEventsLogger.Companion;
        companion2.initializeLib(getApplicationContext(), applicationId);
        UserSettingsManager.logIfAutoAppLinkEnabled();
        Context applicationContext2 = getApplicationContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext().applicationContext");
        companion2.newLogger(applicationContext2).flush();
        return null;
    }

    @JvmStatic
    public static final void setAdvertiserIDCollectionEnabled(boolean z2) {
        UserSettingsManager.setAdvertiserIDCollectionEnabled(z2);
    }

    @JvmStatic
    public static final void setApplicationId(String applicationId2) {
        Intrinsics.checkNotNullParameter(applicationId2, "applicationId");
        Validate.notEmpty(applicationId2, "applicationId");
        applicationId = applicationId2;
    }

    @JvmStatic
    public static final void setApplicationName(String str) {
        applicationName = str;
    }

    @JvmStatic
    public static final void setAutoInitEnabled(boolean z2) {
        UserSettingsManager.setAutoInitEnabled(z2);
        if (z2) {
            fullyInitialize();
        }
    }

    @JvmStatic
    public static final void setAutoLogAppEventsEnabled(boolean z2) {
        UserSettingsManager.setAutoLogAppEventsEnabled(z2);
        if (z2) {
            Context applicationContext2 = getApplicationContext();
            Intrinsics.checkNotNull(applicationContext2, "null cannot be cast to non-null type android.app.Application");
            ActivityLifecycleTracker.startTracking((Application) applicationContext2, getApplicationId());
        }
    }

    @JvmStatic
    public static final void setCacheDir(File cacheDir2) {
        Intrinsics.checkNotNullParameter(cacheDir2, "cacheDir");
        cacheDir = new LockOnGetVariable<>(cacheDir2);
    }

    @JvmStatic
    public static final void setClientToken(String str) {
        appClientToken = str;
    }

    @JvmStatic
    public static final void setCodelessDebugLogEnabled(boolean z2) {
        codelessDebugLogEnabled = Boolean.valueOf(z2);
    }

    @JvmStatic
    public static final void setDataProcessingOptions(String[] strArr) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        try {
            setDataProcessingOptions(strArr, 0, 0);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
        }
    }

    @JvmStatic
    public static final void setExecutor(Executor executor2) {
        Intrinsics.checkNotNullParameter(executor2, "executor");
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            executor = executor2;
            Unit unit = Unit.f139807a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @JvmStatic
    public static final void setFacebookDomain(String facebookDomain2) {
        Intrinsics.checkNotNullParameter(facebookDomain2, "facebookDomain");
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = facebookDomain2;
    }

    @JvmStatic
    public static final void setGraphApiVersion(String graphApiVersion2) {
        Intrinsics.checkNotNullParameter(graphApiVersion2, "graphApiVersion");
        Log.w(TAG, "WARNING: Calling setGraphApiVersion from non-DEBUG code.");
        if (Utility.isNullOrEmpty(graphApiVersion2) || Intrinsics.areEqual(graphApiVersion, graphApiVersion2)) {
            return;
        }
        graphApiVersion = graphApiVersion2;
    }

    @JvmStatic
    public static final void setGraphRequestCreator$facebook_core_release(GraphRequestCreator graphRequestCreator2) {
        Intrinsics.checkNotNullParameter(graphRequestCreator2, "graphRequestCreator");
        graphRequestCreator = graphRequestCreator2;
    }

    @JvmStatic
    public static final void setIsDebugEnabled(boolean z2) {
        isDebugEnabledField = z2;
    }

    @JvmStatic
    public static final void setLegacyTokenUpgradeSupported(boolean z2) {
        isLegacyTokenUpgradeSupported = z2;
    }

    @JvmStatic
    public static final void setLimitEventAndDataUsage(Context context, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z2).apply();
    }

    @JvmStatic
    public static final void setMonitorEnabled(boolean z2) {
        UserSettingsManager.setMonitorEnabled(z2);
    }

    @JvmStatic
    public static final void setOnProgressThreshold(long j3) {
        onProgressThreshold.set(j3);
    }

    private final void updateGraphDebugBehavior() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        if (hashSet.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
            if (hashSet.contains(loggingBehavior)) {
                return;
            }
            hashSet.add(loggingBehavior);
        }
    }

    @JvmStatic
    public static final void loadDefaultsFromMetadata$facebook_core_release(Context context) {
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "try {\n                co…     return\n            }");
            if (applicationInfo.metaData == null) {
                return;
            }
            if (applicationId == null) {
                Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                if (obj instanceof String) {
                    String str = (String) obj;
                    Locale ROOT = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                    String lowerCase = str.toLowerCase(ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    if (StringsKt.U(lowerCase, "fb", false, 2, null)) {
                        String strSubstring = str.substring(2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                        applicationId = strSubstring;
                    } else {
                        applicationId = str;
                    }
                } else if (obj instanceof Number) {
                    throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                }
            }
            redirectURI = applicationInfo.metaData.getString(sECyKyO.uZKHIMW);
            intentUriPackageTarget = applicationInfo.metaData.getString(APPLICATION_INTENT_URI_PACKAGE_TARGET);
            if (applicationName == null) {
                applicationName = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
            }
            if (appClientToken == null) {
                appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
            }
            if (callbackRequestCodeOffset == 64206) {
                callbackRequestCodeOffset = applicationInfo.metaData.getInt(CALLBACK_OFFSET_PROPERTY, DEFAULT_CALLBACK_REQUEST_CODE_OFFSET);
            }
            if (codelessDebugLogEnabled == null) {
                codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean(CODELESS_DEBUG_LOG_ENABLED_PROPERTY, false));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    @Deprecated
    @JvmStatic
    public static final synchronized void sdkInitialize(Context applicationContext2, int i3, InitializeCallback initializeCallback) {
        try {
            Intrinsics.checkNotNullParameter(applicationContext2, "applicationContext");
            if (sdkInitialized.get() && i3 != callbackRequestCodeOffset) {
                throw new FacebookException(CALLBACK_OFFSET_CHANGED_AFTER_INIT);
            }
            if (i3 >= 0) {
                callbackRequestCodeOffset = i3;
                sdkInitialize(applicationContext2, initializeCallback);
            } else {
                throw new FacebookException(CALLBACK_OFFSET_NEGATIVE);
            }
        } finally {
        }
    }

    @JvmStatic
    public static final void setDataProcessingOptions(String[] strArr, int i3, int i4) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        if (strArr == null) {
            try {
                strArr = new String[0];
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DATA_PROCESSING_OPTIONS, new JSONArray((Collection) ArraysKt.toList(strArr)));
            jSONObject.put(DATA_PROCESSING_OPTIONS_COUNTRY, i3);
            jSONObject.put(DATA_PROCESSING_OPTIONS_STATE, i4);
            Context context = applicationContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                context = null;
            }
            context.getSharedPreferences(DATA_PROCESSING_OPTIONS_PREFERENCES, 0).edit().putString(DATA_PROCESSING_OPTIONS, jSONObject.toString()).apply();
        } catch (JSONException unused) {
        }
    }

    @Deprecated
    @JvmStatic
    public static final synchronized void sdkInitialize(Context applicationContext2) {
        Intrinsics.checkNotNullParameter(applicationContext2, "applicationContext");
        sdkInitialize(applicationContext2, (InitializeCallback) null);
    }

    @Deprecated
    @JvmStatic
    public static final synchronized void sdkInitialize(Context applicationContext2, final InitializeCallback initializeCallback) {
        Intrinsics.checkNotNullParameter(applicationContext2, "applicationContext");
        if (sdkInitialized.get()) {
            if (initializeCallback != null) {
                initializeCallback.onInitialized();
            }
            return;
        }
        try {
            FacebookActivity.Companion companion = FacebookActivity.Companion;
            Validate.hasFacebookActivity(applicationContext2, false);
        } catch (ClassNotFoundException unused) {
        }
        Validate.hasInternetPermissions(applicationContext2, false);
        Context applicationContext3 = applicationContext2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext3, "applicationContext.applicationContext");
        applicationContext = applicationContext3;
        AppEventsLogger.Companion.getAnonymousAppDeviceGUID(applicationContext2);
        Context context = applicationContext;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            context = null;
        }
        loadDefaultsFromMetadata$facebook_core_release(context);
        String str = applicationId;
        if (str != null && str.length() != 0) {
            String str2 = appClientToken;
            if (str2 != null && str2.length() != 0) {
                sdkInitialized.set(true);
                if (getAutoInitEnabled()) {
                    fullyInitialize();
                }
                Context context3 = applicationContext;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                    context3 = null;
                }
                if ((context3 instanceof Application) && UserSettingsManager.getAutoLogAppEventsEnabled()) {
                    Context context4 = applicationContext;
                    if (context4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                        context4 = null;
                    }
                    ActivityLifecycleTracker.startTracking((Application) context4, applicationId);
                } else {
                    InAppPurchaseLoggerManager.updateLatestPossiblePurchaseTime();
                }
                AppLinkManager companion2 = AppLinkManager.Companion.getInstance();
                if (companion2 != null) {
                    Context context5 = applicationContext;
                    if (context5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                        context5 = null;
                    }
                    companion2.setupLifecycleListener((Application) context5);
                }
                FetchedAppSettingsManager.loadAppSettingsAsync();
                NativeProtocol.updateAllAvailableProtocolVersionsAsync();
                BoltsMeasurementEventListener.Companion companion3 = BoltsMeasurementEventListener.Companion;
                Context context6 = applicationContext;
                if (context6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                } else {
                    context2 = context6;
                }
                companion3.getInstance(context2);
                cacheDir = new LockOnGetVariable<>(new Callable() { // from class: com.facebook.k
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return FacebookSdk.sdkInitialize$lambda$3();
                    }
                });
                FeatureManager.checkFeature(FeatureManager.Feature.Instrument, new FeatureManager.Callback() { // from class: com.facebook.l
                    @Override // com.facebook.internal.FeatureManager.Callback
                    public final void onCompleted(boolean z2) {
                        FacebookSdk.sdkInitialize$lambda$4(z2);
                    }
                });
                FeatureManager.checkFeature(FeatureManager.Feature.AppEvents, new FeatureManager.Callback() { // from class: com.facebook.m
                    @Override // com.facebook.internal.FeatureManager.Callback
                    public final void onCompleted(boolean z2) {
                        FacebookSdk.sdkInitialize$lambda$5(z2);
                    }
                });
                FeatureManager.checkFeature(FeatureManager.Feature.ChromeCustomTabsPrefetching, new FeatureManager.Callback() { // from class: com.facebook.n
                    @Override // com.facebook.internal.FeatureManager.Callback
                    public final void onCompleted(boolean z2) {
                        FacebookSdk.sdkInitialize$lambda$6(z2);
                    }
                });
                FeatureManager.checkFeature(FeatureManager.Feature.IgnoreAppSwitchToLoggedOut, new FeatureManager.Callback() { // from class: com.facebook.o
                    @Override // com.facebook.internal.FeatureManager.Callback
                    public final void onCompleted(boolean z2) {
                        FacebookSdk.sdkInitialize$lambda$7(z2);
                    }
                });
                FeatureManager.checkFeature(FeatureManager.Feature.BypassAppSwitch, new FeatureManager.Callback() { // from class: com.facebook.p
                    @Override // com.facebook.internal.FeatureManager.Callback
                    public final void onCompleted(boolean z2) {
                        FacebookSdk.sdkInitialize$lambda$8(z2);
                    }
                });
                getExecutor().execute(new FutureTask(new Callable() { // from class: com.facebook.q
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return FacebookSdk.sdkInitialize$lambda$9(initializeCallback);
                    }
                }));
                return;
            }
            throw new FacebookException("A valid Facebook app client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk.");
        }
        throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }
}
