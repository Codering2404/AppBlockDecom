package com.superwall.sdk.debug.localizations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.superwall.sdk.R;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LocalizationAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<LocalizationGrouping> data;
    private final Function1<String, Unit> onLocaleSelected;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerView localeRecyclerView;
        private final TextView titleTextView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R.id.title_text_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.titleTextView = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.locale_recycler_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            RecyclerView recyclerView = (RecyclerView) viewFindViewById2;
            this.localeRecyclerView = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        }

        public final void bind(LocalizationGrouping grouping, Function1<? super String, Unit> onLocaleSelected) {
            Intrinsics.checkNotNullParameter(grouping, "grouping");
            Intrinsics.checkNotNullParameter(onLocaleSelected, "onLocaleSelected");
            this.titleTextView.setText(grouping.getTitle());
            this.localeRecyclerView.setAdapter(new LocaleAdapter(grouping.getLocalizations(), onLocaleSelected));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LocalizationAdapter(List<LocalizationGrouping> data, Function1<? super String, Unit> onLocaleSelected) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(onLocaleSelected, "onLocaleSelected");
        this.data = data;
        this.onLocaleSelected = onLocaleSelected;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final void updateData(List<LocalizationGrouping> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.data = newData;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(i3), this.onLocaleSelected);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_localization, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }
}
