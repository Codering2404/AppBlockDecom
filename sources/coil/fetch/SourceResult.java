package coil.fetch;

import coil.decode.DataSource;
import coil.decode.ImageSource;
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
public final class SourceResult extends FetchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageSource f55854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f55855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DataSource f55856c;

    public SourceResult(ImageSource imageSource, String str, DataSource dataSource) {
        super(null);
        this.f55854a = imageSource;
        this.f55855b = str;
        this.f55856c = dataSource;
    }

    public final DataSource a() {
        return this.f55856c;
    }

    public final String b() {
        return this.f55855b;
    }

    public final ImageSource c() {
        return this.f55854a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceResult)) {
            return false;
        }
        SourceResult sourceResult = (SourceResult) obj;
        return Intrinsics.areEqual(this.f55854a, sourceResult.f55854a) && Intrinsics.areEqual(this.f55855b, sourceResult.f55855b) && this.f55856c == sourceResult.f55856c;
    }

    public int hashCode() {
        int iHashCode = this.f55854a.hashCode() * 31;
        String str = this.f55855b;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f55856c.hashCode();
    }
}
