package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

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
public final class Pager<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Flow f50302a;

    public Pager(PagingConfig config, Object obj, RemoteMediator remoteMediator, Function0 pagingSourceFactory) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pagingSourceFactory, "pagingSourceFactory");
        this.f50302a = new PageFetcher(pagingSourceFactory instanceof SuspendingPagingSourceFactory ? new Pager$flow$1(pagingSourceFactory) : new Pager$flow$2(pagingSourceFactory, null), obj, config, remoteMediator).i();
    }

    public final Flow a() {
        return this.f50302a;
    }

    public /* synthetic */ Pager(PagingConfig pagingConfig, Object obj, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(pagingConfig, (i3 & 2) != 0 ? null : obj, function0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Pager(PagingConfig config, Object obj, Function0 pagingSourceFactory) {
        this(config, obj, null, pagingSourceFactory);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pagingSourceFactory, "pagingSourceFactory");
    }
}
