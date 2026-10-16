package androidx.compose.ui.draganddrop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class DragAndDropNode extends Modifier.Node implements TraversableNode, DragAndDropModifierNode, DragAndDropSourceModifierNode, DragAndDropTargetModifierNode, DragAndDropTarget {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Companion f25343h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25344i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function2 f25345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f25346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f25347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DragAndDropNode f25348d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DragAndDropTarget f25349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f25350g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static final class DragAndDropTraversableKey {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final DragAndDropTraversableKey f25351a = new DragAndDropTraversableKey();

            private DragAndDropTraversableKey() {
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ DragAndDropNode(Function2 function2, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : function2, (i3 & 2) != 0 ? null : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DragAndDropManager t2() {
        return DelegatableNodeKt.p(this).getDragAndDropManager();
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public boolean Q0(DragAndDropEvent dragAndDropEvent) {
        DragAndDropNode dragAndDropNode = this.f25348d;
        if (dragAndDropNode != null) {
            return dragAndDropNode.Q0(dragAndDropEvent);
        }
        DragAndDropTarget dragAndDropTarget = this.f25349f;
        if (dragAndDropTarget != null) {
            return dragAndDropTarget.Q0(dragAndDropEvent);
        }
        return false;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void S(DragAndDropEvent dragAndDropEvent) {
        DragAndDropTarget dragAndDropTarget = this.f25349f;
        if (dragAndDropTarget != null) {
            dragAndDropTarget.S(dragAndDropEvent);
            return;
        }
        DragAndDropNode dragAndDropNode = this.f25348d;
        if (dragAndDropNode != null) {
            dragAndDropNode.S(dragAndDropEvent);
        }
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void T(final DragAndDropEvent dragAndDropEvent) {
        TraversableNode traversableNode;
        DragAndDropNode dragAndDropNode;
        DragAndDropNode dragAndDropNode2 = this.f25348d;
        if (dragAndDropNode2 == null || !DragAndDropNodeKt.g(dragAndDropNode2, DragAndDrop_androidKt.a(dragAndDropEvent))) {
            if (getNode().isAttached()) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                TraversableNodeKt.f(this, new Function1<DragAndDropNode, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$onMoved$$inlined$firstDescendantOrNull$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final TraversableNode.Companion.TraverseDescendantsAction invoke(TraversableNode traversableNode2) {
                        DragAndDropNode dragAndDropNode3 = (DragAndDropNode) traversableNode2;
                        if (!this.t2().z(dragAndDropNode3) || !DragAndDropNodeKt.g(dragAndDropNode3, DragAndDrop_androidKt.a(dragAndDropEvent))) {
                            return TraversableNode.Companion.TraverseDescendantsAction.f27641a;
                        }
                        objectRef.f140144a = traversableNode2;
                        return TraversableNode.Companion.TraverseDescendantsAction.f27643c;
                    }
                });
                traversableNode = (TraversableNode) objectRef.f140144a;
            } else {
                traversableNode = null;
            }
            dragAndDropNode = (DragAndDropNode) traversableNode;
        } else {
            dragAndDropNode = dragAndDropNode2;
        }
        if (dragAndDropNode != null && dragAndDropNode2 == null) {
            DragAndDropNodeKt.h(dragAndDropNode, dragAndDropEvent);
            DragAndDropTarget dragAndDropTarget = this.f25349f;
            if (dragAndDropTarget != null) {
                dragAndDropTarget.d0(dragAndDropEvent);
            }
        } else if (dragAndDropNode == null && dragAndDropNode2 != null) {
            DragAndDropTarget dragAndDropTarget2 = this.f25349f;
            if (dragAndDropTarget2 != null) {
                DragAndDropNodeKt.h(dragAndDropTarget2, dragAndDropEvent);
            }
            dragAndDropNode2.d0(dragAndDropEvent);
        } else if (!Intrinsics.areEqual(dragAndDropNode, dragAndDropNode2)) {
            if (dragAndDropNode != null) {
                DragAndDropNodeKt.h(dragAndDropNode, dragAndDropEvent);
            }
            if (dragAndDropNode2 != null) {
                dragAndDropNode2.d0(dragAndDropEvent);
            }
        } else if (dragAndDropNode != null) {
            dragAndDropNode.T(dragAndDropEvent);
        } else {
            DragAndDropTarget dragAndDropTarget3 = this.f25349f;
            if (dragAndDropTarget3 != null) {
                dragAndDropTarget3.T(dragAndDropEvent);
            }
        }
        this.f25348d = dragAndDropNode;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object U() {
        return this.f25347c;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void d0(DragAndDropEvent dragAndDropEvent) {
        DragAndDropTarget dragAndDropTarget = this.f25349f;
        if (dragAndDropTarget != null) {
            dragAndDropTarget.d0(dragAndDropEvent);
        }
        DragAndDropNode dragAndDropNode = this.f25348d;
        if (dragAndDropNode != null) {
            dragAndDropNode.d0(dragAndDropEvent);
        }
        this.f25348d = null;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void j2(final DragAndDropEvent dragAndDropEvent) {
        DragAndDropNodeKt.i(this, new Function1<DragAndDropNode, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$onEnded$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TraversableNode.Companion.TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                if (!dragAndDropNode.getNode().isAttached()) {
                    return TraversableNode.Companion.TraverseDescendantsAction.f27642b;
                }
                DragAndDropTarget dragAndDropTarget = dragAndDropNode.f25349f;
                if (dragAndDropTarget != null) {
                    dragAndDropTarget.j2(dragAndDropEvent);
                }
                dragAndDropNode.f25349f = null;
                dragAndDropNode.f25348d = null;
                return TraversableNode.Companion.TraverseDescendantsAction.f27641a;
            }
        });
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void m(long j3) {
        this.f25350g = j3;
    }

    public boolean m2(final DragAndDropEvent dragAndDropEvent) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        DragAndDropNodeKt.i(this, new Function1<DragAndDropNode, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$acceptDragAndDropTransfer$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TraversableNode.Companion.TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                if (!dragAndDropNode.isAttached()) {
                    return TraversableNode.Companion.TraverseDescendantsAction.f27642b;
                }
                if (!(dragAndDropNode.f25349f == null)) {
                    InlineClassHelperKt.c("DragAndDropTarget self reference must be null at the start of a drag and drop session");
                }
                Function1 function1 = dragAndDropNode.f25346b;
                dragAndDropNode.f25349f = function1 != null ? (DragAndDropTarget) function1.invoke(dragAndDropEvent) : null;
                boolean z2 = dragAndDropNode.f25349f != null;
                if (z2) {
                    this.t2().A(dragAndDropNode);
                }
                Ref.BooleanRef booleanRef2 = booleanRef;
                booleanRef2.f140137a = booleanRef2.f140137a || z2;
                return TraversableNode.Companion.TraverseDescendantsAction.f27641a;
            }
        });
        return booleanRef.f140137a;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.f25349f = null;
        this.f25348d = null;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropSourceModifierNode
    public void r(long j3) {
        if (!(this.f25345a != null)) {
            InlineClassHelperKt.c("Check failed.");
        }
        t2().y(this, j3);
    }

    public final long u2() {
        return this.f25350g;
    }

    public final void v2(final DragAndDropStartTransferScope dragAndDropStartTransferScope, final long j3, final Function0 function0) {
        final LayoutCoordinates layoutCoordinatesX = DelegatableNodeKt.o(this).x();
        DragAndDropNodeKt.i(this, new Function1<DragAndDropNode, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$startDragAndDropTransfer$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TraversableNode.Companion.TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                if (!dragAndDropNode.isAttached()) {
                    return TraversableNode.Companion.TraverseDescendantsAction.f27642b;
                }
                Function2 function2 = dragAndDropNode.f25345a;
                if (function2 == null) {
                    return TraversableNode.Companion.TraverseDescendantsAction.f27641a;
                }
                long j4 = j3;
                Offset.Companion companion = Offset.f25596b;
                if (Offset.j(j4, companion.b())) {
                    function2.invoke(dragAndDropStartTransferScope, Offset.d(companion.b()));
                } else {
                    long jS = DelegatableNodeKt.o(dragAndDropNode).x().S(layoutCoordinatesX, j3);
                    if (!SizeKt.c(IntSizeKt.e(dragAndDropNode.u2())).f(jS)) {
                        return TraversableNode.Companion.TraverseDescendantsAction.f27641a;
                    }
                    function2.invoke(dragAndDropStartTransferScope, Offset.d(jS));
                }
                return ((Boolean) function0.invoke()).booleanValue() ? TraversableNode.Companion.TraverseDescendantsAction.f27643c : TraversableNode.Companion.TraverseDescendantsAction.f27641a;
            }
        });
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropSourceModifierNode
    public boolean x() {
        return t2().x();
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void x0(DragAndDropEvent dragAndDropEvent) {
        DragAndDropTarget dragAndDropTarget = this.f25349f;
        if (dragAndDropTarget != null) {
            dragAndDropTarget.x0(dragAndDropEvent);
            return;
        }
        DragAndDropNode dragAndDropNode = this.f25348d;
        if (dragAndDropNode != null) {
            dragAndDropNode.x0(dragAndDropEvent);
        }
    }

    public DragAndDropNode(Function2 function2, Function1 function1) {
        this.f25345a = function2;
        this.f25346b = function1;
        this.f25347c = Companion.DragAndDropTraversableKey.f25351a;
        this.f25350g = IntSize.f29998b.a();
    }
}
