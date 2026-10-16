package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SystemClock implements Clock {
    protected SystemClock() {
    }

    @Override // androidx.media3.common.util.Clock
    public long a() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // androidx.media3.common.util.Clock
    public long b() {
        return System.nanoTime();
    }

    @Override // androidx.media3.common.util.Clock
    public long c() {
        return android.os.SystemClock.uptimeMillis();
    }

    @Override // androidx.media3.common.util.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // androidx.media3.common.util.Clock
    public HandlerWrapper d(Looper looper, Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }

    @Override // androidx.media3.common.util.Clock
    public void e() {
    }
}
