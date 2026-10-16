package androidx.compose.foundation.selection;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class TriStateToggleableElement extends ModifierNodeElement<TriStateToggleableNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ToggleableState f9013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableInteractionSource f9014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IndicationNodeFactory f9015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f9016d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Role f9017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function0 f9018g;

    public /* synthetic */ TriStateToggleableElement(ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(toggleableState, mutableInteractionSource, indicationNodeFactory, z2, role, function0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TriStateToggleableNode create() {
        return new TriStateToggleableNode(this.f9013a, this.f9014b, this.f9015c, this.f9016d, this.f9017f, this.f9018g, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(TriStateToggleableNode triStateToggleableNode) {
        triStateToggleableNode.S2(this.f9013a, this.f9014b, this.f9015c, this.f9016d, this.f9017f, this.f9018g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TriStateToggleableElement.class != obj.getClass()) {
            return false;
        }
        TriStateToggleableElement triStateToggleableElement = (TriStateToggleableElement) obj;
        return this.f9013a == triStateToggleableElement.f9013a && Intrinsics.areEqual(this.f9014b, triStateToggleableElement.f9014b) && Intrinsics.areEqual(this.f9015c, triStateToggleableElement.f9015c) && this.f9016d == triStateToggleableElement.f9016d && Intrinsics.areEqual(this.f9017f, triStateToggleableElement.f9017f) && this.f9018g == triStateToggleableElement.f9018g;
    }

    public int hashCode() {
        int iHashCode = this.f9013a.hashCode() * 31;
        MutableInteractionSource mutableInteractionSource = this.f9014b;
        int iHashCode2 = (iHashCode + (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0)) * 31;
        IndicationNodeFactory indicationNodeFactory = this.f9015c;
        int iHashCode3 = (((iHashCode2 + (indicationNodeFactory != null ? indicationNodeFactory.hashCode() : 0)) * 31) + Boolean.hashCode(this.f9016d)) * 31;
        Role role = this.f9017f;
        return ((iHashCode3 + (role != null ? Role.n(role.p()) : 0)) * 31) + this.f9018g.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("triStateToggleable");
        inspectorInfo.b().c(ServerProtocol.DIALOG_PARAM_STATE, this.f9013a);
        inspectorInfo.b().c("interactionSource", this.f9014b);
        inspectorInfo.b().c("indicationNodeFactory", this.f9015c);
        inspectorInfo.b().c("enabled", Boolean.valueOf(this.f9016d));
        inspectorInfo.b().c("role", this.f9017f);
        inspectorInfo.b().c("onClick", this.f9018g);
    }

    private TriStateToggleableElement(ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, Role role, Function0 function0) {
        this.f9013a = toggleableState;
        this.f9014b = mutableInteractionSource;
        this.f9015c = indicationNodeFactory;
        this.f9016d = z2;
        this.f9017f = role;
        this.f9018g = function0;
    }
}
