package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.TrackOutput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ForwardingTrackOutput implements TrackOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TrackOutput f46173a;

    @Override // androidx.media3.extractor.TrackOutput
    public void a(ParsableByteArray parsableByteArray, int i3, int i4) {
        this.f46173a.a(parsableByteArray, i3, i4);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void b(ParsableByteArray parsableByteArray, int i3) {
        this.f46173a.b(parsableByteArray, i3);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void c(Format format) {
        this.f46173a.c(format);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public int d(DataReader dataReader, int i3, boolean z2) {
        return this.f46173a.d(dataReader, i3, z2);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void e(long j3) {
        this.f46173a.e(j3);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public int f(DataReader dataReader, int i3, boolean z2, int i4) {
        return this.f46173a.f(dataReader, i3, z2, i4);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void g(long j3, int i3, int i4, int i5, TrackOutput.CryptoData cryptoData) {
        this.f46173a.g(j3, i3, i4, i5, cryptoData);
    }
}
