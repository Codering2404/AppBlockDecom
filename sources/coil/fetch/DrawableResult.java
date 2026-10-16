package coil.fetch;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
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
public final class DrawableResult extends FetchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f55827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f55828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DataSource f55829c;

    public DrawableResult(Drawable drawable, boolean z2, DataSource dataSource) {
        super(null);
        this.f55827a = drawable;
        this.f55828b = z2;
        this.f55829c = dataSource;
    }

    public final DataSource a() {
        return this.f55829c;
    }

    public final Drawable b() {
        return this.f55827a;
    }

    public final boolean c() {
        return this.f55828b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawableResult)) {
            return false;
        }
        DrawableResult drawableResult = (DrawableResult) obj;
        return Intrinsics.areEqual(this.f55827a, drawableResult.f55827a) && this.f55828b == drawableResult.f55828b && this.f55829c == drawableResult.f55829c;
    }

    public int hashCode() {
        return (((this.f55827a.hashCode() * 31) + Boolean.hashCode(this.f55828b)) * 31) + this.f55829c.hashCode();
    }
}
