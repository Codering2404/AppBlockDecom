package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import d.qFm.sECyKyO;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class FixedIntInsets implements WindowInsets {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f6780e;

    public FixedIntInsets(int i3, int i4, int i5, int i6) {
        this.f6777b = i3;
        this.f6778c = i4;
        this.f6779d = i5;
        this.f6780e = i6;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int a(Density density) {
        return this.f6778c;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int b(Density density, LayoutDirection layoutDirection) {
        return this.f6779d;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int c(Density density) {
        return this.f6780e;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int d(Density density, LayoutDirection layoutDirection) {
        return this.f6777b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedIntInsets)) {
            return false;
        }
        FixedIntInsets fixedIntInsets = (FixedIntInsets) obj;
        return this.f6777b == fixedIntInsets.f6777b && this.f6778c == fixedIntInsets.f6778c && this.f6779d == fixedIntInsets.f6779d && this.f6780e == fixedIntInsets.f6780e;
    }

    public int hashCode() {
        return (((((this.f6777b * 31) + this.f6778c) * 31) + this.f6779d) * 31) + this.f6780e;
    }

    public String toString() {
        return wgbAZXYjrv.DDaiHMWHzgZ + this.f6777b + ", top=" + this.f6778c + sECyKyO.eMmqkLrJFZR + this.f6779d + ", bottom=" + this.f6780e + ')';
    }
}
