package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
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
public abstract class ShaderBrush extends Brush {
    private long createdSize;
    private Shader internalShader;

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.f25617b.a();
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo218applyToPq9zytI(long j3, Paint paint, float f3) {
        Shader shaderMo220createShaderuvyYCjk = this.internalShader;
        if (shaderMo220createShaderuvyYCjk == null || !Size.f(this.createdSize, j3)) {
            if (Size.k(j3)) {
                shaderMo220createShaderuvyYCjk = null;
                this.internalShader = null;
                this.createdSize = Size.f25617b.a();
            } else {
                shaderMo220createShaderuvyYCjk = mo220createShaderuvyYCjk(j3);
                this.internalShader = shaderMo220createShaderuvyYCjk;
                this.createdSize = j3;
            }
        }
        long jD = paint.d();
        Color.Companion companion = Color.f25715b;
        if (!Color.t(jD, companion.a())) {
            paint.u(companion.a());
        }
        if (!Intrinsics.areEqual(paint.A(), shaderMo220createShaderuvyYCjk)) {
            paint.z(shaderMo220createShaderuvyYCjk);
        }
        if (paint.a() == f3) {
            return;
        }
        paint.c(f3);
    }

    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public abstract Shader mo220createShaderuvyYCjk(long j3);
}
