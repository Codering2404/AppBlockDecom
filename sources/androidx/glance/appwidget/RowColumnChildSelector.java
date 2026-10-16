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
public final class RowColumnChildSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutType f38431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f38432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f38433c;

    public RowColumnChildSelector(LayoutType layoutType, boolean z2, boolean z3) {
        this.f38431a = layoutType;
        this.f38432b = z2;
        this.f38433c = z3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowColumnChildSelector)) {
            return false;
        }
        RowColumnChildSelector rowColumnChildSelector = (RowColumnChildSelector) obj;
        return this.f38431a == rowColumnChildSelector.f38431a && this.f38432b == rowColumnChildSelector.f38432b && this.f38433c == rowColumnChildSelector.f38433c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.f38431a.hashCode() * 31;
        boolean z2 = this.f38432b;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int i3 = (iHashCode + r12) * 31;
        boolean z3 = this.f38433c;
        return i3 + (z3 ? 1 : z3);
    }

    public String toString() {
        return "RowColumnChildSelector(type=" + this.f38431a + ", expandWidth=" + this.f38432b + ", expandHeight=" + this.f38433c + ')';
    }
}
