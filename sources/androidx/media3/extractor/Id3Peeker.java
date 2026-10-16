package androidx.media3.extractor;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Id3Peeker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f46192a = new ParsableByteArray(10);

    public Metadata a(ExtractorInput extractorInput, Id3Decoder.FramePredicate framePredicate) throws Throwable {
        Metadata metadataE = null;
        int i3 = 0;
        while (true) {
            try {
                extractorInput.m(this.f46192a.e(), 0, 10);
                this.f46192a.W(0);
                if (this.f46192a.K() != 4801587) {
                    break;
                }
                this.f46192a.X(3);
                int iG = this.f46192a.G();
                int i4 = iG + 10;
                if (metadataE == null) {
                    byte[] bArr = new byte[i4];
                    System.arraycopy(this.f46192a.e(), 0, bArr, 0, 10);
                    extractorInput.m(bArr, 10, iG);
                    metadataE = new Id3Decoder(framePredicate).e(bArr, i4);
                } else {
                    extractorInput.i(iG);
                }
                i3 += i4;
            } catch (EOFException unused) {
            }
        }
        extractorInput.f();
        extractorInput.i(i3);
        return metadataE;
    }
}
