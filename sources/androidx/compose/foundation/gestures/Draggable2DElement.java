package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class Draggable2DElement extends ModifierNodeElement<Draggable2DNode> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f5878i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Function1 f5879j = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.Draggable2DElement$Companion$CanDrag$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return Boolean.TRUE;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Draggable2DState f5880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableInteractionSource f5882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f5883d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function1 f5884f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function1 f5885g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f5886h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Draggable2DNode create() {
        return new Draggable2DNode(this.f5880a, f5879j, this.f5881b, this.f5882c, this.f5883d, this.f5886h, this.f5884f, this.f5885g);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(Draggable2DNode draggable2DNode) {
        draggable2DNode.P2(this.f5880a, f5879j, this.f5881b, this.f5882c, this.f5883d, this.f5886h, this.f5884f, this.f5885g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Draggable2DElement.class != obj.getClass()) {
            return false;
        }
        Draggable2DElement draggable2DElement = (Draggable2DElement) obj;
        return Intrinsics.areEqual(this.f5880a, draggable2DElement.f5880a) && this.f5881b == draggable2DElement.f5881b && Intrinsics.areEqual(this.f5882c, draggable2DElement.f5882c) && this.f5883d == draggable2DElement.f5883d && this.f5884f == draggable2DElement.f5884f && this.f5885g == draggable2DElement.f5885g && this.f5886h == draggable2DElement.f5886h;
    }

    public int hashCode() {
        int iHashCode = ((this.f5880a.hashCode() * 31) + Boolean.hashCode(this.f5881b)) * 31;
        MutableInteractionSource mutableInteractionSource = this.f5882c;
        return ((((((((iHashCode + (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0)) * 31) + Boolean.hashCode(this.f5883d)) * 31) + this.f5884f.hashCode()) * 31) + this.f5885g.hashCode()) * 31) + Boolean.hashCode(this.f5886h);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("draggable2D");
        inspectorInfo.b().c("enabled", Boolean.valueOf(this.f5881b));
        inspectorInfo.b().c("interactionSource", this.f5882c);
        inspectorInfo.b().c("startDragImmediately", Boolean.valueOf(this.f5883d));
        inspectorInfo.b().c("onDragStarted", this.f5884f);
        inspectorInfo.b().c("onDragStopped", this.f5885g);
        inspectorInfo.b().c("reverseDirection", Boolean.valueOf(this.f5886h));
        inspectorInfo.b().c(ServerProtocol.DIALOG_PARAM_STATE, this.f5880a);
    }
}
