package androidx.window.core;

import android.graphics.Rect;
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
public final class Bounds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f54109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f54110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f54111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f54112d;

    public Bounds(int i3, int i4, int i5, int i6) {
        this.f54109a = i3;
        this.f54110b = i4;
        this.f54111c = i5;
        this.f54112d = i6;
        if (i3 > i5) {
            throw new IllegalArgumentException(("Left must be less than or equal to right, left: " + i3 + ", right: " + i5).toString());
        }
        if (i4 <= i6) {
            return;
        }
        throw new IllegalArgumentException(("top must be less than or equal to bottom, top: " + i4 + ", bottom: " + i6).toString());
    }

    public final int a() {
        return this.f54112d - this.f54110b;
    }

    public final int b() {
        return this.f54109a;
    }

    public final int c() {
        return this.f54110b;
    }

    public final int d() {
        return this.f54111c - this.f54109a;
    }

    public final boolean e() {
        return a() == 0 && d() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(Bounds.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.window.core.Bounds");
        Bounds bounds = (Bounds) obj;
        return this.f54109a == bounds.f54109a && this.f54110b == bounds.f54110b && this.f54111c == bounds.f54111c && this.f54112d == bounds.f54112d;
    }

    public final Rect f() {
        return new Rect(this.f54109a, this.f54110b, this.f54111c, this.f54112d);
    }

    public int hashCode() {
        return (((((this.f54109a * 31) + this.f54110b) * 31) + this.f54111c) * 31) + this.f54112d;
    }

    public String toString() {
        return Bounds.class.getSimpleName() + " { [" + this.f54109a + ',' + this.f54110b + ',' + this.f54111c + ',' + this.f54112d + "] }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Bounds(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        Intrinsics.checkNotNullParameter(rect, "rect");
    }
}
