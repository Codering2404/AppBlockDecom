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
final class CombinedClickableElement extends ModifierNodeElement<CombinedClickableNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableInteractionSource f4854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IndicationNodeFactory f4855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f4856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4857d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Role f4858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function0 f4859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f4860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Function0 f4861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Function0 f4862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f4863k;

    public /* synthetic */ CombinedClickableElement(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, String str, Role role, Function0 function0, String str2, Function0 function02, Function0 function03, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, indicationNodeFactory, z2, str, role, function0, str2, function02, function03, z3);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CombinedClickableNode create() {
        return new CombinedClickableNode(this.f4859g, this.f4860h, this.f4861i, this.f4862j, this.f4863k, this.f4854a, this.f4855b, this.f4856c, this.f4857d, this.f4858f, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(CombinedClickableNode combinedClickableNode) {
        combinedClickableNode.V2(this.f4863k);
        combinedClickableNode.W2(this.f4859g, this.f4860h, this.f4861i, this.f4862j, this.f4854a, this.f4855b, this.f4856c, this.f4857d, this.f4858f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CombinedClickableElement.class != obj.getClass()) {
            return false;
        }
        CombinedClickableElement combinedClickableElement = (CombinedClickableElement) obj;
        return Intrinsics.areEqual(this.f4854a, combinedClickableElement.f4854a) && Intrinsics.areEqual(this.f4855b, combinedClickableElement.f4855b) && this.f4856c == combinedClickableElement.f4856c && Intrinsics.areEqual(this.f4857d, combinedClickableElement.f4857d) && Intrinsics.areEqual(this.f4858f, combinedClickableElement.f4858f) && this.f4859g == combinedClickableElement.f4859g && Intrinsics.areEqual(this.f4860h, combinedClickableElement.f4860h) && this.f4861i == combinedClickableElement.f4861i && this.f4862j == combinedClickableElement.f4862j && this.f4863k == combinedClickableElement.f4863k;
    }

    public int hashCode() {
        MutableInteractionSource mutableInteractionSource = this.f4854a;
        int iHashCode = (mutableInteractionSource != null ? mutableInteractionSource.hashCode() : 0) * 31;
        IndicationNodeFactory indicationNodeFactory = this.f4855b;
        int iHashCode2 = (((iHashCode + (indicationNodeFactory != null ? indicationNodeFactory.hashCode() : 0)) * 31) + Boolean.hashCode(this.f4856c)) * 31;
        String str = this.f4857d;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Role role = this.f4858f;
        int iN = (((iHashCode3 + (role != null ? Role.n(role.p()) : 0)) * 31) + this.f4859g.hashCode()) * 31;
        String str2 = this.f4860h;
        int iHashCode4 = (iN + (str2 != null ? str2.hashCode() : 0)) * 31;
        Function0 function0 = this.f4861i;
        int iHashCode5 = (iHashCode4 + (function0 != null ? function0.hashCode() : 0)) * 31;
        Function0 function02 = this.f4862j;
        return ((iHashCode5 + (function02 != null ? function02.hashCode() : 0)) * 31) + Boolean.hashCode(this.f4863k);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("combinedClickable");
        inspectorInfo.b().c("indicationNodeFactory", this.f4855b);
        inspectorInfo.b().c("interactionSource", this.f4854a);
        inspectorInfo.b().c("enabled", Boolean.valueOf(this.f4856c));
        inspectorInfo.b().c("onClickLabel", this.f4857d);
        inspectorInfo.b().c("role", this.f4858f);
        inspectorInfo.b().c("onClick", this.f4859g);
        inspectorInfo.b().c("onDoubleClick", this.f4862j);
        inspectorInfo.b().c("onLongClick", this.f4861i);
        inspectorInfo.b().c("onLongClickLabel", this.f4860h);
        inspectorInfo.b().c("hapticFeedbackEnabled", Boolean.valueOf(this.f4863k));
    }

    private CombinedClickableElement(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, String str, Role role, Function0 function0, String str2, Function0 function02, Function0 function03, boolean z3) {
        this.f4854a = mutableInteractionSource;
        this.f4855b = indicationNodeFactory;
        this.f4856c = z2;
        this.f4857d = str;
        this.f4858f = role;
        this.f4859g = function0;
        this.f4860h = str2;
        this.f4861i = function02;
        this.f4862j = function03;
        this.f4863k = z3;
    }
}
