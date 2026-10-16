package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DropDownPreference extends ListPreference {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final Context f50783b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final ArrayAdapter f50784c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private Spinner f50785d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f50786e0;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f50958c);
    }

    private int S0(String str) {
        CharSequence[] charSequenceArrN0 = N0();
        if (str == null || charSequenceArrN0 == null) {
            return -1;
        }
        for (int length = charSequenceArrN0.length - 1; length >= 0; length--) {
            if (TextUtils.equals(charSequenceArrN0[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    private void T0() {
        this.f50784c0.clear();
        if (L0() != null) {
            for (CharSequence charSequence : L0()) {
                this.f50784c0.add(charSequence.toString());
            }
        }
    }

    @Override // androidx.preference.Preference
    protected void H() {
        super.H();
        ArrayAdapter arrayAdapter = this.f50784c0;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.preference.Preference
    public void Q(PreferenceViewHolder preferenceViewHolder) {
        Spinner spinner = (Spinner) preferenceViewHolder.itemView.findViewById(R.id.f50979h);
        this.f50785d0 = spinner;
        spinner.setAdapter((SpinnerAdapter) this.f50784c0);
        this.f50785d0.setOnItemSelectedListener(this.f50786e0);
        this.f50785d0.setSelection(S0(O0()));
        super.Q(preferenceViewHolder);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void R() {
        this.f50785d0.performClick();
    }

    protected ArrayAdapter R0() {
        return new ArrayAdapter(this.f50783b0, android.R.layout.simple_spinner_dropdown_item);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f50786e0 = new AdapterView.OnItemSelectedListener() { // from class: androidx.preference.DropDownPreference.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView adapterView, View view, int i5, long j3) {
                if (i5 >= 0) {
                    String string = DropDownPreference.this.N0()[i5].toString();
                    if (string.equals(DropDownPreference.this.O0()) || !DropDownPreference.this.b(string)) {
                        return;
                    }
                    DropDownPreference.this.Q0(string);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView adapterView) {
            }
        };
        this.f50783b0 = context;
        this.f50784c0 = R0();
        T0();
    }
}
