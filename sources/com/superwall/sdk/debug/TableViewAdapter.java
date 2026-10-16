package com.superwall.sdk.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.superwall.sdk.R;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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
public final class TableViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Map.Entry<String, String>> data;
    private int pickerRow;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text1;
        private TextView text2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.text1);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.text1 = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.text2);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.text2 = (TextView) viewFindViewById2;
        }

        public final TextView getText1() {
            return this.text1;
        }

        public final TextView getText2() {
            return this.text2;
        }

        public final void setText1(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.text1 = textView;
        }

        public final void setText2(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.text2 = textView;
        }
    }

    public TableViewAdapter(List<Map.Entry<String, String>> data, int i3) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.pickerRow = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final void updateData(Map<String, String> newData, int i3) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.pickerRow = i3;
        this.data.clear();
        Iterator<Map.Entry<String, String>> it = newData.entrySet().iterator();
        while (it.hasNext()) {
            this.data.add(it.next());
        }
        CollectionsKt.sortWith(this.data, new Comparator() { // from class: com.superwall.sdk.debug.TableViewAdapter$updateData$$inlined$compareBy$1
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                return ComparisonsKt.d((Comparable) ((Map.Entry) t2).getKey(), (Comparable) ((Map.Entry) t3).getKey());
            }
        });
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"primary", "secondary", "tertiary"});
        String str = this.pickerRow < listListOf.size() ? (String) listListOf.get(this.pickerRow) : null;
        Map.Entry<String, String> entry = this.data.get(i3);
        String key = entry.getKey();
        holder.getText1().setText(entry.getValue());
        if (str != null) {
            String str2 = str + "." + key;
            if (str2 != null) {
                key = str2;
            }
        }
        holder.getText2().setText("{{ " + key + " }}");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }
}
