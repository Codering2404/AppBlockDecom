package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
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
final class PainterElement extends ModifierNodeElement<PainterNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Painter f25412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f25413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Alignment f25414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ContentScale f25415d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f25416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ColorFilter f25417g;

    public PainterElement(Painter painter, boolean z2, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter) {
        this.f25412a = painter;
        this.f25413b = z2;
        this.f25414c = alignment;
        this.f25415d = contentScale;
        this.f25416f = f3;
        this.f25417g = colorFilter;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PainterNode create() {
        return new PainterNode(this.f25412a, this.f25413b, this.f25414c, this.f25415d, this.f25416f, this.f25417g);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(PainterNode painterNode) {
        boolean zO2 = painterNode.o2();
        boolean z2 = this.f25413b;
        boolean z3 = zO2 != z2 || (z2 && !Size.f(painterNode.n2().l(), this.f25412a.l()));
        painterNode.w2(this.f25412a);
        painterNode.x2(this.f25413b);
        painterNode.t2(this.f25414c);
        painterNode.v2(this.f25415d);
        painterNode.c(this.f25416f);
        painterNode.u2(this.f25417g);
        if (z3) {
            LayoutModifierNodeKt.b(painterNode);
        }
        DrawModifierNodeKt.a(painterNode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PainterElement)) {
            return false;
        }
        PainterElement painterElement = (PainterElement) obj;
        return Intrinsics.areEqual(this.f25412a, painterElement.f25412a) && this.f25413b == painterElement.f25413b && Intrinsics.areEqual(this.f25414c, painterElement.f25414c) && Intrinsics.areEqual(this.f25415d, painterElement.f25415d) && Float.compare(this.f25416f, painterElement.f25416f) == 0 && Intrinsics.areEqual(this.f25417g, painterElement.f25417g);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.f25412a.hashCode() * 31) + Boolean.hashCode(this.f25413b)) * 31) + this.f25414c.hashCode()) * 31) + this.f25415d.hashCode()) * 31) + Float.hashCode(this.f25416f)) * 31;
        ColorFilter colorFilter = this.f25417g;
        return iHashCode + (colorFilter == null ? 0 : colorFilter.hashCode());
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("paint");
        inspectorInfo.b().c("painter", this.f25412a);
        inspectorInfo.b().c("sizeToIntrinsics", Boolean.valueOf(this.f25413b));
        inspectorInfo.b().c("alignment", this.f25414c);
        inspectorInfo.b().c("contentScale", this.f25415d);
        inspectorInfo.b().c("alpha", Float.valueOf(this.f25416f));
        inspectorInfo.b().c("colorFilter", this.f25417g);
    }

    public String toString() {
        return "PainterElement(painter=" + this.f25412a + ", sizeToIntrinsics=" + this.f25413b + ", alignment=" + this.f25414c + ", contentScale=" + this.f25415d + ", alpha=" + this.f25416f + ", colorFilter=" + this.f25417g + ')';
    }
}
