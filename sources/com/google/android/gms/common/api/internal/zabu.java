package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zabu implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Api.Client f71768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ApiKey f71769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IAccountAccessor f71770c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set f71771d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f71772e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ GoogleApiManager f71773f;

    public zabu(GoogleApiManager googleApiManager, Api.Client client, ApiKey apiKey) {
        this.f71773f = googleApiManager;
        this.f71768a = client;
        this.f71769b = apiKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        IAccountAccessor iAccountAccessor;
        if (!this.f71772e || (iAccountAccessor = this.f71770c) == null) {
            return;
        }
        this.f71768a.getRemoteService(iAccountAccessor, this.f71771d);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void a(ConnectionResult connectionResult) {
        this.f71773f.f71578o.post(new zabt(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void b(IAccountAccessor iAccountAccessor, Set set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            c(new ConnectionResult(4));
        } else {
            this.f71770c = iAccountAccessor;
            this.f71771d = set;
            i();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void c(ConnectionResult connectionResult) {
        zabq zabqVar = (zabq) this.f71773f.f71574k.get(this.f71769b);
        if (zabqVar != null) {
            zabqVar.G(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void d(int i3) {
        zabq zabqVar = (zabq) this.f71773f.f71574k.get(this.f71769b);
        if (zabqVar != null) {
            if (zabqVar.f71759j) {
                zabqVar.G(new ConnectionResult(17));
            } else {
                zabqVar.onConnectionSuspended(i3);
            }
        }
    }
}
