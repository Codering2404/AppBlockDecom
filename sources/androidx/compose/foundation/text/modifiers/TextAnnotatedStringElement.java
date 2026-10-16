package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class TextAnnotatedStringElement extends ModifierNodeElement<TextAnnotatedStringNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnnotatedString f11090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextStyle f11091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FontFamily.Resolver f11092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f11093d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f11094f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f11095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f11096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f11097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f11098j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Function1 f11099k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final SelectionController f11100l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ColorProducer f11101m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final TextAutoSize f11102n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Function1 f11103o;

    public /* synthetic */ TextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i3, boolean z2, int i4, int i5, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize, Function1 function13, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i3, z2, i4, i5, list, function12, selectionController, colorProducer, textAutoSize, function13);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextAnnotatedStringNode create() {
        return new TextAnnotatedStringNode(this.f11090a, this.f11091b, this.f11092c, this.f11093d, this.f11094f, this.f11095g, this.f11096h, this.f11097i, this.f11098j, this.f11099k, this.f11100l, this.f11101m, this.f11102n, this.f11103o, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(TextAnnotatedStringNode textAnnotatedStringNode) {
        textAnnotatedStringNode.t2(textAnnotatedStringNode.G2(this.f11101m, this.f11091b), textAnnotatedStringNode.I2(this.f11090a), textAnnotatedStringNode.H2(this.f11091b, this.f11098j, this.f11097i, this.f11096h, this.f11095g, this.f11092c, this.f11094f, this.f11102n), textAnnotatedStringNode.F2(this.f11093d, this.f11099k, this.f11100l, this.f11103o));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextAnnotatedStringElement)) {
            return false;
        }
        TextAnnotatedStringElement textAnnotatedStringElement = (TextAnnotatedStringElement) obj;
        return Intrinsics.areEqual(this.f11101m, textAnnotatedStringElement.f11101m) && Intrinsics.areEqual(this.f11090a, textAnnotatedStringElement.f11090a) && Intrinsics.areEqual(this.f11091b, textAnnotatedStringElement.f11091b) && Intrinsics.areEqual(this.f11098j, textAnnotatedStringElement.f11098j) && Intrinsics.areEqual(this.f11092c, textAnnotatedStringElement.f11092c) && this.f11093d == textAnnotatedStringElement.f11093d && this.f11103o == textAnnotatedStringElement.f11103o && TextOverflow.h(this.f11094f, textAnnotatedStringElement.f11094f) && this.f11095g == textAnnotatedStringElement.f11095g && this.f11096h == textAnnotatedStringElement.f11096h && this.f11097i == textAnnotatedStringElement.f11097i && this.f11099k == textAnnotatedStringElement.f11099k && Intrinsics.areEqual(this.f11100l, textAnnotatedStringElement.f11100l);
    }

    public int hashCode() {
        int iHashCode = ((((this.f11090a.hashCode() * 31) + this.f11091b.hashCode()) * 31) + this.f11092c.hashCode()) * 31;
        Function1 function1 = this.f11093d;
        int iHashCode2 = (((((((((iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31) + TextOverflow.i(this.f11094f)) * 31) + Boolean.hashCode(this.f11095g)) * 31) + this.f11096h) * 31) + this.f11097i) * 31;
        List list = this.f11098j;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Function1 function12 = this.f11099k;
        int iHashCode4 = (iHashCode3 + (function12 != null ? function12.hashCode() : 0)) * 31;
        SelectionController selectionController = this.f11100l;
        int iHashCode5 = (iHashCode4 + (selectionController != null ? selectionController.hashCode() : 0)) * 31;
        ColorProducer colorProducer = this.f11101m;
        int iHashCode6 = (iHashCode5 + (colorProducer != null ? colorProducer.hashCode() : 0)) * 31;
        Function1 function13 = this.f11103o;
        return iHashCode6 + (function13 != null ? function13.hashCode() : 0);
    }

    private TextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i3, boolean z2, int i4, int i5, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize, Function1 function13) {
        this.f11090a = annotatedString;
        this.f11091b = textStyle;
        this.f11092c = resolver;
        this.f11093d = function1;
        this.f11094f = i3;
        this.f11095g = z2;
        this.f11096h = i4;
        this.f11097i = i5;
        this.f11098j = list;
        this.f11099k = function12;
        this.f11100l = selectionController;
        this.f11101m = colorProducer;
        this.f11102n = textAutoSize;
        this.f11103o = function13;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }
}
