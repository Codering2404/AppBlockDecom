package com.google.android.gms.common.moduleinstall.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zam implements RemoteCall {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zay f72169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ApiFeatureRequest f72170b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zaf) ((zaz) obj).getService()).j5(new zax(this.f72169a, (TaskCompletionSource) obj2), this.f72170b);
    }
}
