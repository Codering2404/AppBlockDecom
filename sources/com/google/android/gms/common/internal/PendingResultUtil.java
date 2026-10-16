package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PendingResultUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zas f72012a = new zao();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ResultConverter<R extends Result, T> {
        Object a(Result result);
    }

    public static Task a(PendingResult pendingResult, ResultConverter resultConverter) {
        zas zasVar = f72012a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        pendingResult.addStatusListener(new zap(pendingResult, taskCompletionSource, resultConverter, zasVar));
        return taskCompletionSource.getTask();
    }

    public static Task b(PendingResult pendingResult) {
        return a(pendingResult, new zar());
    }
}
