package androidx.media3.extractor.ts;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PesReader implements TsPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ElementaryStreamReader f47641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ParsableBitArray f47642b = new ParsableBitArray(new byte[10]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f47643c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f47644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TimestampAdjuster f47645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f47646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f47647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f47648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f47649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f47650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f47651k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f47652l;

    public PesReader(ElementaryStreamReader elementaryStreamReader) {
        this.f47641a = elementaryStreamReader;
    }

    private boolean e(ParsableByteArray parsableByteArray, byte[] bArr, int i3) {
        int iMin = Math.min(parsableByteArray.a(), i3 - this.f47644d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.X(iMin);
        } else {
            parsableByteArray.l(bArr, this.f47644d, iMin);
        }
        int i4 = this.f47644d + iMin;
        this.f47644d = i4;
        return i4 == i3;
    }

    private boolean f() {
        this.f47642b.p(0);
        int iH = this.f47642b.h(24);
        if (iH != 1) {
            Log.i("PesReader", "Unexpected start code prefix: " + iH);
            this.f47650j = -1;
            return false;
        }
        this.f47642b.r(8);
        int iH2 = this.f47642b.h(16);
        this.f47642b.r(5);
        this.f47651k = this.f47642b.g();
        this.f47642b.r(2);
        this.f47646f = this.f47642b.g();
        this.f47647g = this.f47642b.g();
        this.f47642b.r(6);
        int iH3 = this.f47642b.h(8);
        this.f47649i = iH3;
        if (iH2 == 0) {
            this.f47650j = -1;
        } else {
            int i3 = (iH2 - 3) - iH3;
            this.f47650j = i3;
            if (i3 < 0) {
                Log.i("PesReader", "Found negative packet payload size: " + this.f47650j);
                this.f47650j = -1;
            }
        }
        return true;
    }

    private void g() {
        this.f47642b.p(0);
        this.f47652l = -9223372036854775807L;
        if (this.f47646f) {
            this.f47642b.r(4);
            long jH = ((long) this.f47642b.h(3)) << 30;
            this.f47642b.r(1);
            long jH2 = jH | ((long) (this.f47642b.h(15) << 15));
            this.f47642b.r(1);
            long jH3 = jH2 | ((long) this.f47642b.h(15));
            this.f47642b.r(1);
            if (!this.f47648h && this.f47647g) {
                this.f47642b.r(4);
                long jH4 = ((long) this.f47642b.h(3)) << 30;
                this.f47642b.r(1);
                long jH5 = jH4 | ((long) (this.f47642b.h(15) << 15));
                this.f47642b.r(1);
                long jH6 = jH5 | ((long) this.f47642b.h(15));
                this.f47642b.r(1);
                this.f47645e.b(jH6);
                this.f47648h = true;
            }
            this.f47652l = this.f47645e.b(jH3);
        }
    }

    private void h(int i3) {
        this.f47643c = i3;
        this.f47644d = 0;
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public void a(ParsableByteArray parsableByteArray, int i3) {
        Assertions.i(this.f47645e);
        if ((i3 & 1) != 0) {
            int i4 = this.f47643c;
            if (i4 != 0 && i4 != 1) {
                if (i4 == 2) {
                    Log.i("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i4 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f47650j != -1) {
                        Log.i("PesReader", "Unexpected start indicator: expected " + this.f47650j + " more bytes");
                    }
                    this.f47641a.d(parsableByteArray.g() == 0);
                }
            }
            h(1);
        }
        while (parsableByteArray.a() > 0) {
            int i5 = this.f47643c;
            if (i5 == 0) {
                parsableByteArray.X(parsableByteArray.a());
            } else if (i5 != 1) {
                if (i5 == 2) {
                    if (e(parsableByteArray, this.f47642b.f41576a, Math.min(10, this.f47649i)) && e(parsableByteArray, null, this.f47649i)) {
                        g();
                        i3 |= this.f47651k ? 4 : 0;
                        this.f47641a.f(this.f47652l, i3);
                        h(3);
                    }
                } else {
                    if (i5 != 3) {
                        throw new IllegalStateException();
                    }
                    int iA = parsableByteArray.a();
                    int i6 = this.f47650j;
                    int i7 = i6 == -1 ? 0 : iA - i6;
                    if (i7 > 0) {
                        iA -= i7;
                        parsableByteArray.V(parsableByteArray.f() + iA);
                    }
                    this.f47641a.a(parsableByteArray);
                    int i8 = this.f47650j;
                    if (i8 != -1) {
                        int i9 = i8 - iA;
                        this.f47650j = i9;
                        if (i9 == 0) {
                            this.f47641a.d(false);
                            h(1);
                        }
                    }
                }
            } else if (e(parsableByteArray, this.f47642b.f41576a, 9)) {
                h(f() ? 2 : 0);
            }
        }
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f47645e = timestampAdjuster;
        this.f47641a.e(extractorOutput, trackIdGenerator);
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader
    public void c() {
        this.f47643c = 0;
        this.f47644d = 0;
        this.f47648h = false;
        this.f47641a.c();
    }

    public boolean d(boolean z2) {
        return this.f47643c == 3 && this.f47650j == -1 && !(z2 && (this.f47641a instanceof H262Reader)) && (!z2 || f());
    }
}
