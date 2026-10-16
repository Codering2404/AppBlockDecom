package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
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
public interface ModifierLocalModifierNode extends ModifierLocalReadScope, DelegatableNode {
    default ModifierLocalMap n0() {
        return EmptyMap.f27245a;
    }

    default void r1(ModifierLocal modifierLocal, Object obj) {
        if (!(n0() != EmptyMap.f27245a)) {
            InlineClassHelperKt.a("In order to provide locals you must override providedValues: ModifierLocalMap");
        }
        if (!n0().a(modifierLocal)) {
            InlineClassHelperKt.a("Any provided key must be initially provided in the overridden providedValues: ModifierLocalMap property. Key " + modifierLocal + " was not found.");
        }
        n0().c(modifierLocal, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
    default Object u(ModifierLocal modifierLocal) {
        NodeChain nodeChainU0;
        if (!getNode().isAttached()) {
            InlineClassHelperKt.a("ModifierLocal accessed from an unattached node");
        }
        int iA = NodeKind.a(32);
        if (!getNode().isAttached()) {
            InlineClassHelperKt.c("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = getNode().getParent$ui_release();
        LayoutNode layoutNodeO = DelegatableNodeKt.o(this);
        while (layoutNodeO != null) {
            if ((layoutNodeO.u0().k().getAggregateChildKindSet$ui_release() & iA) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & iA) != 0) {
                        ?? H = parent$ui_release;
                        ?? mutableVector = 0;
                        while (H != 0) {
                            if (H instanceof ModifierLocalModifierNode) {
                                ModifierLocalModifierNode modifierLocalModifierNode = (ModifierLocalModifierNode) H;
                                if (modifierLocalModifierNode.n0().a(modifierLocal)) {
                                    return modifierLocalModifierNode.n0().b(modifierLocal);
                                }
                            } else if ((H.getKindSet$ui_release() & iA) != 0 && (H instanceof DelegatingNode)) {
                                Modifier.Node nodeN2 = ((DelegatingNode) H).n2();
                                int i3 = 0;
                                H = H;
                                mutableVector = mutableVector;
                                while (nodeN2 != null) {
                                    if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                        i3++;
                                        mutableVector = mutableVector;
                                        if (i3 == 1) {
                                            H = nodeN2;
                                        } else {
                                            if (mutableVector == 0) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (H != 0) {
                                                mutableVector.b(H);
                                                H = 0;
                                            }
                                            mutableVector.b(nodeN2);
                                        }
                                    }
                                    nodeN2 = nodeN2.getChild$ui_release();
                                    H = H;
                                    mutableVector = mutableVector;
                                }
                                if (i3 == 1) {
                                }
                            }
                            H = DelegatableNodeKt.h(mutableVector);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            layoutNodeO = layoutNodeO.B0();
            parent$ui_release = (layoutNodeO == null || (nodeChainU0 = layoutNodeO.u0()) == null) ? null : nodeChainU0.p();
        }
        return modifierLocal.a().invoke();
    }
}
