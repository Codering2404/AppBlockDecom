package com.caverock.androidsvg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class IntegerParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f67388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f67389b;

    IntegerParser(long j3, int i3) {
        this.f67389b = j3;
        this.f67388a = i3;
    }

    static IntegerParser b(String str, int i3, int i4) {
        long j3;
        int i5;
        if (i3 >= i4) {
            return null;
        }
        long j4 = 0;
        int i6 = i3;
        while (i6 < i4) {
            char cCharAt = str.charAt(i6);
            if (cCharAt < '0' || cCharAt > '9') {
                if (cCharAt >= 'A' && cCharAt <= 'F') {
                    j3 = j4 * 16;
                    i5 = cCharAt - 'A';
                } else {
                    if (cCharAt < 'a' || cCharAt > 'f') {
                        break;
                    }
                    j3 = j4 * 16;
                    i5 = cCharAt - 'a';
                }
                j4 = j3 + ((long) i5) + 10;
            } else {
                j4 = (j4 * 16) + ((long) (cCharAt - '0'));
            }
            if (j4 > 4294967295L) {
                return null;
            }
            i6++;
        }
        if (i6 == i3) {
            return null;
        }
        return new IntegerParser(j4, i6);
    }

    static IntegerParser c(String str, int i3, int i4, boolean z2) {
        if (i3 >= i4) {
            return null;
        }
        boolean z3 = false;
        if (z2) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '+') {
                i3++;
            } else if (cCharAt == '-') {
                z3 = true;
                i3++;
            }
        }
        long j3 = 0;
        int i5 = i3;
        while (i5 < i4) {
            char cCharAt2 = str.charAt(i5);
            if (cCharAt2 < '0' || cCharAt2 > '9') {
                break;
            }
            if (z3) {
                j3 = (j3 * 10) - ((long) (cCharAt2 - '0'));
                if (j3 < -2147483648L) {
                    return null;
                }
            } else {
                j3 = (j3 * 10) + ((long) (cCharAt2 - '0'));
                if (j3 > 2147483647L) {
                    return null;
                }
            }
            i5++;
        }
        if (i5 == i3) {
            return null;
        }
        return new IntegerParser(j3, i5);
    }

    int a() {
        return this.f67388a;
    }

    public int d() {
        return (int) this.f67389b;
    }
}
