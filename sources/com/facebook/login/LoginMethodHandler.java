package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
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
public abstract class LoginMethodHandler implements Parcelable {
    public static final Companion Companion = new Companion(null);
    public static final String NO_SIGNED_REQUEST_ERROR_MESSAGE = "Authorization response does not contain the signed_request";
    public static final String NO_USER_ID_ERROR_MESSAGE = "Failed to retrieve user_id from signed_request";
    public static final String USER_CANCELED_LOG_IN_ERROR_MESSAGE = "User canceled log in.";
    public LoginClient loginClient;
    private Map<String, String> methodLoggingExtras;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource, String applicationId) {
            String string;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0L));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string2 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0L));
            if (string2 == null || string2.length() == 0 || (string = bundle.getString(NativeProtocol.EXTRA_USER_ID)) == null || string.length() == 0) {
                return null;
            }
            return new AccessToken(string2, applicationId, string, stringArrayList, null, null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString("graph_domain"));
        }

        @JvmStatic
        public final AccessToken createAccessTokenFromWebBundle(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String applicationId) throws FacebookException {
            Collection<String> collectionArrayListOf;
            ArrayList arrayListArrayListOf;
            ArrayList arrayListArrayListOf2;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, AccessToken.EXPIRES_IN_KEY, new Date());
            String string = bundle.getString("access_token");
            if (string == null) {
                return null;
            }
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0L));
            String string2 = bundle.getString("granted_scopes");
            if (string2 == null || string2.length() <= 0) {
                collectionArrayListOf = collection;
            } else {
                String[] strArr = (String[]) StringsKt.V0(string2, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
                collectionArrayListOf = CollectionsKt.arrayListOf(Arrays.copyOf(strArr, strArr.length));
            }
            String string3 = bundle.getString("denied_scopes");
            if (string3 == null || string3.length() <= 0) {
                arrayListArrayListOf = null;
            } else {
                String[] strArr2 = (String[]) StringsKt.V0(string3, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
                arrayListArrayListOf = CollectionsKt.arrayListOf(Arrays.copyOf(strArr2, strArr2.length));
            }
            String string4 = bundle.getString("expired_scopes");
            if (string4 == null || string4.length() <= 0) {
                arrayListArrayListOf2 = null;
            } else {
                String[] strArr3 = (String[]) StringsKt.V0(string4, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
                arrayListArrayListOf2 = CollectionsKt.arrayListOf(Arrays.copyOf(strArr3, strArr3.length));
            }
            if (Utility.isNullOrEmpty(string)) {
                return null;
            }
            return new AccessToken(string, applicationId, getUserIDFromSignedRequest(bundle.getString("signed_request")), collectionArrayListOf, arrayListArrayListOf, arrayListArrayListOf2, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString("graph_domain"));
        }

        @JvmStatic
        public final AuthenticationToken createAuthenticationTokenFromNativeLogin(Bundle bundle, String str) throws FacebookException {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString(NativeProtocol.EXTRA_AUTHENTICATION_TOKEN);
            if (string == null || string.length() == 0 || str == null || str.length() == 0) {
                return null;
            }
            try {
                return new AuthenticationToken(string, str);
            } catch (Exception e3) {
                throw new FacebookException(e3.getMessage());
            }
        }

        @JvmStatic
        public final AuthenticationToken createAuthenticationTokenFromWebBundle(Bundle bundle, String str) throws FacebookException {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString("id_token");
            if (string == null || string.length() == 0 || str == null || str.length() == 0) {
                return null;
            }
            try {
                return new AuthenticationToken(string, str);
            } catch (Exception e3) {
                throw new FacebookException(e3.getMessage(), e3);
            }
        }

        @JvmStatic
        public final String getUserIDFromSignedRequest(String str) throws FacebookException {
            if (str == null || str.length() == 0) {
                throw new FacebookException(LoginMethodHandler.NO_SIGNED_REQUEST_ERROR_MESSAGE);
            }
            try {
                String[] strArr = (String[]) StringsKt.V0(str, new String[]{"."}, false, 0, 6, null).toArray(new String[0]);
                if (strArr.length == 2) {
                    byte[] data = Base64.decode(strArr[1], 0);
                    Intrinsics.checkNotNullExpressionValue(data, "data");
                    String string = new JSONObject(new String(data, Charsets.f140510b)).getString("user_id");
                    Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"user_id\")");
                    return string;
                }
            } catch (UnsupportedEncodingException | JSONException unused) {
            }
            throw new FacebookException(LoginMethodHandler.NO_USER_ID_ERROR_MESSAGE);
        }

        private Companion() {
        }
    }

    public LoginMethodHandler(LoginClient loginClient) {
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        setLoginClient(loginClient);
    }

    @JvmStatic
    public static final AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        return Companion.createAccessTokenFromNativeLogin(bundle, accessTokenSource, str);
    }

    @JvmStatic
    public static final AccessToken createAccessTokenFromWebBundle(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) throws FacebookException {
        return Companion.createAccessTokenFromWebBundle(collection, bundle, accessTokenSource, str);
    }

    @JvmStatic
    public static final AuthenticationToken createAuthenticationTokenFromNativeLogin(Bundle bundle, String str) throws FacebookException {
        return Companion.createAuthenticationTokenFromNativeLogin(bundle, str);
    }

    @JvmStatic
    public static final AuthenticationToken createAuthenticationTokenFromWebBundle(Bundle bundle, String str) throws FacebookException {
        return Companion.createAuthenticationTokenFromWebBundle(bundle, str);
    }

    @JvmStatic
    public static final String getUserIDFromSignedRequest(String str) throws FacebookException {
        return Companion.getUserIDFromSignedRequest(str);
    }

    protected void addLoggingExtra(String str, Object obj) {
        if (this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        Map<String, String> map = this.methodLoggingExtras;
        if (map != null) {
            map.put(str, obj != null ? obj.toString() : null);
        }
    }

    protected String getClientState(String authId) {
        Intrinsics.checkNotNullParameter(authId, "authId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LoginLogger.EVENT_PARAM_AUTH_LOGGER_ID, authId);
            jSONObject.put(LoginLogger.EVENT_PARAM_METHOD, getNameForLogging());
            putChallengeParam(jSONObject);
        } catch (JSONException e3) {
            Log.w("LoginMethodHandler", "Error creating client state json: " + e3.getMessage());
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "param.toString()");
        return string;
    }

    public final LoginClient getLoginClient() {
        LoginClient loginClient = this.loginClient;
        if (loginClient != null) {
            return loginClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loginClient");
        return null;
    }

    public final Map<String, String> getMethodLoggingExtras() {
        return this.methodLoggingExtras;
    }

    public abstract String getNameForLogging();

    protected String getRedirectUrl() {
        return "fb" + FacebookSdk.getApplicationId() + "://authorize/";
    }

    protected void logWebLoginCompleted(String str) {
        String applicationId;
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        if (pendingRequest == null || (applicationId = pendingRequest.getApplicationId()) == null) {
            applicationId = FacebookSdk.getApplicationId();
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(getLoginClient().getActivity(), applicationId);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_WEB_LOGIN_E2E, str);
        bundle.putLong(AnalyticsEvents.PARAMETER_WEB_LOGIN_SWITCHBACK_TIME, System.currentTimeMillis());
        bundle.putString("app_id", applicationId);
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_WEB_LOGIN_COMPLETE, null, bundle);
    }

    public boolean needsInternetPermission() {
        return false;
    }

    public boolean onActivityResult(int i3, int i4, Intent intent) {
        return false;
    }

    protected Bundle processCodeExchange(LoginClient.Request request, Bundle values) throws FacebookException {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(values, "values");
        String string = values.getString("code");
        if (Utility.isNullOrEmpty(string)) {
            throw new FacebookException("No code param found from the request");
        }
        if (string != null) {
            String redirectUrl = getRedirectUrl();
            String codeVerifier = request.getCodeVerifier();
            if (codeVerifier == null) {
                codeVerifier = "";
            }
            GraphRequest graphRequestCreateCodeExchangeRequest = PKCEUtil.createCodeExchangeRequest(string, redirectUrl, codeVerifier);
            if (graphRequestCreateCodeExchangeRequest != null) {
                GraphResponse graphResponseExecuteAndWait = graphRequestCreateCodeExchangeRequest.executeAndWait();
                FacebookRequestError error = graphResponseExecuteAndWait.getError();
                if (error != null) {
                    throw new FacebookServiceException(error, error.getErrorMessage());
                }
                try {
                    JSONObject jSONObject = graphResponseExecuteAndWait.getJSONObject();
                    String string2 = jSONObject != null ? jSONObject.getString("access_token") : null;
                    if (jSONObject == null || Utility.isNullOrEmpty(string2)) {
                        throw new FacebookException("No access token found from result");
                    }
                    values.putString("access_token", string2);
                    if (jSONObject.has("id_token")) {
                        values.putString("id_token", jSONObject.getString("id_token"));
                    }
                    return values;
                } catch (JSONException e3) {
                    throw new FacebookException("Fail to process code exchange response: " + e3.getMessage());
                }
            }
        }
        throw new FacebookException("Failed to create code exchange request");
    }

    public void putChallengeParam(JSONObject param) throws JSONException {
        Intrinsics.checkNotNullParameter(param, "param");
    }

    public final void setLoginClient(LoginClient loginClient) {
        Intrinsics.checkNotNullParameter(loginClient, "<set-?>");
        this.loginClient = loginClient;
    }

    public final void setMethodLoggingExtras(Map<String, String> map) {
        this.methodLoggingExtras = map;
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return false;
    }

    public abstract int tryAuthorize(LoginClient.Request request);

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Utility.writeStringMapToParcel(dest, this.methodLoggingExtras);
    }

    protected LoginMethodHandler(Parcel source) {
        Intrinsics.checkNotNullParameter(source, "source");
        Map<String, String> stringMapFromParcel = Utility.readStringMapFromParcel(source);
        this.methodLoggingExtras = stringMapFromParcel != null ? MapsKt.toMutableMap(stringMapFromParcel) : null;
    }

    public void cancel() {
    }
}
