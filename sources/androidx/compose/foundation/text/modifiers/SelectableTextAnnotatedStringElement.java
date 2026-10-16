package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import com.facebook.internal.Utility;
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
public final class SelectableTextAnnotatedStringElement extends ModifierNodeElement<SelectableTextAnnotatedStringNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnnotatedString f11051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextStyle f11052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FontFamily.Resolver f11053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f11054d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f11055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f11056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f11057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f11058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f11059j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Function1 f11060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final SelectionController f11061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ColorProducer f11062m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final TextAutoSize f11063n;

    public /* synthetic */ SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i3, boolean z2, int i4, int i5, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i3, z2, i4, i5, list, function12, selectionController, colorProducer, textAutoSize);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SelectableTextAnnotatedStringNode create() {
        return new SelectableTextAnnotatedStringNode(this.f11051a, this.f11052b, this.f11053c, this.f11054d, this.f11055f, this.f11056g, this.f11057h, this.f11058i, this.f11059j, this.f11060k, this.f11061l, this.f11062m, this.f11063n, null, Utility.DEFAULT_STREAM_BUFFER_SIZE, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(SelectableTextAnnotatedStringNode selectableTextAnnotatedStringNode) {
        selectableTextAnnotatedStringNode.s2(this.f11051a, this.f11052b, this.f11059j, this.f11058i, this.f11057h, this.f11056g, this.f11053c, this.f11055f, this.f11054d, this.f11060k, this.f11061l, this.f11062m, this.f11063n);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectableTextAnnotatedStringElement)) {
            return false;
        }
        SelectableTextAnnotatedStringElement selectableTextAnnotatedStringElement = (SelectableTextAnnotatedStringElement) obj;
        return Intrinsics.areEqual(this.f11062m, selectableTextAnnotatedStringElement.f11062m) && Intrinsics.areEqual(this.f11051a, selectableTextAnnotatedStringElement.f11051a) && Intrinsics.areEqual(this.f11052b, selectableTextAnnotatedStringElement.f11052b) && Intrinsics.areEqual(this.f11059j, selectableTextAnnotatedStringElement.f11059j) && Intrinsics.areEqual(this.f11053c, selectableTextAnnotatedStringElement.f11053c) && Intrinsics.areEqual(this.f11063n, selectableTextAnnotatedStringElement.f11063n) && this.f11054d == selectableTextAnnotatedStringElement.f11054d && TextOverflow.h(this.f11055f, selectableTextAnnotatedStringElement.f11055f) && this.f11056g == selectableTextAnnotatedStringElement.f11056g && this.f11057h == selectableTextAnnotatedStringElement.f11057h && this.f11058i == selectableTextAnnotatedStringElement.f11058i && this.f11060k == selectableTextAnnotatedStringElement.f11060k && Intrinsics.areEqual(this.f11061l, selectableTextAnnotatedStringElement.f11061l);
    }

    public int hashCode() {
        int iHashCode = ((((this.f11051a.hashCode() * 31) + this.f11052b.hashCode()) * 31) + this.f11053c.hashCode()) * 31;
        Function1 function1 = this.f11054d;
        int iHashCode2 = (((((((((iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31) + TextOverflow.i(this.f11055f)) * 31) + Boolean.hashCode(this.f11056g)) * 31) + this.f11057h) * 31) + this.f11058i) * 31;
        List list = this.f11059j;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Function1 function12 = this.f11060k;
        int iHashCode4 = (iHashCode3 + (function12 != null ? function12.hashCode() : 0)) * 31;
        SelectionController selectionController = this.f11061l;
        int iHashCode5 = (iHashCode4 + (selectionController != null ? selectionController.hashCode() : 0)) * 31;
        TextAutoSize textAutoSize = this.f11063n;
        int iHashCode6 = (iHashCode5 + (textAutoSize != null ? textAutoSize.hashCode() : 0)) * 31;
        ColorProducer colorProducer = this.f11062m;
        return iHashCode6 + (colorProducer != null ? colorProducer.hashCode() : 0);
    }

    public String toString() {
        return "SelectableTextAnnotatedStringElement(text=" + ((Object) this.f11051a) + ", style=" + this.f11052b + ", fontFamilyResolver=" + this.f11053c + ", onTextLayout=" + this.f11054d + ", overflow=" + ((Object) TextOverflow.j(this.f11055f)) + ", softWrap=" + this.f11056g + ", maxLines=" + this.f11057h + ", minLines=" + this.f11058i + ", placeholders=" + this.f11059j + ", onPlaceholderLayout=" + this.f11060k + ", selectionController=" + this.f11061l + ", color=" + this.f11062m + ", autoSize=" + this.f11063n + ')';
    }

    private SelectableTextAnnotatedStringElement(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i3, boolean z2, int i4, int i5, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, TextAutoSize textAutoSize) {
        this.f11051a = annotatedString;
        this.f11052b = textStyle;
        this.f11053c = resolver;
        this.f11054d = function1;
        this.f11055f = i3;
        this.f11056g = z2;
        this.f11057h = i4;
        this.f11058i = i5;
        this.f11059j = list;
        this.f11060k = function12;
        this.f11061l = selectionController;
        this.f11062m = colorProducer;
        this.f11063n = textAutoSize;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }
}
