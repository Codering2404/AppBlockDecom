package cz.mobilesoft.coreblock.scene.premium.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.adapter.BindingListAdapter;
import cz.mobilesoft.coreblock.databinding.ItemListReviewBinding;
import cz.mobilesoft.coreblock.enums.Review;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ReviewAdapter extends BindingListAdapter<Review, ItemListReviewBinding> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f114013l = BindingListAdapter.f96335k;

    @Override // cz.mobilesoft.coreblock.base.adapter.BindingListAdapter
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void j(ItemListReviewBinding binding, Review item, int i3) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(item, "item");
        binding.f96738b.setText(item.getUserName());
        binding.f96740d.setText(binding.getRoot().getContext().getString(item.getReview()));
        binding.f96739c.setRating(item.getRating());
    }

    @Override // cz.mobilesoft.coreblock.base.adapter.BindingListAdapter
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public ItemListReviewBinding k(LayoutInflater inflater, ViewGroup parent, boolean z2) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemListReviewBinding itemListReviewBindingC = ItemListReviewBinding.c(inflater, parent, z2);
        Intrinsics.checkNotNullExpressionValue(itemListReviewBindingC, "inflate(...)");
        MaterialCardView root = itemListReviewBindingC.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (parent.getMeasuredWidth() * ResourcesCompat.h(parent.getContext().getResources(), R.dimen.f95484r));
        root.setLayoutParams(layoutParams2);
        return itemListReviewBindingC;
    }
}
