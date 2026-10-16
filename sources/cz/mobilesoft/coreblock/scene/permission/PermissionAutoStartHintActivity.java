package cz.mobilesoft.coreblock.scene.permission;

import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.permission.PermissionBaseWizardActivity;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
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
public final class PermissionAutoStartHintActivity extends PermissionBaseWizardActivity {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f111786k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f111787l = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) PermissionAutoStartHintActivity.class);
            intent.addFlags(536870912);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(View view, final PermissionAutoStartHintActivity permissionAutoStartHintActivity) {
        View viewFindViewById = view.findViewById(R.id.D0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        View viewFindViewById2 = view.findViewById(R.id.f95662s1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((TextView) viewFindViewById).setText(StringHelper.h(permissionAutoStartHintActivity.getString(R.string.Kn)));
        ((Button) viewFindViewById2).setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.permission.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PermissionAutoStartHintActivity.l0(this.f111826a, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(PermissionAutoStartHintActivity permissionAutoStartHintActivity, View view) {
        permissionAutoStartHintActivity.finish();
    }

    @Override // cz.mobilesoft.coreblock.scene.permission.PermissionBaseWizardActivity
    public void a0() {
        f0(LayoutInflater.from(new ContextThemeWrapper(this, R.style.f95866a)).inflate(R.layout.f95695f0, Z()));
    }

    @Override // cz.mobilesoft.coreblock.scene.permission.PermissionBaseWizardActivity
    public void g0(final View view, PermissionBaseWizardActivity.AnimationState animationState) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.post(new Runnable() { // from class: cz.mobilesoft.coreblock.scene.permission.k
            @Override // java.lang.Runnable
            public final void run() {
                PermissionAutoStartHintActivity.k0(view, this);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.permission.PermissionBaseWizardActivity
    public void h0() {
        f111786k.a(this);
    }
}
