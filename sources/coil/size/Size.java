package coil.size;

import coil.size.Dimension;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Size {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f56176c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Size f56177d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Dimension f56178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Dimension f56179b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Dimension.Undefined undefined = Dimension.Undefined.f56164a;
        f56177d = new Size(undefined, undefined);
    }

    public Size(Dimension dimension, Dimension dimension2) {
        this.f56178a = dimension;
        this.f56179b = dimension2;
    }

    public final Dimension a() {
        return this.f56178a;
    }

    public final Dimension b() {
        return this.f56179b;
    }

    public final Dimension c() {
        return this.f56179b;
    }

    public final Dimension d() {
        return this.f56178a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return Intrinsics.areEqual(this.f56178a, size.f56178a) && Intrinsics.areEqual(this.f56179b, size.f56179b);
    }

    public int hashCode() {
        return (this.f56178a.hashCode() * 31) + this.f56179b.hashCode();
    }

    public String toString() {
        return "Size(width=" + this.f56178a + ", height=" + this.f56179b + ')';
    }
}
