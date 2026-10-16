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
final class CenteredArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f27290a;

    public static boolean b(int[] iArr, Object obj) {
        return (obj instanceof CenteredArray) && Intrinsics.areEqual(iArr, ((CenteredArray) obj).h());
    }

    public static final int c(int[] iArr, int i3) {
        return iArr[i3 + d(iArr)];
    }

    private static final int d(int[] iArr) {
        return iArr.length / 2;
    }

    public static int e(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static final void f(int[] iArr, int i3, int i4) {
        iArr[i3 + d(iArr)] = i4;
    }

    public static String g(int[] iArr) {
        return "CenteredArray(data=" + Arrays.toString(iArr) + ')';
    }

    public boolean equals(Object obj) {
        return b(this.f27290a, obj);
    }

    public final /* synthetic */ int[] h() {
        return this.f27290a;
    }

    public int hashCode() {
        return e(this.f27290a);
    }

    public String toString() {
        return g(this.f27290a);
    }

    public static int[] a(int[] iArr) {
        return iArr;
    }
}
