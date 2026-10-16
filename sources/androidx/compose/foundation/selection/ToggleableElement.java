package androidx.compose.foundation.selection;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class ToggleableElement extends ModifierNodeElement<ToggleableNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f8975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableInteractionSource f8976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IndicationNodeFactory f8977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f8978d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Role f8979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function1 f8980g;

    public /* synthetic */ ToggleableElement(boolean z2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z3, Role role, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, mutableInteractionSource, indicationNodeFactory, z3, role, function1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ToggleableNode create() {
        return new ToggleableNode(this.f8975a, this.f8976b, this.f8977c, this.f8978d, this.f8979f, this.f8980g, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(ToggleableNode toggleableNode) {
        toggleableNode.U2(this.f8975a, this.f8976b, this.f8977c, this.f8978d, this.f8979f, this.f8980g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ToggleableElement.class != obj.getClass()) {
            return false;
        }
        ToggleableElement toggleableElement = (ToggleableElement) obj;
        return this.f8975a == toggleableElement.f8975a && Intrinsics.areEqual(this.f8976b, toggleableElement.f8976b) && Intrinsics.areEqual(this.f8977c, toggleableElement.f8977c) && this.f8978d == toggleableElement.f8978d && Intrinsics.areEqual(this.f8979f, toggleableElement.f8979f) && this.f8980g == toggleableElement.f8980g;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.f8975a) * 31;
        MutableInteractionSource mutableInteractionSource = this.f8976b;
        int iHashCode2 = (iHashCode + (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0)) * 31;
        IndicationNodeFactory indicationNodeFactory = this.f8977c;
        int iHashCode3 = (((iHashCode2 + (indicationNodeFactory != null ? indicationNodeFactory.hashCode() : 0)) * 31) + Boolean.hashCode(this.f8978d)) * 31;
        Role role = this.f8979f;
        return ((iHashCode3 + (role != null ? Role.n(role.p()) : 0)) * 31) + this.f8980g.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("toggleable");
        inspectorInfo.b().c("value", inspectorInfo.c());
        inspectorInfo.b().c("interactionSource", this.f8976b);
        inspectorInfo.b().c("indicationNodeFactory", this.f8977c);
        inspectorInfo.b().c("enabled", Boolean.valueOf(this.f8978d));
        inspectorInfo.b().c("role", this.f8979f);
        inspectorInfo.b().c("onValueChange", this.f8980g);
    }

    private ToggleableElement(boolean z2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z3, Role role, Function1 function1) {
        this.f8975a = z2;
        this.f8976b = mutableInteractionSource;
        this.f8977c = indicationNodeFactory;
        this.f8978d = z3;
        this.f8979f = role;
        this.f8980g = function1;
    }
}
