package cz.mobilesoft.coreblock.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.FragmentInfoDialogBinding;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import cz.mobilesoft.coreblock.view.dialog.InfoDialogFragment;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class InfoDialogFragment extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f132708b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f132709c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentInfoDialogBinding f132710a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(OnDialogClosedListener onDialogClosedListener, String requestKey, Bundle bundle) {
            Intrinsics.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            if (requestKey.hashCode() == 2016211272 && requestKey.equals("DIALOG")) {
                onDialogClosedListener.a(bundle.getInt("BUTTON", 0), bundle.getBoolean("WITH_NOT_SHOW_AGAIN", false));
            }
        }

        public final InfoDialogFragment b(FragmentManager fragmentManager, InfoDialogSetupDTO setup, final OnDialogClosedListener onDialogClosedListener) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(setup, "setup");
            if (onDialogClosedListener != null) {
                fragmentManager.F1("DIALOG", onDialogClosedListener.b(), new FragmentResultListener() { // from class: cz.mobilesoft.coreblock.view.dialog.e
                    @Override // androidx.fragment.app.FragmentResultListener
                    public final void a(String str, Bundle bundle) {
                        InfoDialogFragment.Companion.c(onDialogClosedListener, str, bundle);
                    }
                });
            }
            InfoDialogFragment infoDialogFragment = new InfoDialogFragment();
            infoDialogFragment.setArguments(BundleKt.b(TuplesKt.a("SETUP", setup)));
            infoDialogFragment.showNow(fragmentManager, InfoDialogFragment.class.getSimpleName());
            return infoDialogFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata
    public @interface DialogButton {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InfoDialogSetupDTO implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f132711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f132712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Integer f132713c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Integer f132714d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f132715f;

        public InfoDialogSetupDTO(String titleText, String descriptionText, Integer num, Integer num2, boolean z2) {
            Intrinsics.checkNotNullParameter(titleText, "titleText");
            Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
            this.f132711a = titleText;
            this.f132712b = descriptionText;
            this.f132713c = num;
            this.f132714d = num2;
            this.f132715f = z2;
        }

        public final String a() {
            return this.f132712b;
        }

        public final Integer b() {
            return this.f132714d;
        }

        public final Integer c() {
            return this.f132713c;
        }

        public final String d() {
            return this.f132711a;
        }

        public final boolean e() {
            return this.f132715f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InfoDialogSetupDTO)) {
                return false;
            }
            InfoDialogSetupDTO infoDialogSetupDTO = (InfoDialogSetupDTO) obj;
            return Intrinsics.areEqual(this.f132711a, infoDialogSetupDTO.f132711a) && Intrinsics.areEqual(this.f132712b, infoDialogSetupDTO.f132712b) && Intrinsics.areEqual(this.f132713c, infoDialogSetupDTO.f132713c) && Intrinsics.areEqual(this.f132714d, infoDialogSetupDTO.f132714d) && this.f132715f == infoDialogSetupDTO.f132715f;
        }

        public int hashCode() {
            int iHashCode = ((this.f132711a.hashCode() * 31) + this.f132712b.hashCode()) * 31;
            Integer num = this.f132713c;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.f132714d;
            return ((iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31) + Boolean.hashCode(this.f132715f);
        }

        public String toString() {
            return "InfoDialogSetupDTO(titleText=" + this.f132711a + ", descriptionText=" + this.f132712b + ", positiveButtonText=" + this.f132713c + ", negativeButtonText=" + this.f132714d + ", withNotShowAgainCheckbox=" + this.f132715f + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnDialogClosedListener {
        void a(int i3, boolean z2);

        LifecycleOwner b();
    }

    private final void B(int i3, boolean z2) {
        FragmentKt.b(this, "DIALOG", BundleKt.b(TuplesKt.a("BUTTON", Integer.valueOf(i3)), TuplesKt.a("WITH_NOT_SHOW_AGAIN", Boolean.valueOf(z2))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(InfoDialogFragment infoDialogFragment, boolean z2, FragmentInfoDialogBinding fragmentInfoDialogBinding, DialogInterface dialogInterface, int i3) {
        infoDialogFragment.B(-1, z2 && fragmentInfoDialogBinding.f96651c.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(InfoDialogFragment infoDialogFragment, boolean z2, FragmentInfoDialogBinding fragmentInfoDialogBinding, DialogInterface dialogInterface, int i3) {
        infoDialogFragment.B(-2, z2 && fragmentInfoDialogBinding.f96651c.isChecked());
    }

    public final FragmentInfoDialogBinding A() {
        FragmentInfoDialogBinding fragmentInfoDialogBinding = this.f132710a;
        if (fragmentInfoDialogBinding != null) {
            return fragmentInfoDialogBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void E(FragmentInfoDialogBinding fragmentInfoDialogBinding) {
        Intrinsics.checkNotNullParameter(fragmentInfoDialogBinding, "<set-?>");
        this.f132710a = fragmentInfoDialogBinding;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String strD;
        Integer numB;
        Integer numC;
        String strA;
        FragmentInfoDialogBinding fragmentInfoDialogBindingC = FragmentInfoDialogBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(fragmentInfoDialogBindingC, "inflate(...)");
        E(fragmentInfoDialogBindingC);
        final FragmentInfoDialogBinding fragmentInfoDialogBindingA = A();
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("SETUP") : null;
        InfoDialogSetupDTO infoDialogSetupDTO = serializable instanceof InfoDialogSetupDTO ? (InfoDialogSetupDTO) serializable : null;
        final boolean z2 = infoDialogSetupDTO != null && infoDialogSetupDTO.e();
        TextView textView = fragmentInfoDialogBindingA.f96652d;
        String str = "";
        if (infoDialogSetupDTO == null || (strD = infoDialogSetupDTO.d()) == null) {
            strD = "";
        }
        textView.setText(strD);
        TextView descriptionTextView = fragmentInfoDialogBindingA.f96650b;
        Intrinsics.checkNotNullExpressionValue(descriptionTextView, "descriptionTextView");
        if (infoDialogSetupDTO != null && (strA = infoDialogSetupDTO.a()) != null) {
            str = strA;
        }
        ViewHelperExtKt.k(descriptionTextView, str, true);
        CheckBox neverShowAgainCheckBox = fragmentInfoDialogBindingA.f96651c;
        Intrinsics.checkNotNullExpressionValue(neverShowAgainCheckBox, "neverShowAgainCheckBox");
        neverShowAgainCheckBox.setVisibility(z2 ? 0 : 8);
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireContext(), R.style.f95867b);
        materialAlertDialogBuilder.u(fragmentInfoDialogBindingA.getRoot()).L((infoDialogSetupDTO == null || (numC = infoDialogSetupDTO.c()) == null) ? R.string.Nl : numC.intValue(), new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.view.dialog.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                InfoDialogFragment.C(this.f132722a, z2, fragmentInfoDialogBindingA, dialogInterface, i3);
            }
        });
        if (infoDialogSetupDTO != null && (numB = infoDialogSetupDTO.b()) != null) {
            materialAlertDialogBuilder.G(numB.intValue(), new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.view.dialog.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    InfoDialogFragment.D(this.f132725a, z2, fragmentInfoDialogBindingA, dialogInterface, i3);
                }
            });
        }
        AlertDialog alertDialogA = materialAlertDialogBuilder.a();
        Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
        return alertDialogA;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(getResources().getConfiguration().orientation == 2 ? -2 : -1, -2);
    }
}
