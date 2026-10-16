package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import kotlin.Metadata;
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
public abstract class WebLoginMethodHandler extends LoginMethodHandler {
    public static final Companion Companion = new Companion(null);
    private static final String WEB_VIEW_AUTH_HANDLER_STORE = "com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY";
    private static final String WEB_VIEW_AUTH_HANDLER_TOKEN_KEY = "TOKEN";
    private String e2e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
    }

    private final String loadCookieToken() {
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            activity = FacebookSdk.getApplicationContext();
        }
        return activity.getSharedPreferences(WEB_VIEW_AUTH_HANDLER_STORE, 0).getString(WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, "");
    }

    private final void saveCookieToken(String str) {
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            activity = FacebookSdk.getApplicationContext();
        }
        activity.getSharedPreferences(WEB_VIEW_AUTH_HANDLER_STORE, 0).edit().putString(WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, str).apply();
    }

    protected Bundle addExtraParameters(Bundle parameters, LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(request, "request");
        String redirectURI = request.getRedirectURI();
        parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, (redirectURI == null || redirectURI.length() == 0) ? getRedirectUrl() : request.getRedirectURI());
        if (request.isInstagramLogin()) {
            parameters.putString("app_id", request.getApplicationId());
        } else {
            parameters.putString("client_id", request.getApplicationId());
        }
        parameters.putString("e2e", LoginClient.Companion.getE2E());
        if (request.isInstagramLogin()) {
            parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES);
        } else {
            if (request.getPermissions().contains(LoginConfiguration.OPENID)) {
                parameters.putString("nonce", request.getNonce());
            }
            parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST);
        }
        parameters.putString(ServerProtocol.DIALOG_PARAM_CODE_CHALLENGE, request.getCodeChallenge());
        CodeChallengeMethod codeChallengeMethod = request.getCodeChallengeMethod();
        parameters.putString(ServerProtocol.DIALOG_PARAM_CODE_CHALLENGE_METHOD, codeChallengeMethod != null ? codeChallengeMethod.name() : null);
        parameters.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        parameters.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, request.getAuthType());
        parameters.putString("login_behavior", request.getLoginBehavior().name());
        parameters.putString("sdk", "android-" + FacebookSdk.getSdkVersion());
        if (getSSODevice() != null) {
            parameters.putString(ServerProtocol.DIALOG_PARAM_SSO_DEVICE, getSSODevice());
        }
        boolean z2 = FacebookSdk.hasCustomTabsPrefetching;
        String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        parameters.putString(ServerProtocol.DIALOG_PARAM_CUSTOM_TABS_PREFETCHING, z2 ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (request.isFamilyLogin()) {
            parameters.putString(ServerProtocol.DIALOG_PARAM_FX_APP, request.getLoginTargetApp().toString());
        }
        if (request.shouldSkipAccountDeduplication()) {
            parameters.putString(ServerProtocol.DIALOG_PARAM_SKIP_DEDUPE, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        }
        if (request.getMessengerPageId() != null) {
            parameters.putString(ServerProtocol.DIALOG_PARAM_MESSENGER_PAGE_ID, request.getMessengerPageId());
            if (request.getResetMessengerState()) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            }
            parameters.putString(ServerProtocol.DIALOG_PARAM_RESET_MESSENGER_STATE, str);
        }
        return parameters;
    }

    protected Bundle getParameters(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Bundle bundle = new Bundle();
        if (!Utility.isNullOrEmpty(request.getPermissions())) {
            String strJoin = TextUtils.join(",", request.getPermissions());
            bundle.putString("scope", strJoin);
            addLoggingExtra("scope", strJoin);
        }
        DefaultAudience defaultAudience = request.getDefaultAudience();
        if (defaultAudience == null) {
            defaultAudience = DefaultAudience.NONE;
        }
        bundle.putString("default_audience", defaultAudience.getNativeProtocolAudience());
        bundle.putString(ServerProtocol.DIALOG_PARAM_STATE, getClientState(request.getAuthId()));
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        String token = currentAccessToken != null ? currentAccessToken.getToken() : null;
        String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        if (token == null || !Intrinsics.areEqual(token, loadCookieToken())) {
            FragmentActivity activity = getLoginClient().getActivity();
            if (activity != null) {
                Utility.clearFacebookCookies(activity);
            }
            addLoggingExtra("access_token", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            bundle.putString("access_token", token);
            addLoggingExtra("access_token", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        bundle.putString(ServerProtocol.DIALOG_PARAM_CBT, String.valueOf(System.currentTimeMillis()));
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        bundle.putString(ServerProtocol.DIALOG_PARAM_IES, str);
        return bundle;
    }

    protected String getSSODevice() {
        return null;
    }

    public abstract AccessTokenSource getTokenSource();

    public void onComplete(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        String strValueOf;
        LoginClient.Result resultCreateErrorResult;
        String strValueOf2;
        Intrinsics.checkNotNullParameter(request, "request");
        LoginClient loginClient = getLoginClient();
        this.e2e = null;
        String redirectURI = request.getRedirectURI();
        if (redirectURI != null && redirectURI.length() != 0 && !Intrinsics.areEqual(request.getRedirectURI(), getRedirectUrl())) {
            if (facebookException instanceof FacebookOperationCanceledException) {
                loginClient.completeAndValidate(LoginClient.Result.Companion.createCancelResult(loginClient.getPendingRequest(), LoginMethodHandler.USER_CANCELED_LOG_IN_ERROR_MESSAGE));
                return;
            }
            if (facebookException != null) {
                this.e2e = null;
                String message = facebookException.getMessage();
                if (facebookException instanceof FacebookServiceException) {
                    FacebookRequestError requestError = ((FacebookServiceException) facebookException).getRequestError();
                    strValueOf2 = String.valueOf(requestError.getErrorCode());
                    message = requestError.toString();
                } else {
                    strValueOf2 = null;
                }
                loginClient.completeAndValidate(LoginClient.Result.Companion.createErrorResult(loginClient.getPendingRequest(), null, message, strValueOf2));
                return;
            }
            return;
        }
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.e2e = bundle.getString("e2e");
            }
            try {
                LoginMethodHandler.Companion companion = LoginMethodHandler.Companion;
                AccessToken accessTokenCreateAccessTokenFromWebBundle = companion.createAccessTokenFromWebBundle(request.getPermissions(), bundle, getTokenSource(), request.getApplicationId());
                resultCreateErrorResult = LoginClient.Result.Companion.createCompositeTokenResult(loginClient.getPendingRequest(), accessTokenCreateAccessTokenFromWebBundle, companion.createAuthenticationTokenFromWebBundle(bundle, request.getNonce()));
                if (loginClient.getActivity() != null) {
                    try {
                        CookieSyncManager.createInstance(loginClient.getActivity()).sync();
                    } catch (Exception unused) {
                    }
                    if (accessTokenCreateAccessTokenFromWebBundle != null) {
                        saveCookieToken(accessTokenCreateAccessTokenFromWebBundle.getToken());
                    }
                }
            } catch (FacebookException e3) {
                resultCreateErrorResult = LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, loginClient.getPendingRequest(), null, e3.getMessage(), null, 8, null);
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            resultCreateErrorResult = LoginClient.Result.Companion.createCancelResult(loginClient.getPendingRequest(), LoginMethodHandler.USER_CANCELED_LOG_IN_ERROR_MESSAGE);
        } else {
            this.e2e = null;
            String message2 = facebookException != null ? facebookException.getMessage() : null;
            if (facebookException instanceof FacebookServiceException) {
                FacebookRequestError requestError2 = ((FacebookServiceException) facebookException).getRequestError();
                strValueOf = String.valueOf(requestError2.getErrorCode());
                message2 = requestError2.toString();
            } else {
                strValueOf = null;
            }
            resultCreateErrorResult = LoginClient.Result.Companion.createErrorResult(loginClient.getPendingRequest(), null, message2, strValueOf);
        }
        if (!Utility.isNullOrEmpty(this.e2e)) {
            logWebLoginCompleted(this.e2e);
        }
        loginClient.completeAndValidate(resultCreateErrorResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebLoginMethodHandler(Parcel source) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
    }
}
