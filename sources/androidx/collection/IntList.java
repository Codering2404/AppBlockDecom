package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

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
public abstract class IntList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f2876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2877b;

    public /* synthetic */ IntList(int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3);
    }

    public static /* synthetic */ int b(IntList intList, int i3, int i4, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: binarySearch");
        }
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = intList.f2877b;
        }
        return intList.a(i3, i4, i5);
    }

    public static /* synthetic */ String i(IntList intList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i4 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i4 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i4 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i4 & 8) != 0) {
            i3 = -1;
        }
        if ((i4 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return intList.h(charSequence, charSequence2, charSequence6, i3, charSequence5);
    }

    public final int a(int i3, int i4, int i5) {
        if (i4 < 0 || i4 >= i5 || i5 > this.f2877b) {
            RuntimeHelpersKt.c("");
        }
        int i6 = i5 - 1;
        while (i4 <= i6) {
            int i7 = (i4 + i6) >>> 1;
            int i8 = this.f2876a[i7];
            if (i8 < i3) {
                i4 = i7 + 1;
            } else {
                if (i8 <= i3) {
                    return i7;
                }
                i6 = i7 - 1;
            }
        }
        return -(i4 + 1);
    }

    public final boolean c(int i3) {
        int[] iArr = this.f2876a;
        int i4 = this.f2877b;
        for (int i5 = 0; i5 < i4; i5++) {
            if (iArr[i5] == i3) {
                return true;
            }
        }
        return false;
    }

    public final int d() {
        if (this.f2877b == 0) {
            RuntimeHelpersKt.d("IntList is empty.");
        }
        return this.f2876a[0];
    }

    public final int e(int i3) {
        if (i3 < 0 || i3 >= this.f2877b) {
            RuntimeHelpersKt.c("Index must be between 0 and size");
        }
        return this.f2876a[i3];
    }

    public boolean equals(Object obj) {
        if (obj instanceof IntList) {
            IntList intList = (IntList) obj;
            int i3 = intList.f2877b;
            int i4 = this.f2877b;
            if (i3 == i4) {
                int[] iArr = this.f2876a;
                int[] iArr2 = intList.f2876a;
                IntRange intRangeB = RangesKt.B(0, i4);
                int iG = intRangeB.g();
                int iH = intRangeB.h();
                if (iG > iH) {
                    return true;
                }
                while (iArr[iG] == iArr2[iG]) {
                    if (iG == iH) {
                        return true;
                    }
                    iG++;
                }
                return false;
            }
        }
        return false;
    }

    public final int f() {
        return this.f2877b;
    }

    public final int g(int i3) {
        int[] iArr = this.f2876a;
        int i4 = this.f2877b;
        for (int i5 = 0; i5 < i4; i5++) {
            if (i3 == iArr[i5]) {
                return i5;
            }
        }
        return -1;
    }

    public final String h(CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.f2876a;
        int i4 = this.f2877b;
        int i5 = 0;
        while (true) {
            if (i5 >= i4) {
                sb.append(postfix);
                break;
            }
            int i6 = iArr[i5];
            if (i5 == i3) {
                sb.append(truncated);
                break;
            }
            if (i5 != 0) {
                sb.append(separator);
            }
            sb.append(i6);
            i5++;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public int hashCode() {
        int[] iArr = this.f2876a;
        int i3 = this.f2877b;
        int iHashCode = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            iHashCode += Integer.hashCode(iArr[i4]) * 31;
        }
        return iHashCode;
    }

    public final int j() {
        if (this.f2877b == 0) {
            RuntimeHelpersKt.d("IntList is empty.");
        }
        return this.f2876a[this.f2877b - 1];
    }

    public String toString() {
        return i(this, null, "[", "]", 0, null, 25, null);
    }

    private IntList(int i3) {
        this.f2876a = i3 == 0 ? IntSetKt.a() : new int[i3];
    }
}
