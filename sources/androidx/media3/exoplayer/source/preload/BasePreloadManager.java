package androidx.media3.exoplayer.source.preload;

import android.os.Handler;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.preload.TargetPreloadStatusControl;
import java.util.Comparator;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePreloadManager<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f45202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Comparator f45203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TargetPreloadStatusControl f45204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ListenerSet f45205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f45206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PriorityQueue f45207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TargetPreloadStatusControl.PreloadStatus f45208g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static abstract class BuilderBase<T> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class MediaSourceHolder implements Comparable<BasePreloadManager<T>.MediaSourceHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaSource f45209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f45210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f45211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ BasePreloadManager f45212d;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(MediaSourceHolder mediaSourceHolder) {
            return this.f45212d.f45203b.compare(this.f45210b, mediaSourceHolder.f45210b);
        }
    }

    public static /* synthetic */ void a(BasePreloadManager basePreloadManager, final MediaSource mediaSource) {
        basePreloadManager.f45205d.j(-1, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.source.preload.c
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((PreloadManagerListener) obj).a(mediaSource.m());
            }
        });
        basePreloadManager.i(mediaSource);
    }

    public static /* synthetic */ void c(BasePreloadManager basePreloadManager, final PreloadException preloadException, MediaSource mediaSource) {
        basePreloadManager.f45205d.j(-1, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.source.preload.e
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                ((PreloadManagerListener) obj).b(preloadException);
            }
        });
        basePreloadManager.i(mediaSource);
    }

    private boolean h(MediaSource mediaSource) {
        return !this.f45207f.isEmpty() && ((MediaSourceHolder) Assertions.e((MediaSourceHolder) this.f45207f.peek())).f45209a == mediaSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(MediaSource mediaSource) {
        synchronized (this.f45202a) {
            try {
                if (h(mediaSource)) {
                    do {
                        this.f45207f.poll();
                        if (this.f45207f.isEmpty()) {
                            break;
                        }
                    } while (!j());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean j() {
        if (!o()) {
            return false;
        }
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.e((MediaSourceHolder) this.f45207f.peek());
        TargetPreloadStatusControl.PreloadStatus preloadStatusA = this.f45204c.a(mediaSourceHolder.f45210b);
        this.f45208g = preloadStatusA;
        if (preloadStatusA != null) {
            n(mediaSourceHolder.f45209a, mediaSourceHolder.f45211c);
            return true;
        }
        f(mediaSourceHolder.f45209a);
        return false;
    }

    protected abstract void f(MediaSource mediaSource);

    protected final TargetPreloadStatusControl.PreloadStatus g(MediaSource mediaSource) {
        synchronized (this.f45202a) {
            try {
                if (!h(mediaSource)) {
                    return null;
                }
                return this.f45208g;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final void k(final MediaSource mediaSource) {
        synchronized (this.f45202a) {
            try {
                if (h(mediaSource)) {
                    this.f45206e.post(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            BasePreloadManager.a(this.f45256a, mediaSource);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final void l(final PreloadException preloadException, final MediaSource mediaSource) {
        synchronized (this.f45202a) {
            try {
                if (h(mediaSource)) {
                    this.f45206e.post(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            BasePreloadManager.c(this.f45259a, preloadException, mediaSource);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final void m(final MediaSource mediaSource) {
        synchronized (this.f45202a) {
            try {
                if (h(mediaSource)) {
                    this.f45206e.post(new Runnable() { // from class: androidx.media3.exoplayer.source.preload.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f45254a.i(mediaSource);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected abstract void n(MediaSource mediaSource, long j3);

    protected boolean o() {
        return true;
    }
}
