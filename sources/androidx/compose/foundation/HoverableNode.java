package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
final class HoverableNode extends Modifier.Node implements PointerInputModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MutableInteractionSource f4953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HoverInteraction.Enter f4954b;

    public HoverableNode(MutableInteractionSource mutableInteractionSource) {
        this.f4953a = mutableInteractionSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o2(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.foundation.HoverableNode$emitEnter$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.foundation.HoverableNode$emitEnter$1 r0 = (androidx.compose.foundation.HoverableNode$emitEnter$1) r0
            int r1 = r0.f4959f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4959f = r1
            goto L18
        L13:
            androidx.compose.foundation.HoverableNode$emitEnter$1 r0 = new androidx.compose.foundation.HoverableNode$emitEnter$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f4957c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f4959f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r1 = r0.f4956b
            androidx.compose.foundation.interaction.HoverInteraction$Enter r1 = (androidx.compose.foundation.interaction.HoverInteraction.Enter) r1
            java.lang.Object r0 = r0.f4955a
            androidx.compose.foundation.HoverableNode r0 = (androidx.compose.foundation.HoverableNode) r0
            kotlin.ResultKt.b(r5)
            goto L56
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L39:
            kotlin.ResultKt.b(r5)
            androidx.compose.foundation.interaction.HoverInteraction$Enter r5 = r4.f4954b
            if (r5 != 0) goto L58
            androidx.compose.foundation.interaction.HoverInteraction$Enter r5 = new androidx.compose.foundation.interaction.HoverInteraction$Enter
            r5.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r4.f4953a
            r0.f4955a = r4
            r0.f4956b = r5
            r0.f4959f = r3
            java.lang.Object r0 = r2.a(r5, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r4
            r1 = r5
        L56:
            r0.f4954b = r1
        L58:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableNode.o2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p2(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.compose.foundation.HoverableNode$emitExit$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.compose.foundation.HoverableNode$emitExit$1 r0 = (androidx.compose.foundation.HoverableNode$emitExit$1) r0
            int r1 = r0.f4963d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4963d = r1
            goto L18
        L13:
            androidx.compose.foundation.HoverableNode$emitExit$1 r0 = new androidx.compose.foundation.HoverableNode$emitExit$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f4961b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f4963d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f4960a
            androidx.compose.foundation.HoverableNode r0 = (androidx.compose.foundation.HoverableNode) r0
            kotlin.ResultKt.b(r5)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.b(r5)
            androidx.compose.foundation.interaction.HoverInteraction$Enter r5 = r4.f4954b
            if (r5 == 0) goto L52
            androidx.compose.foundation.interaction.HoverInteraction$Exit r2 = new androidx.compose.foundation.interaction.HoverInteraction$Exit
            r2.<init>(r5)
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r4.f4953a
            r0.f4960a = r4
            r0.f4963d = r3
            java.lang.Object r5 = r5.a(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r0 = r4
        L4f:
            r5 = 0
            r0.f4954b = r5
        L52:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableNode.p2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void q2() {
        HoverInteraction.Enter enter = this.f4954b;
        if (enter != null) {
            this.f4953a.b(new HoverInteraction.Exit(enter));
            this.f4954b = null;
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void g0(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        if (pointerEventPass == PointerEventPass.f26831b) {
            int iH = pointerEvent.h();
            PointerEventType.Companion companion = PointerEventType.f26835b;
            if (PointerEventType.j(iH, companion.a())) {
                BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$1(this, null), 3, null);
            } else if (PointerEventType.j(iH, companion.b())) {
                BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$2(this, null), 3, null);
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        q2();
    }

    public final void r2(MutableInteractionSource mutableInteractionSource) {
        if (Intrinsics.areEqual(this.f4953a, mutableInteractionSource)) {
            return;
        }
        q2();
        this.f4953a = mutableInteractionSource;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void u1() {
        q2();
    }
}
