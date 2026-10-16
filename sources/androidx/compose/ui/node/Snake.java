package androidx.compose.ui.node;

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
final class Snake {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f27635a;

    public static final void a(int[] iArr, IntStack intStack) {
        int iMin;
        int i3 = iArr[0];
        int i4 = iArr[1];
        if (d(iArr)) {
            iMin = Math.min(iArr[2] - iArr[0], iArr[3] - iArr[1]);
            i3 += ((iArr[4] != 0 ? 1 : 0) | (f(iArr) ? 1 : 0)) ^ 1;
            i4 += ((!f(iArr) ? 1 : 0) | (iArr[4] != 0 ? 1 : 0)) ^ 1;
        } else {
            iMin = iArr[2] - iArr[0];
        }
        intStack.g(i3, i4, iMin);
    }

    public static boolean c(int[] iArr, Object obj) {
        return (obj instanceof Snake) && Intrinsics.areEqual(iArr, ((Snake) obj).h());
    }

    private static final boolean d(int[] iArr) {
        return iArr[3] - iArr[1] != iArr[2] - iArr[0];
    }

    public static int e(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    private static final boolean f(int[] iArr) {
        return iArr[3] - iArr[1] > iArr[2] - iArr[0];
    }

    public static String g(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("Snake(");
        sb.append(iArr[0]);
        sb.append(',');
        sb.append(iArr[1]);
        sb.append(',');
        sb.append(iArr[2]);
        sb.append(',');
        sb.append(iArr[3]);
        sb.append(',');
        sb.append(iArr[4] != 0);
        sb.append(')');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        return c(this.f27635a, obj);
    }

    public final /* synthetic */ int[] h() {
        return this.f27635a;
    }

    public int hashCode() {
        return e(this.f27635a);
    }

    public String toString() {
        return g(this.f27635a);
    }

    public static int[] b(int[] iArr) {
        return iArr;
    }
}
