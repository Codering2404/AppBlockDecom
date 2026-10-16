package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.TextUnit;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class Bullet implements AnnotatedString.Annotation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Shape f28674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f28675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f28676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Brush f28677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f28678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DrawStyle f28679f;

    public /* synthetic */ Bullet(Shape shape, long j3, long j4, Brush brush, float f3, DrawStyle drawStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(shape, j3, j4, brush, f3, drawStyle);
    }

    public final float a() {
        return this.f28678e;
    }

    public final Brush b() {
        return this.f28677d;
    }

    public final DrawStyle c() {
        return this.f28679f;
    }

    public final long d() {
        return this.f28676c;
    }

    public final Shape e() {
        return this.f28674a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Bullet)) {
            Bullet bullet = (Bullet) obj;
            return Intrinsics.areEqual(this.f28674a, bullet.f28674a) && TextUnit.e(this.f28675b, bullet.f28675b) && TextUnit.e(this.f28676c, bullet.f28676c) && Intrinsics.areEqual(this.f28677d, bullet.f28677d) && this.f28678e == bullet.f28678e && Intrinsics.areEqual(this.f28679f, bullet.f28679f);
        }
        return false;
    }

    public final long f() {
        return this.f28675b;
    }

    public int hashCode() {
        int iHashCode = ((((this.f28674a.hashCode() * 31) + TextUnit.i(this.f28675b)) * 31) + TextUnit.i(this.f28676c)) * 31;
        Brush brush = this.f28677d;
        return ((((iHashCode + (brush != null ? brush.hashCode() : 0)) * 31) + Float.hashCode(this.f28678e)) * 31) + this.f28679f.hashCode();
    }

    public String toString() {
        return "Bullet(shape=" + this.f28674a + ", size=" + ((Object) TextUnit.l(this.f28675b)) + ", padding=" + ((Object) TextUnit.l(this.f28676c)) + ", brush=" + this.f28677d + ", alpha=" + this.f28678e + ", drawStyle=" + this.f28679f + ')';
    }

    private Bullet(Shape shape, long j3, long j4, Brush brush, float f3, DrawStyle drawStyle) {
        this.f28674a = shape;
        this.f28675b = j3;
        this.f28676c = j4;
        this.f28677d = brush;
        this.f28678e = f3;
        this.f28679f = drawStyle;
    }
}
