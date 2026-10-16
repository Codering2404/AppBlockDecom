package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.internal.zznb;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzak extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f79040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f79041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AutocompletePrediction f79042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f79043e;

    public zzak(final zzai zzaiVar, View view) {
        super(view);
        this.f79040b = (TextView) view.findViewById(R.id.f74765r1);
        this.f79041c = (TextView) view.findViewById(R.id.f74768s1);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.autocomplete.ui.zzaj
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view2) {
                this.f79038a.d(zzaiVar, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void d(zzai zzaiVar, View view) {
        AutocompletePrediction autocompletePrediction = this.f79042d;
        if (autocompletePrediction == null) {
            return;
        }
        try {
            zzaiVar.a(autocompletePrediction, getAdapterPosition());
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    public final void b(AutocompletePrediction autocompletePrediction, boolean z2) {
        this.f79042d = autocompletePrediction;
        this.f79043e = z2;
        SpannableString spannableStringE = autocompletePrediction.e(new ForegroundColorSpan(ContextCompat.getColor(this.itemView.getContext(), R.color.f74667d)));
        TextView textView = this.f79040b;
        textView.setText(spannableStringE);
        TextView textView2 = this.f79041c;
        SpannableString spannableStringF = autocompletePrediction.f(null);
        textView2.setText(spannableStringF);
        if (spannableStringF.length() == 0) {
            textView2.setVisibility(8);
            textView.setGravity(16);
        } else {
            textView2.setVisibility(0);
            textView.setGravity(80);
        }
    }

    public final boolean c() {
        return this.f79043e;
    }
}
