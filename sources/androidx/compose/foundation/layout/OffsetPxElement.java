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
final class OffsetPxElement extends ModifierNodeElement<OffsetPxNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f7028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f7029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f7030c;

    public OffsetPxElement(Function1 function1, boolean z2, Function1 function12) {
        this.f7028a = function1;
        this.f7029b = z2;
        this.f7030c = function12;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public OffsetPxNode create() {
        return new OffsetPxNode(this.f7028a, this.f7029b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(OffsetPxNode offsetPxNode) {
        offsetPxNode.o2(this.f7028a, this.f7029b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        OffsetPxElement offsetPxElement = obj instanceof OffsetPxElement ? (OffsetPxElement) obj : null;
        return offsetPxElement != null && this.f7028a == offsetPxElement.f7028a && this.f7029b == offsetPxElement.f7029b;
    }

    public int hashCode() {
        return (this.f7028a.hashCode() * 31) + Boolean.hashCode(this.f7029b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.f7030c.invoke(inspectorInfo);
    }

    public String toString() {
        return "OffsetPxModifier(offset=" + this.f7028a + ", rtlAware=" + this.f7029b + ')';
    }
}
