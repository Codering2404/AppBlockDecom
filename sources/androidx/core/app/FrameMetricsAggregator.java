package androidx.core.app;

import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FrameMetricsAggregator {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f33598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        SparseIntArray[] f33599b;

        /* JADX INFO: renamed from: androidx.core.app.FrameMetricsAggregator$FrameMetricsApi24Impl$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Window.OnFrameMetricsAvailableListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ FrameMetricsApi24Impl f33600a;

            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i3) {
                FrameMetricsApi24Impl frameMetricsApi24Impl = this.f33600a;
                if ((frameMetricsApi24Impl.f33598a & 1) != 0) {
                    frameMetricsApi24Impl.a(frameMetricsApi24Impl.f33599b[0], frameMetrics.getMetric(8));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl2 = this.f33600a;
                if ((frameMetricsApi24Impl2.f33598a & 2) != 0) {
                    frameMetricsApi24Impl2.a(frameMetricsApi24Impl2.f33599b[1], frameMetrics.getMetric(1));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl3 = this.f33600a;
                if ((frameMetricsApi24Impl3.f33598a & 4) != 0) {
                    frameMetricsApi24Impl3.a(frameMetricsApi24Impl3.f33599b[2], frameMetrics.getMetric(3));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl4 = this.f33600a;
                if ((frameMetricsApi24Impl4.f33598a & 8) != 0) {
                    frameMetricsApi24Impl4.a(frameMetricsApi24Impl4.f33599b[3], frameMetrics.getMetric(4));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl5 = this.f33600a;
                if ((frameMetricsApi24Impl5.f33598a & 16) != 0) {
                    frameMetricsApi24Impl5.a(frameMetricsApi24Impl5.f33599b[4], frameMetrics.getMetric(5));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl6 = this.f33600a;
                if ((frameMetricsApi24Impl6.f33598a & 64) != 0) {
                    frameMetricsApi24Impl6.a(frameMetricsApi24Impl6.f33599b[6], frameMetrics.getMetric(7));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl7 = this.f33600a;
                if ((frameMetricsApi24Impl7.f33598a & 32) != 0) {
                    frameMetricsApi24Impl7.a(frameMetricsApi24Impl7.f33599b[5], frameMetrics.getMetric(6));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl8 = this.f33600a;
                if ((frameMetricsApi24Impl8.f33598a & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                    frameMetricsApi24Impl8.a(frameMetricsApi24Impl8.f33599b[7], frameMetrics.getMetric(0));
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl9 = this.f33600a;
                if ((frameMetricsApi24Impl9.f33598a & Function.MAX_NARGS) != 0) {
                    frameMetricsApi24Impl9.a(frameMetricsApi24Impl9.f33599b[8], frameMetrics.getMetric(2));
                }
            }
        }

        void a(SparseIntArray sparseIntArray, long j3) {
            if (sparseIntArray != null) {
                int i3 = (int) ((500000 + j3) / 1000000);
                if (j3 >= 0) {
                    sparseIntArray.put(i3, sparseIntArray.get(i3) + 1);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FrameMetricsBaseImpl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetricType {
    }
}
