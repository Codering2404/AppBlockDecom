package cz.mobilesoft.coreblock.util.helperextension;

import android.R;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.databinding.DialogBlockingReasonBinding;
import cz.mobilesoft.coreblock.databinding.DialogGenerateBackdoorCodeBinding;
import cz.mobilesoft.coreblock.databinding.LayoutSimpleEdittextBinding;
import cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeUtils;
import cz.mobilesoft.coreblock.view.bottomsheet.InfoBottomSheetDialogFragment;
import cz.mobilesoft.coreblock.view.dialog.SingleChoiceAdapter;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class DialogHelperExtKt {
    public static /* synthetic */ void A(Activity activity, int i3, Integer num, int i4, int i5, Function0 function0, Function0 function02, boolean z2, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            num = null;
        }
        if ((i6 & 4) != 0) {
            i4 = R.string.ok;
        }
        if ((i6 & 8) != 0) {
            i5 = R.string.cancel;
        }
        if ((i6 & 16) != 0) {
            function0 = null;
        }
        if ((i6 & 32) != 0) {
            function02 = null;
        }
        if ((i6 & 64) != 0) {
            z2 = false;
        }
        y(activity, i3, num, i4, i5, function0, function02, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Function0 function0, DialogInterface dialogInterface, int i3) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function0 function0, DialogInterface dialogInterface, int i3) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void D(final Context context, String str, final String str2, String str3, final boolean z2, Integer num, int i3, final Function0 function0, final int i4, final Function1 onInput) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(onInput, "onInput");
        LayoutSimpleEdittextBinding layoutSimpleEdittextBindingC = LayoutSimpleEdittextBinding.c(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(layoutSimpleEdittextBindingC, "inflate(...)");
        final EditText editText = layoutSimpleEdittextBindingC.f96815b;
        Intrinsics.checkNotNullExpressionValue(editText, "editText");
        final TextView limitTextView = layoutSimpleEdittextBindingC.f96816c;
        Intrinsics.checkNotNullExpressionValue(limitTextView, "limitTextView");
        if (i3 == 1) {
            editText.setSingleLine(true);
        }
        editText.setMaxLines(i3);
        if (i4 > 0) {
            editText.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(i4)});
            limitTextView.setText(context.getString(cz.mobilesoft.coreblock.R.string.Yi, String.valueOf(editText.getText().length()), String.valueOf(i4)));
            limitTextView.setVisibility(0);
            editText.addTextChangedListener(new TextWatcher() { // from class: cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt$showSimpleEditTextDialog$$inlined$addTextChangedListener$default$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    limitTextView.setText(context.getString(cz.mobilesoft.coreblock.R.string.Yi, String.valueOf(editable != null ? Integer.valueOf(editable.length()) : null), String.valueOf(i4)));
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                }
            });
        }
        if (str2 != null) {
            editText.setText(str2);
        }
        if (str3 != null) {
            editText.setHint(str3);
        }
        if (num != null) {
            editText.setInputType(num.intValue());
        }
        final AlertDialog alertDialogA = new MaterialAlertDialogBuilder(new ContextThemeWrapper(context, cz.mobilesoft.coreblock.R.style.f95868c)).t(str).u(layoutSimpleEdittextBindingC.getRoot()).L(cz.mobilesoft.coreblock.R.string.Lt, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                DialogHelperExtKt.F(onInput, editText, dialogInterface, i5);
            }
        }).G(R.string.cancel, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                DialogHelperExtKt.G(function0, dialogInterface, i5);
            }
        }).J(new DialogInterface.OnCancelListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.q
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DialogHelperExtKt.H(function0, dialogInterface);
            }
        }).a();
        Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.r
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
                return DialogHelperExtKt.I(alertDialogA, onInput, editText, textView, i5, keyEvent);
            }
        });
        alertDialogA.setOnShowListener(new DialogInterface.OnShowListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.s
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DialogHelperExtKt.J(alertDialogA, editText, str2, z2, dialogInterface);
            }
        });
        alertDialogA.show();
    }

    public static /* synthetic */ void E(Context context, String str, String str2, String str3, boolean z2, Integer num, int i3, Function0 function0, int i4, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = null;
        }
        if ((i5 & 2) != 0) {
            str2 = null;
        }
        if ((i5 & 4) != 0) {
            str3 = null;
        }
        if ((i5 & 8) != 0) {
            z2 = false;
        }
        if ((i5 & 16) != 0) {
            num = null;
        }
        if ((i5 & 32) != 0) {
            i3 = 2;
        }
        if ((i5 & 64) != 0) {
            function0 = null;
        }
        if ((i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            i4 = 0;
        }
        D(context, str, str2, str3, z2, num, i3, function0, i4, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 function1, EditText editText, DialogInterface dialogInterface, int i3) {
        function1.invoke(editText.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Function0 function0, DialogInterface dialogInterface, int i3) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function0 function0, DialogInterface dialogInterface) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I(AlertDialog alertDialog, Function1 function1, EditText editText, TextView textView, int i3, KeyEvent keyEvent) {
        if (i3 != 6 || !alertDialog.j(-1).isEnabled()) {
            return false;
        }
        function1.invoke(editText.getText().toString());
        alertDialog.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(final AlertDialog alertDialog, EditText editText, String str, final boolean z2, DialogInterface dialogInterface) {
        Window window = alertDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt$showSimpleEditTextDialog$3$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s2) {
                Intrinsics.checkNotNullParameter(s2, "s");
                alertDialog.j(-1).setEnabled((z2 && s2.toString().length() == 0) || s2.toString().length() > 0);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s2, int i3, int i4, int i5) {
                Intrinsics.checkNotNullParameter(s2, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s2, int i3, int i4, int i5) {
                Intrinsics.checkNotNullParameter(s2, "s");
            }
        });
        if (str != null) {
            editText.setText(str);
        } else {
            editText.setText("");
        }
        editText.requestFocus();
        int length = str != null ? str.length() : 0;
        editText.setSelection(length, length);
    }

    public static final void K(Activity activity, CharSequence title, CharSequence charSequence, boolean z2, final Function0 function0) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        AlertDialog alertDialogA = new MaterialAlertDialogBuilder(activity, cz.mobilesoft.coreblock.R.style.f95867b).t(title).h(charSequence).L(R.string.ok, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogHelperExtKt.M(function0, dialogInterface, i3);
            }
        }).d(z2).a();
        alertDialogA.setCanceledOnTouchOutside(z2);
        alertDialogA.show();
    }

    public static /* synthetic */ void L(Activity activity, CharSequence charSequence, CharSequence charSequence2, boolean z2, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            charSequence2 = null;
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        if ((i3 & 8) != 0) {
            function0 = null;
        }
        K(activity, charSequence, charSequence2, z2, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function0 function0, DialogInterface dialogInterface, int i3) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void N(AlertDialog.Builder builder, String[] items, int i3, Collection premiumIndices, DialogInterface.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(premiumIndices, "premiumIndices");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Context contextB = builder.b();
        Intrinsics.checkNotNullExpressionValue(contextB, "getContext(...)");
        builder.q(new SingleChoiceAdapter(contextB, items, premiumIndices), i3, listener);
    }

    public static /* synthetic */ void O(AlertDialog.Builder builder, String[] strArr, int i3, Collection collection, DialogInterface.OnClickListener onClickListener, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            collection = SetsKt.emptySet();
        }
        N(builder, strArr, i3, collection, onClickListener);
    }

    public static final void o(Context context, boolean z2, Spanned strictModeBlockingText, final Function0 onContactSupport, final Function0 onCancelListener, final Function0 excludeUnsupportedBrowser) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(strictModeBlockingText, "strictModeBlockingText");
        Intrinsics.checkNotNullParameter(onContactSupport, "onContactSupport");
        Intrinsics.checkNotNullParameter(onCancelListener, "onCancelListener");
        Intrinsics.checkNotNullParameter(excludeUnsupportedBrowser, "excludeUnsupportedBrowser");
        DialogBlockingReasonBinding dialogBlockingReasonBindingC = DialogBlockingReasonBinding.c(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(dialogBlockingReasonBindingC, "inflate(...)");
        dialogBlockingReasonBindingC.f96513b.setText(strictModeBlockingText);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (z2) {
            Button excludeFromUnsupportedBrowsersButton = dialogBlockingReasonBindingC.f96514c;
            Intrinsics.checkNotNullExpressionValue(excludeFromUnsupportedBrowsersButton, "excludeFromUnsupportedBrowsersButton");
            excludeFromUnsupportedBrowsersButton.setVisibility(0);
            dialogBlockingReasonBindingC.f96514c.setBackground(ContextCompat.getDrawable(context, cz.mobilesoft.coreblock.R.drawable.f95545o));
            dialogBlockingReasonBindingC.f96514c.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogHelperExtKt.q(excludeUnsupportedBrowser, objectRef, view);
                }
            });
        } else {
            Button excludeFromUnsupportedBrowsersButton2 = dialogBlockingReasonBindingC.f96514c;
            Intrinsics.checkNotNullExpressionValue(excludeFromUnsupportedBrowsersButton2, "excludeFromUnsupportedBrowsersButton");
            excludeFromUnsupportedBrowsersButton2.setVisibility(8);
        }
        AlertDialog alertDialogA = new MaterialAlertDialogBuilder(new ContextThemeWrapper(context, cz.mobilesoft.coreblock.R.style.f95866a)).P(cz.mobilesoft.coreblock.R.string.lH).u(dialogBlockingReasonBindingC.getRoot()).L(cz.mobilesoft.coreblock.R.string.i8, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogHelperExtKt.r(onContactSupport, dialogInterface, i3);
            }
        }).I(cz.mobilesoft.coreblock.R.string.N7, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogHelperExtKt.s(onCancelListener, dialogInterface, i3);
            }
        }).J(new DialogInterface.OnCancelListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.n
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DialogHelperExtKt.t(onCancelListener, dialogInterface);
            }
        }).a();
        Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
        objectRef.f140144a = alertDialogA;
        AlertDialog alertDialog = null;
        if (!(context instanceof Activity)) {
            if (alertDialogA == null) {
                Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
                alertDialogA = null;
            }
            Window window = alertDialogA.getWindow();
            if (window != null) {
                window.setType(2038);
            }
        }
        Object obj = objectRef.f140144a;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
        } else {
            alertDialog = (AlertDialog) obj;
        }
        alertDialog.show();
    }

    public static /* synthetic */ void p(Context context, boolean z2, Spanned spanned, Function0 function0, Function0 function02, Function0 function03, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        o(context, z2, spanned, function0, function02, function03);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function0 function0, Ref.ObjectRef objectRef, View view) {
        AlertDialog alertDialog;
        function0.invoke();
        Object obj = objectRef.f140144a;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("alertDialog");
            alertDialog = null;
        } else {
            alertDialog = (AlertDialog) obj;
        }
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function0 function0, DialogInterface dialogInterface, int i3) {
        function0.invoke();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function0 function0, DialogInterface dialogInterface, int i3) {
        function0.invoke();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function0 function0, DialogInterface dialogInterface) {
        function0.invoke();
    }

    public static final void u(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (BuildConfig.f95357b.booleanValue()) {
            final DialogGenerateBackdoorCodeBinding dialogGenerateBackdoorCodeBindingC = DialogGenerateBackdoorCodeBinding.c(LayoutInflater.from(context));
            Intrinsics.checkNotNullExpressionValue(dialogGenerateBackdoorCodeBindingC, "inflate(...)");
            final ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            dialogGenerateBackdoorCodeBindingC.f96516b.setText(BackdoorCodeUtils.Companion.b(BackdoorCodeUtils.f105649a, 0, 1, null));
            dialogGenerateBackdoorCodeBindingC.f96517c.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogHelperExtKt.v(dialogGenerateBackdoorCodeBindingC, clipboardManager, view);
                }
            });
            dialogGenerateBackdoorCodeBindingC.f96518d.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogHelperExtKt.w(dialogGenerateBackdoorCodeBindingC, view);
                }
            });
            AlertDialog alertDialogA = new MaterialAlertDialogBuilder(new ContextThemeWrapper(context, cz.mobilesoft.coreblock.R.style.f95868c)).P(cz.mobilesoft.coreblock.R.string.ca).u(dialogGenerateBackdoorCodeBindingC.getRoot()).I(cz.mobilesoft.coreblock.R.string.N7, null).a();
            Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
            alertDialogA.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(DialogGenerateBackdoorCodeBinding dialogGenerateBackdoorCodeBinding, ClipboardManager clipboardManager, View view) {
        dialogGenerateBackdoorCodeBinding.f96516b.requestFocus();
        ClipData clipDataNewPlainText = ClipData.newPlainText("Code", dialogGenerateBackdoorCodeBinding.f96516b.getText());
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        Snackbar.k0(dialogGenerateBackdoorCodeBinding.f96516b, "Copied to clipboard", -1).Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(DialogGenerateBackdoorCodeBinding dialogGenerateBackdoorCodeBinding, View view) {
        dialogGenerateBackdoorCodeBinding.f96516b.setText(BackdoorCodeUtils.Companion.b(BackdoorCodeUtils.f105649a, 0, 1, null));
    }

    public static final void x(Context context, FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        InfoBottomSheetDialogFragment.Companion companion = InfoBottomSheetDialogFragment.f130198c;
        String string = context.getString(cz.mobilesoft.coreblock.R.string.Of);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(cz.mobilesoft.coreblock.R.string.pi, context.getString(cz.mobilesoft.coreblock.R.string.qi));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        companion.a(fragmentManager, new InfoBottomSheetDialogFragment.InfoBottomSheetSetupDTO(string, string2));
    }

    public static final void y(Activity activity, int i3, Integer num, int i4, int i5, Function0 function0, Function0 function02, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        String string = activity.getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        z(activity, string, num != null ? activity.getString(num.intValue()) : null, i4, i5, function0, function02, z2);
    }

    public static final void z(Activity activity, CharSequence title, CharSequence charSequence, int i3, int i4, final Function0 function0, final Function0 function02, boolean z2) {
        TextView textView;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        AlertDialog alertDialogV = new MaterialAlertDialogBuilder(activity, cz.mobilesoft.coreblock.R.style.f95867b).t(title).h(charSequence).L(i3, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                DialogHelperExtKt.B(function0, dialogInterface, i5);
            }
        }).G(i4, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                DialogHelperExtKt.C(function02, dialogInterface, i5);
            }
        }).v();
        if (!z2 || (textView = (TextView) alertDialogV.findViewById(R.id.message)) == null) {
            return;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
