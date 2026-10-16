package androidx.compose.foundation.selection;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
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
final class SelectableElement extends ModifierNodeElement<SelectableNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f8954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableInteractionSource f8955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IndicationNodeFactory f8956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f8957d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Role f8958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function0 f8959g;

    public /* synthetic */ SelectableElement(boolean z2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z3, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, mutableInteractionSource, indicationNodeFactory, z3, role, function0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SelectableNode create() {
        return new SelectableNode(this.f8954a, this.f8955b, this.f8956c, this.f8957d, this.f8958f, this.f8959g, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(SelectableNode selectableNode) {
        selectableNode.S2(this.f8954a, this.f8955b, this.f8956c, this.f8957d, this.f8958f, this.f8959g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SelectableElement.class != obj.getClass()) {
            return false;
        }
        SelectableElement selectableElement = (SelectableElement) obj;
        return this.f8954a == selectableElement.f8954a && Intrinsics.areEqual(this.f8955b, selectableElement.f8955b) && Intrinsics.areEqual(this.f8956c, selectableElement.f8956c) && this.f8957d == selectableElement.f8957d && Intrinsics.areEqual(this.f8958f, selectableElement.f8958f) && this.f8959g == selectableElement.f8959g;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.f8954a) * 31;
        MutableInteractionSource mutableInteractionSource = this.f8955b;
        int iHashCode2 = (iHashCode + (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0)) * 31;
        IndicationNodeFactory indicationNodeFactory = this.f8956c;
        int iHashCode3 = (((iHashCode2 + (indicationNodeFactory != null ? indicationNodeFactory.hashCode() : 0)) * 31) + Boolean.hashCode(this.f8957d)) * 31;
        Role role = this.f8958f;
        return ((iHashCode3 + (role != null ? Role.n(role.p()) : 0)) * 31) + this.f8959g.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("selectable");
        inspectorInfo.b().c("selected", Boolean.valueOf(this.f8954a));
        inspectorInfo.b().c("interactionSource", this.f8955b);
        inspectorInfo.b().c("indicationNodeFactory", this.f8956c);
        inspectorInfo.b().c("enabled", Boolean.valueOf(this.f8957d));
        inspectorInfo.b().c("role", this.f8958f);
        inspectorInfo.b().c("onClick", this.f8959g);
    }

    private SelectableElement(boolean z2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z3, Role role, Function0 function0) {
        this.f8954a = z2;
        this.f8955b = mutableInteractionSource;
        this.f8956c = indicationNodeFactory;
        this.f8957d = z3;
        this.f8958f = role;
        this.f8959g = function0;
    }
}
