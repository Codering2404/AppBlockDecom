package com.google.android.gms.internal.p000authapi;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.identity.zbv;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zbaq extends GoogleApi implements SignInClient {
    private static final Api.ClientKey zba;
    private static final Api.AbstractClientBuilder zbb;
    private static final Api zbc;
    private final String zbd;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        zbal zbalVar = new zbal();
        zbb = zbalVar;
        zbc = new Api("Auth.Api.Identity.SignIn.API", zbalVar, clientKey);
    }

    public zbaq(Activity activity, zbv zbvVar) {
        super(activity, zbc, (Api.ApiOptions) zbvVar, GoogleApi.Settings.f71506c);
        this.zbd = zbat.zba();
    }

    @Override // com.google.android.gms.auth.api.identity.SignInClient
    public final Task<BeginSignInResult> beginSignIn(BeginSignInRequest beginSignInRequest) {
        Preconditions.m(beginSignInRequest);
        BeginSignInRequest.Builder builderH1 = BeginSignInRequest.h1(beginSignInRequest);
        builderH1.h(this.zbd);
        final BeginSignInRequest beginSignInRequestA = builderH1.a();
        return doRead(TaskApiCall.a().d(new Feature("auth_api_credentials_begin_sign_in", 8L)).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbaj
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zbw) ((zbar) obj).getService()).zbc(new zbam(this.zba, (TaskCompletionSource) obj2), (BeginSignInRequest) Preconditions.m(beginSignInRequestA));
            }
        }).c(false).e(1553).a());
    }

    public final String getPhoneNumberFromIntent(Intent intent) throws ApiException {
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
        String stringExtra = intent.getStringExtra("phone_number_hint_result");
        if (stringExtra != null) {
            return stringExtra;
        }
        throw new ApiException(Status.f71539i);
    }

    public final Task<PendingIntent> getPhoneNumberHintIntent(final GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest) {
        Preconditions.m(getPhoneNumberHintIntentRequest);
        return doRead(TaskApiCall.a().d(zbas.zbh).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbah
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                this.zba.zba(getPhoneNumberHintIntentRequest, (zbar) obj, (TaskCompletionSource) obj2);
            }
        }).e(1653).a());
    }

    @Override // com.google.android.gms.auth.api.identity.SignInClient
    public final SignInCredential getSignInCredentialFromIntent(Intent intent) throws ApiException {
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
        SignInCredential signInCredential = (SignInCredential) SafeParcelableSerializer.b(intent, "sign_in_credential", SignInCredential.CREATOR);
        if (signInCredential != null) {
            return signInCredential;
        }
        throw new ApiException(Status.f71539i);
    }

    @Override // com.google.android.gms.auth.api.identity.SignInClient
    public final Task<PendingIntent> getSignInIntent(GetSignInIntentRequest getSignInIntentRequest) {
        Preconditions.m(getSignInIntentRequest);
        GetSignInIntentRequest.Builder builderW0 = GetSignInIntentRequest.w0(getSignInIntentRequest);
        builderW0.f(this.zbd);
        final GetSignInIntentRequest getSignInIntentRequestA = builderW0.a();
        return doRead(TaskApiCall.a().d(zbas.zbf).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbak
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zbw) ((zbar) obj).getService()).zbe(new zbao(this.zba, (TaskCompletionSource) obj2), (GetSignInIntentRequest) Preconditions.m(getSignInIntentRequestA));
            }
        }).e(1555).a());
    }

    @Override // com.google.android.gms.auth.api.identity.SignInClient
    public final Task<Void> signOut() {
        getApplicationContext().getSharedPreferences("com.google.android.gms.signin", 0).edit().clear().apply();
        Iterator it = GoogleApiClient.i().iterator();
        while (it.hasNext()) {
            ((GoogleApiClient) it.next()).n();
        }
        GoogleApiManager.a();
        return doWrite(TaskApiCall.a().d(zbas.zbb).b(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbai
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                this.zba.zbb((zbar) obj, (TaskCompletionSource) obj2);
            }
        }).c(false).e(1554).a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ void zba(GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest, zbar zbarVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zbw) zbarVar.getService()).zbd(new zbap(this, taskCompletionSource), getPhoneNumberHintIntentRequest, this.zbd);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ void zbb(zbar zbarVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zbw) zbarVar.getService()).zbf(new zban(this, taskCompletionSource), this.zbd);
    }

    public zbaq(Context context, zbv zbvVar) {
        super(context, zbc, zbvVar, GoogleApi.Settings.f71506c);
        this.zbd = zbat.zba();
    }
}
