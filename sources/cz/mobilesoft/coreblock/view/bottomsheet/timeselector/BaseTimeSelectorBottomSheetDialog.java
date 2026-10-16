package cz.mobilesoft.coreblock.view.bottomsheet.timeselector;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.share.HKJ.pnxuebdT;
import cz.mobilesoft.coreblock.databinding.BottomSheetTimeSelectorBinding;
import cz.mobilesoft.coreblock.dto.Pair;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
import cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import cz.mobilesoft.coreblock.view.bottomsheet.BaseBottomSheetDialogFragment;
import cz.mobilesoft.coreblock.view.dialog.LockDialog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
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
public abstract class BaseTimeSelectorBottomSheetDialog extends BaseBottomSheetDialogFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f130258m = new Companion(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f130259n = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f130260b = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.timeselector.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Integer.valueOf(BaseTimeSelectorBottomSheetDialog.R(this.f130287a));
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f130261c = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.timeselector.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Integer.valueOf(BaseTimeSelectorBottomSheetDialog.S(this.f130288a));
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f130262d = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.timeselector.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BaseTimeSelectorBottomSheetDialog.q0(this.f130289a);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f130263f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.timeselector.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BaseTimeSelectorBottomSheetDialog.p0(this.f130290a);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f130264g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.timeselector.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BaseTimeSelectorBottomSheetDialog.Q(this.f130291a);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BottomSheetTimeSelectorBinding f130265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f130266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f130267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f130268k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Long f130269l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BaseTimeSelectorBottomSheetDialog() {
        final Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.timeselector.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseTimeSelectorBottomSheetDialog.H0(this.f130292a);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.timeselector.BaseTimeSelectorBottomSheetDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Fragment invoke() {
                return this;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function03 = null;
        this.f130266i = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<BaseTimeSelectorBottomSheetViewModel>() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.timeselector.BaseTimeSelectorBottomSheetDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                Fragment fragment = this;
                Qualifier qualifier2 = qualifier;
                Function0 function04 = function02;
                Function0 function05 = function03;
                Function0 function06 = function0;
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function04.invoke()).getViewModelStore();
                if (function05 == null || (defaultViewModelCreationExtras = (CreationExtras) function05.invoke()) == null) {
                    defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                return GetViewModelKt.b(Reflection.b(BaseTimeSelectorBottomSheetViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(BottomSheetTimeSelectorBinding bottomSheetTimeSelectorBinding, BaseTimeSelectorBottomSheetDialog baseTimeSelectorBottomSheetDialog, DialogInterface dialogInterface) {
        Object parent = bottomSheetTimeSelectorBinding.getRoot().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackgroundColor(ContextCompat.getColor(baseTimeSelectorBottomSheetDialog.requireActivity(), R.color.transparent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(BaseTimeSelectorBottomSheetDialog baseTimeSelectorBottomSheetDialog, Dialog dialog, BottomSheetTimeSelectorBinding bottomSheetTimeSelectorBinding, long j3) {
        baseTimeSelectorBottomSheetDialog.E0();
        Long lN0 = baseTimeSelectorBottomSheetDialog.m0().N0();
        if (lN0 != null) {
            long jLongValue = lN0.longValue() - j3;
            if (jLongValue <= 0) {
                dialog.dismiss();
            }
            bottomSheetTimeSelectorBinding.f96494s.setText(DateHelper.k(baseTimeSelectorBottomSheetDialog.requireContext(), jLongValue));
        }
        return Unit.f139807a;
    }

    private final void E0() {
        int i3;
        TextView textView = a0().f96484i;
        if (!l0()) {
            i3 = 8;
        } else if (e0() == 0 && i0() == 0) {
            i3 = 4;
        } else {
            Calendar calendarA = TimeHelperExt.A();
            calendarA.add(11, e0());
            calendarA.add(12, i0());
            a0().f96484i.setText(b0().format(calendarA.getTime()));
            i3 = 0;
        }
        textView.setVisibility(i3);
        a0().f96479d.f96853b.setEnabled((!Y() && e0() == 0 && i0() == 0) ? false : true);
        a0().f96477b.setVisibility((e0() == 0 && i0() == 0) ? 4 : 0);
    }

    private final void G0() {
        a0().f96488m.setText(T(e0()));
        a0().f96490o.setText(U(i0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder H0(BaseTimeSelectorBottomSheetDialog baseTimeSelectorBottomSheetDialog) {
        return ParametersHolderKt.b(baseTimeSelectorBottomSheetDialog.f0(), Boolean.valueOf(baseTimeSelectorBottomSheetDialog.n0()), baseTimeSelectorBottomSheetDialog.j0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleDateFormat Q(BaseTimeSelectorBottomSheetDialog baseTimeSelectorBottomSheetDialog) {
        if (DateFormat.is24HourFormat(baseTimeSelectorBottomSheetDialog.requireContext())) {
            Context contextRequireContext = baseTimeSelectorBottomSheetDialog.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            return new SimpleDateFormat("EEE HH:mm", ContextExtKt.d(contextRequireContext));
        }
        Context contextRequireContext2 = baseTimeSelectorBottomSheetDialog.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        return new SimpleDateFormat("EEE hh:mm aa", ContextExtKt.d(contextRequireContext2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int R(BaseTimeSelectorBottomSheetDialog baseTimeSelectorBottomSheetDialog) {
        return ContextCompat.getColor(baseTimeSelectorBottomSheetDialog.requireActivity(), cz.mobilesoft.coreblock.R.color.f95458m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int S(BaseTimeSelectorBottomSheetDialog baseTimeSelectorBottomSheetDialog) {
        return ContextCompat.getColor(baseTimeSelectorBottomSheetDialog.requireActivity(), cz.mobilesoft.coreblock.R.color.f95456k);
    }

    public static /* synthetic */ Spannable W(BaseTimeSelectorBottomSheetDialog baseTimeSelectorBottomSheetDialog, String str, int i3, int i4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formatTimeSpannable");
        }
        if ((i5 & 4) != 0) {
            i4 = 2;
        }
        return baseTimeSelectorBottomSheetDialog.V(str, i3, i4);
    }

    private final SimpleDateFormat b0() {
        return (SimpleDateFormat) this.f130264g.getValue();
    }

    private final Drawable g0() {
        return (Drawable) this.f130263f.getValue();
    }

    private final Drawable h0() {
        return (Drawable) this.f130262d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable p0(BaseTimeSelectorBottomSheetDialog baseTimeSelectorBottomSheetDialog) {
        return AppCompatResources.b(baseTimeSelectorBottomSheetDialog.requireActivity(), cz.mobilesoft.coreblock.R.drawable.y3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable q0(BaseTimeSelectorBottomSheetDialog baseTimeSelectorBottomSheetDialog) {
        return AppCompatResources.b(baseTimeSelectorBottomSheetDialog.requireActivity(), cz.mobilesoft.coreblock.R.drawable.w3);
    }

    private final void s0() {
        int iK0 = k0();
        if (iK0 != 1) {
            if (iK0 == 2) {
                if (i0() > 10) {
                    A0(i0() / 10);
                } else {
                    A0(0);
                }
            }
        } else if (e0() > 10) {
            y0(e0() / 10);
        } else {
            y0(0);
        }
        F0();
    }

    private final void t0(String str) {
        String str2;
        String str3;
        int iK0 = k0();
        if (iK0 == 1) {
            String strValueOf = String.valueOf(e0());
            if (strValueOf.length() < 2) {
                str2 = strValueOf + str;
            } else {
                String strSubstring = strValueOf.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                str2 = strSubstring + str;
            }
            if (!O(Integer.parseInt(str2), i0())) {
                return;
            } else {
                y0(Integer.parseInt(str2));
            }
        } else if (iK0 == 2) {
            String strValueOf2 = String.valueOf(i0());
            if (strValueOf2.length() < 2) {
                str3 = strValueOf2 + str;
            } else {
                String strSubstring2 = strValueOf2.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                str3 = strSubstring2 + str;
            }
            if (!P(Integer.parseInt(str3), e0())) {
                return;
            } else {
                A0(Integer.parseInt(str3));
            }
        }
        F0();
    }

    private final void u0() {
        if (o0() || !PrefManager.f126839a.f1()) {
            z0(!o0());
            a0().f96489n.setImageDrawable(o0() ? g0() : h0());
        } else {
            LockDialog lockDialogB = LockDialog.B();
            lockDialogB.setTargetFragment(this, 907);
            lockDialogB.show(getParentFragmentManager(), "LockDialog");
        }
    }

    protected final void A0(int i3) {
        m0().T0(i3);
    }

    protected final void B0(int i3) {
        m0().U0(i3);
    }

    protected final void F0() {
        Spannable spannableT = T(e0());
        Spannable spannableU = U(i0());
        if (spannableT.length() == 0 || spannableU.length() == 0) {
            a0().f96487l.setVisibility(8);
        } else {
            a0().f96487l.setVisibility(0);
        }
        a0().f96488m.setText(spannableT);
        a0().f96490o.setText(spannableU);
        E0();
    }

    protected boolean M(int i3, int i4) {
        return true;
    }

    protected boolean N(int i3, int i4) {
        return true;
    }

    protected boolean O(int i3, int i4) {
        return true;
    }

    protected boolean P(int i3, int i4) {
        return true;
    }

    protected Spannable T(int i3) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(Locale.US, "%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return W(this, str + "h", k0() == 1 ? d0() : c0(), 0, 4, null);
    }

    protected final Spannable V(String string, int i3, int i4) {
        Intrinsics.checkNotNullParameter(string, "string");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new TextAppearanceSpan(getActivity(), cz.mobilesoft.coreblock.R.style.f95869d), 0, i4, 33);
        spannableString.setSpan(new TextAppearanceSpan(getActivity(), cz.mobilesoft.coreblock.R.style.f95870e), i4, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(i3), 0, spannableString.length(), 33);
        return spannableString;
    }

    protected boolean X() {
        return true;
    }

    protected boolean Y() {
        return false;
    }

    protected long Z() {
        return this.f130268k;
    }

    protected final BottomSheetTimeSelectorBinding a0() {
        BottomSheetTimeSelectorBinding bottomSheetTimeSelectorBinding = this.f130265h;
        if (bottomSheetTimeSelectorBinding != null) {
            return bottomSheetTimeSelectorBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    protected final int c0() {
        return ((Number) this.f130260b.getValue()).intValue();
    }

    protected final int d0() {
        return ((Number) this.f130261c.getValue()).intValue();
    }

    protected final int e0() {
        return m0().K0();
    }

    protected Pair f0() {
        if (Z() == 0) {
            return new Pair(0, 0);
        }
        long jZ = Z() / 3600000;
        return new Pair(Integer.valueOf((int) (jZ % 24)), Integer.valueOf((int) ((Z() - (jZ * 3600000)) / 60000)));
    }

    protected final int i0() {
        return m0().M0();
    }

    protected Long j0() {
        return this.f130269l;
    }

    protected final int k0() {
        return m0().O0();
    }

    protected boolean l0() {
        return true;
    }

    protected BaseTimeSelectorBottomSheetViewModel m0() {
        return (BaseTimeSelectorBottomSheetViewModel) this.f130266i.getValue();
    }

    protected boolean n0() {
        return this.f130267j;
    }

    protected final boolean o0() {
        return m0().Q0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        if (i3 == 907 && i4 == -1) {
            z0(true);
            a0().f96489n.setImageDrawable(g0());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == cz.mobilesoft.coreblock.R.id.f95595b1) {
            u0();
            return;
        }
        if (view.getId() == cz.mobilesoft.coreblock.R.id.T1) {
            int iK0 = k0();
            if (iK0 == 0 || iK0 == 1) {
                x0();
                return;
            } else {
                if (iK0 != 2) {
                    return;
                }
                w0();
                return;
            }
        }
        if (view.getId() == cz.mobilesoft.coreblock.R.id.f95645o) {
            s0();
            return;
        }
        if (view.getId() == cz.mobilesoft.coreblock.R.id.f95666u) {
            if (v0(e0(), i0())) {
                DialogHelper.f(getDialog());
                return;
            }
            return;
        }
        if (view.getId() == cz.mobilesoft.coreblock.R.id.A1) {
            if (i0() > 94) {
                return;
            }
            x0();
            if (N(e0(), i0())) {
                A0(i0() + 5);
                F0();
                return;
            }
            return;
        }
        if (view.getId() != cz.mobilesoft.coreblock.R.id.f95683z1) {
            if (!(view instanceof Button) || view.getTag() == null) {
                return;
            }
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
            t0((String) tag);
            return;
        }
        if (e0() > 98) {
            return;
        }
        w0();
        if (M(e0(), i0())) {
            y0(e0() + 1);
            F0();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(final Dialog dialog, int i3) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.setupDialog(dialog, i3);
        BottomSheetTimeSelectorBinding bottomSheetTimeSelectorBindingC = BottomSheetTimeSelectorBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(bottomSheetTimeSelectorBindingC, "inflate(...)");
        this.f130265h = bottomSheetTimeSelectorBindingC;
        final BottomSheetTimeSelectorBinding bottomSheetTimeSelectorBindingA0 = a0();
        dialog.setContentView(bottomSheetTimeSelectorBindingA0.getRoot());
        C(bottomSheetTimeSelectorBindingA0.getRoot());
        if (!X()) {
            bottomSheetTimeSelectorBindingA0.f96489n.setVisibility(4);
        }
        if (!l0()) {
            bottomSheetTimeSelectorBindingA0.f96484i.setVisibility(8);
        }
        F0();
        bottomSheetTimeSelectorBindingA0.f96489n.setImageDrawable(o0() ? g0() : h0());
        bottomSheetTimeSelectorBindingA0.f96490o.setTextColor(d0());
        RadioGroup radioGroup = bottomSheetTimeSelectorBindingA0.f96495t;
        Intrinsics.checkNotNullExpressionValue(radioGroup, "radioGroup");
        ViewHelperExtKt.s(radioGroup);
        ArrayList arrayList = new ArrayList();
        LinearLayout buttonRow0 = bottomSheetTimeSelectorBindingA0.f96480e;
        Intrinsics.checkNotNullExpressionValue(buttonRow0, "buttonRow0");
        arrayList.add(buttonRow0);
        LinearLayout buttonRow1 = bottomSheetTimeSelectorBindingA0.f96481f;
        Intrinsics.checkNotNullExpressionValue(buttonRow1, "buttonRow1");
        arrayList.add(buttonRow1);
        LinearLayout buttonRow2 = bottomSheetTimeSelectorBindingA0.f96482g;
        Intrinsics.checkNotNullExpressionValue(buttonRow2, "buttonRow2");
        arrayList.add(buttonRow2);
        LinearLayout buttonRow3 = bottomSheetTimeSelectorBindingA0.f96483h;
        Intrinsics.checkNotNullExpressionValue(buttonRow3, "buttonRow3");
        arrayList.add(buttonRow3);
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            LinearLayout linearLayout = (LinearLayout) obj;
            int childCount = linearLayout.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = linearLayout.getChildAt(i5);
                Button button = childAt instanceof Button ? (Button) childAt : null;
                if (button != null) {
                    button.setOnClickListener(this);
                }
            }
        }
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.timeselector.g
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                BaseTimeSelectorBottomSheetDialog.C0(bottomSheetTimeSelectorBindingA0, this, dialogInterface);
            }
        });
        bottomSheetTimeSelectorBindingA0.f96496u.setOnClickListener(this);
        bottomSheetTimeSelectorBindingA0.f96477b.setOnClickListener(this);
        bottomSheetTimeSelectorBindingA0.f96489n.setOnClickListener(this);
        bottomSheetTimeSelectorBindingA0.f96479d.f96853b.setOnClickListener(this);
        if (m0().N0() != null) {
            bottomSheetTimeSelectorBindingA0.f96493r.setTextColor(c0());
            TextView previousTimeTextView = bottomSheetTimeSelectorBindingA0.f96494s;
            Intrinsics.checkNotNullExpressionValue(previousTimeTextView, "previousTimeTextView");
            previousTimeTextView.setVisibility(0);
            TextView plusTextView = bottomSheetTimeSelectorBindingA0.f96493r;
            Intrinsics.checkNotNullExpressionValue(plusTextView, "plusTextView");
            plusTextView.setVisibility(0);
        } else {
            TextView previousTimeTextView2 = bottomSheetTimeSelectorBindingA0.f96494s;
            Intrinsics.checkNotNullExpressionValue(previousTimeTextView2, "previousTimeTextView");
            previousTimeTextView2.setVisibility(8);
            TextView plusTextView2 = bottomSheetTimeSelectorBindingA0.f96493r;
            Intrinsics.checkNotNullExpressionValue(plusTextView2, "plusTextView");
            plusTextView2.setVisibility(8);
        }
        FlowsExtKt.c(this, m0().L0(), new Function1() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.timeselector.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return BaseTimeSelectorBottomSheetDialog.D0(this.f130295a, dialog, bottomSheetTimeSelectorBindingA0, ((Long) obj2).longValue());
            }
        });
    }

    protected abstract boolean v0(int i3, int i4);

    protected final void w0() {
        B0(1);
        G0();
    }

    protected final void x0() {
        B0(2);
        G0();
    }

    protected final void y0(int i3) {
        m0().R0(i3);
    }

    protected final void z0(boolean z2) {
        m0().S0(z2);
    }

    protected Spannable U(int i3) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(Locale.US, pnxuebdT.VAXP, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return W(this, str + "m", k0() == 2 ? d0() : c0(), 0, 4, null);
    }
}
