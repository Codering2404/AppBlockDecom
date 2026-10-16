package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int f(CharSequence charSequence, int i3, int i4) {
        CType cTypeG;
        CType cTypeG2;
        char cCharAt;
        CType cTypeG3 = g(charSequence, i3);
        CType cType = CType.ONE_DIGIT;
        if (cTypeG3 == cType) {
            return 100;
        }
        CType cType2 = CType.UNCODABLE;
        if (cTypeG3 == cType2) {
            return (i3 >= charSequence.length() || ((cCharAt = charSequence.charAt(i3)) >= ' ' && (i4 != 101 || cCharAt >= '`'))) ? 100 : 101;
        }
        if (i4 == 99) {
            return 99;
        }
        if (i4 != 100) {
            if (cTypeG3 == CType.FNC_1) {
                cTypeG3 = g(charSequence, i3 + 1);
            }
            return cTypeG3 == CType.TWO_DIGITS ? 99 : 100;
        }
        CType cType3 = CType.FNC_1;
        if (cTypeG3 == cType3 || (cTypeG = g(charSequence, i3 + 2)) == cType2 || cTypeG == cType) {
            return 100;
        }
        if (cTypeG == cType3) {
            return g(charSequence, i3 + 3) == CType.TWO_DIGITS ? 99 : 100;
        }
        int i5 = i3 + 4;
        while (true) {
            cTypeG2 = g(charSequence, i5);
            if (cTypeG2 != CType.TWO_DIGITS) {
                break;
            }
            i5 += 2;
        }
        return cTypeG2 == CType.ONE_DIGIT ? 100 : 99;
    }

    private static CType g(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        if (i3 >= length) {
            return CType.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i3);
        if (cCharAt == 241) {
            return CType.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return CType.UNCODABLE;
        }
        int i4 = i3 + 1;
        if (i4 >= length) {
            return CType.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i4);
        return (cCharAt2 < '0' || cCharAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix a(String str, BarcodeFormat barcodeFormat, int i3, int i4, Map map) {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i3, i4, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] c(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int iB = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            switch (cCharAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (cCharAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(cCharAt)));
                    }
                    break;
                    break;
            }
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (true) {
            int i8 = 103;
            if (i4 >= length) {
                int[][] iArr = Code128Reader.f91915a;
                arrayList.add(iArr[i5 % 103]);
                arrayList.add(iArr[106]);
                int size = arrayList.size();
                int i9 = 0;
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    for (int i11 : (int[]) obj) {
                        i9 += i11;
                    }
                }
                boolean[] zArr = new boolean[i9];
                int size2 = arrayList.size();
                int i12 = 0;
                while (i12 < size2) {
                    Object obj2 = arrayList.get(i12);
                    i12++;
                    iB += OneDimensionalCodeWriter.b(zArr, iB, (int[]) obj2, true);
                }
                return zArr;
            }
            int iF = f(str, i4, i6);
            int iCharAt = 100;
            if (iF == i6) {
                switch (str.charAt(i4)) {
                    case 241:
                        iCharAt = 102;
                        break;
                    case 242:
                        iCharAt = 97;
                        break;
                    case 243:
                        iCharAt = 96;
                        break;
                    case 244:
                        if (i6 == 101) {
                            iCharAt = 101;
                        }
                        break;
                    default:
                        if (i6 == 100) {
                            iCharAt = str.charAt(i4) - ' ';
                        } else if (i6 != 101) {
                            iCharAt = Integer.parseInt(str.substring(i4, i4 + 2));
                            i4++;
                        } else {
                            char cCharAt2 = str.charAt(i4);
                            iCharAt = cCharAt2 - ' ';
                            if (iCharAt < 0) {
                                iCharAt = cCharAt2 + '@';
                            }
                        }
                        break;
                }
                i4++;
            } else {
                if (i6 != 0) {
                    i8 = iF;
                } else if (iF == 100) {
                    i8 = 104;
                } else if (iF != 101) {
                    i8 = 105;
                }
                iCharAt = i8;
                i6 = iF;
            }
            arrayList.add(Code128Reader.f91915a[iCharAt]);
            i5 += iCharAt * i7;
            if (i4 != 0) {
                i7++;
            }
        }
    }
}
