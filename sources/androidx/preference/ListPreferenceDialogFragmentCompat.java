package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f50804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence[] f50805k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CharSequence[] f50806l;

    private ListPreference G() {
        return (ListPreference) y();
    }

    public static ListPreferenceDialogFragmentCompat H(String str) {
        ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = new ListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        listPreferenceDialogFragmentCompat.setArguments(bundle);
        return listPreferenceDialogFragmentCompat;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void C(boolean z2) {
        int i3;
        if (!z2 || (i3 = this.f50804j) < 0) {
            return;
        }
        String string = this.f50806l[i3].toString();
        ListPreference listPreferenceG = G();
        if (listPreferenceG.b(string)) {
            listPreferenceG.Q0(string);
        }
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected void D(AlertDialog.Builder builder) {
        super.D(builder);
        builder.r(this.f50805k, this.f50804j, new DialogInterface.OnClickListener() { // from class: androidx.preference.ListPreferenceDialogFragmentCompat.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = ListPreferenceDialogFragmentCompat.this;
                listPreferenceDialogFragmentCompat.f50804j = i3;
                listPreferenceDialogFragmentCompat.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        builder.p(null, null);
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f50804j = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.f50805k = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.f50806l = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreferenceG = G();
        if (listPreferenceG.L0() == null || listPreferenceG.N0() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f50804j = listPreferenceG.K0(listPreferenceG.O0());
        this.f50805k = listPreferenceG.L0();
        this.f50806l = listPreferenceG.N0();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f50804j);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f50805k);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.f50806l);
    }
}
