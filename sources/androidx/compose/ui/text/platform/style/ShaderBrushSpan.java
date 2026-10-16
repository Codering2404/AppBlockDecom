package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ShaderBrush f29549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f29550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f29551c = SnapshotStateKt__SnapshotStateKt.e(Size.c(Size.f25617b.a()), null, 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final State f29552d = SnapshotStateKt.e(new Function0<Shader>() { // from class: androidx.compose.ui.text.platform.style.ShaderBrushSpan$shaderState$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Shader invoke() {
            if (this.f29553a.b() == 9205357640488583168L || Size.k(this.f29553a.b())) {
                return null;
            }
            return this.f29553a.a().mo220createShaderuvyYCjk(this.f29553a.b());
        }
    });

    public ShaderBrushSpan(ShaderBrush shaderBrush, float f3) {
        this.f29549a = shaderBrush;
        this.f29550b = f3;
    }

    public final ShaderBrush a() {
        return this.f29549a;
    }

    public final long b() {
        return ((Size) this.f29551c.getValue()).m();
    }

    public final void c(long j3) {
        this.f29551c.setValue(Size.c(j3));
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        AndroidTextPaint_androidKt.a(textPaint, this.f29550b);
        textPaint.setShader((Shader) this.f29552d.getValue());
    }
}
