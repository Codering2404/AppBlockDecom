package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Dp;
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
final class GlowEdgeEffectCompat extends EdgeEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f4946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f4947b;

    public GlowEdgeEffectCompat(Context context) {
        super(context);
        this.f4946a = AndroidDensity_androidKt.a(context).M1(Dp.g(1));
    }

    public final void a(float f3) {
        float f4 = this.f4947b + f3;
        this.f4947b = f4;
        if (Math.abs(f4) > this.f4946a) {
            onRelease();
        }
    }

    @Override // android.widget.EdgeEffect
    public void onAbsorb(int i3) {
        this.f4947b = 0.0f;
        super.onAbsorb(i3);
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float f3, float f4) {
        this.f4947b = 0.0f;
        super.onPull(f3, f4);
    }

    @Override // android.widget.EdgeEffect
    public void onRelease() {
        this.f4947b = 0.0f;
        super.onRelease();
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float f3) {
        this.f4947b = 0.0f;
        super.onPull(f3);
    }
}
