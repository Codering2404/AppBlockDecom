package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.CompoundButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.FragmentDisclaimerDialogBinding;
import cz.mobilesoft.coreblock.scene.more.academy.lesson.AcademyClosingLessonDialog;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
public final class AcademyClosingLessonDialog extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f106208b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f106209c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentDisclaimerDialogBinding f106210a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(Function0 function0, String requestKey, Bundle bundle) {
            Intrinsics.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            if (Intrinsics.areEqual(requestKey, "USER_INTERACTED") && bundle.getBoolean("IS_SUCCESSFUL")) {
                function0.invoke();
            }
            return Unit.f139807a;
        }

        public final AcademyClosingLessonDialog b(FragmentManager fragmentManager, final Function0 onClosed) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(onClosed, "onClosed");
            AcademyClosingLessonDialog academyClosingLessonDialog = new AcademyClosingLessonDialog();
            academyClosingLessonDialog.show(fragmentManager, AcademyClosingLessonDialog.class.getSimpleName());
            FragmentKt.c(academyClosingLessonDialog, "USER_INTERACTED", new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AcademyClosingLessonDialog.Companion.c(onClosed, (String) obj, (Bundle) obj2);
                }
            });
            return academyClosingLessonDialog;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(CompoundButton compoundButton, boolean z2) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        PrefManager.f126839a.z2(!z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(AcademyClosingLessonDialog academyClosingLessonDialog, DialogInterface dialogInterface, int i3) {
        FragmentKt.b(academyClosingLessonDialog, "USER_INTERACTED", BundleKt.b(TuplesKt.a("IS_SUCCESSFUL", Boolean.TRUE)));
        academyClosingLessonDialog.dismiss();
    }

    public final FragmentDisclaimerDialogBinding A() {
        FragmentDisclaimerDialogBinding fragmentDisclaimerDialogBinding = this.f106210a;
        if (fragmentDisclaimerDialogBinding != null) {
            return fragmentDisclaimerDialogBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void D(FragmentDisclaimerDialogBinding fragmentDisclaimerDialogBinding) {
        Intrinsics.checkNotNullParameter(fragmentDisclaimerDialogBinding, "<set-?>");
        this.f106210a = fragmentDisclaimerDialogBinding;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireActivity());
        FragmentDisclaimerDialogBinding fragmentDisclaimerDialogBindingC = FragmentDisclaimerDialogBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(fragmentDisclaimerDialogBindingC, "inflate(...)");
        D(fragmentDisclaimerDialogBindingC);
        FragmentDisclaimerDialogBinding fragmentDisclaimerDialogBindingA = A();
        fragmentDisclaimerDialogBindingA.f96636b.setText(getString(R.string.Gi, getString(R.string.Li)));
        fragmentDisclaimerDialogBindingA.f96636b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        fragmentDisclaimerDialogBindingA.f96637c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                AcademyClosingLessonDialog.B(compoundButton, z2);
            }
        });
        materialAlertDialogBuilder.u(A().getRoot()).P(R.string.Fi).L(R.string.vA, null).G(R.string.Ei, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.academy.lesson.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AcademyClosingLessonDialog.C(this.f106330a, dialogInterface, i3);
            }
        });
        AlertDialog alertDialogA = materialAlertDialogBuilder.a();
        Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
        return alertDialogA;
    }
}
