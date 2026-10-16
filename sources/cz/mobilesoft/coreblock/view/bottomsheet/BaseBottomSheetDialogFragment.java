package cz.mobilesoft.coreblock.view.bottomsheet;

import android.app.Dialog;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseBottomSheetDialogFragment extends BottomSheetDialogFragment {
    protected void C(final View view) {
        final CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.LayoutParams) ((View) view.getParent()).getLayoutParams()).f();
        if (behaviorF instanceof BottomSheetBehavior) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.BaseBottomSheetDialogFragment.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    ((BottomSheetBehavior) behaviorF).U0(view.getMeasuredHeight());
                }
            });
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }
}
