package cz.mobilesoft.coreblock.view.bottomsheet;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;
import cz.mobilesoft.coreblock.databinding.BottomsheetDialogInfoBinding;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import java.io.Serializable;
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
public final class InfoBottomSheetDialogFragment extends BaseBottomSheetDialogFragment {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f130198c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f130199d = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BottomsheetDialogInfoBinding f130200b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InfoBottomSheetDialogFragment a(FragmentManager fragmentManager, InfoBottomSheetSetupDTO setup) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(setup, "setup");
            InfoBottomSheetDialogFragment infoBottomSheetDialogFragment = new InfoBottomSheetDialogFragment();
            infoBottomSheetDialogFragment.setArguments(BundleKt.b(TuplesKt.a("SETUP", setup)));
            infoBottomSheetDialogFragment.showNow(fragmentManager, InfoBottomSheetDialogFragment.class.getSimpleName());
            return infoBottomSheetDialogFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InfoBottomSheetSetupDTO implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f130201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f130202b;

        public InfoBottomSheetSetupDTO(String titleText, String descriptionText) {
            Intrinsics.checkNotNullParameter(titleText, "titleText");
            Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
            this.f130201a = titleText;
            this.f130202b = descriptionText;
        }

        public final String a() {
            return this.f130202b;
        }

        public final String b() {
            return this.f130201a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InfoBottomSheetSetupDTO)) {
                return false;
            }
            InfoBottomSheetSetupDTO infoBottomSheetSetupDTO = (InfoBottomSheetSetupDTO) obj;
            return Intrinsics.areEqual(this.f130201a, infoBottomSheetSetupDTO.f130201a) && Intrinsics.areEqual(this.f130202b, infoBottomSheetSetupDTO.f130202b);
        }

        public int hashCode() {
            return (this.f130201a.hashCode() * 31) + this.f130202b.hashCode();
        }

        public String toString() {
            return "InfoBottomSheetSetupDTO(titleText=" + this.f130201a + ", descriptionText=" + this.f130202b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(NestedScrollView nestedScrollView, DialogInterface dialogInterface) {
        Object parent = nestedScrollView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackgroundColor(ContextCompat.getColor(nestedScrollView.getContext(), R.color.transparent));
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i3) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.setupDialog(dialog, i3);
        Bundle arguments = getArguments();
        BottomsheetDialogInfoBinding bottomsheetDialogInfoBinding = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("SETUP") : null;
        InfoBottomSheetSetupDTO infoBottomSheetSetupDTO = serializable instanceof InfoBottomSheetSetupDTO ? (InfoBottomSheetSetupDTO) serializable : null;
        if (infoBottomSheetSetupDTO == null) {
            dismiss();
            return;
        }
        BottomsheetDialogInfoBinding bottomsheetDialogInfoBindingC = BottomsheetDialogInfoBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(bottomsheetDialogInfoBindingC, "inflate(...)");
        this.f130200b = bottomsheetDialogInfoBindingC;
        if (bottomsheetDialogInfoBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bottomsheetDialogInfoBindingC = null;
        }
        final NestedScrollView root = bottomsheetDialogInfoBindingC.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        BottomsheetDialogInfoBinding bottomsheetDialogInfoBinding2 = this.f130200b;
        if (bottomsheetDialogInfoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bottomsheetDialogInfoBinding2 = null;
        }
        bottomsheetDialogInfoBinding2.f96507d.setText(infoBottomSheetSetupDTO.b());
        BottomsheetDialogInfoBinding bottomsheetDialogInfoBinding3 = this.f130200b;
        if (bottomsheetDialogInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bottomsheetDialogInfoBinding = bottomsheetDialogInfoBinding3;
        }
        TextView messageTextView = bottomsheetDialogInfoBinding.f96506c;
        Intrinsics.checkNotNullExpressionValue(messageTextView, "messageTextView");
        ViewHelperExtKt.k(messageTextView, infoBottomSheetSetupDTO.a(), true);
        dialog.setContentView(root);
        C(root);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                InfoBottomSheetDialogFragment.E(root, dialogInterface);
            }
        });
    }
}
