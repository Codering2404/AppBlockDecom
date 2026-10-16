package com.google.android.gms.internal.p000authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.auth.api.identity.AuthorizationClient;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.auth.api.identity.zbb;
import com.google.android.gms.auth.api.identity.zbc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zbaa extends GoogleApi implements AuthorizationClient {
    private static final Api.ClientKey zba;
    private static final Api.AbstractClientBuilder zbb;
    private static final Api zbc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        zby zbyVar = new zby();
        zbb = zbyVar;
        zbc = new Api("Auth.Api.Identity.Authorization.API", zbyVar, clientKey);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zbaa(Activity activity, zbc zbcVar) {
        Api api = zbc;
        zbb zbbVarC = zbb.c(zbcVar);
        zbbVarC.a(zbat.zba());
        super(activity, api, (Api.ApiOptions) zbbVarC.b(), GoogleApi.Settings.f71506c);
    }

    public final Task<AuthorizationResult> authorize(AuthorizationRequest authorizationRequest) {
        Preconditions.m(authorizationRequest);
        AuthorizationRequest.Builder builderZ0 = AuthorizationRequest.z0(authorizationRequest);
        builderZ0.h(((zbc) getApiOptions()).b());
        final AuthorizationRequest authorizationRequestA = builderZ0.a();
        return doRead(TaskApiCall.a().d(zbas.zbc).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbx
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zbk) ((zbg) obj).getService()).zbc(new zbz(this.zba, (TaskCompletionSource) obj2), (AuthorizationRequest) Preconditions.m(authorizationRequestA));
            }
        }).c(false).e(1534).a());
    }

    public final AuthorizationResult getAuthorizationResultFromIntent(Intent intent) throws ApiException {
        if (intent == null) {
            throw new ApiException(Status.f71539i);
        }
        Status status = (Status) SafeParcelableSerializer.b(intent, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, Status.CREATOR);
        if (status == null) {
            throw new ApiException(Status.f71541k);
        }
        if (!status.w0()) {
            throw new ApiException(status);
        }
        AuthorizationResult authorizationResult = (AuthorizationResult) SafeParcelableSerializer.b(intent, "authorization_result", AuthorizationResult.CREATOR);
        if (authorizationResult != null) {
            return authorizationResult;
        }
        throw new ApiException(Status.f71539i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zbaa(Context context, zbc zbcVar) {
        Api api = zbc;
        zbb zbbVarC = zbb.c(zbcVar);
        zbbVarC.a(zbat.zba());
        super(context, api, zbbVarC.b(), GoogleApi.Settings.f71506c);
    }
}
