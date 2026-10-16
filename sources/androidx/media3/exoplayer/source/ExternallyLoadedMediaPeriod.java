package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.ExternalLoader;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ExternallyLoadedMediaPeriod implements MediaPeriod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f44678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExternalLoader f44679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TrackGroupArray f44680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f44681d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f44682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference f44683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ListenableFuture f44684h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class SampleStreamImpl implements SampleStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f44686a = 0;

        public SampleStreamImpl() {
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public void d() throws IOException {
            Throwable th = (Throwable) ExternallyLoadedMediaPeriod.this.f44683g.get();
            if (th != null) {
                throw new IOException(th);
            }
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int h(long j3) {
            return 0;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public boolean isReady() {
            return ExternallyLoadedMediaPeriod.this.f44682f.get();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
            int i4 = this.f44686a;
            if (i4 == 2) {
                decoderInputBuffer.e(4);
                return -4;
            }
            if ((i3 & 2) != 0 || i4 == 0) {
                formatHolder.f43108b = ExternallyLoadedMediaPeriod.this.f44680c.b(0).a(0);
                this.f44686a = 1;
                return -5;
            }
            if (!ExternallyLoadedMediaPeriod.this.f44682f.get()) {
                return -3;
            }
            int length = ExternallyLoadedMediaPeriod.this.f44681d.length;
            decoderInputBuffer.e(1);
            decoderInputBuffer.f42140g = 0L;
            if ((i3 & 4) == 0) {
                decoderInputBuffer.p(length);
                decoderInputBuffer.f42138d.put(ExternallyLoadedMediaPeriod.this.f44681d, 0, length);
            }
            if ((i3 & 1) == 0) {
                this.f44686a = 2;
            }
            return -4;
        }
    }

    public ExternallyLoadedMediaPeriod(Uri uri, String str, ExternalLoader externalLoader) {
        this.f44678a = uri;
        Format formatN = new Format.Builder().u0(str).N();
        this.f44679b = externalLoader;
        this.f44680c = new TrackGroupArray(new TrackGroup(formatN));
        this.f44681d = uri.toString().getBytes(StandardCharsets.UTF_8);
        this.f44682f = new AtomicBoolean();
        this.f44683g = new AtomicReference();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean a() {
        return !this.f44682f.get();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean b(LoadingInfo loadingInfo) {
        return !this.f44682f.get();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long c() {
        return this.f44682f.get() ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long e() {
        return this.f44682f.get() ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long k(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        for (int i3 = 0; i3 < exoTrackSelectionArr.length; i3++) {
            if (sampleStreamArr[i3] != null && (exoTrackSelectionArr[i3] == null || !zArr[i3])) {
                sampleStreamArr[i3] = null;
            }
            if (sampleStreamArr[i3] == null && exoTrackSelectionArr[i3] != null) {
                sampleStreamArr[i3] = new SampleStreamImpl();
                zArr2[i3] = true;
            }
        }
        return j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long l() {
        return -9223372036854775807L;
    }

    public void n() {
        ListenableFuture listenableFuture = this.f44684h;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
        }
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void r(MediaPeriod.Callback callback, long j3) {
        callback.g(this);
        ListenableFuture listenableFutureA = this.f44679b.a(new ExternalLoader.LoadRequest(this.f44678a));
        this.f44684h = listenableFutureA;
        Futures.a(listenableFutureA, new FutureCallback<Object>() { // from class: androidx.media3.exoplayer.source.ExternallyLoadedMediaPeriod.1
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                ExternallyLoadedMediaPeriod.this.f44683g.set(th);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(Object obj) {
                ExternallyLoadedMediaPeriod.this.f44682f.set(true);
            }
        }, MoreExecutors.a());
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray s() {
        return this.f44680c;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void o() {
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void f(long j3) {
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long j(long j3) {
        return j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long i(long j3, SeekParameters seekParameters) {
        return j3;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void u(long j3, boolean z2) {
    }
}
