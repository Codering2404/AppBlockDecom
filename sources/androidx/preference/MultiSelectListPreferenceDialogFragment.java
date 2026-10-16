package androidx.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class MultiSelectListPreferenceDialogFragment extends PreferenceDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Set f50809j = new HashSet();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f50810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    CharSequence[] f50811l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    CharSequence[] f50812m;

    private MultiSelectListPreference h() {
        return (MultiSelectListPreference) a();
    }

    public static MultiSelectListPreferenceDialogFragment i(String str) {
        MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = new MultiSelectListPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragment.setArguments(bundle);
        return multiSelectListPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public void e(boolean z2) {
        MultiSelectListPreference multiSelectListPreferenceH = h();
        if (z2 && this.f50810k) {
            Set set = this.f50809j;
            if (multiSelectListPreferenceH.b(set)) {
                multiSelectListPreferenceH.N0(set);
            }
        }
        this.f50810k = false;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void f(AlertDialog.Builder builder) {
        super.f(builder);
        int length = this.f50812m.length;
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < length; i3++) {
            zArr[i3] = this.f50809j.contains(this.f50812m[i3].toString());
        }
        builder.setMultiChoiceItems(this.f50811l, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: androidx.preference.MultiSelectListPreferenceDialogFragment.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i4, boolean z2) {
                if (z2) {
                    MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = MultiSelectListPreferenceDialogFragment.this;
                    multiSelectListPreferenceDialogFragment.f50810k = multiSelectListPreferenceDialogFragment.f50809j.add(multiSelectListPreferenceDialogFragment.f50812m[i4].toString()) | multiSelectListPreferenceDialogFragment.f50810k;
                } else {
                    MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment2 = MultiSelectListPreferenceDialogFragment.this;
                    multiSelectListPreferenceDialogFragment2.f50810k = multiSelectListPreferenceDialogFragment2.f50809j.remove(multiSelectListPreferenceDialogFragment2.f50812m[i4].toString()) | multiSelectListPreferenceDialogFragment2.f50810k;
                }
            }
        });
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f50809j.clear();
            this.f50809j.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragment.values"));
            this.f50810k = bundle.getBoolean("MultiSelectListPreferenceDialogFragment.changed", false);
            this.f50811l = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries");
            this.f50812m = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreferenceH = h();
        if (multiSelectListPreferenceH.K0() == null || multiSelectListPreferenceH.L0() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.f50809j.clear();
        this.f50809j.addAll(multiSelectListPreferenceH.M0());
        this.f50810k = false;
        this.f50811l = multiSelectListPreferenceH.K0();
        this.f50812m = multiSelectListPreferenceH.L0();
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragment.values", new ArrayList<>(this.f50809j));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragment.changed", this.f50810k);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entries", this.f50811l);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragment.entryValues", this.f50812m);
    }
}
