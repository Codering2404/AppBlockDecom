package androidx.compose.material3.carousel;

import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

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
public final class CarouselPageSize implements PageSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f21697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f21698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f21699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f21700d = SnapshotStateKt__SnapshotStateKt.e(Strategy.f21741m.a(), null, 2, null);

    public CarouselPageSize(Function2 function2, float f3, float f4) {
        this.f21697a = function2;
        this.f21698b = f3;
        this.f21699c = f4;
    }

    private final Strategy c() {
        return (Strategy) this.f21700d.getValue();
    }

    private final void d(Strategy strategy) {
        this.f21700d.setValue(strategy);
    }

    @Override // androidx.compose.foundation.pager.PageSize
    public int a(Density density, int i3, int i4) {
        float f3 = i3;
        float f4 = i4;
        d(new Strategy((KeylineList) this.f21697a.invoke(Float.valueOf(f3), Float.valueOf(f4)), f3, f4, this.f21698b, this.f21699c));
        return b().j() ? MathKt.d(b().e()) : i3;
    }

    public final Strategy b() {
        return c();
    }
}
