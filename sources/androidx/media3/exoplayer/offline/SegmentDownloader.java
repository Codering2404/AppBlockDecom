package androidx.media3.exoplayer.offline;

import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.CacheKeyFactory;
import androidx.media3.datasource.cache.CacheWriter;
import androidx.media3.datasource.cache.ContentMetadata;
import androidx.media3.exoplayer.offline.Downloader;
import androidx.media3.exoplayer.offline.FilterableManifest;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SegmentDownloader<M extends FilterableManifest<M>> implements Downloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataSpec f44482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsingLoadable.Parser f44483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList f44484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CacheDataSource.Factory f44485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Cache f44486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CacheKeyFactory f44487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PriorityTaskManager f44488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Executor f44489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f44490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ArrayList f44491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f44492k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ProgressNotifier implements CacheWriter.ProgressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Downloader.ProgressListener f44496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f44497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f44498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f44499d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f44500e;

        public ProgressNotifier(Downloader.ProgressListener progressListener, long j3, int i3, long j4, int i4) {
            this.f44496a = progressListener;
            this.f44497b = j3;
            this.f44498c = i3;
            this.f44499d = j4;
            this.f44500e = i4;
        }

        private float b() {
            long j3 = this.f44497b;
            if (j3 != -1 && j3 != 0) {
                return (this.f44499d * 100.0f) / j3;
            }
            int i3 = this.f44498c;
            if (i3 != 0) {
                return (this.f44500e * 100.0f) / i3;
            }
            return -1.0f;
        }

        @Override // androidx.media3.datasource.cache.CacheWriter.ProgressListener
        public void a(long j3, long j4, long j5) {
            long j6 = this.f44499d + j5;
            this.f44499d = j6;
            this.f44496a.a(this.f44497b, j6, b());
        }

        public void c() {
            this.f44500e++;
            this.f44496a.a(this.f44497b, this.f44499d, b());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class Segment implements Comparable<Segment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f44501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DataSpec f44502b;

        public Segment(long j3, DataSpec dataSpec) {
            this.f44501a = j3;
            this.f44502b = dataSpec;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Segment segment) {
            return Util.p(this.f44501a, segment.f44501a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SegmentDownloadRunnable extends RunnableFutureTask<Void, IOException> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Segment f44503i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final CacheDataSource f44504j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final ProgressNotifier f44505k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final byte[] f44506l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final CacheWriter f44507m;

        public SegmentDownloadRunnable(Segment segment, CacheDataSource cacheDataSource, ProgressNotifier progressNotifier, byte[] bArr) {
            this.f44503i = segment;
            this.f44504j = cacheDataSource;
            this.f44505k = progressNotifier;
            this.f44506l = bArr;
            this.f44507m = new CacheWriter(cacheDataSource, segment.f44502b, bArr, progressNotifier);
        }

        @Override // androidx.media3.common.util.RunnableFutureTask
        protected void c() {
            this.f44507m.b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.media3.common.util.RunnableFutureTask
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Void d() throws InterruptedIOException {
            this.f44507m.a();
            ProgressNotifier progressNotifier = this.f44505k;
            if (progressNotifier == null) {
                return null;
            }
            progressNotifier.c();
            return null;
        }
    }

    private void c(RunnableFutureTask runnableFutureTask) {
        synchronized (this.f44491j) {
            try {
                if (this.f44492k) {
                    throw new InterruptedException();
                }
                this.f44491j.add(runnableFutureTask);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean d(DataSpec dataSpec, DataSpec dataSpec2) {
        if (!dataSpec.f41829a.equals(dataSpec2.f41829a)) {
            return false;
        }
        long j3 = dataSpec.f41836h;
        return j3 != -1 && dataSpec.f41835g + j3 == dataSpec2.f41835g && Objects.equals(dataSpec.f41837i, dataSpec2.f41837i) && dataSpec.f41838j == dataSpec2.f41838j && dataSpec.f41831c == dataSpec2.f41831c && dataSpec.f41833e.equals(dataSpec2.f41833e);
    }

    private static void h(List list, CacheKeyFactory cacheKeyFactory, long j3) {
        HashMap map = new HashMap();
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            Segment segment = (Segment) list.get(i4);
            String strB = cacheKeyFactory.b(segment.f44502b);
            Integer num = (Integer) map.get(strB);
            Segment segment2 = num == null ? null : (Segment) list.get(num.intValue());
            if (segment2 == null || segment.f44501a > segment2.f44501a + j3 || !d(segment2.f44502b, segment.f44502b)) {
                map.put(strB, Integer.valueOf(i3));
                list.set(i3, segment);
                i3++;
            } else {
                long j4 = segment.f44502b.f41836h;
                list.set(((Integer) Assertions.e(num)).intValue(), new Segment(segment2.f44501a, segment2.f44502b.f(0L, j4 != -1 ? segment2.f44502b.f41836h + j4 : -1L)));
            }
        }
        Util.X0(list, i3, list.size());
    }

    private void i(int i3) {
        synchronized (this.f44491j) {
            this.f44491j.remove(i3);
        }
    }

    private void j(RunnableFutureTask runnableFutureTask) {
        synchronized (this.f44491j) {
            this.f44491j.remove(runnableFutureTask);
        }
    }

    @Override // androidx.media3.exoplayer.offline.Downloader
    public final void a(Downloader.ProgressListener progressListener) {
        CacheDataSource cacheDataSourceC;
        byte[] bArr;
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        PriorityTaskManager priorityTaskManager = this.f44488g;
        if (priorityTaskManager != null) {
            priorityTaskManager.a(-4000);
        }
        try {
            CacheDataSource cacheDataSourceC2 = this.f44485d.c();
            FilterableManifest filterableManifestF = f(cacheDataSourceC2, this.f44482a, false);
            if (!this.f44484c.isEmpty()) {
                filterableManifestF = (FilterableManifest) filterableManifestF.a(this.f44484c);
            }
            List listG = g(cacheDataSourceC2, filterableManifestF, false);
            Collections.sort(listG);
            h(listG, this.f44487f, this.f44490i);
            int size = listG.size();
            int i3 = 0;
            long j3 = 0;
            long j4 = 0;
            for (int size2 = listG.size() - 1; size2 >= 0; size2--) {
                DataSpec dataSpec = ((Segment) listG.get(size2)).f44502b;
                String strB = this.f44487f.b(dataSpec);
                long j5 = dataSpec.f41836h;
                if (j5 == -1) {
                    long jB = ContentMetadata.b(this.f44486e.b(strB));
                    if (jB != -1) {
                        j5 = jB - dataSpec.f41835g;
                    }
                }
                long j6 = j5;
                long jC = this.f44486e.c(strB, dataSpec.f41835g, j6);
                j4 += jC;
                if (j6 != -1) {
                    if (j6 == jC) {
                        i3++;
                        listG.remove(size2);
                    }
                    if (j3 != -1) {
                        j3 += j6;
                    }
                } else {
                    j3 = -1;
                }
            }
            ProgressNotifier progressNotifier = progressListener != null ? new ProgressNotifier(progressListener, j3, size, j4, i3) : null;
            arrayDeque.addAll(listG);
            while (!this.f44492k && !arrayDeque.isEmpty()) {
                PriorityTaskManager priorityTaskManager2 = this.f44488g;
                if (priorityTaskManager2 != null) {
                    priorityTaskManager2.b(-4000);
                }
                if (arrayDeque2.isEmpty()) {
                    cacheDataSourceC = this.f44485d.c();
                    bArr = new byte[131072];
                } else {
                    SegmentDownloadRunnable segmentDownloadRunnable = (SegmentDownloadRunnable) arrayDeque2.removeFirst();
                    cacheDataSourceC = segmentDownloadRunnable.f44504j;
                    bArr = segmentDownloadRunnable.f44506l;
                }
                SegmentDownloadRunnable segmentDownloadRunnable2 = new SegmentDownloadRunnable((Segment) arrayDeque.removeFirst(), cacheDataSourceC, progressNotifier, bArr);
                c(segmentDownloadRunnable2);
                this.f44489h.execute(segmentDownloadRunnable2);
                for (int size3 = this.f44491j.size() - 1; size3 >= 0; size3--) {
                    SegmentDownloadRunnable segmentDownloadRunnable3 = (SegmentDownloadRunnable) this.f44491j.get(size3);
                    if (arrayDeque.isEmpty() || segmentDownloadRunnable3.isDone()) {
                        try {
                            segmentDownloadRunnable3.get();
                            i(size3);
                            arrayDeque2.addLast(segmentDownloadRunnable3);
                        } catch (ExecutionException e3) {
                            Throwable th = (Throwable) Assertions.e(e3.getCause());
                            if (th instanceof PriorityTaskManager.PriorityTooLowException) {
                                arrayDeque.addFirst(segmentDownloadRunnable3.f44503i);
                                i(size3);
                                arrayDeque2.addLast(segmentDownloadRunnable3);
                            } else {
                                if (th instanceof IOException) {
                                    throw ((IOException) th);
                                }
                                Util.f1(th);
                            }
                        }
                    }
                }
                segmentDownloadRunnable2.b();
            }
            for (int i4 = 0; i4 < this.f44491j.size(); i4++) {
                ((RunnableFutureTask) this.f44491j.get(i4)).cancel(true);
            }
            for (int size4 = this.f44491j.size() - 1; size4 >= 0; size4--) {
                ((RunnableFutureTask) this.f44491j.get(size4)).a();
                i(size4);
            }
            PriorityTaskManager priorityTaskManager3 = this.f44488g;
            if (priorityTaskManager3 != null) {
                priorityTaskManager3.d(-4000);
            }
        } catch (Throwable th2) {
            for (int i5 = 0; i5 < this.f44491j.size(); i5++) {
                ((RunnableFutureTask) this.f44491j.get(i5)).cancel(true);
            }
            for (int size5 = this.f44491j.size() - 1; size5 >= 0; size5--) {
                ((RunnableFutureTask) this.f44491j.get(size5)).a();
                i(size5);
            }
            PriorityTaskManager priorityTaskManager4 = this.f44488g;
            if (priorityTaskManager4 != null) {
                priorityTaskManager4.d(-4000);
            }
            throw th2;
        }
    }

    @Override // androidx.media3.exoplayer.offline.Downloader
    public void cancel() {
        synchronized (this.f44491j) {
            try {
                this.f44492k = true;
                for (int i3 = 0; i3 < this.f44491j.size(); i3++) {
                    ((RunnableFutureTask) this.f44491j.get(i3)).cancel(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:23|37|24|(2:27|(2:29|45)(3:44|31|32))(2:26|46)|30) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        r0 = (java.lang.Throwable) androidx.media3.common.util.Assertions.e(r4.getCause());
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        if ((r0 instanceof androidx.media3.common.PriorityTaskManager.PriorityTooLowException) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        if ((r0 instanceof java.io.IOException) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        androidx.media3.common.util.Util.f1(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
    
        throw ((java.io.IOException) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
    
        r3.a();
        j(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final java.lang.Object e(androidx.media3.common.util.RunnableFutureTask r3, boolean r4) throws java.lang.Throwable {
        /*
            r2 = this;
            if (r4 == 0) goto L20
            r3.run()
            java.lang.Object r3 = r3.get()     // Catch: java.util.concurrent.ExecutionException -> La
            return r3
        La:
            r4 = move-exception
            java.lang.Throwable r0 = r4.getCause()
            java.lang.Object r0 = androidx.media3.common.util.Assertions.e(r0)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            boolean r1 = r0 instanceof java.io.IOException
            if (r1 != 0) goto L1d
            androidx.media3.common.util.Util.f1(r4)
            goto L20
        L1d:
            java.io.IOException r0 = (java.io.IOException) r0
            throw r0
        L20:
            boolean r4 = r2.f44492k
            if (r4 != 0) goto L6a
            androidx.media3.common.PriorityTaskManager r4 = r2.f44488g
            if (r4 == 0) goto L2d
            r0 = -4000(0xfffffffffffff060, float:NaN)
            r4.b(r0)
        L2d:
            r2.c(r3)
            java.util.concurrent.Executor r4 = r2.f44489h
            r4.execute(r3)
            java.lang.Object r4 = r3.get()     // Catch: java.lang.Throwable -> L40 java.util.concurrent.ExecutionException -> L42
            r3.a()
            r2.j(r3)
            return r4
        L40:
            r4 = move-exception
            goto L63
        L42:
            r4 = move-exception
            java.lang.Throwable r0 = r4.getCause()     // Catch: java.lang.Throwable -> L40
            java.lang.Object r0 = androidx.media3.common.util.Assertions.e(r0)     // Catch: java.lang.Throwable -> L40
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch: java.lang.Throwable -> L40
            boolean r1 = r0 instanceof androidx.media3.common.PriorityTaskManager.PriorityTooLowException     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L52
            goto L59
        L52:
            boolean r1 = r0 instanceof java.io.IOException     // Catch: java.lang.Throwable -> L40
            if (r1 != 0) goto L60
            androidx.media3.common.util.Util.f1(r4)     // Catch: java.lang.Throwable -> L40
        L59:
            r3.a()
            r2.j(r3)
            goto L20
        L60:
            java.io.IOException r0 = (java.io.IOException) r0     // Catch: java.lang.Throwable -> L40
            throw r0     // Catch: java.lang.Throwable -> L40
        L63:
            r3.a()
            r2.j(r3)
            throw r4
        L6a:
            java.lang.InterruptedException r3 = new java.lang.InterruptedException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.offline.SegmentDownloader.e(androidx.media3.common.util.RunnableFutureTask, boolean):java.lang.Object");
    }

    protected final FilterableManifest f(final DataSource dataSource, final DataSpec dataSpec, boolean z2) {
        return (FilterableManifest) e(new RunnableFutureTask<M, IOException>() { // from class: androidx.media3.exoplayer.offline.SegmentDownloader.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.media3.common.util.RunnableFutureTask
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public FilterableManifest d() {
                return (FilterableManifest) ParsingLoadable.d(dataSource, SegmentDownloader.this.f44483b, dataSpec, 4);
            }
        }, z2);
    }

    protected abstract List g(DataSource dataSource, FilterableManifest filterableManifest, boolean z2);

    @Override // androidx.media3.exoplayer.offline.Downloader
    public final void remove() {
        CacheDataSource cacheDataSourceD = this.f44485d.d();
        try {
            try {
                List listG = g(cacheDataSourceD, f(cacheDataSourceD, this.f44482a, true), true);
                for (int i3 = 0; i3 < listG.size(); i3++) {
                    this.f44486e.k(this.f44487f.b(((Segment) listG.get(i3)).f44502b));
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception unused2) {
            }
        } finally {
            this.f44486e.k(this.f44487f.b(this.f44482a));
        }
    }
}
