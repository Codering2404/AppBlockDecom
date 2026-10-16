package com.google.android.gms.common.moduleinstall.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zai implements RemoteCall {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zay f72159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f72160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InstallStatusListener f72161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ApiFeatureRequest f72162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zaab f72163e;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zaf) ((zaz) obj).getService()).i5(new zau(this.f72159a, this.f72160b, (TaskCompletionSource) obj2, this.f72161c), this.f72162d, this.f72163e);
    }
}
