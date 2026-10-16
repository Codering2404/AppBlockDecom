package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
final class OffsetElement extends ModifierNodeElement<OffsetNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f7011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f7012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f7013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f7014d;

    public /* synthetic */ OffsetElement(float f3, float f4, boolean z2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, z2, function1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public OffsetNode create() {
        return new OffsetNode(this.f7011a, this.f7012b, this.f7013c, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(OffsetNode offsetNode) {
        offsetNode.p2(this.f7011a, this.f7012b, this.f7013c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        OffsetElement offsetElement = obj instanceof OffsetElement ? (OffsetElement) obj : null;
        return offsetElement != null && Dp.i(this.f7011a, offsetElement.f7011a) && Dp.i(this.f7012b, offsetElement.f7012b) && this.f7013c == offsetElement.f7013c;
    }

    public int hashCode() {
        return (((Dp.j(this.f7011a) * 31) + Dp.j(this.f7012b)) * 31) + Boolean.hashCode(this.f7013c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.f7014d.invoke(inspectorInfo);
    }

    public String toString() {
        return "OffsetModifierElement(x=" + ((Object) Dp.k(this.f7011a)) + ", y=" + ((Object) Dp.k(this.f7012b)) + ", rtlAware=" + this.f7013c + ')';
    }

    private OffsetElement(float f3, float f4, boolean z2, Function1 function1) {
        this.f7011a = f3;
        this.f7012b = f4;
        this.f7013c = z2;
        this.f7014d = function1;
    }
}
