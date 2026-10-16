package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
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
final class BackgroundElement extends ModifierNodeElement<BackgroundNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f4615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Brush f4616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f4617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Shape f4618d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function1 f4619f;

    public /* synthetic */ BackgroundElement(long j3, Brush brush, float f3, Shape shape, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, brush, f3, shape, function1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BackgroundNode create() {
        return new BackgroundNode(this.f4615a, this.f4616b, this.f4617c, this.f4618d, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(BackgroundNode backgroundNode) {
        backgroundNode.s2(this.f4615a);
        backgroundNode.r2(this.f4616b);
        backgroundNode.c(this.f4617c);
        backgroundNode.I1(this.f4618d);
    }

    public boolean equals(Object obj) {
        BackgroundElement backgroundElement = obj instanceof BackgroundElement ? (BackgroundElement) obj : null;
        return backgroundElement != null && Color.t(this.f4615a, backgroundElement.f4615a) && Intrinsics.areEqual(this.f4616b, backgroundElement.f4616b) && this.f4617c == backgroundElement.f4617c && Intrinsics.areEqual(this.f4618d, backgroundElement.f4618d);
    }

    public int hashCode() {
        int iZ = Color.z(this.f4615a) * 31;
        Brush brush = this.f4616b;
        return ((((iZ + (brush != null ? brush.hashCode() : 0)) * 31) + Float.hashCode(this.f4617c)) * 31) + this.f4618d.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.f4619f.invoke(inspectorInfo);
    }

    public /* synthetic */ BackgroundElement(long j3, Brush brush, float f3, Shape shape, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Color.f25715b.k() : j3, (i3 & 2) != 0 ? null : brush, f3, shape, function1, null);
    }

    private BackgroundElement(long j3, Brush brush, float f3, Shape shape, Function1 function1) {
        this.f4615a = j3;
        this.f4616b = brush;
        this.f4617c = f3;
        this.f4618d = shape;
        this.f4619f = function1;
    }
}
