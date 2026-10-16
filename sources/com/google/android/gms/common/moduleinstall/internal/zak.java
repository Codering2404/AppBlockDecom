package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zak implements SuccessContinuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f72166a;

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        int i3 = zay.f72190d;
        AtomicReference atomicReference = this.f72166a;
        return atomicReference.get() != null ? Tasks.forResult((ModuleInstallResponse) atomicReference.get()) : Tasks.forException(new ApiException(Status.f71539i));
    }
}
