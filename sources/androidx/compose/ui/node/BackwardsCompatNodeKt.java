package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class BackwardsCompatNodeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1 f27283a = new ModifierLocalReadScope() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1
        @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
        public Object u(ModifierLocal modifierLocal) {
            return modifierLocal.a().invoke();
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function1 f27284b = new Function1<BackwardsCompatNode, Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$onDrawCacheReadsChanged$1
        public final void c(BackwardsCompatNode backwardsCompatNode) {
            backwardsCompatNode.q2();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((BackwardsCompatNode) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Function1 f27285c = new Function1<BackwardsCompatNode, Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$updateModifierLocalConsumer$1
        public final void c(BackwardsCompatNode backwardsCompatNode) {
            backwardsCompatNode.u2();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((BackwardsCompatNode) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(BackwardsCompatNode backwardsCompatNode) {
        Modifier.Node nodeP = DelegatableNodeKt.o(backwardsCompatNode).u0().p();
        Intrinsics.checkNotNull(nodeP, "null cannot be cast to non-null type androidx.compose.ui.node.TailModifierNode");
        return ((TailModifierNode) nodeP).m2();
    }
}
