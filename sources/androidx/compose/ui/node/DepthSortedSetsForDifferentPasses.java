package androidx.compose.ui.node;

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
public final class DepthSortedSetsForDifferentPasses {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DepthSortedSet f27315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DepthSortedSet f27316b;

    public DepthSortedSetsForDifferentPasses(boolean z2) {
        this.f27315a = new DepthSortedSet(z2);
        this.f27316b = new DepthSortedSet(z2);
    }

    public final void c(LayoutNode layoutNode, boolean z2) {
        if (z2) {
            this.f27315a.a(layoutNode);
            this.f27316b.a(layoutNode);
        } else {
            if (this.f27315a.b(layoutNode)) {
                return;
            }
            this.f27316b.a(layoutNode);
        }
    }

    public final boolean d(LayoutNode layoutNode) {
        return this.f27315a.b(layoutNode) || this.f27316b.b(layoutNode);
    }

    public final boolean e(LayoutNode layoutNode, boolean z2) {
        boolean zB = this.f27315a.b(layoutNode);
        return z2 ? zB : zB || this.f27316b.b(layoutNode);
    }

    public final boolean f() {
        return this.f27316b.c() && this.f27315a.c();
    }

    public final boolean g(boolean z2) {
        return (z2 ? this.f27315a : this.f27316b).c();
    }

    public final boolean h() {
        return !f();
    }

    public final boolean i(LayoutNode layoutNode) {
        return this.f27316b.e(layoutNode) || this.f27315a.e(layoutNode);
    }
}
