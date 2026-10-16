package androidx.compose.ui.node;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.layout.MeasurePolicy;
import kotlin.Metadata;

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
public final class IntrinsicsPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutNode f27337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f27338b;

    public IntrinsicsPolicy(LayoutNode layoutNode, MeasurePolicy measurePolicy) {
        this.f27337a = layoutNode;
        this.f27338b = SnapshotStateKt__SnapshotStateKt.e(measurePolicy, null, 2, null);
    }

    private final MeasurePolicy a() {
        return (MeasurePolicy) this.f27338b.getValue();
    }

    private final void j(MeasurePolicy measurePolicy) {
        this.f27338b.setValue(measurePolicy);
    }

    public final int b(int i3) {
        return a().maxIntrinsicHeight(this.f27337a.x0(), this.f27337a.N(), i3);
    }

    public final int c(int i3) {
        return a().maxIntrinsicWidth(this.f27337a.x0(), this.f27337a.N(), i3);
    }

    public final int d(int i3) {
        return a().maxIntrinsicHeight(this.f27337a.x0(), this.f27337a.M(), i3);
    }

    public final int e(int i3) {
        return a().maxIntrinsicWidth(this.f27337a.x0(), this.f27337a.M(), i3);
    }

    public final int f(int i3) {
        return a().minIntrinsicHeight(this.f27337a.x0(), this.f27337a.N(), i3);
    }

    public final int g(int i3) {
        return a().minIntrinsicWidth(this.f27337a.x0(), this.f27337a.N(), i3);
    }

    public final int h(int i3) {
        return a().minIntrinsicHeight(this.f27337a.x0(), this.f27337a.M(), i3);
    }

    public final int i(int i3) {
        return a().minIntrinsicWidth(this.f27337a.x0(), this.f27337a.M(), i3);
    }

    public final void k(MeasurePolicy measurePolicy) {
        j(measurePolicy);
    }
}
