package androidx.glance.appwidget;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SizeSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutSize f38454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LayoutSize f38455b;

    public SizeSelector(LayoutSize layoutSize, LayoutSize layoutSize2) {
        this.f38454a = layoutSize;
        this.f38455b = layoutSize2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeSelector)) {
            return false;
        }
        SizeSelector sizeSelector = (SizeSelector) obj;
        return this.f38454a == sizeSelector.f38454a && this.f38455b == sizeSelector.f38455b;
    }

    public int hashCode() {
        return (this.f38454a.hashCode() * 31) + this.f38455b.hashCode();
    }

    public String toString() {
        return "SizeSelector(width=" + this.f38454a + ", height=" + this.f38455b + ')';
    }
}
