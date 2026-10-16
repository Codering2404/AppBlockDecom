package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class SelectableTextAnnotatedStringNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, GlobalPositionAwareModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SelectionController f11064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function1 f11065d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextAnnotatedStringNode f11066f;

    public /* synthetic */ SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i3, boolean z2, int i4, int i5, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize, Function1 function13, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i3, z2, i4, i5, list, function12, selectionController, colorProducer, textAutoSize, function13);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void I(LayoutCoordinates layoutCoordinates) {
        SelectionController selectionController = this.f11064c;
        if (selectionController != null) {
            selectionController.g(layoutCoordinates);
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        this.f11066f.u2(contentDrawScope);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return this.f11066f.z2(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return this.f11066f.A2(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        return this.f11066f.B2(measureScope, measurable, j3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return this.f11066f.C2(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return this.f11066f.D2(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    public final void s2(AnnotatedString annotatedString, TextStyle textStyle, List list, int i3, int i4, boolean z2, FontFamily.Resolver resolver, int i5, Function1 function1, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize) {
        TextAnnotatedStringNode textAnnotatedStringNode = this.f11066f;
        textAnnotatedStringNode.t2(textAnnotatedStringNode.G2(colorProducer, textStyle), this.f11066f.I2(annotatedString), this.f11066f.H2(textStyle, list, i3, i4, z2, resolver, i5, textAutoSize), this.f11066f.F2(function1, function12, selectionController, this.f11065d));
        this.f11064c = selectionController;
        LayoutModifierNodeKt.b(this);
    }

    public /* synthetic */ SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i3, boolean z2, int i4, int i5, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize, Function1 function13, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, (i6 & 8) != 0 ? null : function1, (i6 & 16) != 0 ? TextOverflow.f29661b.a() : i3, (i6 & 32) != 0 ? true : z2, (i6 & 64) != 0 ? Integer.MAX_VALUE : i4, (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 1 : i5, (i6 & Function.MAX_NARGS) != 0 ? null : list, (i6 & 512) != 0 ? null : function12, (i6 & 1024) != 0 ? null : selectionController, (i6 & 2048) != 0 ? null : colorProducer, (i6 & 4096) != 0 ? null : textAutoSize, (i6 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : function13, null);
    }

    private SelectableTextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i3, boolean z2, int i4, int i5, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize, Function1 function13) {
        this.f11064c = selectionController;
        this.f11065d = function13;
        this.f11066f = (TextAnnotatedStringNode) m2(new TextAnnotatedStringNode(annotatedString, textStyle, resolver, function1, i3, z2, i4, i5, list, function12, this.f11064c, colorProducer, textAutoSize, this.f11065d, null));
        if (this.f11064c != null) {
            return;
        }
        InlineClassHelperKt.b("Do not use SelectionCapableStaticTextModifier unless selectionController != null");
        throw new KotlinNothingValueException();
    }
}
