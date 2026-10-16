package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaax implements zabf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zabi f71690a;

    public zaax(zabi zabiVar) {
        this.f71690a = zabiVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void b() {
        Iterator it = this.f71690a.f71733g.values().iterator();
        while (it.hasNext()) {
            ((Api.Client) it.next()).disconnect();
        }
        this.f71690a.f71741o.f71716p = Collections.EMPTY_SET;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void c() throws Throwable {
        this.f71690a.m();
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl f(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.f71690a.f71741o.f71708h.add(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean g() {
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl h(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void a(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void e(int i3) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void d(ConnectionResult connectionResult, Api api, boolean z2) {
    }
}
