package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    static final Object F = "CONFIRM_BUTTON_TAG";
    static final Object G = "CANCEL_BUTTON_TAG";
    static final Object H = "TOGGLE_BUTTON_TAG";
    private MaterialShapeDrawable A;
    private Button B;
    private boolean C;
    private CharSequence D;
    private CharSequence E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f80826a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashSet f80827b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashSet f80828c = new LinkedHashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashSet f80829d = new LinkedHashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f80830f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DateSelector f80831g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PickerFragment f80832h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CalendarConstraints f80833i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private DayViewDecorator f80834j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MaterialCalendar f80835k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f80836l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private CharSequence f80837m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f80838n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f80839o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f80840p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CharSequence f80841q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f80842r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CharSequence f80843s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f80844t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CharSequence f80845u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f80846v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CharSequence f80847w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private TextView f80848x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f80849y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private CheckableImageButton f80850z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder<S> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InputMode {
    }

    private static Drawable D(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, AppCompatResources.b(context, com.google.android.material.R.drawable.f79610e));
        stateListDrawable.addState(new int[0], AppCompatResources.b(context, com.google.android.material.R.drawable.f79611f));
        return stateListDrawable;
    }

    private void E(Window window) {
        if (this.C) {
            return;
        }
        final View viewFindViewById = requireView().findViewById(com.google.android.material.R.id.f79638j);
        EdgeToEdgeUtils.a(window, true, ViewUtils.h(viewFindViewById), null);
        final int paddingTop = viewFindViewById.getPaddingTop();
        final int i3 = viewFindViewById.getLayoutParams().height;
        ViewCompat.C0(viewFindViewById, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                int i4 = windowInsetsCompat.f(WindowInsetsCompat.Type.i()).f33965b;
                if (i3 >= 0) {
                    viewFindViewById.getLayoutParams().height = i3 + i4;
                    View view2 = viewFindViewById;
                    view2.setLayoutParams(view2.getLayoutParams());
                }
                View view3 = viewFindViewById;
                view3.setPadding(view3.getPaddingLeft(), paddingTop + i4, viewFindViewById.getPaddingRight(), viewFindViewById.getPaddingBottom());
                return windowInsetsCompat;
            }
        });
        this.C = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector F() {
        if (this.f80831g == null) {
            this.f80831g = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f80831g;
    }

    private static CharSequence G(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] strArrSplit = TextUtils.split(String.valueOf(charSequence), "\n");
        return strArrSplit.length > 1 ? strArrSplit[0] : charSequence;
    }

    private String H() {
        return F().z(requireContext());
    }

    private static int J(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.google.android.material.R.dimen.f79579m0);
        int i3 = Month.e().f80868d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(com.google.android.material.R.dimen.f79583o0) * i3) + ((i3 - 1) * resources.getDimensionPixelOffset(com.google.android.material.R.dimen.f79591s0));
    }

    private int M(Context context) {
        int i3 = this.f80830f;
        return i3 != 0 ? i3 : F().V(context);
    }

    private void N(Context context) {
        this.f80850z.setTag(H);
        this.f80850z.setImageDrawable(D(context));
        this.f80850z.setChecked(this.f80839o != 0);
        ViewCompat.m0(this.f80850z, null);
        V(this.f80850z);
        this.f80850z.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MaterialDatePicker.y(this.f80927a, view);
            }
        });
    }

    static boolean O(Context context) {
        return R(context, R.attr.windowFullscreen);
    }

    private boolean P() {
        return getResources().getConfiguration().orientation == 2;
    }

    static boolean Q(Context context) {
        return R(context, com.google.android.material.R.attr.f79497k0);
    }

    static boolean R(Context context, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.d(context, com.google.android.material.R.attr.N, MaterialCalendar.class.getCanonicalName()), new int[]{i3});
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z2;
    }

    private void S() {
        int iM = M(requireContext());
        MaterialCalendar materialCalendarP = MaterialCalendar.P(F(), iM, this.f80833i, this.f80834j);
        this.f80835k = materialCalendarP;
        PickerFragment pickerFragmentY = materialCalendarP;
        if (this.f80839o == 1) {
            pickerFragmentY = MaterialTextInputPicker.y(F(), iM, this.f80833i);
        }
        this.f80832h = pickerFragmentY;
        U();
        T(I());
        FragmentTransaction fragmentTransactionQ = getChildFragmentManager().q();
        fragmentTransactionQ.s(com.google.android.material.R.id.M, this.f80832h);
        fragmentTransactionQ.l();
        this.f80832h.w(new OnSelectionChangedListener<S>() { // from class: com.google.android.material.datepicker.MaterialDatePicker.4
            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public void a() {
                MaterialDatePicker.this.B.setEnabled(false);
            }

            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public void b(Object obj) {
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                materialDatePicker.T(materialDatePicker.I());
                MaterialDatePicker.this.B.setEnabled(MaterialDatePicker.this.F().k2());
            }
        });
    }

    private void U() {
        this.f80848x.setText((this.f80839o == 1 && P()) ? this.E : this.D);
    }

    private void V(CheckableImageButton checkableImageButton) {
        this.f80850z.setContentDescription(this.f80839o == 1 ? checkableImageButton.getContext().getString(com.google.android.material.R.string.Z) : checkableImageButton.getContext().getString(com.google.android.material.R.string.f79700b0));
    }

    public static /* synthetic */ void y(MaterialDatePicker materialDatePicker, View view) {
        materialDatePicker.B.setEnabled(materialDatePicker.F().k2());
        materialDatePicker.f80850z.toggle();
        materialDatePicker.f80839o = materialDatePicker.f80839o == 1 ? 0 : 1;
        materialDatePicker.V(materialDatePicker.f80850z);
        materialDatePicker.S();
    }

    public String I() {
        return F().u1(getContext());
    }

    public final Object L() {
        return F().r2();
    }

    void T(String str) {
        this.f80849y.setContentDescription(H());
        this.f80849y.setText(str);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f80828c.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f80830f = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f80831g = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f80833i = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f80834j = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f80836l = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f80837m = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f80839o = bundle.getInt("INPUT_MODE_KEY");
        this.f80840p = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f80841q = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f80842r = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f80843s = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f80844t = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f80845u = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.f80846v = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f80847w = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.f80837m;
        if (text == null) {
            text = requireContext().getResources().getText(this.f80836l);
        }
        this.D = text;
        this.E = G(text);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), M(requireContext()));
        Context context = dialog.getContext();
        this.f80838n = O(context);
        int i3 = com.google.android.material.R.attr.N;
        int i4 = com.google.android.material.R.style.O;
        this.A = new MaterialShapeDrawable(context, null, i3, i4);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, com.google.android.material.R.styleable.x4, i3, i4);
        int color = typedArrayObtainStyledAttributes.getColor(com.google.android.material.R.styleable.y4, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.A.P(context);
        this.A.a0(ColorStateList.valueOf(color));
        this.A.Z(ViewCompat.t(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f80838n ? com.google.android.material.R.layout.F : com.google.android.material.R.layout.E, viewGroup);
        Context context = viewInflate.getContext();
        DayViewDecorator dayViewDecorator = this.f80834j;
        if (dayViewDecorator != null) {
            dayViewDecorator.i(context);
        }
        if (this.f80838n) {
            viewInflate.findViewById(com.google.android.material.R.id.M).setLayoutParams(new LinearLayout.LayoutParams(J(context), -2));
        } else {
            viewInflate.findViewById(com.google.android.material.R.id.N).setLayoutParams(new LinearLayout.LayoutParams(J(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(com.google.android.material.R.id.U);
        this.f80849y = textView;
        ViewCompat.o0(textView, 1);
        this.f80850z = (CheckableImageButton) viewInflate.findViewById(com.google.android.material.R.id.V);
        this.f80848x = (TextView) viewInflate.findViewById(com.google.android.material.R.id.Z);
        N(context);
        this.B = (Button) viewInflate.findViewById(com.google.android.material.R.id.f79626d);
        if (F().k2()) {
            this.B.setEnabled(true);
        } else {
            this.B.setEnabled(false);
        }
        this.B.setTag(F);
        CharSequence charSequence = this.f80841q;
        if (charSequence != null) {
            this.B.setText(charSequence);
        } else {
            int i3 = this.f80840p;
            if (i3 != 0) {
                this.B.setText(i3);
            }
        }
        CharSequence charSequence2 = this.f80843s;
        if (charSequence2 != null) {
            this.B.setContentDescription(charSequence2);
        } else if (this.f80842r != 0) {
            this.B.setContentDescription(getContext().getResources().getText(this.f80842r));
        }
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it = MaterialDatePicker.this.f80826a.iterator();
                while (it.hasNext()) {
                    ((MaterialPickerOnPositiveButtonClickListener) it.next()).a(MaterialDatePicker.this.L());
                }
                MaterialDatePicker.this.dismiss();
            }
        });
        Button button = (Button) viewInflate.findViewById(com.google.android.material.R.id.f79620a);
        button.setTag(G);
        CharSequence charSequence3 = this.f80845u;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i4 = this.f80844t;
            if (i4 != 0) {
                button.setText(i4);
            }
        }
        CharSequence charSequence4 = this.f80847w;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.f80846v != 0) {
            button.setContentDescription(getContext().getResources().getText(this.f80846v));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialDatePicker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Iterator it = MaterialDatePicker.this.f80827b.iterator();
                while (it.hasNext()) {
                    ((View.OnClickListener) it.next()).onClick(view);
                }
                MaterialDatePicker.this.dismiss();
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f80829d.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f80830f);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f80831g);
        CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.f80833i);
        MaterialCalendar materialCalendar = this.f80835k;
        Month monthJ = materialCalendar == null ? null : materialCalendar.J();
        if (monthJ != null) {
            builder.b(monthJ.f80870g);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", builder.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f80834j);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f80836l);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f80837m);
        bundle.putInt("INPUT_MODE_KEY", this.f80839o);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f80840p);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f80841q);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f80842r);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f80843s);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f80844t);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f80845u);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f80846v);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f80847w);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f80838n) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.A);
            E(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.f79587q0);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.A, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
        }
        S();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.f80832h.x();
        super.onStop();
    }
}
