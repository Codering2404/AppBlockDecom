package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class SelectableNode extends ClickableNode {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f8974w;

    public /* synthetic */ SelectableNode(boolean z2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z3, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, mutableInteractionSource, indicationNodeFactory, z3, role, function0);
    }

    public final void S2(boolean z2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z3, Role role, Function0 function0) {
        if (this.f8974w != z2) {
            this.f8974w = z2;
            SemanticsModifierNodeKt.b(this);
        }
        super.R2(mutableInteractionSource, indicationNodeFactory, z3, null, role, function0);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void z2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.s0(semanticsPropertyReceiver, this.f8974w);
    }

    private SelectableNode(boolean z2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z3, Role role, Function0 function0) {
        super(mutableInteractionSource, indicationNodeFactory, z3, null, role, function0, null);
        this.f8974w = z2;
    }
}
