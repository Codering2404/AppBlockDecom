package com.google.zxing.oned;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class CodaBarWriter extends OneDimensionalCodeWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f91911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f91912b = {'T', 'N', '*', 'E'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f91913c = {'/', ':', '+', '.'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char f91914d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f91911a = cArr;
        f91914d = cArr[0];
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] c(String str) {
        int i3;
        if (str.length() < 2) {
            StringBuilder sb = new StringBuilder();
            char c3 = f91914d;
            sb.append(c3);
            sb.append(str);
            sb.append(c3);
            str = sb.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f91911a;
            boolean zA = CodaBarReader.a(cArr, upperCase);
            boolean zA2 = CodaBarReader.a(cArr, upperCase2);
            char[] cArr2 = f91912b;
            boolean zA3 = CodaBarReader.a(cArr2, upperCase);
            boolean zA4 = CodaBarReader.a(cArr2, upperCase2);
            if (zA) {
                if (!zA2) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (!zA3) {
                if (zA2 || zA4) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
                StringBuilder sb2 = new StringBuilder();
                char c4 = f91914d;
                sb2.append(c4);
                sb2.append(str);
                sb2.append(c4);
                str = sb2.toString();
            } else if (!zA4) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
            }
        }
        int i4 = 20;
        for (int i5 = 1; i5 < str.length() - 1; i5++) {
            if (Character.isDigit(str.charAt(i5)) || str.charAt(i5) == '-' || str.charAt(i5) == '$') {
                i4 += 9;
            } else {
                if (!CodaBarReader.a(f91913c, str.charAt(i5))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i5) + '\'');
                }
                i4 += 10;
            }
        }
        boolean[] zArr = new boolean[i4 + (str.length() - 1)];
        int i6 = 0;
        for (int i7 = 0; i7 < str.length(); i7++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i7));
            if (i7 == 0 || i7 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i8 = 0;
            while (true) {
                char[] cArr3 = CodaBarReader.f91908a;
                if (i8 >= cArr3.length) {
                    i3 = 0;
                    break;
                }
                if (upperCase3 == cArr3[i8]) {
                    i3 = CodaBarReader.f91909b[i8];
                    break;
                }
                i8++;
            }
            int i9 = 0;
            int i10 = 0;
            boolean z2 = true;
            while (i9 < 7) {
                zArr[i6] = z2;
                i6++;
                if (((i3 >> (6 - i9)) & 1) == 0 || i10 == 1) {
                    z2 = !z2;
                    i9++;
                    i10 = 0;
                } else {
                    i10++;
                }
            }
            if (i7 < str.length() - 1) {
                zArr[i6] = false;
                i6++;
            }
        }
        return zArr;
    }
}
