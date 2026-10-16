package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaae extends zap {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArraySet f71644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final GoogleApiManager f71645g;

    zaae(LifecycleFragment lifecycleFragment, GoogleApiManager googleApiManager, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment, googleApiAvailability);
        this.f71644f = new ArraySet();
        this.f71645g = googleApiManager;
        this.mLifecycleFragment.a("ConnectionlessLifecycleHelper", this);
    }

    public static void j(Activity activity, GoogleApiManager googleApiManager, ApiKey apiKey) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        zaae zaaeVar = (zaae) fragment.c("ConnectionlessLifecycleHelper", zaae.class);
        if (zaaeVar == null) {
            zaaeVar = new zaae(fragment, googleApiManager, GoogleApiAvailability.q());
        }
        Preconditions.n(apiKey, "ApiKey cannot be null");
        zaaeVar.f71644f.add(apiKey);
        googleApiManager.b(zaaeVar);
    }

    private final void k() {
        if (this.f71644f.isEmpty()) {
            return;
        }
        this.f71645g.b(this);
    }

    @Override // com.google.android.gms.common.api.internal.zap
    protected final void b(ConnectionResult connectionResult, int i3) {
        this.f71645g.G(connectionResult, i3);
    }

    @Override // com.google.android.gms.common.api.internal.zap
    protected final void c() {
        this.f71645g.H();
    }

    final ArraySet i() {
        return this.f71644f;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onResume() {
        super.onResume();
        k();
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        k();
    }

    @Override // com.google.android.gms.common.api.internal.zap, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        this.f71645g.c(this);
    }
}
