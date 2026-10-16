package com.facebook.ads.redexgen.core;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9Y, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C9Y {
    public static String[] A0M = {"T7VAgrMlNjunoCY92EX", "RGUT9owbnhx8phDbzrCYMg", "CVNC8QX", "fBdqcrRV46KfIZmPA23V4p", "8FvZMHzhr", "kMgSgwu", "1eJdCrNjGcKHTUWf60z", "EzFxZEW8JHF4ThmiFQVxs9z"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public short[] A0A;
    public short[] A0B;
    public short[] A0C;
    public final float A0D;
    public final float A0E;
    public final float A0F;
    public final int A0G;
    public final int A0H;
    public final int A0I;
    public final int A0J;
    public final int A0K;
    public final short[] A0L;

    public C9Y(int i3, int i4, float f3, float f4, int i5) {
        this.A0H = i3;
        this.A0G = i4;
        this.A0F = f3;
        this.A0D = f4;
        this.A0E = i3 / i5;
        this.A0K = i3 / RCHTTPStatusCodes.BAD_REQUEST;
        this.A0I = i3 / 65;
        this.A0J = this.A0I * 2;
        this.A0L = new short[this.A0J];
        this.A0A = new short[this.A0J * i4];
        this.A0B = new short[this.A0J * i4];
        this.A0C = new short[this.A0J * i4];
    }

    private int A00(int i3) {
        int iMin = Math.min(this.A0J, this.A09);
        A0D(this.A0A, i3, iMin);
        int frameCount = this.A09;
        this.A09 = frameCount - iMin;
        return iMin;
    }

    private int A01(short[] sArr, int i3) {
        int minP;
        int maxP;
        int i4 = this.A0H > 4000 ? this.A0H / 4000 : 1;
        int i5 = this.A0G;
        if (A0M[4].length() != 9) {
            throw new RuntimeException();
        }
        A0M[5] = "ihqHcMR";
        if (i5 == 1 && i4 == 1) {
            int i6 = this.A0K;
            int skip = this.A0I;
            minP = A04(sArr, i3, i6, skip);
        } else {
            A0E(sArr, i3, i4);
            short[] sArr2 = this.A0L;
            int i7 = this.A0K / i4;
            int skip2 = this.A0I;
            minP = A04(sArr2, 0, i7, skip2 / i4);
            if (i4 != 1) {
                int minP2 = minP * i4;
                int skip3 = i4 * 4;
                int period = minP2 - skip3;
                int i8 = (i4 * 4) + minP2;
                int skip4 = this.A0K;
                if (period < skip4) {
                    period = this.A0K;
                }
                int skip5 = this.A0I;
                if (i8 > skip5) {
                    i8 = this.A0I;
                }
                int skip6 = this.A0G;
                if (skip6 == 1) {
                    minP = A04(sArr, i3, period, i8);
                } else {
                    A0E(sArr, i3, 1);
                    minP = A04(this.A0L, 0, period, i8);
                }
            }
        }
        int period2 = this.A02;
        int skip7 = this.A01;
        if (A0F(period2, skip7)) {
            maxP = this.A08;
        } else {
            maxP = minP;
        }
        int skip8 = this.A02;
        this.A07 = skip8;
        if (A0M[5].length() != 7) {
            throw new RuntimeException();
        }
        String[] strArr = A0M;
        strArr[6] = "cTOoGT7MMdDrVmklJ8r";
        strArr[0] = "keLDEQoIXNVpWb6w58r";
        this.A08 = minP;
        return maxP;
    }

    private int A02(short[] sArr, int i3, float f3, int i4) {
        int i5;
        if (f3 < 0.5f) {
            i5 = (int) ((i4 * f3) / (1.0f - f3));
        } else {
            i5 = i4;
            int newFrameCount = (int) ((i4 * ((2.0f * f3) - 1.0f)) / (1.0f - f3));
            this.A09 = newFrameCount;
        }
        int newFrameCount2 = i4 + i5;
        this.A0B = A0G(this.A0B, this.A05, newFrameCount2);
        int i6 = this.A0G * i3;
        short[] sArr2 = this.A0B;
        int i7 = this.A05;
        int newFrameCount3 = this.A0G;
        int i8 = i7 * newFrameCount3;
        int newFrameCount4 = this.A0G;
        System.arraycopy(sArr, i6, sArr2, i8, newFrameCount4 * i4);
        A0C(i5, this.A0G, this.A0B, this.A05 + i4, sArr, i3 + i4, sArr, i3);
        int newFrameCount5 = this.A05;
        this.A05 = newFrameCount5 + i4 + i5;
        return i5;
    }

    private int A03(short[] sArr, int i3, float f3, int i4) {
        int newFrameCount;
        if (f3 >= 2.0f) {
            newFrameCount = (int) (i4 / (f3 - 1.0f));
        } else {
            this.A09 = (int) ((i4 * (2.0f - f3)) / (f3 - 1.0f));
            newFrameCount = i4;
        }
        short[] sArr2 = this.A0B;
        int newFrameCount2 = this.A05;
        this.A0B = A0G(sArr2, newFrameCount2, newFrameCount);
        A0C(newFrameCount, this.A0G, this.A0B, this.A05, sArr, i3, sArr, i3 + i4);
        int newFrameCount3 = this.A05;
        this.A05 = newFrameCount3 + newFrameCount;
        return newFrameCount;
    }

    private int A04(short[] sArr, int i3, int i4, int i5) {
        int i6 = 0;
        int i7 = 255;
        int period = 1;
        int maxDiff = 0;
        int bestPeriod = this.A0G;
        int i8 = i3 * bestPeriod;
        while (i4 <= i5) {
            int diff = 0;
            for (int minDiff = 0; minDiff < i4; minDiff++) {
                int bestPeriod2 = i8 + minDiff;
                short s2 = sArr[bestPeriod2];
                int bestPeriod3 = i8 + i4;
                int worstPeriod = s2 - sArr[bestPeriod3 + minDiff];
                int bestPeriod4 = Math.abs(worstPeriod);
                diff += bestPeriod4;
            }
            int worstPeriod2 = diff * i6;
            int bestPeriod5 = period * i4;
            if (worstPeriod2 < bestPeriod5) {
                period = diff;
                i6 = i4;
            }
            int worstPeriod3 = diff * i7;
            int bestPeriod6 = maxDiff * i4;
            if (worstPeriod3 > bestPeriod6) {
                maxDiff = diff;
                i7 = i4;
            }
            i4++;
        }
        this.A02 = period / i6;
        this.A01 = maxDiff / i7;
        return i6;
    }

    private short A05(short[] sArr, int i3, int i4, int i5) {
        short s2 = sArr[i3];
        short s3 = sArr[this.A0G + i3];
        int leftPosition = this.A03 * i4;
        int i6 = this.A04 * i5;
        int position = (this.A04 + 1) * i5;
        int i7 = position - leftPosition;
        int position2 = position - i6;
        short left = (short) (((i7 * s2) + ((position2 - i7) * s3)) / position2);
        return left;
    }

    private void A06() {
        int i3 = this.A05;
        float f3 = this.A0F / this.A0D;
        float f4 = this.A0E * this.A0D;
        if (f3 > 1.00001d || f3 < 0.99999d) {
            A07(f3);
        } else {
            A0D(this.A0A, 0, this.A00);
            this.A00 = 0;
        }
        if (f4 != 1.0f) {
            A08(f4, i3);
        }
    }

    private void A07(float f3) {
        int frameCount;
        if (this.A00 < this.A0J) {
            return;
        }
        int i3 = this.A00;
        if (A0M[4].length() != 9) {
            throw new RuntimeException();
        }
        A0M[4] = "1EAucAhfj";
        int i4 = 0;
        do {
            int frameCount2 = this.A09;
            if (frameCount2 > 0) {
                int frameCount3 = A00(i4);
                i4 += frameCount3;
            } else {
                int iA01 = A01(this.A0A, i4);
                if (f3 > 1.0d) {
                    int frameCount4 = A03(this.A0A, i4, f3, iA01);
                    i4 += frameCount4 + iA01;
                } else {
                    int iA02 = A02(this.A0A, i4, f3, iA01);
                    int positionFrames = A0M[4].length();
                    if (positionFrames != 9) {
                        i4 += iA02;
                    } else {
                        String[] strArr = A0M;
                        strArr[7] = "LI3iTvxeiLHfC3eQqEyHhGd";
                        strArr[2] = "DQqtHf8";
                        i4 += iA02;
                    }
                }
            }
            frameCount = this.A0J;
        } while (frameCount + i4 <= i3);
        A0B(i4);
    }

    /* JADX WARN: Incorrect condition in loop: B:24:0x0070 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(float r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.A05
            if (r0 != r11) goto L5
            return
        L5:
            int r0 = r9.A0H
            float r0 = (float) r0
            float r0 = r0 / r10
            int r4 = (int) r0
            int r3 = r9.A0H
        Lc:
            r0 = 16384(0x4000, float:2.2959E-41)
            if (r4 > r0) goto L12
            if (r3 <= r0) goto L31
        L12:
            int r4 = r4 / 2
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C9Y.A0M
            r0 = 4
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 9
            if (r1 == r0) goto L27
        L21:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L27:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C9Y.A0M
            java.lang.String r1 = "8yLWj9SnB"
            r0 = 4
            r2[r0] = r1
            int r3 = r3 / 2
            goto Lc
        L31:
            r9.A09(r11)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C9Y.A0M
            r0 = 3
            r1 = r2[r0]
            r0 = 1
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L47
            goto L21
        L47:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C9Y.A0M
            java.lang.String r1 = "6iwvuS4pXw8rJ8Q1q7RXek"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "P2j6LGlMYimVuvOXYheyMm"
            r0 = 1
            r2[r0] = r1
            r0 = 0
        L54:
            int r1 = r9.A06
            r5 = 1
            int r1 = r1 - r5
            if (r0 >= r1) goto Lae
        L5a:
            int r2 = r9.A04
            int r2 = r2 + r5
            int r2 = r2 * r4
            int r1 = r9.A03
            int r1 = r1 * r3
            if (r2 <= r1) goto L94
            short[] r2 = r9.A0B
            int r1 = r9.A05
            short[] r1 = r9.A0G(r2, r1, r5)
            r9.A0B = r1
            r8 = 0
        L6e:
            int r1 = r9.A0G
            if (r8 >= r1) goto L89
            short[] r7 = r9.A0B
            int r6 = r9.A05
            int r1 = r9.A0G
            int r6 = r6 * r1
            int r6 = r6 + r8
            short[] r2 = r9.A0C
            int r1 = r9.A0G
            int r1 = r1 * r0
            int r1 = r1 + r8
            short r1 = r9.A05(r2, r1, r3, r4)
            r7[r6] = r1
            int r8 = r8 + 1
            goto L6e
        L89:
            int r1 = r9.A03
            int r1 = r1 + r5
            r9.A03 = r1
            int r1 = r9.A05
            int r1 = r1 + r5
            r9.A05 = r1
            goto L5a
        L94:
            int r1 = r9.A04
            int r1 = r1 + r5
            r9.A04 = r1
            int r1 = r9.A04
            if (r1 != r3) goto La9
            r2 = 0
            r9.A04 = r2
            int r1 = r9.A03
            if (r1 != r4) goto Lac
        La4:
            com.facebook.ads.redexgen.core.AbstractC04323y.A08(r5)
            r9.A03 = r2
        La9:
            int r0 = r0 + 1
            goto L54
        Lac:
            r5 = 0
            goto La4
        Lae:
            int r0 = r9.A06
            int r0 = r0 - r5
            r9.A0A(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C9Y.A08(float, int):void");
    }

    private void A09(int i3) {
        int i4 = this.A05 - i3;
        short[] sArr = this.A0C;
        int frameCount = this.A06;
        this.A0C = A0G(sArr, frameCount, i4);
        short[] sArr2 = this.A0B;
        int i5 = this.A0G * i3;
        short[] sArr3 = this.A0C;
        int i6 = this.A06;
        int frameCount2 = this.A0G;
        int i7 = i6 * frameCount2;
        int frameCount3 = this.A0G;
        System.arraycopy(sArr2, i5, sArr3, i7, frameCount3 * i4);
        this.A05 = i3;
        int frameCount4 = this.A06;
        this.A06 = frameCount4 + i4;
    }

    private void A0A(int i3) {
        if (i3 == 0) {
            return;
        }
        System.arraycopy(this.A0C, this.A0G * i3, this.A0C, 0, (this.A06 - i3) * this.A0G);
        this.A06 -= i3;
    }

    private void A0B(int i3) {
        int i4 = this.A00 - i3;
        System.arraycopy(this.A0A, this.A0G * i3, this.A0A, 0, this.A0G * i4);
        this.A00 = i4;
    }

    public static void A0C(int i3, int i4, short[] sArr, int i5, short[] sArr2, int i6, short[] sArr3, int i7) {
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = (i5 * i4) + i8;
            int t2 = (i7 * i4) + i8;
            int d3 = (i6 * i4) + i8;
            for (int u2 = 0; u2 < i3; u2++) {
                int i10 = i3 - u2;
                int o3 = sArr2[d3] * i10;
                int i11 = sArr3[t2] * u2;
                sArr[i9] = (short) ((o3 + i11) / i3);
                i9 += i4;
                d3 += i4;
                t2 += i4;
            }
        }
    }

    private void A0D(short[] sArr, int i3, int i4) {
        this.A0B = A0G(this.A0B, this.A05, i4);
        System.arraycopy(sArr, this.A0G * i3, this.A0B, this.A05 * this.A0G, this.A0G * i4);
        this.A05 += i4;
    }

    private void A0E(short[] sArr, int i3, int i4) {
        int i5 = this.A0J / i4;
        int value = this.A0G * i4;
        int frameCount = this.A0G;
        int i6 = i3 * frameCount;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = 0;
            for (int samplesPerValue = 0; samplesPerValue < value; samplesPerValue++) {
                int frameCount2 = i7 * value;
                i8 += sArr[frameCount2 + i6 + samplesPerValue];
            }
            int i9 = i8 / value;
            String[] strArr = A0M;
            String str = strArr[6];
            String str2 = strArr[0];
            int samplesPerValue2 = str.length();
            int frameCount3 = str2.length();
            if (samplesPerValue2 != frameCount3) {
                throw new RuntimeException();
            }
            A0M[4] = "fFYg0yxzP";
            this.A0L[i7] = (short) i9;
        }
    }

    private boolean A0F(int i3, int i4) {
        if (i3 == 0 || this.A08 == 0 || i4 > i3 * 3 || i3 * 2 <= this.A07 * 3) {
            return false;
        }
        return true;
    }

    private short[] A0G(short[] sArr, int i3, int i4) {
        int length = sArr.length / this.A0G;
        if (i3 + i4 <= length) {
            return sArr;
        }
        int currentCapacityFrames = length * 3;
        int newCapacityFrames = (currentCapacityFrames / 2) + i4;
        int currentCapacityFrames2 = this.A0G;
        return Arrays.copyOf(sArr, currentCapacityFrames2 * newCapacityFrames);
    }

    public final int A0H() {
        return this.A05 * this.A0G * 2;
    }

    public final int A0I() {
        return this.A00 * this.A0G * 2;
    }

    public final void A0J() {
        this.A00 = 0;
        this.A05 = 0;
        this.A06 = 0;
        this.A04 = 0;
        this.A03 = 0;
        this.A09 = 0;
        this.A08 = 0;
        this.A07 = 0;
        this.A02 = 0;
        this.A01 = 0;
    }

    public final void A0K() {
        int i3 = this.A00;
        float f3 = this.A0F / this.A0D;
        float r2 = this.A0E * this.A0D;
        int i4 = this.A05;
        float s2 = i3;
        int remainingFrameCount = this.A06;
        int i5 = i4 + ((int) ((((s2 / f3) + remainingFrameCount) / r2) + 0.5f));
        short[] sArr = this.A0A;
        int i6 = this.A00;
        int remainingFrameCount2 = this.A0J;
        this.A0A = A0G(sArr, i6, (remainingFrameCount2 * 2) + i3);
        int expectedOutputFrames = 0;
        while (true) {
            int remainingFrameCount3 = this.A0J;
            int i7 = remainingFrameCount3 * 2;
            int remainingFrameCount4 = this.A0G;
            if (expectedOutputFrames >= i7 * remainingFrameCount4) {
                break;
            }
            short[] sArr2 = this.A0A;
            int remainingFrameCount5 = this.A0G;
            sArr2[(remainingFrameCount5 * i3) + expectedOutputFrames] = 0;
            expectedOutputFrames++;
        }
        int i8 = this.A00;
        int remainingFrameCount6 = this.A0J;
        this.A00 = i8 + (remainingFrameCount6 * 2);
        A06();
        int remainingFrameCount7 = this.A05;
        if (remainingFrameCount7 > i5) {
            this.A05 = i5;
        }
        this.A00 = 0;
        this.A09 = 0;
        this.A06 = 0;
    }

    public final void A0L(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.A0G, this.A05);
        short[] sArr = this.A0B;
        int framesToRead = this.A0G;
        shortBuffer.put(sArr, 0, framesToRead * iMin);
        int framesToRead2 = this.A05;
        this.A05 = framesToRead2 - iMin;
        short[] sArr2 = this.A0B;
        int i3 = this.A0G * iMin;
        short[] sArr3 = this.A0B;
        int i4 = this.A05;
        int framesToRead3 = this.A0G;
        System.arraycopy(sArr2, i3, sArr3, 0, i4 * framesToRead3);
    }

    public final void A0M(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining() / this.A0G;
        int framesToWrite = this.A0G;
        int i3 = framesToWrite * iRemaining * 2;
        short[] sArr = this.A0A;
        int framesToWrite2 = this.A00;
        this.A0A = A0G(sArr, framesToWrite2, iRemaining);
        short[] sArr2 = this.A0A;
        int bytesToWrite = this.A00;
        int framesToWrite3 = this.A0G;
        int bytesToWrite2 = bytesToWrite * framesToWrite3;
        int framesToWrite4 = i3 / 2;
        shortBuffer.get(sArr2, bytesToWrite2, framesToWrite4);
        int framesToWrite5 = this.A00;
        this.A00 = framesToWrite5 + iRemaining;
        A06();
    }
}
