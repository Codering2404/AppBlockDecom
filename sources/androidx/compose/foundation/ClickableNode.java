package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class ClickableNode extends AbstractClickableNode {
    public /* synthetic */ ClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, indicationNodeFactory, z2, str, role, function0);
    }

    static /* synthetic */ Object Q2(final ClickableNode clickableNode, PointerInputScope pointerInputScope, Continuation continuation) {
        Object objK = TapGestureDetectorKt.k(pointerInputScope, new ClickableNode$clickPointerInput$2(clickableNode, null), new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.ClickableNode$clickPointerInput$3
            {
                super(1);
            }

            public final void c(long j3) {
                if (this.f4851a.F2()) {
                    this.f4851a.G2().invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((Offset) obj).u());
                return Unit.f139807a;
            }
        }, continuation);
        return objK == IntrinsicsKt.f() ? objK : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public Object A2(PointerInputScope pointerInputScope, Continuation continuation) {
        return Q2(this, pointerInputScope, continuation);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    protected final boolean K2(KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    protected final boolean L2(KeyEvent keyEvent) {
        G2().invoke();
        return true;
    }

    public final void R2(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, String str, Role role, Function0 function0) {
        P2(mutableInteractionSource, indicationNodeFactory, z2, str, role, function0);
    }

    private ClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, String str, Role role, Function0 function0) {
        super(mutableInteractionSource, indicationNodeFactory, z2, str, role, function0, null);
    }
}
