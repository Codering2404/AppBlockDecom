package androidx.media3.extractor.avi;

import androidx.media3.common.util.ParsableByteArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AviMainHeaderChunk implements AviChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f46305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46306d;

    private AviMainHeaderChunk(int i3, int i4, int i5, int i6) {
        this.f46303a = i3;
        this.f46304b = i4;
        this.f46305c = i5;
        this.f46306d = i6;
    }

    public static AviMainHeaderChunk b(ParsableByteArray parsableByteArray) {
        int iU = parsableByteArray.u();
        parsableByteArray.X(8);
        int iU2 = parsableByteArray.u();
        int iU3 = parsableByteArray.u();
        parsableByteArray.X(4);
        int iU4 = parsableByteArray.u();
        parsableByteArray.X(12);
        return new AviMainHeaderChunk(iU, iU2, iU3, iU4);
    }

    public boolean a() {
        return (this.f46304b & 16) == 16;
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public int getType() {
        return 1751742049;
    }
}
