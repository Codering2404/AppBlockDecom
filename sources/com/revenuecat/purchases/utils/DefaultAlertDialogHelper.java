package com.revenuecat.purchases.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DefaultAlertDialogHelper implements AlertDialogHelper {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$0(Function0 function0, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$1(Function0 function0, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$2(Function0 function0, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        function0.invoke();
    }

    @Override // com.revenuecat.purchases.utils.AlertDialogHelper
    public void showDialog(Activity activity, String title, String message, String positiveButtonText, String negativeButtonText, String str, final Function0<Unit> onPositiveButtonClicked, final Function0<Unit> onNegativeButtonClicked, final Function0<Unit> onNeutralButtonClicked) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(positiveButtonText, "positiveButtonText");
        Intrinsics.checkNotNullParameter(negativeButtonText, "negativeButtonText");
        Intrinsics.checkNotNullParameter(str, bfIdKSjLOVjG.njtlt);
        Intrinsics.checkNotNullParameter(onPositiveButtonClicked, "onPositiveButtonClicked");
        Intrinsics.checkNotNullParameter(onNegativeButtonClicked, "onNegativeButtonClicked");
        Intrinsics.checkNotNullParameter(onNeutralButtonClicked, "onNeutralButtonClicked");
        new AlertDialog.Builder(activity).setTitle(title).setMessage(message).setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() { // from class: com.revenuecat.purchases.utils.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DefaultAlertDialogHelper.showDialog$lambda$0(onPositiveButtonClicked, dialogInterface, i3);
            }
        }).setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() { // from class: com.revenuecat.purchases.utils.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DefaultAlertDialogHelper.showDialog$lambda$1(onNegativeButtonClicked, dialogInterface, i3);
            }
        }).setNeutralButton(str, new DialogInterface.OnClickListener() { // from class: com.revenuecat.purchases.utils.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DefaultAlertDialogHelper.showDialog$lambda$2(onNeutralButtonClicked, dialogInterface, i3);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.revenuecat.purchases.utils.d
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                onNeutralButtonClicked.invoke();
            }
        }).show();
    }
}
