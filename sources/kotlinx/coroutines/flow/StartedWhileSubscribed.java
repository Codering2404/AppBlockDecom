package kotlinx.coroutines.flow;

import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class StartedWhileSubscribed implements SharingStarted {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f142222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f142223c;

    public StartedWhileSubscribed(long j3, long j4) {
        this.f142222b = j3;
        this.f142223c = j4;
        if (j3 < 0) {
            throw new IllegalArgumentException(("stopTimeout(" + j3 + " ms) cannot be negative").toString());
        }
        if (j4 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j4 + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow a(StateFlow stateFlow) {
        return FlowKt.u(FlowKt.y(FlowKt.m0(stateFlow, new StartedWhileSubscribed$command$1(this, null)), new StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StartedWhileSubscribed)) {
            return false;
        }
        StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
        return this.f142222b == startedWhileSubscribed.f142222b && this.f142223c == startedWhileSubscribed.f142223c;
    }

    public int hashCode() {
        return (Long.hashCode(this.f142222b) * 31) + Long.hashCode(this.f142223c);
    }

    public String toString() {
        List listCreateListBuilder = CollectionsKt.createListBuilder(2);
        if (this.f142222b > 0) {
            listCreateListBuilder.add("stopTimeout=" + this.f142222b + "ms");
        }
        if (this.f142223c < Long.MAX_VALUE) {
            listCreateListBuilder.add("replayExpiration=" + this.f142223c + "ms");
        }
        return CbYNFSEGaQj.JaQntiISzv + CollectionsKt.joinToString$default(CollectionsKt.build(listCreateListBuilder), null, null, null, 0, null, null, 63, null) + ')';
    }
}
