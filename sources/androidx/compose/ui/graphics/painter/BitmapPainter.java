package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
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
public final class BitmapPainter extends Painter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImageBitmap f26274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f26275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f26276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f26277k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f26278l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f26279m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ColorFilter f26280n;

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, j3, j4);
    }

    private final long p(long j3, long j4) {
        int i3;
        int i4;
        if (IntOffset.k(j3) < 0 || IntOffset.l(j3) < 0 || (i3 = (int) (j4 >> 32)) < 0 || (i4 = (int) (4294967295L & j4)) < 0 || i3 > this.f26274h.getWidth() || i4 > this.f26274h.getHeight()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        return j4;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean a(float f3) {
        this.f26279m = f3;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean b(ColorFilter colorFilter) {
        this.f26280n = colorFilter;
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapPainter)) {
            return false;
        }
        BitmapPainter bitmapPainter = (BitmapPainter) obj;
        return Intrinsics.areEqual(this.f26274h, bitmapPainter.f26274h) && IntOffset.j(this.f26275i, bitmapPainter.f26275i) && IntSize.e(this.f26276j, bitmapPainter.f26276j) && FilterQuality.e(this.f26277k, bitmapPainter.f26277k);
    }

    public int hashCode() {
        return (((((this.f26274h.hashCode() * 31) + IntOffset.m(this.f26275i)) * 31) + IntSize.h(this.f26276j)) * 31) + FilterQuality.f(this.f26277k);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long l() {
        return IntSizeKt.e(this.f26278l);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void n(DrawScope drawScope) {
        DrawScope.W(drawScope, this.f26274h, this.f26275i, this.f26276j, 0L, IntSize.c((((long) Math.round(Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)))) & 4294967295L) | (((long) Math.round(Float.intBitsToFloat((int) (drawScope.b() >> 32)))) << 32)), this.f26279m, null, this.f26280n, 0, this.f26277k, 328, null);
    }

    public final void o(int i3) {
        this.f26277k = i3;
    }

    public String toString() {
        return "BitmapPainter(image=" + this.f26274h + ", srcOffset=" + ((Object) IntOffset.p(this.f26275i)) + ", srcSize=" + ((Object) IntSize.i(this.f26276j)) + ", filterQuality=" + ((Object) FilterQuality.g(this.f26277k)) + ')';
    }

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j3, long j4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, (i3 & 2) != 0 ? IntOffset.f29988b.b() : j3, (i3 & 4) != 0 ? IntSize.c((((long) imageBitmap.getHeight()) & 4294967295L) | (((long) imageBitmap.getWidth()) << 32)) : j4, null);
    }

    private BitmapPainter(ImageBitmap imageBitmap, long j3, long j4) {
        this.f26274h = imageBitmap;
        this.f26275i = j3;
        this.f26276j = j4;
        this.f26277k = FilterQuality.f25743b.a();
        this.f26278l = p(j3, j4);
        this.f26279m = 1.0f;
    }
}
