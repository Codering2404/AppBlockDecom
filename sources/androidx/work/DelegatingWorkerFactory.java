package androidx.work;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DelegatingWorkerFactory extends WorkerFactory {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f54512c = Logger.i("DelegatingWkrFctry");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f54513b;

    @Override // androidx.work.WorkerFactory
    public final ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
        Iterator it = this.f54513b.iterator();
        while (it.hasNext()) {
            try {
                ListenableWorker listenableWorkerA = ((WorkerFactory) it.next()).a(context, str, workerParameters);
                if (listenableWorkerA != null) {
                    return listenableWorkerA;
                }
            } catch (Throwable th) {
                Logger.e().d(f54512c, "Unable to instantiate a ListenableWorker (" + str + ")", th);
                throw th;
            }
        }
        return null;
    }
}
