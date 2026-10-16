package androidx.compose.foundation.layout;

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
final class IntrinsicHeightElement extends ModifierNodeElement<IntrinsicHeightNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntrinsicSize f6976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f6978c;

    public IntrinsicHeightElement(IntrinsicSize intrinsicSize, boolean z2, Function1 function1) {
        this.f6976a = intrinsicSize;
        this.f6977b = z2;
        this.f6978c = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public IntrinsicHeightNode create() {
        return new IntrinsicHeightNode(this.f6976a, this.f6977b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(IntrinsicHeightNode intrinsicHeightNode) {
        intrinsicHeightNode.p2(this.f6976a);
        intrinsicHeightNode.o2(this.f6977b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        IntrinsicHeightElement intrinsicHeightElement = obj instanceof IntrinsicHeightElement ? (IntrinsicHeightElement) obj : null;
        return intrinsicHeightElement != null && this.f6976a == intrinsicHeightElement.f6976a && this.f6977b == intrinsicHeightElement.f6977b;
    }

    public int hashCode() {
        return (this.f6976a.hashCode() * 31) + Boolean.hashCode(this.f6977b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.f6978c.invoke(inspectorInfo);
    }
}
