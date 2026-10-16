package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class SignInClientImpl extends GmsClient<zaf> implements com.google.android.gms.signin.zae {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f74562f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f74563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClientSettings f74564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f74565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f74566d;

    public SignInClientImpl(Context context, Looper looper, boolean z2, ClientSettings clientSettings, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.f74563a = true;
        this.f74564b = clientSettings;
        this.f74565c = bundle;
        this.f74566d = clientSettings.i();
    }

    public static Bundle g(ClientSettings clientSettings) {
        clientSettings.h();
        Integer numI = clientSettings.i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", clientSettings.a());
        if (numI != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numI.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.zae
    public final void a() {
        try {
            ((zaf) getService()).x3(((Integer) Preconditions.m(this.f74566d)).intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // com.google.android.gms.signin.zae
    public final void b() {
        connect(new BaseGmsClient.LegacyClientCallbackAdapter(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.zae
    public final void c(zae zaeVar) {
        Preconditions.n(zaeVar, "Expecting a valid ISignInCallbacks");
        try {
            Account accountC = this.f74564b.c();
            ((zaf) getService()).i5(new zai(1, new zat(accountC, ((Integer) Preconditions.m(this.f74566d)).intValue(), BaseGmsClient.DEFAULT_ACCOUNT.equals(accountC.name) ? Storage.b(getContext()).c() : null)), zaeVar);
        } catch (RemoteException e3) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zaeVar.m0(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e3);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zaf ? (zaf) iInterfaceQueryLocalInterface : new zaf(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.zae
    public final void d(IAccountAccessor iAccountAccessor, boolean z2) {
        try {
            ((zaf) getService()).h5(iAccountAccessor, ((Integer) Preconditions.m(this.f74566d)).intValue(), z2);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.f74564b.f())) {
            this.f74565c.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f74564b.f());
        }
        return this.f74565c;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        return this.f74563a;
    }
}
