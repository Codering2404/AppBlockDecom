package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.TrackOutput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BaseMediaChunkOutput implements ChunkExtractor.TrackOutputProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f45071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SampleQueue[] f45072b;

    public int[] a() {
        int[] iArr = new int[this.f45072b.length];
        int i3 = 0;
        while (true) {
            SampleQueue[] sampleQueueArr = this.f45072b;
            if (i3 >= sampleQueueArr.length) {
                return iArr;
            }
            iArr[i3] = sampleQueueArr[i3].E();
            i3++;
        }
    }

    public void b(long j3) {
        for (SampleQueue sampleQueue : this.f45072b) {
            sampleQueue.W(j3);
        }
    }

    @Override // androidx.media3.exoplayer.source.chunk.ChunkExtractor.TrackOutputProvider
    public TrackOutput d(int i3, int i4) {
        int i5 = 0;
        while (true) {
            int[] iArr = this.f45071a;
            if (i5 >= iArr.length) {
                Log.d("BaseMediaChunkOutput", "Unmatched track of type: " + i4);
                return new DiscardingTrackOutput();
            }
            if (i4 == iArr[i5]) {
                return this.f45072b[i5];
            }
            i5++;
        }
    }
}
