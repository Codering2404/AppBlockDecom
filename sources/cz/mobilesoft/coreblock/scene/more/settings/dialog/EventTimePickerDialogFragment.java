package cz.mobilesoft.coreblock.scene.more.settings.dialog;

import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.DialogNumberPickerBinding;
import cz.mobilesoft.coreblock.enums.EventShowAsType;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
import cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.runnability.JobHelperKtx;
import cz.mobilesoft.coreblock.view.UnfocusableNumberPicker;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
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
public final class EventTimePickerDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f109567g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f109568h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EventType f109569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DialogNumberPickerBinding f109570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f109571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f109572d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ActivityResultLauncher f109573f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventTimePickerDialogFragment a(EventType eventType) {
            EventTimePickerDialogFragment eventTimePickerDialogFragment = new EventTimePickerDialogFragment();
            eventTimePickerDialogFragment.setArguments(BundleKt.b(TuplesKt.a("BEFORE_USAGE_LIMIT_END_SHOW_AS_TYPE", eventType)));
            return eventTimePickerDialogFragment;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EventType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EventType[] $VALUES;
        public static final EventType INTERVAL_START = new EventType("INTERVAL_START", 0);
        public static final EventType USAGE_LIMIT_END = new EventType("USAGE_LIMIT_END", 1);
        public static final EventType PAUSE_END = new EventType("PAUSE_END", 2);

        private static final /* synthetic */ EventType[] $values() {
            return new EventType[]{INTERVAL_START, USAGE_LIMIT_END, PAUSE_END};
        }

        static {
            EventType[] eventTypeArr$values = $values();
            $VALUES = eventTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(eventTypeArr$values);
        }

        private EventType(String str, int i3) {
        }

        public static EnumEntries<EventType> getEntries() {
            return $ENTRIES;
        }

        public static EventType valueOf(String str) {
            return (EventType) Enum.valueOf(EventType.class, str);
        }

        public static EventType[] values() {
            return (EventType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f109574a;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.USAGE_LIMIT_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventType.PAUSE_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventType.INTERVAL_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f109574a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventTimePickerDialogFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f109571c = LazyKt.a(lazyThreadSafetyMode, new Function0<JobHelperKtx>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(JobHelperKtx.class), qualifier, objArr);
            }
        });
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f109572d = LazyKt.a(lazyThreadSafetyMode, new Function0<NotificationDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(NotificationDataStore.class), objArr2, objArr3);
            }
        });
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.g
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                EventTimePickerDialogFragment.V(this.f109612a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.f109573f = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NotificationDataStore I() {
        return (NotificationDataStore) this.f109572d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JobHelperKtx J() {
        return (JobHelperKtx) this.f109571c.getValue();
    }

    private final void L(final DialogNumberPickerBinding dialogNumberPickerBinding) {
        EventType eventType = this.f109569a;
        int i3 = eventType == null ? -1 : WhenMappings.f109574a[eventType.ordinal()];
        if (i3 != -1) {
            if (i3 == 1) {
                FlowsExtKt.c(this, I().Q(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EventTimePickerDialogFragment.M(dialogNumberPickerBinding, ((Integer) obj).intValue());
                    }
                });
                FlowsExtKt.c(this, I().R(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EventTimePickerDialogFragment.N(dialogNumberPickerBinding, (EventShowAsType) obj);
                    }
                });
            } else if (i3 == 2) {
                FlowsExtKt.c(this, I().P(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EventTimePickerDialogFragment.P(dialogNumberPickerBinding, ((Integer) obj).intValue());
                    }
                });
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                FlowsExtKt.c(this, I().O(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EventTimePickerDialogFragment.O(dialogNumberPickerBinding, ((Integer) obj).intValue());
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(DialogNumberPickerBinding dialogNumberPickerBinding, int i3) {
        dialogNumberPickerBinding.f96526c.setValue(i3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(DialogNumberPickerBinding dialogNumberPickerBinding, EventShowAsType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        dialogNumberPickerBinding.f96528e.check(it.getButtonResId());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(DialogNumberPickerBinding dialogNumberPickerBinding, int i3) {
        dialogNumberPickerBinding.f96526c.setValue(i3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(DialogNumberPickerBinding dialogNumberPickerBinding, int i3) {
        dialogNumberPickerBinding.f96526c.setValue(i3);
        return Unit.f139807a;
    }

    private final void Q(DialogNumberPickerBinding dialogNumberPickerBinding) {
        RadioGroup radioGroup = dialogNumberPickerBinding.f96528e;
        Intrinsics.checkNotNullExpressionValue(radioGroup, "radioGroup");
        radioGroup.setVisibility(this.f109569a == EventType.USAGE_LIMIT_END ? 0 : 8);
        final String string = getString(R.string.Bc);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        final String string2 = getString(R.string.Nj);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        UnfocusableNumberPicker unfocusableNumberPicker = dialogNumberPickerBinding.f96526c;
        unfocusableNumberPicker.setFormatter(new NumberPicker.Formatter() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.h
            @Override // android.widget.NumberPicker.Formatter
            public final String format(int i3) {
                return EventTimePickerDialogFragment.R(string, string2, i3);
            }
        });
        unfocusableNumberPicker.d(0);
        unfocusableNumberPicker.setMaxValue(20);
        unfocusableNumberPicker.setMinValue(0);
        unfocusableNumberPicker.setWrapSelectorWheel(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String R(String str, String str2, int i3) {
        if (i3 == 0) {
            return str;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str3 = String.format(str2, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(final EventTimePickerDialogFragment eventTimePickerDialogFragment, final AlertDialog alertDialog, DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        EventType eventType = eventTimePickerDialogFragment.f109569a;
        int i3 = eventType == null ? -1 : WhenMappings.f109574a[eventType.ordinal()];
        if (i3 == 1) {
            AnswersHelper.f128199a.a6();
        } else if (i3 == 2) {
            AnswersHelper.f128199a.d6();
        }
        ((AlertDialog) dialog).j(-1).setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventTimePickerDialogFragment.T(this.f109615a, alertDialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(EventTimePickerDialogFragment eventTimePickerDialogFragment, AlertDialog alertDialog, View view) {
        eventTimePickerDialogFragment.U(alertDialog);
    }

    private final void U(AlertDialog alertDialog) {
        DialogNumberPickerBinding dialogNumberPickerBinding = this.f109570b;
        DialogNumberPickerBinding dialogNumberPickerBinding2 = null;
        if (dialogNumberPickerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogNumberPickerBinding = null;
        }
        int value = dialogNumberPickerBinding.f96526c.getValue();
        EventType eventType = this.f109569a;
        int i3 = eventType == null ? -1 : WhenMappings.f109574a[eventType.ordinal()];
        if (i3 != -1) {
            if (i3 != 1) {
                if (i3 == 2) {
                    AnswersHelper.f128199a.e6(value);
                    CoroutinesHelperExtKt.d(new EventTimePickerDialogFragment$onPositiveButtonClicked$2(this, value, null));
                    DialogHelper.f(alertDialog);
                    return;
                } else {
                    if (i3 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    AnswersHelper.f128199a.f6(value);
                    CoroutinesHelperExtKt.d(new EventTimePickerDialogFragment$onPositiveButtonClicked$1(this, value, null));
                    DialogHelper.f(alertDialog);
                    return;
                }
            }
            EventShowAsType.Companion companion = EventShowAsType.Companion;
            DialogNumberPickerBinding dialogNumberPickerBinding3 = this.f109570b;
            if (dialogNumberPickerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogNumberPickerBinding2 = dialogNumberPickerBinding3;
            }
            EventShowAsType eventShowAsTypeA = companion.a(dialogNumberPickerBinding2.f96528e.getCheckedRadioButtonId());
            AnswersHelper.f128199a.b6(value, eventShowAsTypeA);
            if (eventShowAsTypeA == EventShowAsType.NOTIFICATION || PermissionHelper.g(requireContext())) {
                W(value, eventShowAsTypeA);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PermissionDTO(Permission.SYSTEM_OVERLAY.f97003d, false, false, 6, null));
            this.f109573f.b(PermissionActivity.Companion.b(PermissionActivity.f111772j, getActivity(), arrayList, false, false, false, null, null, 124, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(EventTimePickerDialogFragment eventTimePickerDialogFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            DialogNumberPickerBinding dialogNumberPickerBinding = eventTimePickerDialogFragment.f109570b;
            DialogNumberPickerBinding dialogNumberPickerBinding2 = null;
            if (dialogNumberPickerBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogNumberPickerBinding = null;
            }
            int value = dialogNumberPickerBinding.f96526c.getValue();
            EventShowAsType.Companion companion = EventShowAsType.Companion;
            DialogNumberPickerBinding dialogNumberPickerBinding3 = eventTimePickerDialogFragment.f109570b;
            if (dialogNumberPickerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogNumberPickerBinding2 = dialogNumberPickerBinding3;
            }
            eventTimePickerDialogFragment.W(value, companion.a(dialogNumberPickerBinding2.f96528e.getCheckedRadioButtonId()));
        }
    }

    private final void W(int i3, EventShowAsType eventShowAsType) {
        AnswersHelper.f128199a.Z5();
        CoroutinesHelperExtKt.d(new EventTimePickerDialogFragment$setUsageLimitEnd$1(this, i3, eventShowAsType, null));
        DialogHelper.f(getDialog());
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Object obj = requireArguments().get("BEFORE_USAGE_LIMIT_END_SHOW_AS_TYPE");
        this.f109569a = obj instanceof EventType ? (EventType) obj : null;
        DialogNumberPickerBinding dialogNumberPickerBindingC = DialogNumberPickerBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(dialogNumberPickerBindingC, "inflate(...)");
        this.f109570b = dialogNumberPickerBindingC;
        if (dialogNumberPickerBindingC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogNumberPickerBindingC = null;
        }
        Q(dialogNumberPickerBindingC);
        DialogNumberPickerBinding dialogNumberPickerBinding = this.f109570b;
        if (dialogNumberPickerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogNumberPickerBinding = null;
        }
        L(dialogNumberPickerBinding);
        EventType eventType = this.f109569a;
        int i3 = eventType == null ? -1 : WhenMappings.f109574a[eventType.ordinal()];
        MaterialAlertDialogBuilder materialAlertDialogBuilderP = new MaterialAlertDialogBuilder(requireActivity(), R.style.f95875j).P(i3 != 1 ? i3 != 2 ? R.string.RC : R.string.sl : R.string.SC);
        DialogNumberPickerBinding dialogNumberPickerBinding2 = this.f109570b;
        if (dialogNumberPickerBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogNumberPickerBinding2 = null;
        }
        final AlertDialog alertDialogA = materialAlertDialogBuilderP.u(dialogNumberPickerBinding2.getRoot()).L(R.string.Lt, null).G(android.R.string.cancel, null).a();
        Intrinsics.checkNotNullExpressionValue(alertDialogA, "create(...)");
        alertDialogA.setOnShowListener(new DialogInterface.OnShowListener() { // from class: cz.mobilesoft.coreblock.scene.more.settings.dialog.f
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                EventTimePickerDialogFragment.S(this.f109610a, alertDialogA, dialogInterface);
            }
        });
        return alertDialogA;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventType eventType = this.f109569a;
        int i3 = eventType == null ? -1 : WhenMappings.f109574a[eventType.ordinal()];
        if (i3 == 1) {
            AnswersHelper.f128199a.Y5();
        } else {
            if (i3 != 2) {
                return;
            }
            AnswersHelper.f128199a.c6();
        }
    }
}
