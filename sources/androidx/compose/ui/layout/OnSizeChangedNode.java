package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
final class OnSizeChangedNode extends Modifier.Node implements LayoutAwareModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function1 f27193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f27194b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f27195c;

    public OnSizeChangedNode(Function1 function1) {
        this.f27193a = function1;
        long j3 = Integer.MIN_VALUE;
        this.f27195c = IntSize.c((j3 & 4294967295L) | (j3 << 32));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.f27194b;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void m(long j3) {
        if (IntSize.e(this.f27195c, j3)) {
            return;
        }
        this.f27193a.invoke(IntSize.b(j3));
        this.f27195c = j3;
    }

    public final void m2(Function1 function1) {
        this.f27193a = function1;
        long j3 = Integer.MIN_VALUE;
        this.f27195c = IntSize.c((j3 & 4294967295L) | (j3 << 32));
    }
}
