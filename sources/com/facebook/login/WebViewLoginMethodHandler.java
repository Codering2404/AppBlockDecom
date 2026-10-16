package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;
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
public class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    private static final String OAUTH_DIALOG = "oauth";
    private String e2e;
    private WebDialog loginDialog;
    private final String nameForLogging;
    private final AccessTokenSource tokenSource;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new Parcelable.Creator<WebViewLoginMethodHandler>() { // from class: com.facebook.login.WebViewLoginMethodHandler$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WebViewLoginMethodHandler createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new WebViewLoginMethodHandler(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WebViewLoginMethodHandler[] newArray(int i3) {
            return new WebViewLoginMethodHandler[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class AuthDialogBuilder extends WebDialog.Builder {
        public String authType;
        public String e2e;
        private boolean isFamilyLogin;
        private LoginBehavior loginBehavior;
        private LoginClient.Request originalRequest;
        private String redirect_uri;
        private boolean shouldSkipDedupe;
        private LoginTargetApp targetApp;
        final /* synthetic */ WebViewLoginMethodHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthDialogBuilder(WebViewLoginMethodHandler webViewLoginMethodHandler, Context context, String applicationId, Bundle parameters, LoginClient.Request request) {
            super(context, applicationId, "oauth", parameters);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            Intrinsics.checkNotNullParameter(request, "request");
            this.this$0 = webViewLoginMethodHandler;
            this.redirect_uri = ServerProtocol.DIALOG_REDIRECT_URI;
            this.loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
            this.targetApp = LoginTargetApp.FACEBOOK;
            this.originalRequest = request;
        }

        @Override // com.facebook.internal.WebDialog.Builder
        public WebDialog build() {
            Bundle parameters = getParameters();
            Intrinsics.checkNotNull(parameters, "null cannot be cast to non-null type android.os.Bundle");
            String redirectURI = this.originalRequest.getRedirectURI();
            boolean z2 = redirectURI == null || redirectURI.length() == 0;
            if (!parameters.containsKey(ServerProtocol.DIALOG_PARAM_REDIRECT_URI)) {
                parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.redirect_uri);
            }
            parameters.putString("client_id", getApplicationId());
            parameters.putString("e2e", getE2e());
            parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, this.targetApp == LoginTargetApp.INSTAGRAM ? ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES : ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
            parameters.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            parameters.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, getAuthType());
            parameters.putString("login_behavior", this.loginBehavior.name());
            if (this.isFamilyLogin) {
                parameters.putString(ServerProtocol.DIALOG_PARAM_FX_APP, this.targetApp.toString());
            }
            if (this.shouldSkipDedupe) {
                parameters.putString(ServerProtocol.DIALOG_PARAM_SKIP_DEDUPE, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            if (z2) {
                WebDialog.Companion companion = WebDialog.Companion;
                Context context = getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.content.Context");
                return companion.newInstance(context, "oauth", parameters, getTheme(), this.targetApp, getListener());
            }
            CustomRedirectWebDialog.Companion companion2 = CustomRedirectWebDialog.Companion;
            Context context2 = getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.content.Context");
            int theme = getTheme();
            LoginTargetApp loginTargetApp = this.targetApp;
            WebDialog.OnCompleteListener listener = getListener();
            String redirectURI2 = this.originalRequest.getRedirectURI();
            Intrinsics.checkNotNull(redirectURI2);
            return companion2.create(context2, "oauth", parameters, theme, loginTargetApp, listener, redirectURI2);
        }

        public final String getAuthType() {
            String str = this.authType;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("authType");
            return null;
        }

        public final String getE2e() {
            String str = this.e2e;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("e2e");
            return null;
        }

        /* JADX INFO: renamed from: setAuthType, reason: collision with other method in class */
        public final void m370setAuthType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authType = str;
        }

        public final AuthDialogBuilder setE2E(String e2e) {
            Intrinsics.checkNotNullParameter(e2e, "e2e");
            setE2e(e2e);
            return this;
        }

        public final void setE2e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.e2e = str;
        }

        public final AuthDialogBuilder setFamilyLogin(boolean z2) {
            this.isFamilyLogin = z2;
            return this;
        }

        public final AuthDialogBuilder setIsChromeOS(boolean z2) {
            this.redirect_uri = z2 ? ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI : ServerProtocol.DIALOG_REDIRECT_URI;
            return this;
        }

        public final AuthDialogBuilder setLoginBehavior(LoginBehavior loginBehavior) {
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            this.loginBehavior = loginBehavior;
            return this;
        }

        public final AuthDialogBuilder setLoginTargetApp(LoginTargetApp targetApp) {
            Intrinsics.checkNotNullParameter(targetApp, "targetApp");
            this.targetApp = targetApp;
            return this;
        }

        public final AuthDialogBuilder setShouldSkipDedupe(boolean z2) {
            this.shouldSkipDedupe = z2;
            return this;
        }

        public final AuthDialogBuilder setAuthType(String authType) {
            Intrinsics.checkNotNullParameter(authType, "authType");
            m370setAuthType(authType);
            return this;
        }

        public final AuthDialogBuilder setIsRerequest(boolean z2) {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class CustomRedirectWebDialog extends WebDialog {
        public static final Companion Companion = new Companion(null);
        private final String customRedirectUri;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LoginTargetApp.values().length];
                    try {
                        iArr[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final WebDialog create(Context context, String str, Bundle bundle, int i3, LoginTargetApp targetApp, WebDialog.OnCompleteListener onCompleteListener, String customRedirectUri) {
                Uri uriBuildUri;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(targetApp, "targetApp");
                Intrinsics.checkNotNullParameter(customRedirectUri, "customRedirectUri");
                if (bundle == null) {
                    bundle = new Bundle();
                }
                Bundle bundle2 = new Bundle(bundle);
                bundle2.putString(ServerProtocol.DIALOG_PARAM_DISPLAY, "touch");
                bundle2.putString("client_id", FacebookSdk.getApplicationId());
                bundle2.putString("sdk", "android-" + FacebookSdk.getSdkVersion());
                if (WhenMappings.$EnumSwitchMapping$0[targetApp.ordinal()] == 1) {
                    uriBuildUri = Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), ServerProtocol.INSTAGRAM_OAUTH_PATH, bundle2);
                } else {
                    uriBuildUri = Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + str, bundle2);
                }
                WebDialog.Companion companion = WebDialog.Companion;
                WebDialog.initDefaultTheme(context);
                String string = uriBuildUri.toString();
                Intrinsics.checkNotNullExpressionValue(string, "uri.toString()");
                CustomRedirectWebDialog customRedirectWebDialog = new CustomRedirectWebDialog(context, string, customRedirectUri);
                customRedirectWebDialog.setOnCompleteListener(onCompleteListener);
                return customRedirectWebDialog;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomRedirectWebDialog(Context context, String url, String customRedirectUri) {
            super(context, url);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(customRedirectUri, "customRedirectUri");
            this.customRedirectUri = customRedirectUri;
            setExpectedRedirectUrl(customRedirectUri);
        }

        @Override // com.facebook.internal.WebDialog
        public Bundle parseResponseUri(String str) {
            if (str == null || this.customRedirectUri.length() <= 0 || !StringsKt.U(str, this.customRedirectUri, false, 2, null)) {
                return super.parseResponseUri(str);
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                getContext().startActivity(intent);
                dismiss();
            } catch (Exception e3) {
                sendErrorToListener(new FacebookDialogException("Failed to launch custom redirect: " + e3.getMessage(), -1, str));
            }
            return new Bundle();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        this.nameForLogging = "web_view";
        this.tokenSource = AccessTokenSource.WEB_VIEW;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void cancel() {
        WebDialog webDialog = this.loginDialog;
        if (webDialog != null) {
            if (webDialog != null) {
                webDialog.cancel();
            }
            this.loginDialog = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getE2e() {
        return this.e2e;
    }

    public final WebDialog getLoginDialog() {
        return this.loginDialog;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean needsInternetPermission() {
        return true;
    }

    public final void onWebDialogComplete(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(request, "request");
        super.onComplete(request, bundle, facebookException);
    }

    public final void setE2e(String str) {
        this.e2e = str;
    }

    public final void setLoginDialog(WebDialog webDialog) {
        this.loginDialog = webDialog;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int tryAuthorize(final LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Bundle bundleAddExtraParameters = addExtraParameters(getParameters(request), request);
        WebDialog.OnCompleteListener onCompleteListener = new WebDialog.OnCompleteListener() { // from class: com.facebook.login.WebViewLoginMethodHandler$tryAuthorize$listener$1
            @Override // com.facebook.internal.WebDialog.OnCompleteListener
            public void onComplete(Bundle bundle, FacebookException facebookException) {
                this.this$0.onWebDialogComplete(request, bundle, facebookException);
            }
        };
        String e2e = LoginClient.Companion.getE2E();
        this.e2e = e2e;
        addLoggingExtra("e2e", e2e);
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity == null) {
            return 0;
        }
        boolean zIsChromeOS = Utility.isChromeOS(activity);
        AuthDialogBuilder authDialogBuilder = new AuthDialogBuilder(this, activity, request.getApplicationId(), bundleAddExtraParameters, request);
        String str = this.e2e;
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type kotlin.String");
        this.loginDialog = authDialogBuilder.setE2E(str).setIsChromeOS(zIsChromeOS).setAuthType(request.getAuthType()).setLoginBehavior(request.getLoginBehavior()).setLoginTargetApp(request.getLoginTargetApp()).setFamilyLogin(request.isFamilyLogin()).setShouldSkipDedupe(request.shouldSkipAccountDeduplication()).setOnCompleteListener(onCompleteListener).build();
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.setRetainInstance(true);
        facebookDialogFragment.setInnerDialog(this.loginDialog);
        facebookDialogFragment.show(activity.getSupportFragmentManager(), FacebookDialogFragment.TAG);
        return 1;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        super.writeToParcel(dest, i3);
        dest.writeString(this.e2e);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(Parcel source) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        this.nameForLogging = "web_view";
        this.tokenSource = AccessTokenSource.WEB_VIEW;
        this.e2e = source.readString();
    }
}
