package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zau extends zaa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f72180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f72181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ InstallStatusListener f72182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zay f72183d;

    zau(zay zayVar, AtomicReference atomicReference, TaskCompletionSource taskCompletionSource, InstallStatusListener installStatusListener) {
        this.f72183d = zayVar;
        this.f72180a = atomicReference;
        this.f72181b = taskCompletionSource;
        this.f72182c = installStatusListener;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void I3(Status status, ModuleInstallResponse moduleInstallResponse) {
        if (moduleInstallResponse != null) {
            this.f72180a.set(moduleInstallResponse);
        }
        TaskUtil.c(status, null, this.f72181b);
        if (!status.w0() || (moduleInstallResponse != null && moduleInstallResponse.N())) {
            this.f72183d.doUnregisterEventListener(ListenerHolders.c(this.f72182c, InstallStatusListener.class.getSimpleName()), 27306);
        }
    }
}
