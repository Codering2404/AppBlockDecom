package androidx.media3.exoplayer;

import android.util.SparseArray;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaExtractorCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Allocator f43127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f43128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray f43129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SampleMetadataQueue f43130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SeekMap f43131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f43132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f43133g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ExtractorOutputImpl implements ExtractorOutput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaExtractorCompat f43134a;

        @Override // androidx.media3.extractor.ExtractorOutput
        public TrackOutput d(int i3, int i4) {
            MediaExtractorSampleQueue mediaExtractorSampleQueue = (MediaExtractorSampleQueue) this.f43134a.f43129c.get(i3);
            if (mediaExtractorSampleQueue != null) {
                return mediaExtractorSampleQueue;
            }
            if (this.f43134a.f43132f) {
                return new DiscardingTrackOutput();
            }
            MediaExtractorCompat mediaExtractorCompat = this.f43134a;
            MediaExtractorSampleQueue mediaExtractorSampleQueue2 = mediaExtractorCompat.new MediaExtractorSampleQueue(mediaExtractorCompat.f43127a, i3);
            this.f43134a.f43129c.put(i3, mediaExtractorSampleQueue2);
            return mediaExtractorSampleQueue2;
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public void n(SeekMap seekMap) {
            this.f43134a.f43131e = seekMap;
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public void q() {
            this.f43134a.f43132f = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class MediaExtractorSampleQueue extends SampleQueue {
        public final int H;
        public long I;
        private int J;
        private int K;

        public MediaExtractorSampleQueue(Allocator allocator, int i3) {
            super(allocator, null, null);
            this.H = i3;
            this.I = -9223372036854775807L;
            this.J = -1;
            this.K = -1;
        }

        private void b0(long j3, int i3) {
            int i4 = ((1073741824 & i3) != 0 ? 2 : 0) | ((i3 & 1) != 0 ? 1 : 0);
            if (this.K != -1) {
                MediaExtractorCompat.this.f43130d.a(j3, i4, this.K);
            }
            MediaExtractorCompat.this.f43130d.a(j3, i4, this.J);
        }

        public void c0(int i3) {
            this.K = i3;
        }

        public void d0(int i3) {
            this.J = i3;
        }

        @Override // androidx.media3.extractor.TrackOutput
        public void e(long j3) {
            this.I = j3;
            super.e(j3);
        }

        @Override // androidx.media3.exoplayer.source.SampleQueue, androidx.media3.extractor.TrackOutput
        public void g(long j3, int i3, int i4, int i5, TrackOutput.CryptoData cryptoData) {
            int i6 = i3 & (-536870913);
            Assertions.g(this.J != -1);
            int iE = E();
            super.g(j3, i6, i4, i5, cryptoData);
            if (E() == iE + 1) {
                b0(j3, i6);
            }
        }

        public String toString() {
            return String.format("trackId: %s, mainTrackIndex: %s, compatibilityTrackIndex: %s", Integer.valueOf(this.H), Integer.valueOf(this.J), Integer.valueOf(this.K));
        }

        @Override // androidx.media3.exoplayer.source.SampleQueue
        public Format v(Format format) {
            if (D() == null) {
                MediaExtractorCompat.this.h(this, format);
            }
            return super.v(format);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MediaExtractorTrack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaExtractorSampleQueue f43135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f43136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f43137c;

        public String toString() {
            return String.format("MediaExtractorSampleQueue: %s, isCompatibilityTrack: %s, compatibilityTrackMimeType: %s", this.f43135a, Boolean.valueOf(this.f43136b), this.f43137c);
        }

        private MediaExtractorTrack(MediaExtractorSampleQueue mediaExtractorSampleQueue, boolean z2, String str) {
            this.f43135a = mediaExtractorSampleQueue;
            this.f43136b = z2;
            this.f43137c = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SampleMetadataQueue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayDeque f43138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayDeque f43139b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class SampleMetadata {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f43140a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public long f43141b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f43142c;

            public SampleMetadata(long j3, int i3, int i4) {
                a(j3, i3, i4);
            }

            public void a(long j3, int i3, int i4) {
                this.f43141b = j3;
                this.f43140a = i3;
                this.f43142c = i4;
            }
        }

        private SampleMetadata b(long j3, int i3, int i4) {
            SampleMetadata sampleMetadata = this.f43138a.isEmpty() ? new SampleMetadata(j3, i3, i4) : (SampleMetadata) this.f43138a.pop();
            sampleMetadata.a(j3, i3, i4);
            return sampleMetadata;
        }

        public void a(long j3, int i3, int i4) {
            this.f43139b.addLast(b(j3, i3, i4));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface SeekMode {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void h(MediaExtractorSampleQueue mediaExtractorSampleQueue, Format format) {
        boolean z2 = true;
        this.f43133g++;
        mediaExtractorSampleQueue.d0(this.f43128b.size());
        Object[] objArr = 0;
        this.f43128b.add(new MediaExtractorTrack(mediaExtractorSampleQueue, false, null));
        String strG = MediaCodecUtil.g(format);
        if (strG != null) {
            mediaExtractorSampleQueue.c0(this.f43128b.size());
            this.f43128b.add(new MediaExtractorTrack(mediaExtractorSampleQueue, z2, strG));
        }
    }
}
