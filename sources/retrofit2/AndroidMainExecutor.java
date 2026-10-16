package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class AndroidMainExecutor implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f146821a = new Handler(Looper.getMainLooper());

    AndroidMainExecutor() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f146821a.post(runnable);
    }
}
