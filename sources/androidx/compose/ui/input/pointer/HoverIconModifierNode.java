package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.TouchBoundsExpansion;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class HoverIconModifierNode extends Modifier.Node implements TraversableNode, PointerInputModifierNode, CompositionLocalConsumerModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DpTouchBoundsExpansion f26796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PointerIcon f26797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f26798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f26799d;

    public /* synthetic */ HoverIconModifierNode(PointerIcon pointerIcon, boolean z2, DpTouchBoundsExpansion dpTouchBoundsExpansion, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(pointerIcon, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? null : dpTouchBoundsExpansion);
    }

    private final void n2() {
        PointerIcon pointerIcon;
        HoverIconModifierNode hoverIconModifierNodeT2 = t2();
        if (hoverIconModifierNodeT2 == null || (pointerIcon = hoverIconModifierNodeT2.f26797b) == null) {
            pointerIcon = this.f26797b;
        }
        o2(pointerIcon);
    }

    private final void p2() {
        Unit unit;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TraversableNodeKt.d(this, new Function1<HoverIconModifierNode, Boolean>() { // from class: androidx.compose.ui.input.pointer.HoverIconModifierNode$displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(HoverIconModifierNode hoverIconModifierNode) {
                if (objectRef.f140144a == null && hoverIconModifierNode.f26799d) {
                    objectRef.f140144a = hoverIconModifierNode;
                } else if (objectRef.f140144a != null && hoverIconModifierNode.u2() && hoverIconModifierNode.f26799d) {
                    objectRef.f140144a = hoverIconModifierNode;
                }
                return Boolean.TRUE;
            }
        });
        HoverIconModifierNode hoverIconModifierNode = (HoverIconModifierNode) objectRef.f140144a;
        if (hoverIconModifierNode != null) {
            hoverIconModifierNode.n2();
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            o2(null);
        }
    }

    private final void q2() {
        HoverIconModifierNode hoverIconModifierNodeS2;
        if (this.f26799d) {
            if (this.f26798c || (hoverIconModifierNodeS2 = s2()) == null) {
                hoverIconModifierNodeS2 = this;
            }
            hoverIconModifierNodeS2.n2();
        }
    }

    private final void r2() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.f140137a = true;
        if (!this.f26798c) {
            TraversableNodeKt.f(this, new Function1<HoverIconModifierNode, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.ui.input.pointer.HoverIconModifierNode$displayIconIfDescendantsDoNotHavePriority$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final TraversableNode.Companion.TraverseDescendantsAction invoke(HoverIconModifierNode hoverIconModifierNode) {
                    if (!hoverIconModifierNode.f26799d) {
                        return TraversableNode.Companion.TraverseDescendantsAction.f27641a;
                    }
                    booleanRef.f140137a = false;
                    return TraversableNode.Companion.TraverseDescendantsAction.f27643c;
                }
            });
        }
        if (booleanRef.f140137a) {
            n2();
        }
    }

    private final HoverIconModifierNode s2() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TraversableNodeKt.f(this, new Function1<HoverIconModifierNode, TraversableNode.Companion.TraverseDescendantsAction>() { // from class: androidx.compose.ui.input.pointer.HoverIconModifierNode$findDescendantNodeWithCursorInBounds$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TraversableNode.Companion.TraverseDescendantsAction invoke(HoverIconModifierNode hoverIconModifierNode) {
                TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsAction = TraversableNode.Companion.TraverseDescendantsAction.f27641a;
                if (hoverIconModifierNode.f26799d) {
                    objectRef.f140144a = hoverIconModifierNode;
                    if (hoverIconModifierNode.u2()) {
                        return TraversableNode.Companion.TraverseDescendantsAction.f27642b;
                    }
                }
                return traverseDescendantsAction;
            }
        });
        return (HoverIconModifierNode) objectRef.f140144a;
    }

    private final HoverIconModifierNode t2() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TraversableNodeKt.d(this, new Function1<HoverIconModifierNode, Boolean>() { // from class: androidx.compose.ui.input.pointer.HoverIconModifierNode$findOverridingAncestorNode$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(HoverIconModifierNode hoverIconModifierNode) {
                if (hoverIconModifierNode.u2() && hoverIconModifierNode.f26799d) {
                    objectRef.f140144a = hoverIconModifierNode;
                }
                return Boolean.TRUE;
            }
        });
        return (HoverIconModifierNode) objectRef.f140144a;
    }

    private final void x2() {
        this.f26799d = true;
        r2();
    }

    private final void y2() {
        if (this.f26799d) {
            this.f26799d = false;
            if (isAttached()) {
                p2();
            }
        }
    }

    public final void A2(PointerIcon pointerIcon) {
        if (Intrinsics.areEqual(this.f26797b, pointerIcon)) {
            return;
        }
        this.f26797b = pointerIcon;
        if (this.f26799d) {
            r2();
        }
    }

    public final void B2(boolean z2) {
        if (this.f26798c != z2) {
            this.f26798c = z2;
            if (z2) {
                if (this.f26799d) {
                    n2();
                }
            } else if (this.f26799d) {
                q2();
            }
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public long V0() {
        DpTouchBoundsExpansion dpTouchBoundsExpansion = this.f26796a;
        return dpTouchBoundsExpansion != null ? dpTouchBoundsExpansion.a(DelegatableNodeKt.k(this)) : TouchBoundsExpansion.f27637b.b();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void g0(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        if (pointerEventPass == PointerEventPass.f26831b) {
            List listC = pointerEvent.c();
            int size = listC.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (w2(((PointerInputChange) listC.get(i3)).n())) {
                    int iH = pointerEvent.h();
                    PointerEventType.Companion companion = PointerEventType.f26835b;
                    if (PointerEventType.j(iH, companion.a())) {
                        x2();
                        return;
                    } else {
                        if (PointerEventType.j(pointerEvent.h(), companion.b())) {
                            y2();
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public abstract void o2(PointerIcon pointerIcon);

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        y2();
        super.onDetach();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void u1() {
        y2();
    }

    public final boolean u2() {
        return this.f26798c;
    }

    protected final PointerIconService v2() {
        return (PointerIconService) CompositionLocalConsumerModifierNodeKt.a(this, CompositionLocalsKt.n());
    }

    public abstract boolean w2(int i3);

    public final void z2(DpTouchBoundsExpansion dpTouchBoundsExpansion) {
        this.f26796a = dpTouchBoundsExpansion;
    }

    public HoverIconModifierNode(PointerIcon pointerIcon, boolean z2, DpTouchBoundsExpansion dpTouchBoundsExpansion) {
        this.f26796a = dpTouchBoundsExpansion;
        this.f26797b = pointerIcon;
        this.f26798c = z2;
    }
}
