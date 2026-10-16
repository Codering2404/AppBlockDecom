package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
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
public final class GetTokenLoginMethodHandler extends LoginMethodHandler {
    private GetTokenClient getTokenClient;
    private final String nameForLogging;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new Parcelable.Creator<GetTokenLoginMethodHandler>() { // from class: com.facebook.login.GetTokenLoginMethodHandler$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetTokenLoginMethodHandler createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new GetTokenLoginMethodHandler(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetTokenLoginMethodHandler[] newArray(int i3) {
            return new GetTokenLoginMethodHandler[i3];
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        this.nameForLogging = "get_token";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryAuthorize$lambda$1(GetTokenLoginMethodHandler this$0, LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        this$0.getTokenCompleted(request, bundle);
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void cancel() {
        GetTokenClient getTokenClient = this.getTokenClient;
        if (getTokenClient != null) {
            getTokenClient.cancel();
            getTokenClient.setCompletedListener(null);
            this.getTokenClient = null;
        }
    }

    public final void complete(final LoginClient.Request request, final Bundle result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        String string = result.getString(NativeProtocol.EXTRA_USER_ID);
        if (string != null && string.length() != 0) {
            onComplete(request, result);
            return;
        }
        getLoginClient().notifyBackgroundProcessingStart();
        String string2 = result.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
        if (string2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Intrinsics.checkNotNullExpressionValue(string2, "checkNotNull(result.getS…ocol.EXTRA_ACCESS_TOKEN))");
        Utility.getGraphMeRequestWithCacheAsync(string2, new Utility.GraphMeRequestWithCacheCallback() { // from class: com.facebook.login.GetTokenLoginMethodHandler.complete.1
            @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
            public void onFailure(FacebookException facebookException) {
                this.getLoginClient().complete(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, this.getLoginClient().getPendingRequest(), "Caught exception", facebookException != null ? facebookException.getMessage() : null, null, 8, null));
            }

            @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
            public void onSuccess(JSONObject jSONObject) {
                try {
                    result.putString(NativeProtocol.EXTRA_USER_ID, jSONObject != null ? jSONObject.getString("id") : null);
                    this.onComplete(request, result);
                } catch (JSONException e3) {
                    this.getLoginClient().complete(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, this.getLoginClient().getPendingRequest(), "Caught exception", e3.getMessage(), null, 8, null));
                }
            }
        });
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public final void getTokenCompleted(LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(request, "request");
        GetTokenClient getTokenClient = this.getTokenClient;
        if (getTokenClient != null) {
            getTokenClient.setCompletedListener(null);
        }
        this.getTokenClient = null;
        getLoginClient().notifyBackgroundProcessingStop();
        if (bundle != null) {
            List stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            if (stringArrayList == null) {
                stringArrayList = CollectionsKt.emptyList();
            }
            Set<String> permissions = request.getPermissions();
            if (permissions == null) {
                permissions = SetsKt.emptySet();
            }
            String string = bundle.getString(NativeProtocol.EXTRA_AUTHENTICATION_TOKEN);
            if (permissions.contains(LoginConfiguration.OPENID) && (string == null || string.length() == 0)) {
                getLoginClient().tryNextHandler();
                return;
            }
            if (stringArrayList.containsAll(permissions)) {
                complete(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : permissions) {
                if (!stringArrayList.contains(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                addLoggingExtra(LoginLogger.EVENT_EXTRAS_NEW_PERMISSIONS, TextUtils.join(",", hashSet));
            }
            request.setPermissions(hashSet);
        }
        getLoginClient().tryNextHandler();
    }

    public final void onComplete(LoginClient.Request request, Bundle result) {
        LoginClient.Result resultCreateErrorResult$default;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            LoginMethodHandler.Companion companion = LoginMethodHandler.Companion;
            resultCreateErrorResult$default = LoginClient.Result.Companion.createCompositeTokenResult(request, companion.createAccessTokenFromNativeLogin(result, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.getApplicationId()), companion.createAuthenticationTokenFromNativeLogin(result, request.getNonce()));
        } catch (FacebookException e3) {
            resultCreateErrorResult$default = LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, getLoginClient().getPendingRequest(), null, e3.getMessage(), null, 8, null);
        }
        getLoginClient().completeAndValidate(resultCreateErrorResult$default);
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int tryAuthorize(final LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            activity = FacebookSdk.getApplicationContext();
        }
        GetTokenClient getTokenClient = new GetTokenClient(activity, request);
        this.getTokenClient = getTokenClient;
        if (!getTokenClient.start()) {
            return 0;
        }
        getLoginClient().notifyBackgroundProcessingStart();
        PlatformServiceClient.CompletedListener completedListener = new PlatformServiceClient.CompletedListener() { // from class: com.facebook.login.i
            @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
            public final void completed(Bundle bundle) {
                GetTokenLoginMethodHandler.tryAuthorize$lambda$1(this.f68202a, request, bundle);
            }
        };
        GetTokenClient getTokenClient2 = this.getTokenClient;
        if (getTokenClient2 == null) {
            return 1;
        }
        getTokenClient2.setCompletedListener(completedListener);
        return 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(Parcel source) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        this.nameForLogging = "get_token";
    }
}
