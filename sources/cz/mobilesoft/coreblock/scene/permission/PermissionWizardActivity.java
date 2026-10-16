package cz.mobilesoft.coreblock.scene.permission;

import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.permission.PermissionBaseWizardActivity;
import kotlin.Metadata;
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
public final class PermissionWizardActivity extends PermissionBaseWizardActivity {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f111804k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f111805l = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(Companion companion, Context context, PermissionBaseWizardActivity.AnimationState animationState, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                animationState = null;
            }
            companion.b(context, animationState);
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            c(this, context, null, 2, null);
        }

        public final void b(Context context, PermissionBaseWizardActivity.AnimationState animationState) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) PermissionWizardActivity.class);
            if (animationState != null) {
                intent.putExtra("STATE", animationState);
            }
            intent.addFlags(536870912);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l0(android.view.View r8, final cz.mobilesoft.coreblock.scene.permission.PermissionWizardActivity r9, cz.mobilesoft.coreblock.scene.permission.PermissionBaseWizardActivity.AnimationState r10) {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.PermissionWizardActivity.l0(android.view.View, cz.mobilesoft.coreblock.scene.permission.PermissionWizardActivity, cz.mobilesoft.coreblock.scene.permission.PermissionBaseWizardActivity$AnimationState):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(PermissionWizardActivity permissionWizardActivity, View view) {
        permissionWizardActivity.U();
    }

    public static final void o0(Context context) {
        f111804k.a(context);
    }

    @Override // cz.mobilesoft.coreblock.scene.permission.PermissionBaseWizardActivity
    public void a0() {
        f0(LayoutInflater.from(new ContextThemeWrapper(this, R.style.f95866a)).inflate(R.layout.f95697g0, Z()));
    }

    @Override // cz.mobilesoft.coreblock.scene.permission.PermissionBaseWizardActivity
    public void g0(final View view, final PermissionBaseWizardActivity.AnimationState animationState) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.post(new Runnable() { // from class: cz.mobilesoft.coreblock.scene.permission.o
            @Override // java.lang.Runnable
            public final void run() {
                PermissionWizardActivity.l0(view, this, animationState);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.permission.PermissionBaseWizardActivity
    public void h0() {
        f111804k.b(this, new PermissionBaseWizardActivity.AnimationState(X().getX(), X().getY(), W().isChecked()));
    }
}
