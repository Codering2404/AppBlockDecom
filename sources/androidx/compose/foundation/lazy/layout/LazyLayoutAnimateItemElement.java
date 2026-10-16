package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
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
public final class LazyLayoutAnimateItemElement extends ModifierNodeElement<LazyLayoutAnimationSpecsNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FiniteAnimationSpec f7994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FiniteAnimationSpec f7995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FiniteAnimationSpec f7996c;

    public LazyLayoutAnimateItemElement(FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        this.f7994a = finiteAnimationSpec;
        this.f7995b = finiteAnimationSpec2;
        this.f7996c = finiteAnimationSpec3;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LazyLayoutAnimationSpecsNode create() {
        return new LazyLayoutAnimationSpecsNode(this.f7994a, this.f7995b, this.f7996c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(LazyLayoutAnimationSpecsNode lazyLayoutAnimationSpecsNode) {
        lazyLayoutAnimationSpecsNode.p2(this.f7994a);
        lazyLayoutAnimationSpecsNode.r2(this.f7995b);
        lazyLayoutAnimationSpecsNode.q2(this.f7996c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyLayoutAnimateItemElement)) {
            return false;
        }
        LazyLayoutAnimateItemElement lazyLayoutAnimateItemElement = (LazyLayoutAnimateItemElement) obj;
        return Intrinsics.areEqual(this.f7994a, lazyLayoutAnimateItemElement.f7994a) && Intrinsics.areEqual(this.f7995b, lazyLayoutAnimateItemElement.f7995b) && Intrinsics.areEqual(this.f7996c, lazyLayoutAnimateItemElement.f7996c);
    }

    public int hashCode() {
        FiniteAnimationSpec finiteAnimationSpec = this.f7994a;
        int iHashCode = (finiteAnimationSpec == null ? 0 : finiteAnimationSpec.hashCode()) * 31;
        FiniteAnimationSpec finiteAnimationSpec2 = this.f7995b;
        int iHashCode2 = (iHashCode + (finiteAnimationSpec2 == null ? 0 : finiteAnimationSpec2.hashCode())) * 31;
        FiniteAnimationSpec finiteAnimationSpec3 = this.f7996c;
        return iHashCode2 + (finiteAnimationSpec3 != null ? finiteAnimationSpec3.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("animateItem");
        inspectorInfo.b().c("fadeInSpec", this.f7994a);
        inspectorInfo.b().c("placementSpec", this.f7995b);
        inspectorInfo.b().c("fadeOutSpec", this.f7996c);
    }

    public String toString() {
        return "LazyLayoutAnimateItemElement(fadeInSpec=" + this.f7994a + ", placementSpec=" + this.f7995b + ", fadeOutSpec=" + this.f7996c + ')';
    }
}
