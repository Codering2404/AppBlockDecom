package com.google.android.libraries.places.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzmb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f78184a = new HashMap();

    public zzmb(zzlx zzlxVar) {
    }

    public final Task a(Task task, CancellationToken cancellationToken, long j3, String str) {
        final TaskCompletionSource taskCompletionSource = cancellationToken == null ? new TaskCompletionSource() : new TaskCompletionSource(cancellationToken);
        Map map = this.f78184a;
        if (!map.containsKey(taskCompletionSource)) {
            HandlerThread handlerThread = new HandlerThread("timeoutHandlerThread");
            handlerThread.start();
            map.put(taskCompletionSource, handlerThread);
            final String str2 = "Location timeout.";
            new Handler(handlerThread.getLooper()).postDelayed(new Runnable(str2) { // from class: com.google.android.libraries.places.internal.zzma
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f78183a.trySetException(new ApiException(new Status(15, "Location timeout.")));
                }
            }, j3);
        }
        task.continueWithTask(new Continuation(this) { // from class: com.google.android.libraries.places.internal.zzly
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task2) {
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                Exception exception = task2.getException();
                if (task2.isSuccessful()) {
                    taskCompletionSource2.setResult(task2.getResult());
                } else if (!task2.isCanceled() && exception != null) {
                    taskCompletionSource2.setException(exception);
                }
                return taskCompletionSource2.getTask();
            }
        });
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.libraries.places.internal.zzlz
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task2) {
                this.f78181a.b(taskCompletionSource, task2);
            }
        });
        return taskCompletionSource.getTask();
    }

    final /* synthetic */ void b(TaskCompletionSource taskCompletionSource, Task task) {
        HandlerThread handlerThread = (HandlerThread) this.f78184a.remove(taskCompletionSource);
        if (handlerThread == null) {
            return;
        }
        handlerThread.quit();
    }
}
