package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
final class DraggableAnchorsElement<T> extends ModifierNodeElement<DraggableAnchorsNode<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnchoredDraggableState f12700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f12701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Orientation f12702c;

    public DraggableAnchorsElement(AnchoredDraggableState anchoredDraggableState, Function2 function2, Orientation orientation) {
        this.f12700a = anchoredDraggableState;
        this.f12701b = function2;
        this.f12702c = orientation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public DraggableAnchorsNode create() {
        return new DraggableAnchorsNode(this.f12700a, this.f12701b, this.f12702c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DraggableAnchorsElement)) {
            return false;
        }
        DraggableAnchorsElement draggableAnchorsElement = (DraggableAnchorsElement) obj;
        return Intrinsics.areEqual(this.f12700a, draggableAnchorsElement.f12700a) && this.f12701b == draggableAnchorsElement.f12701b && this.f12702c == draggableAnchorsElement.f12702c;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void update(DraggableAnchorsNode draggableAnchorsNode) {
        draggableAnchorsNode.q2(this.f12700a);
        draggableAnchorsNode.o2(this.f12701b);
        draggableAnchorsNode.p2(this.f12702c);
    }

    public int hashCode() {
        return (((this.f12700a.hashCode() * 31) + this.f12701b.hashCode()) * 31) + this.f12702c.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        if (InspectableValueKt.b()) {
            new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.DraggableAnchorsElement$inspectableProperties$$inlined$debugInspectorInfo$1
                {
                    super(1);
                }

                public final void c(InspectorInfo inspectorInfo2) {
                    inspectorInfo2.b().c(ServerProtocol.DIALOG_PARAM_STATE, this.f12703a.f12700a);
                    inspectorInfo2.b().c("anchors", this.f12703a.f12701b);
                    inspectorInfo2.b().c("orientation", this.f12703a.f12702c);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((InspectorInfo) obj);
                    return Unit.f139807a;
                }
            };
        } else {
            InspectableValueKt.a();
        }
    }
}
