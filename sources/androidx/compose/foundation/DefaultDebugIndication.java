package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
final class DefaultDebugIndication implements IndicationNodeFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DefaultDebugIndication f4890a = new DefaultDebugIndication();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class DefaultDebugIndicationInstance extends Modifier.Node implements DrawModifierNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InteractionSource f4891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f4892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4894d;

        public DefaultDebugIndicationInstance(InteractionSource interactionSource) {
            this.f4891a = interactionSource;
        }

        @Override // androidx.compose.ui.node.DrawModifierNode
        public void draw(ContentDrawScope contentDrawScope) {
            contentDrawScope.i2();
            if (this.f4892b) {
                DrawScope.L1(contentDrawScope, Color.r(Color.f25715b.a(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0L, contentDrawScope.b(), 0.0f, null, null, 0, 122, null);
            } else if (this.f4893c || this.f4894d) {
                DrawScope.L1(contentDrawScope, Color.r(Color.f25715b.a(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), 0L, contentDrawScope.b(), 0.0f, null, null, 0, 122, null);
            }
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onAttach() {
            BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(this, null), 3, null);
        }
    }

    private DefaultDebugIndication() {
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public DelegatableNode b(InteractionSource interactionSource) {
        return new DefaultDebugIndicationInstance(interactionSource);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public int hashCode() {
        return -1;
    }
}
