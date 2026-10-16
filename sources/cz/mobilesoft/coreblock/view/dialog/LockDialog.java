package cz.mobilesoft.coreblock.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.FragmentLockDialogBinding;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class LockDialog extends AppCompatDialogFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(DialogInterface dialogInterface, int i3) {
        if (getTargetFragment() != null) {
            getTargetFragment().onActivityResult(907, -1, new Intent());
        }
    }

    public static LockDialog B() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("IS_FOR_TIME_LOCK", true);
        LockDialog lockDialog = new LockDialog();
        lockDialog.setArguments(bundle);
        return lockDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireActivity());
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        boolean z2 = getArguments() != null ? getArguments().getBoolean("IS_FOR_TIME_LOCK") : false;
        FragmentLockDialogBinding fragmentLockDialogBindingC = FragmentLockDialogBinding.c(layoutInflater, null, false);
        fragmentLockDialogBindingC.f96670b.setText(z2 ? R.string.yj : R.string.t7);
        fragmentLockDialogBindingC.f96671c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cz.mobilesoft.coreblock.view.dialog.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                PrefManager.f126839a.E2(!z3);
            }
        });
        materialAlertDialogBuilder.u(fragmentLockDialogBindingC.getRoot()).P(R.string.f95842s).L(R.string.ij, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.view.dialog.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f132729a.A(dialogInterface, i3);
            }
        }).G(android.R.string.cancel, null);
        return materialAlertDialogBuilder.a();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }
}
