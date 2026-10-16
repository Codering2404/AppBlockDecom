package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd extends zzz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseGmsClient f72098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72099b;

    public zzd(BaseGmsClient baseGmsClient, int i3) {
        this.f72098a = baseGmsClient;
        this.f72099b = i3;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void R3(int i3, IBinder iBinder, zzj zzjVar) {
        BaseGmsClient baseGmsClient = this.f72098a;
        Preconditions.n(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.m(zzjVar);
        baseGmsClient.zzc(zzjVar);
        a1(i3, iBinder, zzjVar.f72106a);
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void a1(int i3, IBinder iBinder, Bundle bundle) {
        Preconditions.n(this.f72098a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f72098a.onPostInitHandler(i3, iBinder, bundle, this.f72099b);
        this.f72098a = null;
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void c3(int i3, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
