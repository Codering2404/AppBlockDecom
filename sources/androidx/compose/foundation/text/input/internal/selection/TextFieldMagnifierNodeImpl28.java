package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.MagnifierNode;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

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
public final class TextFieldMagnifierNodeImpl28 extends TextFieldMagnifierNode implements CompositionLocalConsumerModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TransformedTextFieldState f10722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextFieldSelectionState f10723d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextLayoutState f10724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10725g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Animatable f10727i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Job f10729k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f10726h = SnapshotStateKt__SnapshotStateKt.e(IntSize.b(IntSize.f29998b.a()), null, 2, null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MagnifierNode f10728j = (MagnifierNode) m2(new MagnifierNode(new Function1<Density, Offset>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$magnifierNode$1
        {
            super(1);
        }

        public final long c(Density density) {
            return ((Offset) this.f10730a.f10727i.n()).u();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Offset.d(c((Density) obj));
        }
    }, null, new Function1<DpSize, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$magnifierNode$2
        {
            super(1);
        }

        public final void c(long j3) {
            TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28 = this.f10731a;
            Density density = (Density) CompositionLocalConsumerModifierNodeKt.a(textFieldMagnifierNodeImpl28, CompositionLocalsKt.f());
            int iZ0 = density.z0(DpSize.j(j3));
            textFieldMagnifierNodeImpl28.C2(IntSize.c((((long) density.z0(DpSize.i(j3))) & 4294967295L) | (((long) iZ0) << 32)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c(((DpSize) obj).m());
            return Unit.f139807a;
        }
    }, 0.0f, true, 0, 0.0f, 0.0f, false, null, 1002, null));

    public TextFieldMagnifierNodeImpl28(TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, TextLayoutState textLayoutState, boolean z2) {
        this.f10722c = transformedTextFieldState;
        this.f10723d = textFieldSelectionState;
        this.f10724f = textLayoutState;
        this.f10725g = z2;
        this.f10727i = new Animatable(Offset.d(TextFieldMagnifierKt.a(this.f10722c, this.f10723d, this.f10724f, A2())), SelectionMagnifierKt.g(), Offset.d(SelectionMagnifierKt.f()), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long A2() {
        return ((IntSize) this.f10726h.getValue()).j();
    }

    private final void B2() {
        Job job = this.f10729k;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f10729k = null;
        if (Magnifier_androidKt.d(0, 1, null)) {
            this.f10729k = BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new TextFieldMagnifierNodeImpl28$restartAnimationJob$1(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C2(long j3) {
        this.f10726h.setValue(IntSize.b(j3));
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode, androidx.compose.ui.layout.OnGloballyPositionedModifier
    public void I(LayoutCoordinates layoutCoordinates) {
        this.f10728j.I(layoutCoordinates);
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode, androidx.compose.ui.node.SemanticsModifierNode
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        this.f10728j.N(semanticsPropertyReceiver);
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode, androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.i2();
        this.f10728j.draw(contentDrawScope);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        B2();
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
    public void s2(TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, TextLayoutState textLayoutState, boolean z2) {
        TransformedTextFieldState transformedTextFieldState2 = this.f10722c;
        TextFieldSelectionState textFieldSelectionState2 = this.f10723d;
        TextLayoutState textLayoutState2 = this.f10724f;
        boolean z3 = this.f10725g;
        this.f10722c = transformedTextFieldState;
        this.f10723d = textFieldSelectionState;
        this.f10724f = textLayoutState;
        this.f10725g = z2;
        if (Intrinsics.areEqual(transformedTextFieldState, transformedTextFieldState2) && Intrinsics.areEqual(textFieldSelectionState, textFieldSelectionState2) && Intrinsics.areEqual(textLayoutState, textLayoutState2) && z2 == z3) {
            return;
        }
        B2();
    }
}
