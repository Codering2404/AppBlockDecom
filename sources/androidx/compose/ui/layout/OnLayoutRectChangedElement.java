package androidx.compose.ui.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.sun.jna.Callback;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OnLayoutRectChangedElement extends ModifierNodeElement<OnLayoutRectChangedNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f27183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f27184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f27185c;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public OnLayoutRectChangedNode create() {
        return new OnLayoutRectChangedNode(this.f27183a, this.f27184b, this.f27185c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(OnLayoutRectChangedNode onLayoutRectChangedNode) {
        onLayoutRectChangedNode.p2(this.f27183a);
        onLayoutRectChangedNode.o2(this.f27184b);
        onLayoutRectChangedNode.n2(this.f27185c);
        onLayoutRectChangedNode.m2();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnLayoutRectChangedElement)) {
            return false;
        }
        OnLayoutRectChangedElement onLayoutRectChangedElement = (OnLayoutRectChangedElement) obj;
        return this.f27183a == onLayoutRectChangedElement.f27183a && this.f27184b == onLayoutRectChangedElement.f27184b && Intrinsics.areEqual(this.f27185c, onLayoutRectChangedElement.f27185c);
    }

    public int hashCode() {
        return (((Long.hashCode(this.f27183a) * 31) + Long.hashCode(this.f27184b)) * 31) + this.f27185c.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("onRectChanged");
        inspectorInfo.b().c("throttleMillis", Long.valueOf(this.f27183a));
        inspectorInfo.b().c("debounceMillis", Long.valueOf(this.f27184b));
        inspectorInfo.b().c(Callback.METHOD_NAME, this.f27185c);
    }

    public String toString() {
        return "OnLayoutRectChangedElement(throttleMillis=" + this.f27183a + FptyjHFU.KLgJMkGTsJAhR + this.f27184b + ", callback=" + this.f27185c + ')';
    }
}
