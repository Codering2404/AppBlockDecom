package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTargetNodeKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.compose.ui.semantics.SemanticsModifier;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;

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
public final class NodeKindKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final MutableObjectIntMap f27588a = ObjectIntMapKt.b();

    public static final void a(Modifier.Node node) {
        if (!node.isAttached()) {
            InlineClassHelperKt.c("autoInvalidateInsertedNode called on unattached node");
        }
        b(node, -1, 1);
    }

    public static final void b(Modifier.Node node, int i3, int i4) {
        if (!(node instanceof DelegatingNode)) {
            c(node, i3 & node.getKindSet$ui_release(), i4);
            return;
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        c(node, delegatingNode.o2() & i3, i4);
        int i5 = (~delegatingNode.o2()) & i3;
        for (Modifier.Node nodeN2 = delegatingNode.n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
            b(nodeN2, i5, i4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void c(Modifier.Node node, int i3, int i4) {
        if (i4 != 0 || node.getShouldAutoInvalidate()) {
            if ((NodeKind.a(2) & i3) != 0 && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.b((LayoutModifierNode) node);
                if (i4 == 2) {
                    DelegatableNodeKt.j(node, NodeKind.a(2)).u3();
                }
            }
            if ((NodeKind.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) & i3) != 0 && (node instanceof LayoutAwareModifierNode) && i4 != 2) {
                DelegatableNodeKt.o(node).P0();
            }
            if ((NodeKind.a(Function.MAX_NARGS) & i3) != 0 && (node instanceof GlobalPositionAwareModifierNode) && i4 != 2) {
                DelegatableNodeKt.o(node).Q0();
            }
            if ((NodeKind.a(4) & i3) != 0 && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.a((DrawModifierNode) node);
            }
            if ((NodeKind.a(8) & i3) != 0 && (node instanceof SemanticsModifierNode)) {
                DelegatableNodeKt.o(node).Y1(true);
            }
            if ((NodeKind.a(64) & i3) != 0 && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.a((ParentDataModifierNode) node);
            }
            if ((NodeKind.a(2048) & i3) != 0 && (node instanceof FocusPropertiesModifierNode)) {
                FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) node;
                if (k(focusPropertiesModifierNode)) {
                    if (ComposeUiFlags.f25107g || i4 == 2) {
                        j(focusPropertiesModifierNode);
                    } else {
                        FocusPropertiesModifierNodeKt.a(focusPropertiesModifierNode);
                    }
                }
            }
            if ((i3 & NodeKind.a(4096)) == 0 || !(node instanceof FocusEventModifierNode)) {
                return;
            }
            FocusEventModifierNodeKt.b((FocusEventModifierNode) node);
        }
    }

    public static final void d(Modifier.Node node) {
        if (!node.isAttached()) {
            InlineClassHelperKt.c("autoInvalidateRemovedNode called on unattached node");
        }
        b(node, -1, 2);
    }

    public static final void e(Modifier.Node node) {
        if (!node.isAttached()) {
            InlineClassHelperKt.c("autoInvalidateUpdatedNode called on unattached node");
        }
        b(node, -1, 0);
    }

    public static final int f(Modifier.Element element) {
        int iA = NodeKind.a(1);
        if (element instanceof LayoutModifier) {
            iA |= NodeKind.a(2);
        }
        if (element instanceof DrawModifier) {
            iA |= NodeKind.a(4);
        }
        if (element instanceof SemanticsModifier) {
            iA |= NodeKind.a(8);
        }
        if (element instanceof PointerInputModifier) {
            iA |= NodeKind.a(16);
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            iA |= NodeKind.a(32);
        }
        if (element instanceof FocusEventModifier) {
            iA |= NodeKind.a(4096);
        }
        if (element instanceof FocusOrderModifier) {
            iA |= NodeKind.a(2048);
        }
        if (element instanceof OnGloballyPositionedModifier) {
            iA |= NodeKind.a(Function.MAX_NARGS);
        }
        if (element instanceof ParentDataModifier) {
            iA |= NodeKind.a(64);
        }
        if ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier)) {
            iA |= NodeKind.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        }
        return element instanceof BringIntoViewModifierNode ? NodeKind.a(524288) | iA : iA;
    }

    public static final int g(Modifier.Node node) {
        if (node.getKindSet$ui_release() != 0) {
            return node.getKindSet$ui_release();
        }
        MutableObjectIntMap mutableObjectIntMap = f27588a;
        Object objB = Actual_jvmKt.b(node);
        int iB = mutableObjectIntMap.b(objB);
        if (iB >= 0) {
            return mutableObjectIntMap.f3077c[iB];
        }
        int iA = NodeKind.a(1);
        if (node instanceof LayoutModifierNode) {
            iA |= NodeKind.a(2);
        }
        if (node instanceof DrawModifierNode) {
            iA |= NodeKind.a(4);
        }
        if (node instanceof SemanticsModifierNode) {
            iA |= NodeKind.a(8);
        }
        if (node instanceof PointerInputModifierNode) {
            iA |= NodeKind.a(16);
        }
        if (node instanceof ModifierLocalModifierNode) {
            iA |= NodeKind.a(32);
        }
        if (node instanceof ParentDataModifierNode) {
            iA |= NodeKind.a(64);
        }
        if (node instanceof LayoutAwareModifierNode) {
            iA |= NodeKind.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            iA |= NodeKind.a(Function.MAX_NARGS);
        }
        if (node instanceof ApproachLayoutModifierNode) {
            iA |= NodeKind.a(512);
        }
        if (node instanceof FocusTargetNode) {
            iA |= NodeKind.a(1024);
        }
        if (node instanceof FocusPropertiesModifierNode) {
            iA |= NodeKind.a(2048);
        }
        if (node instanceof FocusEventModifierNode) {
            iA |= NodeKind.a(4096);
        }
        if (node instanceof KeyInputModifierNode) {
            iA |= NodeKind.a(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        }
        if (node instanceof RotaryInputModifierNode) {
            iA |= NodeKind.a(16384);
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            iA |= NodeKind.a(32768);
        }
        if (node instanceof SoftKeyboardInterceptionModifierNode) {
            iA |= NodeKind.a(131072);
        }
        if (node instanceof TraversableNode) {
            iA |= NodeKind.a(262144);
        }
        if (node instanceof BringIntoViewModifierNode) {
            iA |= NodeKind.a(524288);
        }
        if (node instanceof OnUnplacedModifierNode) {
            iA |= NodeKind.a(1048576);
        }
        mutableObjectIntMap.u(objB, iA);
        return iA;
    }

    public static final int h(Modifier.Node node) {
        if (!(node instanceof DelegatingNode)) {
            return g(node);
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        int iO2 = delegatingNode.o2();
        for (Modifier.Node nodeN2 = delegatingNode.n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
            iO2 |= h(nodeN2);
        }
        return iO2;
    }

    public static final boolean i(int i3) {
        return (i3 & NodeKind.a(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)) != 0;
    }

    private static final void j(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        int iA = NodeKind.a(1024);
        if (!focusPropertiesModifierNode.getNode().isAttached()) {
            InlineClassHelperKt.c("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusPropertiesModifierNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.c(mutableVector, focusPropertiesModifierNode.getNode(), false);
        } else {
            mutableVector.b(child$ui_release);
        }
        while (mutableVector.o() != 0) {
            Modifier.Node nodeH = (Modifier.Node) mutableVector.u(mutableVector.o() - 1);
            if ((nodeH.getAggregateChildKindSet$ui_release() & iA) == 0) {
                DelegatableNodeKt.c(mutableVector, nodeH, false);
            } else {
                while (true) {
                    if (nodeH == null) {
                        break;
                    }
                    if ((nodeH.getKindSet$ui_release() & iA) != 0) {
                        MutableVector mutableVector2 = null;
                        while (nodeH != null) {
                            if (nodeH instanceof FocusTargetNode) {
                                FocusTargetNodeKt.b((FocusTargetNode) nodeH);
                            } else if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node nodeN2 = ((DelegatingNode) nodeH).n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            nodeH = nodeN2;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodeH != null) {
                                                mutableVector2.b(nodeH);
                                                nodeH = null;
                                            }
                                            mutableVector2.b(nodeN2);
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            nodeH = DelegatableNodeKt.h(mutableVector2);
                        }
                    } else {
                        nodeH = nodeH.getChild$ui_release();
                    }
                }
            }
        }
    }

    private static final boolean k(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        CanFocusChecker canFocusChecker = CanFocusChecker.f27288a;
        canFocusChecker.d();
        focusPropertiesModifierNode.i1(canFocusChecker);
        return canFocusChecker.c();
    }
}
