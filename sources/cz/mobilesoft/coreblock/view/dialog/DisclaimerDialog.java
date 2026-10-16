package cz.mobilesoft.coreblock.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class DisclaimerDialog extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ProfileType f132704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f132705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f132706c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.view.dialog.DisclaimerDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f132707a;

        static {
            int[] iArr = new int[ProfileType.values().length];
            f132707a = iArr;
            try {
                iArr[ProfileType.LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f132707a[ProfileType.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(CompoundButton compoundButton, boolean z2) {
        if (this.f132705b) {
            if (this.f132706c) {
                PrefManager.f126839a.C2(!z2);
                return;
            } else {
                PrefManager.f126839a.B2(!z2);
                return;
            }
        }
        int i3 = AnonymousClass1.f132707a[this.f132704a.ordinal()];
        if (i3 == 1) {
            PrefManager.f126839a.D2(!z2);
        } else {
            if (i3 != 2) {
                return;
            }
            PrefManager.f126839a.I2(!z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(DialogInterface dialogInterface, int i3) {
        dismiss();
    }

    public static DisclaimerDialog C() {
        DisclaimerDialog disclaimerDialog = new DisclaimerDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean("STRICT_MODE", true);
        disclaimerDialog.setArguments(bundle);
        return disclaimerDialog;
    }

    public static DisclaimerDialog D() {
        DisclaimerDialog disclaimerDialog = new DisclaimerDialog();
        Bundle bundle = new Bundle();
        bundle.putBoolean("STRICT_MODE", true);
        bundle.putBoolean("IS_NEW_PROFILE", true);
        disclaimerDialog.setArguments(bundle);
        return disclaimerDialog;
    }

    public static DisclaimerDialog E(ProfileType profileType) {
        DisclaimerDialog disclaimerDialog = new DisclaimerDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("PROFILE_TYPE", profileType);
        disclaimerDialog.setArguments(bundle);
        return disclaimerDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string;
        Drawable drawableB;
        int i3;
        Drawable drawableB2;
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
        View viewInflate = getActivity().getLayoutInflater().inflate(R.layout.F, (ViewGroup) null);
        if (getArguments() != null) {
            this.f132705b = getArguments().getBoolean("STRICT_MODE", false);
            this.f132706c = getArguments().getBoolean("IS_NEW_PROFILE", false);
            this.f132704a = (ProfileType) getArguments().getSerializable("PROFILE_TYPE");
        }
        if (this.f132704a == null) {
            this.f132704a = ProfileType.LOCATION;
        }
        int i4 = R.string.WF;
        if (this.f132705b) {
            drawableB2 = AppCompatResources.b(getContext(), R.drawable.Y5);
            i3 = R.string.QD;
            string = this.f132706c ? getString(R.string.U1) : getString(R.string.T1);
        } else {
            if (this.f132704a == ProfileType.WIFI) {
                string = getString(R.string.mH);
                drawableB = AppCompatResources.b(getContext(), R.drawable.O3);
            } else {
                string = getString(R.string.gj);
                drawableB = AppCompatResources.b(getContext(), R.drawable.N3);
            }
            Drawable drawable = drawableB;
            i3 = i4;
            drawableB2 = drawable;
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.X);
        Drawable drawableMutate = drawableB2.mutate();
        drawableMutate.setColorFilter(getResources().getColor(R.color.f95455j), PorterDuff.Mode.SRC_ATOP);
        textView.setText(string);
        textView.setCompoundDrawablesWithIntrinsicBounds(drawableMutate, (Drawable) null, (Drawable) null, (Drawable) null);
        ((CheckBox) viewInflate.findViewById(R.id.f95635l1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cz.mobilesoft.coreblock.view.dialog.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.f132720a.A(compoundButton, z2);
            }
        });
        materialAlertDialogBuilder.u(viewInflate).P(i3).L(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.view.dialog.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f132721a.B(dialogInterface, i5);
            }
        });
        return materialAlertDialogBuilder.a();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }
}
