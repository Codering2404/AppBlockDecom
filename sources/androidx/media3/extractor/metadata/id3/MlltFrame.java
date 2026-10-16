package androidx.media3.extractor.metadata.id3;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MlltFrame extends Id3Frame {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f46481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f46482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f46483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f46484f;

    public MlltFrame(int i3, int i4, int i5, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f46480b = i3;
        this.f46481c = i4;
        this.f46482d = i5;
        this.f46483e = iArr;
        this.f46484f = iArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MlltFrame.class == obj.getClass()) {
            MlltFrame mlltFrame = (MlltFrame) obj;
            if (this.f46480b == mlltFrame.f46480b && this.f46481c == mlltFrame.f46481c && this.f46482d == mlltFrame.f46482d && Arrays.equals(this.f46483e, mlltFrame.f46483e) && Arrays.equals(this.f46484f, mlltFrame.f46484f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.f46480b) * 31) + this.f46481c) * 31) + this.f46482d) * 31) + Arrays.hashCode(this.f46483e)) * 31) + Arrays.hashCode(this.f46484f);
    }
}
