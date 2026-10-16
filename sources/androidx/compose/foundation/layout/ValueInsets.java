package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
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
public final class ValueInsets implements WindowInsets {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f7169c;

    public ValueInsets(InsetsValues insetsValues, String str) {
        this.f7168b = str;
        this.f7169c = SnapshotStateKt__SnapshotStateKt.e(insetsValues, null, 2, null);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int a(Density density) {
        return e().d();
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int b(Density density, LayoutDirection layoutDirection) {
        return e().c();
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int c(Density density) {
        return e().a();
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int d(Density density, LayoutDirection layoutDirection) {
        return e().b();
    }

    public final InsetsValues e() {
        return (InsetsValues) this.f7169c.getValue();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ValueInsets) {
            return Intrinsics.areEqual(e(), ((ValueInsets) obj).e());
        }
        return false;
    }

    public final void f(InsetsValues insetsValues) {
        this.f7169c.setValue(insetsValues);
    }

    public int hashCode() {
        return this.f7168b.hashCode();
    }

    public String toString() {
        return this.f7168b + "(left=" + e().b() + ", top=" + e().d() + ", right=" + e().c() + ", bottom=" + e().a() + ')';
    }
}
