package androidx.media3.common.util;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BackgroundExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Executor f41478a;

    public static synchronized Executor a() {
        try {
            if (f41478a == null) {
                f41478a = Util.Q0("ExoPlayer:BackgroundExecutor");
            }
        } catch (Throwable th) {
            throw th;
        }
        return f41478a;
    }
}
