package androidx.compose.ui.graphics;

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
public final class BlurEffect extends RenderEffect {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RenderEffect f25700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f25701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f25702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f25703e;

    public /* synthetic */ BlurEffect(RenderEffect renderEffect, float f3, float f4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(renderEffect, f3, f4, i3);
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    protected android.graphics.RenderEffect b() {
        return RenderEffectVerificationHelper.f25880a.a(this.f25700b, this.f25701c, this.f25702d, this.f25703e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlurEffect)) {
            return false;
        }
        BlurEffect blurEffect = (BlurEffect) obj;
        return this.f25701c == blurEffect.f25701c && this.f25702d == blurEffect.f25702d && TileMode.g(this.f25703e, blurEffect.f25703e) && Intrinsics.areEqual(this.f25700b, blurEffect.f25700b);
    }

    public int hashCode() {
        RenderEffect renderEffect = this.f25700b;
        return ((((((renderEffect != null ? renderEffect.hashCode() : 0) * 31) + Float.hashCode(this.f25701c)) * 31) + Float.hashCode(this.f25702d)) * 31) + TileMode.h(this.f25703e);
    }

    public String toString() {
        return "BlurEffect(renderEffect=" + this.f25700b + ", radiusX=" + this.f25701c + ", radiusY=" + this.f25702d + ", edgeTreatment=" + ((Object) TileMode.i(this.f25703e)) + ')';
    }

    private BlurEffect(RenderEffect renderEffect, float f3, float f4, int i3) {
        super(null);
        this.f25700b = renderEffect;
        this.f25701c = f3;
        this.f25702d = f4;
        this.f25703e = i3;
    }
}
