package androidx.paging;

import android.view.ViewGroup;
import androidx.paging.LoadState;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
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
public abstract class LoadStateAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LoadState f49896i;

    public boolean g(LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        return (loadState instanceof LoadState.Loading) || (loadState instanceof LoadState.Error);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return g(this.f49896i) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i3) {
        return h(this.f49896i);
    }

    public int h(LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        return 0;
    }

    public abstract void i(RecyclerView.ViewHolder viewHolder, LoadState loadState);

    public abstract RecyclerView.ViewHolder j(ViewGroup viewGroup, LoadState loadState);

    public final void k(LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        if (Intrinsics.areEqual(this.f49896i, loadState)) {
            return;
        }
        boolean zG = g(this.f49896i);
        boolean zG2 = g(loadState);
        if (zG && !zG2) {
            notifyItemRemoved(0);
        } else if (zG2 && !zG) {
            notifyItemInserted(0);
        } else if (zG && zG2) {
            notifyItemChanged(0);
        }
        this.f49896i = loadState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        i(holder, this.f49896i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return j(parent, this.f49896i);
    }
}
