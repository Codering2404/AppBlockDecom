package com.superwall.sdk.debug.localizations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.superwall.sdk.R;
import com.superwall.sdk.debug.localizations.LocaleAdapter;
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
public final class LocaleAdapter extends RecyclerView.Adapter<LocaleViewHolder> {
    private final List<LocalizationOption> localizations;
    private final Function1<String, Unit> onLocaleSelected;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LocaleViewHolder extends RecyclerView.ViewHolder {
        private final TextView countryTextView;
        private final TextView languageTextView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocaleViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R.id.language_text_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.languageTextView = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.country_text_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.countryTextView = (TextView) viewFindViewById2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(Function1 function1, LocalizationOption localizationOption, View view) {
            function1.invoke(localizationOption.getLocale());
        }

        public final void bind(final LocalizationOption localizationOption, final Function1<? super String, Unit> onLocaleSelected) {
            Intrinsics.checkNotNullParameter(localizationOption, "localizationOption");
            Intrinsics.checkNotNullParameter(onLocaleSelected, "onLocaleSelected");
            this.languageTextView.setText(localizationOption.getDescription());
            this.countryTextView.setText(localizationOption.getLocale());
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.debug.localizations.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocaleAdapter.LocaleViewHolder.bind$lambda$0(onLocaleSelected, localizationOption, view);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LocaleAdapter(List<LocalizationOption> localizations, Function1<? super String, Unit> onLocaleSelected) {
        Intrinsics.checkNotNullParameter(localizations, "localizations");
        Intrinsics.checkNotNullParameter(onLocaleSelected, "onLocaleSelected");
        this.localizations = localizations;
        this.onLocaleSelected = onLocaleSelected;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.localizations.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(LocaleViewHolder holder, int i3) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.localizations.get(i3), this.onLocaleSelected);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public LocaleViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_locale, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new LocaleViewHolder(viewInflate);
    }
}
