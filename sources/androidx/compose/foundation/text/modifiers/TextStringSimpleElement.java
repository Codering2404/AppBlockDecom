package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Metadata;
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
public final class TextStringSimpleElement extends ModifierNodeElement<TextStringSimpleNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextStyle f11132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FontFamily.Resolver f11133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f11134d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f11135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f11136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f11137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ColorProducer f11138i;

    public /* synthetic */ TextStringSimpleElement(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i3, boolean z2, int i4, int i5, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, resolver, i3, z2, i4, i5, colorProducer);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextStringSimpleNode create() {
        return new TextStringSimpleNode(this.f11131a, this.f11132b, this.f11133c, this.f11134d, this.f11135f, this.f11136g, this.f11137h, this.f11138i, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(TextStringSimpleNode textStringSimpleNode) {
        textStringSimpleNode.u2(textStringSimpleNode.A2(this.f11138i, this.f11132b), textStringSimpleNode.C2(this.f11131a), textStringSimpleNode.B2(this.f11132b, this.f11137h, this.f11136g, this.f11135f, this.f11133c, this.f11134d));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStringSimpleElement)) {
            return false;
        }
        TextStringSimpleElement textStringSimpleElement = (TextStringSimpleElement) obj;
        return Intrinsics.areEqual(this.f11138i, textStringSimpleElement.f11138i) && Intrinsics.areEqual(this.f11131a, textStringSimpleElement.f11131a) && Intrinsics.areEqual(this.f11132b, textStringSimpleElement.f11132b) && Intrinsics.areEqual(this.f11133c, textStringSimpleElement.f11133c) && TextOverflow.h(this.f11134d, textStringSimpleElement.f11134d) && this.f11135f == textStringSimpleElement.f11135f && this.f11136g == textStringSimpleElement.f11136g && this.f11137h == textStringSimpleElement.f11137h;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.f11131a.hashCode() * 31) + this.f11132b.hashCode()) * 31) + this.f11133c.hashCode()) * 31) + TextOverflow.i(this.f11134d)) * 31) + Boolean.hashCode(this.f11135f)) * 31) + this.f11136g) * 31) + this.f11137h) * 31;
        ColorProducer colorProducer = this.f11138i;
        return iHashCode + (colorProducer != null ? colorProducer.hashCode() : 0);
    }

    private TextStringSimpleElement(String str, TextStyle textStyle, FontFamily.Resolver resolver, int i3, boolean z2, int i4, int i5, ColorProducer colorProducer) {
        this.f11131a = str;
        this.f11132b = textStyle;
        this.f11133c = resolver;
        this.f11134d = i3;
        this.f11135f = z2;
        this.f11136g = i4;
        this.f11137h = i5;
        this.f11138i = colorProducer;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }
}
