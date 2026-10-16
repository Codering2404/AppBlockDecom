package androidx.media3.extractor.mkv;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class Sniffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f46617a = new ParsableByteArray(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f46618b;

    private long a(ExtractorInput extractorInput) {
        int i3 = 0;
        extractorInput.m(this.f46617a.e(), 0, 1);
        int i4 = this.f46617a.e()[0] & 255;
        if (i4 == 0) {
            return Long.MIN_VALUE;
        }
        int i5 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i6 = 0;
        while ((i4 & i5) == 0) {
            i5 >>= 1;
            i6++;
        }
        int i7 = i4 & (~i5);
        extractorInput.m(this.f46617a.e(), 1, i6);
        while (i3 < i6) {
            i3++;
            i7 = (this.f46617a.e()[i3] & 255) + (i7 << 8);
        }
        this.f46618b += i6 + 1;
        return i7;
    }

    public boolean b(ExtractorInput extractorInput) {
        long length = extractorInput.getLength();
        long j3 = 1024;
        if (length != -1 && length <= 1024) {
            j3 = length;
        }
        int i3 = (int) j3;
        extractorInput.m(this.f46617a.e(), 0, 4);
        long J = this.f46617a.J();
        this.f46618b = 4;
        while (J != 440786851) {
            int i4 = this.f46618b + 1;
            this.f46618b = i4;
            if (i4 == i3) {
                return false;
            }
            extractorInput.m(this.f46617a.e(), 0, 1);
            J = ((J << 8) & (-256)) | ((long) (this.f46617a.e()[0] & 255));
        }
        long jA = a(extractorInput);
        long j4 = this.f46618b;
        if (jA != Long.MIN_VALUE && (length == -1 || j4 + jA < length)) {
            while (true) {
                int i5 = this.f46618b;
                long j5 = j4 + jA;
                if (i5 < j5) {
                    if (a(extractorInput) == Long.MIN_VALUE) {
                        return false;
                    }
                    long jA2 = a(extractorInput);
                    if (jA2 < 0 || jA2 > 2147483647L) {
                        break;
                    }
                    if (jA2 != 0) {
                        int i6 = (int) jA2;
                        extractorInput.i(i6);
                        this.f46618b += i6;
                    }
                } else if (i5 == j5) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
