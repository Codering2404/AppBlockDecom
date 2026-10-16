package androidx.media3.extractor.avi;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AviStreamHeaderChunk implements AviChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f46309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f46311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f46312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f46313g;

    private AviStreamHeaderChunk(int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f46307a = i3;
        this.f46308b = i4;
        this.f46309c = i5;
        this.f46310d = i6;
        this.f46311e = i7;
        this.f46312f = i8;
        this.f46313g = i9;
    }

    public static AviStreamHeaderChunk c(ParsableByteArray parsableByteArray) {
        int iU = parsableByteArray.u();
        parsableByteArray.X(12);
        int iU2 = parsableByteArray.u();
        int iU3 = parsableByteArray.u();
        int iU4 = parsableByteArray.u();
        parsableByteArray.X(4);
        int iU5 = parsableByteArray.u();
        int iU6 = parsableByteArray.u();
        parsableByteArray.X(4);
        return new AviStreamHeaderChunk(iU, iU2, iU3, iU4, iU5, iU6, parsableByteArray.u());
    }

    public long a() {
        return Util.Z0(this.f46311e, ((long) this.f46309c) * 1000000, this.f46310d);
    }

    public int b() {
        int i3 = this.f46307a;
        if (i3 == 1935960438) {
            return 2;
        }
        if (i3 == 1935963489) {
            return 1;
        }
        if (i3 == 1937012852) {
            return 3;
        }
        Log.i("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.f46307a));
        return -1;
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public int getType() {
        return 1752331379;
    }
}
