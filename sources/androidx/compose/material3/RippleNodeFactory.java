package androidx.compose.material3;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
final class RippleNodeFactory implements IndicationNodeFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f19387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f19388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorProducer f19389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19390d;

    public /* synthetic */ RippleNodeFactory(boolean z2, float f3, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, f3, j3);
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public DelegatableNode b(InteractionSource interactionSource) {
        ColorProducer colorProducer = this.f19389c;
        if (colorProducer == null) {
            colorProducer = new ColorProducer() { // from class: androidx.compose.material3.RippleNodeFactory$create$colorProducer$1
                @Override // androidx.compose.ui.graphics.ColorProducer
                public final long a() {
                    return this.f19391a.f19390d;
                }
            };
        }
        return new DelegatingThemeAwareRippleNode(interactionSource, this.f19387a, this.f19388b, colorProducer, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleNodeFactory)) {
            return false;
        }
        RippleNodeFactory rippleNodeFactory = (RippleNodeFactory) obj;
        if (this.f19387a == rippleNodeFactory.f19387a && Dp.i(this.f19388b, rippleNodeFactory.f19388b) && Intrinsics.areEqual(this.f19389c, rippleNodeFactory.f19389c)) {
            return Color.t(this.f19390d, rippleNodeFactory.f19390d);
        }
        return false;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.f19387a) * 31) + Dp.j(this.f19388b)) * 31;
        ColorProducer colorProducer = this.f19389c;
        return ((iHashCode + (colorProducer != null ? colorProducer.hashCode() : 0)) * 31) + Color.z(this.f19390d);
    }

    private RippleNodeFactory(boolean z2, float f3, ColorProducer colorProducer, long j3) {
        this.f19387a = z2;
        this.f19388b = f3;
        this.f19389c = colorProducer;
        this.f19390d = j3;
    }

    private RippleNodeFactory(boolean z2, float f3, long j3) {
        this(z2, f3, (ColorProducer) null, j3);
    }
}
