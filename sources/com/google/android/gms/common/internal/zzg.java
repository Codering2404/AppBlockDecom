package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzg extends zza {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f72104g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(BaseGmsClient baseGmsClient, int i3, Bundle bundle) {
        super(baseGmsClient, i3, bundle);
        java.util.Objects.requireNonNull(baseGmsClient);
        this.f72104g = baseGmsClient;
    }

    @Override // com.google.android.gms.common.internal.zza
    protected final boolean e() {
        this.f72104g.zzc.a(ConnectionResult.f71433g);
        return true;
    }

    @Override // com.google.android.gms.common.internal.zza
    protected final void f(ConnectionResult connectionResult) {
        BaseGmsClient baseGmsClient = this.f72104g;
        if (baseGmsClient.enableLocalFallback() && baseGmsClient.zzg()) {
            baseGmsClient.zzf(16);
        } else {
            baseGmsClient.zzc.a(connectionResult);
            baseGmsClient.onConnectionFailed(connectionResult);
        }
    }
}
