package androidx.compose.foundation.content;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MediaType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f5187b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final MediaType f5188c = new MediaType("text/*");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final MediaType f5189d = new MediaType("text/plain");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final MediaType f5190e = new MediaType("text/html");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final MediaType f5191f = new MediaType("image/*");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final MediaType f5192g = new MediaType("*/*");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5193a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MediaType a() {
            return MediaType.f5192g;
        }

        public final MediaType b() {
            return MediaType.f5188c;
        }

        private Companion() {
        }
    }

    public MediaType(String str) {
        this.f5193a = str;
    }

    public final String c() {
        return this.f5193a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaType) {
            return Intrinsics.areEqual(this.f5193a, ((MediaType) obj).f5193a);
        }
        return false;
    }

    public int hashCode() {
        return this.f5193a.hashCode();
    }

    public String toString() {
        return "MediaType(representation='" + this.f5193a + "')";
    }
}
