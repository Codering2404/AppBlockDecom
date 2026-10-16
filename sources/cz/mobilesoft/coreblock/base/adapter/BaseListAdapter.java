package cz.mobilesoft.coreblock.base.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseListAdapter<T> extends ListAdapter<T, BaseViewHolder<T>> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f96331k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class BaseViewHolderImp extends BaseViewHolder<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseListAdapter f96334b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolderImp(BaseListAdapter baseListAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.f96334b = baseListAdapter;
        }

        @Override // cz.mobilesoft.coreblock.base.adapter.BaseViewHolder
        public void b(Object obj, int i3) {
            BaseListAdapter baseListAdapter = this.f96334b;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            baseListAdapter.j(itemView, obj, i3, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseListAdapter(int i3, final Function2 itemsSame, final Function2 contentsSame) {
        super(new DiffUtil.ItemCallback<T>() { // from class: cz.mobilesoft.coreblock.base.adapter.BaseListAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean a(Object old, Object obj) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(obj, "new");
                return ((Boolean) contentsSame.invoke(old, obj)).booleanValue();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean b(Object old, Object obj) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(obj, "new");
                return ((Boolean) itemsSame.invoke(old, obj)).booleanValue();
            }
        });
        Intrinsics.checkNotNullParameter(itemsSame, "itemsSame");
        Intrinsics.checkNotNullParameter(contentsSame, "contentsSame");
        this.f96331k = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.f96331k;
    }

    public abstract void j(View view, Object obj, int i3, BaseViewHolderImp baseViewHolderImp);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder holder, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.b(g(i3), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(this.f96331k, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new BaseViewHolderImp(this, viewInflate);
    }
}
