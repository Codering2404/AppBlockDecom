package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PendingIntentCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api23Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api26Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GatedCallback implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CountDownLatch f33782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private PendingIntent.OnFinished f33783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f33784c;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.f33784c) {
                this.f33783b = null;
            }
            this.f33782a.countDown();
        }
    }

    private static int a(boolean z2, int i3) {
        int i4;
        if (!z2) {
            i4 = 67108864;
        } else {
            if (Build.VERSION.SDK_INT < 31) {
                return i3;
            }
            i4 = 33554432;
        }
        return i4 | i3;
    }

    public static PendingIntent b(Context context, int i3, Intent intent, int i4, boolean z2) {
        return PendingIntent.getActivity(context, i3, intent, a(z2, i4));
    }
}
