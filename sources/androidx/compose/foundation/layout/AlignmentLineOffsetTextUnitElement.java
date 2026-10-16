package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
final class AlignmentLineOffsetTextUnitElement extends ModifierNodeElement<AlignmentLineOffsetTextUnitNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AlignmentLine f6557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f6558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f6559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f6560d;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AlignmentLineOffsetTextUnitNode create() {
        return new AlignmentLineOffsetTextUnitNode(this.f6557a, this.f6558b, this.f6559c, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(AlignmentLineOffsetTextUnitNode alignmentLineOffsetTextUnitNode) {
        alignmentLineOffsetTextUnitNode.n2(this.f6557a);
        alignmentLineOffsetTextUnitNode.o2(this.f6558b);
        alignmentLineOffsetTextUnitNode.m2(this.f6559c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        AlignmentLineOffsetTextUnitElement alignmentLineOffsetTextUnitElement = obj instanceof AlignmentLineOffsetTextUnitElement ? (AlignmentLineOffsetTextUnitElement) obj : null;
        return alignmentLineOffsetTextUnitElement != null && Intrinsics.areEqual(this.f6557a, alignmentLineOffsetTextUnitElement.f6557a) && TextUnit.e(this.f6558b, alignmentLineOffsetTextUnitElement.f6558b) && TextUnit.e(this.f6559c, alignmentLineOffsetTextUnitElement.f6559c);
    }

    public int hashCode() {
        return (((this.f6557a.hashCode() * 31) + TextUnit.i(this.f6558b)) * 31) + TextUnit.i(this.f6559c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.f6560d.invoke(inspectorInfo);
    }
}
