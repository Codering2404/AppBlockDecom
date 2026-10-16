package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ServerProtocol {
    private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
    public static final String DIALOG_CANCEL_URI = "fbconnect://cancel";
    public static final String DIALOG_HTTPS_REDIRECT_URI = "https_redirect_uri";
    public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
    public static final String DIALOG_PARAM_APP_ID = "app_id";
    public static final String DIALOG_PARAM_AUTHENTICATION_TOKEN = "id_token";
    public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
    public static final String DIALOG_PARAM_CBT = "cbt";
    public static final String DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH = "cct_over_app_switch";
    public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
    public static final String DIALOG_PARAM_CODE_CHALLENGE = "code_challenge";
    public static final String DIALOG_PARAM_CODE_CHALLENGE_METHOD = "code_challenge_method";
    public static final String DIALOG_PARAM_CODE_REDIRECT_URI = "code_redirect_uri";
    public static final String DIALOG_PARAM_CUSTOM_TABS_PREFETCHING = "cct_prefetching";
    public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
    public static final String DIALOG_PARAM_DISPLAY = "display";
    public static final String DIALOG_PARAM_DISPLAY_TOUCH = "touch";
    public static final String DIALOG_PARAM_E2E = "e2e";
    public static final String DIALOG_PARAM_FAIL_ON_LOGGED_OUT = "fail_on_logged_out";
    public static final String DIALOG_PARAM_FX_APP = "fx_app";
    public static final String DIALOG_PARAM_IES = "ies";
    public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
    public static final String DIALOG_PARAM_LOGIN_BEHAVIOR = "login_behavior";
    public static final String DIALOG_PARAM_MESSENGER_PAGE_ID = "messenger_page_id";
    public static final String DIALOG_PARAM_NONCE = "nonce";
    public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
    public static final String DIALOG_PARAM_RESET_MESSENGER_STATE = "reset_messenger_state";
    public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
    public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
    public static final String DIALOG_PARAM_SCOPE = "scope";
    public static final String DIALOG_PARAM_SDK_VERSION = "sdk";
    public static final String DIALOG_PARAM_SKIP_DEDUPE = "skip_dedupe";
    public static final String DIALOG_PARAM_SSO_DEVICE = "sso";
    public static final String DIALOG_PARAM_STATE = "state";
    public static final String DIALOG_PATH = "dialog/";
    public static final String DIALOG_REDIRECT_CHROME_OS_URI = "fbconnect://chrome_os_success";
    public static final String DIALOG_REDIRECT_URI = "fbconnect://success";
    public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
    public static final String DIALOG_RESPONSE_TYPE_CODE = "code,signed_request,graph_domain";
    public static final String DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST = "id_token,token,signed_request,graph_domain";
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES = "token,signed_request,graph_domain,granted_scopes";
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST = "token,signed_request,graph_domain";
    public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
    public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
    public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
    public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
    public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
    public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
    public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
    public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
    private static final String GAMING_DIALOG_AUTHORITY_FORMAT = "%s";
    private static final String GRAPH_URL_FORMAT = "https://graph.%s";
    private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
    public static final String INSTAGRAM_OAUTH_PATH = "oauth/authorize";
    public static final ServerProtocol INSTANCE = new ServerProtocol();
    private static final String TAG = ServerProtocol.class.getName();

    private ServerProtocol() {
    }

    @JvmStatic
    public static final String getDefaultAPIVersion() {
        return "v16.0";
    }

    @JvmStatic
    public static final String getDialogAuthority() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(DIALOG_AUTHORITY_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getFacebookDomain()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    @JvmStatic
    public static final String getErrorConnectionFailure() {
        return "CONNECTION_FAILURE";
    }

    @JvmStatic
    public static final Collection<String> getErrorsProxyAuthDisabled() {
        return CollectionsKt.listOf((Object[]) new String[]{"service_disabled", "AndroidAuthKillSwitchException"});
    }

    @JvmStatic
    public static final Collection<String> getErrorsUserCanceled() {
        return CollectionsKt.listOf((Object[]) new String[]{"access_denied", "OAuthAccessDeniedException"});
    }

    @JvmStatic
    public static final String getFacebookGraphUrlBase() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getFacebookDomain()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    @JvmStatic
    public static final String getGamingDialogAuthority() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(GAMING_DIALOG_AUTHORITY_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getFacebookGamingDomain()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    @JvmStatic
    public static final String getGraphUrlBase() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getGraphDomain()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    @JvmStatic
    public static final String getGraphUrlBaseForSubdomain(String subdomain) {
        Intrinsics.checkNotNullParameter(subdomain, "subdomain");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(new Object[]{subdomain}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    @JvmStatic
    public static final String getGraphVideoUrlBase() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(GRAPH_VIDEO_URL_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getGraphDomain()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    @JvmStatic
    public static final String getInstagramDialogAuthority() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(DIALOG_AUTHORITY_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getInstagramDomain()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    @JvmStatic
    public static final Bundle getQueryParamsForPlatformActivityIntentWebFallback(String callId, int i3, Bundle bundle) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        String applicationSignature = FacebookSdk.getApplicationSignature(FacebookSdk.getApplicationContext());
        if (Utility.isNullOrEmpty(applicationSignature)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(FALLBACK_DIALOG_PARAM_KEY_HASH, applicationSignature);
        bundle2.putString("app_id", FacebookSdk.getApplicationId());
        bundle2.putInt("version", i3);
        bundle2.putString(DIALOG_PARAM_DISPLAY, "touch");
        Bundle bundle3 = new Bundle();
        bundle3.putString("action_id", callId);
        try {
            JSONObject jSONObjectConvertToJSON = BundleJSONConverter.convertToJSON(bundle3);
            if (bundle == null) {
                bundle = new Bundle();
            }
            JSONObject jSONObjectConvertToJSON2 = BundleJSONConverter.convertToJSON(bundle);
            if (jSONObjectConvertToJSON != null && jSONObjectConvertToJSON2 != null) {
                bundle2.putString(FALLBACK_DIALOG_PARAM_BRIDGE_ARGS, jSONObjectConvertToJSON.toString());
                bundle2.putString(FALLBACK_DIALOG_PARAM_METHOD_ARGS, jSONObjectConvertToJSON2.toString());
                return bundle2;
            }
            return null;
        } catch (IllegalArgumentException e3) {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            companion.log(loggingBehavior, 6, TAG2, "Error creating Url -- " + e3);
            return null;
        } catch (JSONException e4) {
            Logger.Companion companion2 = Logger.Companion;
            LoggingBehavior loggingBehavior2 = LoggingBehavior.DEVELOPER_ERRORS;
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            companion2.log(loggingBehavior2, 6, TAG3, "Error creating Url -- " + e4);
            return null;
        }
    }
}
