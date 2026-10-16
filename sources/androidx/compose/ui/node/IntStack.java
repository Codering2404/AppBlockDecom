package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
final class IntStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f27335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f27336b;

    public IntStack(int i3) {
        this.f27335a = new int[i3];
    }

    private final boolean a(int i3, int i4) {
        int[] iArr = this.f27335a;
        int i5 = iArr[i3];
        int i6 = iArr[i4];
        return i5 < i6 || (i5 == i6 && iArr[i3 + 1] <= iArr[i4 + 1]);
    }

    private final int e(int i3, int i4, int i5) {
        int i6 = i3 - i5;
        while (i3 < i4) {
            if (a(i3, i4)) {
                i6 += i5;
                l(i6, i3);
            }
            i3 += i5;
        }
        int i7 = i6 + i5;
        l(i7, i4);
        return i7;
    }

    private final void i(int i3, int i4, int i5) {
        if (i3 < i4) {
            int iE = e(i3, i4, i5);
            i(i3, iE - i5, i5);
            i(iE + i5, i4, i5);
        }
    }

    private final int[] j(int[] iArr) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        this.f27335a = iArrCopyOf;
        return iArrCopyOf;
    }

    private final void l(int i3, int i4) {
        int[] iArr = this.f27335a;
        MyersDiffKt.i(iArr, i3, i4);
        MyersDiffKt.i(iArr, i3 + 1, i4 + 1);
        MyersDiffKt.i(iArr, i3 + 2, i4 + 2);
    }

    public final int b(int i3) {
        return this.f27335a[i3];
    }

    public final int c() {
        return this.f27336b;
    }

    public final boolean d() {
        return this.f27336b != 0;
    }

    public final int f() {
        int[] iArr = this.f27335a;
        int i3 = this.f27336b - 1;
        this.f27336b = i3;
        return iArr[i3];
    }

    public final void g(int i3, int i4, int i5) {
        int i6 = this.f27336b;
        int[] iArrJ = this.f27335a;
        int i7 = i6 + 3;
        if (i7 >= iArrJ.length) {
            iArrJ = j(iArrJ);
        }
        iArrJ[i6] = i3 + i5;
        iArrJ[i6 + 1] = i4 + i5;
        iArrJ[i6 + 2] = i5;
        this.f27336b = i7;
    }

    public final void h(int i3, int i4, int i5, int i6) {
        int i7 = this.f27336b;
        int[] iArrJ = this.f27335a;
        int i8 = i7 + 4;
        if (i8 >= iArrJ.length) {
            iArrJ = j(iArrJ);
        }
        iArrJ[i7] = i3;
        iArrJ[i7 + 1] = i4;
        iArrJ[i7 + 2] = i5;
        iArrJ[i7 + 3] = i6;
        this.f27336b = i8;
    }

    public final void k() {
        int i3 = this.f27336b;
        if (!(i3 % 3 == 0)) {
            InlineClassHelperKt.c("Array size not a multiple of 3");
        }
        if (i3 > 3) {
            i(0, i3 - 3, 3);
        }
    }
}
