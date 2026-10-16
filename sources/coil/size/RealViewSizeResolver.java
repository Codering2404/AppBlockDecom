package coil.size;

import android.view.View;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class RealViewSizeResolver<T extends View> implements ViewSizeResolver<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f56171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f56172b;

    public RealViewSizeResolver(View view, boolean z2) {
        this.f56171a = view;
        this.f56172b = z2;
    }

    @Override // coil.size.ViewSizeResolver
    public View a() {
        return this.f56171a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealViewSizeResolver)) {
            return false;
        }
        RealViewSizeResolver realViewSizeResolver = (RealViewSizeResolver) obj;
        return Intrinsics.areEqual(a(), realViewSizeResolver.a()) && f() == realViewSizeResolver.f();
    }

    @Override // coil.size.ViewSizeResolver
    public boolean f() {
        return this.f56172b;
    }

    public int hashCode() {
        return (a().hashCode() * 31) + Boolean.hashCode(f());
    }
}
