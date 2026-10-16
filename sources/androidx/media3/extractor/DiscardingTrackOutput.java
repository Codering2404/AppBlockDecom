package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.TrackOutput;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DiscardingTrackOutput implements TrackOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f46130a = new byte[4096];

    @Override // androidx.media3.extractor.TrackOutput
    public void a(ParsableByteArray parsableByteArray, int i3, int i4) {
        parsableByteArray.X(i3);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public int f(DataReader dataReader, int i3, boolean z2, int i4) throws EOFException {
        int i5 = dataReader.read(this.f46130a, 0, Math.min(this.f46130a.length, i3));
        if (i5 != -1) {
            return i5;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void c(Format format) {
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void g(long j3, int i3, int i4, int i5, TrackOutput.CryptoData cryptoData) {
    }
}
