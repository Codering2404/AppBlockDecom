package androidx.compose.material3.carousel;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

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
public final class CarouselItemInfoImpl implements CarouselItemInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableFloatState f21620a = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableFloatState f21621b = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableFloatState f21622c = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f21623d = SnapshotStateKt__SnapshotStateKt.e(Rect.f25601e.a(), null, 2, null);

    @Override // androidx.compose.material3.carousel.CarouselItemInfo
    public Rect a() {
        return b();
    }

    public final Rect b() {
        return (Rect) this.f21623d.getValue();
    }

    public final void c(Rect rect) {
        this.f21623d.setValue(rect);
    }

    public final void d(float f3) {
        this.f21622c.s(f3);
    }

    public final void e(float f3) {
        this.f21621b.s(f3);
    }

    public final void f(float f3) {
        this.f21620a.s(f3);
    }
}
