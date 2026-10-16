package com.superwall.sdk.store.testmode.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.superwall.sdk.R;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.models.serialization.AnyMapSerializer;
import com.superwall.sdk.storage.TestModeSettings;
import com.superwall.sdk.store.testmode.FreeTrialOverride;
import com.superwall.sdk.store.testmode.ui.TestModeModal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;

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
public final class TestModeModal {
    public static final TestModeModal INSTANCE = new TestModeModal();

    /* JADX INFO: renamed from: com.superwall.sdk.store.testmode.ui.TestModeModal$show$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.testmode.ui.TestModeModal$show$2", f = "TestModeModal.kt", l = {191}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TestModeModalResult>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $apiKey;
        final /* synthetic */ List<String> $availableEntitlements;
        final /* synthetic */ String $dashboardBaseUrl;
        final /* synthetic */ boolean $hasPurchaseController;
        final /* synthetic */ String $reason;
        final /* synthetic */ TestModeSettings $savedSettings;
        final /* synthetic */ String $userAttributes;
        final /* synthetic */ String $userId;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.store.testmode.ui.TestModeModal$show$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.store.testmode.ui.TestModeModal$show$2$3", f = "TestModeModal.kt", l = {98, 99}, m = "invokeSuspend")
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Activity $activity;
            final /* synthetic */ View $view;
            Object L$0;
            Object L$1;
            int label;

            /* JADX INFO: renamed from: com.superwall.sdk.store.testmode.ui.TestModeModal$show$2$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.store.testmode.ui.TestModeModal$show$2$3$1", f = "TestModeModal.kt", l = {}, m = "invokeSuspend")
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Activity $activity;
                final /* synthetic */ String $deviceAttributes;
                final /* synthetic */ View $view;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(View view, Activity activity, String str, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$view = view;
                    this.$activity = activity;
                    this.$deviceAttributes = str;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void invokeSuspend$lambda$0(Activity activity, String str, View view) {
                    TestModeAttributesViewer.INSTANCE.show(activity, "Device Attributes", str);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$view, this.$activity, this.$deviceAttributes, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    View viewFindViewById = this.$view.findViewById(R.id.device_attributes_row);
                    final Activity activity = this.$activity;
                    final String str = this.$deviceAttributes;
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.store.testmode.ui.k
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TestModeModal.AnonymousClass2.AnonymousClass3.AnonymousClass1.invokeSuspend$lambda$0(activity, str, view);
                        }
                    });
                    return Unit.f139807a;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(View view, Activity activity, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$view = view;
                this.$activity = activity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$view, this.$activity, continuation);
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x005f, code lost:
            
                if (kotlinx.coroutines.BuildersKt.g(r1, r3, r8) == r0) goto L16;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
                /*
                    r8 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r1 = r8.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L26
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    kotlin.ResultKt.b(r9)
                    goto L62
                L12:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                L1a:
                    java.lang.Object r1 = r8.L$1
                    kotlinx.serialization.SerializationStrategy r1 = (kotlinx.serialization.SerializationStrategy) r1
                    java.lang.Object r3 = r8.L$0
                    kotlinx.serialization.json.Json$Default r3 = (kotlinx.serialization.json.Json.Default) r3
                    kotlin.ResultKt.b(r9)
                    goto L43
                L26:
                    kotlin.ResultKt.b(r9)
                    kotlinx.serialization.json.Json$Default r9 = kotlinx.serialization.json.Json.f142959d
                    com.superwall.sdk.models.serialization.AnyMapSerializer r1 = com.superwall.sdk.models.serialization.AnyMapSerializer.INSTANCE
                    com.superwall.sdk.Superwall$Companion r4 = com.superwall.sdk.Superwall.Companion
                    com.superwall.sdk.Superwall r4 = r4.getInstance()
                    r8.L$0 = r9
                    r8.L$1 = r1
                    r8.label = r3
                    java.lang.Object r3 = r4.deviceAttributes(r8)
                    if (r3 != r0) goto L40
                    goto L61
                L40:
                    r7 = r3
                    r3 = r9
                    r9 = r7
                L43:
                    java.lang.String r9 = r3.b(r1, r9)
                    kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.c()
                    com.superwall.sdk.store.testmode.ui.TestModeModal$show$2$3$1 r3 = new com.superwall.sdk.store.testmode.ui.TestModeModal$show$2$3$1
                    android.view.View r4 = r8.$view
                    android.app.Activity r5 = r8.$activity
                    r6 = 0
                    r3.<init>(r4, r5, r9, r6)
                    r8.L$0 = r6
                    r8.L$1 = r6
                    r8.label = r2
                    java.lang.Object r9 = kotlinx.coroutines.BuildersKt.g(r1, r3, r8)
                    if (r9 != r0) goto L62
                L61:
                    return r0
                L62:
                    kotlin.Unit r9 = kotlin.Unit.f139807a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.testmode.ui.TestModeModal.AnonymousClass2.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Activity activity, TestModeSettings testModeSettings, String str, String str2, boolean z2, List<String> list, String str3, String str4, String str5, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$savedSettings = testModeSettings;
            this.$reason = str;
            this.$userId = str2;
            this.$hasPurchaseController = z2;
            this.$availableEntitlements = list;
            this.$dashboardBaseUrl = str3;
            this.$apiKey = str4;
            this.$userAttributes = str5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1(Activity activity, String str, View view) {
            TestModeModal testModeModal = TestModeModal.INSTANCE;
            if (str == null) {
                str = "";
            }
            testModeModal.copyToClipboard(activity, "User ID", str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$3(Activity activity, String str, View view) {
            TestModeAttributesViewer.INSTANCE.show(activity, "User Attributes", str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$5(EntitlementSelection entitlementSelection) {
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$7(List list, CompletableDeferred completableDeferred, Ref.ObjectRef objectRef, BottomSheetDialog bottomSheetDialog, View view) {
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((EntitlementRowViewHolder) it.next()).getCurrentSelection());
            }
            completableDeferred.J(new TestModeModalResult(arrayList, (FreeTrialOverride) objectRef.f140144a));
            bottomSheetDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$8(IOScope iOScope, CompletableDeferred completableDeferred, DialogInterface dialogInterface) {
            CoroutineScopeKt.e(iOScope, null, 1, null);
            if (completableDeferred.isCompleted()) {
                return;
            }
            completableDeferred.J(new TestModeModalResult(CollectionsKt.emptyList(), FreeTrialOverride.UseDefault));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$activity, this.$savedSettings, this.$reason, this.$userId, this.$hasPurchaseController, this.$availableEntitlements, this.$dashboardBaseUrl, this.$apiKey, this.$userAttributes, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super TestModeModalResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Map mapEmptyMap;
            FreeTrialOverride freeTrialOverride;
            String str;
            List<EntitlementSelection> entitlementSelections;
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
            final IOScope iOScope = new IOScope(null, 1, null);
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.$activity);
            bottomSheetDialog.setCancelable(false);
            View viewInflate = LayoutInflater.from(this.$activity).inflate(R.layout.test_mode_modal, (ViewGroup) null);
            viewInflate.setBackground(ContextCompat.getDrawable(this.$activity, R.drawable.test_mode_sheet_bg));
            TestModeSettings testModeSettings = this.$savedSettings;
            if (testModeSettings == null || (entitlementSelections = testModeSettings.getEntitlementSelections()) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            } else {
                List<EntitlementSelection> list = entitlementSelections;
                mapEmptyMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
                for (Object obj2 : list) {
                    mapEmptyMap.put(((EntitlementSelection) obj2).getIdentifier(), obj2);
                }
            }
            Map map = mapEmptyMap;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            TestModeSettings testModeSettings2 = this.$savedSettings;
            if (testModeSettings2 == null || (freeTrialOverride = testModeSettings2.getFreeTrialOverride()) == null) {
                freeTrialOverride = FreeTrialOverride.UseDefault;
            }
            objectRef.f140144a = freeTrialOverride;
            ((TextView) viewInflate.findViewById(R.id.reason_text)).setText(this.$reason);
            TextView textView = (TextView) viewInflate.findViewById(R.id.user_id_value);
            String str2 = this.$userId;
            if (str2 == null) {
                str2 = "(anonymous)";
            }
            textView.setText(str2);
            ((TextView) viewInflate.findViewById(R.id.purchase_controller_value)).setText(this.$hasPurchaseController ? tDEtWsFLJfe.KgkTywEYdIJHA : "Not provided");
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.copy_user_id_button);
            final Activity activity = this.$activity;
            final String str3 = this.$userId;
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.store.testmode.ui.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestModeModal.AnonymousClass2.invokeSuspend$lambda$1(activity, str3, view);
                }
            });
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.view_dashboard_button);
            final String str4 = this.$dashboardBaseUrl;
            final String str5 = this.$apiKey;
            final String str6 = this.$userId;
            final Activity activity2 = this.$activity;
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.store.testmode.ui.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestModeModal.AnonymousClass2.invokeSuspend$lambda$2(str4, str5, str6, activity2, view);
                }
            });
            BuildersKt__Builders_commonKt.d(iOScope, null, null, new AnonymousClass3(viewInflate, this.$activity, null), 3, null);
            View viewFindViewById = viewInflate.findViewById(R.id.user_attributes_row);
            final Activity activity3 = this.$activity;
            final String str7 = this.$userAttributes;
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.store.testmode.ui.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestModeModal.AnonymousClass2.invokeSuspend$lambda$3(activity3, str7, view);
                }
            });
            Spinner spinner = (Spinner) viewInflate.findViewById(R.id.free_trial_spinner);
            final List list2 = CollectionsKt.toList(FreeTrialOverride.getEntries());
            Activity activity4 = this.$activity;
            int i4 = R.layout.test_mode_spinner_item;
            List list3 = list2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(((FreeTrialOverride) it.next()).getDisplayName());
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(activity4, i4, arrayList);
            arrayAdapter.setDropDownViewResource(R.layout.test_mode_spinner_dropdown_item);
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
            spinner.setSelection(RangesKt.f(list2.indexOf(objectRef.f140144a), 0));
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.superwall.sdk.store.testmode.ui.TestModeModal.show.2.5
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i5, long j3) {
                    objectRef.f140144a = list2.get(i5);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            final ArrayList arrayList2 = new ArrayList();
            if (!this.$availableEntitlements.isEmpty()) {
                ((LinearLayout) viewInflate.findViewById(R.id.entitlements_section)).setVisibility(0);
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.entitlements_container);
                for (String str8 : this.$availableEntitlements) {
                    EntitlementSelection entitlementSelection = (EntitlementSelection) map.get(str8);
                    if (entitlementSelection == null) {
                        str = str8;
                        entitlementSelection = new EntitlementSelection(str, (EntitlementStateOption) null, (OfferTypeOption) null, 6, (DefaultConstructorMarker) null);
                    } else {
                        str = str8;
                    }
                    Activity activity5 = this.$activity;
                    Intrinsics.checkNotNull(linearLayout);
                    EntitlementRowViewHolder entitlementRowViewHolder = new EntitlementRowViewHolder(activity5, linearLayout, str, entitlementSelection, new Function1() { // from class: com.superwall.sdk.store.testmode.ui.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return TestModeModal.AnonymousClass2.invokeSuspend$lambda$5((EntitlementSelection) obj3);
                        }
                    });
                    arrayList2.add(entitlementRowViewHolder);
                    linearLayout.addView(entitlementRowViewHolder.getView());
                }
            }
            ((TextView) viewInflate.findViewById(R.id.continue_button)).setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.store.testmode.ui.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestModeModal.AnonymousClass2.invokeSuspend$lambda$7(arrayList2, completableDeferredB, objectRef, bottomSheetDialog, view);
                }
            });
            bottomSheetDialog.setContentView(viewInflate);
            bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.superwall.sdk.store.testmode.ui.j
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    TestModeModal.AnonymousClass2.invokeSuspend$lambda$8(iOScope, completableDeferredB, dialogInterface);
                }
            });
            bottomSheetDialog.show();
            this.label = 1;
            Object objAwait = completableDeferredB.await(this);
            return objAwait == objF ? objF : objAwait;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$2(String str, String str2, String str3, Activity activity, View view) {
            if (str.length() > 0 && str2.length() > 0 && str3 != null && str3.length() != 0) {
                try {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str + "/sdk-link/applications/" + str2 + "/users/" + str3)));
                } catch (Exception unused) {
                    Toast.makeText(activity, jlWo.tpAAFFGJTbicb, 0).show();
                }
            }
        }
    }

    private TestModeModal() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void copyToClipboard(Context context, String str, String str2) {
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(str, str2));
        Toast.makeText(context, str + " copied", 0).show();
    }

    public static /* synthetic */ Object show$default(TestModeModal testModeModal, Activity activity, String str, boolean z2, List list, String str2, String str3, TestModeSettings testModeSettings, Continuation continuation, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str2 = "";
        }
        if ((i3 & 32) != 0) {
            str3 = "";
        }
        if ((i3 & 64) != 0) {
            testModeSettings = null;
        }
        return testModeModal.show(activity, str, z2, list, str2, str3, testModeSettings, continuation);
    }

    public final Object show(Activity activity, String str, boolean z2, List<String> list, String str2, String str3, TestModeSettings testModeSettings, Continuation<? super TestModeModalResult> continuation) {
        Superwall.Companion companion = Superwall.Companion;
        return BuildersKt.g(Dispatchers.c(), new AnonymousClass2(activity, testModeSettings, str, companion.getInstance().getUserId(), z2, list, str3, str2, Json.f142959d.b(AnyMapSerializer.INSTANCE, companion.getInstance().getUserAttributes()), null), continuation);
    }
}
