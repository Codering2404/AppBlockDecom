package androidx.compose.material3;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class ClockDialNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode, LayoutAwareModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnalogTimePickerState f16585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f16586d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f16588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f16589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f16590i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final SuspendingPointerInputModifierNode f16591j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final SuspendingPointerInputModifierNode f16592k;

    public /* synthetic */ ClockDialNode(AnalogTimePickerState analogTimePickerState, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(analogTimePickerState, z2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float A2() {
        return DelegatableNodeKt.k(this).M1(TimePickerKt.f21174h);
    }

    public final void B2(AnalogTimePickerState analogTimePickerState, boolean z2, int i3) {
        this.f16585c = analogTimePickerState;
        this.f16586d = z2;
        if (TimePickerSelectionMode.f(this.f16587f, i3)) {
            return;
        }
        this.f16587f = i3;
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new ClockDialNode$updateNode$1(analogTimePickerState, null), 3, null);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void g0(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        this.f16591j.g0(pointerEvent, pointerEventPass, j3);
        this.f16592k.g0(pointerEvent, pointerEventPass, j3);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void m(long j3) {
        this.f16590i = IntSizeKt.b(j3);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void u1() {
        this.f16591j.u1();
        this.f16592k.u1();
    }

    private ClockDialNode(AnalogTimePickerState analogTimePickerState, boolean z2, int i3) {
        this.f16585c = analogTimePickerState;
        this.f16586d = z2;
        this.f16587f = i3;
        this.f16590i = IntOffset.f29988b.b();
        this.f16591j = (SuspendingPointerInputModifierNode) m2(SuspendingPointerInputFilterKt.b(new ClockDialNode$pointerInputTapNode$1(this, null)));
        this.f16592k = (SuspendingPointerInputModifierNode) m2(SuspendingPointerInputFilterKt.b(new ClockDialNode$pointerInputDragNode$1(this, null)));
    }
}
