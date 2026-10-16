package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zact extends com.google.android.gms.signin.internal.zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Api.AbstractClientBuilder f71806i = com.google.android.gms.signin.zad.f74579c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f71807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f71808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Api.AbstractClientBuilder f71809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f71810d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ClientSettings f71811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.google.android.gms.signin.zae f71812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zacs f71813h;

    public zact(Context context, Handler handler, ClientSettings clientSettings) {
        Api.AbstractClientBuilder abstractClientBuilder = f71806i;
        this.f71807a = context;
        this.f71808b = handler;
        this.f71811f = (ClientSettings) Preconditions.n(clientSettings, "ClientSettings must not be null");
        this.f71810d = clientSettings.g();
        this.f71809c = abstractClientBuilder;
    }

    static /* bridge */ /* synthetic */ void i5(zact zactVar, com.google.android.gms.signin.internal.zak zakVar) {
        ConnectionResult connectionResultM = zakVar.M();
        if (connectionResultM.w0()) {
            com.google.android.gms.common.internal.zav zavVar = (com.google.android.gms.common.internal.zav) Preconditions.m(zakVar.N());
            ConnectionResult connectionResultM2 = zavVar.M();
            if (!connectionResultM2.w0()) {
                String strValueOf = String.valueOf(connectionResultM2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                zactVar.f71813h.c(connectionResultM2);
                zactVar.f71812g.disconnect();
                return;
            }
            zactVar.f71813h.b(zavVar.N(), zactVar.f71810d);
        } else {
            zactVar.f71813h.c(connectionResultM);
        }
        zactVar.f71812g.disconnect();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    public final void j5(zacs zacsVar) {
        com.google.android.gms.signin.zae zaeVar = this.f71812g;
        if (zaeVar != null) {
            zaeVar.disconnect();
        }
        this.f71811f.l(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractClientBuilder abstractClientBuilder = this.f71809c;
        Context context = this.f71807a;
        Handler handler = this.f71808b;
        ClientSettings clientSettings = this.f71811f;
        this.f71812g = abstractClientBuilder.buildClient(context, handler.getLooper(), clientSettings, clientSettings.h(), (GoogleApiClient.ConnectionCallbacks) this, (GoogleApiClient.OnConnectionFailedListener) this);
        this.f71813h = zacsVar;
        Set set = this.f71810d;
        if (set == null || set.isEmpty()) {
            this.f71808b.post(new zacq(this));
        } else {
            this.f71812g.b();
        }
    }

    public final void k5() {
        com.google.android.gms.signin.zae zaeVar = this.f71812g;
        if (zaeVar != null) {
            zaeVar.disconnect();
        }
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void m0(com.google.android.gms.signin.internal.zak zakVar) {
        this.f71808b.post(new zacr(this, zakVar));
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.f71812g.c(this);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f71813h.c(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i3) {
        this.f71813h.d(i3);
    }
}
