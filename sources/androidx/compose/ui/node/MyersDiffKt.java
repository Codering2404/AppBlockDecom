package androidx.compose.ui.node;

import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MyersDiffKt {
    private static final void b(IntStack intStack, DiffCallback diffCallback) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < intStack.c()) {
            int i6 = i3 + 2;
            int iB = intStack.b(i3) - intStack.b(i6);
            int iB2 = intStack.b(i3 + 1) - intStack.b(i6);
            int iB3 = intStack.b(i6);
            i3 += 3;
            while (i4 < iB) {
                diffCallback.a(i5, i4);
                i4++;
            }
            while (i5 < iB2) {
                diffCallback.c(i5);
                i5++;
            }
            while (true) {
                int i7 = iB3 - 1;
                if (iB3 > 0) {
                    diffCallback.d(i4, i5);
                    i4++;
                    i5++;
                    iB3 = i7;
                }
            }
        }
    }

    private static final boolean c(int i3, int i4, int i5, int i6, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i7, int[] iArr3) {
        int iC;
        int i8;
        int i9;
        int i10 = (i4 - i3) - (i6 - i5);
        boolean z2 = (i10 & 1) == 0;
        int i11 = -i7;
        for (int i12 = i11; i12 <= i7; i12 += 2) {
            if (i12 == i11 || (i12 != i7 && CenteredArray.c(iArr2, i12 + 1) < CenteredArray.c(iArr2, i12 - 1))) {
                iC = CenteredArray.c(iArr2, i12 + 1);
                i8 = iC;
            } else {
                iC = CenteredArray.c(iArr2, i12 - 1);
                i8 = iC - 1;
            }
            int i13 = i6 - ((i4 - i8) - i12);
            int i14 = ((i7 != 0 ? 1 : 0) & (i8 == iC ? 1 : 0)) + i13;
            while (i8 > i3 && i13 > i5) {
                if (!diffCallback.b(i8 - 1, i13 - 1)) {
                    break;
                }
                i8--;
                i13--;
            }
            CenteredArray.f(iArr2, i12, i8);
            if (z2 && (i9 = i10 - i12) >= i11 && i9 <= i7) {
                if (CenteredArray.c(iArr, i9) >= i8) {
                    f(i8, i13, iC, i14, true, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    private static final IntStack d(int i3, int i4, DiffCallback diffCallback) {
        char c3 = 1;
        int i5 = ((i3 + i4) + 1) / 2;
        IntStack intStack = new IntStack(i5 * 3);
        IntStack intStack2 = new IntStack(i5 * 4);
        intStack2.h(0, i3, 0, i4);
        int i6 = (i5 * 2) + 1;
        int[] iArrA = CenteredArray.a(new int[i6]);
        int[] iArrA2 = CenteredArray.a(new int[i6]);
        int[] iArrB = Snake.b(new int[5]);
        while (intStack2.d()) {
            int iF = intStack2.f();
            int iF2 = intStack2.f();
            int iF3 = intStack2.f();
            int iF4 = intStack2.f();
            int[] iArr = iArrB;
            if (h(iF4, iF3, iF2, iF, diffCallback, iArrA, iArrA2, iArrB)) {
                char c4 = c3;
                if (Math.min(iArr[2] - iArr[0], iArr[3] - iArr[c3]) > 0) {
                    Snake.a(iArr, intStack);
                }
                intStack2.h(iF4, iArr[0], iF2, iArr[c4]);
                intStack2.h(iArr[2], iF3, iArr[3], iF);
                iArrB = iArr;
                c3 = c4;
            } else {
                iArrB = iArr;
            }
        }
        intStack.k();
        intStack.g(i3, i4, 0);
        return intStack;
    }

    public static final void e(int i3, int i4, DiffCallback diffCallback) {
        b(d(i3, i4, diffCallback), diffCallback);
    }

    public static final void f(int i3, int i4, int i5, int i6, boolean z2, int[] iArr) {
        if (iArr.length < 5) {
            return;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        iArr[2] = i5;
        iArr[3] = i6;
        iArr[4] = z2 ? 1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final boolean g(int i3, int i4, int i5, int i6, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i7, int[] iArr3) {
        int iC;
        int i8;
        boolean z2;
        int i9 = (i4 - i3) - (i6 - i5);
        boolean z3 = true;
        boolean z4 = (Math.abs(i9) & 1) == 1;
        int i10 = -i7;
        int i11 = i10;
        while (i11 <= i7) {
            if (i11 == i10 || (i11 != i7 && CenteredArray.c(iArr, i11 + 1) > CenteredArray.c(iArr, i11 - 1))) {
                iC = CenteredArray.c(iArr, i11 + 1);
                i8 = iC;
            } else {
                iC = CenteredArray.c(iArr, i11 - 1);
                i8 = iC + 1;
            }
            int i12 = (i5 + (i8 - i3)) - i11;
            int i13 = i12 - ((i7 != 0 ? z3 : 0) & (i8 == iC ? z3 : 0));
            while (i8 < i4 && i12 < i6) {
                if (!diffCallback.b(i8, i12)) {
                    break;
                }
                i8++;
                i12++;
            }
            CenteredArray.f(iArr, i11, i8);
            if (z4) {
                int i14 = i9 - i11;
                z2 = z3;
                if (i14 >= i10 + 1 && i14 <= i7 - 1) {
                    if (CenteredArray.c(iArr2, i14) <= i8) {
                        f(iC, i13, i8, i12, false, iArr3);
                        return z2;
                    }
                }
                i11 += 2;
                z3 = z2;
            } else {
                z2 = z3;
            }
            i11 += 2;
            z3 = z2;
        }
        return false;
    }

    private static final boolean h(int i3, int i4, int i5, int i6, DiffCallback diffCallback, int[] iArr, int[] iArr2, int[] iArr3) {
        int i7 = i4 - i3;
        int i8 = i6 - i5;
        if (i7 >= 1 && i8 >= 1) {
            int i9 = ((i7 + i8) + 1) / 2;
            int[] iArr4 = iArr;
            CenteredArray.f(iArr4, 1, i3);
            int[] iArr5 = iArr2;
            CenteredArray.f(iArr5, 1, i4);
            int i10 = 0;
            while (i10 < i9) {
                if (g(i3, i4, i5, i6, diffCallback, iArr4, iArr5, i10, iArr3) || c(i3, i4, i5, i6, diffCallback, iArr, iArr2, i10, iArr3)) {
                    return true;
                }
                i10++;
                iArr4 = iArr;
                iArr5 = iArr2;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int[] iArr, int i3, int i4) {
        int i5 = iArr[i3];
        iArr[i3] = iArr[i4];
        iArr[i4] = i5;
    }
}
