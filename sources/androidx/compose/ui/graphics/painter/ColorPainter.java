package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class ColorPainter extends Painter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f26284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f26285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorFilter f26286j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f26287k;

    public /* synthetic */ ColorPainter(long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean a(float f3) {
        this.f26285i = f3;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean b(ColorFilter colorFilter) {
        this.f26286j = colorFilter;
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ColorPainter) && Color.t(this.f26284h, ((ColorPainter) obj).f26284h);
    }

    public int hashCode() {
        return Color.z(this.f26284h);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long l() {
        return this.f26287k;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void n(DrawScope drawScope) {
        DrawScope.L1(drawScope, this.f26284h, 0L, 0L, this.f26285i, null, this.f26286j, 0, 86, null);
    }

    public String toString() {
        return "ColorPainter(color=" + ((Object) Color.A(this.f26284h)) + ')';
    }

    private ColorPainter(long j3) {
        this.f26284h = j3;
        this.f26285i = 1.0f;
        this.f26287k = Size.f25617b.a();
    }
}
