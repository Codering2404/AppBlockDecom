package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class TextFieldTextLayoutModifierNode extends Modifier.Node implements LayoutModifierNode, GlobalPositionAwareModifierNode, CompositionLocalConsumerModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextLayoutState f10650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f10651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f10652c;

    public TextFieldTextLayoutModifierNode(TextLayoutState textLayoutState, TransformedTextFieldState transformedTextFieldState, TextStyle textStyle, boolean z2, Function2 function2, KeyboardOptions keyboardOptions) {
        this.f10650a = textLayoutState;
        this.f10651b = z2;
        textLayoutState.p(function2);
        TextLayoutState textLayoutState2 = this.f10650a;
        boolean z3 = this.f10651b;
        textLayoutState2.r(transformedTextFieldState, textStyle, z3, !z3, keyboardOptions);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void I(LayoutCoordinates layoutCoordinates) {
        this.f10650a.q(layoutCoordinates);
    }

    public final void m2(TextLayoutState textLayoutState, TransformedTextFieldState transformedTextFieldState, TextStyle textStyle, boolean z2, Function2 function2, KeyboardOptions keyboardOptions) {
        this.f10650a = textLayoutState;
        textLayoutState.p(function2);
        this.f10651b = z2;
        this.f10650a.r(transformedTextFieldState, textStyle, z2, !z2, keyboardOptions);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        TextLayoutResult textLayoutResultL = this.f10650a.l(measureScope, measureScope.getLayoutDirection(), (FontFamily.Resolver) CompositionLocalConsumerModifierNodeKt.a(this, CompositionLocalsKt.h()), j3);
        final Placeable placeableN0 = measurable.n0(Constraints.f29963b.b((int) (textLayoutResultL.B() >> 32), (int) (textLayoutResultL.B() >> 32), (int) (textLayoutResultL.B() & 4294967295L), (int) (textLayoutResultL.B() & 4294967295L)));
        this.f10650a.o(this.f10651b ? measureScope.F(TextDelegateKt.a(textLayoutResultL.m(0))) : Dp.g(0));
        Map linkedHashMap = this.f10652c;
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap(2);
        }
        linkedHashMap.put(AlignmentLineKt.a(), Integer.valueOf(Math.round(textLayoutResultL.h())));
        linkedHashMap.put(AlignmentLineKt.b(), Integer.valueOf(Math.round(textLayoutResultL.k())));
        this.f10652c = linkedHashMap;
        int iB = (int) (textLayoutResultL.B() >> 32);
        int iB2 = (int) (textLayoutResultL.B() & 4294967295L);
        Map map = this.f10652c;
        Intrinsics.checkNotNull(map);
        return measureScope.c1(iB, iB2, map, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifierNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.i(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
            }
        });
    }
}
