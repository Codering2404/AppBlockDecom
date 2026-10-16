package cz.mobilesoft.coreblock.scene.permission;

import android.content.ComponentName;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class PermissionBaseWizardActivity$getWrapper$1 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f111800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PermissionBaseWizardActivity f111801b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionBaseWizardActivity$getWrapper$1(PermissionBaseWizardActivity permissionBaseWizardActivity) {
        super(permissionBaseWizardActivity);
        this.f111801b = permissionBaseWizardActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PermissionBaseWizardActivity permissionBaseWizardActivity, PermissionBaseWizardActivity$getWrapper$1 permissionBaseWizardActivity$getWrapper$1) {
        String className;
        ComponentName componentNameY = permissionBaseWizardActivity.Y();
        if (componentNameY == null || (className = componentNameY.getClassName()) == null) {
            className = "";
        }
        String packageName = permissionBaseWizardActivity.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        if (!StringsKt.U(className, packageName, false, 2, null) && !StringsKt.U(className, "cz.mobilesoft.coreblock", false, 2, null) && !StringsKt.E(className, "SubSettings", false, 2, null) && !StringsKt.E(className, "AccessibilitySettingsActivity", false, 2, null)) {
            if (permissionBaseWizardActivity.isFinishing()) {
                return;
            }
            permissionBaseWizardActivity.h0();
        } else {
            if (permissionBaseWizardActivity.V() != permissionBaseWizardActivity.b0()) {
                permissionBaseWizardActivity.U();
                return;
            }
            int i3 = permissionBaseWizardActivity$getWrapper$1.f111800a;
            if (i3 < 2) {
                permissionBaseWizardActivity$getWrapper$1.f111800a = i3 + 1;
            } else {
                permissionBaseWizardActivity.U();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getKeyCode() != 4 || event.getAction() != 1) {
            return super.dispatchKeyEvent(event);
        }
        this.f111801b.U();
        return true;
    }

    public final int getTouchCount() {
        return this.f111800a;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Handler handler = new Handler();
        final PermissionBaseWizardActivity permissionBaseWizardActivity = this.f111801b;
        handler.postDelayed(new Runnable() { // from class: cz.mobilesoft.coreblock.scene.permission.n
            @Override // java.lang.Runnable
            public final void run() {
                PermissionBaseWizardActivity$getWrapper$1.b(permissionBaseWizardActivity, this);
            }
        }, 200L);
        return super.onTouchEvent(motionEvent);
    }

    public final void setTouchCount(int i3) {
        this.f111800a = i3;
    }
}
