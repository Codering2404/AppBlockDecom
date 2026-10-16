package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zbw implements LoaderManager.LoaderCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SignInHubActivity f71263a;

    /* synthetic */ zbw(SignInHubActivity signInHubActivity, zbv zbvVar) {
        this.f71263a = signInHubActivity;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final /* bridge */ /* synthetic */ void a(Loader loader, Object obj) {
        SignInHubActivity signInHubActivity = this.f71263a;
        signInHubActivity.setResult(signInHubActivity.f71240d, signInHubActivity.f71241f);
        this.f71263a.finish();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final Loader b(int i3, Bundle bundle) {
        return new zbc(this.f71263a, GoogleApiClient.i());
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final void c(Loader loader) {
    }
}
