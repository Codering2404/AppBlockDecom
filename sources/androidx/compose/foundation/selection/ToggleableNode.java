package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
final class ToggleableNode extends ClickableNode {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f9007w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Function1 f9008x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Function0 f9009y;

    public /* synthetic */ ToggleableNode(boolean z2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z3, Role role, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, mutableInteractionSource, indicationNodeFactory, z3, role, function1);
    }

    public final void U2(boolean z2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z3, Role role, Function1 function1) {
        if (this.f9007w != z2) {
            this.f9007w = z2;
            SemanticsModifierNodeKt.b(this);
        }
        this.f9008x = function1;
        super.R2(mutableInteractionSource, indicationNodeFactory, z3, null, role, this.f9009y);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void z2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.F0(semanticsPropertyReceiver, ToggleableStateKt.a(this.f9007w));
    }

    private ToggleableNode(final boolean z2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z3, Role role, final Function1 function1) {
        super(mutableInteractionSource, indicationNodeFactory, z3, null, role, new Function0<Unit>() { // from class: androidx.compose.foundation.selection.ToggleableNode.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m51invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m51invoke() {
                function1.invoke(Boolean.valueOf(!z2));
            }
        }, null);
        this.f9007w = z2;
        this.f9008x = function1;
        this.f9009y = new Function0<Unit>() { // from class: androidx.compose.foundation.selection.ToggleableNode$_onClick$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m52invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m52invoke() {
                this.f9012a.f9008x.invoke(Boolean.valueOf(!this.f9012a.f9007w));
            }
        };
    }
}
