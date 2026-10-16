package cz.mobilesoft.coreblock.scene.permission;

import android.animation.Animator;
import com.google.android.material.switchmaterial.SwitchMaterial;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PermissionWizardActivity$setupBottomSheetView$1$2 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PermissionWizardActivity f111806a;

    PermissionWizardActivity$setupBottomSheetView$1$2(PermissionWizardActivity permissionWizardActivity) {
        this.f111806a = permissionWizardActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PermissionWizardActivity permissionWizardActivity) {
        permissionWizardActivity.W().setPressed(false);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (this.f111806a.W().isChecked()) {
            return;
        }
        this.f111806a.W().setPressed(true);
        this.f111806a.W().setChecked(true);
        SwitchMaterial switchMaterialW = this.f111806a.W();
        final PermissionWizardActivity permissionWizardActivity = this.f111806a;
        switchMaterialW.postDelayed(new Runnable() { // from class: cz.mobilesoft.coreblock.scene.permission.r
            @Override // java.lang.Runnable
            public final void run() {
                PermissionWizardActivity$setupBottomSheetView$1$2.b(permissionWizardActivity);
            }
        }, 500L);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }
}
