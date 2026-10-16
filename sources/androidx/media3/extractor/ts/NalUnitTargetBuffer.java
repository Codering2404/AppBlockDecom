package androidx.media3.extractor.ts;

import androidx.media3.common.util.Assertions;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class NalUnitTargetBuffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f47633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f47634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f47635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f47636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f47637e;

    public NalUnitTargetBuffer(int i3, int i4) {
        this.f47633a = i3;
        byte[] bArr = new byte[i4 + 3];
        this.f47636d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i3, int i4) {
        if (this.f47634b) {
            int i5 = i4 - i3;
            byte[] bArr2 = this.f47636d;
            int length = bArr2.length;
            int i6 = this.f47637e;
            if (length < i6 + i5) {
                this.f47636d = Arrays.copyOf(bArr2, (i6 + i5) * 2);
            }
            System.arraycopy(bArr, i3, this.f47636d, this.f47637e, i5);
            this.f47637e += i5;
        }
    }

    public boolean b(int i3) {
        if (!this.f47634b) {
            return false;
        }
        this.f47637e -= i3;
        this.f47634b = false;
        this.f47635c = true;
        return true;
    }

    public boolean c() {
        return this.f47635c;
    }

    public void d() {
        this.f47634b = false;
        this.f47635c = false;
    }

    public void e(int i3) {
        Assertions.g(!this.f47634b);
        boolean z2 = i3 == this.f47633a;
        this.f47634b = z2;
        if (z2) {
            this.f47637e = 3;
            this.f47635c = false;
        }
    }
}
