package androidx.compose.runtime;

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
public final class IntStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f23906a = new int[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23907b;

    private final int[] i() {
        int[] iArr = this.f23906a;
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        this.f23906a = iArrCopyOf;
        return iArrCopyOf;
    }

    public final void a() {
        this.f23907b = 0;
    }

    public final int b(int i3) {
        int[] iArr = this.f23906a;
        int iMin = Math.min(iArr.length, this.f23907b);
        for (int i4 = 0; i4 < iMin; i4++) {
            if (iArr[i4] == i3) {
                return i4;
            }
        }
        return -1;
    }

    public final int c() {
        return this.f23906a[this.f23907b - 1];
    }

    public final int d(int i3) {
        return this.f23906a[i3];
    }

    public final int e() {
        return this.f23906a[this.f23907b - 2];
    }

    public final int f(int i3) {
        int i4 = this.f23907b - 1;
        return i4 >= 0 ? this.f23906a[i4] : i3;
    }

    public final int g() {
        int[] iArr = this.f23906a;
        int i3 = this.f23907b - 1;
        this.f23907b = i3;
        return iArr[i3];
    }

    public final void h(int i3) {
        int[] iArrI = this.f23906a;
        if (this.f23907b >= iArrI.length) {
            iArrI = i();
        }
        int i4 = this.f23907b;
        this.f23907b = i4 + 1;
        iArrI[i4] = i3;
    }
}
