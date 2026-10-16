package com.revenuecat.purchases.ui.revenuecatui.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.customercenter.CustomerCenterManagementOption;
import com.revenuecat.purchases.customercenter.Resumable;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterOptions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
public final class CustomerCenterView extends CompatComposeView {
    public static final int $stable = 8;
    private CustomerCenterListener customerCenterListener;
    private final CustomerCenterOptions customerCenterOptions;
    private Function0<Unit> dismissHandler;
    private final CustomerCenterView$internalListener$1 internalListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerCenterView(Context context) {
        this(context, null, null, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss() {
        Function0<Unit> function0 = this.dismissHandler;
        if (function0 != null) {
            function0.invoke();
        }
        destroy();
    }

    private final void init() {
        Logger.INSTANCE.d("Initialized CustomerCenterView");
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, int i3) {
        composer.a0(1372663828);
        if (ComposerKt.M()) {
            ComposerKt.U(1372663828, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView.Content (CustomerCenterView.kt:130)");
        }
        RevenueCatThemeKt.RevenueCatTheme(ComposableLambdaKt.e(1061986288, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView.Content.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i4) {
                if ((i4 & 3) == 2 && composer2.l()) {
                    composer2.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(1061986288, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView.Content.<anonymous> (CustomerCenterView.kt:132)");
                }
                CustomerCenterOptions customerCenterOptions = CustomerCenterView.this.customerCenterOptions;
                composer2.a0(573881428);
                boolean zI = composer2.I(CustomerCenterView.this);
                final CustomerCenterView customerCenterView = CustomerCenterView.this;
                Object objG = composer2.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$Content$1$1$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1235invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1235invoke() {
                            customerCenterView.dismiss();
                        }
                    };
                    composer2.w(objG);
                }
                composer2.U();
                CustomerCenterKt.CustomerCenter(null, customerCenterOptions, (Function0) objG, composer2, 0, 1);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }, composer, 54), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.views.CompatComposeView
    public void onBackPressed() {
        Unit unit;
        if (this.dismissHandler != null) {
            dismiss();
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.onBackPressed();
        }
    }

    public final void setCustomerCenterListener(CustomerCenterListener customerCenterListener) {
        this.customerCenterListener = customerCenterListener;
    }

    public final void setDismissHandler(Function0<Unit> function0) {
        this.dismissHandler = function0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerCenterView(Context context, CustomerCenterListener customerCenterListener) {
        this(context, customerCenterListener, null, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.revenuecat.purchases.customercenter.CustomerCenterListener, com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$internalListener$1] */
    public CustomerCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r8 = new CustomerCenterListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$internalListener$1
            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onCustomActionSelected(String actionIdentifier, String str) {
                Intrinsics.checkNotNullParameter(actionIdentifier, "actionIdentifier");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onCustomActionSelected(actionIdentifier, str);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onFeedbackSurveyCompleted(String feedbackSurveyOptionId) {
                Intrinsics.checkNotNullParameter(feedbackSurveyOptionId, "feedbackSurveyOptionId");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onFeedbackSurveyCompleted(feedbackSurveyOptionId);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onManagementOptionSelected(CustomerCenterManagementOption action) {
                Intrinsics.checkNotNullParameter(action, "action");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onManagementOptionSelected(action);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onPromotionalOfferSucceeded(CustomerInfo customerInfo, StoreTransaction transaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(transaction, "transaction");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onPromotionalOfferSucceeded(customerInfo, transaction);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreCompleted(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreFailed(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreFailed(error);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreInitiated(Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(resume, "resume");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreInitiated(resume);
                    unit = Unit.f139807a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreStarted() {
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreStarted();
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onShowingManageSubscriptions() {
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onShowingManageSubscriptions();
                }
            }
        };
        this.internalListener = r8;
        this.customerCenterOptions = new CustomerCenterOptions.Builder().setListener(r8).build();
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.revenuecat.purchases.customercenter.CustomerCenterListener, com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$internalListener$1] */
    public CustomerCenterView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r2 = new CustomerCenterListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$internalListener$1
            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onCustomActionSelected(String actionIdentifier, String str) {
                Intrinsics.checkNotNullParameter(actionIdentifier, "actionIdentifier");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onCustomActionSelected(actionIdentifier, str);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onFeedbackSurveyCompleted(String feedbackSurveyOptionId) {
                Intrinsics.checkNotNullParameter(feedbackSurveyOptionId, "feedbackSurveyOptionId");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onFeedbackSurveyCompleted(feedbackSurveyOptionId);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onManagementOptionSelected(CustomerCenterManagementOption action) {
                Intrinsics.checkNotNullParameter(action, "action");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onManagementOptionSelected(action);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onPromotionalOfferSucceeded(CustomerInfo customerInfo, StoreTransaction transaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(transaction, "transaction");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onPromotionalOfferSucceeded(customerInfo, transaction);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreCompleted(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreFailed(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreFailed(error);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreInitiated(Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(resume, "resume");
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreInitiated(resume);
                    unit = Unit.f139807a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreStarted() {
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onRestoreStarted();
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onShowingManageSubscriptions() {
                CustomerCenterListener customerCenterListener = this.this$0.customerCenterListener;
                if (customerCenterListener != null) {
                    customerCenterListener.onShowingManageSubscriptions();
                }
            }
        };
        this.internalListener = r2;
        this.customerCenterOptions = new CustomerCenterOptions.Builder().setListener(r2).build();
        init();
    }

    public /* synthetic */ CustomerCenterView(Context context, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (Function0<Unit>) ((i3 & 2) != 0 ? null : function0));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerCenterView(Context context, Function0<Unit> function0) {
        this(context, (CustomerCenterListener) null, function0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CustomerCenterView(Context context, CustomerCenterListener customerCenterListener, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : customerCenterListener, (Function0<Unit>) ((i3 & 4) != 0 ? null : function0));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.revenuecat.purchases.customercenter.CustomerCenterListener, com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$internalListener$1] */
    public CustomerCenterView(Context context, CustomerCenterListener customerCenterListener, Function0<Unit> function0) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r8 = new CustomerCenterListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CustomerCenterView$internalListener$1
            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onCustomActionSelected(String actionIdentifier, String str) {
                Intrinsics.checkNotNullParameter(actionIdentifier, "actionIdentifier");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onCustomActionSelected(actionIdentifier, str);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onFeedbackSurveyCompleted(String feedbackSurveyOptionId) {
                Intrinsics.checkNotNullParameter(feedbackSurveyOptionId, "feedbackSurveyOptionId");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onFeedbackSurveyCompleted(feedbackSurveyOptionId);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onManagementOptionSelected(CustomerCenterManagementOption action) {
                Intrinsics.checkNotNullParameter(action, "action");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onManagementOptionSelected(action);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onPromotionalOfferSucceeded(CustomerInfo customerInfo, StoreTransaction transaction) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(transaction, "transaction");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onPromotionalOfferSucceeded(customerInfo, transaction);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreCompleted(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onRestoreCompleted(customerInfo);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreFailed(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onRestoreFailed(error);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreInitiated(Resumable resume) {
                Unit unit;
                Intrinsics.checkNotNullParameter(resume, "resume");
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onRestoreInitiated(resume);
                    unit = Unit.f139807a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Resumable.invoke$default(resume, false, 1, null);
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onRestoreStarted() {
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onRestoreStarted();
                }
            }

            @Override // com.revenuecat.purchases.customercenter.CustomerCenterListener
            public void onShowingManageSubscriptions() {
                CustomerCenterListener customerCenterListener2 = this.this$0.customerCenterListener;
                if (customerCenterListener2 != null) {
                    customerCenterListener2.onShowingManageSubscriptions();
                }
            }
        };
        this.internalListener = r8;
        this.customerCenterOptions = new CustomerCenterOptions.Builder().setListener(r8).build();
        this.customerCenterListener = customerCenterListener;
        this.dismissHandler = function0;
        init();
    }
}
