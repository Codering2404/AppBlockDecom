package com.google.android.libraries.places.internal;

import android.net.Uri;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriResponse;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzii implements SuccessContinuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ zzii f77954a = new zzii();

    private /* synthetic */ zzii() {
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final /* synthetic */ Task then(Object obj) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(FetchResolvedPhotoUriResponse.b(Uri.parse(((zzayo) obj).G())));
        return taskCompletionSource.getTask();
    }
}
