package com.google.android.gms.common.moduleinstall.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zaj implements RemoteCall {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zay f72164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zaab f72165b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zaf) ((zaz) obj).getService()).k5(new zav(this.f72164a, (TaskCompletionSource) obj2), this.f72165b);
    }
}
