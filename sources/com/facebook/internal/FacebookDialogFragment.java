package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookWebFallbackDialog;
import com.facebook.internal.WebDialog;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class FacebookDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "FacebookDialogFragment";
    private Dialog innerDialog;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDialog$lambda$0(FacebookDialogFragment this$0, Bundle bundle, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onCompleteWebDialog(bundle, facebookException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDialog$lambda$1(FacebookDialogFragment this$0, Bundle bundle, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onCompleteWebFallbackDialog(bundle);
    }

    private final void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "fragmentActivity.intent");
        activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(intent, bundle, facebookException));
        activity.finish();
    }

    private final void onCompleteWebFallbackDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }

    public final Dialog getInnerDialog() {
        return this.innerDialog;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if ((this.innerDialog instanceof WebDialog) && isResumed()) {
            Dialog dialog = this.innerDialog;
            Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.facebook.internal.WebDialog");
            ((WebDialog) dialog).resize();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initDialog$facebook_common_release();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.innerDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type android.app.Dialog");
            return dialog;
        }
        onCompleteWebDialog(null, null);
        setShowsDialog(false);
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = this.innerDialog;
        if (dialog instanceof WebDialog) {
            Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.facebook.internal.WebDialog");
            ((WebDialog) dialog).resize();
        }
    }

    public final void setInnerDialog(Dialog dialog) {
        this.innerDialog = dialog;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void initDialog$facebook_common_release() {
        FragmentActivity activity;
        WebDialog webDialogNewInstance;
        if (this.innerDialog == null && (activity = getActivity()) != null) {
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(intent);
            if (methodArgumentsFromIntent != null ? methodArgumentsFromIntent.getBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, false) : false) {
                String string = methodArgumentsFromIntent != null ? methodArgumentsFromIntent.getString("url") : null;
                if (Utility.isNullOrEmpty(string)) {
                    Utility.logd(TAG, wgbAZXYjrv.oWrhDoI);
                    activity.finish();
                    return;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str = String.format("fb%s://bridge/", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                FacebookWebFallbackDialog.Companion companion = FacebookWebFallbackDialog.Companion;
                Intrinsics.checkNotNull(string, "null cannot be cast to non-null type kotlin.String");
                webDialogNewInstance = companion.newInstance(activity, string, str);
                webDialogNewInstance.setOnCompleteListener(new WebDialog.OnCompleteListener() { // from class: com.facebook.internal.c
                    @Override // com.facebook.internal.WebDialog.OnCompleteListener
                    public final void onComplete(Bundle bundle, FacebookException facebookException) {
                        FacebookDialogFragment.initDialog$lambda$1(this.f68153a, bundle, facebookException);
                    }
                });
            } else {
                String string2 = methodArgumentsFromIntent != null ? methodArgumentsFromIntent.getString("action") : null;
                Bundle bundle = methodArgumentsFromIntent != null ? methodArgumentsFromIntent.getBundle(NativeProtocol.WEB_DIALOG_PARAMS) : null;
                if (Utility.isNullOrEmpty(string2)) {
                    Utility.logd(TAG, "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                } else {
                    Intrinsics.checkNotNull(string2, "null cannot be cast to non-null type kotlin.String");
                    webDialogNewInstance = new WebDialog.Builder(activity, string2, bundle).setOnCompleteListener(new WebDialog.OnCompleteListener() { // from class: com.facebook.internal.b
                        @Override // com.facebook.internal.WebDialog.OnCompleteListener
                        public final void onComplete(Bundle bundle2, FacebookException facebookException) {
                            FacebookDialogFragment.initDialog$lambda$0(this.f68152a, bundle2, facebookException);
                        }
                    }).build();
                }
            }
            this.innerDialog = webDialogNewInstance;
        }
    }
}
