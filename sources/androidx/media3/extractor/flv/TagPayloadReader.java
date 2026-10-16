package androidx.media3.extractor.flv;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.TrackOutput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
abstract class TagPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final TrackOutput f46378a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    protected TagPayloadReader(TrackOutput trackOutput) {
        this.f46378a = trackOutput;
    }

    public final boolean a(ParsableByteArray parsableByteArray, long j3) {
        return b(parsableByteArray) && c(parsableByteArray, j3);
    }

    protected abstract boolean b(ParsableByteArray parsableByteArray);

    protected abstract boolean c(ParsableByteArray parsableByteArray, long j3);
}
