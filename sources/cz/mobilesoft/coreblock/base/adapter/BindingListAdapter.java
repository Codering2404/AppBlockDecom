package cz.mobilesoft.coreblock.base.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
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
public abstract class BindingListAdapter<T, Binding extends ViewBinding> extends ListAdapter<T, BaseViewHolder<T>> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f96335k = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class BaseViewHolderImp extends BaseViewHolder<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ViewBinding f96338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BindingListAdapter f96339c;

        /* JADX WARN: Illegal instructions before constructor call */
        public BaseViewHolderImp(BindingListAdapter bindingListAdapter, ViewBinding binding) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f96339c = bindingListAdapter;
            View root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            super(root);
            this.f96338b = binding;
        }

        @Override // cz.mobilesoft.coreblock.base.adapter.BaseViewHolder
        public void b(Object obj, int i3) {
            this.f96339c.j(this.f96338b, obj, i3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BindingListAdapter(final Function2 itemsSame, final Function2 contentsSame) {
        super(new DiffUtil.ItemCallback<T>() { // from class: cz.mobilesoft.coreblock.base.adapter.BindingListAdapter.1
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
    }

    public abstract void j(ViewBinding viewBinding, Object obj, int i3);

    public abstract ViewBinding k(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BaseViewHolder holder, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.b(g(i3), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        Intrinsics.checkNotNullParameter(viewGroup, YznnJpHcAmeoW.tyxFflmyYr);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        Intrinsics.checkNotNullExpressionValue(layoutInflaterFrom, "from(...)");
        return new BaseViewHolderImp(this, k(layoutInflaterFrom, viewGroup, false));
    }
}
