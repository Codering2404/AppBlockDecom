package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
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
public final class DefaultIntrinsicMeasurable implements Measurable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntrinsicMeasurable f27063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IntrinsicMinMax f27064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IntrinsicWidthHeight f27065c;

    public DefaultIntrinsicMeasurable(IntrinsicMeasurable intrinsicMeasurable, IntrinsicMinMax intrinsicMinMax, IntrinsicWidthHeight intrinsicWidthHeight) {
        this.f27063a = intrinsicMeasurable;
        this.f27064b = intrinsicMinMax;
        this.f27065c = intrinsicWidthHeight;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int I(int i3) {
        return this.f27063a.I(i3);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int d0(int i3) {
        return this.f27063a.d0(i3);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int k0(int i3) {
        return this.f27063a.k0(i3);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int l0(int i3) {
        return this.f27063a.l0(i3);
    }

    @Override // androidx.compose.ui.layout.Measurable
    public Placeable n0(long j3) {
        if (this.f27065c == IntrinsicWidthHeight.f27072a) {
            return new FixedSizeIntrinsicsPlaceable(this.f27064b == IntrinsicMinMax.f27069b ? this.f27063a.l0(Constraints.k(j3)) : this.f27063a.k0(Constraints.k(j3)), Constraints.g(j3) ? Constraints.k(j3) : 32767);
        }
        return new FixedSizeIntrinsicsPlaceable(Constraints.h(j3) ? Constraints.l(j3) : 32767, this.f27064b == IntrinsicMinMax.f27069b ? this.f27063a.I(Constraints.l(j3)) : this.f27063a.d0(Constraints.l(j3)));
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public Object p() {
        return this.f27063a.p();
    }
}
