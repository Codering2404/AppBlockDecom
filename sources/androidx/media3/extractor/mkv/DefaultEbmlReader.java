package androidx.media3.extractor.mkv;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.ExtractorInput;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class DefaultEbmlReader implements EbmlReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f46542a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque f46543b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final VarintReader f46544c = new VarintReader();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EbmlProcessor f46545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f46546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f46547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f46548g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MasterElement {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f46549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f46550b;

        private MasterElement(int i3, long j3) {
            this.f46549a = i3;
            this.f46550b = j3;
        }
    }

    private long c(ExtractorInput extractorInput) {
        extractorInput.f();
        while (true) {
            extractorInput.m(this.f46542a, 0, 4);
            int iC = VarintReader.c(this.f46542a[0]);
            if (iC != -1 && iC <= 4) {
                int iA = (int) VarintReader.a(this.f46542a, iC, false);
                if (this.f46545d.f(iA)) {
                    extractorInput.k(iC);
                    return iA;
                }
            }
            extractorInput.k(1);
        }
    }

    private double d(ExtractorInput extractorInput, int i3) {
        return i3 == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(e(extractorInput, i3));
    }

    private long e(ExtractorInput extractorInput, int i3) {
        extractorInput.readFully(this.f46542a, 0, i3);
        long j3 = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            j3 = (j3 << 8) | ((long) (this.f46542a[i4] & 255));
        }
        return j3;
    }

    private static String f(ExtractorInput extractorInput, int i3) {
        if (i3 == 0) {
            return "";
        }
        byte[] bArr = new byte[i3];
        extractorInput.readFully(bArr, 0, i3);
        while (i3 > 0 && bArr[i3 - 1] == 0) {
            i3--;
        }
        return new String(bArr, 0, i3);
    }

    @Override // androidx.media3.extractor.mkv.EbmlReader
    public boolean a(ExtractorInput extractorInput) throws ParserException {
        Assertions.i(this.f46545d);
        while (true) {
            MasterElement masterElement = (MasterElement) this.f46543b.peek();
            if (masterElement != null && extractorInput.getPosition() >= masterElement.f46550b) {
                this.f46545d.a(((MasterElement) this.f46543b.pop()).f46549a);
                return true;
            }
            if (this.f46546e == 0) {
                long jD = this.f46544c.d(extractorInput, true, false, 4);
                if (jD == -2) {
                    jD = c(extractorInput);
                }
                if (jD == -1) {
                    return false;
                }
                this.f46547f = (int) jD;
                this.f46546e = 1;
            }
            if (this.f46546e == 1) {
                this.f46548g = this.f46544c.d(extractorInput, false, true, 8);
                this.f46546e = 2;
            }
            int iE = this.f46545d.e(this.f46547f);
            if (iE != 0) {
                if (iE == 1) {
                    long position = extractorInput.getPosition();
                    this.f46543b.push(new MasterElement(this.f46547f, this.f46548g + position));
                    this.f46545d.h(this.f46547f, position, this.f46548g);
                    this.f46546e = 0;
                    return true;
                }
                if (iE == 2) {
                    long j3 = this.f46548g;
                    if (j3 <= 8) {
                        this.f46545d.d(this.f46547f, e(extractorInput, (int) j3));
                        this.f46546e = 0;
                        return true;
                    }
                    throw ParserException.a("Invalid integer size: " + this.f46548g, null);
                }
                if (iE == 3) {
                    long j4 = this.f46548g;
                    if (j4 <= 2147483647L) {
                        this.f46545d.g(this.f46547f, f(extractorInput, (int) j4));
                        this.f46546e = 0;
                        return true;
                    }
                    throw ParserException.a("String element size: " + this.f46548g, null);
                }
                if (iE == 4) {
                    this.f46545d.c(this.f46547f, (int) this.f46548g, extractorInput);
                    this.f46546e = 0;
                    return true;
                }
                if (iE != 5) {
                    throw ParserException.a("Invalid element type " + iE, null);
                }
                long j5 = this.f46548g;
                if (j5 == 4 || j5 == 8) {
                    this.f46545d.b(this.f46547f, d(extractorInput, (int) j5));
                    this.f46546e = 0;
                    return true;
                }
                throw ParserException.a("Invalid float size: " + this.f46548g, null);
            }
            extractorInput.k((int) this.f46548g);
            this.f46546e = 0;
        }
    }

    @Override // androidx.media3.extractor.mkv.EbmlReader
    public void b(EbmlProcessor ebmlProcessor) {
        this.f46545d = ebmlProcessor;
    }

    @Override // androidx.media3.extractor.mkv.EbmlReader
    public void reset() {
        this.f46546e = 0;
        this.f46543b.clear();
        this.f46544c.e();
    }
}
