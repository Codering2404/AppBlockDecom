package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class UnspecifiedConstraintsElement extends ModifierNodeElement<UnspecifiedConstraintsNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f7163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f7164b;

    public /* synthetic */ UnspecifiedConstraintsElement(float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public UnspecifiedConstraintsNode create() {
        return new UnspecifiedConstraintsNode(this.f7163a, this.f7164b, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(UnspecifiedConstraintsNode unspecifiedConstraintsNode) {
        unspecifiedConstraintsNode.n2(this.f7163a);
        unspecifiedConstraintsNode.m2(this.f7164b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UnspecifiedConstraintsElement)) {
            return false;
        }
        UnspecifiedConstraintsElement unspecifiedConstraintsElement = (UnspecifiedConstraintsElement) obj;
        return Dp.i(this.f7163a, unspecifiedConstraintsElement.f7163a) && Dp.i(this.f7164b, unspecifiedConstraintsElement.f7164b);
    }

    public int hashCode() {
        return (Dp.j(this.f7163a) * 31) + Dp.j(this.f7164b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("defaultMinSize");
        inspectorInfo.b().c("minWidth", Dp.d(this.f7163a));
        inspectorInfo.b().c("minHeight", Dp.d(this.f7164b));
    }

    private UnspecifiedConstraintsElement(float f3, float f4) {
        this.f7163a = f3;
        this.f7164b = f4;
    }
}
