package com.google.android.libraries.places.internal;

import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcff implements Cloneable, ByteChannel, zzcfh, zzcfg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzcfq f77740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f77741b;

    @Override // com.google.android.libraries.places.internal.zzcfv
    public final long A2(zzcff sink, long j3) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j3 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 15);
            sb.append("byteCount < 0: ");
            sb.append(j3);
            throw new IllegalArgumentException(sb.toString());
        }
        long j4 = this.f77741b;
        if (j4 == 0) {
            return -1L;
        }
        if (j3 > j4) {
            j3 = j4;
        }
        sink.i2(this, j3);
        return j3;
    }

    @Override // com.google.android.libraries.places.internal.zzcfg
    public final /* bridge */ /* synthetic */ zzcfg C1(int i3) {
        c(i3);
        return this;
    }

    public final String F() {
        return J(this.f77741b, Charsets.f140510b);
    }

    public final String J(long j3, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (j3 < 0 || j3 > 2147483647L) {
            StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 11);
            sb.append("byteCount: ");
            sb.append(j3);
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.f77741b < j3) {
            throw new EOFException();
        }
        if (j3 == 0) {
            return "";
        }
        zzcfq zzcfqVar = this.f77740a;
        Intrinsics.checkNotNull(zzcfqVar);
        int i3 = zzcfqVar.f77758b;
        int i4 = zzcfqVar.f77759c;
        if (((long) i3) + j3 > i4) {
            return new String(zzr(j3), charset);
        }
        int i5 = (int) j3;
        String str = new String(zzcfqVar.f77757a, i3, i5, charset);
        int i6 = i3 + i5;
        zzcfqVar.f77758b = i6;
        this.f77741b -= j3;
        if (i6 == i4) {
            this.f77740a = zzcfqVar.b();
            zzcfr.b(zzcfqVar);
        }
        return str;
    }

    public final String K(long j3) throws EOFException {
        zzcfq zzcfqVar;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8 = this.f77741b;
        long j9 = j8 < Long.MAX_VALUE ? j8 : Long.MAX_VALUE;
        long j10 = 0;
        if (j9 == 0 || (zzcfqVar = this.f77740a) == null) {
            j4 = 0;
            j7 = -1;
            j5 = -1;
        } else if (j8 < 0) {
            while (j8 > 0) {
                zzcfqVar = zzcfqVar.f77763g;
                Intrinsics.checkNotNull(zzcfqVar);
                j8 -= (long) (zzcfqVar.f77759c - zzcfqVar.f77758b);
            }
            long j11 = 0;
            loop3: while (j8 < j9) {
                byte[] bArr = zzcfqVar.f77757a;
                j4 = j10;
                j5 = -1;
                int iMin = (int) Math.min(zzcfqVar.f77759c, (((long) zzcfqVar.f77758b) + j9) - j8);
                for (int i3 = (int) ((((long) zzcfqVar.f77758b) + j11) - j8); i3 < iMin; i3++) {
                    if (bArr[i3] == 10) {
                        j6 = i3 - zzcfqVar.f77758b;
                        j7 = j6 + j8;
                        break loop3;
                    }
                }
                j11 = j8 + ((long) (zzcfqVar.f77759c - zzcfqVar.f77758b));
                zzcfqVar = zzcfqVar.f77762f;
                Intrinsics.checkNotNull(zzcfqVar);
                j10 = j4;
                j8 = j11;
            }
            j4 = j10;
            j5 = -1;
            j7 = j5;
        } else {
            j4 = 0;
            j5 = -1;
            j8 = 0;
            while (true) {
                long j12 = ((long) (zzcfqVar.f77759c - zzcfqVar.f77758b)) + j8;
                if (j12 > 0) {
                    break;
                }
                zzcfqVar = zzcfqVar.f77762f;
                Intrinsics.checkNotNull(zzcfqVar);
                j8 = j12;
            }
            long j13 = 0;
            loop6: while (j8 < j9) {
                byte[] bArr2 = zzcfqVar.f77757a;
                int iMin2 = (int) Math.min(zzcfqVar.f77759c, (((long) zzcfqVar.f77758b) + j9) - j8);
                for (int i4 = (int) ((((long) zzcfqVar.f77758b) + j13) - j8); i4 < iMin2; i4++) {
                    if (bArr2[i4] == 10) {
                        j6 = i4 - zzcfqVar.f77758b;
                        j7 = j6 + j8;
                        break loop3;
                    }
                }
                j13 = ((long) (zzcfqVar.f77759c - zzcfqVar.f77758b)) + j8;
                zzcfqVar = zzcfqVar.f77762f;
                Intrinsics.checkNotNull(zzcfqVar);
                j8 = j13;
            }
            j7 = j5;
        }
        if (j7 != j5) {
            int i5 = zzcfz.f77770b;
            Intrinsics.checkNotNullParameter(this, "<this>");
            if (j7 > j4) {
                long j14 = j7 + j5;
                if (z(j14) == 13) {
                    String strJ = J(j14, Charsets.f140510b);
                    x0(2L);
                    return strJ;
                }
            }
            String strJ2 = J(j7, Charsets.f140510b);
            x0(1L);
            return strJ2;
        }
        zzcff out = new zzcff();
        long jMin = Math.min(32L, this.f77741b);
        Intrinsics.checkNotNullParameter(out, "out");
        zzcfb.a(this.f77741b, 0L, jMin);
        if (jMin != j4) {
            out.f77741b += jMin;
            zzcfq zzcfqVar2 = this.f77740a;
            long j15 = j4;
            while (true) {
                Intrinsics.checkNotNull(zzcfqVar2);
                long j16 = zzcfqVar2.f77759c - zzcfqVar2.f77758b;
                if (j15 < j16) {
                    break;
                }
                zzcfqVar2 = zzcfqVar2.f77762f;
                j15 -= j16;
            }
            while (jMin > j4) {
                Intrinsics.checkNotNull(zzcfqVar2);
                zzcfq zzcfqVarA = zzcfqVar2.a();
                int i6 = zzcfqVarA.f77758b + ((int) j15);
                zzcfqVarA.f77758b = i6;
                zzcfqVarA.f77759c = Math.min(i6 + ((int) jMin), zzcfqVarA.f77759c);
                zzcfq zzcfqVar3 = out.f77740a;
                if (zzcfqVar3 == null) {
                    zzcfqVarA.f77763g = zzcfqVarA;
                    zzcfqVarA.f77762f = zzcfqVarA;
                    out.f77740a = zzcfqVarA;
                } else {
                    Intrinsics.checkNotNull(zzcfqVar3);
                    zzcfq zzcfqVar4 = zzcfqVar3.f77763g;
                    Intrinsics.checkNotNull(zzcfqVar4);
                    zzcfqVar4.c(zzcfqVarA);
                }
                jMin -= (long) (zzcfqVarA.f77759c - zzcfqVarA.f77758b);
                zzcfqVar2 = zzcfqVar2.f77762f;
                j15 = j4;
            }
        }
        long jMin2 = Math.min(this.f77741b, Long.MAX_VALUE);
        String strG = out.z1(out.f77741b).g();
        StringBuilder sb = new StringBuilder(String.valueOf(jMin2).length() + 29 + String.valueOf(strG).length() + 1);
        sb.append("\\n not found: limit=");
        sb.append(jMin2);
        sb.append(" content=");
        sb.append(strG);
        sb.append("…");
        throw new EOFException(sb.toString());
    }

    public final int L(byte[] sink, int i3, int i4) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        zzcfb.a(sink.length, i3, i4);
        zzcfq zzcfqVar = this.f77740a;
        if (zzcfqVar == null) {
            return -1;
        }
        int iMin = Math.min(i4, zzcfqVar.f77759c - zzcfqVar.f77758b);
        int i5 = zzcfqVar.f77758b;
        ArraysKt.copyInto(zzcfqVar.f77757a, sink, i3, i5, i5 + iMin);
        int i6 = zzcfqVar.f77758b + iMin;
        zzcfqVar.f77758b = i6;
        this.f77741b -= (long) iMin;
        if (i6 != zzcfqVar.f77759c) {
            return iMin;
        }
        this.f77740a = zzcfqVar.b();
        zzcfr.b(zzcfqVar);
        return iMin;
    }

    public final zzcff M(zzcfj byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.m(this, 0, byteString.j());
        return this;
    }

    public final zzcff N(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        O(string, 0, string.length());
        return this;
    }

    public final zzcff V(int i3) {
        if (i3 < 128) {
            a(i3);
            return this;
        }
        if (i3 < 2048) {
            zzcfq zzcfqVarJ = j(2);
            byte[] bArr = zzcfqVarJ.f77757a;
            int i4 = zzcfqVarJ.f77759c;
            bArr[i4] = (byte) ((i3 >> 6) | 192);
            bArr[i4 + 1] = (byte) ((i3 & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            zzcfqVarJ.f77759c = i4 + 2;
            this.f77741b += 2;
            return this;
        }
        if (i3 >= 55296 && i3 < 57344) {
            a(63);
            return this;
        }
        if (i3 < 65536) {
            zzcfq zzcfqVarJ2 = j(3);
            byte[] bArr2 = zzcfqVarJ2.f77757a;
            int i5 = zzcfqVarJ2.f77759c;
            bArr2[i5] = (byte) ((i3 >> 12) | 224);
            bArr2[i5 + 1] = (byte) (((i3 >> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            bArr2[i5 + 2] = (byte) ((i3 & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            zzcfqVarJ2.f77759c = i5 + 3;
            this.f77741b += 3;
            return this;
        }
        if (i3 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x".concat(String.valueOf(zzcfb.c(i3))));
        }
        zzcfq zzcfqVarJ3 = j(4);
        byte[] bArr3 = zzcfqVarJ3.f77757a;
        int i6 = zzcfqVarJ3.f77759c;
        bArr3[i6] = (byte) ((i3 >> 18) | 240);
        bArr3[i6 + 1] = (byte) (((i3 >> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        bArr3[i6 + 2] = (byte) (((i3 >> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        bArr3[i6 + 3] = (byte) ((i3 & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        zzcfqVarJ3.f77759c = i6 + 4;
        this.f77741b += 4;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzcfg
    public final /* bridge */ /* synthetic */ zzcfg X1(int i3) {
        a(i3);
        return this;
    }

    public final zzcff a(int i3) {
        zzcfq zzcfqVarJ = j(1);
        byte[] bArr = zzcfqVarJ.f77757a;
        int i4 = zzcfqVarJ.f77759c;
        zzcfqVarJ.f77759c = i4 + 1;
        bArr[i4] = (byte) i3;
        this.f77741b++;
        return this;
    }

    public final zzcff b(int i3) {
        zzcfq zzcfqVarJ = j(2);
        byte[] bArr = zzcfqVarJ.f77757a;
        int i4 = zzcfqVarJ.f77759c;
        bArr[i4] = (byte) ((i3 >>> 8) & 255);
        bArr[i4 + 1] = (byte) (i3 & 255);
        zzcfqVarJ.f77759c = i4 + 2;
        this.f77741b += 2;
        return this;
    }

    public final zzcff c(int i3) {
        zzcfq zzcfqVarJ = j(4);
        byte[] bArr = zzcfqVarJ.f77757a;
        int i4 = zzcfqVarJ.f77759c;
        bArr[i4] = (byte) (i3 >> 24);
        bArr[i4 + 1] = (byte) ((i3 >>> 16) & 255);
        bArr[i4 + 2] = (byte) ((i3 >>> 8) & 255);
        bArr[i4 + 3] = (byte) (i3 & 255);
        zzcfqVarJ.f77759c = i4 + 4;
        this.f77741b += 4;
        return this;
    }

    public final /* synthetic */ Object clone() {
        zzcff zzcffVar = new zzcff();
        if (this.f77741b == 0) {
            return zzcffVar;
        }
        zzcfq zzcfqVar = this.f77740a;
        Intrinsics.checkNotNull(zzcfqVar);
        zzcfq zzcfqVarA = zzcfqVar.a();
        zzcffVar.f77740a = zzcfqVarA;
        zzcfqVarA.f77763g = zzcfqVarA;
        zzcfqVarA.f77762f = zzcfqVarA;
        for (zzcfq zzcfqVar2 = zzcfqVar.f77762f; zzcfqVar2 != zzcfqVar; zzcfqVar2 = zzcfqVar2.f77762f) {
            zzcfq zzcfqVar3 = zzcfqVarA.f77763g;
            Intrinsics.checkNotNull(zzcfqVar3);
            Intrinsics.checkNotNull(zzcfqVar2);
            zzcfqVar3.c(zzcfqVar2.a());
        }
        zzcffVar.f77741b = this.f77741b;
        return zzcffVar;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzcfv
    public final void close() {
    }

    public final zzcff e0(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        g0(source, 0, source.length);
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcff)) {
            return false;
        }
        long j3 = this.f77741b;
        zzcff zzcffVar = (zzcff) obj;
        if (j3 != zzcffVar.f77741b) {
            return false;
        }
        if (j3 == 0) {
            return true;
        }
        zzcfq zzcfqVar = this.f77740a;
        Intrinsics.checkNotNull(zzcfqVar);
        zzcfq zzcfqVar2 = zzcffVar.f77740a;
        Intrinsics.checkNotNull(zzcfqVar2);
        int i3 = zzcfqVar.f77758b;
        int i4 = zzcfqVar2.f77758b;
        long j4 = 0;
        while (j4 < this.f77741b) {
            long jMin = Math.min(zzcfqVar.f77759c - i3, zzcfqVar2.f77759c - i4);
            long j5 = 0;
            while (j5 < jMin) {
                int i5 = i3 + 1;
                int i6 = i4 + 1;
                if (zzcfqVar.f77757a[i3] != zzcfqVar2.f77757a[i4]) {
                    return false;
                }
                j5++;
                i3 = i5;
                i4 = i6;
            }
            if (i3 == zzcfqVar.f77759c) {
                zzcfqVar = zzcfqVar.f77762f;
                Intrinsics.checkNotNull(zzcfqVar);
                i3 = zzcfqVar.f77758b;
            }
            if (i4 == zzcfqVar2.f77759c) {
                zzcfqVar2 = zzcfqVar2.f77762f;
                Intrinsics.checkNotNull(zzcfqVar2);
                i4 = zzcfqVar2.f77758b;
            }
            j4 += jMin;
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzcfg, com.google.android.libraries.places.internal.zzcft, java.io.Flushable
    public final void flush() {
    }

    public final zzcff g0(byte[] source, int i3, int i4) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j3 = i4;
        zzcfb.a(source.length, i3, j3);
        int i5 = i3;
        while (true) {
            int i6 = i3 + i4;
            if (i5 >= i6) {
                this.f77741b += j3;
                return this;
            }
            zzcfq zzcfqVarJ = j(1);
            int iMin = Math.min(i6 - i5, 8192 - zzcfqVarJ.f77759c);
            int i7 = i5 + iMin;
            ArraysKt.copyInto(source, zzcfqVarJ.f77757a, zzcfqVarJ.f77759c, i5, i7);
            zzcfqVarJ.f77759c += iMin;
            i5 = i7;
        }
    }

    public final int hashCode() {
        zzcfq zzcfqVar = this.f77740a;
        if (zzcfqVar == null) {
            return 0;
        }
        int i3 = 1;
        do {
            int i4 = zzcfqVar.f77759c;
            for (int i5 = zzcfqVar.f77758b; i5 < i4; i5++) {
                i3 = (i3 * 31) + zzcfqVar.f77757a[i5];
            }
            zzcfqVar = zzcfqVar.f77762f;
            Intrinsics.checkNotNull(zzcfqVar);
        } while (zzcfqVar != this.f77740a);
        return i3;
    }

    public final zzcff i(long j3) {
        if (j3 == 0) {
            a(48);
            return this;
        }
        long j4 = (j3 >>> 1) | j3;
        long j5 = j4 | (j4 >>> 2);
        long j6 = j5 | (j5 >>> 4);
        long j7 = j6 | (j6 >>> 8);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i3 = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) >> 2);
        zzcfq zzcfqVarJ = j(i3);
        byte[] bArr = zzcfqVarJ.f77757a;
        int i4 = zzcfqVarJ.f77759c;
        int i5 = i4 + i3;
        while (true) {
            i5--;
            if (i5 < i4) {
                zzcfqVarJ.f77759c += i3;
                this.f77741b += (long) i3;
                return this;
            }
            bArr[i5] = zzcfz.a()[(int) (15 & j3)];
            j3 >>>= 4;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcft
    public final void i2(zzcff source, long j3) {
        zzcfq zzcfqVar;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        zzcfb.a(source.f77741b, 0L, j3);
        while (j3 > 0) {
            zzcfq zzcfqVar2 = source.f77740a;
            Intrinsics.checkNotNull(zzcfqVar2);
            int i3 = zzcfqVar2.f77759c;
            zzcfq zzcfqVar3 = source.f77740a;
            Intrinsics.checkNotNull(zzcfqVar3);
            long j4 = i3 - zzcfqVar3.f77758b;
            int i4 = 0;
            if (j3 < j4) {
                zzcfq zzcfqVar4 = this.f77740a;
                if (zzcfqVar4 != null) {
                    Intrinsics.checkNotNull(zzcfqVar4);
                    zzcfqVar = zzcfqVar4.f77763g;
                } else {
                    zzcfqVar = null;
                }
                int i5 = (int) j3;
                if (zzcfqVar != null && zzcfqVar.f77761e) {
                    if ((((long) zzcfqVar.f77759c) + j3) - ((long) (zzcfqVar.f77760d ? 0 : zzcfqVar.f77758b)) <= 8192) {
                        zzcfq zzcfqVar5 = source.f77740a;
                        Intrinsics.checkNotNull(zzcfqVar5);
                        zzcfqVar5.e(zzcfqVar, i5);
                        source.f77741b -= j3;
                        this.f77741b += j3;
                        return;
                    }
                }
                zzcfq zzcfqVar6 = source.f77740a;
                Intrinsics.checkNotNull(zzcfqVar6);
                source.f77740a = zzcfqVar6.d(i5);
            }
            zzcfq zzcfqVar7 = source.f77740a;
            Intrinsics.checkNotNull(zzcfqVar7);
            int i6 = zzcfqVar7.f77759c - zzcfqVar7.f77758b;
            source.f77740a = zzcfqVar7.b();
            zzcfq zzcfqVar8 = this.f77740a;
            if (zzcfqVar8 == null) {
                this.f77740a = zzcfqVar7;
                zzcfqVar7.f77763g = zzcfqVar7;
                zzcfqVar7.f77762f = zzcfqVar7;
            } else {
                Intrinsics.checkNotNull(zzcfqVar8);
                zzcfq zzcfqVar9 = zzcfqVar8.f77763g;
                Intrinsics.checkNotNull(zzcfqVar9);
                zzcfqVar9.c(zzcfqVar7);
                zzcfq zzcfqVar10 = zzcfqVar7.f77763g;
                if (zzcfqVar10 == zzcfqVar7) {
                    throw new IllegalStateException("cannot compact");
                }
                Intrinsics.checkNotNull(zzcfqVar10);
                if (zzcfqVar10.f77761e) {
                    int i7 = zzcfqVar7.f77759c - zzcfqVar7.f77758b;
                    zzcfq zzcfqVar11 = zzcfqVar7.f77763g;
                    Intrinsics.checkNotNull(zzcfqVar11);
                    int i8 = 8192 - zzcfqVar11.f77759c;
                    zzcfq zzcfqVar12 = zzcfqVar7.f77763g;
                    Intrinsics.checkNotNull(zzcfqVar12);
                    if (!zzcfqVar12.f77760d) {
                        zzcfq zzcfqVar13 = zzcfqVar7.f77763g;
                        Intrinsics.checkNotNull(zzcfqVar13);
                        i4 = zzcfqVar13.f77758b;
                    }
                    if (i7 <= i8 + i4) {
                        zzcfq zzcfqVar14 = zzcfqVar7.f77763g;
                        Intrinsics.checkNotNull(zzcfqVar14);
                        zzcfqVar7.e(zzcfqVar14, i7);
                        zzcfqVar7.b();
                        zzcfr.b(zzcfqVar7);
                    }
                }
            }
            long j5 = i6;
            source.f77741b -= j5;
            this.f77741b += j5;
            j3 -= j5;
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final zzcfq j(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        zzcfq zzcfqVar = this.f77740a;
        if (zzcfqVar == null) {
            zzcfq zzcfqVarA = zzcfr.a();
            this.f77740a = zzcfqVarA;
            zzcfqVarA.f77763g = zzcfqVarA;
            zzcfqVarA.f77762f = zzcfqVarA;
            return zzcfqVarA;
        }
        Intrinsics.checkNotNull(zzcfqVar);
        zzcfq zzcfqVar2 = zzcfqVar.f77763g;
        Intrinsics.checkNotNull(zzcfqVar2);
        if (zzcfqVar2.f77759c + i3 <= 8192 && zzcfqVar2.f77761e) {
            return zzcfqVar2;
        }
        zzcfq zzcfqVarA2 = zzcfr.a();
        zzcfqVar2.c(zzcfqVarA2);
        return zzcfqVarA2;
    }

    public final zzcfj k() {
        long j3 = this.f77741b;
        if (j3 <= 2147483647L) {
            return m((int) j3);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 22);
        sb.append("size > Int.MAX_VALUE: ");
        sb.append(j3);
        throw new IllegalStateException(sb.toString());
    }

    public final zzcfj m(int i3) {
        if (i3 == 0) {
            return zzcfj.f77742d;
        }
        zzcfb.a(this.f77741b, 0L, i3);
        zzcfq zzcfqVar = this.f77740a;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            Intrinsics.checkNotNull(zzcfqVar);
            int i7 = zzcfqVar.f77759c;
            int i8 = zzcfqVar.f77758b;
            if (i7 == i8) {
                throw new AssertionError("s.limit == s.pos");
            }
            i5 += i7 - i8;
            i6++;
            zzcfqVar = zzcfqVar.f77762f;
        }
        byte[][] bArr = new byte[i6][];
        int[] iArr = new int[i6 + i6];
        zzcfq zzcfqVar2 = this.f77740a;
        int i9 = 0;
        while (i4 < i3) {
            Intrinsics.checkNotNull(zzcfqVar2);
            bArr[i9] = zzcfqVar2.f77757a;
            i4 += zzcfqVar2.f77759c - zzcfqVar2.f77758b;
            iArr[i9] = Math.min(i4, i3);
            iArr[i9 + i6] = zzcfqVar2.f77758b;
            zzcfqVar2.f77760d = true;
            i9++;
            zzcfqVar2 = zzcfqVar2.f77762f;
        }
        return new zzcfs(bArr, iArr);
    }

    @Override // com.google.android.libraries.places.internal.zzcfg
    public final /* bridge */ /* synthetic */ zzcfg n1(byte[] bArr) {
        e0(bArr);
        return this;
    }

    public final zzcff r(OutputStream out, long j3) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        zzcfb.a(this.f77741b, 0L, j3);
        zzcfq zzcfqVar = this.f77740a;
        long j4 = j3;
        while (j4 > 0) {
            Intrinsics.checkNotNull(zzcfqVar);
            int iMin = (int) Math.min(j4, zzcfqVar.f77759c - zzcfqVar.f77758b);
            out.write(zzcfqVar.f77757a, zzcfqVar.f77758b, iMin);
            int i3 = zzcfqVar.f77758b + iMin;
            zzcfqVar.f77758b = i3;
            long j5 = iMin;
            this.f77741b -= j5;
            j4 -= j5;
            if (i3 == zzcfqVar.f77759c) {
                zzcfq zzcfqVarB = zzcfqVar.b();
                this.f77740a = zzcfqVarB;
                zzcfr.b(zzcfqVar);
                zzcfqVar = zzcfqVarB;
            }
        }
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        zzcfq zzcfqVar = this.f77740a;
        if (zzcfqVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), zzcfqVar.f77759c - zzcfqVar.f77758b);
        sink.put(zzcfqVar.f77757a, zzcfqVar.f77758b, iMin);
        int i3 = zzcfqVar.f77758b + iMin;
        zzcfqVar.f77758b = i3;
        this.f77741b -= (long) iMin;
        if (i3 == zzcfqVar.f77759c) {
            this.f77740a = zzcfqVar.b();
            zzcfr.b(zzcfqVar);
        }
        return iMin;
    }

    public final String toString() {
        return k().toString();
    }

    @Override // com.google.android.libraries.places.internal.zzcfg
    public final /* bridge */ /* synthetic */ zzcfg v1(int i3) {
        b(i3);
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        int i3 = iRemaining;
        while (i3 > 0) {
            zzcfq zzcfqVarJ = j(1);
            int iMin = Math.min(i3, 8192 - zzcfqVarJ.f77759c);
            source.get(zzcfqVarJ.f77757a, zzcfqVarJ.f77759c, iMin);
            i3 -= iMin;
            zzcfqVarJ.f77759c += iMin;
        }
        this.f77741b += (long) iRemaining;
        return iRemaining;
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final void x0(long j3) throws EOFException {
        while (j3 > 0) {
            zzcfq zzcfqVar = this.f77740a;
            if (zzcfqVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j3, zzcfqVar.f77759c - zzcfqVar.f77758b);
            long j4 = iMin;
            this.f77741b -= j4;
            j3 -= j4;
            int i3 = zzcfqVar.f77758b + iMin;
            zzcfqVar.f77758b = i3;
            if (i3 == zzcfqVar.f77759c) {
                this.f77740a = zzcfqVar.b();
                zzcfr.b(zzcfqVar);
            }
        }
    }

    public final byte z(long j3) {
        zzcfb.a(this.f77741b, j3, 1L);
        zzcfq zzcfqVar = this.f77740a;
        if (zzcfqVar == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        }
        long j4 = this.f77741b;
        if (j4 - j3 < j3) {
            while (j4 > j3) {
                zzcfqVar = zzcfqVar.f77763g;
                Intrinsics.checkNotNull(zzcfqVar);
                j4 -= (long) (zzcfqVar.f77759c - zzcfqVar.f77758b);
            }
            Intrinsics.checkNotNull(zzcfqVar);
            return zzcfqVar.f77757a[(int) ((((long) zzcfqVar.f77758b) + j3) - j4)];
        }
        long j5 = 0;
        while (true) {
            long j6 = ((long) (zzcfqVar.f77759c - zzcfqVar.f77758b)) + j5;
            if (j6 > j3) {
                Intrinsics.checkNotNull(zzcfqVar);
                return zzcfqVar.f77757a[(int) ((((long) zzcfqVar.f77758b) + j3) - j5)];
            }
            zzcfqVar = zzcfqVar.f77762f;
            Intrinsics.checkNotNull(zzcfqVar);
            j5 = j6;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final zzcfj z1(long j3) throws EOFException {
        if (j3 < 0 || j3 > 2147483647L) {
            StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 11);
            sb.append("byteCount: ");
            sb.append(j3);
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.f77741b < j3) {
            throw new EOFException();
        }
        if (j3 < 4096) {
            return new zzcfj(zzr(j3));
        }
        zzcfj zzcfjVarM = m((int) j3);
        x0(j3);
        return zzcfjVarM;
    }

    @Override // com.google.android.libraries.places.internal.zzcfg
    public final /* bridge */ /* synthetic */ zzcfg zzH(String str) {
        N(str);
        return this;
    }

    public final long zzb() {
        return this.f77741b;
    }

    public final void zzd(long j3) {
        this.f77741b = j3;
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final zzcff zze() {
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final boolean zzf() {
        return this.f77741b == 0;
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final void zzg(long j3) throws EOFException {
        if (this.f77741b < j3) {
            throw new EOFException();
        }
    }

    public final long zzi() {
        long j3 = this.f77741b;
        if (j3 == 0) {
            return 0L;
        }
        zzcfq zzcfqVar = this.f77740a;
        Intrinsics.checkNotNull(zzcfqVar);
        zzcfq zzcfqVar2 = zzcfqVar.f77763g;
        Intrinsics.checkNotNull(zzcfqVar2);
        int i3 = zzcfqVar2.f77759c;
        return (i3 >= 8192 || !zzcfqVar2.f77761e) ? j3 : j3 - ((long) (i3 - zzcfqVar2.f77758b));
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final byte zzj() throws EOFException {
        if (this.f77741b == 0) {
            throw new EOFException();
        }
        zzcfq zzcfqVar = this.f77740a;
        Intrinsics.checkNotNull(zzcfqVar);
        int i3 = zzcfqVar.f77758b;
        int i4 = zzcfqVar.f77759c;
        int i5 = i3 + 1;
        byte b3 = zzcfqVar.f77757a[i3];
        this.f77741b--;
        if (i5 != i4) {
            zzcfqVar.f77758b = i5;
            return b3;
        }
        this.f77740a = zzcfqVar.b();
        zzcfr.b(zzcfqVar);
        return b3;
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final short zzl() throws EOFException {
        int iZzj;
        if (this.f77741b < 2) {
            throw new EOFException();
        }
        zzcfq zzcfqVar = this.f77740a;
        Intrinsics.checkNotNull(zzcfqVar);
        int i3 = zzcfqVar.f77758b;
        int i4 = zzcfqVar.f77759c;
        if (i4 - i3 < 2) {
            iZzj = ((zzj() & 255) << 8) | (zzj() & 255);
        } else {
            byte[] bArr = zzcfqVar.f77757a;
            int i5 = (bArr[i3] & 255) << 8;
            int i6 = bArr[i3 + 1] & 255;
            this.f77741b -= 2;
            int i7 = i3 + 2;
            if (i7 == i4) {
                this.f77740a = zzcfqVar.b();
                zzcfr.b(zzcfqVar);
            } else {
                zzcfqVar.f77758b = i7;
            }
            iZzj = i5 | i6;
        }
        return (short) iZzj;
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final int zzm() throws EOFException {
        if (this.f77741b < 4) {
            throw new EOFException();
        }
        zzcfq zzcfqVar = this.f77740a;
        Intrinsics.checkNotNull(zzcfqVar);
        int i3 = zzcfqVar.f77758b;
        int i4 = zzcfqVar.f77759c;
        if (i4 - i3 < 4) {
            return ((zzj() & 255) << 24) | ((zzj() & 255) << 16) | ((zzj() & 255) << 8) | (zzj() & 255);
        }
        byte[] bArr = zzcfqVar.f77757a;
        int i5 = (bArr[i3] & 255) << 24;
        int i6 = (bArr[i3 + 1] & 255) << 16;
        int i7 = (bArr[i3 + 2] & 255) << 8;
        this.f77741b -= 4;
        int i8 = (bArr[i3 + 3] & 255) | i6 | i5 | i7;
        int i9 = i3 + 4;
        if (i9 != i4) {
            zzcfqVar.f77758b = i9;
            return i8;
        }
        this.f77740a = zzcfqVar.b();
        zzcfr.b(zzcfqVar);
        return i8;
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final byte[] zzr(long j3) throws EOFException {
        if (j3 < 0 || j3 > 2147483647L) {
            StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 11);
            sb.append("byteCount: ");
            sb.append(j3);
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.f77741b < j3) {
            throw new EOFException();
        }
        int i3 = (int) j3;
        byte[] sink = new byte[i3];
        Intrinsics.checkNotNullParameter(sink, "sink");
        int i4 = 0;
        while (i4 < i3) {
            int iL = L(sink, i4, i3 - i4);
            if (iL == -1) {
                throw new EOFException();
            }
            i4 += iL;
        }
        return sink;
    }

    public final zzcff O(String string, int i3, int i4) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (i4 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 27);
            sb.append("endIndex < beginIndex: ");
            sb.append(i4);
            sb.append(" < 0");
            throw new IllegalArgumentException(sb.toString());
        }
        if (i4 > string.length()) {
            int length = string.length();
            StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 29 + String.valueOf(length).length());
            sb2.append("endIndex > string.length: ");
            sb2.append(i4);
            sb2.append(muQRKXGtpOhe.YTItWchkkKbub);
            sb2.append(length);
            throw new IllegalArgumentException(sb2.toString());
        }
        int i5 = 0;
        while (i5 < i4) {
            int i6 = i5 + 1;
            char cCharAt = string.charAt(i5);
            if (cCharAt < 128) {
                zzcfq zzcfqVarJ = j(1);
                byte[] bArr = zzcfqVarJ.f77757a;
                int i7 = zzcfqVarJ.f77759c - i5;
                int iMin = Math.min(i4, 8192 - i7);
                bArr[i5 + i7] = (byte) cCharAt;
                i5 = i6;
                while (i5 < iMin) {
                    char cCharAt2 = string.charAt(i5);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i5 + i7] = (byte) cCharAt2;
                    i5++;
                }
                int i8 = zzcfqVarJ.f77759c;
                int i9 = (i7 + i5) - i8;
                zzcfqVarJ.f77759c = i8 + i9;
                this.f77741b += (long) i9;
            } else {
                if (cCharAt < 2048) {
                    zzcfq zzcfqVarJ2 = j(2);
                    byte[] bArr2 = zzcfqVarJ2.f77757a;
                    int i10 = zzcfqVarJ2.f77759c;
                    bArr2[i10] = (byte) ((cCharAt >> 6) | 192);
                    bArr2[i10 + 1] = (byte) ((cCharAt & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    zzcfqVarJ2.f77759c = i10 + 2;
                    this.f77741b += 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    zzcfq zzcfqVarJ3 = j(3);
                    byte[] bArr3 = zzcfqVarJ3.f77757a;
                    int i11 = zzcfqVarJ3.f77759c;
                    bArr3[i11] = (byte) ((cCharAt >> '\f') | 224);
                    bArr3[i11 + 1] = (byte) ((63 & (cCharAt >> 6)) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    bArr3[i11 + 2] = (byte) ((cCharAt & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    zzcfqVarJ3.f77759c = i11 + 3;
                    this.f77741b += 3;
                } else {
                    char cCharAt3 = i6 < i4 ? string.charAt(i6) : (char) 0;
                    if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 >= 57344) {
                        a(63);
                    } else {
                        zzcfq zzcfqVarJ4 = j(4);
                        byte[] bArr4 = zzcfqVarJ4.f77757a;
                        int i12 = zzcfqVarJ4.f77759c;
                        int i13 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        bArr4[i12] = (byte) ((i13 >> 18) | 240);
                        bArr4[i12 + 1] = (byte) (((i13 >> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        bArr4[i12 + 2] = (byte) (((i13 >> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        bArr4[i12 + 3] = (byte) ((i13 & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                        zzcfqVarJ4.f77759c = i12 + 4;
                        this.f77741b += 4;
                        i5 += 2;
                    }
                }
                i5 = i6;
            }
        }
        return this;
    }
}
