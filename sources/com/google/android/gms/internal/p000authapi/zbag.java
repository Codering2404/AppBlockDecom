package com.google.android.gms.internal.p000authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.auth.api.identity.CredentialSavingClient;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.auth.api.identity.zbi;
import com.google.android.gms.common.api.Api;
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
public final class zbag extends GoogleApi implements CredentialSavingClient {
    private static final Api.ClientKey zba;
    private static final Api.AbstractClientBuilder zbb;
    private static final Api zbc;
    private final String zbd;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        zbad zbadVar = new zbad();
        zbb = zbadVar;
        zbc = new Api("Auth.Api.Identity.CredentialSaving.API", zbadVar, clientKey);
    }

    public zbag(Activity activity, zbi zbiVar) {
        super(activity, zbc, (Api.ApiOptions) zbiVar, GoogleApi.Settings.f71506c);
        this.zbd = zbat.zba();
    }

    public final Status getStatusFromIntent(Intent intent) {
        if (intent == null) {
            return Status.f71539i;
        }
        Status status = (Status) SafeParcelableSerializer.b(intent, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, Status.CREATOR);
        return status == null ? Status.f71539i : status;
    }

    public final Task<SaveAccountLinkingTokenResult> saveAccountLinkingToken(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        Preconditions.m(saveAccountLinkingTokenRequest);
        SaveAccountLinkingTokenRequest.Builder builderW0 = SaveAccountLinkingTokenRequest.w0(saveAccountLinkingTokenRequest);
        builderW0.f(this.zbd);
        final SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequestA = builderW0.a();
        return doRead(TaskApiCall.a().d(zbas.zbg).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbab
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zbn) ((zbh) obj).getService()).zbc(new zbae(this.zba, (TaskCompletionSource) obj2), (SaveAccountLinkingTokenRequest) Preconditions.m(saveAccountLinkingTokenRequestA));
            }
        }).c(false).e(1535).a());
    }

    @Override // com.google.android.gms.auth.api.identity.CredentialSavingClient
    public final Task<SavePasswordResult> savePassword(SavePasswordRequest savePasswordRequest) {
        Preconditions.m(savePasswordRequest);
        SavePasswordRequest.Builder builderO = SavePasswordRequest.O(savePasswordRequest);
        builderO.c(this.zbd);
        final SavePasswordRequest savePasswordRequestA = builderO.a();
        return doRead(TaskApiCall.a().d(zbas.zbe).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbac
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zbn) ((zbh) obj).getService()).zbd(new zbaf(this.zba, (TaskCompletionSource) obj2), (SavePasswordRequest) Preconditions.m(savePasswordRequestA));
            }
        }).c(false).e(1536).a());
    }

    public zbag(Context context, zbi zbiVar) {
        super(context, zbc, zbiVar, GoogleApi.Settings.f71506c);
        this.zbd = zbat.zba();
    }
}
