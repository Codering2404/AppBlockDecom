package androidx.compose.foundation.content;

import androidx.compose.foundation.content.internal.DragAndDropRequestPermission_androidKt;
import androidx.compose.foundation.content.internal.DynamicReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.content.internal.ReceiveContentDragAndDropNode_androidKt;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ReceiveContentNode extends DelegatingNode implements ModifierLocalModifierNode, CompositionLocalConsumerModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ReceiveContentListener f5197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReceiveContentConfiguration f5198d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ModifierLocalMap f5199f;

    public ReceiveContentNode(ReceiveContentListener receiveContentListener) {
        this.f5197c = receiveContentListener;
        DynamicReceiveContentConfiguration dynamicReceiveContentConfiguration = new DynamicReceiveContentConfiguration(this);
        this.f5198d = dynamicReceiveContentConfiguration;
        this.f5199f = ModifierLocalModifierNodeKt.b(TuplesKt.a(ReceiveContentConfigurationKt.a(), dynamicReceiveContentConfiguration));
        m2(ReceiveContentDragAndDropNode_androidKt.a(dynamicReceiveContentConfiguration, new Function1<DragAndDropEvent, Unit>() { // from class: androidx.compose.foundation.content.ReceiveContentNode.1
            {
                super(1);
            }

            public final void c(DragAndDropEvent dragAndDropEvent) {
                DragAndDropRequestPermission_androidKt.b(ReceiveContentNode.this, dragAndDropEvent);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((DragAndDropEvent) obj);
                return Unit.f139807a;
            }
        }));
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap n0() {
        return this.f5199f;
    }

    public final ReceiveContentListener s2() {
        return this.f5197c;
    }

    public final void t2(ReceiveContentListener receiveContentListener) {
        this.f5197c = receiveContentListener;
    }
}
