package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
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
public class LoginClient implements Parcelable {
    private BackgroundProcessingListener backgroundProcessingListener;
    private boolean checkedInternetPermission;
    private int currentHandler;
    private Map<String, String> extraData;
    private Fragment fragment;
    private LoginMethodHandler[] handlersToTry;
    private Map<String, String> loggingExtras;
    private LoginLogger loginLogger;
    private int numActivitiesReturned;
    private int numTotalIntentsFired;
    private OnCompletedListener onCompletedListener;
    private Request pendingRequest;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = LoginClient.class.getSimpleName();
    public static final Parcelable.Creator<LoginClient> CREATOR = new Parcelable.Creator<LoginClient>() { // from class: com.facebook.login.LoginClient$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginClient createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new LoginClient(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginClient[] newArray(int i3) {
            return new LoginClient[i3];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface BackgroundProcessingListener {
        void onBackgroundProcessingStarted();

        void onBackgroundProcessingStopped();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String getE2E() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("init", System.currentTimeMillis());
            } catch (JSONException e3) {
                Utility.logd(LoginClient.TAG, "Failed to create e2e JSON", e3);
            }
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "e2e.toString()");
            return string;
        }

        @JvmStatic
        public final int getLoginRequestCode() {
            return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnCompletedListener {
        void onCompleted(Result result);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Request implements Parcelable {
        private final String applicationId;
        private String authId;
        private String authType;
        private final String codeChallenge;
        private final CodeChallengeMethod codeChallengeMethod;
        private final String codeVerifier;
        private final DefaultAudience defaultAudience;
        private String deviceAuthTargetUserId;
        private String deviceRedirectUriString;
        private String intentUriPackageTarget;
        private boolean isFamilyLogin;
        private boolean isRerequest;
        private final LoginBehavior loginBehavior;
        private final LoginTargetApp loginTargetApp;
        private String messengerPageId;
        private final String nonce;
        private Set<String> permissions;
        private String redirectURI;
        private boolean resetMessengerState;
        private boolean shouldSkipAccountDeduplication;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator<Request>() { // from class: com.facebook.login.LoginClient$Request$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LoginClient.Request createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new LoginClient.Request(source, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LoginClient.Request[] newArray(int i3) {
                return new LoginClient.Request[i3];
            }
        };

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public /* synthetic */ Request(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String getApplicationId() {
            return this.applicationId;
        }

        public final String getAuthId() {
            return this.authId;
        }

        public final String getAuthType() {
            return this.authType;
        }

        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        public final CodeChallengeMethod getCodeChallengeMethod() {
            return this.codeChallengeMethod;
        }

        public final String getCodeVerifier() {
            return this.codeVerifier;
        }

        public final DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public final String getDeviceAuthTargetUserId() {
            return this.deviceAuthTargetUserId;
        }

        public final String getDeviceRedirectUriString() {
            return this.deviceRedirectUriString;
        }

        public final String getIntentUriPackageTarget() {
            return this.intentUriPackageTarget;
        }

        public final LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public final LoginTargetApp getLoginTargetApp() {
            return this.loginTargetApp;
        }

        public final String getMessengerPageId() {
            return this.messengerPageId;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final Set<String> getPermissions() {
            return this.permissions;
        }

        public final String getRedirectURI() {
            return this.redirectURI;
        }

        public final boolean getResetMessengerState() {
            return this.resetMessengerState;
        }

        public final boolean hasPublishPermission() {
            Iterator<String> it = this.permissions.iterator();
            while (it.hasNext()) {
                if (LoginManager.Companion.isPublishPermission(it.next())) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isFamilyLogin() {
            return this.isFamilyLogin;
        }

        public final boolean isInstagramLogin() {
            return this.loginTargetApp == LoginTargetApp.INSTAGRAM;
        }

        public final boolean isRerequest() {
            return this.isRerequest;
        }

        public final void setAuthId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authId = str;
        }

        public final void setAuthType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authType = str;
        }

        public final void setDeviceAuthTargetUserId(String str) {
            this.deviceAuthTargetUserId = str;
        }

        public final void setDeviceRedirectUriString(String str) {
            this.deviceRedirectUriString = str;
        }

        public final void setFamilyLogin(boolean z2) {
            this.isFamilyLogin = z2;
        }

        public final void setIntentUriPackageTarget(String str) {
            this.intentUriPackageTarget = str;
        }

        public final void setMessengerPageId(String str) {
            this.messengerPageId = str;
        }

        public final void setPermissions(Set<String> set) {
            Intrinsics.checkNotNullParameter(set, "<set-?>");
            this.permissions = set;
        }

        public final void setRedirectURI(String str) {
            this.redirectURI = str;
        }

        public final void setRerequest(boolean z2) {
            this.isRerequest = z2;
        }

        public final void setResetMessengerState(boolean z2) {
            this.resetMessengerState = z2;
        }

        public final void setShouldSkipAccountDeduplication(boolean z2) {
            this.shouldSkipAccountDeduplication = z2;
        }

        public final boolean shouldSkipAccountDeduplication() {
            return this.shouldSkipAccountDeduplication;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int i3) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.loginBehavior.name());
            dest.writeStringList(new ArrayList(this.permissions));
            dest.writeString(this.defaultAudience.name());
            dest.writeString(this.applicationId);
            dest.writeString(this.redirectURI);
            dest.writeString(this.intentUriPackageTarget);
            dest.writeString(this.authId);
            dest.writeByte(this.isRerequest ? (byte) 1 : (byte) 0);
            dest.writeString(this.deviceRedirectUriString);
            dest.writeString(this.authType);
            dest.writeString(this.deviceAuthTargetUserId);
            dest.writeString(this.messengerPageId);
            dest.writeByte(this.resetMessengerState ? (byte) 1 : (byte) 0);
            dest.writeString(this.loginTargetApp.name());
            dest.writeByte(this.isFamilyLogin ? (byte) 1 : (byte) 0);
            dest.writeByte(this.shouldSkipAccountDeduplication ? (byte) 1 : (byte) 0);
            dest.writeString(this.nonce);
            dest.writeString(this.codeVerifier);
            dest.writeString(this.codeChallenge);
            CodeChallengeMethod codeChallengeMethod = this.codeChallengeMethod;
            dest.writeString(codeChallengeMethod != null ? codeChallengeMethod.name() : null);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId) {
            this(loginBehavior, set, defaultAudience, authType, applicationId, authId, null, null, null, null, null, null, null, 8128, null);
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId, LoginTargetApp loginTargetApp) {
            this(loginBehavior, set, defaultAudience, authType, applicationId, authId, loginTargetApp, null, null, null, null, null, null, 8064, null);
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId, LoginTargetApp loginTargetApp, String str) {
            this(loginBehavior, set, defaultAudience, authType, applicationId, authId, loginTargetApp, str, null, null, null, null, null, 7936, null);
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId, LoginTargetApp loginTargetApp, String str, String str2) {
            this(loginBehavior, set, defaultAudience, authType, applicationId, authId, loginTargetApp, str, str2, null, null, null, null, 7680, null);
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId, LoginTargetApp loginTargetApp, String str, String str2, String str3) {
            this(loginBehavior, set, defaultAudience, authType, applicationId, authId, loginTargetApp, str, str2, str3, null, null, null, 7168, null);
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId, LoginTargetApp loginTargetApp, String str, String str2, String str3, CodeChallengeMethod codeChallengeMethod) {
            this(loginBehavior, set, defaultAudience, authType, applicationId, authId, loginTargetApp, str, str2, str3, codeChallengeMethod, null, null, 6144, null);
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId, LoginTargetApp loginTargetApp, String str, String str2, String str3, CodeChallengeMethod codeChallengeMethod, String str4) {
            this(loginBehavior, set, defaultAudience, authType, applicationId, authId, loginTargetApp, str, str2, str3, codeChallengeMethod, str4, null, 4096, null);
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ Request(com.facebook.login.LoginBehavior r17, java.util.Set r18, com.facebook.login.DefaultAudience r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, com.facebook.login.LoginTargetApp r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, com.facebook.login.CodeChallengeMethod r27, java.lang.String r28, java.lang.String r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
            /*
                r16 = this;
                r0 = r30
                r1 = r0 & 64
                if (r1 == 0) goto La
                com.facebook.login.LoginTargetApp r1 = com.facebook.login.LoginTargetApp.FACEBOOK
                r9 = r1
                goto Lc
            La:
                r9 = r23
            Lc:
                r1 = r0 & 128(0x80, float:1.8E-43)
                r2 = 0
                if (r1 == 0) goto L13
                r10 = r2
                goto L15
            L13:
                r10 = r24
            L15:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L1b
                r11 = r2
                goto L1d
            L1b:
                r11 = r25
            L1d:
                r1 = r0 & 512(0x200, float:7.17E-43)
                if (r1 == 0) goto L23
                r12 = r2
                goto L25
            L23:
                r12 = r26
            L25:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L2b
                r13 = r2
                goto L2d
            L2b:
                r13 = r27
            L2d:
                r1 = r0 & 2048(0x800, float:2.87E-42)
                if (r1 == 0) goto L33
                r14 = r2
                goto L35
            L33:
                r14 = r28
            L35:
                r0 = r0 & 4096(0x1000, float:5.74E-42)
                if (r0 == 0) goto L49
                r15 = r2
                r3 = r17
                r4 = r18
                r5 = r19
                r6 = r20
                r7 = r21
                r8 = r22
                r2 = r16
                goto L59
            L49:
                r15 = r29
                r2 = r16
                r3 = r17
                r4 = r18
                r5 = r19
                r6 = r20
                r7 = r21
                r8 = r22
            L59:
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.Request.<init>(com.facebook.login.LoginBehavior, java.util.Set, com.facebook.login.DefaultAudience, java.lang.String, java.lang.String, java.lang.String, com.facebook.login.LoginTargetApp, java.lang.String, java.lang.String, java.lang.String, com.facebook.login.CodeChallengeMethod, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String authType, String applicationId, String authId, LoginTargetApp loginTargetApp, String str, String str2, String str3, CodeChallengeMethod codeChallengeMethod, String str4, String str5) {
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(authType, "authType");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(authId, "authId");
            this.loginBehavior = loginBehavior;
            this.permissions = set == null ? new HashSet<>() : set;
            this.defaultAudience = defaultAudience;
            this.authType = authType;
            this.applicationId = applicationId;
            this.redirectURI = str4;
            this.intentUriPackageTarget = str5;
            this.authId = authId;
            this.loginTargetApp = loginTargetApp == null ? LoginTargetApp.FACEBOOK : loginTargetApp;
            if (str != null && str.length() != 0) {
                this.nonce = str;
            } else {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                this.nonce = string;
            }
            this.codeVerifier = str2;
            this.codeChallenge = str3;
            this.codeChallengeMethod = codeChallengeMethod;
        }

        private Request(Parcel parcel) {
            DefaultAudience defaultAudienceValueOf;
            LoginTargetApp loginTargetAppValueOf;
            this.loginBehavior = LoginBehavior.valueOf(Validate.notNullOrEmpty(parcel.readString(), "loginBehavior"));
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.permissions = new HashSet(arrayList);
            String string = parcel.readString();
            if (string != null) {
                defaultAudienceValueOf = DefaultAudience.valueOf(string);
            } else {
                defaultAudienceValueOf = DefaultAudience.NONE;
            }
            this.defaultAudience = defaultAudienceValueOf;
            this.applicationId = Validate.notNullOrEmpty(parcel.readString(), "applicationId");
            this.redirectURI = parcel.readString();
            this.intentUriPackageTarget = parcel.readString();
            this.authId = Validate.notNullOrEmpty(parcel.readString(), "authId");
            this.isRerequest = parcel.readByte() != 0;
            this.deviceRedirectUriString = parcel.readString();
            this.authType = Validate.notNullOrEmpty(parcel.readString(), "authType");
            this.deviceAuthTargetUserId = parcel.readString();
            this.messengerPageId = parcel.readString();
            this.resetMessengerState = parcel.readByte() != 0;
            String string2 = parcel.readString();
            if (string2 != null) {
                loginTargetAppValueOf = LoginTargetApp.valueOf(string2);
            } else {
                loginTargetAppValueOf = LoginTargetApp.FACEBOOK;
            }
            this.loginTargetApp = loginTargetAppValueOf;
            this.isFamilyLogin = parcel.readByte() != 0;
            this.shouldSkipAccountDeduplication = parcel.readByte() != 0;
            this.nonce = Validate.notNullOrEmpty(parcel.readString(), "nonce");
            this.codeVerifier = parcel.readString();
            this.codeChallenge = parcel.readString();
            String string3 = parcel.readString();
            this.codeChallengeMethod = string3 != null ? CodeChallengeMethod.valueOf(string3) : null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Result implements Parcelable {
        public final AuthenticationToken authenticationToken;
        public final Code code;
        public final String errorCode;
        public final String errorMessage;
        public Map<String, String> extraData;
        public Map<String, String> loggingExtras;
        public final Request request;
        public final AccessToken token;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.facebook.login.LoginClient$Result$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LoginClient.Result createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new LoginClient.Result(source, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LoginClient.Result[] newArray(int i3) {
                return new LoginClient.Result[i3];
            }
        };

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public enum Code {
            SUCCESS(GraphResponse.SUCCESS_KEY),
            CANCEL("cancel"),
            ERROR("error");

            private final String loggingValue;

            Code(String str) {
                this.loggingValue = str;
            }

            public final String getLoggingValue() {
                return this.loggingValue;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ Result createErrorResult$default(Companion companion, Request request, String str, String str2, String str3, int i3, Object obj) {
                if ((i3 & 8) != 0) {
                    str3 = null;
                }
                return companion.createErrorResult(request, str, str2, str3);
            }

            @JvmStatic
            public final Result createCancelResult(Request request, String str) {
                return new Result(request, Code.CANCEL, null, str, null);
            }

            @JvmStatic
            public final Result createCompositeTokenResult(Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
                return new Result(request, Code.SUCCESS, accessToken, authenticationToken, null, null);
            }

            @JvmStatic
            public final Result createErrorResult(Request request, String str, String str2) {
                return createErrorResult$default(this, request, str, str2, null, 8, null);
            }

            @JvmStatic
            public final Result createTokenResult(Request request, AccessToken token) {
                Intrinsics.checkNotNullParameter(token, "token");
                return new Result(request, Code.SUCCESS, token, null, null);
            }

            private Companion() {
            }

            @JvmStatic
            public final Result createErrorResult(Request request, String str, String str2, String str3) {
                ArrayList arrayList = new ArrayList();
                if (str != null) {
                    arrayList.add(str);
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
                return new Result(request, Code.ERROR, null, TextUtils.join(": ", arrayList), str3);
            }
        }

        public /* synthetic */ Result(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        @JvmStatic
        public static final Result createCancelResult(Request request, String str) {
            return Companion.createCancelResult(request, str);
        }

        @JvmStatic
        public static final Result createCompositeTokenResult(Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
            return Companion.createCompositeTokenResult(request, accessToken, authenticationToken);
        }

        @JvmStatic
        public static final Result createErrorResult(Request request, String str, String str2) {
            return Companion.createErrorResult(request, str, str2);
        }

        @JvmStatic
        public static final Result createTokenResult(Request request, AccessToken accessToken) {
            return Companion.createTokenResult(request, accessToken);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int i3) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.code.name());
            dest.writeParcelable(this.token, i3);
            dest.writeParcelable(this.authenticationToken, i3);
            dest.writeString(this.errorMessage);
            dest.writeString(this.errorCode);
            dest.writeParcelable(this.request, i3);
            Utility.writeNonnullStringMapToParcel(dest, this.loggingExtras);
            Utility.writeNonnullStringMapToParcel(dest, this.extraData);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Result(Request request, Code code, AccessToken accessToken, String str, String str2) {
            this(request, code, accessToken, null, str, str2);
            Intrinsics.checkNotNullParameter(code, "code");
        }

        @JvmStatic
        public static final Result createErrorResult(Request request, String str, String str2, String str3) {
            return Companion.createErrorResult(request, str, str2, str3);
        }

        public Result(Request request, Code code, AccessToken accessToken, AuthenticationToken authenticationToken, String str, String str2) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.request = request;
            this.token = accessToken;
            this.authenticationToken = authenticationToken;
            this.errorMessage = str;
            this.code = code;
            this.errorCode = str2;
        }

        private Result(Parcel parcel) {
            String string = parcel.readString();
            this.code = Code.valueOf(string == null ? "error" : string);
            this.token = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.authenticationToken = (AuthenticationToken) parcel.readParcelable(AuthenticationToken.class.getClassLoader());
            this.errorMessage = parcel.readString();
            this.errorCode = parcel.readString();
            this.request = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readNonnullStringMapFromParcel(parcel);
            this.extraData = Utility.readNonnullStringMapFromParcel(parcel);
        }
    }

    public LoginClient(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.currentHandler = -1;
        setFragment(fragment);
    }

    private final void addLoggingExtra(String str, String str2, boolean z2) {
        Map<String, String> map = this.loggingExtras;
        if (map == null) {
            map = new HashMap<>();
        }
        if (this.loggingExtras == null) {
            this.loggingExtras = map;
        }
        if (map.containsKey(str) && z2) {
            str2 = map.get(str) + ',' + str2;
        }
        map.put(str, str2);
    }

    private final void completeWithFailure() {
        complete(Result.Companion.createErrorResult$default(Result.Companion, this.pendingRequest, "Login attempt failed.", null, null, 8, null));
    }

    @JvmStatic
    public static final String getE2E() {
        return Companion.getE2E();
    }

    private final LoginLogger getLogger() {
        String applicationId;
        LoginLogger loginLogger = this.loginLogger;
        if (loginLogger != null) {
            String applicationId2 = loginLogger.getApplicationId();
            Request request = this.pendingRequest;
            if (Intrinsics.areEqual(applicationId2, request != null ? request.getApplicationId() : null)) {
                return loginLogger;
            }
        }
        Context activity = getActivity();
        if (activity == null) {
            activity = FacebookSdk.getApplicationContext();
        }
        Request request2 = this.pendingRequest;
        if (request2 == null || (applicationId = request2.getApplicationId()) == null) {
            applicationId = FacebookSdk.getApplicationId();
        }
        LoginLogger loginLogger2 = new LoginLogger(activity, applicationId);
        this.loginLogger = loginLogger2;
        return loginLogger2;
    }

    @JvmStatic
    public static final int getLoginRequestCode() {
        return Companion.getLoginRequestCode();
    }

    private final void logAuthorizationMethodComplete(String str, Result result, Map<String, String> map) {
        logAuthorizationMethodComplete(str, result.code.getLoggingValue(), result.errorMessage, result.errorCode, map);
    }

    private final void notifyOnCompleteListener(Result result) {
        OnCompletedListener onCompletedListener = this.onCompletedListener;
        if (onCompletedListener != null) {
            onCompletedListener.onCompleted(result);
        }
    }

    public final void addExtraData(String key, String value, boolean z2) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Map<String, String> map = this.extraData;
        if (map == null) {
            map = new HashMap<>();
        }
        if (this.extraData == null) {
            this.extraData = map;
        }
        if (map.containsKey(key) && z2) {
            value = map.get(key) + ',' + value;
        }
        map.put(key, value);
    }

    public final void authorize(Request request) {
        if (request == null) {
            return;
        }
        if (this.pendingRequest != null) {
            throw new FacebookException("Attempted to authorize while a request is pending.");
        }
        if (!AccessToken.Companion.isCurrentAccessTokenActive() || checkInternetPermission()) {
            this.pendingRequest = request;
            this.handlersToTry = getHandlersToTry(request);
            tryNextHandler();
        }
    }

    public final void cancelCurrentHandler() {
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler != null) {
            currentHandler.cancel();
        }
    }

    public final boolean checkInternetPermission() {
        if (this.checkedInternetPermission) {
            return true;
        }
        if (checkPermission("android.permission.INTERNET") == 0) {
            this.checkedInternetPermission = true;
            return true;
        }
        FragmentActivity activity = getActivity();
        complete(Result.Companion.createErrorResult$default(Result.Companion, this.pendingRequest, activity != null ? activity.getString(com.facebook.common.R.string.com_facebook_internet_permission_error_title) : null, activity != null ? activity.getString(com.facebook.common.R.string.com_facebook_internet_permission_error_message) : null, null, 8, null));
        return false;
    }

    public final int checkPermission(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.checkCallingOrSelfPermission(permission);
        }
        return -1;
    }

    public final void complete(Result outcome) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler != null) {
            logAuthorizationMethodComplete(currentHandler.getNameForLogging(), outcome, currentHandler.getMethodLoggingExtras());
        }
        Map<String, String> map = this.loggingExtras;
        if (map != null) {
            outcome.loggingExtras = map;
        }
        Map<String, String> map2 = this.extraData;
        if (map2 != null) {
            outcome.extraData = map2;
        }
        this.handlersToTry = null;
        this.currentHandler = -1;
        this.pendingRequest = null;
        this.loggingExtras = null;
        this.numActivitiesReturned = 0;
        this.numTotalIntentsFired = 0;
        notifyOnCompleteListener(outcome);
    }

    public final void completeAndValidate(Result outcome) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        if (outcome.token == null || !AccessToken.Companion.isCurrentAccessTokenActive()) {
            complete(outcome);
        } else {
            validateSameFbidAndFinish(outcome);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final FragmentActivity getActivity() {
        Fragment fragment = this.fragment;
        if (fragment != null) {
            return fragment.getActivity();
        }
        return null;
    }

    public final BackgroundProcessingListener getBackgroundProcessingListener() {
        return this.backgroundProcessingListener;
    }

    public final boolean getCheckedInternetPermission() {
        return this.checkedInternetPermission;
    }

    public final LoginMethodHandler getCurrentHandler() {
        LoginMethodHandler[] loginMethodHandlerArr;
        int i3 = this.currentHandler;
        if (i3 < 0 || (loginMethodHandlerArr = this.handlersToTry) == null) {
            return null;
        }
        return loginMethodHandlerArr[i3];
    }

    public final Map<String, String> getExtraData() {
        return this.extraData;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final LoginMethodHandler[] getHandlersToTry() {
        return this.handlersToTry;
    }

    public final boolean getInProgress() {
        return this.pendingRequest != null && this.currentHandler >= 0;
    }

    public final Map<String, String> getLoggingExtras() {
        return this.loggingExtras;
    }

    public final OnCompletedListener getOnCompletedListener() {
        return this.onCompletedListener;
    }

    public final Request getPendingRequest() {
        return this.pendingRequest;
    }

    public final void notifyBackgroundProcessingStart() {
        BackgroundProcessingListener backgroundProcessingListener = this.backgroundProcessingListener;
        if (backgroundProcessingListener != null) {
            backgroundProcessingListener.onBackgroundProcessingStarted();
        }
    }

    public final void notifyBackgroundProcessingStop() {
        BackgroundProcessingListener backgroundProcessingListener = this.backgroundProcessingListener;
        if (backgroundProcessingListener != null) {
            backgroundProcessingListener.onBackgroundProcessingStopped();
        }
    }

    public final boolean onActivityResult(int i3, int i4, Intent intent) {
        this.numActivitiesReturned++;
        if (this.pendingRequest != null) {
            if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
                tryNextHandler();
                return false;
            }
            LoginMethodHandler currentHandler = getCurrentHandler();
            if (currentHandler != null && (!currentHandler.shouldKeepTrackOfMultipleIntents() || intent != null || this.numActivitiesReturned >= this.numTotalIntentsFired)) {
                return currentHandler.onActivityResult(i3, i4, intent);
            }
        }
        return false;
    }

    public final void setBackgroundProcessingListener(BackgroundProcessingListener backgroundProcessingListener) {
        this.backgroundProcessingListener = backgroundProcessingListener;
    }

    public final void setCheckedInternetPermission(boolean z2) {
        this.checkedInternetPermission = z2;
    }

    protected final void setCurrentHandlerIndex(int i3) {
        this.currentHandler = i3;
    }

    public final void setExtraData(Map<String, String> map) {
        this.extraData = map;
    }

    public final void setFragment(Fragment fragment) {
        if (this.fragment != null) {
            throw new FacebookException("Can't set fragment once it is already set.");
        }
        this.fragment = fragment;
    }

    public final void setHandlersToTry(LoginMethodHandler[] loginMethodHandlerArr) {
        this.handlersToTry = loginMethodHandlerArr;
    }

    public final void setLoggingExtras(Map<String, String> map) {
        this.loggingExtras = map;
    }

    public final void setOnCompletedListener(OnCompletedListener onCompletedListener) {
        this.onCompletedListener = onCompletedListener;
    }

    public final void setPendingRequest(Request request) {
        this.pendingRequest = request;
    }

    public final void startOrContinueAuth(Request request) {
        if (getInProgress()) {
            return;
        }
        authorize(request);
    }

    public final boolean tryCurrentHandler() {
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler == null) {
            return false;
        }
        if (currentHandler.needsInternetPermission() && !checkInternetPermission()) {
            addLoggingExtra(LoginLogger.EVENT_EXTRAS_MISSING_INTERNET_PERMISSION, AppEventsConstants.EVENT_PARAM_VALUE_YES, false);
            return false;
        }
        Request request = this.pendingRequest;
        if (request == null) {
            return false;
        }
        int iTryAuthorize = currentHandler.tryAuthorize(request);
        this.numActivitiesReturned = 0;
        if (iTryAuthorize > 0) {
            getLogger().logAuthorizationMethodStart(request.getAuthId(), currentHandler.getNameForLogging(), request.isFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_METHOD_START : LoginLogger.EVENT_NAME_LOGIN_METHOD_START);
            this.numTotalIntentsFired = iTryAuthorize;
        } else {
            getLogger().logAuthorizationMethodNotTried(request.getAuthId(), currentHandler.getNameForLogging(), request.isFamilyLogin() ? LoginLogger.EVENT_NAME_FOA_LOGIN_METHOD_NOT_TRIED : LoginLogger.EVENT_NAME_LOGIN_METHOD_NOT_TRIED);
            addLoggingExtra(LoginLogger.EVENT_EXTRAS_NOT_TRIED, currentHandler.getNameForLogging(), true);
        }
        return iTryAuthorize > 0;
    }

    public final void tryNextHandler() {
        LoginClient loginClient;
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler != null) {
            loginClient = this;
            loginClient.logAuthorizationMethodComplete(currentHandler.getNameForLogging(), LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED, null, null, currentHandler.getMethodLoggingExtras());
        } else {
            loginClient = this;
        }
        LoginMethodHandler[] loginMethodHandlerArr = loginClient.handlersToTry;
        while (loginMethodHandlerArr != null) {
            int i3 = loginClient.currentHandler;
            if (i3 >= loginMethodHandlerArr.length - 1) {
                break;
            }
            loginClient.currentHandler = i3 + 1;
            if (tryCurrentHandler()) {
                return;
            }
        }
        if (loginClient.pendingRequest != null) {
            completeWithFailure();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:6:0x0013, B:8:0x0021, B:12:0x0040, B:11:0x0031), top: B:18:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void validateSameFbidAndFinish(com.facebook.login.LoginClient.Result r8) {
        /*
            r7 = this;
            java.lang.String r0 = "pendingResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.facebook.AccessToken r0 = r8.token
            if (r0 == 0) goto L5a
            com.facebook.AccessToken$Companion r0 = com.facebook.AccessToken.Companion
            com.facebook.AccessToken r0 = r0.getCurrentAccessToken()
            com.facebook.AccessToken r1 = r8.token
            if (r0 == 0) goto L31
            java.lang.String r0 = r0.getUserId()     // Catch: java.lang.Exception -> L2e
            java.lang.String r1 = r1.getUserId()     // Catch: java.lang.Exception -> L2e
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)     // Catch: java.lang.Exception -> L2e
            if (r0 == 0) goto L31
            com.facebook.login.LoginClient$Result$Companion r0 = com.facebook.login.LoginClient.Result.Companion     // Catch: java.lang.Exception -> L2e
            com.facebook.login.LoginClient$Request r1 = r7.pendingRequest     // Catch: java.lang.Exception -> L2e
            com.facebook.AccessToken r2 = r8.token     // Catch: java.lang.Exception -> L2e
            com.facebook.AuthenticationToken r8 = r8.authenticationToken     // Catch: java.lang.Exception -> L2e
            com.facebook.login.LoginClient$Result r8 = r0.createCompositeTokenResult(r1, r2, r8)     // Catch: java.lang.Exception -> L2e
            goto L40
        L2e:
            r0 = move-exception
            r8 = r0
            goto L44
        L31:
            com.facebook.login.LoginClient$Result$Companion r0 = com.facebook.login.LoginClient.Result.Companion     // Catch: java.lang.Exception -> L2e
            com.facebook.login.LoginClient$Request r1 = r7.pendingRequest     // Catch: java.lang.Exception -> L2e
            java.lang.String r2 = "User logged in as different Facebook user."
            r5 = 8
            r6 = 0
            r3 = 0
            r4 = 0
            com.facebook.login.LoginClient$Result r8 = com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L2e
        L40:
            r7.complete(r8)     // Catch: java.lang.Exception -> L2e
            return
        L44:
            com.facebook.login.LoginClient$Result$Companion r0 = com.facebook.login.LoginClient.Result.Companion
            com.facebook.login.LoginClient$Request r1 = r7.pendingRequest
            java.lang.String r3 = r8.getMessage()
            r5 = 8
            r6 = 0
            java.lang.String r2 = "Caught exception"
            r4 = 0
            com.facebook.login.LoginClient$Result r8 = com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(r0, r1, r2, r3, r4, r5, r6)
            r7.complete(r8)
            return
        L5a:
            com.facebook.FacebookException r8 = new com.facebook.FacebookException
            java.lang.String r0 = "Can't validate without a token"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.LoginClient.validateSameFbidAndFinish(com.facebook.login.LoginClient$Result):void");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelableArray(this.handlersToTry, i3);
        dest.writeInt(this.currentHandler);
        dest.writeParcelable(this.pendingRequest, i3);
        Utility.writeNonnullStringMapToParcel(dest, this.loggingExtras);
        Utility.writeNonnullStringMapToParcel(dest, this.extraData);
    }

    public LoginMethodHandler[] getHandlersToTry(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ArrayList arrayList = new ArrayList();
        LoginBehavior loginBehavior = request.getLoginBehavior();
        if (!request.isInstagramLogin()) {
            if (loginBehavior.allowsGetTokenAuth()) {
                arrayList.add(new GetTokenLoginMethodHandler(this));
            }
            if (!FacebookSdk.bypassAppSwitch && loginBehavior.allowsKatanaAuth()) {
                arrayList.add(new KatanaProxyLoginMethodHandler(this));
            }
        } else if (!FacebookSdk.bypassAppSwitch && loginBehavior.allowsInstagramAppAuth()) {
            arrayList.add(new InstagramAppLoginMethodHandler(this));
        }
        if (loginBehavior.allowsCustomTabAuth()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (loginBehavior.allowsWebViewAuth()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (!request.isInstagramLogin() && loginBehavior.allowsDeviceAuth()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        return (LoginMethodHandler[]) arrayList.toArray(new LoginMethodHandler[0]);
    }

    private final void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, Map<String, String> map) {
        Request request = this.pendingRequest;
        String str5 = LoginLogger.EVENT_NAME_LOGIN_METHOD_COMPLETE;
        if (request == null) {
            getLogger().logUnexpectedError(LoginLogger.EVENT_NAME_LOGIN_METHOD_COMPLETE, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
            return;
        }
        LoginLogger logger = getLogger();
        String authId = request.getAuthId();
        if (request.isFamilyLogin()) {
            str5 = LoginLogger.EVENT_NAME_FOA_LOGIN_METHOD_COMPLETE;
        }
        logger.logAuthorizationMethodComplete(authId, str, str2, str3, str4, map, str5);
    }

    public LoginClient(Parcel source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.currentHandler = -1;
        Parcelable[] parcelableArray = source.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        parcelableArray = parcelableArray == null ? new Parcelable[0] : parcelableArray;
        ArrayList arrayList = new ArrayList();
        int length = parcelableArray.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            Parcelable parcelable = parcelableArray[i3];
            LoginMethodHandler loginMethodHandler = parcelable instanceof LoginMethodHandler ? (LoginMethodHandler) parcelable : null;
            if (loginMethodHandler != null) {
                loginMethodHandler.setLoginClient(this);
            }
            if (loginMethodHandler != null) {
                arrayList.add(loginMethodHandler);
            }
            i3++;
        }
        this.handlersToTry = (LoginMethodHandler[]) arrayList.toArray(new LoginMethodHandler[0]);
        this.currentHandler = source.readInt();
        this.pendingRequest = (Request) source.readParcelable(Request.class.getClassLoader());
        Map<String, String> nonnullStringMapFromParcel = Utility.readNonnullStringMapFromParcel(source);
        this.loggingExtras = nonnullStringMapFromParcel != null ? MapsKt.toMutableMap(nonnullStringMapFromParcel) : null;
        Map<String, String> nonnullStringMapFromParcel2 = Utility.readNonnullStringMapFromParcel(source);
        this.extraData = nonnullStringMapFromParcel2 != null ? MapsKt.toMutableMap(nonnullStringMapFromParcel2) : null;
    }
}
