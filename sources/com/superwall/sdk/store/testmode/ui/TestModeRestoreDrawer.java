package com.superwall.sdk.store.testmode.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.superwall.sdk.R;
import com.superwall.sdk.store.testmode.ui.RestoreSimulationResult;
import com.superwall.sdk.store.testmode.ui.TestModeRestoreDrawer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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
import kotlin.ranges.RangesKt;
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
public final class TestModeRestoreDrawer {
    public static final TestModeRestoreDrawer INSTANCE = new TestModeRestoreDrawer();

    /* JADX INFO: renamed from: com.superwall.sdk.store.testmode.ui.TestModeRestoreDrawer$show$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.testmode.ui.TestModeRestoreDrawer$show$2", f = "TestModeRestoreDrawer.kt", l = {86}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RestoreSimulationResult>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ List<String> $availableEntitlements;
        final /* synthetic */ List<EntitlementSelection> $currentSelections;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Activity activity, List<EntitlementSelection> list, List<String> list2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$currentSelections = list;
            this.$availableEntitlements = list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1(CompletableDeferred completableDeferred, BottomSheetDialog bottomSheetDialog, View view) {
            completableDeferred.J(RestoreSimulationResult.Cancelled.INSTANCE);
            bottomSheetDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(EntitlementSelection entitlementSelection) {
            return Unit.f139807a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$4(List list, CompletableDeferred completableDeferred, BottomSheetDialog bottomSheetDialog, View view) {
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((EntitlementRowViewHolder) it.next()).getCurrentSelection());
            }
            completableDeferred.J(new RestoreSimulationResult.Restored(arrayList));
            bottomSheetDialog.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$5(CompletableDeferred completableDeferred, DialogInterface dialogInterface) {
            if (completableDeferred.isCompleted()) {
                return;
            }
            completableDeferred.J(RestoreSimulationResult.Cancelled.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$activity, this.$currentSelections, this.$availableEntitlements, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
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
            View viewInflate = LayoutInflater.from(this.$activity).inflate(R.layout.test_mode_restore_drawer, (ViewGroup) null);
            viewInflate.setBackground(ContextCompat.getDrawable(this.$activity, R.drawable.test_mode_sheet_bg));
            List<EntitlementSelection> list = this.$currentSelections;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj2 : list) {
                linkedHashMap.put(((EntitlementSelection) obj2).getIdentifier(), obj2);
            }
            ((TextView) viewInflate.findViewById(R.id.close_button)).setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.store.testmode.ui.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestModeRestoreDrawer.AnonymousClass2.invokeSuspend$lambda$1(completableDeferredB, bottomSheetDialog, view);
                }
            });
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.entitlements_container);
            final ArrayList arrayList = new ArrayList();
            if (this.$availableEntitlements.isEmpty()) {
                ((TextView) viewInflate.findViewById(R.id.no_entitlements_text)).setVisibility(0);
            } else {
                for (String str : this.$availableEntitlements) {
                    EntitlementSelection entitlementSelection = (EntitlementSelection) linkedHashMap.get(str);
                    if (entitlementSelection == null) {
                        entitlementSelection = new EntitlementSelection(str, (EntitlementStateOption) null, (OfferTypeOption) null, 6, (DefaultConstructorMarker) null);
                    }
                    Activity activity = this.$activity;
                    Intrinsics.checkNotNull(linearLayout);
                    EntitlementRowViewHolder entitlementRowViewHolder = new EntitlementRowViewHolder(activity, linearLayout, str, entitlementSelection, new Function1() { // from class: com.superwall.sdk.store.testmode.ui.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return TestModeRestoreDrawer.AnonymousClass2.invokeSuspend$lambda$2((EntitlementSelection) obj3);
                        }
                    });
                    arrayList.add(entitlementRowViewHolder);
                    linearLayout.addView(entitlementRowViewHolder.getView());
                }
            }
            ((TextView) viewInflate.findViewById(R.id.restore_button)).setOnClickListener(new View.OnClickListener() { // from class: com.superwall.sdk.store.testmode.ui.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestModeRestoreDrawer.AnonymousClass2.invokeSuspend$lambda$4(arrayList, completableDeferredB, bottomSheetDialog, view);
                }
            });
            bottomSheetDialog.setContentView(viewInflate);
            bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.superwall.sdk.store.testmode.ui.s
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    TestModeRestoreDrawer.AnonymousClass2.invokeSuspend$lambda$5(completableDeferredB, dialogInterface);
                }
            });
            bottomSheetDialog.show();
            this.label = 1;
            Object objAwait = completableDeferredB.await(this);
            return objAwait == objF ? objF : objAwait;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RestoreSimulationResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    private TestModeRestoreDrawer() {
    }

    public final Object show(Activity activity, List<String> list, List<EntitlementSelection> list2, Continuation<? super RestoreSimulationResult> continuation) {
        return BuildersKt.g(Dispatchers.c(), new AnonymousClass2(activity, list2, list, null), continuation);
    }
}
