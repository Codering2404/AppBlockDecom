package androidx.media3.exoplayer.upstream;

import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface LoadErrorHandlingPolicy {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FallbackOptions {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FallbackSelection {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FallbackType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class LoadErrorInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LoadEventInfo f45530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaLoadData f45531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IOException f45532c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f45533d;

        public LoadErrorInfo(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, int i3) {
            this.f45530a = loadEventInfo;
            this.f45531b = mediaLoadData;
            this.f45532c = iOException;
            this.f45533d = i3;
        }
    }

    long a(LoadErrorInfo loadErrorInfo);

    int b(int i3);

    default void c(long j3) {
    }
}
