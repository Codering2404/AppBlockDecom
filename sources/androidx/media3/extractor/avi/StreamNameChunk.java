package androidx.media3.extractor.avi;

import androidx.media3.common.util.ParsableByteArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class StreamNameChunk implements AviChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46331a;

    private StreamNameChunk(String str) {
        this.f46331a = str;
    }

    public static StreamNameChunk a(ParsableByteArray parsableByteArray) {
        return new StreamNameChunk(parsableByteArray.E(parsableByteArray.a()));
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public int getType() {
        return 1852994675;
    }
}
