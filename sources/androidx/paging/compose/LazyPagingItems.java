package androidx.paging.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.AndroidUiDispatcher;
import androidx.paging.CombinedLoadStates;
import androidx.paging.ItemSnapshotList;
import androidx.paging.PagingData;
import androidx.paging.PagingDataEvent;
import androidx.paging.PagingDataPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;

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
public final class LazyPagingItems<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f50756f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Flow f50757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineContext f50758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyPagingItems$pagingDataPresenter$1 f50759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f50760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f50761e;

    public LazyPagingItems(Flow flow) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        this.f50757a = flow;
        final CoroutineContext coroutineContextB = AndroidUiDispatcher.f27887m.b();
        this.f50758b = coroutineContextB;
        final PagingData pagingData = flow instanceof SharedFlow ? (PagingData) CollectionsKt.firstOrNull(((SharedFlow) flow).b()) : null;
        PagingDataPresenter<T> pagingDataPresenter = new PagingDataPresenter<T>(coroutineContextB, pagingData) { // from class: androidx.paging.compose.LazyPagingItems$pagingDataPresenter$1
            @Override // androidx.paging.PagingDataPresenter
            public Object s(PagingDataEvent pagingDataEvent, Continuation continuation) {
                this.f50766m.l();
                return Unit.f139807a;
            }
        };
        this.f50759c = pagingDataPresenter;
        this.f50760d = SnapshotStateKt__SnapshotStateKt.e(pagingDataPresenter.u(), null, 2, null);
        CombinedLoadStates combinedLoadStates = (CombinedLoadStates) pagingDataPresenter.p().getValue();
        this.f50761e = SnapshotStateKt__SnapshotStateKt.e(combinedLoadStates == null ? new CombinedLoadStates(LazyPagingItemsKt.f50768b.f(), LazyPagingItemsKt.f50768b.e(), LazyPagingItemsKt.f50768b.d(), LazyPagingItemsKt.f50768b, null, 16, null) : combinedLoadStates, null, 2, null);
    }

    private final void j(ItemSnapshotList itemSnapshotList) {
        this.f50760d.setValue(itemSnapshotList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(CombinedLoadStates combinedLoadStates) {
        this.f50761e.setValue(combinedLoadStates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        j(u());
    }

    public final Object d(Continuation continuation) {
        Object objCollect = FlowKt.C(p()).collect(new FlowCollector() { // from class: androidx.paging.compose.LazyPagingItems$collectLoadState$2
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(CombinedLoadStates combinedLoadStates, Continuation continuation2) {
                this.f50762a.k(combinedLoadStates);
                return Unit.f139807a;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    public final Object e(Continuation continuation) {
        Object objL = FlowKt.l(this.f50757a, new LazyPagingItems$collectPagingData$2(this, null), continuation);
        return objL == IntrinsicsKt.f() ? objL : Unit.f139807a;
    }

    public final Object f(int i3) {
        o(i3);
        return h().get(i3);
    }

    public final int g() {
        return h().size();
    }

    public final ItemSnapshotList h() {
        return (ItemSnapshotList) this.f50760d.getValue();
    }

    public final Object i(int i3) {
        return h().get(i3);
    }
}
