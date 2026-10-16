package androidx.media3.transformer;

import android.graphics.Bitmap;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampIterator;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class VideoFrameProcessingWrapper implements GraphInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VideoFrameProcessor f48616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f48617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f48618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f48619d = new AtomicLong();

    public VideoFrameProcessingWrapper(VideoFrameProcessor videoFrameProcessor, List list, long j3) {
        this.f48616a = videoFrameProcessor;
        this.f48617b = list;
        this.f48618c = j3;
    }

    private static Format j(Format format) {
        return format.f40642y % SensibleDefaults.X_OFFSET == 0 ? format : format.b().B0(format.f40640w).d0(format.f40639v).t0(0).N();
    }

    private static int k(String str) {
        if (MimeTypes.o(str)) {
            return 2;
        }
        if (str.equals("video/raw")) {
            return 3;
        }
        if (MimeTypes.q(str)) {
            return 1;
        }
        throw new IllegalArgumentException("MIME type not supported " + str);
    }

    private static boolean l(EditedMediaItem editedMediaItem) {
        String scheme;
        MediaItem.LocalConfiguration localConfiguration = editedMediaItem.f48095a.f40714b;
        if (localConfiguration == null || (scheme = localConfiguration.f40810a.getScheme()) == null) {
            return false;
        }
        return scheme.equals("transformer_surface_asset");
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public Surface a() {
        return this.f48616a.a();
    }

    @Override // androidx.media3.transformer.OnMediaItemChangedListener
    public void b(EditedMediaItem editedMediaItem, long j3, Format format, boolean z2) {
        Assertions.a(!editedMediaItem.d());
        boolean zL = l(editedMediaItem);
        long jB = editedMediaItem.b(j3);
        if (format != null) {
            Format formatJ = j(format);
            this.f48616a.j(zL ? 4 : k((String) Assertions.e(formatJ.f40632o)), formatJ, new ImmutableList.Builder().k(editedMediaItem.f48101g.f48127b).k(this.f48617b).m(), this.f48619d.get() + this.f48618c);
        }
        this.f48619d.addAndGet(jB);
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public int d() {
        return this.f48616a.l();
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public void e(Runnable runnable) {
        this.f48616a.e(runnable);
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public int g(Bitmap bitmap, TimestampIterator timestampIterator) {
        return this.f48616a.g(bitmap, timestampIterator) ? 1 : 2;
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public void h() {
        this.f48616a.d();
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public boolean i(long j3) {
        return this.f48616a.k();
    }
}
