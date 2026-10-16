package com.superwall.sdk.paywall.view.survey;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.superwall.sdk.R;
import com.superwall.sdk.config.models.Survey;
import com.superwall.sdk.config.models.SurveyOption;
import com.superwall.sdk.config.models.SurveyShowCondition;
import com.superwall.sdk.dependencies.TriggerFactory;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.paywall.presentation.PaywallCloseReason;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallResult;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.paywall.view.delegate.PaywallLoadingState;
import com.superwall.sdk.storage.LocalStorage;
import com.superwall.sdk.storage.SurveyAssignmentKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
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
public final class SurveyManager {
    public static final SurveyManager INSTANCE = new SurveyManager();
    private static AlertDialog otherAlertDialog;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyShowCondition.values().length];
            try {
                iArr[SurveyShowCondition.ON_MANUAL_CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyShowCondition.ON_PURCHASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.survey.SurveyManager$handleDialogDismissal$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.survey.SurveyManager$handleDialogDismissal$1", f = "SurveyManager.kt", l = {260, 264}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<SurveyPresentationResult, Unit> $completion;
        final /* synthetic */ String $customResponse;
        final /* synthetic */ TriggerFactory $factory;
        final /* synthetic */ SurveyOption $option;
        final /* synthetic */ PaywallInfo $paywallInfo;
        final /* synthetic */ PaywallView $paywallView;
        final /* synthetic */ Survey $survey;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Survey survey, SurveyOption surveyOption, String str, PaywallInfo paywallInfo, TriggerFactory triggerFactory, PaywallView paywallView, Function1<? super SurveyPresentationResult, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$survey = survey;
            this.$option = surveyOption;
            this.$customResponse = str;
            this.$paywallInfo = paywallInfo;
            this.$factory = triggerFactory;
            this.$paywallView = paywallView;
            this.$completion = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$survey, this.$option, this.$customResponse, this.$paywallInfo, this.$factory, this.$paywallView, this.$completion, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L33
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r0 = r7.L$0
                com.superwall.sdk.analytics.internal.TrackingLogic$ImplicitTriggerOutcome r0 = (com.superwall.sdk.analytics.internal.TrackingLogic.ImplicitTriggerOutcome) r0
                kotlin.ResultKt.b(r8)
                kotlin.Result r8 = (kotlin.Result) r8
                r8.j()
                goto L79
            L1b:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L23:
                java.lang.Object r1 = r7.L$2
                com.superwall.sdk.analytics.internal.trackable.Trackable r1 = (com.superwall.sdk.analytics.internal.trackable.Trackable) r1
                java.lang.Object r3 = r7.L$1
                com.superwall.sdk.analytics.internal.TrackingLogic$Companion r3 = (com.superwall.sdk.analytics.internal.TrackingLogic.Companion) r3
                java.lang.Object r4 = r7.L$0
                com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$SurveyResponse r4 = (com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent.SurveyResponse) r4
                kotlin.ResultKt.b(r8)
                goto L5a
            L33:
                kotlin.ResultKt.b(r8)
                com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$SurveyResponse r1 = new com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent$SurveyResponse
                com.superwall.sdk.config.models.Survey r8 = r7.$survey
                com.superwall.sdk.config.models.SurveyOption r4 = r7.$option
                java.lang.String r5 = r7.$customResponse
                com.superwall.sdk.paywall.presentation.PaywallInfo r6 = r7.$paywallInfo
                r1.<init>(r8, r4, r5, r6)
                com.superwall.sdk.analytics.internal.TrackingLogic$Companion r8 = com.superwall.sdk.analytics.internal.TrackingLogic.Companion
                com.superwall.sdk.dependencies.TriggerFactory r4 = r7.$factory
                r7.L$0 = r1
                r7.L$1 = r8
                r7.L$2 = r1
                r7.label = r3
                java.lang.Object r3 = r4.makeTriggers(r7)
                if (r3 != r0) goto L56
                goto L77
            L56:
                r4 = r3
                r3 = r8
                r8 = r4
                r4 = r1
            L5a:
                java.util.Set r8 = (java.util.Set) r8
                com.superwall.sdk.paywall.view.PaywallView r5 = r7.$paywallView
                com.superwall.sdk.analytics.internal.TrackingLogic$ImplicitTriggerOutcome r8 = r3.canTriggerPaywall(r1, r8, r5)
                com.superwall.sdk.Superwall$Companion r1 = com.superwall.sdk.Superwall.Companion
                com.superwall.sdk.Superwall r1 = r1.getInstance()
                r7.L$0 = r8
                r3 = 0
                r7.L$1 = r3
                r7.L$2 = r3
                r7.label = r2
                java.lang.Object r1 = com.superwall.sdk.analytics.internal.TrackingKt.track(r1, r4, r7)
                if (r1 != r0) goto L78
            L77:
                return r0
            L78:
                r0 = r8
            L79:
                com.superwall.sdk.analytics.internal.TrackingLogic$ImplicitTriggerOutcome$DontTriggerPaywall r8 = com.superwall.sdk.analytics.internal.TrackingLogic.ImplicitTriggerOutcome.DontTriggerPaywall.INSTANCE
                boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)
                if (r8 == 0) goto L88
                kotlin.jvm.functions.Function1<com.superwall.sdk.paywall.view.survey.SurveyPresentationResult, kotlin.Unit> r8 = r7.$completion
                com.superwall.sdk.paywall.view.survey.SurveyPresentationResult r0 = com.superwall.sdk.paywall.view.survey.SurveyPresentationResult.SHOW
                r8.invoke(r0)
            L88:
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.survey.SurveyManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    private SurveyManager() {
    }

    private final void handleDialogDismissal(boolean z2, Survey survey, SurveyOption surveyOption, String str, PaywallInfo paywallInfo, TriggerFactory triggerFactory, PaywallView paywallView, Function1<? super SurveyPresentationResult, Unit> function1) {
        if (z2) {
            function1.invoke(SurveyPresentationResult.SHOW);
        } else {
            BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new AnonymousClass1(survey, surveyOption, str, paywallInfo, triggerFactory, paywallView, function1, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void presentSurveyIfAvailable$lambda$10(final Survey survey, BottomSheetDialog bottomSheetDialog, List list, Activity activity, final Function1 function1, final boolean z2, final PaywallInfo paywallInfo, final TriggerFactory triggerFactory, final PaywallView paywallView, AdapterView adapterView, View view, final int i3, long j3) {
        if (i3 < survey.getOptions().size()) {
            bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.superwall.sdk.paywall.view.survey.c
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    SurveyManager.presentSurveyIfAvailable$lambda$10$lambda$4(z2, survey, i3, paywallInfo, triggerFactory, paywallView, function1, dialogInterface);
                }
            });
            bottomSheetDialog.dismiss();
            return;
        }
        String str = (String) list.get(i3);
        if (!Intrinsics.areEqual(str, "Other")) {
            if (Intrinsics.areEqual(str, "Close")) {
                BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), null, null, new SurveyManager$presentSurveyIfAvailable$2$7(null), 3, null);
                bottomSheetDialog.dismiss();
                function1.invoke(SurveyPresentationResult.SHOW);
                return;
            }
            return;
        }
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.custom_alert_dialog_layout, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.d(false);
        builder.u(viewInflate);
        final SurveyOption surveyOption = new SurveyOption("000", "Other");
        builder.p("Submit", new DialogInterface.OnClickListener() { // from class: com.superwall.sdk.paywall.view.survey.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                SurveyManager.presentSurveyIfAvailable$lambda$10$lambda$5(dialogInterface, i4);
            }
        });
        final AlertDialog alertDialogA = builder.a();
        Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
        TextView textView = (TextView) viewInflate.findViewById(R.id.customDialogTitle);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.customDialogMessage);
        final EditText editText = (EditText) viewInflate.findViewById(R.id.editText);
        textView.setText(survey.getTitle());
        textView2.setText(survey.getMessage());
        editText.addTextChangedListener(new TextWatcher() { // from class: com.superwall.sdk.paywall.view.survey.SurveyManager$presentSurveyIfAvailable$2$3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String string;
                String string2 = (editable == null || (string = editable.toString()) == null) ? null : StringsKt.t1(string).toString();
                alertDialogA.j(-1).setEnabled(!(string2 == null || string2.length() == 0));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }
        });
        alertDialogA.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.superwall.sdk.paywall.view.survey.e
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                SurveyManager.presentSurveyIfAvailable$lambda$10$lambda$6(alertDialogA, dialogInterface);
            }
        });
        bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.superwall.sdk.paywall.view.survey.f
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SurveyManager.presentSurveyIfAvailable$lambda$10$lambda$7(alertDialogA, editText, dialogInterface);
            }
        });
        alertDialogA.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.superwall.sdk.paywall.view.survey.g
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                SurveyManager.presentSurveyIfAvailable$lambda$10$lambda$9(alertDialogA, z2, survey, surveyOption, editText, paywallInfo, triggerFactory, paywallView, function1, dialogInterface);
            }
        });
        bottomSheetDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void presentSurveyIfAvailable$lambda$10$lambda$4(boolean z2, Survey survey, int i3, PaywallInfo paywallInfo, TriggerFactory triggerFactory, PaywallView paywallView, Function1 function1, DialogInterface dialogInterface) {
        INSTANCE.handleDialogDismissal(z2, survey, survey.getOptions().get(i3), null, paywallInfo, triggerFactory, paywallView, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void presentSurveyIfAvailable$lambda$10$lambda$6(AlertDialog alertDialog, DialogInterface dialogInterface) {
        alertDialog.j(-1).setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void presentSurveyIfAvailable$lambda$10$lambda$7(AlertDialog alertDialog, EditText editText, DialogInterface dialogInterface) {
        alertDialog.show();
        alertDialog.j(-1).setEnabled(false);
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void presentSurveyIfAvailable$lambda$10$lambda$9(final AlertDialog alertDialog, final boolean z2, final Survey survey, final SurveyOption surveyOption, final EditText editText, final PaywallInfo paywallInfo, final TriggerFactory triggerFactory, final PaywallView paywallView, final Function1 function1, DialogInterface dialogInterface) {
        alertDialog.j(-1).setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.paywall.view.survey.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SurveyManager.presentSurveyIfAvailable$lambda$10$lambda$9$lambda$8(z2, survey, surveyOption, editText, paywallInfo, triggerFactory, paywallView, function1, alertDialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void presentSurveyIfAvailable$lambda$10$lambda$9$lambda$8(boolean z2, Survey survey, SurveyOption surveyOption, EditText editText, PaywallInfo paywallInfo, TriggerFactory triggerFactory, PaywallView paywallView, Function1 function1, AlertDialog alertDialog, View view) {
        INSTANCE.handleDialogDismissal(z2, survey, surveyOption, editText.getText().toString(), paywallInfo, triggerFactory, paywallView, function1);
        alertDialog.dismiss();
    }

    private final Survey selectSurvey(List<Survey> list, PaywallResult paywallResult, PaywallCloseReason paywallCloseReason) {
        boolean z2 = paywallResult instanceof PaywallResult.Purchased;
        boolean z3 = paywallResult instanceof PaywallResult.Declined;
        boolean z4 = paywallCloseReason instanceof PaywallCloseReason.ManualClose;
        for (Survey survey : list) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[survey.getPresentationCondition().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (z2) {
                    return survey;
                }
            } else if (z3 && z4) {
                return survey;
            }
        }
        return null;
    }

    public final void presentSurveyIfAvailable(List<Survey> surveys, PaywallResult paywallResult, PaywallCloseReason paywallCloseReason, final Activity activity, final PaywallView paywallView, PaywallLoadingState loadingState, final boolean z2, final PaywallInfo paywallInfo, LocalStorage storage, final TriggerFactory factory, final Function1<? super SurveyPresentationResult, Unit> completion) {
        Intrinsics.checkNotNullParameter(surveys, "surveys");
        Intrinsics.checkNotNullParameter(paywallResult, "paywallResult");
        Intrinsics.checkNotNullParameter(paywallCloseReason, "paywallCloseReason");
        Intrinsics.checkNotNullParameter(paywallView, "paywallView");
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(completion, "completion");
        if (activity == null) {
            completion.invoke(SurveyPresentationResult.NOSHOW);
            return;
        }
        final Survey surveySelectSurvey = selectSurvey(surveys, paywallResult, paywallCloseReason);
        if (surveySelectSurvey == null) {
            completion.invoke(SurveyPresentationResult.NOSHOW);
            return;
        }
        if (!(loadingState instanceof PaywallLoadingState.Ready) && !(loadingState instanceof PaywallLoadingState.LoadingPurchase)) {
            completion.invoke(SurveyPresentationResult.NOSHOW);
            return;
        }
        if (surveySelectSurvey.hasSeenSurvey(storage)) {
            completion.invoke(SurveyPresentationResult.NOSHOW);
            return;
        }
        boolean zShouldAssignHoldout = surveySelectSurvey.shouldAssignHoldout(z2);
        if (!z2) {
            storage.write(SurveyAssignmentKey.INSTANCE, surveySelectSurvey.getAssignmentKey());
        }
        if (zShouldAssignHoldout) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.info, LogScope.paywallView, "The survey will not present.", (Map) null, (Throwable) null, 24, (Object) null);
            completion.invoke(SurveyPresentationResult.HOLDOUT);
            return;
        }
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        bottomSheetDialog.setCanceledOnTouchOutside(false);
        bottomSheetDialog.setCancelable(false);
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.survey_bottom_sheet, (ViewGroup) null);
        bottomSheetDialog.setContentView(viewInflate);
        final ArrayList arrayList = new ArrayList();
        List<SurveyOption> options = surveySelectSurvey.getOptions();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(options, 10));
        Iterator<T> it = options.iterator();
        while (it.hasNext()) {
            arrayList2.add(((SurveyOption) it.next()).getTitle());
        }
        arrayList.addAll(arrayList2);
        if (surveySelectSurvey.getIncludeOtherOption()) {
            arrayList.add("Other");
        }
        if (surveySelectSurvey.getIncludeCloseOption()) {
            arrayList.add("Close");
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.message);
        textView.setText(surveySelectSurvey.getTitle());
        textView2.setText(surveySelectSurvey.getMessage());
        View viewFindViewById = viewInflate.findViewById(R.id.surveyListView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ListView listView = (ListView) viewFindViewById;
        listView.setAdapter((ListAdapter) new ArrayAdapter(activity, R.layout.list_item, arrayList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.superwall.sdk.paywall.view.survey.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                SurveyManager.presentSurveyIfAvailable$lambda$10(surveySelectSurvey, bottomSheetDialog, arrayList, activity, completion, z2, paywallInfo, factory, paywallView, adapterView, view, i3, j3);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void presentSurveyIfAvailable$lambda$10$lambda$5(DialogInterface dialogInterface, int i3) {
    }
}
