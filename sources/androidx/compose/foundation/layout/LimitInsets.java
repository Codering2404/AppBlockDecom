package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
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
final class LimitInsets implements WindowInsets {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WindowInsets f7008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7009c;

    public /* synthetic */ LimitInsets(WindowInsets windowInsets, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsets, i3);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int a(Density density) {
        if (WindowInsetsSides.p(this.f7009c, WindowInsetsSides.f7284b.k())) {
            return this.f7008b.a(density);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int b(Density density, LayoutDirection layoutDirection) {
        if (WindowInsetsSides.p(this.f7009c, layoutDirection == LayoutDirection.f30001a ? WindowInsetsSides.f7284b.c() : WindowInsetsSides.f7284b.d())) {
            return this.f7008b.b(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int c(Density density) {
        if (WindowInsetsSides.p(this.f7009c, WindowInsetsSides.f7284b.e())) {
            return this.f7008b.c(density);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int d(Density density, LayoutDirection layoutDirection) {
        if (WindowInsetsSides.p(this.f7009c, layoutDirection == LayoutDirection.f30001a ? WindowInsetsSides.f7284b.a() : WindowInsetsSides.f7284b.b())) {
            return this.f7008b.d(density, layoutDirection);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitInsets)) {
            return false;
        }
        LimitInsets limitInsets = (LimitInsets) obj;
        return Intrinsics.areEqual(this.f7008b, limitInsets.f7008b) && WindowInsetsSides.o(this.f7009c, limitInsets.f7009c);
    }

    public int hashCode() {
        return (this.f7008b.hashCode() * 31) + WindowInsetsSides.q(this.f7009c);
    }

    public String toString() {
        return '(' + this.f7008b + " only " + ((Object) WindowInsetsSides.s(this.f7009c)) + ')';
    }

    private LimitInsets(WindowInsets windowInsets, int i3) {
        this.f7008b = windowInsets;
        this.f7009c = i3;
    }
}
