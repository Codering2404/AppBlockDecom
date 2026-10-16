package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
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
public final class BrushPainter extends Painter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Brush f26281h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f26282i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorFilter f26283j;

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean a(float f3) {
        this.f26282i = f3;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean b(ColorFilter colorFilter) {
        this.f26283j = colorFilter;
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BrushPainter) && Intrinsics.areEqual(this.f26281h, ((BrushPainter) obj).f26281h);
    }

    public int hashCode() {
        return this.f26281h.hashCode();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long l() {
        return this.f26281h.mo219getIntrinsicSizeNHjbRc();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void n(DrawScope drawScope) {
        DrawScope.k1(drawScope, this.f26281h, 0L, 0L, this.f26282i, null, this.f26283j, 0, 86, null);
    }

    public String toString() {
        return "BrushPainter(brush=" + this.f26281h + ')';
    }
}
