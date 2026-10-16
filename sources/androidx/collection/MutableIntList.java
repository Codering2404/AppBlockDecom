package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class MutableIntList extends IntList {
    public MutableIntList(int i3) {
        super(i3, null);
    }

    public final void k(int i3, int i4) {
        if (i3 < 0 || i3 > this.f2877b) {
            RuntimeHelpersKt.c("Index must be between 0 and size");
        }
        n(this.f2877b + 1);
        int[] iArr = this.f2876a;
        int i5 = this.f2877b;
        if (i3 != i5) {
            ArraysKt.copyInto(iArr, iArr, i3 + 1, i3, i5);
        }
        iArr[i3] = i4;
        this.f2877b++;
    }

    public final boolean l(int i3) {
        n(this.f2877b + 1);
        int[] iArr = this.f2876a;
        int i4 = this.f2877b;
        iArr[i4] = i3;
        this.f2877b = i4 + 1;
        return true;
    }

    public final boolean m(int i3, int[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (i3 < 0 || i3 > this.f2877b) {
            RuntimeHelpersKt.c("");
        }
        if (elements.length == 0) {
            return false;
        }
        n(this.f2877b + elements.length);
        int[] iArr = this.f2876a;
        int i4 = this.f2877b;
        if (i3 != i4) {
            ArraysKt.copyInto(iArr, iArr, elements.length + i3, i3, i4);
        }
        ArraysKt.copyInto$default(elements, iArr, i3, 0, 0, 12, (Object) null);
        this.f2877b += elements.length;
        return true;
    }

    public final void n(int i3) {
        int[] iArr = this.f2876a;
        if (iArr.length < i3) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, Math.max(i3, (iArr.length * 3) / 2));
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.f2876a = iArrCopyOf;
        }
    }

    public final boolean o(int i3) {
        int iG = g(i3);
        if (iG < 0) {
            return false;
        }
        p(iG);
        return true;
    }

    public final int p(int i3) {
        if (i3 < 0 || i3 >= this.f2877b) {
            RuntimeHelpersKt.c("Index must be between 0 and size");
        }
        int[] iArr = this.f2876a;
        int i4 = iArr[i3];
        int i5 = this.f2877b;
        if (i3 != i5 - 1) {
            ArraysKt.copyInto(iArr, iArr, i3, i3 + 1, i5);
        }
        this.f2877b--;
        return i4;
    }

    public final int q(int i3, int i4) {
        if (i3 < 0 || i3 >= this.f2877b) {
            RuntimeHelpersKt.c("Index must be between 0 and size");
        }
        int[] iArr = this.f2876a;
        int i5 = iArr[i3];
        iArr[i3] = i4;
        return i5;
    }

    public final void r() {
        int i3 = this.f2877b;
        if (i3 == 0) {
            return;
        }
        ArraysKt.sort(this.f2876a, 0, i3);
    }

    public /* synthetic */ MutableIntList(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 16 : i3);
    }
}
