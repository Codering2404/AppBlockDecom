package androidx.privacysandbox.ads.adservices.topics;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class GetTopicsResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f51362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f51363b;

    public GetTopicsResponse(List topics, List encryptedTopics) {
        Intrinsics.checkNotNullParameter(topics, "topics");
        Intrinsics.checkNotNullParameter(encryptedTopics, "encryptedTopics");
        this.f51362a = topics;
        this.f51363b = encryptedTopics;
    }

    public final List a() {
        return this.f51362a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsResponse)) {
            return false;
        }
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        return this.f51362a.size() == getTopicsResponse.f51362a.size() && this.f51363b.size() == getTopicsResponse.f51363b.size() && Intrinsics.areEqual(new HashSet(this.f51362a), new HashSet(getTopicsResponse.f51362a)) && Intrinsics.areEqual(new HashSet(this.f51363b), new HashSet(getTopicsResponse.f51363b));
    }

    public int hashCode() {
        return Objects.hash(this.f51362a, this.f51363b);
    }

    public String toString() {
        return "GetTopicsResponse: Topics=" + this.f51362a + ", EncryptedTopics=" + this.f51363b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetTopicsResponse(List topics) {
        this(topics, CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(topics, "topics");
    }
}
