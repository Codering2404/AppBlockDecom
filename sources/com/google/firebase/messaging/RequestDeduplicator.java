package com.google.firebase.messaging;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class RequestDeduplicator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f89449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f89450b = new ArrayMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface GetTokenRequest {
        Task start();
    }

    RequestDeduplicator(Executor executor) {
        this.f89449a = executor;
    }

    public static /* synthetic */ Task a(RequestDeduplicator requestDeduplicator, String str, Task task) {
        synchronized (requestDeduplicator) {
            requestDeduplicator.f89450b.remove(str);
        }
        return task;
    }

    synchronized Task b(final String str, GetTokenRequest getTokenRequest) {
        Task task = (Task) this.f89450b.get(str);
        if (task != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Joining ongoing request for: " + str);
            }
            return task;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Making new request for: " + str);
        }
        Task taskContinueWithTask = getTokenRequest.start().continueWithTask(this.f89449a, new Continuation() { // from class: com.google.firebase.messaging.z
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return RequestDeduplicator.a(this.f89612a, str, task2);
            }
        });
        this.f89450b.put(str, taskContinueWithTask);
        return taskContinueWithTask;
    }
}
