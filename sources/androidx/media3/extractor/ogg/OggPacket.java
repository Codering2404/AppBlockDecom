package androidx.media3.extractor.ogg;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorUtil;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class OggPacket {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OggPageHeader f46889a = new OggPageHeader();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f46890b = new ParsableByteArray(new byte[65025], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f46891c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f46892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f46893e;

    OggPacket() {
    }

    private int a(int i3) {
        int i4;
        int i5 = 0;
        this.f46892d = 0;
        do {
            int i6 = this.f46892d;
            int i7 = i3 + i6;
            OggPageHeader oggPageHeader = this.f46889a;
            if (i7 >= oggPageHeader.f46900g) {
                break;
            }
            int[] iArr = oggPageHeader.f46903j;
            this.f46892d = i6 + 1;
            i4 = iArr[i6 + i3];
            i5 += i4;
        } while (i4 == 255);
        return i5;
    }

    public OggPageHeader b() {
        return this.f46889a;
    }

    public ParsableByteArray c() {
        return this.f46890b;
    }

    public boolean d(ExtractorInput extractorInput) {
        int i3;
        Assertions.g(extractorInput != null);
        if (this.f46893e) {
            this.f46893e = false;
            this.f46890b.S(0);
        }
        while (!this.f46893e) {
            if (this.f46891c < 0) {
                if (!this.f46889a.c(extractorInput) || !this.f46889a.a(extractorInput, true)) {
                    return false;
                }
                OggPageHeader oggPageHeader = this.f46889a;
                int iA = oggPageHeader.f46901h;
                if ((oggPageHeader.f46895b & 1) == 1 && this.f46890b.g() == 0) {
                    iA += a(0);
                    i3 = this.f46892d;
                } else {
                    i3 = 0;
                }
                if (!ExtractorUtil.e(extractorInput, iA)) {
                    return false;
                }
                this.f46891c = i3;
            }
            int iA2 = a(this.f46891c);
            int i4 = this.f46891c + this.f46892d;
            if (iA2 > 0) {
                ParsableByteArray parsableByteArray = this.f46890b;
                parsableByteArray.c(parsableByteArray.g() + iA2);
                if (!ExtractorUtil.d(extractorInput, this.f46890b.e(), this.f46890b.g(), iA2)) {
                    return false;
                }
                ParsableByteArray parsableByteArray2 = this.f46890b;
                parsableByteArray2.V(parsableByteArray2.g() + iA2);
                this.f46893e = this.f46889a.f46903j[i4 + (-1)] != 255;
            }
            if (i4 == this.f46889a.f46900g) {
                i4 = -1;
            }
            this.f46891c = i4;
        }
        return true;
    }

    public void e() {
        this.f46889a.b();
        this.f46890b.S(0);
        this.f46891c = -1;
        this.f46893e = false;
    }

    public void f() {
        if (this.f46890b.e().length == 65025) {
            return;
        }
        ParsableByteArray parsableByteArray = this.f46890b;
        parsableByteArray.U(Arrays.copyOf(parsableByteArray.e(), Math.max(65025, this.f46890b.g())), this.f46890b.g());
    }
}
