package androidx.paging;

import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

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
final class MulticastedPagingData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f49909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PagingData f49910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ActiveFlowTracker f49911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CachedPageEventFlow f49912d;

    public MulticastedPagingData(CoroutineScope scope, PagingData parent, ActiveFlowTracker activeFlowTracker) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.f49909a = scope;
        this.f49910b = parent;
        this.f49911c = activeFlowTracker;
        CachedPageEventFlow cachedPageEventFlow = new CachedPageEventFlow(parent.b(), scope);
        if (activeFlowTracker != null) {
            activeFlowTracker.b(cachedPageEventFlow);
        }
        this.f49912d = cachedPageEventFlow;
    }

    public final PagingData b() {
        return new PagingData(FlowKt.U(FlowKt.W(this.f49912d.g(), new MulticastedPagingData$asPagingData$1(this, null)), new MulticastedPagingData$asPagingData$2(this, null)), this.f49910b.d(), this.f49910b.c(), new Function0<PageEvent.Insert<T>>() { // from class: androidx.paging.MulticastedPagingData$asPagingData$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final PageEvent.Insert invoke() {
                return this.f49917a.f49912d.f();
            }
        });
    }

    public final Object c(Continuation continuation) {
        this.f49912d.e();
        return Unit.f139807a;
    }

    public final ActiveFlowTracker d() {
        return this.f49911c;
    }
}
