package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class VelocityTrackerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map f34438a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api34Impl {
        static float a(VelocityTracker velocityTracker, int i3) {
            return velocityTracker.getAxisVelocity(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface VelocityTrackableMotionEventAxis {
    }

    public static void a(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!f34438a.containsKey(velocityTracker)) {
                f34438a.put(velocityTracker, new VelocityTrackerFallback());
            }
            ((VelocityTrackerFallback) f34438a.get(velocityTracker)).a(motionEvent);
        }
    }

    public static void b(VelocityTracker velocityTracker, int i3) {
        c(velocityTracker, i3, Float.MAX_VALUE);
    }

    public static void c(VelocityTracker velocityTracker, int i3, float f3) {
        velocityTracker.computeCurrentVelocity(i3, f3);
        VelocityTrackerFallback velocityTrackerFallbackE = e(velocityTracker);
        if (velocityTrackerFallbackE != null) {
            velocityTrackerFallbackE.c(i3, f3);
        }
    }

    public static float d(VelocityTracker velocityTracker, int i3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.a(velocityTracker, i3);
        }
        if (i3 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i3 == 1) {
            return velocityTracker.getYVelocity();
        }
        VelocityTrackerFallback velocityTrackerFallbackE = e(velocityTracker);
        if (velocityTrackerFallbackE != null) {
            return velocityTrackerFallbackE.d(i3);
        }
        return 0.0f;
    }

    private static VelocityTrackerFallback e(VelocityTracker velocityTracker) {
        return (VelocityTrackerFallback) f34438a.get(velocityTracker);
    }
}
