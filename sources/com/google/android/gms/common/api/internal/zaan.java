package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaan extends zabg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks f71659b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zaan(zaao zaaoVar, zabf zabfVar, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zabfVar);
        this.f71659b = connectionProgressReportCallbacks;
    }

    @Override // com.google.android.gms.common.api.internal.zabg
    public final void a() {
        this.f71659b.a(new ConnectionResult(16, null));
    }
}
