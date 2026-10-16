package androidx.paging;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

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
public final class InvalidatingPagingSourceFactory<Key, Value> implements PagingSourceFactory<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f49825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantLock f49826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f49827c;

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public PagingSource invoke() {
        PagingSource pagingSource = (PagingSource) this.f49825a.invoke();
        ReentrantLock reentrantLock = this.f49826b;
        try {
            reentrantLock.lock();
            this.f49827c = CollectionsKt.plus((Collection<? extends PagingSource>) this.f49827c, pagingSource);
            Unit unit = Unit.f139807a;
            return pagingSource;
        } finally {
            reentrantLock.unlock();
        }
    }
}
