package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MultiSelectListPreferenceDialogFragmentCompat extends PreferenceDialogFragmentCompat {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Set f50814j = new HashSet();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f50815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    CharSequence[] f50816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    CharSequence[] f50817m;

    private MultiSelectListPreference G() {
        return (MultiSelectListPreference) y();
    }

    public static MultiSelectListPreferenceDialogFragmentCompat H(String str) {
        MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = new MultiSelectListPreferenceDialogFragmentCompat();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        multiSelectListPreferenceDialogFragmentCompat.setArguments(bundle);
        return multiSelectListPreferenceDialogFragmentCompat;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    public void C(boolean z2) {
        if (z2 && this.f50815k) {
            MultiSelectListPreference multiSelectListPreferenceG = G();
            if (multiSelectListPreferenceG.b(this.f50814j)) {
                multiSelectListPreferenceG.N0(this.f50814j);
            }
        }
        this.f50815k = false;
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat
    protected void D(AlertDialog.Builder builder) {
        super.D(builder);
        int length = this.f50817m.length;
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < length; i3++) {
            zArr[i3] = this.f50814j.contains(this.f50817m[i3].toString());
        }
        builder.i(this.f50816l, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: androidx.preference.MultiSelectListPreferenceDialogFragmentCompat.1
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i4, boolean z2) {
                if (z2) {
                    MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = MultiSelectListPreferenceDialogFragmentCompat.this;
                    multiSelectListPreferenceDialogFragmentCompat.f50815k = multiSelectListPreferenceDialogFragmentCompat.f50814j.add(multiSelectListPreferenceDialogFragmentCompat.f50817m[i4].toString()) | multiSelectListPreferenceDialogFragmentCompat.f50815k;
                } else {
                    MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat2 = MultiSelectListPreferenceDialogFragmentCompat.this;
                    multiSelectListPreferenceDialogFragmentCompat2.f50815k = multiSelectListPreferenceDialogFragmentCompat2.f50814j.remove(multiSelectListPreferenceDialogFragmentCompat2.f50817m[i4].toString()) | multiSelectListPreferenceDialogFragmentCompat2.f50815k;
                }
            }
        });
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f50814j.clear();
            this.f50814j.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.f50815k = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.f50816l = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.f50817m = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreferenceG = G();
        if (multiSelectListPreferenceG.K0() == null || multiSelectListPreferenceG.L0() == null) {
            throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
        }
        this.f50814j.clear();
        this.f50814j.addAll(multiSelectListPreferenceG.M0());
        this.f50815k = false;
        this.f50816l = multiSelectListPreferenceG.K0();
        this.f50817m = multiSelectListPreferenceG.L0();
    }

    @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.f50814j));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f50815k);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.f50816l);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.f50817m);
    }
}
