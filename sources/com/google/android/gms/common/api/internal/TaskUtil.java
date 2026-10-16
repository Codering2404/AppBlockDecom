package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TaskUtil {
    public static void a(Status status, TaskCompletionSource taskCompletionSource) {
        b(status, null, taskCompletionSource);
    }

    public static void b(Status status, Object obj, TaskCompletionSource taskCompletionSource) {
        if (status.w0()) {
            taskCompletionSource.setResult(obj);
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.a(status));
        }
    }

    public static boolean c(Status status, Object obj, TaskCompletionSource taskCompletionSource) {
        return status.w0() ? taskCompletionSource.trySetResult(obj) : taskCompletionSource.trySetException(ApiExceptionUtil.a(status));
    }
}
