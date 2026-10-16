package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
final class AspectRatioElement extends ModifierNodeElement<AspectRatioNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f6606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f6608c;

    public AspectRatioElement(float f3, boolean z2, Function1 function1) {
        this.f6606a = f3;
        this.f6607b = z2;
        this.f6608c = function1;
        if (f3 > 0.0f) {
            return;
        }
        InlineClassHelperKt.a("aspectRatio " + f3 + " must be > 0");
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AspectRatioNode create() {
        return new AspectRatioNode(this.f6606a, this.f6607b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(AspectRatioNode aspectRatioNode) {
        aspectRatioNode.n2(this.f6606a);
        aspectRatioNode.o2(this.f6607b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        AspectRatioElement aspectRatioElement = obj instanceof AspectRatioElement ? (AspectRatioElement) obj : null;
        return aspectRatioElement != null && this.f6606a == aspectRatioElement.f6606a && this.f6607b == ((AspectRatioElement) obj).f6607b;
    }

    public int hashCode() {
        return (Float.hashCode(this.f6606a) * 31) + Boolean.hashCode(this.f6607b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.f6608c.invoke(inspectorInfo);
    }
}
