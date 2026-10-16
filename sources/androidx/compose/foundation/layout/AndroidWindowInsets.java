package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
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
public final class AndroidWindowInsets implements WindowInsets {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f6572d = SnapshotStateKt__SnapshotStateKt.e(Insets.f33963e, null, 2, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f6573e = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);

    public AndroidWindowInsets(int i3, String str) {
        this.f6570b = i3;
        this.f6571c = str;
    }

    private final void i(boolean z2) {
        this.f6573e.setValue(Boolean.valueOf(z2));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int a(Density density) {
        return e().f33965b;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int b(Density density, LayoutDirection layoutDirection) {
        return e().f33966c;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int c(Density density) {
        return e().f33967d;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int d(Density density, LayoutDirection layoutDirection) {
        return e().f33964a;
    }

    public final Insets e() {
        return (Insets) this.f6572d.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AndroidWindowInsets) && this.f6570b == ((AndroidWindowInsets) obj).f6570b;
    }

    public final int f() {
        return this.f6570b;
    }

    public final boolean g() {
        return ((Boolean) this.f6573e.getValue()).booleanValue();
    }

    public final void h(Insets insets) {
        this.f6572d.setValue(insets);
    }

    public int hashCode() {
        return this.f6570b;
    }

    public final void j(WindowInsetsCompat windowInsetsCompat, int i3) {
        if (i3 == 0 || (i3 & this.f6570b) != 0) {
            h(windowInsetsCompat.f(this.f6570b));
            i(windowInsetsCompat.s(this.f6570b));
        }
    }

    public String toString() {
        return this.f6571c + '(' + e().f33964a + ", " + e().f33965b + ", " + e().f33966c + ", " + e().f33967d + ')';
    }
}
