package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ProfileInstallerInitializer implements Initializer<Result> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Handler28Impl {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Result {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: androidx.profileinstaller.e
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstaller.h(context);
            }
        });
    }

    @Override // androidx.startup.Initializer
    public List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.startup.Initializer
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Result create(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.profileinstaller.c
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j3) {
                this.f51436a.f(applicationContext);
            }
        });
        return new Result();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(final Context context) {
        Handler28Impl.a(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: androidx.profileinstaller.d
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.g(context);
            }
        }, new Random().nextInt(Math.max(1000, 1)) + 5000);
    }
}
