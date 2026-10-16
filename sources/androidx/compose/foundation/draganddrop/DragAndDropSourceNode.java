package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropSourceModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropStartTransferScope;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class DragAndDropSourceNode extends DelegatingNode implements LayoutAwareModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function1 f5333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function2 f5334d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function1 f5335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f5336g = IntSize.f29998b.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final DragAndDropSourceModifierNode f5337h = (DragAndDropSourceModifierNode) m2(DragAndDropNodeKt.b(new Function2<DragAndDropStartTransferScope, Offset, Unit>() { // from class: androidx.compose.foundation.draganddrop.DragAndDropSourceNode$dragAndDropModifierNode$1
        {
            super(2);
        }

        public final void c(DragAndDropStartTransferScope dragAndDropStartTransferScope, long j3) {
            DragAndDropTransferData dragAndDropTransferData = (DragAndDropTransferData) this.f5339a.w2().invoke(Offset.d(j3));
            if (dragAndDropTransferData != null) {
                dragAndDropStartTransferScope.a(dragAndDropTransferData, IntSizeKt.e(this.f5339a.f5336g), this.f5339a.v2());
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((DragAndDropStartTransferScope) obj, ((Offset) obj2).u());
            return Unit.f139807a;
        }
    }));

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PointerInputModifierNode f5338i;

    public DragAndDropSourceNode(Function1 function1, Function2 function2, Function1 function12) {
        this.f5333c = function1;
        this.f5334d = function2;
        this.f5335f = function12;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void m(long j3) {
        this.f5336g = j3;
        this.f5337h.m(j3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        if (this.f5337h.x()) {
            this.f5338i = (PointerInputModifierNode) m2(SuspendingPointerInputFilterKt.a(new PointerInputEventHandler() { // from class: androidx.compose.foundation.draganddrop.DragAndDropSourceNode.onAttach.1

                /* JADX INFO: renamed from: androidx.compose.foundation.draganddrop.DragAndDropSourceNode$onAttach$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class C00101 implements DragAndDropStartDetectorScope, PointerInputScope {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    private final /* synthetic */ PointerInputScope f5341a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ DragAndDropSourceNode f5342b;

                    C00101(PointerInputScope pointerInputScope, DragAndDropSourceNode dragAndDropSourceNode) {
                        this.f5342b = dragAndDropSourceNode;
                        this.f5341a = pointerInputScope;
                    }

                    @Override // androidx.compose.ui.unit.Density
                    public float F(int i3) {
                        return this.f5341a.F(i3);
                    }

                    @Override // androidx.compose.ui.unit.Density
                    public float G(float f3) {
                        return this.f5341a.G(f3);
                    }

                    @Override // androidx.compose.ui.unit.Density
                    public float J0(long j3) {
                        return this.f5341a.J0(j3);
                    }

                    @Override // androidx.compose.ui.unit.FontScaling
                    public float K1() {
                        return this.f5341a.K1();
                    }

                    @Override // androidx.compose.ui.unit.Density
                    public long M(long j3) {
                        return this.f5341a.M(j3);
                    }

                    @Override // androidx.compose.ui.input.pointer.PointerInputScope
                    public void M0(boolean z2) {
                        this.f5341a.M0(z2);
                    }

                    @Override // androidx.compose.ui.unit.Density
                    public float M1(float f3) {
                        return this.f5341a.M1(f3);
                    }

                    @Override // androidx.compose.ui.unit.Density
                    public int T1(long j3) {
                        return this.f5341a.T1(j3);
                    }

                    @Override // androidx.compose.ui.input.pointer.PointerInputScope
                    public Object c0(Function2 function2, Continuation continuation) {
                        return this.f5341a.c0(function2, continuation);
                    }

                    @Override // androidx.compose.ui.unit.Density
                    public float getDensity() {
                        return this.f5341a.getDensity();
                    }

                    @Override // androidx.compose.ui.input.pointer.PointerInputScope
                    public ViewConfiguration getViewConfiguration() {
                        return this.f5341a.getViewConfiguration();
                    }

                    @Override // androidx.compose.ui.unit.FontScaling
                    public long n(float f3) {
                        return this.f5341a.n(f3);
                    }

                    @Override // androidx.compose.ui.unit.Density
                    public long o(long j3) {
                        return this.f5341a.o(j3);
                    }

                    @Override // androidx.compose.ui.unit.FontScaling
                    public float q(long j3) {
                        return this.f5341a.q(j3);
                    }

                    @Override // androidx.compose.foundation.draganddrop.DragAndDropStartDetectorScope
                    public void r(long j3) {
                        this.f5342b.f5337h.r(j3);
                    }

                    @Override // androidx.compose.ui.unit.Density
                    public long v(float f3) {
                        return this.f5341a.v(f3);
                    }

                    @Override // androidx.compose.ui.unit.Density
                    public int z0(float f3) {
                        return this.f5341a.z0(f3);
                    }
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                    Object objInvoke = DragAndDropSourceNode.this.u2().invoke(new C00101(pointerInputScope, DragAndDropSourceNode.this), continuation);
                    return objInvoke == IntrinsicsKt.f() ? objInvoke : Unit.f139807a;
                }
            }));
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        PointerInputModifierNode pointerInputModifierNode = this.f5338i;
        if (pointerInputModifierNode != null) {
            p2(pointerInputModifierNode);
        }
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void p(LayoutCoordinates layoutCoordinates) {
        this.f5337h.p(layoutCoordinates);
    }

    public final Function2 u2() {
        return this.f5334d;
    }

    public final Function1 v2() {
        return this.f5333c;
    }

    public final Function1 w2() {
        return this.f5335f;
    }

    public final void x2(Function2 function2) {
        this.f5334d = function2;
    }

    public final void y2(Function1 function1) {
        this.f5333c = function1;
    }

    public final void z2(Function1 function1) {
        this.f5335f = function1;
    }
}
