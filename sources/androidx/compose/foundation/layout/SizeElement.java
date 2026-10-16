package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
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
final class SizeElement extends ModifierNodeElement<SizeNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f7110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f7111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f7112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f7113d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f7114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function1 f7115g;

    public /* synthetic */ SizeElement(float f3, float f4, float f5, float f6, boolean z2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, z2, function1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SizeNode create() {
        return new SizeNode(this.f7110a, this.f7111b, this.f7112c, this.f7113d, this.f7114f, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(SizeNode sizeNode) {
        sizeNode.r2(this.f7110a);
        sizeNode.q2(this.f7111b);
        sizeNode.p2(this.f7112c);
        sizeNode.o2(this.f7113d);
        sizeNode.n2(this.f7114f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeElement)) {
            return false;
        }
        SizeElement sizeElement = (SizeElement) obj;
        return Dp.i(this.f7110a, sizeElement.f7110a) && Dp.i(this.f7111b, sizeElement.f7111b) && Dp.i(this.f7112c, sizeElement.f7112c) && Dp.i(this.f7113d, sizeElement.f7113d) && this.f7114f == sizeElement.f7114f;
    }

    public int hashCode() {
        return (((((((Dp.j(this.f7110a) * 31) + Dp.j(this.f7111b)) * 31) + Dp.j(this.f7112c)) * 31) + Dp.j(this.f7113d)) * 31) + Boolean.hashCode(this.f7114f);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.f7115g.invoke(inspectorInfo);
    }

    public /* synthetic */ SizeElement(float f3, float f4, float f5, float f6, boolean z2, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Dp.f29970b.c() : f3, (i3 & 2) != 0 ? Dp.f29970b.c() : f4, (i3 & 4) != 0 ? Dp.f29970b.c() : f5, (i3 & 8) != 0 ? Dp.f29970b.c() : f6, z2, function1, null);
    }

    private SizeElement(float f3, float f4, float f5, float f6, boolean z2, Function1 function1) {
        this.f7110a = f3;
        this.f7111b = f4;
        this.f7112c = f5;
        this.f7113d = f6;
        this.f7114f = z2;
        this.f7115g = function1;
    }
}
