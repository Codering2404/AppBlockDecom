package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    private final AccessTokenSource tokenSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        this.tokenSource = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    }

    private final void completeLogin(LoginClient.Result result) {
        if (result != null) {
            getLoginClient().completeAndValidate(result);
        } else {
            getLoginClient().tryNextHandler();
        }
    }

    private final boolean isCallable(Intent intent) {
        Intrinsics.checkNotNullExpressionValue(FacebookSdk.getApplicationContext().getPackageManager().queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST), "getApplicationContext()\n…nager.MATCH_DEFAULT_ONLY)");
        return !r3.isEmpty();
    }

    private final void processSuccessResponse(final LoginClient.Request request, final Bundle bundle) {
        if (!bundle.containsKey("code") || Utility.isNullOrEmpty(bundle.getString("code"))) {
            handleResultOk(request, bundle);
        } else {
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.login.q
                @Override // java.lang.Runnable
                public final void run() {
                    NativeAppLoginMethodHandler.processSuccessResponse$lambda$0(this.f68217a, request, bundle);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processSuccessResponse$lambda$0(NativeAppLoginMethodHandler this$0, LoginClient.Request request, Bundle extras) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(extras, "$extras");
        try {
            this$0.handleResultOk(request, this$0.processCodeExchange(request, extras));
        } catch (FacebookServiceException e3) {
            FacebookRequestError requestError = e3.getRequestError();
            this$0.handleResultError(request, requestError.getErrorType(), requestError.getErrorMessage(), String.valueOf(requestError.getErrorCode()));
        } catch (FacebookException e4) {
            this$0.handleResultError(request, null, e4.getMessage(), null);
        }
    }

    protected String getError(Bundle bundle) {
        String string;
        if (bundle != null && (string = bundle.getString("error")) != null) {
            return string;
        }
        if (bundle != null) {
            return bundle.getString("error_type");
        }
        return null;
    }

    protected String getErrorMessage(Bundle bundle) {
        String string;
        if (bundle != null && (string = bundle.getString("error_message")) != null) {
            return string;
        }
        if (bundle != null) {
            return bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
        }
        return null;
    }

    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    protected void handleResultCancel(LoginClient.Request request, Intent data) {
        Object obj;
        Intrinsics.checkNotNullParameter(data, "data");
        Bundle extras = data.getExtras();
        String error = getError(extras);
        String string = (extras == null || (obj = extras.get("error_code")) == null) ? null : obj.toString();
        if (Intrinsics.areEqual(ServerProtocol.getErrorConnectionFailure(), string)) {
            completeLogin(LoginClient.Result.Companion.createErrorResult(request, error, getErrorMessage(extras), string));
        } else {
            completeLogin(LoginClient.Result.Companion.createCancelResult(request, error));
        }
    }

    protected void handleResultError(LoginClient.Request request, String str, String str2, String str3) {
        if (str != null && Intrinsics.areEqual(str, "logged_out")) {
            CustomTabLoginMethodHandler.calledThroughLoggedOutAppSwitch = true;
            completeLogin(null);
        } else if (CollectionsKt.contains(ServerProtocol.getErrorsProxyAuthDisabled(), str)) {
            completeLogin(null);
        } else if (CollectionsKt.contains(ServerProtocol.getErrorsUserCanceled(), str)) {
            completeLogin(LoginClient.Result.Companion.createCancelResult(request, null));
        } else {
            completeLogin(LoginClient.Result.Companion.createErrorResult(request, str, str2, str3));
        }
    }

    protected void handleResultOk(LoginClient.Request request, Bundle extras) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(extras, "extras");
        try {
            LoginMethodHandler.Companion companion = LoginMethodHandler.Companion;
            completeLogin(LoginClient.Result.Companion.createCompositeTokenResult(request, companion.createAccessTokenFromWebBundle(request.getPermissions(), extras, getTokenSource(), request.getApplicationId()), companion.createAuthenticationTokenFromWebBundle(extras, request.getNonce())));
        } catch (FacebookException e3) {
            completeLogin(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, request, null, e3.getMessage(), null, 8, null));
        }
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean onActivityResult(int i3, int i4, Intent intent) {
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        if (intent == null) {
            completeLogin(LoginClient.Result.Companion.createCancelResult(pendingRequest, "Operation canceled"));
        } else if (i4 == 0) {
            handleResultCancel(pendingRequest, intent);
        } else if (i4 != -1) {
            completeLogin(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, pendingRequest, "Unexpected resultCode from authorization.", null, null, 8, null));
        } else {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                completeLogin(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, pendingRequest, "Unexpected null from returned authorization data.", null, null, 8, null));
                return true;
            }
            String error = getError(extras);
            Object obj = extras.get("error_code");
            String string = obj != null ? obj.toString() : null;
            String errorMessage = getErrorMessage(extras);
            String string2 = extras.getString("e2e");
            if (!Utility.isNullOrEmpty(string2)) {
                logWebLoginCompleted(string2);
            }
            if (error == null && string == null && errorMessage == null && pendingRequest != null) {
                processSuccessResponse(pendingRequest, extras);
            } else {
                handleResultError(pendingRequest, error, errorMessage, string);
            }
        }
        return true;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public abstract int tryAuthorize(LoginClient.Request request);

    protected boolean tryIntent(Intent intent, int i3) {
        ActivityResultLauncher<Intent> launcher;
        if (intent == null || !isCallable(intent)) {
            return false;
        }
        Fragment fragment = getLoginClient().getFragment();
        Unit unit = null;
        LoginFragment loginFragment = fragment instanceof LoginFragment ? (LoginFragment) fragment : null;
        if (loginFragment != null && (launcher = loginFragment.getLauncher()) != null) {
            launcher.b(intent);
            unit = Unit.f139807a;
        }
        return unit != null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAppLoginMethodHandler(Parcel source) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        this.tokenSource = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    }
}
