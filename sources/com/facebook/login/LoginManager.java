package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginManager;
import com.google.common.cache.LSNn.vfptEEmYY;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
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
public class LoginManager {
    public static final Companion Companion;
    private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS;
    private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static final String TAG;
    private static volatile LoginManager instance;
    private boolean isFamilyLogin;
    private String messengerPageId;
    private boolean resetMessengerState;
    private final SharedPreferences sharedPreferences;
    private boolean shouldSkipAccountDeduplication;
    private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
    private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
    private LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activityContext;

        public ActivityStartActivityDelegate(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activityContext = activity;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public Activity getActivityContext() {
            return this.activityContext;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(Intent intent, int i3) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            getActivityContext().startActivityForResult(intent, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AndroidxActivityResultRegistryOwnerStartActivityDelegate implements StartActivityDelegate {
        private final ActivityResultRegistryOwner activityResultRegistryOwner;
        private final CallbackManager callbackManager;

        public AndroidxActivityResultRegistryOwnerStartActivityDelegate(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager) {
            Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
            Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
            this.activityResultRegistryOwner = activityResultRegistryOwner;
            this.callbackManager = callbackManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void startActivityForResult$lambda$0(AndroidxActivityResultRegistryOwnerStartActivityDelegate this$0, LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder launcherHolder, Pair pair) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(launcherHolder, "$launcherHolder");
            CallbackManager callbackManager = this$0.callbackManager;
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            Object obj = pair.first;
            Intrinsics.checkNotNullExpressionValue(obj, "result.first");
            callbackManager.onActivityResult(requestCode, ((Number) obj).intValue(), (Intent) pair.second);
            ActivityResultLauncher<Intent> launcher = launcherHolder.getLauncher();
            if (launcher != null) {
                launcher.d();
            }
            launcherHolder.setLauncher(null);
        }

        @Override // com.facebook.login.StartActivityDelegate
        public Activity getActivityContext() {
            Object obj = this.activityResultRegistryOwner;
            if (obj instanceof Activity) {
                return (Activity) obj;
            }
            return null;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(Intent intent, int i3) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            final LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder = new LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder();
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher(this.activityResultRegistryOwner.getActivityResultRegistry().l("facebook-login", new ActivityResultContract<Intent, Pair<Integer, Intent>>() { // from class: com.facebook.login.LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$1
                @Override // androidx.activity.result.contract.ActivityResultContract
                public Intent createIntent(Context context, Intent input) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(input, "input");
                    return input;
                }

                @Override // androidx.activity.result.contract.ActivityResultContract
                public Pair<Integer, Intent> parseResult(int i4, Intent intent2) {
                    Pair<Integer, Intent> pairCreate = Pair.create(Integer.valueOf(i4), intent2);
                    Intrinsics.checkNotNullExpressionValue(pairCreate, "create(resultCode, intent)");
                    return pairCreate;
                }
            }, new ActivityResultCallback() { // from class: com.facebook.login.p
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.startActivityForResult$lambda$0(this.f68215a, loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, (Pair) obj);
                }
            }));
            ActivityResultLauncher<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher != null) {
                launcher.b(intent);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<String> getOtherPublishPermissions() {
            return SetsKt.setOf((Object[]) new String[]{"ads_management", "create_event", "rsvp_event"});
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void handleLoginStatusError(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
            FacebookException facebookException = new FacebookException(str + ": " + str2);
            loginLogger.logLoginStatusError(str3, facebookException);
            loginStatusCallback.onError(facebookException);
        }

        @JvmStatic
        public final LoginResult computeLoginResult(LoginClient.Request request, AccessToken newToken, AuthenticationToken authenticationToken) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(newToken, "newToken");
            Set<String> permissions = request.getPermissions();
            Set mutableSet = CollectionsKt.toMutableSet(CollectionsKt.filterNotNull(newToken.getPermissions()));
            if (request.isRerequest()) {
                mutableSet.retainAll(permissions);
            }
            Set mutableSet2 = CollectionsKt.toMutableSet(CollectionsKt.filterNotNull(permissions));
            mutableSet2.removeAll(mutableSet);
            return new LoginResult(newToken, authenticationToken, mutableSet, mutableSet2);
        }

        @JvmStatic
        public final Map<String, String> getExtraDataFromIntent(Intent intent) {
            if (intent == null) {
                return null;
            }
            intent.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result == null) {
                return null;
            }
            return result.extraData;
        }

        @JvmStatic
        public LoginManager getInstance() {
            if (LoginManager.instance == null) {
                synchronized (this) {
                    LoginManager.instance = new LoginManager();
                    Unit unit = Unit.f139807a;
                }
            }
            LoginManager loginManager = LoginManager.instance;
            if (loginManager != null) {
                return loginManager;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        }

        @JvmStatic
        public final boolean isPublishPermission(String str) {
            return str != null && (StringsKt.U(str, LoginManager.PUBLISH_PERMISSION_PREFIX, false, 2, null) || StringsKt.U(str, LoginManager.MANAGE_PERMISSION_PREFIX, false, 2, null) || LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(str));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class FacebookLoginActivityResultContract extends ActivityResultContract<Collection<? extends String>, CallbackManager.ActivityResultParameters> {
        private CallbackManager callbackManager;
        private String loggerID;

        public FacebookLoginActivityResultContract(CallbackManager callbackManager, String str) {
            this.callbackManager = callbackManager;
            this.loggerID = str;
        }

        public final CallbackManager getCallbackManager() {
            return this.callbackManager;
        }

        public final String getLoggerID() {
            return this.loggerID;
        }

        public final void setCallbackManager(CallbackManager callbackManager) {
            this.callbackManager = callbackManager;
        }

        public final void setLoggerID(String str) {
            this.loggerID = str;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Collection<String> permissions) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            LoginClient.Request requestCreateLoginRequestWithConfig = LoginManager.this.createLoginRequestWithConfig(new LoginConfiguration(permissions, null, 2, null));
            String str = this.loggerID;
            if (str != null) {
                requestCreateLoginRequestWithConfig.setAuthId(str);
            }
            LoginManager.this.logStartLogin(context, requestCreateLoginRequestWithConfig);
            Intent facebookActivityIntent = LoginManager.this.getFacebookActivityIntent(requestCreateLoginRequestWithConfig);
            if (LoginManager.this.resolveIntent(facebookActivityIntent)) {
                return facebookActivityIntent;
            }
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            LoginManager.this.logCompleteLogin(context, LoginClient.Result.Code.ERROR, null, facebookException, false, requestCreateLoginRequestWithConfig);
            throw facebookException;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public CallbackManager.ActivityResultParameters parseResult(int i3, Intent intent) {
            LoginManager.onActivityResult$default(LoginManager.this, i3, intent, null, 4, null);
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            CallbackManager callbackManager = this.callbackManager;
            if (callbackManager != null) {
                callbackManager.onActivityResult(requestCode, i3, intent);
            }
            return new CallbackManager.ActivityResultParameters(requestCode, i3, intent);
        }

        public /* synthetic */ FacebookLoginActivityResultContract(LoginManager loginManager, CallbackManager callbackManager, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : callbackManager, (i3 & 2) != 0 ? null : str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final Activity activityContext;
        private final FragmentWrapper fragment;

        public FragmentStartActivityDelegate(FragmentWrapper fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.fragment = fragment;
            this.activityContext = fragment.getActivity();
        }

        @Override // com.facebook.login.StartActivityDelegate
        public Activity getActivityContext() {
            return this.activityContext;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(Intent intent, int i3) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.fragment.startActivityForResult(intent, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class LoginLoggerHolder {
        public static final LoginLoggerHolder INSTANCE = new LoginLoggerHolder();
        private static LoginLogger logger;

        private LoginLoggerHolder() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x000f A[Catch: all -> 0x0008, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:12:0x000f, B:14:0x0013, B:15:0x001e), top: B:20:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x000c A[DONT_GENERATE] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final synchronized com.facebook.login.LoginLogger getLogger(android.content.Context r3) {
            /*
                r2 = this;
                monitor-enter(r2)
                if (r3 != 0) goto La
                android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L8
                goto La
            L8:
                r3 = move-exception
                goto L22
            La:
                if (r3 != 0) goto Lf
                monitor-exit(r2)
                r3 = 0
                return r3
            Lf:
                com.facebook.login.LoginLogger r0 = com.facebook.login.LoginManager.LoginLoggerHolder.logger     // Catch: java.lang.Throwable -> L8
                if (r0 != 0) goto L1e
                com.facebook.login.LoginLogger r0 = new com.facebook.login.LoginLogger     // Catch: java.lang.Throwable -> L8
                java.lang.String r1 = com.facebook.FacebookSdk.getApplicationId()     // Catch: java.lang.Throwable -> L8
                r0.<init>(r3, r1)     // Catch: java.lang.Throwable -> L8
                com.facebook.login.LoginManager.LoginLoggerHolder.logger = r0     // Catch: java.lang.Throwable -> L8
            L1e:
                com.facebook.login.LoginLogger r3 = com.facebook.login.LoginManager.LoginLoggerHolder.logger     // Catch: java.lang.Throwable -> L8
                monitor-exit(r2)
                return r3
            L22:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L8
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginManager.LoginLoggerHolder.getLogger(android.content.Context):com.facebook.login.LoginLogger");
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        OTHER_PUBLISH_PERMISSIONS = companion.getOtherPublishPermissions();
        String string = LoginManager.class.toString();
        Intrinsics.checkNotNullExpressionValue(string, "LoginManager::class.java.toString()");
        TAG = string;
    }

    public LoginManager() {
        Validate.sdkInitialized();
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getApplicationContext().…ER, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences;
        if (!FacebookSdk.hasCustomTabsPrefetching || CustomTabUtils.getChromePackage() == null) {
            return;
        }
        CustomTabsClient.a(FacebookSdk.getApplicationContext(), "com.android.chrome", new CustomTabPrefetchHelper());
        CustomTabsClient.b(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationContext().getPackageName());
    }

    @JvmStatic
    public static final LoginResult computeLoginResult(LoginClient.Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
        return Companion.computeLoginResult(request, accessToken, authenticationToken);
    }

    public static /* synthetic */ FacebookLoginActivityResultContract createLogInActivityResultContract$default(LoginManager loginManager, CallbackManager callbackManager, String str, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogInActivityResultContract");
        }
        if ((i3 & 1) != 0) {
            callbackManager = null;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        return loginManager.createLogInActivityResultContract(callbackManager, str);
    }

    private final LoginClient.Request createLoginRequestFromResponse(GraphResponse graphResponse) {
        Set<String> permissions;
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        return createLoginRequest((accessToken == null || (permissions = accessToken.getPermissions()) == null) ? null : CollectionsKt.filterNotNull(permissions));
    }

    private final void finishLogin(AccessToken accessToken, AuthenticationToken authenticationToken, LoginClient.Request request, FacebookException facebookException, boolean z2, FacebookCallback<LoginResult> facebookCallback) {
        if (accessToken != null) {
            AccessToken.Companion.setCurrentAccessToken(accessToken);
            Profile.Companion.fetchProfileForCurrentAccessToken();
        }
        if (authenticationToken != null) {
            AuthenticationToken.Companion.setCurrentAuthenticationToken(authenticationToken);
        }
        if (facebookCallback != null) {
            LoginResult loginResultComputeLoginResult = (accessToken == null || request == null) ? null : Companion.computeLoginResult(request, accessToken, authenticationToken);
            if (z2 || (loginResultComputeLoginResult != null && loginResultComputeLoginResult.getRecentlyGrantedPermissions().isEmpty())) {
                facebookCallback.onCancel();
                return;
            }
            if (facebookException != null) {
                facebookCallback.onError(facebookException);
            } else {
                if (accessToken == null || loginResultComputeLoginResult == null) {
                    return;
                }
                setExpressLoginStatus(true);
                facebookCallback.onSuccess(loginResultComputeLoginResult);
            }
        }
    }

    @JvmStatic
    public static final Map<String, String> getExtraDataFromIntent(Intent intent) {
        return Companion.getExtraDataFromIntent(intent);
    }

    @JvmStatic
    public static LoginManager getInstance() {
        return Companion.getInstance();
    }

    private final boolean isExpressLoginAllowed() {
        return this.sharedPreferences.getBoolean(EXPRESS_LOGIN_ALLOWED, true);
    }

    @JvmStatic
    public static final boolean isPublishPermission(String str) {
        return Companion.isPublishPermission(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logCompleteLogin(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exc, boolean z2, LoginClient.Request request) {
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger == null) {
            return;
        }
        if (request == null) {
            LoginLogger.logUnexpectedError$default(logger, LoginLogger.EVENT_NAME_LOGIN_COMPLETE, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", null, 4, null);
            return;
        }
        HashMap map2 = new HashMap();
        map2.put(LoginLogger.EVENT_EXTRAS_TRY_LOGIN_ACTIVITY, z2 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        logger.logCompleteLogin(request.getAuthId(), map2, code, map, exc, request.isFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_COMPLETE : LoginLogger.EVENT_NAME_LOGIN_COMPLETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logStartLogin(Context context, LoginClient.Request request) {
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger == null || request == null) {
            return;
        }
        logger.logStartLogin(request, request.isFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_START : LoginLogger.EVENT_NAME_LOGIN_START);
    }

    private final void loginWithConfiguration(FragmentWrapper fragmentWrapper, LoginConfiguration loginConfiguration) {
        logIn(fragmentWrapper, loginConfiguration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean onActivityResult$default(LoginManager loginManager, int i3, Intent intent, FacebookCallback facebookCallback, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActivityResult");
        }
        if ((i4 & 4) != 0) {
            facebookCallback = null;
        }
        return loginManager.onActivityResult(i3, intent, facebookCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerCallback$lambda$0(LoginManager this$0, FacebookCallback facebookCallback, int i3, Intent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.onActivityResult(i3, intent, facebookCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean resolveIntent(Intent intent) {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    private final void retrieveLoginStatusImpl(Context context, final LoginStatusCallback loginStatusCallback, long j3) {
        final String applicationId = FacebookSdk.getApplicationId();
        String redirectURI = FacebookSdk.getRedirectURI();
        final String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        final LoginLogger loginLogger = new LoginLogger(context == null ? FacebookSdk.getApplicationContext() : context, applicationId);
        if (!isExpressLoginAllowed()) {
            loginLogger.logLoginStatusFailure(string);
            loginStatusCallback.onFailure();
            return;
        }
        if (redirectURI == null) {
            loginLogger.logLoginStatusFailure(string);
            loginStatusCallback.onFailure();
            return;
        }
        LoginStatusClient loginStatusClientNewInstance$facebook_common_release = LoginStatusClient.Companion.newInstance$facebook_common_release(context, applicationId, redirectURI, string, FacebookSdk.getGraphApiVersion(), j3, null);
        loginStatusClientNewInstance$facebook_common_release.setCompletedListener(new PlatformServiceClient.CompletedListener() { // from class: com.facebook.login.n
            @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
            public final void completed(Bundle bundle) {
                LoginManager.retrieveLoginStatusImpl$lambda$2(string, loginLogger, loginStatusCallback, applicationId, bundle);
            }
        });
        loginLogger.logLoginStatusStart(string);
        if (loginStatusClientNewInstance$facebook_common_release.start()) {
            return;
        }
        loginLogger.logLoginStatusFailure(string);
        loginStatusCallback.onFailure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void retrieveLoginStatusImpl$lambda$2(String loggerRef, LoginLogger logger, LoginStatusCallback responseCallback, String applicationId, Bundle bundle) {
        Intrinsics.checkNotNullParameter(loggerRef, "$loggerRef");
        Intrinsics.checkNotNullParameter(logger, "$logger");
        Intrinsics.checkNotNullParameter(responseCallback, "$responseCallback");
        Intrinsics.checkNotNullParameter(applicationId, "$applicationId");
        if (bundle == null) {
            logger.logLoginStatusFailure(loggerRef);
            responseCallback.onFailure();
            return;
        }
        String string = bundle.getString(NativeProtocol.STATUS_ERROR_TYPE);
        String string2 = bundle.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
        if (string != null) {
            Companion.handleLoginStatusError(string, string2, loggerRef, logger, responseCallback);
            return;
        }
        String string3 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0L));
        ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
        String string4 = bundle.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
        String string5 = bundle.getString("graph_domain");
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0L));
        String userIDFromSignedRequest = (string4 == null || string4.length() == 0) ? null : LoginMethodHandler.Companion.getUserIDFromSignedRequest(string4);
        if (string3 == null || string3.length() == 0 || stringArrayList == null || stringArrayList.isEmpty() || userIDFromSignedRequest == null || userIDFromSignedRequest.length() == 0) {
            logger.logLoginStatusFailure(loggerRef);
            responseCallback.onFailure();
            return;
        }
        AccessToken accessToken = new AccessToken(string3, applicationId, userIDFromSignedRequest, stringArrayList, null, null, null, bundleLongAsDate, null, bundleLongAsDate2, string5);
        AccessToken.Companion.setCurrentAccessToken(accessToken);
        Profile.Companion.fetchProfileForCurrentAccessToken();
        logger.logLoginStatusSuccess(loggerRef);
        responseCallback.onCompleted(accessToken);
    }

    private final void setExpressLoginStatus(boolean z2) {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(EXPRESS_LOGIN_ALLOWED, z2);
        editorEdit.apply();
    }

    private final void startLogin(StartActivityDelegate startActivityDelegate, LoginClient.Request request) throws FacebookException {
        logStartLogin(startActivityDelegate.getActivityContext(), request);
        CallbackManagerImpl.Companion.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.login.o
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i3, Intent intent) {
                return LoginManager.startLogin$lambda$1(this.f68214a, i3, intent);
            }
        });
        if (tryFacebookActivity(startActivityDelegate, request)) {
            return;
        }
        FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        logCompleteLogin(startActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, null, facebookException, false, request);
        throw facebookException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean startLogin$lambda$1(LoginManager this$0, int i3, Intent intent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return onActivityResult$default(this$0, i3, intent, null, 4, null);
    }

    private final boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, LoginClient.Request request) {
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.Companion.getLoginRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private final void validatePublishPermissions(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            if (!Companion.isPublishPermission(str)) {
                throw new FacebookException("Cannot pass a read permission (" + str + ") to a request for publish authorization");
            }
        }
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract() {
        return createLogInActivityResultContract$default(this, null, null, 3, null);
    }

    protected LoginClient.Request createLoginRequest(Collection<String> collection) {
        LoginBehavior loginBehavior = this.loginBehavior;
        Set set = collection != null ? CollectionsKt.toSet(collection) : null;
        DefaultAudience defaultAudience = this.defaultAudience;
        String str = this.authType;
        String applicationId = FacebookSdk.getApplicationId();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior, set, defaultAudience, str, applicationId, string, this.loginTargetApp, null, null, null, null, FacebookSdk.getRedirectURI().toString(), FacebookSdk.getIntentUriPackageTarget(), 1920, null);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    protected LoginClient.Request createLoginRequestWithConfig(LoginConfiguration loginConfig) {
        String codeVerifier;
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        CodeChallengeMethod codeChallengeMethod = CodeChallengeMethod.S256;
        try {
            codeVerifier = PKCEUtil.generateCodeChallenge(loginConfig.getCodeVerifier(), codeChallengeMethod);
        } catch (FacebookException unused) {
            codeChallengeMethod = CodeChallengeMethod.PLAIN;
            codeVerifier = loginConfig.getCodeVerifier();
        }
        CodeChallengeMethod codeChallengeMethod2 = codeChallengeMethod;
        String str = codeVerifier;
        LoginBehavior loginBehavior = this.loginBehavior;
        Set set = CollectionsKt.toSet(loginConfig.getPermissions());
        DefaultAudience defaultAudience = this.defaultAudience;
        String str2 = this.authType;
        String applicationId = FacebookSdk.getApplicationId();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior, set, defaultAudience, str2, applicationId, string, this.loginTargetApp, loginConfig.getNonce(), loginConfig.getCodeVerifier(), str, codeChallengeMethod2, FacebookSdk.getRedirectURI(), FacebookSdk.getIntentUriPackageTarget());
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    protected LoginClient.Request createReauthorizeRequest() {
        LoginBehavior loginBehavior = LoginBehavior.DIALOG_ONLY;
        HashSet hashSet = new HashSet();
        DefaultAudience defaultAudience = this.defaultAudience;
        String applicationId = FacebookSdk.getApplicationId();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior, hashSet, defaultAudience, "reauthorize", applicationId, string, this.loginTargetApp, null, null, null, null, FacebookSdk.getRedirectURI().toString(), FacebookSdk.getIntentUriPackageTarget(), 1920, null);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    public final String getAuthType() {
        return this.authType;
    }

    public final DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    protected Intent getFacebookActivityIntent(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra(LoginFragment.REQUEST_KEY, bundle);
        return intent;
    }

    public final LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    public final LoginTargetApp getLoginTargetApp() {
        return this.loginTargetApp;
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.shouldSkipAccountDeduplication;
    }

    public final boolean isFamilyLogin() {
        return this.isFamilyLogin;
    }

    public final void logIn(Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithConfiguration(Fragment fragment, LoginConfiguration loginConfig) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        loginWithConfiguration(new FragmentWrapper(fragment), loginConfig);
    }

    @Deprecated
    public final void logInWithPublishPermissions(Fragment fragment, Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), permissions);
    }

    @Deprecated
    public final void logInWithReadPermissions(Fragment fragment, Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), permissions);
    }

    public void logOut() {
        AccessToken.Companion.setCurrentAccessToken(null);
        AuthenticationToken.Companion.setCurrentAuthenticationToken(null);
        Profile.Companion.setCurrentProfile(null);
        setExpressLoginStatus(false);
    }

    public final boolean onActivityResult(int i3, Intent intent) {
        return onActivityResult$default(this, i3, intent, null, 4, null);
    }

    public final void reauthorizeDataAccess(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        startLogin(new ActivityStartActivityDelegate(activity), createReauthorizeRequest());
    }

    public final void registerCallback(CallbackManager callbackManager, final FacebookCallback<LoginResult> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.login.m
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i3, Intent intent) {
                return LoginManager.registerCallback$lambda$0(this.f68208a, facebookCallback, i3, intent);
            }
        });
    }

    public final void resolveError(Activity activity, GraphResponse response) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(response, "response");
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(response));
    }

    public final void retrieveLoginStatus(Context context, LoginStatusCallback responseCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        retrieveLoginStatus(context, 5000L, responseCallback);
    }

    public final LoginManager setAuthType(String authType) {
        Intrinsics.checkNotNullParameter(authType, "authType");
        this.authType = authType;
        return this;
    }

    public final LoginManager setDefaultAudience(DefaultAudience defaultAudience) {
        Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
        this.defaultAudience = defaultAudience;
        return this;
    }

    public final LoginManager setFamilyLogin(boolean z2) {
        this.isFamilyLogin = z2;
        return this;
    }

    public final LoginManager setLoginBehavior(LoginBehavior loginBehavior) {
        Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
        this.loginBehavior = loginBehavior;
        return this;
    }

    public final LoginManager setLoginTargetApp(LoginTargetApp targetApp) {
        Intrinsics.checkNotNullParameter(targetApp, "targetApp");
        this.loginTargetApp = targetApp;
        return this;
    }

    public final LoginManager setMessengerPageId(String str) {
        this.messengerPageId = str;
        return this;
    }

    public final LoginManager setResetMessengerState(boolean z2) {
        this.resetMessengerState = z2;
        return this;
    }

    public final LoginManager setShouldSkipAccountDeduplication(boolean z2) {
        this.shouldSkipAccountDeduplication = z2;
        return this;
    }

    public final void unregisterCallback(CallbackManager callbackManager) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
    }

    private final void validateReadPermissions(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            if (Companion.isPublishPermission(str)) {
                throw new FacebookException(vfptEEmYY.VdVKBEt + str + ") to a request for read authorization");
            }
        }
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract(CallbackManager callbackManager) {
        return createLogInActivityResultContract$default(this, callbackManager, null, 2, null);
    }

    public final void logIn(Fragment fragment, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logInWithPublishPermissions(Fragment fragment, CallbackManager callbackManager, Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithPublishPermissions(activity, callbackManager, permissions);
            return;
        }
        throw new FacebookException("Cannot obtain activity context on the fragment " + fragment);
    }

    public final void logInWithReadPermissions(Fragment fragment, CallbackManager callbackManager, Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithReadPermissions(activity, callbackManager, permissions);
            return;
        }
        throw new FacebookException("Cannot obtain activity context on the fragment " + fragment);
    }

    public final void loginWithConfiguration(Activity activity, LoginConfiguration loginConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        logIn(activity, loginConfig);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onActivityResult(int r16, android.content.Intent r17, com.facebook.FacebookCallback<com.facebook.login.LoginResult> r18) {
        /*
            r15 = this;
            r0 = r16
            r1 = r17
            com.facebook.login.LoginClient$Result$Code r2 = com.facebook.login.LoginClient.Result.Code.ERROR
            r3 = 1
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L47
            java.lang.Class<com.facebook.login.LoginClient$Result> r6 = com.facebook.login.LoginClient.Result.class
            java.lang.ClassLoader r6 = r6.getClassLoader()
            r1.setExtrasClassLoader(r6)
            java.lang.String r6 = "com.facebook.LoginFragment:Result"
            android.os.Parcelable r1 = r1.getParcelableExtra(r6)
            com.facebook.login.LoginClient$Result r1 = (com.facebook.login.LoginClient.Result) r1
            if (r1 == 0) goto L52
            com.facebook.login.LoginClient$Request r2 = r1.request
            com.facebook.login.LoginClient$Result$Code r6 = r1.code
            r7 = -1
            if (r0 == r7) goto L2c
            if (r0 == 0) goto L2a
        L27:
            r0 = r4
            r7 = r0
            goto L3f
        L2a:
            r5 = r3
            goto L27
        L2c:
            com.facebook.login.LoginClient$Result$Code r0 = com.facebook.login.LoginClient.Result.Code.SUCCESS
            if (r6 != r0) goto L35
            com.facebook.AccessToken r0 = r1.token
            com.facebook.AuthenticationToken r7 = r1.authenticationToken
            goto L3f
        L35:
            com.facebook.FacebookAuthorizationException r0 = new com.facebook.FacebookAuthorizationException
            java.lang.String r7 = r1.errorMessage
            r0.<init>(r7)
            r7 = r4
            r4 = r0
            r0 = r7
        L3f:
            java.util.Map<java.lang.String, java.lang.String> r1 = r1.loggingExtras
            r8 = r1
            r11 = r2
            r13 = r5
            r1 = r7
            r7 = r6
            goto L58
        L47:
            if (r0 != 0) goto L52
            com.facebook.login.LoginClient$Result$Code r2 = com.facebook.login.LoginClient.Result.Code.CANCEL
            r7 = r2
            r13 = r3
            r0 = r4
            r1 = r0
            r8 = r1
            r11 = r8
            goto L58
        L52:
            r7 = r2
            r0 = r4
            r1 = r0
            r8 = r1
            r11 = r8
            r13 = r5
        L58:
            if (r4 != 0) goto L65
            if (r0 != 0) goto L65
            if (r13 != 0) goto L65
            com.facebook.FacebookException r4 = new com.facebook.FacebookException
            java.lang.String r2 = "Unexpected call to LoginManager.onActivityResult"
            r4.<init>(r2)
        L65:
            r12 = r4
            r10 = 1
            r6 = 0
            r5 = r15
            r9 = r12
            r5.logCompleteLogin(r6, r7, r8, r9, r10, r11)
            r14 = r18
            r10 = r1
            r8 = r5
            r9 = r0
            r8.finishLogin(r9, r10, r11, r12, r13, r14)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginManager.onActivityResult(int, android.content.Intent, com.facebook.FacebookCallback):boolean");
    }

    @Deprecated
    public final void resolveError(Fragment fragment, GraphResponse response) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(response, "response");
        resolveError(new FragmentWrapper(fragment), response);
    }

    public final void retrieveLoginStatus(Context context, long j3, LoginStatusCallback responseCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        retrieveLoginStatusImpl(context, responseCallback, j3);
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract(CallbackManager callbackManager, String str) {
        return new FacebookLoginActivityResultContract(callbackManager, str);
    }

    public final void logIn(android.app.Fragment fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void reauthorizeDataAccess(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        reauthorizeDataAccess(new FragmentWrapper(fragment));
    }

    public final void resolveError(Fragment fragment, CallbackManager callbackManager, GraphResponse response) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(response, "response");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            resolveError(activity, callbackManager, response);
            return;
        }
        throw new FacebookException("Cannot obtain activity context on the fragment " + fragment);
    }

    private final void reauthorizeDataAccess(FragmentWrapper fragmentWrapper) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createReauthorizeRequest());
    }

    public final void logIn(android.app.Fragment fragment, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logIn(FragmentWrapper fragment, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        logIn(fragment, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithPublishPermissions(android.app.Fragment fragment, Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), permissions);
    }

    public final void logInWithReadPermissions(android.app.Fragment fragment, Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), permissions);
    }

    private final void logInWithPublishPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validatePublishPermissions(collection);
        loginWithConfiguration(fragmentWrapper, new LoginConfiguration(collection, null, 2, null));
    }

    private final void logInWithReadPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validateReadPermissions(collection);
        logIn(fragmentWrapper, new LoginConfiguration(collection, null, 2, null));
    }

    public final void resolveError(android.app.Fragment fragment, GraphResponse response) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(response, "response");
        resolveError(new FragmentWrapper(fragment), response);
    }

    private final void resolveError(FragmentWrapper fragmentWrapper, GraphResponse graphResponse) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestFromResponse(graphResponse));
    }

    public final void logIn(FragmentWrapper fragment, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        LoginClient.Request requestCreateLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, null, 2, null));
        if (str != null) {
            requestCreateLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new FragmentStartActivityDelegate(fragment), requestCreateLoginRequestWithConfig);
    }

    public final void resolveError(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, GraphResponse response) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(response, "response");
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestFromResponse(response));
    }

    public final void logInWithPublishPermissions(Activity activity, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        validatePublishPermissions(collection);
        loginWithConfiguration(activity, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithReadPermissions(Activity activity, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        validateReadPermissions(collection);
        logIn(activity, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logIn(Activity activity, Collection<String> collection) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        logIn(activity, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithPublishPermissions(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        validatePublishPermissions(permissions);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logInWithReadPermissions(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        validateReadPermissions(permissions);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logIn(FragmentWrapper fragment, LoginConfiguration loginConfig) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        startLogin(new FragmentStartActivityDelegate(fragment), createLoginRequestWithConfig(loginConfig));
    }

    public final void logIn(Activity activity, LoginConfiguration loginConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loginConfig, "loginConfig");
        if (activity instanceof ActivityResultRegistryOwner) {
            Log.w(TAG, "You're calling logging in Facebook with an activity supports androidx activity result APIs. Please follow our document to upgrade to new APIs to avoid overriding onActivityResult().");
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig(loginConfig));
    }

    public final void logIn(Activity activity, Collection<String> collection, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoginClient.Request requestCreateLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, null, 2, null));
        if (str != null) {
            requestCreateLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new ActivityStartActivityDelegate(activity), requestCreateLoginRequestWithConfig);
    }

    private final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, LoginConfiguration loginConfiguration) {
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> permissions, String str) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        LoginClient.Request requestCreateLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(permissions, null, 2, null));
        if (str != null) {
            requestCreateLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), requestCreateLoginRequestWithConfig);
    }

    public final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(activityResultRegistryOwner, "activityResultRegistryOwner");
        Intrinsics.checkNotNullParameter(callbackManager, "callbackManager");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }
}
