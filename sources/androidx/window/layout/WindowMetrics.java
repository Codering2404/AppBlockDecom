package androidx.window.layout;

import android.graphics.Rect;
import androidx.core.view.WindowInsetsCompat;
import androidx.window.core.Bounds;
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
public final class WindowMetrics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bounds f54366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WindowInsetsCompat f54367b;

    public WindowMetrics(Bounds _bounds, WindowInsetsCompat _windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(_bounds, "_bounds");
        Intrinsics.checkNotNullParameter(_windowInsetsCompat, "_windowInsetsCompat");
        this.f54366a = _bounds;
        this.f54367b = _windowInsetsCompat;
    }

    public final Rect a() {
        return this.f54366a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(WindowMetrics.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        WindowMetrics windowMetrics = (WindowMetrics) obj;
        return Intrinsics.areEqual(this.f54366a, windowMetrics.f54366a) && Intrinsics.areEqual(this.f54367b, windowMetrics.f54367b);
    }

    public int hashCode() {
        return (this.f54366a.hashCode() * 31) + this.f54367b.hashCode();
    }

    public String toString() {
        return "WindowMetrics( bounds=" + this.f54366a + ", windowInsetsCompat=" + this.f54367b + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WindowMetrics(Rect rect, WindowInsetsCompat windowInsetsCompat, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 2) != 0) {
            windowInsetsCompat = new WindowInsetsCompat.Builder().a();
            Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "Builder().build()");
        }
        this(rect, windowInsetsCompat);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WindowMetrics(Rect bounds, WindowInsetsCompat insets) {
        this(new Bounds(bounds), insets);
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(insets, "insets");
    }
}
