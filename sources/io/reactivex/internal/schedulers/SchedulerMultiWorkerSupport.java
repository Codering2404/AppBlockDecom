package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public interface SchedulerMultiWorkerSupport {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface WorkerCallback {
        void a(int i3, Scheduler.Worker worker);
    }

    void a(int i3, WorkerCallback workerCallback);
}
