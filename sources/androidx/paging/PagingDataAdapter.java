package androidx.paging;

import androidx.paging.LoadState;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class PagingDataAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f50327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AsyncPagingDataDiffer f50328j;

    /* JADX INFO: renamed from: androidx.paging.PagingDataAdapter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class AnonymousClass1 extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PagingDataAdapter f50329b;

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i4) {
            PagingDataAdapter.g(this.f50329b);
            this.f50329b.unregisterAdapterDataObserver(this);
            super.onItemRangeInserted(i3, i4);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PagingDataAdapter$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class AnonymousClass2 implements Function1<CombinedLoadStates, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f50330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PagingDataAdapter f50331b;

        public void c(CombinedLoadStates loadStates) {
            Intrinsics.checkNotNullParameter(loadStates, "loadStates");
            if (this.f50330a) {
                this.f50330a = false;
            } else if (loadStates.e().f() instanceof LoadState.NotLoading) {
                PagingDataAdapter.g(this.f50331b);
                this.f50331b.i(this);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((CombinedLoadStates) obj);
            return Unit.f139807a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(PagingDataAdapter pagingDataAdapter) {
        if (pagingDataAdapter.getStateRestorationPolicy() != RecyclerView.Adapter.StateRestorationPolicy.PREVENT || pagingDataAdapter.f50327i) {
            return;
        }
        pagingDataAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.ALLOW);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f50328j.l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i3) {
        return super.getItemId(i3);
    }

    public final void i(Function1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f50328j.o(listener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z2) {
        throw new UnsupportedOperationException("Stable ids are unsupported on PagingDataAdapter.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.f50327i = true;
        super.setStateRestorationPolicy(strategy);
    }
}
