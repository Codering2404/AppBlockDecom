package androidx.compose.foundation.gestures;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.facebook.internal.ServerProtocol;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class TransformableElement extends ModifierNodeElement<TransformableNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransformableState f6303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f6304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f6305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f6306d;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TransformableNode create() {
        return new TransformableNode(this.f6303a, this.f6304b, this.f6305c, this.f6306d);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(TransformableNode transformableNode) {
        transformableNode.y2(this.f6303a, this.f6304b, this.f6305c, this.f6306d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TransformableElement.class != obj.getClass()) {
            return false;
        }
        TransformableElement transformableElement = (TransformableElement) obj;
        return Intrinsics.areEqual(this.f6303a, transformableElement.f6303a) && this.f6304b == transformableElement.f6304b && this.f6305c == transformableElement.f6305c && this.f6306d == transformableElement.f6306d;
    }

    public int hashCode() {
        return (((((this.f6303a.hashCode() * 31) + this.f6304b.hashCode()) * 31) + Boolean.hashCode(this.f6305c)) * 31) + Boolean.hashCode(this.f6306d);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("transformable");
        inspectorInfo.b().c(ServerProtocol.DIALOG_PARAM_STATE, this.f6303a);
        inspectorInfo.b().c("canPan", this.f6304b);
        inspectorInfo.b().c("enabled", Boolean.valueOf(this.f6306d));
        inspectorInfo.b().c("lockRotationOnZoomPan", Boolean.valueOf(this.f6305c));
    }
}
