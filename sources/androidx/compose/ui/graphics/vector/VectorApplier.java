package androidx.compose.ui.graphics.vector;

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
public final class VectorApplier extends AbstractApplier<VNode> {
    public VectorApplier(VNode vNode) {
        super(vNode);
    }

    private final GroupComponent q(VNode vNode) {
        if (vNode instanceof GroupComponent) {
            return (GroupComponent) vNode;
        }
        throw new IllegalStateException("Cannot only insert VNode into Group");
    }

    @Override // androidx.compose.runtime.Applier
    public void a(int i3, int i4) {
        q((VNode) b()).p(i3, i4);
    }

    @Override // androidx.compose.runtime.Applier
    public void c(int i3, int i4, int i5) {
        q((VNode) b()).o(i3, i4, i5);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    protected void n() {
        GroupComponent groupComponentQ = q((VNode) l());
        groupComponentQ.p(0, groupComponentQ.f());
    }

    @Override // androidx.compose.runtime.Applier
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void g(int i3, VNode vNode) {
        q((VNode) b()).i(i3, vNode);
    }

    @Override // androidx.compose.runtime.Applier
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void e(int i3, VNode vNode) {
    }
}
