package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f80214a;

    private void A(BottomSheetBehavior bottomSheetBehavior, boolean z2) {
        this.f80214a = z2;
        if (bottomSheetBehavior.getState() == 5) {
            z();
            return;
        }
        if (getDialog() instanceof BottomSheetDialog) {
            ((BottomSheetDialog) getDialog()).q();
        }
        bottomSheetBehavior.e0(new BottomSheetDismissCallback());
        bottomSheetBehavior.c(5);
    }

    private boolean B(boolean z2) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof BottomSheetDialog)) {
            return false;
        }
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
        BottomSheetBehavior bottomSheetBehaviorO = bottomSheetDialog.o();
        if (!bottomSheetBehaviorO.C0() || !bottomSheetDialog.p()) {
            return false;
        }
        A(bottomSheetBehaviorO, z2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.f80214a) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (B(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (B(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new BottomSheetDialog(getContext(), getTheme());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class BottomSheetDismissCallback extends BottomSheetBehavior.BottomSheetCallback {
        private BottomSheetDismissCallback() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i3) {
            if (i3 == 5) {
                BottomSheetDialogFragment.this.z();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f3) {
        }
    }
}
