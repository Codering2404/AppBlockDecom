package com.superwall.sdk.misc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AlertControllerFactory {
    public static final AlertControllerFactory INSTANCE = new AlertControllerFactory();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AlertProps {
        private final Function0<Unit> action;
        private final String actionTitle;
        private final String closeActionTitle;
        private final String message;
        private final Function0<Unit> onClose;
        private final String title;

        public AlertProps() {
            this(null, null, null, null, null, null, 63, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AlertProps copy$default(AlertProps alertProps, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = alertProps.title;
            }
            if ((i3 & 2) != 0) {
                str2 = alertProps.message;
            }
            if ((i3 & 4) != 0) {
                str3 = alertProps.actionTitle;
            }
            if ((i3 & 8) != 0) {
                str4 = alertProps.closeActionTitle;
            }
            if ((i3 & 16) != 0) {
                function0 = alertProps.action;
            }
            if ((i3 & 32) != 0) {
                function02 = alertProps.onClose;
            }
            Function0 function03 = function0;
            Function0 function04 = function02;
            return alertProps.copy(str, str2, str3, str4, function03, function04);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.message;
        }

        public final String component3() {
            return this.actionTitle;
        }

        public final String component4() {
            return this.closeActionTitle;
        }

        public final Function0<Unit> component5() {
            return this.action;
        }

        public final Function0<Unit> component6() {
            return this.onClose;
        }

        public final AlertProps copy(String str, String str2, String str3, String closeActionTitle, Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(closeActionTitle, "closeActionTitle");
            return new AlertProps(str, str2, str3, closeActionTitle, function0, function02);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AlertProps)) {
                return false;
            }
            AlertProps alertProps = (AlertProps) obj;
            return Intrinsics.areEqual(this.title, alertProps.title) && Intrinsics.areEqual(this.message, alertProps.message) && Intrinsics.areEqual(this.actionTitle, alertProps.actionTitle) && Intrinsics.areEqual(this.closeActionTitle, alertProps.closeActionTitle) && Intrinsics.areEqual(this.action, alertProps.action) && Intrinsics.areEqual(this.onClose, alertProps.onClose);
        }

        public final Function0<Unit> getAction() {
            return this.action;
        }

        public final String getActionTitle() {
            return this.actionTitle;
        }

        public final String getCloseActionTitle() {
            return this.closeActionTitle;
        }

        public final String getMessage() {
            return this.message;
        }

        public final Function0<Unit> getOnClose() {
            return this.onClose;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.message;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.actionTitle;
            int iHashCode3 = (((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.closeActionTitle.hashCode()) * 31;
            Function0<Unit> function0 = this.action;
            int iHashCode4 = (iHashCode3 + (function0 == null ? 0 : function0.hashCode())) * 31;
            Function0<Unit> function02 = this.onClose;
            return iHashCode4 + (function02 != null ? function02.hashCode() : 0);
        }

        public AlertProps(String str, String str2, String str3, String closeActionTitle, Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(closeActionTitle, "closeActionTitle");
            this.title = str;
            this.message = str2;
            this.actionTitle = str3;
            this.closeActionTitle = closeActionTitle;
            this.action = function0;
            this.onClose = function02;
        }

        public String toString() {
            return "AlertProps(title=" + this.title + ", message=" + this.message + ", actionTitle=" + this.actionTitle + ", closeActionTitle=" + this.closeActionTitle + ", action=" + this.action + ", onClose=" + this.onClose + jTYhJgqLBN.aaUzkuceUyJ;
        }

        public /* synthetic */ AlertProps(String str, String str2, String str3, String str4, Function0 function0, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? "Done" : str4, (i3 & 16) != 0 ? null : function0, (i3 & 32) != 0 ? null : function02);
        }
    }

    private AlertControllerFactory() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlertDialog make$default(AlertControllerFactory alertControllerFactory, Context context, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        if ((i3 & 8) != 0) {
            str3 = null;
        }
        if ((i3 & 16) != 0) {
            str4 = "Done";
        }
        if ((i3 & 32) != 0) {
            function0 = null;
        }
        if ((i3 & 64) != 0) {
            function02 = null;
        }
        return alertControllerFactory.make(context, str, str2, str3, str4, function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void make$lambda$0(Function0 function0, DialogInterface dialogInterface, int i3) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void make$lambda$1(Function0 function0, DialogInterface dialogInterface, int i3) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final AlertDialog make(Context context, String str, String str2, String str3, String closeActionTitle, final Function0<Unit> function0, final Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(closeActionTitle, "closeActionTitle");
        AlertDialog.Builder message = new AlertDialog.Builder(context).setTitle(str).setMessage(str2);
        if (str3 != null) {
            message.setPositiveButton(str3, new DialogInterface.OnClickListener() { // from class: com.superwall.sdk.misc.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AlertControllerFactory.make$lambda$0(function0, dialogInterface, i3);
                }
            });
        }
        message.setNegativeButton(closeActionTitle, new DialogInterface.OnClickListener() { // from class: com.superwall.sdk.misc.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AlertControllerFactory.make$lambda$1(function02, dialogInterface, i3);
            }
        });
        AlertDialog alertDialogCreate = message.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        return alertDialogCreate;
    }
}
