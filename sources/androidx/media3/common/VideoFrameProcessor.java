package androidx.media3.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import androidx.media3.common.util.TimestampIterator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface VideoFrameProcessor {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {
        VideoFrameProcessor a(Context context, DebugViewProvider debugViewProvider, ColorInfo colorInfo, boolean z2, Executor executor, Listener listener);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputType {
    }

    Surface a();

    void b(long j3);

    void d();

    void e(Runnable runnable);

    void f(SurfaceInfo surfaceInfo);

    void flush();

    boolean g(Bitmap bitmap, TimestampIterator timestampIterator);

    boolean h(int i3, long j3);

    void i(OnInputFrameProcessedListener onInputFrameProcessedListener);

    void j(int i3, Format format, List list, long j3);

    boolean k();

    int l();

    void release();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        default void b() {
        }

        default void a(VideoFrameProcessingException videoFrameProcessingException) {
        }

        default void c(long j3) {
        }

        default void e(float f3) {
        }

        default void d(int i3, int i4) {
        }

        default void f(int i3, Format format, List list) {
        }
    }
}
