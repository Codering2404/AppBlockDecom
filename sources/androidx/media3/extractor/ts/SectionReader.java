package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SectionReader implements TsPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SectionPayloadReader f47683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableByteArray f47684b = new ParsableByteArray(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f47685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f47686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f47687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f47688f;

    public SectionReader(SectionPayloadReader sectionPayloadReader) {
        this.f47683a = sectionPayloadReader;
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public void a(ParsableByteArray parsableByteArray, int i3) {
        boolean z2 = (i3 & 1) != 0;
        int iF = z2 ? parsableByteArray.f() + parsableByteArray.H() : -1;
        if (this.f47688f) {
            if (!z2) {
                return;
            }
            this.f47688f = false;
            parsableByteArray.W(iF);
            this.f47686d = 0;
        }
        while (parsableByteArray.a() > 0) {
            int i4 = this.f47686d;
            if (i4 < 3) {
                if (i4 == 0) {
                    int iH = parsableByteArray.H();
                    parsableByteArray.W(parsableByteArray.f() - 1);
                    if (iH == 255) {
                        this.f47688f = true;
                        return;
                    }
                }
                int iMin = Math.min(parsableByteArray.a(), 3 - this.f47686d);
                parsableByteArray.l(this.f47684b.e(), this.f47686d, iMin);
                int i5 = this.f47686d + iMin;
                this.f47686d = i5;
                if (i5 == 3) {
                    this.f47684b.W(0);
                    this.f47684b.V(3);
                    this.f47684b.X(1);
                    int iH2 = this.f47684b.H();
                    int iH3 = this.f47684b.H();
                    this.f47687e = (iH2 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
                    this.f47685c = (((iH2 & 15) << 8) | iH3) + 3;
                    int iB = this.f47684b.b();
                    int i6 = this.f47685c;
                    if (iB < i6) {
                        this.f47684b.c(Math.min(4098, Math.max(i6, this.f47684b.b() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(parsableByteArray.a(), this.f47685c - this.f47686d);
                parsableByteArray.l(this.f47684b.e(), this.f47686d, iMin2);
                int i7 = this.f47686d + iMin2;
                this.f47686d = i7;
                int i8 = this.f47685c;
                if (i7 != i8) {
                    continue;
                } else {
                    if (!this.f47687e) {
                        this.f47684b.V(i8);
                    } else {
                        if (Util.z(this.f47684b.e(), 0, this.f47685c, -1) != 0) {
                            this.f47688f = true;
                            return;
                        }
                        this.f47684b.V(this.f47685c - 4);
                    }
                    this.f47684b.W(0);
                    this.f47683a.a(this.f47684b);
                    this.f47686d = 0;
                }
            }
        }
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f47683a.b(timestampAdjuster, extractorOutput, trackIdGenerator);
        this.f47688f = true;
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public void c() {
        this.f47688f = true;
    }
}
