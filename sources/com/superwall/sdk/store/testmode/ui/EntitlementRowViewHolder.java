package com.superwall.sdk.store.testmode.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.superwall.sdk.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class EntitlementRowViewHolder {
    private final Context context;
    private OfferTypeOption currentOfferType;
    private EntitlementStateOption currentState;
    private final TextView nameText;
    private final View offerRow;
    private final Spinner offerSpinner;
    private final Function1<EntitlementSelection, Unit> onSelectionChanged;
    private final Spinner stateSpinner;
    private final View view;

    /* JADX WARN: Multi-variable type inference failed */
    public EntitlementRowViewHolder(Context context, ViewGroup parent, String entitlementName, EntitlementSelection initialSelection, Function1<? super EntitlementSelection, Unit> onSelectionChanged) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(entitlementName, "entitlementName");
        Intrinsics.checkNotNullParameter(initialSelection, "initialSelection");
        Intrinsics.checkNotNullParameter(onSelectionChanged, "onSelectionChanged");
        this.context = context;
        this.onSelectionChanged = onSelectionChanged;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.test_mode_entitlement_row, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        this.view = viewInflate;
        View viewFindViewById = viewInflate.findViewById(R.id.entitlement_name);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        this.nameText = textView;
        View viewFindViewById2 = viewInflate.findViewById(R.id.state_spinner);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.stateSpinner = (Spinner) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.offer_type_row);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.offerRow = viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.offer_spinner);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.offerSpinner = (Spinner) viewFindViewById4;
        this.currentState = initialSelection.getState();
        this.currentOfferType = initialSelection.getOfferType();
        textView.setText(entitlementName);
        final List list = CollectionsKt.toList(EntitlementStateOption.getEntries());
        int i3 = R.layout.test_mode_spinner_item;
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((EntitlementStateOption) it.next()).getDisplayName());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, i3, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.test_mode_spinner_dropdown_item);
        this.stateSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.stateSpinner.setSelection(RangesKt.f(list.indexOf(initialSelection.getState()), 0));
        final List list3 = CollectionsKt.toList(OfferTypeOption.getEntries());
        Context context2 = this.context;
        int i4 = R.layout.test_mode_spinner_item;
        List list4 = list3;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator it2 = list4.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((OfferTypeOption) it2.next()).getDisplayName());
        }
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(context2, i4, arrayList2);
        arrayAdapter2.setDropDownViewResource(R.layout.test_mode_spinner_dropdown_item);
        this.offerSpinner.setAdapter((SpinnerAdapter) arrayAdapter2);
        this.offerSpinner.setSelection(RangesKt.f(list3.indexOf(initialSelection.getOfferType()), 0));
        updateAppearance();
        this.stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.superwall.sdk.store.testmode.ui.EntitlementRowViewHolder.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i5, long j3) {
                EntitlementRowViewHolder.this.currentState = list.get(i5);
                EntitlementRowViewHolder.this.updateAppearance();
                EntitlementRowViewHolder.this.notifyChanged();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.offerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.superwall.sdk.store.testmode.ui.EntitlementRowViewHolder.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i5, long j3) {
                EntitlementRowViewHolder.this.currentOfferType = list3.get(i5);
                EntitlementRowViewHolder.this.notifyChanged();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        View view = this.view;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = dpToPx(8);
        view.setLayoutParams(layoutParams);
    }

    private final int dpToPx(int i3) {
        return (int) (i3 * this.context.getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyChanged() {
        this.onSelectionChanged.invoke(getCurrentSelection());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAppearance() {
        this.offerRow.setVisibility(this.currentState.isActive() ? 0 : 8);
        this.view.setBackground(ContextCompat.getDrawable(this.context, this.currentState.isActive() ? R.drawable.test_mode_card_active_bg : R.drawable.test_mode_card_bg));
    }

    public final EntitlementSelection getCurrentSelection() {
        String string = this.nameText.getText().toString();
        EntitlementStateOption entitlementStateOption = this.currentState;
        return new EntitlementSelection(string, entitlementStateOption, entitlementStateOption.isActive() ? this.currentOfferType : OfferTypeOption.None);
    }

    public final View getView() {
        return this.view;
    }

    public final void resetToDefaults() {
        this.currentState = EntitlementStateOption.Inactive;
        this.currentOfferType = OfferTypeOption.None;
        this.stateSpinner.setSelection(0);
        this.offerSpinner.setSelection(0);
        updateAppearance();
    }
}
