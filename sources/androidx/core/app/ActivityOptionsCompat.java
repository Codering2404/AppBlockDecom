package androidx.core.app;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ActivityOptionsCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ActivityOptions f33577a;

        ActivityOptionsCompatImpl(ActivityOptions activityOptions) {
            this.f33577a = activityOptions;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Bundle b() {
            return this.f33577a.toBundle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api23Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api33Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api34Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BackgroundActivityStartMode {
    }

    protected ActivityOptionsCompat() {
    }

    public static ActivityOptionsCompat a(Context context, int i3, int i4) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation(context, i3, i4));
    }

    public Bundle b() {
        return null;
    }
}
