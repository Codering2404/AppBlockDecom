package cz.mobilesoft.coreblock.scene.lockscreen.ossettings;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import cz.mobilesoft.coreblock.databinding.BottomsheetDialogSystemSettingsBinding;
import cz.mobilesoft.coreblock.databinding.ItemListSystemSettingsBinding;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class SystemSettingsBottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f105755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f105756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f105757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f105758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BottomSheetDialog f105759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BottomsheetDialogSystemSettingsBinding f105760f;

    public SystemSettingsBottomSheetDialog(Context context, Set selectedAvailableSettings, Function1 onItemClickListener, Function0 onCancelListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectedAvailableSettings, "selectedAvailableSettings");
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        Intrinsics.checkNotNullParameter(onCancelListener, "onCancelListener");
        this.f105755a = context;
        this.f105756b = selectedAvailableSettings;
        this.f105757c = onItemClickListener;
        this.f105758d = onCancelListener;
    }

    private final void d(BottomsheetDialogSystemSettingsBinding bottomsheetDialogSystemSettingsBinding, LayoutInflater layoutInflater) {
        for (Pair pair : SystemSettingsType.Companion.b(this.f105755a, this.f105756b)) {
            final SystemSettingsType systemSettingsType = (SystemSettingsType) pair.a();
            final Intent intent = (Intent) pair.b();
            ItemListSystemSettingsBinding itemListSystemSettingsBindingC = ItemListSystemSettingsBinding.c(layoutInflater, bottomsheetDialogSystemSettingsBinding.f96510b, false);
            itemListSystemSettingsBindingC.getRoot().setText(systemSettingsType.getTitleResId());
            itemListSystemSettingsBindingC.getRoot().setCompoundDrawablesRelativeWithIntrinsicBounds(systemSettingsType.getIconResId(), 0, 0, 0);
            itemListSystemSettingsBindingC.getRoot().setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SystemSettingsBottomSheetDialog.e(systemSettingsType, this, intent, view);
                }
            });
            bottomsheetDialogSystemSettingsBinding.f96510b.addView(itemListSystemSettingsBindingC.getRoot());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(SystemSettingsType systemSettingsType, SystemSettingsBottomSheetDialog systemSettingsBottomSheetDialog, Intent intent, View view) {
        AnswersHelper.f128199a.x0(systemSettingsType);
        BottomSheetDialog bottomSheetDialog = systemSettingsBottomSheetDialog.f105759e;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog = null;
        }
        bottomSheetDialog.dismiss();
        systemSettingsBottomSheetDialog.f105757c.invoke(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(SystemSettingsBottomSheetDialog systemSettingsBottomSheetDialog, DialogInterface dialogInterface) {
        systemSettingsBottomSheetDialog.f105758d.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(SystemSettingsBottomSheetDialog systemSettingsBottomSheetDialog, DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog = systemSettingsBottomSheetDialog.f105759e;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog = null;
        }
        View viewFindViewById = bottomSheetDialog.findViewById(R.id.f79632g);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundResource(cz.mobilesoft.coreblock.R.drawable.f95541n);
        }
    }

    public final void f() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f105755a);
        BottomsheetDialogSystemSettingsBinding bottomsheetDialogSystemSettingsBindingC = BottomsheetDialogSystemSettingsBinding.c(layoutInflaterFrom);
        Intrinsics.checkNotNullExpressionValue(bottomsheetDialogSystemSettingsBindingC, "inflate(...)");
        this.f105760f = bottomsheetDialogSystemSettingsBindingC;
        BottomSheetDialog bottomSheetDialog = null;
        if (bottomsheetDialogSystemSettingsBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bottomsheetDialogSystemSettingsBindingC = null;
        }
        Intrinsics.checkNotNull(layoutInflaterFrom);
        d(bottomsheetDialogSystemSettingsBindingC, layoutInflaterFrom);
        BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(new ContextThemeWrapper(this.f105755a, cz.mobilesoft.coreblock.R.style.f95866a));
        this.f105759e = bottomSheetDialog2;
        bottomSheetDialog2.setContentView(bottomsheetDialogSystemSettingsBindingC.getRoot());
        if (!(this.f105755a instanceof Activity)) {
            BottomSheetDialog bottomSheetDialog3 = this.f105759e;
            if (bottomSheetDialog3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialog");
                bottomSheetDialog3 = null;
            }
            Window window = bottomSheetDialog3.getWindow();
            if (window != null) {
                window.setType(2038);
            }
        }
        BottomSheetDialog bottomSheetDialog4 = this.f105759e;
        if (bottomSheetDialog4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog4 = null;
        }
        bottomSheetDialog4.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.h
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                SystemSettingsBottomSheetDialog.g(this.f105766a, dialogInterface);
            }
        });
        BottomSheetDialog bottomSheetDialog5 = this.f105759e;
        if (bottomSheetDialog5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog5 = null;
        }
        Window window2 = bottomSheetDialog5.getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawableResource(android.R.color.transparent);
        }
        BottomSheetDialog bottomSheetDialog6 = this.f105759e;
        if (bottomSheetDialog6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog6 = null;
        }
        bottomSheetDialog6.setOnShowListener(new DialogInterface.OnShowListener() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.i
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                SystemSettingsBottomSheetDialog.h(this.f105767a, dialogInterface);
            }
        });
        BottomSheetDialog bottomSheetDialog7 = this.f105759e;
        if (bottomSheetDialog7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        } else {
            bottomSheetDialog = bottomSheetDialog7;
        }
        bottomSheetDialog.show();
    }
}
