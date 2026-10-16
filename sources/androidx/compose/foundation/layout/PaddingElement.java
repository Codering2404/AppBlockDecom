package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
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
final class PaddingElement extends ModifierNodeElement<PaddingNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f7040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f7041d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function1 f7043g;

    public /* synthetic */ PaddingElement(float f3, float f4, float f5, float f6, boolean z2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, z2, function1);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PaddingNode create() {
        return new PaddingNode(this.f7038a, this.f7039b, this.f7040c, this.f7041d, this.f7042f, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(PaddingNode paddingNode) {
        paddingNode.s2(this.f7038a);
        paddingNode.t2(this.f7039b);
        paddingNode.q2(this.f7040c);
        paddingNode.p2(this.f7041d);
        paddingNode.r2(this.f7042f);
    }

    public boolean equals(Object obj) {
        PaddingElement paddingElement = obj instanceof PaddingElement ? (PaddingElement) obj : null;
        return paddingElement != null && Dp.i(this.f7038a, paddingElement.f7038a) && Dp.i(this.f7039b, paddingElement.f7039b) && Dp.i(this.f7040c, paddingElement.f7040c) && Dp.i(this.f7041d, paddingElement.f7041d) && this.f7042f == paddingElement.f7042f;
    }

    public int hashCode() {
        return (((((((Dp.j(this.f7038a) * 31) + Dp.j(this.f7039b)) * 31) + Dp.j(this.f7040c)) * 31) + Dp.j(this.f7041d)) * 31) + Boolean.hashCode(this.f7042f);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.f7043g.invoke(inspectorInfo);
    }

    private PaddingElement(float f3, float f4, float f5, float f6, boolean z2, Function1 function1) {
        this.f7038a = f3;
        this.f7039b = f4;
        this.f7040c = f5;
        this.f7041d = f6;
        this.f7042f = z2;
        this.f7043g = function1;
        boolean z3 = true;
        boolean z4 = f3 >= 0.0f || Float.isNaN(f3);
        float f7 = this.f7039b;
        boolean z5 = z4 & (f7 >= 0.0f || Float.isNaN(f7));
        float f8 = this.f7040c;
        boolean z6 = z5 & (f8 >= 0.0f || Float.isNaN(f8));
        float f9 = this.f7041d;
        if (f9 < 0.0f && !Float.isNaN(f9)) {
            z3 = false;
        }
        if (!z6 || !z3) {
            InlineClassHelperKt.a("Padding must be non-negative");
        }
    }
}
