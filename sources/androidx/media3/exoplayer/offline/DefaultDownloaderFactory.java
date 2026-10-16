package androidx.media3.exoplayer.offline;

import android.util.SparseArray;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.cache.CacheDataSource;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultDownloaderFactory implements DownloaderFactory {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseArray f44367c = c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CacheDataSource.Factory f44368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f44369b;

    private Downloader b(DownloadRequest downloadRequest, int i3) {
        Constructor constructor = (Constructor) f44367c.get(i3);
        if (constructor == null) {
            throw new IllegalStateException("Module missing for content type " + i3);
        }
        try {
            return (Downloader) constructor.newInstance(new MediaItem.Builder().k(downloadRequest.f44430b).h(downloadRequest.f44432d).c(downloadRequest.f44434g).a(), this.f44368a, this.f44369b);
        } catch (Exception e3) {
            throw new IllegalStateException("Failed to instantiate downloader for content type " + i3, e3);
        }
    }

    private static SparseArray c() {
        SparseArray sparseArray = new SparseArray();
        try {
            sparseArray.put(0, d(Class.forName("androidx.media3.exoplayer.dash.offline.DashDownloader")));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, d(Class.forName("androidx.media3.exoplayer.hls.offline.HlsDownloader")));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, d(Class.forName("androidx.media3.exoplayer.smoothstreaming.offline.SsDownloader")));
        } catch (ClassNotFoundException unused3) {
        }
        return sparseArray;
    }

    private static Constructor d(Class cls) {
        try {
            return cls.asSubclass(Downloader.class).getConstructor(MediaItem.class, CacheDataSource.Factory.class, Executor.class);
        } catch (NoSuchMethodException e3) {
            throw new IllegalStateException("Downloader constructor missing", e3);
        }
    }

    @Override // androidx.media3.exoplayer.offline.DownloaderFactory
    public Downloader a(DownloadRequest downloadRequest) {
        int iW0 = Util.w0(downloadRequest.f44430b, downloadRequest.f44431c);
        if (iW0 == 0 || iW0 == 1 || iW0 == 2) {
            return b(downloadRequest, iW0);
        }
        if (iW0 == 4) {
            return new ProgressiveDownloader(new MediaItem.Builder().k(downloadRequest.f44430b).c(downloadRequest.f44434g).a(), this.f44368a, this.f44369b);
        }
        throw new IllegalArgumentException("Unsupported type: " + iW0);
    }
}
