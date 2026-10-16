package androidx.compose.material;

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
    private final boolean f13626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f13627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorProducer f13628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f13629d;

    public /* synthetic */ RippleNodeFactory(boolean z2, float f3, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, f3, j3);
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public DelegatableNode b(InteractionSource interactionSource) {
        ColorProducer colorProducer = this.f13628c;
        if (colorProducer == null) {
            colorProducer = new ColorProducer() { // from class: androidx.compose.material.RippleNodeFactory$create$colorProducer$1
                @Override // androidx.compose.ui.graphics.ColorProducer
                public final long a() {
                    return this.f13630a.f13629d;
                }
            };
        }
        return new DelegatingThemeAwareRippleNode(interactionSource, this.f13626a, this.f13627b, colorProducer, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleNodeFactory)) {
            return false;
        }
        RippleNodeFactory rippleNodeFactory = (RippleNodeFactory) obj;
        if (this.f13626a == rippleNodeFactory.f13626a && Dp.i(this.f13627b, rippleNodeFactory.f13627b) && Intrinsics.areEqual(this.f13628c, rippleNodeFactory.f13628c)) {
            return Color.t(this.f13629d, rippleNodeFactory.f13629d);
        }
        return false;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.f13626a) * 31) + Dp.j(this.f13627b)) * 31;
        ColorProducer colorProducer = this.f13628c;
        return ((iHashCode + (colorProducer != null ? colorProducer.hashCode() : 0)) * 31) + Color.z(this.f13629d);
    }

    private RippleNodeFactory(boolean z2, float f3, ColorProducer colorProducer, long j3) {
        this.f13626a = z2;
        this.f13627b = f3;
        this.f13628c = colorProducer;
        this.f13629d = j3;
    }

    private RippleNodeFactory(boolean z2, float f3, long j3) {
        this(z2, f3, (ColorProducer) null, j3);
    }
}
