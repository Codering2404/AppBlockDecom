package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
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
public final class LazyLayoutAnimationSpecsNode extends Modifier.Node implements ParentDataModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FiniteAnimationSpec f7997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FiniteAnimationSpec f7998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FiniteAnimationSpec f7999c;

    public LazyLayoutAnimationSpecsNode(FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        this.f7997a = finiteAnimationSpec;
        this.f7998b = finiteAnimationSpec2;
        this.f7999c = finiteAnimationSpec3;
    }

    public final FiniteAnimationSpec m2() {
        return this.f7997a;
    }

    public final FiniteAnimationSpec n2() {
        return this.f7999c;
    }

    public final FiniteAnimationSpec o2() {
        return this.f7998b;
    }

    public final void p2(FiniteAnimationSpec finiteAnimationSpec) {
        this.f7997a = finiteAnimationSpec;
    }

    public final void q2(FiniteAnimationSpec finiteAnimationSpec) {
        this.f7999c = finiteAnimationSpec;
    }

    public final void r2(FiniteAnimationSpec finiteAnimationSpec) {
        this.f7998b = finiteAnimationSpec;
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public Object H(Density density, Object obj) {
        return this;
    }
}
