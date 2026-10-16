package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaam extends zabg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ConnectionResult f71657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zaao f71658c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zaam(zaao zaaoVar, zabf zabfVar, ConnectionResult connectionResult) {
        super(zabfVar);
        this.f71658c = zaaoVar;
        this.f71657b = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.zabg
    public final void a() {
        this.f71658c.f71661c.l(this.f71657b);
    }
}
