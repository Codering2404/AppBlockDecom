package com.superwall.sdk.store.testmode.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.superwall.sdk.R;
import com.superwall.sdk.store.testmode.ui.PurchaseSimulationResult;
import com.superwall.sdk.store.testmode.ui.TestModePurchaseDrawer;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

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
public final class TestModePurchaseDrawer {
    public static final TestModePurchaseDrawer INSTANCE = new TestModePurchaseDrawer();

    /* JADX INFO: renamed from: com.superwall.sdk.store.testmode.ui.TestModePurchaseDrawer$show$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.testmode.ui.TestModePurchaseDrawer$show$2", f = "TestModePurchaseDrawer.kt", l = {92}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PurchaseSimulationResult>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ List<String> $entitlementNames;
        final /* synthetic */ boolean $hasFreeTrial;
        final /* synthetic */ String $localizedPrice;
        final /* synthetic */ String $period;
        final /* synthetic */ String $productIdentifier;
        final /* synthetic */ String $trialPeriodText;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Activity activity, String str, boolean z2, String str2, String str3, String str4, List<String> list, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$productIdentifier = str;
            this.$hasFreeTrial = z2;
            this.$trialPeriodText = str2;
            this.$period = str3;
            this.$localizedPrice = str4;
            this.$entitlementNames = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$3$lambda$2(CompletableDeferred completableDeferred, BottomSheetDialog bottomSheetDialog, View view) {
            completableDeferred.J(PurchaseSimulationResult.Purchased.INSTANCE);
            bottomSheetDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$4(CompletableDeferred completableDeferred, BottomSheetDialog bottomSheetDialog, View view) {
            completableDeferred.J(PurchaseSimulationResult.Abandoned.INSTANCE);
            bottomSheetDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$5(CompletableDeferred completableDeferred, BottomSheetDialog bottomSheetDialog, View view) {
            completableDeferred.J(PurchaseSimulationResult.Failed.INSTANCE);
            bottomSheetDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$6(CompletableDeferred completableDeferred, DialogInterface dialogInterface) {
            if (completableDeferred.isCompleted()) {
                return;
            }
            completableDeferred.J(PurchaseSimulationResult.Abandoned.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$activity, this.$productIdentifier, this.$hasFreeTrial, this.$trialPeriodText, this.$period, this.$localizedPrice, this.$entitlementNames, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String str;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            final CompletableDeferred completableDeferredB = CompletableDeferredKt.b(null, 1, null);
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.$activity);
            View viewInflate = LayoutInflater.from(this.$activity).inflate(R.layout.test_mode_purchase_drawer, (ViewGroup) null);
            viewInflate.setBackground(ContextCompat.getDrawable(this.$activity, R.drawable.test_mode_sheet_bg));
            ((TextView) viewInflate.findViewById(R.id.product_id_text)).setText(this.$productIdentifier);
            if (this.$hasFreeTrial && this.$trialPeriodText.length() > 0) {
                View viewFindViewById = viewInflate.findViewById(R.id.trial_text);
                TextView textView = (TextView) viewFindViewById;
                textView.setText(this.$trialPeriodText + " free trial");
                textView.setVisibility(0);
            }
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.price_text);
            if (this.$period.length() > 0) {
                str = this.$localizedPrice + " / " + this.$period;
            } else {
                str = this.$localizedPrice;
            }
            textView2.setText(str);
            if (!this.$entitlementNames.isEmpty()) {
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.entitlements_text);
                textView3.setText("Entitlements: " + CollectionsKt.joinToString$default(this.$entitlementNames, ", ", null, null, 0, null, null, 62, null));
                textView3.setVisibility(0);
            }
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.confirm_button);
            textView4.setText(this.$hasFreeTrial ? "Start Free Trial" : "Confirm Purchase");
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.store.testmode.ui.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestModePurchaseDrawer.AnonymousClass2.invokeSuspend$lambda$3$lambda$2(completableDeferredB, bottomSheetDialog, view);
                }
            });
            ((TextView) viewInflate.findViewById(R.id.close_button)).setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.store.testmode.ui.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestModePurchaseDrawer.AnonymousClass2.invokeSuspend$lambda$4(completableDeferredB, bottomSheetDialog, view);
                }
            });
            ((TextView) viewInflate.findViewById(R.id.fail_button)).setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.store.testmode.ui.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestModePurchaseDrawer.AnonymousClass2.invokeSuspend$lambda$5(completableDeferredB, bottomSheetDialog, view);
                }
            });
            bottomSheetDialog.setContentView(viewInflate);
            bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.superwall.sdk.store.testmode.ui.o
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    TestModePurchaseDrawer.AnonymousClass2.invokeSuspend$lambda$6(completableDeferredB, dialogInterface);
                }
            });
            bottomSheetDialog.show();
            this.label = 1;
            Object objAwait = completableDeferredB.await(this);
            return objAwait == objF ? objF : objAwait;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PurchaseSimulationResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    private TestModePurchaseDrawer() {
    }

    public final Object show(Activity activity, String str, String str2, String str3, boolean z2, String str4, List<String> list, Continuation<? super PurchaseSimulationResult> continuation) {
        return BuildersKt.g(Dispatchers.c(), new AnonymousClass2(activity, str, z2, str4, str3, str2, list, null), continuation);
    }
}
