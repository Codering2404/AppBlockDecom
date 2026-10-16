package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.math.MathKt;

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
public final class EdgeEffectCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EdgeEffectCompat f4901a = new EdgeEffectCompat();

    private EdgeEffectCompat() {
    }

    public final float a(EdgeEffect edgeEffect, float f3, float f4, Density density) {
        if (EdgeEffectCompat_androidKt.b(density, f3) > c(edgeEffect) * f4) {
            return 0.0f;
        }
        d(edgeEffect, MathKt.d(f3));
        return f3;
    }

    public final EdgeEffect b(Context context) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.f4614a.a(context, null) : new GlowEdgeEffectCompat(context);
    }

    public final float c(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.f4614a.b(edgeEffect);
        }
        return 0.0f;
    }

    public final void d(EdgeEffect edgeEffect, int i3) {
        if (Build.VERSION.SDK_INT >= 31) {
            edgeEffect.onAbsorb(i3);
        } else if (edgeEffect.isFinished()) {
            edgeEffect.onAbsorb(i3);
        }
    }

    public final float e(EdgeEffect edgeEffect, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.f4614a.c(edgeEffect, f3, f4);
        }
        edgeEffect.onPull(f3, f4);
        return f3;
    }

    public final void f(EdgeEffect edgeEffect, float f3) {
        if (edgeEffect instanceof GlowEdgeEffectCompat) {
            ((GlowEdgeEffectCompat) edgeEffect).a(f3);
        } else {
            edgeEffect.onRelease();
        }
    }
}
