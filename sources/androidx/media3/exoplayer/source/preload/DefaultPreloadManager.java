package androidx.media3.exoplayer.source.preload;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.preload.BasePreloadManager;
import androidx.media3.exoplayer.source.preload.DefaultPreloadManager;
import androidx.media3.exoplayer.source.preload.PreloadMediaSource;
import androidx.media3.exoplayer.source.preload.TargetPreloadStatusControl;
import com.google.common.base.Predicate;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultPreloadManager extends BasePreloadManager<Integer> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder extends BasePreloadManager.BuilderBase<Integer> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RankingDataComparator implements Comparator<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f45213a;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Integer num, Integer num2) {
            return Integer.compare(Math.abs(num.intValue() - this.f45213a), Math.abs(num2.intValue() - this.f45213a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class SourcePreloadControl implements PreloadMediaSource.PreloadControl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DefaultPreloadManager f45214a;

        public static /* synthetic */ boolean g(long j3, Status status) {
            return status.a() == 2 && status.b() > Util.t1(j3);
        }

        public static /* synthetic */ boolean h(Status status) {
            return status.a() > 1;
        }

        public static /* synthetic */ boolean i(Status status) {
            return status.a() > 0;
        }

        private boolean j(PreloadMediaSource preloadMediaSource, Predicate predicate, boolean z2) {
            TargetPreloadStatusControl.PreloadStatus preloadStatusG = this.f45214a.g(preloadMediaSource);
            if (preloadStatusG == null) {
                this.f45214a.m(preloadMediaSource);
                return false;
            }
            if (predicate.apply((Status) Assertions.e((Status) preloadStatusG))) {
                return true;
            }
            if (z2) {
                this.f45214a.f(preloadMediaSource);
            }
            this.f45214a.k(preloadMediaSource);
            return false;
        }

        @Override // androidx.media3.exoplayer.source.preload.PreloadMediaSource.PreloadControl
        public void a(PreloadMediaSource preloadMediaSource) {
            this.f45214a.k(preloadMediaSource);
        }

        @Override // androidx.media3.exoplayer.source.preload.PreloadMediaSource.PreloadControl
        public void b(PreloadMediaSource preloadMediaSource) {
            this.f45214a.m(preloadMediaSource);
        }

        @Override // androidx.media3.exoplayer.source.preload.PreloadMediaSource.PreloadControl
        public boolean c(PreloadMediaSource preloadMediaSource, final long j3) {
            return j(preloadMediaSource, new Predicate() { // from class: androidx.media3.exoplayer.source.preload.h
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return DefaultPreloadManager.SourcePreloadControl.g(j3, (DefaultPreloadManager.Status) obj);
                }
            }, false);
        }

        @Override // androidx.media3.exoplayer.source.preload.PreloadMediaSource.PreloadControl
        public boolean d(PreloadMediaSource preloadMediaSource) {
            return j(preloadMediaSource, new Predicate() { // from class: androidx.media3.exoplayer.source.preload.g
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return DefaultPreloadManager.SourcePreloadControl.i((DefaultPreloadManager.Status) obj);
                }
            }, true);
        }

        @Override // androidx.media3.exoplayer.source.preload.PreloadMediaSource.PreloadControl
        public boolean e(PreloadMediaSource preloadMediaSource) {
            return j(preloadMediaSource, new Predicate() { // from class: androidx.media3.exoplayer.source.preload.f
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return DefaultPreloadManager.SourcePreloadControl.h((DefaultPreloadManager.Status) obj);
                }
            }, false);
        }

        @Override // androidx.media3.exoplayer.source.preload.PreloadMediaSource.PreloadControl
        public void f(PreloadException preloadException, PreloadMediaSource preloadMediaSource) {
            this.f45214a.l(preloadException, preloadMediaSource);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Status implements TargetPreloadStatusControl.PreloadStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f45215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f45216b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Stage {
        }

        public int a() {
            return this.f45215a;
        }

        public long b() {
            return this.f45216b;
        }
    }

    @Override // androidx.media3.exoplayer.source.preload.BasePreloadManager
    protected void f(MediaSource mediaSource) {
        Assertions.a(mediaSource instanceof PreloadMediaSource);
        ((PreloadMediaSource) mediaSource).W0();
    }

    @Override // androidx.media3.exoplayer.source.preload.BasePreloadManager
    protected void n(MediaSource mediaSource, long j3) {
        Assertions.a(mediaSource instanceof PreloadMediaSource);
        ((PreloadMediaSource) mediaSource).b1(j3);
    }
}
