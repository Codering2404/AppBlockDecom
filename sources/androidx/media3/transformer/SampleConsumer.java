package androidx.media3.transformer;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.media3.common.util.TimestampIterator;
import androidx.media3.decoder.DecoderInputBuffer;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface SampleConsumer {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputResult {
    }

    default Surface a() {
        throw new UnsupportedOperationException();
    }

    default boolean c() {
        throw new UnsupportedOperationException();
    }

    default int d() {
        throw new UnsupportedOperationException();
    }

    default void e(Runnable runnable) {
        throw new UnsupportedOperationException();
    }

    default DecoderInputBuffer f() {
        throw new UnsupportedOperationException();
    }

    default int g(Bitmap bitmap, TimestampIterator timestampIterator) {
        throw new UnsupportedOperationException();
    }

    default void h() {
        throw new UnsupportedOperationException();
    }

    default boolean i(long j3) {
        throw new UnsupportedOperationException();
    }
}
