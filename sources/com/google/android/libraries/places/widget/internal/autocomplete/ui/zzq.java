package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.internal.zznb;
import com.google.android.libraries.places.internal.zznq;
import com.google.android.libraries.places.widget.model.AutocompleteListDensity;
import com.google.android.libraries.places.widget.model.AutocompleteUiCustomization;
import com.google.android.libraries.places.widget.model.AutocompleteUiIcon;
import com.google.android.material.color.MaterialColors;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzq extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f79065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f79066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImageView f79067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FrameLayout f79068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zznq f79069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AutocompletePrediction f79070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f79071h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ForegroundColorSpan f79072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ForegroundColorSpan f79073j;

    public zzq(final zzp zzpVar, View view, zznq zznqVar) {
        super(view);
        this.f79072i = new ForegroundColorSpan(MaterialColors.d(view, R.attr.f74652o));
        this.f79073j = new ForegroundColorSpan(MaterialColors.d(view, R.attr.f74651n));
        this.f79065b = (TextView) view.findViewById(R.id.f74772u);
        this.f79066c = (TextView) view.findViewById(R.id.f74775v);
        this.f79067d = (ImageView) view.findViewById(R.id.f74704c0);
        this.f79068e = (FrameLayout) view.findViewById(R.id.f74708d0);
        this.f79069f = zznqVar;
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzo
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view2) {
                this.f79063a.d(zzpVar, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void d(zzp zzpVar, View view) {
        AutocompletePrediction autocompletePrediction = this.f79070g;
        if (autocompletePrediction == null) {
            return;
        }
        try {
            zzpVar.a(autocompletePrediction, getAdapterPosition());
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    public final void b(AutocompletePrediction autocompletePrediction, boolean z2) {
        String strConcat;
        this.f79070g = autocompletePrediction;
        this.f79071h = z2;
        AutocompleteUiCustomization autocompleteUiCustomizationQ = this.f79069f.q();
        if (autocompleteUiCustomizationQ != null) {
            AutocompleteUiIcon autocompleteUiIconD = autocompleteUiCustomizationQ.d();
            if (autocompleteUiIconD != null) {
                int iC = autocompleteUiIconD.c();
                if (iC != 0) {
                    this.f79068e.setVisibility(0);
                    this.f79067d.setImageResource(iC);
                } else {
                    this.f79068e.setVisibility(8);
                }
            }
            AutocompleteListDensity autocompleteListDensityC = autocompleteUiCustomizationQ.c();
            if (autocompleteListDensityC != null && autocompleteListDensityC.ordinal() == 1) {
                this.f79065b.setSingleLine(false);
                this.f79066c.setSingleLine(false);
            }
        }
        this.f79065b.setText(autocompletePrediction.e(this.f79072i));
        SpannableString spannableStringF = autocompletePrediction.f(null);
        Integer numC = this.f79070g.c();
        if (numC == null) {
            strConcat = "";
        } else {
            double dIntValue = ((double) numC.intValue()) * 6.21371E-4d;
            if (dIntValue % 1.0d == 0.0d) {
                int i3 = (int) dIntValue;
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 3);
                sb.append(i3);
                sb.append(" mi");
                strConcat = sb.toString();
            } else {
                strConcat = String.valueOf(new DecimalFormat("#.#").format(dIntValue)).concat(" mi");
            }
        }
        TextView textView = this.f79066c;
        textView.setVisibility(0);
        if (spannableStringF.length() == 0 || strConcat.length() == 0) {
            if (strConcat.length() != 0) {
                textView.setText(strConcat);
                return;
            } else if (spannableStringF.length() != 0) {
                textView.setText(spannableStringF);
                return;
            } else {
                textView.setVisibility(8);
                return;
            }
        }
        String strValueOf = String.valueOf(spannableStringF);
        StringBuilder sb2 = new StringBuilder(strConcat.length() + 5 + strValueOf.length());
        sb2.append(strConcat);
        sb2.append("  ·  ");
        sb2.append(strValueOf);
        SpannableString spannableString = new SpannableString(sb2.toString());
        int length = strConcat.length();
        spannableString.setSpan(this.f79073j, length + 2, length + 3, 33);
        textView.setText(spannableString);
    }

    public final boolean c() {
        return this.f79071h;
    }
}
