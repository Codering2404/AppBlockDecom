package androidx.compose.ui.semantics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SemanticsNodeKt {
    /* JADX WARN: Removed duplicated region for block: B:36:0x0075 A[LOOP:0: B:5:0x0016->B:36:0x0075, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a A[EDGE_INSN: B:44:0x007a->B:37:0x007a BREAK  A[LOOP:0: B:5:0x0016->B:36:0x0075], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.semantics.SemanticsNode a(androidx.compose.ui.node.LayoutNode r10, boolean r11) {
        /*
            androidx.compose.ui.node.NodeChain r0 = r10.u0()
            r1 = 8
            int r1 = androidx.compose.ui.node.NodeKind.a(r1)
            int r2 = androidx.compose.ui.node.NodeChain.c(r0)
            r2 = r2 & r1
            r3 = 0
            if (r2 == 0) goto L7a
            androidx.compose.ui.Modifier$Node r0 = r0.k()
        L16:
            if (r0 == 0) goto L7a
            int r2 = r0.getKindSet$ui_release()
            r2 = r2 & r1
            if (r2 == 0) goto L6e
            r2 = r0
            r4 = r3
        L21:
            if (r2 == 0) goto L6e
            boolean r5 = r2 instanceof androidx.compose.ui.node.SemanticsModifierNode
            if (r5 == 0) goto L29
            r3 = r2
            goto L7a
        L29:
            int r5 = r2.getKindSet$ui_release()
            r5 = r5 & r1
            if (r5 == 0) goto L69
            boolean r5 = r2 instanceof androidx.compose.ui.node.DelegatingNode
            if (r5 == 0) goto L69
            r5 = r2
            androidx.compose.ui.node.DelegatingNode r5 = (androidx.compose.ui.node.DelegatingNode) r5
            androidx.compose.ui.Modifier$Node r5 = r5.n2()
            r6 = 0
            r7 = r6
        L3d:
            r8 = 1
            if (r5 == 0) goto L66
            int r9 = r5.getKindSet$ui_release()
            r9 = r9 & r1
            if (r9 == 0) goto L61
            int r7 = r7 + 1
            if (r7 != r8) goto L4d
            r2 = r5
            goto L61
        L4d:
            if (r4 != 0) goto L58
            androidx.compose.runtime.collection.MutableVector r4 = new androidx.compose.runtime.collection.MutableVector
            r8 = 16
            androidx.compose.ui.Modifier$Node[] r8 = new androidx.compose.ui.Modifier.Node[r8]
            r4.<init>(r8, r6)
        L58:
            if (r2 == 0) goto L5e
            r4.b(r2)
            r2 = r3
        L5e:
            r4.b(r5)
        L61:
            androidx.compose.ui.Modifier$Node r5 = r5.getChild$ui_release()
            goto L3d
        L66:
            if (r7 != r8) goto L69
            goto L21
        L69:
            androidx.compose.ui.Modifier$Node r2 = androidx.compose.ui.node.DelegatableNodeKt.b(r4)
            goto L21
        L6e:
            int r2 = r0.getAggregateChildKindSet$ui_release()
            r2 = r2 & r1
            if (r2 == 0) goto L7a
            androidx.compose.ui.Modifier$Node r0 = r0.getChild$ui_release()
            goto L16
        L7a:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            androidx.compose.ui.node.SemanticsModifierNode r3 = (androidx.compose.ui.node.SemanticsModifierNode) r3
            androidx.compose.ui.Modifier$Node r0 = r3.getNode()
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r10.Q()
            if (r1 != 0) goto L8e
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = new androidx.compose.ui.semantics.SemanticsConfiguration
            r1.<init>()
        L8e:
            androidx.compose.ui.semantics.SemanticsNode r2 = new androidx.compose.ui.semantics.SemanticsNode
            r2.<init>(r0, r11, r10, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsNodeKt.a(androidx.compose.ui.node.LayoutNode, boolean):androidx.compose.ui.semantics.SemanticsNode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(SemanticsNode semanticsNode) {
        return semanticsNode.o() + 2000000000;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007e A[LOOP:0: B:5:0x0016->B:38:0x007e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083 A[EDGE_INSN: B:43:0x0083->B:39:0x0083 BREAK  A[LOOP:0: B:5:0x0016->B:38:0x007e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.node.SemanticsModifierNode f(androidx.compose.ui.node.LayoutNode r9) {
        /*
            androidx.compose.ui.node.NodeChain r9 = r9.u0()
            r0 = 8
            int r0 = androidx.compose.ui.node.NodeKind.a(r0)
            int r1 = androidx.compose.ui.node.NodeChain.c(r9)
            r1 = r1 & r0
            r2 = 0
            if (r1 == 0) goto L83
            androidx.compose.ui.Modifier$Node r9 = r9.k()
        L16:
            if (r9 == 0) goto L83
            int r1 = r9.getKindSet$ui_release()
            r1 = r1 & r0
            if (r1 == 0) goto L77
            r1 = r9
            r3 = r2
        L21:
            if (r1 == 0) goto L77
            boolean r4 = r1 instanceof androidx.compose.ui.node.SemanticsModifierNode
            if (r4 == 0) goto L32
            r4 = r1
            androidx.compose.ui.node.SemanticsModifierNode r4 = (androidx.compose.ui.node.SemanticsModifierNode) r4
            boolean r4 = r4.d2()
            if (r4 == 0) goto L72
            r2 = r1
            goto L83
        L32:
            int r4 = r1.getKindSet$ui_release()
            r4 = r4 & r0
            if (r4 == 0) goto L72
            boolean r4 = r1 instanceof androidx.compose.ui.node.DelegatingNode
            if (r4 == 0) goto L72
            r4 = r1
            androidx.compose.ui.node.DelegatingNode r4 = (androidx.compose.ui.node.DelegatingNode) r4
            androidx.compose.ui.Modifier$Node r4 = r4.n2()
            r5 = 0
            r6 = r5
        L46:
            r7 = 1
            if (r4 == 0) goto L6f
            int r8 = r4.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L6a
            int r6 = r6 + 1
            if (r6 != r7) goto L56
            r1 = r4
            goto L6a
        L56:
            if (r3 != 0) goto L61
            androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
            r7 = 16
            androidx.compose.ui.Modifier$Node[] r7 = new androidx.compose.ui.Modifier.Node[r7]
            r3.<init>(r7, r5)
        L61:
            if (r1 == 0) goto L67
            r3.b(r1)
            r1 = r2
        L67:
            r3.b(r4)
        L6a:
            androidx.compose.ui.Modifier$Node r4 = r4.getChild$ui_release()
            goto L46
        L6f:
            if (r6 != r7) goto L72
            goto L21
        L72:
            androidx.compose.ui.Modifier$Node r1 = androidx.compose.ui.node.DelegatableNodeKt.b(r3)
            goto L21
        L77:
            int r1 = r9.getAggregateChildKindSet$ui_release()
            r1 = r1 & r0
            if (r1 == 0) goto L83
            androidx.compose.ui.Modifier$Node r9 = r9.getChild$ui_release()
            goto L16
        L83:
            androidx.compose.ui.node.SemanticsModifierNode r2 = (androidx.compose.ui.node.SemanticsModifierNode) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsNodeKt.f(androidx.compose.ui.node.LayoutNode):androidx.compose.ui.node.SemanticsModifierNode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Role g(SemanticsNode semanticsNode) {
        return (Role) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsProperties.f28517a.C());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h(SemanticsNode semanticsNode) {
        return semanticsNode.o() + 1000000000;
    }
}
