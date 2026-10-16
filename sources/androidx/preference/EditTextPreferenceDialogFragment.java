package androidx.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class EditTextPreferenceDialogFragment extends PreferenceDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private EditText f50790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f50791k;

    private EditTextPreference h() {
        return (EditTextPreference) a();
    }

    public static EditTextPreferenceDialogFragment i(String str) {
        EditTextPreferenceDialogFragment editTextPreferenceDialogFragment = new EditTextPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        editTextPreferenceDialogFragment.setArguments(bundle);
        return editTextPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected boolean b() {
        return true;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void c(View view) {
        super.c(view);
        EditText editText = (EditText) view.findViewById(android.R.id.edit);
        this.f50790j = editText;
        editText.requestFocus();
        EditText editText2 = this.f50790j;
        if (editText2 == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText2.setText(this.f50791k);
        EditText editText3 = this.f50790j;
        editText3.setSelection(editText3.getText().length());
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public void e(boolean z2) {
        if (z2) {
            String string = this.f50790j.getText().toString();
            if (h().b(string)) {
                h().M0(string);
            }
        }
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f50791k = h().L0();
        } else {
            this.f50791k = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f50791k);
    }
}
