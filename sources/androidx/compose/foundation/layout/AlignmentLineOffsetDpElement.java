package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
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
final class AlignmentLineOffsetDpElement extends ModifierNodeElement<AlignmentLineOffsetDpNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AlignmentLine f6550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f6551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f6552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f6553d;

    public /* synthetic */ AlignmentLineOffsetDpElement(AlignmentLine alignmentLine, float f3, float f4, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLine, f3, f4, function1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AlignmentLineOffsetDpNode create() {
        return new AlignmentLineOffsetDpNode(this.f6550a, this.f6551b, this.f6552c, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(AlignmentLineOffsetDpNode alignmentLineOffsetDpNode) {
        alignmentLineOffsetDpNode.n2(this.f6550a);
        alignmentLineOffsetDpNode.o2(this.f6551b);
        alignmentLineOffsetDpNode.m2(this.f6552c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        AlignmentLineOffsetDpElement alignmentLineOffsetDpElement = obj instanceof AlignmentLineOffsetDpElement ? (AlignmentLineOffsetDpElement) obj : null;
        return alignmentLineOffsetDpElement != null && Intrinsics.areEqual(this.f6550a, alignmentLineOffsetDpElement.f6550a) && Dp.i(this.f6551b, alignmentLineOffsetDpElement.f6551b) && Dp.i(this.f6552c, alignmentLineOffsetDpElement.f6552c);
    }

    public int hashCode() {
        return (((this.f6550a.hashCode() * 31) + Dp.j(this.f6551b)) * 31) + Dp.j(this.f6552c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.f6553d.invoke(inspectorInfo);
    }

    private AlignmentLineOffsetDpElement(AlignmentLine alignmentLine, float f3, float f4, Function1 function1) {
        this.f6550a = alignmentLine;
        this.f6551b = f3;
        this.f6552c = f4;
        this.f6553d = function1;
        boolean z2 = true;
        boolean z3 = f3 >= 0.0f || Float.isNaN(f3);
        if (f4 < 0.0f && !Float.isNaN(f4)) {
            z2 = false;
        }
        if (!z3 || !z2) {
            InlineClassHelperKt.a("Padding from alignment line must be a non-negative number");
        }
    }
}
