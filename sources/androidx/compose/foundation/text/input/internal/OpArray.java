package androidx.compose.foundation.text.input.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
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
@JvmInline
final class OpArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f10411a;

    public static int[] a(int i3) {
        return b(new int[i3 * 3]);
    }

    public static final int[] c(int[] iArr, int i3) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, i3 * 3);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return b(iArrCopyOf);
    }

    public static boolean d(int[] iArr, Object obj) {
        return (obj instanceof OpArray) && Intrinsics.areEqual(iArr, ((OpArray) obj).i());
    }

    public static final int e(int[] iArr) {
        return iArr.length / 3;
    }

    public static int f(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static final void g(int[] iArr, int i3, int i4, int i5, int i6) {
        int i7 = i3 * 3;
        iArr[i7] = i4;
        iArr[i7 + 1] = i5;
        iArr[i7 + 2] = i6;
    }

    public static String h(int[] iArr) {
        return "OpArray(values=" + Arrays.toString(iArr) + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f10411a, obj);
    }

    public int hashCode() {
        return f(this.f10411a);
    }

    public final /* synthetic */ int[] i() {
        return this.f10411a;
    }

    public String toString() {
        return h(this.f10411a);
    }

    private static int[] b(int[] iArr) {
        return iArr;
    }
}
