package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.auth.zzap;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzl extends TaskApiCall {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected TaskCompletionSource f71010d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* bridge */ /* synthetic */ void b(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) {
        this.f71010d = taskCompletionSource;
        f((zzau) ((zzap) anyClient).getService());
    }

    protected abstract void f(zzau zzauVar);
}
