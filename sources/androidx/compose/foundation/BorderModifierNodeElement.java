package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.internal.ViewHierarchyConstants;
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
public final class BorderModifierNodeElement extends ModifierNodeElement<BorderModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f4765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Brush f4766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Shape f4767c;

    public /* synthetic */ BorderModifierNodeElement(float f3, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, brush, shape);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BorderModifierNode create() {
        return new BorderModifierNode(this.f4765a, this.f4766b, this.f4767c, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(BorderModifierNode borderModifierNode) {
        borderModifierNode.A2(this.f4765a);
        borderModifierNode.z2(this.f4766b);
        borderModifierNode.I1(this.f4767c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderModifierNodeElement)) {
            return false;
        }
        BorderModifierNodeElement borderModifierNodeElement = (BorderModifierNodeElement) obj;
        return Dp.i(this.f4765a, borderModifierNodeElement.f4765a) && Intrinsics.areEqual(this.f4766b, borderModifierNodeElement.f4766b) && Intrinsics.areEqual(this.f4767c, borderModifierNodeElement.f4767c);
    }

    public int hashCode() {
        return (((Dp.j(this.f4765a) * 31) + this.f4766b.hashCode()) * 31) + this.f4767c.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("border");
        inspectorInfo.b().c(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, Dp.d(this.f4765a));
        if (this.f4766b instanceof SolidColor) {
            inspectorInfo.b().c("color", Color.n(((SolidColor) this.f4766b).a()));
            inspectorInfo.e(Color.n(((SolidColor) this.f4766b).a()));
        } else {
            inspectorInfo.b().c("brush", this.f4766b);
        }
        inspectorInfo.b().c("shape", this.f4767c);
    }

    public String toString() {
        return "BorderModifierNodeElement(width=" + ((Object) Dp.k(this.f4765a)) + ", brush=" + this.f4766b + ", shape=" + this.f4767c + ')';
    }

    private BorderModifierNodeElement(float f3, Brush brush, Shape shape) {
        this.f4765a = f3;
        this.f4766b = brush;
        this.f4767c = shape;
    }
}
