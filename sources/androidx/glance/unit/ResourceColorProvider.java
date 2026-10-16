package androidx.glance.unit;

import android.content.Context;
import androidx.compose.ui.graphics.ColorKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ResourceColorProvider implements ColorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f39792a;

    public ResourceColorProvider(int i3) {
        this.f39792a = i3;
    }

    @Override // androidx.glance.unit.ColorProvider
    public long a(Context context) {
        return ColorKt.b(ColorProviderApi23Impl.f39785a.a(context, this.f39792a));
    }

    public final int b() {
        return this.f39792a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ResourceColorProvider) && this.f39792a == ((ResourceColorProvider) obj).f39792a;
    }

    public int hashCode() {
        return Integer.hashCode(this.f39792a);
    }

    public String toString() {
        return "ResourceColorProvider(resId=" + this.f39792a + ')';
    }
}
