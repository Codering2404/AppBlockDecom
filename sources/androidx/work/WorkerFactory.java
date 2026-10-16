package androidx.work;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class WorkerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f54605a = Logger.i("WorkerFactory");

    public static WorkerFactory c() {
        return new WorkerFactory() { // from class: androidx.work.WorkerFactory.1
            @Override // androidx.work.WorkerFactory
            public ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
                return null;
            }
        };
    }

    public abstract ListenableWorker a(Context context, String str, WorkerParameters workerParameters);

    public final ListenableWorker b(Context context, String str, WorkerParameters workerParameters) {
        Class clsAsSubclass;
        ListenableWorker listenableWorkerA = a(context, str, workerParameters);
        if (listenableWorkerA == null) {
            try {
                clsAsSubclass = Class.forName(str).asSubclass(ListenableWorker.class);
            } catch (Throwable th) {
                Logger.e().d(f54605a, "Invalid class: " + str, th);
                clsAsSubclass = null;
            }
            if (clsAsSubclass != null) {
                try {
                    listenableWorkerA = (ListenableWorker) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
                } catch (Throwable th2) {
                    Logger.e().d(f54605a, "Could not instantiate " + str, th2);
                }
            }
        }
        if (listenableWorkerA == null || !listenableWorkerA.isUsed()) {
            return listenableWorkerA;
        }
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
