package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ListPreferenceDialogFragment extends PreferenceDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f50800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence[] f50801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CharSequence[] f50802l;

    private ListPreference h() {
        return (ListPreference) a();
    }

    public static ListPreferenceDialogFragment i(String str) {
        ListPreferenceDialogFragment listPreferenceDialogFragment = new ListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        listPreferenceDialogFragment.setArguments(bundle);
        return listPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public void e(boolean z2) {
        int i3;
        ListPreference listPreferenceH = h();
        if (!z2 || (i3 = this.f50800j) < 0) {
            return;
        }
        String string = this.f50802l[i3].toString();
        if (listPreferenceH.b(string)) {
            listPreferenceH.Q0(string);
        }
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void f(AlertDialog.Builder builder) {
        super.f(builder);
        builder.setSingleChoiceItems(this.f50801k, this.f50800j, new DialogInterface.OnClickListener() { // from class: androidx.preference.ListPreferenceDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                ListPreferenceDialogFragment listPreferenceDialogFragment = ListPreferenceDialogFragment.this;
                listPreferenceDialogFragment.f50800j = i3;
                listPreferenceDialogFragment.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f50800j = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.f50801k = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.f50802l = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreferenceH = h();
        if (listPreferenceH.L0() == null || listPreferenceH.N0() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f50800j = listPreferenceH.K0(listPreferenceH.O0());
        this.f50801k = listPreferenceH.L0();
        this.f50802l = listPreferenceH.N0();
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f50800j);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f50801k);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f50802l);
    }
}
