package androidx.privacysandbox.ads.adservices.topics;

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
public final class Topic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f51365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f51366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f51367c;

    public Topic(long j3, long j4, int i3) {
        this.f51365a = j3;
        this.f51366b = j4;
        this.f51367c = i3;
    }

    public final long a() {
        return this.f51366b;
    }

    public final long b() {
        return this.f51365a;
    }

    public final int c() {
        return this.f51367c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Topic)) {
            return false;
        }
        Topic topic = (Topic) obj;
        return this.f51365a == topic.f51365a && this.f51366b == topic.f51366b && this.f51367c == topic.f51367c;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f51365a) * 31) + Long.hashCode(this.f51366b)) * 31) + Integer.hashCode(this.f51367c);
    }

    public String toString() {
        return "Topic { " + ("TaxonomyVersion=" + this.f51365a + ", ModelVersion=" + this.f51366b + ", TopicCode=" + this.f51367c + " }");
    }
}
