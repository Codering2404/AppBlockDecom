package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

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
public final class SuspendingPagingSourceFactory<Key, Value> implements Function0<PagingSource<Key, Value>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineDispatcher f50689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f50690b;

    public final Object d(Continuation continuation) {
        return BuildersKt.g(this.f50689a, new SuspendingPagingSourceFactory$create$2(this, null), continuation);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public PagingSource invoke() {
        return (PagingSource) this.f50690b.invoke();
    }
}
