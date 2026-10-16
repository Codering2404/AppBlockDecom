package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.IntSize;
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
public final class LegacyDragAndDropSourceNode extends DelegatingNode implements LayoutAwareModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function1 f5356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function2 f5357d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f5358f = IntSize.f29998b.a();

    public LegacyDragAndDropSourceNode(Function1 function1, Function2 function2) {
        this.f5356c = function1;
        this.f5357d = function2;
        final DragAndDropModifierNode dragAndDropModifierNode = (DragAndDropModifierNode) m2(DragAndDropNodeKt.a());
        m2(SuspendingPointerInputFilterKt.a(new PointerInputEventHandler() { // from class: androidx.compose.foundation.draganddrop.LegacyDragAndDropSourceNode.1

            /* JADX INFO: renamed from: androidx.compose.foundation.draganddrop.LegacyDragAndDropSourceNode$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class C00111 implements DragAndDropSourceScope, PointerInputScope {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final /* synthetic */ PointerInputScope f5361a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ DragAndDropModifierNode f5362b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ LegacyDragAndDropSourceNode f5363c;

                C00111(PointerInputScope pointerInputScope, DragAndDropModifierNode dragAndDropModifierNode, LegacyDragAndDropSourceNode legacyDragAndDropSourceNode) {
                    this.f5362b = dragAndDropModifierNode;
                    this.f5363c = legacyDragAndDropSourceNode;
                    this.f5361a = pointerInputScope;
                }

                @Override // androidx.compose.ui.unit.Density
                public float F(int i3) {
                    return this.f5361a.F(i3);
                }

                @Override // androidx.compose.ui.unit.Density
                public float G(float f3) {
                    return this.f5361a.G(f3);
                }

                @Override // androidx.compose.ui.unit.Density
                public float J0(long j3) {
                    return this.f5361a.J0(j3);
                }

                @Override // androidx.compose.ui.unit.FontScaling
                public float K1() {
                    return this.f5361a.K1();
                }

                @Override // androidx.compose.ui.unit.Density
                public long M(long j3) {
                    return this.f5361a.M(j3);
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputScope
                public void M0(boolean z2) {
                    this.f5361a.M0(z2);
                }

                @Override // androidx.compose.ui.unit.Density
                public float M1(float f3) {
                    return this.f5361a.M1(f3);
                }

                @Override // androidx.compose.ui.unit.Density
                public int T1(long j3) {
                    return this.f5361a.T1(j3);
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputScope
                public Object c0(Function2 function2, Continuation continuation) {
                    return this.f5361a.c0(function2, continuation);
                }

                @Override // androidx.compose.ui.unit.Density
                public float getDensity() {
                    return this.f5361a.getDensity();
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputScope
                public ViewConfiguration getViewConfiguration() {
                    return this.f5361a.getViewConfiguration();
                }

                @Override // androidx.compose.ui.unit.FontScaling
                public long n(float f3) {
                    return this.f5361a.n(f3);
                }

                @Override // androidx.compose.ui.unit.Density
                public long o(long j3) {
                    return this.f5361a.o(j3);
                }

                @Override // androidx.compose.ui.unit.FontScaling
                public float q(long j3) {
                    return this.f5361a.q(j3);
                }

                @Override // androidx.compose.ui.unit.Density
                public long v(float f3) {
                    return this.f5361a.v(f3);
                }

                @Override // androidx.compose.ui.unit.Density
                public int z0(float f3) {
                    return this.f5361a.z0(f3);
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                Object objInvoke = LegacyDragAndDropSourceNode.this.s2().invoke(new C00111(pointerInputScope, dragAndDropModifierNode, LegacyDragAndDropSourceNode.this), continuation);
                return objInvoke == IntrinsicsKt.f() ? objInvoke : Unit.f139807a;
            }
        }));
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void m(long j3) {
        this.f5358f = j3;
    }

    public final Function2 s2() {
        return this.f5357d;
    }

    public final void t2(Function2 function2) {
        this.f5357d = function2;
    }

    public final void u2(Function1 function1) {
        this.f5356c = function1;
    }
}
