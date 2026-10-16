package androidx.preference;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class EditTextPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private EditText f50792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f50793k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Runnable f50794l = new Runnable() { // from class: androidx.preference.EditTextPreferenceDialogFragmentCompat.1
        @Override // java.lang.Runnable
        public void run() {
            EditTextPreferenceDialogFragmentCompat.this.J();
        }
    };

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f50795m = -1;

    private EditTextPreference G() {
        return (EditTextPreference) y();
    }

    private boolean H() {
        long j3 = this.f50795m;
        return j3 != -1 && j3 + 1000 > SystemClock.currentThreadTimeMillis();
    }

    public static EditTextPreferenceDialogFragmentCompat I(String str) {
        EditTextPreferenceDialogFragmentCompat editTextPreferenceDialogFragmentCompat = new EditTextPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        editTextPreferenceDialogFragmentCompat.setArguments(bundle);
        return editTextPreferenceDialogFragmentCompat;
    }

    private void L(boolean z2) {
        this.f50795m = z2 ? SystemClock.currentThreadTimeMillis() : -1L;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected void A(View view) {
        super.A(view);
        EditText editText = (EditText) view.findViewById(android.R.id.edit);
        this.f50792j = editText;
        if (editText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText.requestFocus();
        this.f50792j.setText(this.f50793k);
        EditText editText2 = this.f50792j;
        editText2.setSelection(editText2.getText().length());
        if (G().K0() != null) {
            G().K0().a(this.f50792j);
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void C(boolean z2) {
        if (z2) {
            String string = this.f50792j.getText().toString();
            EditTextPreference editTextPreferenceG = G();
            if (editTextPreferenceG.b(string)) {
                editTextPreferenceG.M0(string);
            }
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected void F() {
        L(true);
        J();
    }

    void J() {
        if (H()) {
            EditText editText = this.f50792j;
            if (editText == null || !editText.isFocused()) {
                L(false);
            } else if (((InputMethodManager) this.f50792j.getContext().getSystemService("input_method")).showSoftInput(this.f50792j, 0)) {
                L(false);
            } else {
                this.f50792j.removeCallbacks(this.f50794l);
                this.f50792j.postDelayed(this.f50794l, 50L);
            }
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f50793k = G().L0();
        } else {
            this.f50793k = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f50793k);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected boolean z() {
        return true;
    }
}
