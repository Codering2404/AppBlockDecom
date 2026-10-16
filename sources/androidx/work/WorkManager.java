package androidx.work;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.work.impl.WorkManagerImpl;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class WorkManager {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum UpdateResult {
        NOT_APPLIED,
        APPLIED_IMMEDIATELY,
        APPLIED_FOR_NEXT_RUN
    }

    protected WorkManager() {
    }

    public static WorkManager h(Context context) {
        return WorkManagerImpl.r(context);
    }

    public static void l(Context context, Configuration configuration) {
        WorkManagerImpl.l(context, configuration);
    }

    public abstract Operation a(String str);

    public abstract Operation b(String str);

    public final Operation c(WorkRequest workRequest) {
        return d(Collections.singletonList(workRequest));
    }

    public abstract Operation d(List list);

    public abstract Operation e(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest);

    public Operation f(String str, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        return g(str, existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract Operation g(String str, ExistingWorkPolicy existingWorkPolicy, List list);

    public abstract LiveData i(UUID uuid);

    public abstract ListenableFuture j(String str);

    public abstract ListenableFuture k(String str);
}
