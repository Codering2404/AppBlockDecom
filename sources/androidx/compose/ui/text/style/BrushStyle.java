package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class BrushStyle implements TextForegroundStyle {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ShaderBrush f29559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f29560c;

    public BrushStyle(ShaderBrush shaderBrush, float f3) {
        this.f29559b = shaderBrush;
        this.f29560c = f3;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public float a() {
        return this.f29560c;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public long d() {
        return Color.f25715b.k();
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public Brush e() {
        return this.f29559b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrushStyle)) {
            return false;
        }
        BrushStyle brushStyle = (BrushStyle) obj;
        return Intrinsics.areEqual(this.f29559b, brushStyle.f29559b) && Float.compare(this.f29560c, brushStyle.f29560c) == 0;
    }

    public final ShaderBrush f() {
        return this.f29559b;
    }

    public int hashCode() {
        return (this.f29559b.hashCode() * 31) + Float.hashCode(this.f29560c);
    }

    public String toString() {
        return "BrushStyle(value=" + this.f29559b + ", alpha=" + this.f29560c + ')';
    }
}
