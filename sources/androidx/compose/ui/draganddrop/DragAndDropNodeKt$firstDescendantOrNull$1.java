package androidx.compose.ui.draganddrop;

import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

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
public final class DragAndDropNodeKt$firstDescendantOrNull$1 extends Lambda implements Function1<TraversableNode, TraversableNode.Companion.TraverseDescendantsAction> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function1 f25370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f25371b;

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final TraversableNode.Companion.TraverseDescendantsAction invoke(TraversableNode traversableNode) {
        if (!((Boolean) this.f25370a.invoke(traversableNode)).booleanValue()) {
            return TraversableNode.Companion.TraverseDescendantsAction.f27641a;
        }
        this.f25371b.f140144a = traversableNode;
        return TraversableNode.Companion.TraverseDescendantsAction.f27643c;
    }
}
