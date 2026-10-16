package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zza extends zzc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f72083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f72084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f72085f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected zza(BaseGmsClient baseGmsClient, int i3, Bundle bundle) {
        super(baseGmsClient, Boolean.TRUE);
        java.util.Objects.requireNonNull(baseGmsClient);
        this.f72085f = baseGmsClient;
        this.f72083d = i3;
        this.f72084e = bundle;
    }

    @Override // com.google.android.gms.common.internal.zzc
    protected final /* bridge */ /* synthetic */ void a(Object obj) {
        int i3 = this.f72083d;
        if (i3 != 0) {
            this.f72085f.zzd(1, null);
            Bundle bundle = this.f72084e;
            f(new ConnectionResult(i3, bundle != null ? (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT) : null));
        } else {
            if (e()) {
                return;
            }
            this.f72085f.zzd(1, null);
            f(new ConnectionResult(8, null));
        }
    }

    protected abstract boolean e();

    protected abstract void f(ConnectionResult connectionResult);
}
