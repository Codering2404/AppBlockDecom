package androidx.media3.transformer;

import android.os.Looper;
import androidx.media3.common.Format;
import com.google.common.collect.ImmutableMap;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface AssetLoader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CompositionSettings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f47901b;

        public CompositionSettings(int i3, boolean z2) {
            this.f47900a = i3;
            this.f47901b = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory {
        AssetLoader a(EditedMediaItem editedMediaItem, Looper looper, Listener listener, CompositionSettings compositionSettings);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        SampleConsumer a(Format format);

        boolean b(Format format, int i3);

        void c(int i3);

        void d(ExportException exportException);

        void f(long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedOutputTypes {
    }

    int e(ProgressHolder progressHolder);

    ImmutableMap g();

    void release();

    void start();
}
