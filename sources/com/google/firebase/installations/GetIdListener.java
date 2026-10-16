package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class GetIdListener implements StateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f89248a;

    public GetIdListener(TaskCompletionSource taskCompletionSource) {
        this.f89248a = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean a(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.l() && !persistedInstallationEntry.k() && !persistedInstallationEntry.i()) {
            return false;
        }
        this.f89248a.trySetResult(persistedInstallationEntry.d());
        return true;
    }
}
