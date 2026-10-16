package androidx.compose.ui.node;

import androidx.compose.runtime.AbstractApplier;
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
public final class UiApplier extends AbstractApplier<LayoutNode> {
    public UiApplier(LayoutNode layoutNode) {
        super(layoutNode);
    }

    @Override // androidx.compose.runtime.Applier
    public void a(int i3, int i4) {
        ((LayoutNode) b()).w1(i3, i4);
    }

    @Override // androidx.compose.runtime.Applier
    public void c(int i3, int i4, int i5) {
        ((LayoutNode) b()).n1(i3, i4, i5);
    }

    @Override // androidx.compose.runtime.Applier
    public void f() {
        super.f();
        Owner ownerA0 = ((LayoutNode) l()).A0();
        if (ownerA0 != null) {
            ownerA0.E();
        }
    }

    @Override // androidx.compose.runtime.Applier
    public void i() {
        ((LayoutNode) b()).i();
    }

    @Override // androidx.compose.runtime.AbstractApplier
    protected void n() {
        ((LayoutNode) l()).v1();
    }

    @Override // androidx.compose.runtime.Applier
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void g(int i3, LayoutNode layoutNode) {
        ((LayoutNode) b()).M0(i3, layoutNode);
    }

    @Override // androidx.compose.runtime.Applier
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void e(int i3, LayoutNode layoutNode) {
    }
}
