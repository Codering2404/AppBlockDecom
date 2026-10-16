package cz.mobilesoft.coreblock.scene.permission.old;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import cz.mobilesoft.coreblock.databinding.BottomsheetDialogAccessibilityPrivacyBinding;
import cz.mobilesoft.coreblock.databinding.ViewBottomButtonsBinding;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.view.bottomsheet.BaseBottomSheetDialogFragment;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class AccessibilityPrivacyBottomSheet extends BaseBottomSheetDialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f111958d = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f111959f = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function0 f111960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BottomsheetDialogAccessibilityPrivacyBinding f111961c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccessibilityPrivacyBottomSheet a() {
            return new AccessibilityPrivacyBottomSheet();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(AccessibilityPrivacyBottomSheet accessibilityPrivacyBottomSheet, View view) {
        AnswersHelper.f128199a.M();
        accessibilityPrivacyBottomSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(AccessibilityPrivacyBottomSheet accessibilityPrivacyBottomSheet, View view) {
        AnswersHelper.f128199a.L();
        PrefManager.f126839a.M2(true);
        Function0 function0 = accessibilityPrivacyBottomSheet.f111960b;
        if (function0 != null) {
            function0.invoke();
        }
        accessibilityPrivacyBottomSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(NestedScrollView nestedScrollView, DialogInterface dialogInterface) {
        Object parent = nestedScrollView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackgroundColor(ContextCompat.getColor(nestedScrollView.getContext(), R.color.transparent));
    }

    public final void G(Function0 function0) {
        this.f111960b = function0;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i3) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.setupDialog(dialog, i3);
        AnswersHelper.f128199a.N();
        BottomsheetDialogAccessibilityPrivacyBinding bottomsheetDialogAccessibilityPrivacyBindingC = BottomsheetDialogAccessibilityPrivacyBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(bottomsheetDialogAccessibilityPrivacyBindingC, "inflate(...)");
        this.f111961c = bottomsheetDialogAccessibilityPrivacyBindingC;
        BottomsheetDialogAccessibilityPrivacyBinding bottomsheetDialogAccessibilityPrivacyBinding = null;
        String str = FptyjHFU.udSE;
        if (bottomsheetDialogAccessibilityPrivacyBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            bottomsheetDialogAccessibilityPrivacyBindingC = null;
        }
        final NestedScrollView root = bottomsheetDialogAccessibilityPrivacyBindingC.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        StrictModeOption strictModeOption = StrictModeOption.BlockSettings;
        int i4 = (strictModeOption.isBlockingFGSTaskManager() || strictModeOption.isBlockingUserChange() || strictModeOption.isBlockingSplitScreen() || strictModeOption.isBlockingUninstall()) ? cz.mobilesoft.coreblock.R.string.f95805j : cz.mobilesoft.coreblock.R.string.f95800i;
        BottomsheetDialogAccessibilityPrivacyBinding bottomsheetDialogAccessibilityPrivacyBinding2 = this.f111961c;
        if (bottomsheetDialogAccessibilityPrivacyBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            bottomsheetDialogAccessibilityPrivacyBinding2 = null;
        }
        bottomsheetDialogAccessibilityPrivacyBinding2.f96501c.setText(StringHelper.h(getString(i4, getString(cz.mobilesoft.coreblock.R.string.f95790f1))));
        BottomsheetDialogAccessibilityPrivacyBinding bottomsheetDialogAccessibilityPrivacyBinding3 = this.f111961c;
        if (bottomsheetDialogAccessibilityPrivacyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            bottomsheetDialogAccessibilityPrivacyBinding = bottomsheetDialogAccessibilityPrivacyBinding3;
        }
        ViewBottomButtonsBinding viewBottomButtonsBinding = bottomsheetDialogAccessibilityPrivacyBinding.f96500b;
        viewBottomButtonsBinding.f96858d.setText(getString(cz.mobilesoft.coreblock.R.string.Re));
        viewBottomButtonsBinding.f96858d.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.permission.old.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccessibilityPrivacyBottomSheet.H(this.f111980a, view);
            }
        });
        Button secondaryButton = viewBottomButtonsBinding.f96858d;
        Intrinsics.checkNotNullExpressionValue(secondaryButton, "secondaryButton");
        secondaryButton.setVisibility(0);
        viewBottomButtonsBinding.f96856b.setText(getString(cz.mobilesoft.coreblock.R.string.f95806j0));
        viewBottomButtonsBinding.f96856b.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.permission.old.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccessibilityPrivacyBottomSheet.I(this.f111981a, view);
            }
        });
        dialog.setContentView(root);
        C(root);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: cz.mobilesoft.coreblock.scene.permission.old.c
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                AccessibilityPrivacyBottomSheet.J(root, dialogInterface);
            }
        });
    }
}
