package androidx.compose.foundation.layout;

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
public final class InsetsValues {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6975d;

    public InsetsValues(int i3, int i4, int i5, int i6) {
        this.f6972a = i3;
        this.f6973b = i4;
        this.f6974c = i5;
        this.f6975d = i6;
    }

    public final int a() {
        return this.f6975d;
    }

    public final int b() {
        return this.f6972a;
    }

    public final int c() {
        return this.f6974c;
    }

    public final int d() {
        return this.f6973b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsetsValues)) {
            return false;
        }
        InsetsValues insetsValues = (InsetsValues) obj;
        return this.f6972a == insetsValues.f6972a && this.f6973b == insetsValues.f6973b && this.f6974c == insetsValues.f6974c && this.f6975d == insetsValues.f6975d;
    }

    public int hashCode() {
        return (((((this.f6972a * 31) + this.f6973b) * 31) + this.f6974c) * 31) + this.f6975d;
    }

    public String toString() {
        return "InsetsValues(left=" + this.f6972a + ", top=" + this.f6973b + ", right=" + this.f6974c + ", bottom=" + this.f6975d + ')';
    }
}
