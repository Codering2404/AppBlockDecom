package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.AlignmentLineProvider;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class SiblingsAlignedNode extends Modifier.Node implements ParentDataModifierNode {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WithAlignmentLineBlockNode extends SiblingsAlignedNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Function1 f7102a;

        public WithAlignmentLineBlockNode(Function1 function1) {
            super(null);
            this.f7102a = function1;
        }

        @Override // androidx.compose.ui.node.ParentDataModifierNode
        public Object H(Density density, Object obj) {
            RowColumnParentData rowColumnParentData = obj instanceof RowColumnParentData ? (RowColumnParentData) obj : null;
            if (rowColumnParentData == null) {
                rowColumnParentData = new RowColumnParentData(0.0f, false, null, null, 15, null);
            }
            rowColumnParentData.e(CrossAxisAlignment.f6736a.a(new AlignmentLineProvider.Block(this.f7102a)));
            return rowColumnParentData;
        }

        public final void m2(Function1 function1) {
            this.f7102a = function1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WithAlignmentLineNode extends SiblingsAlignedNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AlignmentLine f7103a;

        public WithAlignmentLineNode(AlignmentLine alignmentLine) {
            super(null);
            this.f7103a = alignmentLine;
        }

        @Override // androidx.compose.ui.node.ParentDataModifierNode
        public Object H(Density density, Object obj) {
            RowColumnParentData rowColumnParentData = obj instanceof RowColumnParentData ? (RowColumnParentData) obj : null;
            if (rowColumnParentData == null) {
                rowColumnParentData = new RowColumnParentData(0.0f, false, null, null, 15, null);
            }
            rowColumnParentData.e(CrossAxisAlignment.f6736a.a(new AlignmentLineProvider.Value(this.f7103a)));
            return rowColumnParentData;
        }

        public final void m2(AlignmentLine alignmentLine) {
            this.f7103a = alignmentLine;
        }
    }

    public /* synthetic */ SiblingsAlignedNode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SiblingsAlignedNode() {
    }
}
