package androidx.compose.foundation;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.facebook.internal.ServerProtocol;
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
public final class ScrollingLayoutElement extends ModifierNodeElement<ScrollNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollState f5175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f5176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5177c;

    public ScrollingLayoutElement(ScrollState scrollState, boolean z2, boolean z3) {
        this.f5175a = scrollState;
        this.f5176b = z2;
        this.f5177c = z3;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollNode create() {
        return new ScrollNode(this.f5175a, this.f5176b, this.f5177c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(ScrollNode scrollNode) {
        scrollNode.q2(this.f5175a);
        scrollNode.p2(this.f5176b);
        scrollNode.r2(this.f5177c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ScrollingLayoutElement)) {
            return false;
        }
        ScrollingLayoutElement scrollingLayoutElement = (ScrollingLayoutElement) obj;
        return Intrinsics.areEqual(this.f5175a, scrollingLayoutElement.f5175a) && this.f5176b == scrollingLayoutElement.f5176b && this.f5177c == scrollingLayoutElement.f5177c;
    }

    public int hashCode() {
        return (((this.f5175a.hashCode() * 31) + Boolean.hashCode(this.f5176b)) * 31) + Boolean.hashCode(this.f5177c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("scroll");
        inspectorInfo.b().c(ServerProtocol.DIALOG_PARAM_STATE, this.f5175a);
        inspectorInfo.b().c("reverseScrolling", Boolean.valueOf(this.f5176b));
        inspectorInfo.b().c("isVertical", Boolean.valueOf(this.f5177c));
    }
}
