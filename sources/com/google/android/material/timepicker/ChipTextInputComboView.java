package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Chip f82405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextInputLayout f82406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EditText f82407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextWatcher f82408d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f82409f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class TextFormatter extends TextWatcherAdapter {
        private TextFormatter() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f82405a.setText(ChipTextInputComboView.this.d("00"));
                return;
            }
            String strD = ChipTextInputComboView.this.d(editable);
            Chip chip = ChipTextInputComboView.this.f82405a;
            if (TextUtils.isEmpty(strD)) {
                strD = ChipTextInputComboView.this.d("00");
            }
            chip.setText(strD);
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void h() {
        this.f82407c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.f82407c.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f82407c.setFilters(inputFilterArr);
    }

    public TextInputLayout e() {
        return this.f82406b;
    }

    public void f(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.m0(this.f82405a, accessibilityDelegateCompat);
    }

    public void g(CharSequence charSequence) {
        String strD = d(charSequence);
        this.f82405a.setText(strD);
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        this.f82407c.removeTextChangedListener(this.f82408d);
        this.f82407c.setText(strD);
        this.f82407c.addTextChangedListener(this.f82408d);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f82405a.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        this.f82405a.setChecked(z2);
        this.f82407c.setVisibility(z2 ? 0 : 4);
        this.f82405a.setVisibility(z2 ? 8 : 0);
        if (isChecked()) {
            ViewUtils.t(this.f82407c, false);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f82405a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i3, Object obj) {
        this.f82405a.setTag(i3, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f82405a.toggle();
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(R.layout.f79686q, (ViewGroup) this, false);
        this.f82405a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(R.layout.f79687r, (ViewGroup) this, false);
        this.f82406b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f82407c = editText;
        editText.setVisibility(4);
        TextFormatter textFormatter = new TextFormatter();
        this.f82408d = textFormatter;
        editText.addTextChangedListener(textFormatter);
        h();
        addView(chip);
        addView(textInputLayout);
        this.f82409f = (TextView) findViewById(R.id.f79662v);
        editText.setId(ViewCompat.j());
        ViewCompat.z0(this.f82409f, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
