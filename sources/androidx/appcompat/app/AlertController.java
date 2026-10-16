package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AppCompatDialog f914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Window f915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ListView f919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f923k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f924l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f925m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Button f927o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f928p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    Message f929q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Drawable f930r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Button f931s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CharSequence f932t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    Message f933u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Drawable f934v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Button f935w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CharSequence f936x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    Message f937y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Drawable f938z;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f926n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message messageObtain = (view != alertController.f927o || (message3 = alertController.f929q) == null) ? (view != alertController.f931s || (message2 = alertController.f933u) == null) ? (view != alertController.f935w || (message = alertController.f937y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f914b).sendToTarget();
        }
    };

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements NestedScrollView.OnScrollChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f941b;

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
            AlertController.g(nestedScrollView, this.f940a, this.f941b);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AlertController f944c;

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(this.f944c.A, this.f942a, this.f943b);
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass5 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AlertController f949c;

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(this.f949c.f919g, this.f947a, this.f948b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class AlertParams {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public OnPrepareListViewListener O;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f951b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f953d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f955f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f956g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f957h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f958i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Drawable f959j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f960k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public CharSequence f961l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Drawable f962m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f963n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public CharSequence f964o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Drawable f965p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f966q;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f968s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f969t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f970u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public CharSequence[] f971v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public ListAdapter f972w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f973x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f974y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public View f975z;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f952c = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f954e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f967r = true;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface OnPrepareListViewListener {
            void a(ListView listView);
        }

        public AlertParams(Context context) {
            this.f950a = context;
            this.f951b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            AlertParams alertParams;
            final AlertController alertController2;
            ListAdapter checkedItemAdapter;
            final RecycleListView recycleListView = (RecycleListView) this.f951b.inflate(alertController.L, (ViewGroup) null);
            if (!this.G) {
                alertParams = this;
                alertController2 = alertController;
                int i3 = alertParams.H ? alertController2.N : alertController2.O;
                if (alertParams.K != null) {
                    checkedItemAdapter = new SimpleCursorAdapter(alertParams.f950a, i3, alertParams.K, new String[]{alertParams.L}, new int[]{R.id.text1});
                } else {
                    checkedItemAdapter = alertParams.f972w;
                    if (checkedItemAdapter == null) {
                        checkedItemAdapter = new CheckedItemAdapter(alertParams.f950a, i3, R.id.text1, alertParams.f971v);
                    }
                }
            } else if (this.K == null) {
                alertParams = this;
                checkedItemAdapter = new ArrayAdapter<CharSequence>(this.f950a, alertController.M, R.id.text1, this.f971v) { // from class: androidx.appcompat.app.AlertController.AlertParams.1
                    @Override // android.widget.ArrayAdapter, android.widget.Adapter
                    public View getView(int i4, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i4, view, viewGroup);
                        boolean[] zArr = AlertParams.this.F;
                        if (zArr != null && zArr[i4]) {
                            recycleListView.setItemChecked(i4, true);
                        }
                        return view2;
                    }
                };
                recycleListView = recycleListView;
                alertController2 = alertController;
            } else {
                alertParams = this;
                alertController2 = alertController;
                checkedItemAdapter = new CursorAdapter(alertParams.f950a, alertParams.K, false) { // from class: androidx.appcompat.app.AlertController.AlertParams.2

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    private final int f978a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    private final int f979b;

                    {
                        Cursor cursor = getCursor();
                        this.f978a = cursor.getColumnIndexOrThrow(AlertParams.this.L);
                        this.f979b = cursor.getColumnIndexOrThrow(AlertParams.this.M);
                    }

                    @Override // android.widget.CursorAdapter
                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f978a));
                        recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f979b) == 1);
                    }

                    @Override // android.widget.CursorAdapter
                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return AlertParams.this.f951b.inflate(alertController2.M, viewGroup, false);
                    }
                };
            }
            OnPrepareListViewListener onPrepareListViewListener = alertParams.O;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.a(recycleListView);
            }
            alertController2.H = checkedItemAdapter;
            alertController2.I = alertParams.I;
            if (alertParams.f973x != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView adapterView, View view, int i4, long j3) {
                        AlertParams.this.f973x.onClick(alertController2.f914b, i4);
                        if (AlertParams.this.H) {
                            return;
                        }
                        alertController2.f914b.dismiss();
                    }
                });
            } else if (alertParams.J != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView adapterView, View view, int i4, long j3) {
                        boolean[] zArr = AlertParams.this.F;
                        if (zArr != null) {
                            zArr[i4] = recycleListView.isItemChecked(i4);
                        }
                        AlertParams.this.J.onClick(alertController2.f914b, i4, recycleListView.isItemChecked(i4));
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = alertParams.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (alertParams.H) {
                recycleListView.setChoiceMode(1);
            } else if (alertParams.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController2.f919g = recycleListView;
        }

        public void a(AlertController alertController) {
            AlertController alertController2;
            View view = this.f956g;
            if (view != null) {
                alertController.m(view);
            } else {
                CharSequence charSequence = this.f955f;
                if (charSequence != null) {
                    alertController.r(charSequence);
                }
                Drawable drawable = this.f953d;
                if (drawable != null) {
                    alertController.o(drawable);
                }
                int i3 = this.f952c;
                if (i3 != 0) {
                    alertController.n(i3);
                }
                int i4 = this.f954e;
                if (i4 != 0) {
                    alertController.n(alertController.d(i4));
                }
            }
            CharSequence charSequence2 = this.f957h;
            if (charSequence2 != null) {
                alertController.p(charSequence2);
            }
            CharSequence charSequence3 = this.f958i;
            if (charSequence3 == null && this.f959j == null) {
                alertController2 = alertController;
            } else {
                alertController.l(-1, charSequence3, this.f960k, null, this.f959j);
                alertController2 = alertController;
            }
            CharSequence charSequence4 = this.f961l;
            if (charSequence4 != null || this.f962m != null) {
                alertController2.l(-2, charSequence4, this.f963n, null, this.f962m);
            }
            CharSequence charSequence5 = this.f964o;
            if (charSequence5 != null || this.f965p != null) {
                alertController2.l(-3, charSequence5, this.f966q, null, this.f965p);
            }
            if (this.f971v != null || this.K != null || this.f972w != null) {
                b(alertController2);
            }
            View view2 = this.f975z;
            if (view2 != null) {
                if (this.E) {
                    alertController2.u(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController2.t(view2);
                    return;
                }
            }
            int i5 = this.f974y;
            if (i5 != 0) {
                alertController2.s(i5);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ButtonHandler extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference f988a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f988a = new WeakReference(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == -3 || i3 == -2 || i3 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f988a.get(), message.what);
            } else {
                if (i3 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i3, int i4, CharSequence[] charSequenceArr) {
            super(context, i3, i4, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f990b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.f856m2);
            this.f990b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.f860n2, -1);
            this.f989a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.f864o2, -1);
        }

        public void a(boolean z2, boolean z3) {
            if (z3 && z2) {
                return;
            }
            setPadding(getPaddingLeft(), z2 ? getPaddingTop() : this.f989a, getPaddingRight(), z3 ? getPaddingBottom() : this.f990b);
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f913a = context;
        this.f914b = appCompatDialog;
        this.f915c = window;
        this.R = new ButtonHandler(appCompatDialog);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, androidx.appcompat.R.styleable.H, androidx.appcompat.R.attr.f659o, 0);
        this.J = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.I, 0);
        this.K = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.K, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.M, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.N, 0);
        this.N = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.P, 0);
        this.O = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.L, 0);
        this.P = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.O, true);
        this.f916d = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.J, 0);
        typedArrayObtainStyledAttributes.recycle();
        appCompatDialog.i(1);
    }

    private static boolean A(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.f657n, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void g(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private ViewGroup j(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int k() {
        int i3 = this.K;
        return i3 == 0 ? this.J : this.Q == 1 ? i3 : this.J;
    }

    private void q(ViewGroup viewGroup, View view, int i3, int i4) {
        View viewFindViewById = this.f915c.findViewById(androidx.appcompat.R.id.B);
        View viewFindViewById2 = this.f915c.findViewById(androidx.appcompat.R.id.A);
        ViewCompat.G0(view, i3, i4);
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    private void v(ViewGroup viewGroup) {
        int i3;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f927o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f928p) && this.f930r == null) {
            this.f927o.setVisibility(8);
            i3 = 0;
        } else {
            this.f927o.setText(this.f928p);
            Drawable drawable = this.f930r;
            if (drawable != null) {
                int i4 = this.f916d;
                drawable.setBounds(0, 0, i4, i4);
                this.f927o.setCompoundDrawables(this.f930r, null, null, null);
            }
            this.f927o.setVisibility(0);
            i3 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f931s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f932t) && this.f934v == null) {
            this.f931s.setVisibility(8);
        } else {
            this.f931s.setText(this.f932t);
            Drawable drawable2 = this.f934v;
            if (drawable2 != null) {
                int i5 = this.f916d;
                drawable2.setBounds(0, 0, i5, i5);
                this.f931s.setCompoundDrawables(this.f934v, null, null, null);
            }
            this.f931s.setVisibility(0);
            i3 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f935w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f936x) && this.f938z == null) {
            this.f935w.setVisibility(8);
        } else {
            this.f935w.setText(this.f936x);
            Drawable drawable3 = this.f938z;
            if (drawable3 != null) {
                int i6 = this.f916d;
                drawable3.setBounds(0, 0, i6, i6);
                this.f935w.setCompoundDrawables(this.f938z, null, null, null);
            }
            this.f935w.setVisibility(0);
            i3 |= 4;
        }
        if (A(this.f913a)) {
            if (i3 == 1) {
                b(this.f927o);
            } else if (i3 == 2) {
                b(this.f931s);
            } else if (i3 == 4) {
                b(this.f935w);
            }
        }
        if (i3 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void w(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f915c.findViewById(androidx.appcompat.R.id.C);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f918f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f919g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f919g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void x(ViewGroup viewGroup) {
        View viewInflate = this.f920h;
        if (viewInflate == null) {
            viewInflate = this.f921i != 0 ? LayoutInflater.from(this.f913a).inflate(this.f921i, viewGroup, false) : null;
        }
        boolean z2 = viewInflate != null;
        if (!z2 || !a(viewInflate)) {
            this.f915c.setFlags(131072, 131072);
        }
        if (!z2) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f915c.findViewById(androidx.appcompat.R.id.f747o);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f926n) {
            frameLayout.setPadding(this.f922j, this.f923k, this.f924l, this.f925m);
        }
        if (this.f919g != null) {
            ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = 0.0f;
        }
    }

    private void y(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f915c.findViewById(androidx.appcompat.R.id.U).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f915c.findViewById(R.id.icon);
        if (TextUtils.isEmpty(this.f917e) || !this.P) {
            this.f915c.findViewById(androidx.appcompat.R.id.U).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f915c.findViewById(androidx.appcompat.R.id.f743k);
        this.E = textView;
        textView.setText(this.f917e);
        int i3 = this.B;
        if (i3 != 0) {
            this.D.setImageResource(i3);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f915c.findViewById(androidx.appcompat.R.id.f758z);
        int i3 = androidx.appcompat.R.id.V;
        View viewFindViewById4 = viewFindViewById3.findViewById(i3);
        int i4 = androidx.appcompat.R.id.f746n;
        View viewFindViewById5 = viewFindViewById3.findViewById(i4);
        int i5 = androidx.appcompat.R.id.f744l;
        View viewFindViewById6 = viewFindViewById3.findViewById(i5);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(androidx.appcompat.R.id.f748p);
        x(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i3);
        View viewFindViewById8 = viewGroup.findViewById(i4);
        View viewFindViewById9 = viewGroup.findViewById(i5);
        ViewGroup viewGroupJ = j(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupJ2 = j(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupJ3 = j(viewFindViewById9, viewFindViewById6);
        w(viewGroupJ2);
        v(viewGroupJ3);
        y(viewGroupJ);
        boolean z2 = viewGroup.getVisibility() != 8;
        boolean z3 = (viewGroupJ == null || viewGroupJ.getVisibility() == 8) ? 0 : 1;
        boolean z4 = (viewGroupJ3 == null || viewGroupJ3.getVisibility() == 8) ? false : true;
        if (!z4 && viewGroupJ2 != null && (viewFindViewById2 = viewGroupJ2.findViewById(androidx.appcompat.R.id.Q)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z3 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f918f == null && this.f919g == null) ? null : viewGroupJ.findViewById(androidx.appcompat.R.id.T);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupJ2 != null && (viewFindViewById = viewGroupJ2.findViewById(androidx.appcompat.R.id.R)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f919g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z3, z4);
        }
        if (!z2) {
            View view = this.f919g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                q(viewGroupJ2, view, z3 | (z4 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f919g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i6 = this.I;
        if (i6 > -1) {
            listView2.setItemChecked(i6, true);
            listView2.setSelection(i6);
        }
    }

    public Button c(int i3) {
        if (i3 == -3) {
            return this.f935w;
        }
        if (i3 == -2) {
            return this.f931s;
        }
        if (i3 != -1) {
            return null;
        }
        return this.f927o;
    }

    public int d(int i3) {
        TypedValue typedValue = new TypedValue();
        this.f913a.getTheme().resolveAttribute(i3, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f919g;
    }

    public void f() {
        this.f914b.setContentView(k());
        z();
    }

    public boolean h(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public boolean i(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.t(keyEvent);
    }

    public void l(int i3, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i3, onClickListener);
        }
        if (i3 == -3) {
            this.f936x = charSequence;
            this.f937y = message;
            this.f938z = drawable;
        } else if (i3 == -2) {
            this.f932t = charSequence;
            this.f933u = message;
            this.f934v = drawable;
        } else {
            if (i3 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f928p = charSequence;
            this.f929q = message;
            this.f930r = drawable;
        }
    }

    public void m(View view) {
        this.G = view;
    }

    public void n(int i3) {
        this.C = null;
        this.B = i3;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i3 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void o(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void p(CharSequence charSequence) {
        this.f918f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(CharSequence charSequence) {
        this.f917e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void s(int i3) {
        this.f920h = null;
        this.f921i = i3;
        this.f926n = false;
    }

    public void t(View view) {
        this.f920h = view;
        this.f921i = 0;
        this.f926n = false;
    }

    public void u(View view, int i3, int i4, int i5, int i6) {
        this.f920h = view;
        this.f921i = 0;
        this.f926n = true;
        this.f922j = i3;
        this.f923k = i4;
        this.f924l = i5;
        this.f925m = i6;
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 implements AbsListView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f946b;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
            AlertController.g(absListView, this.f945a, this.f946b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
        }
    }
}
