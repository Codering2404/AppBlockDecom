package androidx.compose.foundation;

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
final class ClickableElement extends ModifierNodeElement<ClickableNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableInteractionSource f4778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IndicationNodeFactory f4779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f4780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4781d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Role f4782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function0 f4783g;

    public /* synthetic */ ClickableElement(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, indicationNodeFactory, z2, str, role, function0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ClickableNode create() {
        return new ClickableNode(this.f4778a, this.f4779b, this.f4780c, this.f4781d, this.f4782f, this.f4783g, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(ClickableNode clickableNode) {
        clickableNode.R2(this.f4778a, this.f4779b, this.f4780c, this.f4781d, this.f4782f, this.f4783g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ClickableElement.class != obj.getClass()) {
            return false;
        }
        ClickableElement clickableElement = (ClickableElement) obj;
        return Intrinsics.areEqual(this.f4778a, clickableElement.f4778a) && Intrinsics.areEqual(this.f4779b, clickableElement.f4779b) && this.f4780c == clickableElement.f4780c && Intrinsics.areEqual(this.f4781d, clickableElement.f4781d) && Intrinsics.areEqual(this.f4782f, clickableElement.f4782f) && this.f4783g == clickableElement.f4783g;
    }

    public int hashCode() {
        MutableInteractionSource mutableInteractionSource = this.f4778a;
        int iHashCode = (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0) * 31;
        IndicationNodeFactory indicationNodeFactory = this.f4779b;
        int iHashCode2 = (((iHashCode + (indicationNodeFactory != null ? indicationNodeFactory.hashCode() : 0)) * 31) + Boolean.hashCode(this.f4780c)) * 31;
        String str = this.f4781d;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Role role = this.f4782f;
        return ((iHashCode3 + (role != null ? Role.n(role.p()) : 0)) * 31) + this.f4783g.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("clickable");
        inspectorInfo.b().c("enabled", Boolean.valueOf(this.f4780c));
        inspectorInfo.b().c("onClick", this.f4783g);
        inspectorInfo.b().c("onClickLabel", this.f4781d);
        inspectorInfo.b().c("role", this.f4782f);
        inspectorInfo.b().c("interactionSource", this.f4778a);
        inspectorInfo.b().c("indicationNodeFactory", this.f4779b);
    }

    private ClickableElement(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, String str, Role role, Function0 function0) {
        this.f4778a = mutableInteractionSource;
        this.f4779b = indicationNodeFactory;
        this.f4780c = z2;
        this.f4781d = str;
        this.f4782f = role;
        this.f4783g = function0;
    }
}
