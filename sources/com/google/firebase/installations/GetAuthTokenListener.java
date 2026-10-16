package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class GetAuthTokenListener implements StateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Utils f89246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TaskCompletionSource f89247b;

    public GetAuthTokenListener(Utils utils, TaskCompletionSource taskCompletionSource) {
        this.f89246a = utils;
        this.f89247b = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean a(Exception exc) {
        this.f89247b.trySetException(exc);
        return true;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.k() || this.f89246a.f(persistedInstallationEntry)) {
            return false;
        }
        this.f89247b.setResult(InstallationTokenResult.a().b(persistedInstallationEntry.b()).d(persistedInstallationEntry.c()).c(persistedInstallationEntry.h()).a());
        return true;
    }
}
