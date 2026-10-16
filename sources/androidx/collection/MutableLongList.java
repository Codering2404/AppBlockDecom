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
public final class MutableLongList extends LongList {
    public MutableLongList(int i3) {
        super(i3, null);
    }

    public final boolean d(long j3) {
        g(this.f2921b + 1);
        long[] jArr = this.f2920a;
        int i3 = this.f2921b;
        jArr[i3] = j3;
        this.f2921b = i3 + 1;
        return true;
    }

    public final boolean e(int i3, long[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (i3 < 0 || i3 > this.f2921b) {
            RuntimeHelpersKt.c("");
        }
        if (elements.length == 0) {
            return false;
        }
        g(this.f2921b + elements.length);
        long[] jArr = this.f2920a;
        int i4 = this.f2921b;
        if (i3 != i4) {
            ArraysKt.copyInto(jArr, jArr, elements.length + i3, i3, i4);
        }
        ArraysKt.copyInto$default(elements, jArr, i3, 0, 0, 12, (Object) null);
        this.f2921b += elements.length;
        return true;
    }

    public final void f() {
        this.f2921b = 0;
    }

    public final void g(int i3) {
        long[] jArr = this.f2920a;
        if (jArr.length < i3) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, Math.max(i3, (jArr.length * 3) / 2));
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
            this.f2920a = jArrCopyOf;
        }
    }

    public final long h(int i3) {
        if (i3 < 0 || i3 >= this.f2921b) {
            RuntimeHelpersKt.c("Index must be between 0 and size");
        }
        long[] jArr = this.f2920a;
        long j3 = jArr[i3];
        int i4 = this.f2921b;
        if (i3 != i4 - 1) {
            ArraysKt.copyInto(jArr, jArr, i3, i3 + 1, i4);
        }
        this.f2921b--;
        return j3;
    }

    public final void i(int i3, int i4) {
        int i5;
        if (i3 < 0 || i3 > (i5 = this.f2921b) || i4 < 0 || i4 > i5) {
            RuntimeHelpersKt.c("Index must be between 0 and size");
        }
        if (i4 < i3) {
            RuntimeHelpersKt.a("The end index must be < start index");
        }
        if (i4 != i3) {
            int i6 = this.f2921b;
            if (i4 < i6) {
                long[] jArr = this.f2920a;
                ArraysKt.copyInto(jArr, jArr, i3, i4, i6);
            }
            this.f2921b -= i4 - i3;
        }
    }

    public /* synthetic */ MutableLongList(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 16 : i3);
    }
}
