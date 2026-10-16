package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class DraggableElement extends ModifierNodeElement<DraggableNode> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f5904j = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Function1 f5905k = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableElement$Companion$CanDrag$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return Boolean.TRUE;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DraggableState f5906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Orientation f5907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableInteractionSource f5909d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f5910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function3 f5911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function3 f5912h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f5913i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DraggableElement(DraggableState draggableState, Orientation orientation, boolean z2, MutableInteractionSource mutableInteractionSource, boolean z3, Function3 function3, Function3 function32, boolean z4) {
        this.f5906a = draggableState;
        this.f5907b = orientation;
        this.f5908c = z2;
        this.f5909d = mutableInteractionSource;
        this.f5910f = z3;
        this.f5911g = function3;
        this.f5912h = function32;
        this.f5913i = z4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DraggableNode create() {
        return new DraggableNode(this.f5906a, f5905k, this.f5907b, this.f5908c, this.f5909d, this.f5910f, this.f5911g, this.f5912h, this.f5913i);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(DraggableNode draggableNode) {
        draggableNode.V2(this.f5906a, f5905k, this.f5907b, this.f5908c, this.f5909d, this.f5910f, this.f5911g, this.f5912h, this.f5913i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DraggableElement.class != obj.getClass()) {
            return false;
        }
        DraggableElement draggableElement = (DraggableElement) obj;
        return Intrinsics.areEqual(this.f5906a, draggableElement.f5906a) && this.f5907b == draggableElement.f5907b && this.f5908c == draggableElement.f5908c && Intrinsics.areEqual(this.f5909d, draggableElement.f5909d) && this.f5910f == draggableElement.f5910f && Intrinsics.areEqual(this.f5911g, draggableElement.f5911g) && Intrinsics.areEqual(this.f5912h, draggableElement.f5912h) && this.f5913i == draggableElement.f5913i;
    }

    public int hashCode() {
        int iHashCode = ((((this.f5906a.hashCode() * 31) + this.f5907b.hashCode()) * 31) + Boolean.hashCode(this.f5908c)) * 31;
        MutableInteractionSource mutableInteractionSource = this.f5909d;
        return ((((((((iHashCode + (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0)) * 31) + Boolean.hashCode(this.f5910f)) * 31) + this.f5911g.hashCode()) * 31) + this.f5912h.hashCode()) * 31) + Boolean.hashCode(this.f5913i);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("draggable");
        inspectorInfo.b().c("orientation", this.f5907b);
        inspectorInfo.b().c("enabled", Boolean.valueOf(this.f5908c));
        inspectorInfo.b().c("reverseDirection", Boolean.valueOf(this.f5913i));
        inspectorInfo.b().c("interactionSource", this.f5909d);
        inspectorInfo.b().c("startDragImmediately", Boolean.valueOf(this.f5910f));
        inspectorInfo.b().c("onDragStarted", this.f5911g);
        inspectorInfo.b().c("onDragStopped", this.f5912h);
        inspectorInfo.b().c(ServerProtocol.DIALOG_PARAM_STATE, this.f5906a);
    }
}
