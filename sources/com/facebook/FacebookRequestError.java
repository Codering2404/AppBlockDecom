package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class FacebookRequestError implements Parcelable {
    public static final String BODY_KEY = "body";
    public static final String CODE_KEY = "code";
    public static final String ERROR_CODE_FIELD_KEY = "code";
    public static final String ERROR_CODE_KEY = "error_code";
    public static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    public static final String ERROR_KEY = "error";
    public static final String ERROR_MESSAGE_FIELD_KEY = "message";
    public static final String ERROR_MSG_KEY = "error_msg";
    public static final String ERROR_REASON_KEY = "error_reason";
    public static final String ERROR_SUB_CODE_KEY = "error_subcode";
    public static final String ERROR_TYPE_FIELD_KEY = "type";
    public static final String ERROR_USER_MSG_KEY = "error_user_msg";
    public static final String ERROR_USER_TITLE_KEY = "error_user_title";
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    public final Object batchRequestResult;
    public final Category category;
    public final HttpURLConnection connection;
    public final int errorCode;
    public final String errorMessage;
    public final String errorRecoveryMessage;
    public final String errorType;
    public final String errorUserMessage;
    public final String errorUserTitle;
    public FacebookException exception;
    public final JSONObject requestResult;
    public final JSONObject requestResultBody;
    public final int requestStatusCode;
    public final int subErrorCode;
    public static final Companion Companion = new Companion(null);
    public static final Range HTTP_RANGE_SUCCESS = new Range(200, 299);
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new Parcelable.Creator<FacebookRequestError>() { // from class: com.facebook.FacebookRequestError$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FacebookRequestError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FacebookRequestError(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FacebookRequestError[] newArray(int i3) {
            return new FacebookRequestError[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final FacebookRequestError checkResponseAndCreateError(JSONObject singleResult, Object obj, HttpURLConnection httpURLConnection) {
            String str;
            String strOptString;
            int iOptInt;
            String str2;
            Object obj2;
            boolean z2;
            String str3;
            String strOptString2;
            Intrinsics.checkNotNullParameter(singleResult, "singleResult");
            try {
                if (singleResult.has("code")) {
                    int i3 = singleResult.getInt("code");
                    Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(singleResult, "body", GraphResponse.NON_JSON_RESPONSE_PROPERTY);
                    if (stringPropertyAsJSON == null || !(stringPropertyAsJSON instanceof JSONObject)) {
                        str = "body";
                    } else {
                        boolean z3 = true;
                        if (((JSONObject) stringPropertyAsJSON).has("error")) {
                            JSONObject jSONObject = (JSONObject) Utility.getStringPropertyAsJSON((JSONObject) stringPropertyAsJSON, "error", null);
                            String strOptString3 = jSONObject != null ? jSONObject.optString("type", null) : null;
                            strOptString = jSONObject != null ? jSONObject.optString("message", null) : null;
                            int iOptInt2 = jSONObject != null ? jSONObject.optInt("code", -1) : -1;
                            iOptInt = jSONObject != null ? jSONObject.optInt("error_subcode", -1) : -1;
                            strOptString2 = jSONObject != null ? jSONObject.optString(FacebookRequestError.ERROR_USER_MSG_KEY, null) : null;
                            String strOptString4 = jSONObject != null ? jSONObject.optString(FacebookRequestError.ERROR_USER_TITLE_KEY, null) : null;
                            boolean zOptBoolean = jSONObject != null ? jSONObject.optBoolean(FacebookRequestError.ERROR_IS_TRANSIENT_KEY, false) : false;
                            str = "body";
                            iOptInt = iOptInt;
                            iOptInt = iOptInt2;
                            str2 = strOptString3;
                            obj2 = stringPropertyAsJSON;
                            str3 = strOptString4;
                            z2 = zOptBoolean;
                        } else if (((JSONObject) stringPropertyAsJSON).has("error_code") || ((JSONObject) stringPropertyAsJSON).has(FacebookRequestError.ERROR_MSG_KEY) || ((JSONObject) stringPropertyAsJSON).has(FacebookRequestError.ERROR_REASON_KEY)) {
                            String strOptString5 = ((JSONObject) stringPropertyAsJSON).optString(FacebookRequestError.ERROR_REASON_KEY, null);
                            strOptString = ((JSONObject) stringPropertyAsJSON).optString(FacebookRequestError.ERROR_MSG_KEY, null);
                            iOptInt = ((JSONObject) stringPropertyAsJSON).optInt("error_code", -1);
                            str = "body";
                            iOptInt = ((JSONObject) stringPropertyAsJSON).optInt("error_subcode", -1);
                            str2 = strOptString5;
                            obj2 = stringPropertyAsJSON;
                            z2 = false;
                            str3 = null;
                            strOptString2 = null;
                        } else {
                            str = "body";
                            obj2 = stringPropertyAsJSON;
                            z3 = false;
                            z2 = false;
                            iOptInt = -1;
                            str2 = null;
                            str3 = null;
                            strOptString = null;
                            strOptString2 = null;
                        }
                        if (z3) {
                            return new FacebookRequestError(i3, iOptInt, iOptInt, str2, strOptString, str3, strOptString2, (JSONObject) obj2, singleResult, obj, httpURLConnection, null, z2, null);
                        }
                    }
                    if (!getHTTP_RANGE_SUCCESS$facebook_core_release().contains(i3)) {
                        return new FacebookRequestError(i3, -1, -1, null, null, null, null, singleResult.has(str) ? (JSONObject) Utility.getStringPropertyAsJSON(singleResult, str, GraphResponse.NON_JSON_RESPONSE_PROPERTY) : null, singleResult, obj, httpURLConnection, null, false, null);
                    }
                }
            } catch (JSONException unused) {
            }
            return null;
        }

        @JvmStatic
        public final synchronized FacebookRequestErrorClassification getErrorClassification() {
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                return FacebookRequestErrorClassification.Companion.getDefaultErrorClassification();
            }
            return appSettingsWithoutQuery.getErrorClassification();
        }

        public final Range getHTTP_RANGE_SUCCESS$facebook_core_release() {
            return FacebookRequestError.HTTP_RANGE_SUCCESS;
        }

        public Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Range {
        public final int end;
        public final int start;

        public Range(int i3, int i4) {
            this.start = i3;
            this.end = i4;
        }

        public final boolean contains(int i3) {
            return i3 <= this.end && this.start <= i3;
        }
    }

    public /* synthetic */ FacebookRequestError(int i3, int i4, int i5, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, i5, str, str2, str3, str4, jSONObject, jSONObject2, obj, httpURLConnection, facebookException, z2);
    }

    @JvmStatic
    public static final FacebookRequestError checkResponseAndCreateError(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        return Companion.checkResponseAndCreateError(jSONObject, obj, httpURLConnection);
    }

    @JvmStatic
    public static final synchronized FacebookRequestErrorClassification getErrorClassification() {
        return Companion.getErrorClassification();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public final Category getCategory() {
        return this.category;
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        String str = this.errorMessage;
        if (str != null) {
            return str;
        }
        FacebookException facebookException = this.exception;
        if (facebookException != null) {
            return facebookException.getLocalizedMessage();
        }
        return null;
    }

    public final String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    public final String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    public final FacebookException getException() {
        return this.exception;
    }

    public final JSONObject getRequestResult() {
        return this.requestResult;
    }

    public final JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public final int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public final int getSubErrorCode() {
        return this.subErrorCode;
    }

    public String toString() {
        String str = "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder(\"{HttpStat…(\"}\")\n        .toString()");
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.requestStatusCode);
        out.writeInt(this.errorCode);
        out.writeInt(this.subErrorCode);
        out.writeString(this.errorType);
        out.writeString(getErrorMessage());
        out.writeString(this.errorUserTitle);
        out.writeString(this.errorUserMessage);
    }

    public /* synthetic */ FacebookRequestError(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public FacebookRequestError(int i3, int i4, int i5, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z2) {
        Category categoryClassify;
        this.requestStatusCode = i3;
        this.errorCode = i4;
        this.subErrorCode = i5;
        this.errorType = str;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorMessage = str2;
        if (facebookException != null) {
            this.exception = facebookException;
            categoryClassify = Category.OTHER;
        } else {
            this.exception = new FacebookServiceException(this, getErrorMessage());
            categoryClassify = Companion.getErrorClassification().classify(i4, i5, z2);
        }
        this.category = categoryClassify;
        this.errorRecoveryMessage = Companion.getErrorClassification().getRecoveryMessage(categoryClassify);
    }

    public FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, null, null, null, httpURLConnection, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc), false);
    }

    public FacebookRequestError(int i3, String str, String str2) {
        this(-1, i3, -1, str, str2, null, null, null, null, null, null, null, false);
    }

    public FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), null, null, null, null, null, false);
    }
}
