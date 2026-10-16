package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager;
import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager_androidKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

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
final class HandwritingDetectorNode extends DelegatingNode implements PointerInputModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function0 f10097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f10098d = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<ComposeInputMethodManager>() { // from class: androidx.compose.foundation.text.handwriting.HandwritingDetectorNode$composeImm$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ComposeInputMethodManager invoke() {
            return ComposeInputMethodManager_androidKt.a(DelegatableNode_androidKt.a(this.f10100a));
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StylusHandwritingNode f10099f = (StylusHandwritingNode) m2(new StylusHandwritingNode(new Function0<Unit>() { // from class: androidx.compose.foundation.text.handwriting.HandwritingDetectorNode$pointerInputNode$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m75invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m75invoke() {
            this.f10101a.t2().invoke();
            this.f10101a.u2().d();
        }
    }));

    public HandwritingDetectorNode(Function0 function0) {
        this.f10097c = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ComposeInputMethodManager u2() {
        return (ComposeInputMethodManager) this.f10098d.getValue();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public long V0() {
        return this.f10099f.V0();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void g0(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        this.f10099f.g0(pointerEvent, pointerEventPass, j3);
    }

    public final Function0 t2() {
        return this.f10097c;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void u1() {
        this.f10099f.u1();
    }

    public final void v2(Function0 function0) {
        this.f10097c = function0;
    }
}
