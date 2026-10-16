package androidx.media3.extractor.mkv;

import androidx.media3.extractor.ExtractorInput;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class VarintReader {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long[] f46619d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f46620a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f46621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f46622c;

    public static long a(byte[] bArr, int i3, boolean z2) {
        long j3 = ((long) bArr[0]) & 255;
        if (z2) {
            j3 &= ~f46619d[i3 - 1];
        }
        for (int i4 = 1; i4 < i3; i4++) {
            j3 = (j3 << 8) | (((long) bArr[i4]) & 255);
        }
        return j3;
    }

    public static int c(int i3) {
        int i4 = 0;
        while (true) {
            long[] jArr = f46619d;
            if (i4 >= jArr.length) {
                return -1;
            }
            if ((jArr[i4] & ((long) i3)) != 0) {
                return i4 + 1;
            }
            i4++;
        }
    }

    public int b() {
        return this.f46622c;
    }

    public long d(ExtractorInput extractorInput, boolean z2, boolean z3, int i3) {
        if (this.f46621b == 0) {
            if (!extractorInput.g(this.f46620a, 0, 1, z2)) {
                return -1L;
            }
            int iC = c(this.f46620a[0] & 255);
            this.f46622c = iC;
            if (iC == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f46621b = 1;
        }
        int i4 = this.f46622c;
        if (i4 > i3) {
            this.f46621b = 0;
            return -2L;
        }
        if (i4 != 1) {
            extractorInput.readFully(this.f46620a, 1, i4 - 1);
        }
        this.f46621b = 0;
        return a(this.f46620a, this.f46622c, z3);
    }

    public void e() {
        this.f46621b = 0;
        this.f46622c = 0;
    }
}
