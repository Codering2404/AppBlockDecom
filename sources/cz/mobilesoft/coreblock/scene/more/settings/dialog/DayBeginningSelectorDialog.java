package cz.mobilesoft.coreblock.scene.more.settings.dialog;

import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateFormat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.FragmentDayBeginningDialogBinding;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.view.ViewHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DayBeginningSelectorDialog extends AppCompatDialogFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f109545f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f109546g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f109547a = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DayBeginningSelectorDialog.E(this.f109600a);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f109548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f109549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f109550d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DayBeginningSelectorDialog a() {
            return new DayBeginningSelectorDialog();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog$onCreateDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog$onCreateDialog$1", f = "DayBeginningSelectorDialog.kt", l = {38}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f109551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f109552b;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return DayBeginningSelectorDialog.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            DayBeginningSelectorDialog dayBeginningSelectorDialog;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f109552b;
            if (i3 == 0) {
                ResultKt.b(obj);
                DayBeginningSelectorDialog dayBeginningSelectorDialog2 = DayBeginningSelectorDialog.this;
                Flow flowD0 = dayBeginningSelectorDialog2.G().d0();
                this.f109551a = dayBeginningSelectorDialog2;
                this.f109552b = 1;
                Object objD = FlowKt.D(flowD0, this);
                if (objD == objF) {
                    return objF;
                }
                dayBeginningSelectorDialog = dayBeginningSelectorDialog2;
                obj = objD;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                dayBeginningSelectorDialog = (DayBeginningSelectorDialog) this.f109551a;
                ResultKt.b(obj);
            }
            dayBeginningSelectorDialog.f109550d = ((Number) obj).intValue();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DayBeginningSelectorDialog() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f109548b = LazyKt.a(lazyThreadSafetyMode, new Function0<UsageLimitDao>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(UsageLimitDao.class), qualifier, objArr);
            }
        });
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f109549c = LazyKt.a(lazyThreadSafetyMode, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(CoreMultiProcessDataStore.class), objArr2, objArr3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FragmentDayBeginningDialogBinding E(DayBeginningSelectorDialog dayBeginningSelectorDialog) {
        FragmentDayBeginningDialogBinding fragmentDayBeginningDialogBindingC = FragmentDayBeginningDialogBinding.c(dayBeginningSelectorDialog.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(fragmentDayBeginningDialogBindingC, "inflate(...)");
        return fragmentDayBeginningDialogBindingC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore G() {
        return (CoreMultiProcessDataStore) this.f109549c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UsageLimitDao H() {
        return (UsageLimitDao) this.f109548b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(DayBeginningSelectorDialog dayBeginningSelectorDialog, DialogInterface dialogInterface, int i3) {
        if (dayBeginningSelectorDialog.getContext() != null) {
            AnswersHelper.F5();
            int hours = dayBeginningSelectorDialog.F().f96631b.getHours();
            if (hours == dayBeginningSelectorDialog.f109550d) {
                return;
            }
            AnswersHelper.E5(hours);
            CoroutinesHelperExtKt.d(new DayBeginningSelectorDialog$onCreateDialog$2$1(dayBeginningSelectorDialog, hours, dayBeginningSelectorDialog.requireContext().getApplicationContext(), null));
        }
    }

    public final FragmentDayBeginningDialogBinding F() {
        return (FragmentDayBeginningDialogBinding) this.f109547a.getValue();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        boolean zE = ViewHelper.e(getActivity());
        CoroutinesHelperExtKt.h(this, new AnonymousClass1(null));
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireActivity(), R.style.f95867b);
        F().f96631b.i(getActivity(), null, this.f109550d, 0, DateFormat.is24HourFormat(getContext()));
        F().f96631b.o(getActivity(), zE);
        F().f96631b.m(0, false);
        materialAlertDialogBuilder.u(F().getRoot()).P(R.string.Eo).L(R.string.Sv, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DayBeginningSelectorDialog.I(this.f109603a, dialogInterface, i3);
            }
        }).G(android.R.string.cancel, null);
        AlertDialog alertDialogA = materialAlertDialogBuilder.a();
        Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
        return alertDialogA;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AnswersHelper.D5();
    }
}
