package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScopeKt;

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
public final class BringIntoViewResponderNode extends Modifier.Node implements BringIntoViewModifierNode, LayoutAwareModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BringIntoViewResponder f8932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f8933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8934c;

    public BringIntoViewResponderNode(BringIntoViewResponder bringIntoViewResponder) {
        this.f8932a = bringIntoViewResponder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect n2(BringIntoViewResponderNode bringIntoViewResponderNode, LayoutCoordinates layoutCoordinates, Function0 function0) {
        Rect rect;
        if (!bringIntoViewResponderNode.isAttached() || !bringIntoViewResponderNode.f8934c) {
            return null;
        }
        LayoutCoordinates layoutCoordinatesM = DelegatableNodeKt.m(bringIntoViewResponderNode);
        if (!layoutCoordinates.m()) {
            layoutCoordinates = null;
        }
        if (layoutCoordinates == null || (rect = (Rect) function0.invoke()) == null) {
            return null;
        }
        return BringIntoViewRequesterKt__BringIntoViewResponderKt.b(layoutCoordinatesM, layoutCoordinates, rect);
    }

    @Override // androidx.compose.ui.relocation.BringIntoViewModifierNode
    public Object E0(final LayoutCoordinates layoutCoordinates, final Function0 function0, Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new BringIntoViewResponderNode$bringIntoView$2(this, layoutCoordinates, function0, new Function0<Rect>() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringIntoView$parentRect$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Rect invoke() {
                Rect rectN2 = BringIntoViewResponderNode.n2(this.f8951a, layoutCoordinates, function0);
                if (rectN2 != null) {
                    return this.f8951a.o2().w1(rectN2);
                }
                return null;
            }
        }, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.f8933b;
    }

    public final BringIntoViewResponder o2() {
        return this.f8932a;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void p(LayoutCoordinates layoutCoordinates) {
        this.f8934c = true;
    }

    public final void p2(BringIntoViewResponder bringIntoViewResponder) {
        this.f8932a = bringIntoViewResponder;
    }
}
