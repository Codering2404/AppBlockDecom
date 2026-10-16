package androidx.media3.exoplayer.source;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class EmptySampleStream implements SampleStream {
    @Override // androidx.media3.exoplayer.source.SampleStream
    public int h(long j3) {
        return 0;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
        decoderInputBuffer.n(4);
        return -4;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public void d() {
    }
}
