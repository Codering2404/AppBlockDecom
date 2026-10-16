package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Stroke extends DrawStyle {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f26099f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f26100g = StrokeCap.f25935b.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f26101h = StrokeJoin.f25940b.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f26102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f26103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f26104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f26105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PathEffect f26106e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return Stroke.f26100g;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Stroke(float f3, float f4, int i3, int i4, PathEffect pathEffect, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, i3, i4, pathEffect);
    }

    public final int b() {
        return this.f26104c;
    }

    public final int c() {
        return this.f26105d;
    }

    public final float d() {
        return this.f26103b;
    }

    public final PathEffect e() {
        return this.f26106e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stroke)) {
            return false;
        }
        Stroke stroke = (Stroke) obj;
        return this.f26102a == stroke.f26102a && this.f26103b == stroke.f26103b && StrokeCap.g(this.f26104c, stroke.f26104c) && StrokeJoin.g(this.f26105d, stroke.f26105d) && Intrinsics.areEqual(this.f26106e, stroke.f26106e);
    }

    public final float f() {
        return this.f26102a;
    }

    public int hashCode() {
        int iHashCode = ((((((Float.hashCode(this.f26102a) * 31) + Float.hashCode(this.f26103b)) * 31) + StrokeCap.h(this.f26104c)) * 31) + StrokeJoin.h(this.f26105d)) * 31;
        PathEffect pathEffect = this.f26106e;
        return iHashCode + (pathEffect != null ? pathEffect.hashCode() : 0);
    }

    public String toString() {
        return "Stroke(width=" + this.f26102a + ", miter=" + this.f26103b + ", cap=" + ((Object) StrokeCap.i(this.f26104c)) + ", join=" + ((Object) StrokeJoin.i(this.f26105d)) + ", pathEffect=" + this.f26106e + ')';
    }

    public /* synthetic */ Stroke(float f3, float f4, int i3, int i4, PathEffect pathEffect, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0.0f : f3, (i5 & 2) != 0 ? 4.0f : f4, (i5 & 4) != 0 ? f26100g : i3, (i5 & 8) != 0 ? f26101h : i4, (i5 & 16) != 0 ? null : pathEffect, null);
    }

    private Stroke(float f3, float f4, int i3, int i4, PathEffect pathEffect) {
        super(null);
        this.f26102a = f3;
        this.f26103b = f4;
        this.f26104c = i3;
        this.f26105d = i4;
        this.f26106e = pathEffect;
    }
}
