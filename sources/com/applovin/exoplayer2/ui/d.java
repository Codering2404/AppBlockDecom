package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.exoplayer2.ui.i;
import com.applovin.impl.b1;
import com.applovin.impl.e8;
import com.applovin.impl.fo;
import com.applovin.impl.qh;
import com.applovin.impl.s4;
import com.applovin.impl.t2;
import com.applovin.impl.t5;
import com.applovin.impl.ui;
import com.applovin.impl.xp;
import com.applovin.sdk.R;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class d extends FrameLayout {
    private final String A;
    private final Drawable B;
    private final Drawable C;
    private final float D;
    private final float E;
    private final String F;
    private final String G;
    private qh H;
    private s4 I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private long V;
    private long[] W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f58021a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean[] f58022a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f58023b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private long[] f58024b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f58025c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private boolean[] f58026c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f58027d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private long f58028d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private long f58029e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View f58030f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private long f58031f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final View f58032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final View f58033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View f58034i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ImageView f58035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ImageView f58036k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final View f58037l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final TextView f58038m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final TextView f58039n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final i f58040o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final StringBuilder f58041p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Formatter f58042q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final fo.b f58043r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final fo.d f58044s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Runnable f58045t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Runnable f58046u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Drawable f58047v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Drawable f58048w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Drawable f58049x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final String f58050y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final String f58051z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.ui.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InterfaceC0096d {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface e {
        void d(int i3);
    }

    static {
        e8.a("goog.exo.ui");
    }

    public d(Context context, AttributeSet attributeSet, int i3, AttributeSet attributeSet2) {
        super(context, attributeSet, i3);
        int resourceId = R.layout.applovin_exo_player_control_view;
        this.N = 5000;
        this.P = 0;
        this.O = 200;
        this.V = -9223372036854775807L;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = true;
        this.U = false;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.AppLovinPlayerControlView, i3, 0);
            try {
                this.N = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerControlView_al_show_timeout, this.N);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppLovinPlayerControlView_al_controller_layout_id, resourceId);
                this.P = a(typedArrayObtainStyledAttributes, this.P);
                this.Q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_rewind_button, this.Q);
                this.R = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_fastforward_button, this.R);
                this.S = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_previous_button, this.S);
                this.T = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_next_button, this.T);
                this.U = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerControlView_al_show_shuffle_button, this.U);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerControlView_al_time_bar_min_update_interval, this.O));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f58023b = new CopyOnWriteArrayList();
        this.f58043r = new fo.b();
        this.f58044s = new fo.d();
        StringBuilder sb = new StringBuilder();
        this.f58041p = sb;
        this.f58042q = new Formatter(sb, Locale.getDefault());
        this.W = new long[0];
        this.f58022a0 = new boolean[0];
        this.f58024b0 = new long[0];
        this.f58026c0 = new boolean[0];
        c cVar = new c();
        this.f58021a = cVar;
        this.I = new t5();
        this.f58045t = new Runnable() { // from class: com.applovin.exoplayer2.ui.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f58129a.k();
            }
        };
        this.f58046u = new Runnable() { // from class: com.applovin.exoplayer2.ui.n
            @Override // java.lang.Runnable
            public final void run() {
                this.f58130a.a();
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        int i4 = R.id.al_exo_progress;
        i iVar = (i) findViewById(i4);
        View viewFindViewById = findViewById(R.id.al_exo_progress_placeholder);
        if (iVar != null) {
            this.f58040o = iVar;
        } else if (viewFindViewById != null) {
            com.applovin.exoplayer2.ui.b bVar = new com.applovin.exoplayer2.ui.b(context, null, 0, attributeSet2);
            bVar.setId(i4);
            bVar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(bVar, iIndexOfChild);
            this.f58040o = bVar;
        } else {
            this.f58040o = null;
        }
        this.f58038m = (TextView) findViewById(R.id.al_exo_duration);
        this.f58039n = (TextView) findViewById(R.id.al_exo_position);
        i iVar2 = this.f58040o;
        if (iVar2 != null) {
            iVar2.a(cVar);
        }
        View viewFindViewById2 = findViewById(R.id.al_exo_play);
        this.f58030f = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(R.id.al_exo_pause);
        this.f58032g = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        View viewFindViewById4 = findViewById(R.id.al_exo_prev);
        this.f58025c = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(cVar);
        }
        View viewFindViewById5 = findViewById(R.id.al_exo_next);
        this.f58027d = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(R.id.al_exo_rew);
        this.f58034i = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(R.id.al_exo_ffwd);
        this.f58033h = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        ImageView imageView = (ImageView) findViewById(R.id.al_exo_repeat_toggle);
        this.f58035j = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.al_exo_shuffle);
        this.f58036k = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(cVar);
        }
        View viewFindViewById8 = findViewById(R.id.al_exo_vr);
        this.f58037l = viewFindViewById8;
        setShowVrButton(false);
        a(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.D = resources.getInteger(R.integer.al_exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.E = resources.getInteger(R.integer.al_exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f58047v = resources.getDrawable(R.drawable.al_exo_controls_repeat_off);
        this.f58048w = resources.getDrawable(R.drawable.al_exo_controls_repeat_one);
        this.f58049x = resources.getDrawable(R.drawable.al_exo_controls_repeat_all);
        this.B = resources.getDrawable(R.drawable.al_exo_controls_shuffle_on);
        this.C = resources.getDrawable(R.drawable.al_exo_controls_shuffle_off);
        this.f58050y = resources.getString(R.string.al_exo_controls_repeat_off_description);
        this.f58051z = resources.getString(R.string.al_exo_controls_repeat_one_description);
        this.A = resources.getString(R.string.al_exo_controls_repeat_all_description);
        this.F = resources.getString(R.string.al_exo_controls_shuffle_on_description);
        this.G = resources.getString(R.string.al_exo_controls_shuffle_off_description);
    }

    private static boolean a(int i3) {
        return i3 == 90 || i3 == 89 || i3 == 85 || i3 == 79 || i3 == 126 || i3 == 127 || i3 == 87 || i3 == 88;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f58046u);
        } else if (motionEvent.getAction() == 1) {
            b();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public qh getPlayer() {
        return this.H;
    }

    public int getRepeatToggleModes() {
        return this.P;
    }

    public boolean getShowShuffleButton() {
        return this.U;
    }

    public int getShowTimeoutMs() {
        return this.N;
    }

    public boolean getShowVrButton() {
        View view = this.f58037l;
        return view != null && view.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.J = true;
        long j3 = this.V;
        if (j3 != -9223372036854775807L) {
            long jUptimeMillis = j3 - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                a();
            } else {
                postDelayed(this.f58046u, jUptimeMillis);
            }
        } else if (c()) {
            b();
        }
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.J = false;
        removeCallbacks(this.f58045t);
        removeCallbacks(this.f58046u);
    }

    @Deprecated
    public void setControlDispatcher(s4 s4Var) {
        if (this.I != s4Var) {
            this.I = s4Var;
            i();
        }
    }

    public void setPlayer(qh qhVar) {
        b1.b(Looper.myLooper() == Looper.getMainLooper());
        b1.a(qhVar == null || qhVar.p() == Looper.getMainLooper());
        qh qhVar2 = this.H;
        if (qhVar2 == qhVar) {
            return;
        }
        if (qhVar2 != null) {
            qhVar2.a(this.f58021a);
        }
        this.H = qhVar;
        if (qhVar != null) {
            qhVar.b(this.f58021a);
        }
        h();
    }

    public void setRepeatToggleModes(int i3) {
        this.P = i3;
        qh qhVar = this.H;
        if (qhVar != null) {
            int iM = qhVar.m();
            if (i3 == 0 && iM != 0) {
                this.I.a(this.H, 0);
            } else if (i3 == 1 && iM == 2) {
                this.I.a(this.H, 1);
            } else if (i3 == 2 && iM == 1) {
                this.I.a(this.H, 2);
            }
        }
        l();
    }

    public void setShowFastForwardButton(boolean z2) {
        this.R = z2;
        i();
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        this.K = z2;
        n();
    }

    public void setShowNextButton(boolean z2) {
        this.T = z2;
        i();
    }

    public void setShowPreviousButton(boolean z2) {
        this.S = z2;
        i();
    }

    public void setShowRewindButton(boolean z2) {
        this.Q = z2;
        i();
    }

    public void setShowShuffleButton(boolean z2) {
        this.U = z2;
        m();
    }

    public void setShowTimeoutMs(int i3) {
        this.N = i3;
        if (c()) {
            b();
        }
    }

    public void setShowVrButton(boolean z2) {
        View view = this.f58037l;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i3) {
        this.O = xp.a(i3, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.f58037l;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            a(getShowVrButton(), onClickListener != null, this.f58037l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(qh qhVar) {
        int iO = qhVar.o();
        if (iO == 1) {
            this.I.b(qhVar);
        } else if (iO == 4) {
            a(qhVar, qhVar.t(), -9223372036854775807L);
        }
        this.I.b(qhVar, true);
    }

    private void c(qh qhVar) {
        int iO = qhVar.o();
        if (iO == 1 || iO == 4 || !qhVar.l()) {
            b(qhVar);
        } else {
            a(qhVar);
        }
    }

    private void d() {
        View view;
        View view2;
        boolean zF = f();
        if (!zF && (view2 = this.f58030f) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (!zF || (view = this.f58032g) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    private void e() {
        View view;
        View view2;
        boolean zF = f();
        if (!zF && (view2 = this.f58030f) != null) {
            view2.requestFocus();
        } else {
            if (!zF || (view = this.f58032g) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    private boolean f() {
        qh qhVar = this.H;
        return (qhVar == null || qhVar.o() == 4 || this.H.o() == 1 || !this.H.l()) ? false : true;
    }

    private void h() {
        j();
        i();
        l();
        m();
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        boolean z2;
        boolean zB;
        boolean z3;
        boolean z4;
        if (c() && this.J) {
            qh qhVar = this.H;
            boolean z5 = false;
            if (qhVar != null) {
                boolean zB2 = qhVar.b(4);
                boolean zB3 = qhVar.b(6);
                z4 = qhVar.b(10) && this.I.b();
                if (qhVar.b(11) && this.I.a()) {
                    z5 = true;
                }
                zB = qhVar.b(8);
                z2 = z5;
                z5 = zB3;
                z3 = zB2;
            } else {
                z2 = false;
                zB = false;
                z3 = false;
                z4 = false;
            }
            a(this.S, z5, this.f58025c);
            a(this.Q, z4, this.f58034i);
            a(this.R, z2, this.f58033h);
            a(this.T, zB, this.f58027d);
            i iVar = this.f58040o;
            if (iVar != null) {
                iVar.setEnabled(z3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        boolean z2;
        boolean z3;
        if (c() && this.J) {
            boolean zF = f();
            View view = this.f58030f;
            boolean z4 = true;
            if (view != null) {
                z2 = zF && view.isFocused();
                z3 = xp.f65027a < 21 ? z2 : zF && b.a(this.f58030f);
                this.f58030f.setVisibility(zF ? 8 : 0);
            } else {
                z2 = false;
                z3 = false;
            }
            View view2 = this.f58032g;
            if (view2 != null) {
                z2 |= !zF && view2.isFocused();
                if (xp.f65027a < 21) {
                    z4 = z2;
                } else if (zF || !b.a(this.f58032g)) {
                    z4 = false;
                }
                z3 |= z4;
                this.f58032g.setVisibility(zF ? 0 : 8);
            }
            if (z2) {
                e();
            }
            if (z3) {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        long jG;
        long jS;
        if (c() && this.J) {
            qh qhVar = this.H;
            if (qhVar != null) {
                jG = this.f58028d0 + qhVar.g();
                jS = this.f58028d0 + qhVar.s();
            } else {
                jG = 0;
                jS = 0;
            }
            boolean z2 = jG != this.f58029e0;
            this.f58029e0 = jG;
            this.f58031f0 = jS;
            TextView textView = this.f58039n;
            if (textView != null && !this.M && z2) {
                textView.setText(xp.a(this.f58041p, this.f58042q, jG));
            }
            i iVar = this.f58040o;
            if (iVar != null) {
                iVar.setPosition(jG);
                this.f58040o.setBufferedPosition(jS);
            }
            removeCallbacks(this.f58045t);
            int iO = qhVar == null ? 1 : qhVar.o();
            if (qhVar == null || !qhVar.isPlaying()) {
                if (iO == 4 || iO == 1) {
                    return;
                }
                postDelayed(this.f58045t, 1000L);
                return;
            }
            i iVar2 = this.f58040o;
            long jMin = Math.min(iVar2 != null ? iVar2.getPreferredUpdateDelay() : 1000L, 1000 - (jG % 1000));
            float f3 = qhVar.a().f62440a;
            postDelayed(this.f58045t, xp.b(f3 > 0.0f ? (long) (jMin / f3) : 1000L, this.O, 1000L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        ImageView imageView;
        if (c() && this.J && (imageView = this.f58035j) != null) {
            if (this.P == 0) {
                a(false, false, (View) imageView);
                return;
            }
            qh qhVar = this.H;
            if (qhVar == null) {
                a(true, false, (View) imageView);
                this.f58035j.setImageDrawable(this.f58047v);
                this.f58035j.setContentDescription(this.f58050y);
                return;
            }
            a(true, true, (View) imageView);
            int iM = qhVar.m();
            if (iM == 0) {
                this.f58035j.setImageDrawable(this.f58047v);
                this.f58035j.setContentDescription(this.f58050y);
            } else if (iM == 1) {
                this.f58035j.setImageDrawable(this.f58048w);
                this.f58035j.setContentDescription(this.f58051z);
            } else if (iM == 2) {
                this.f58035j.setImageDrawable(this.f58049x);
                this.f58035j.setContentDescription(this.A);
            }
            this.f58035j.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ImageView imageView;
        if (c() && this.J && (imageView = this.f58036k) != null) {
            qh qhVar = this.H;
            if (!this.U) {
                a(false, false, (View) imageView);
                return;
            }
            if (qhVar == null) {
                a(true, false, (View) imageView);
                this.f58036k.setImageDrawable(this.C);
                this.f58036k.setContentDescription(this.G);
            } else {
                a(true, true, (View) imageView);
                this.f58036k.setImageDrawable(qhVar.r() ? this.B : this.C);
                this.f58036k.setContentDescription(qhVar.r() ? this.F : this.G);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        int i3;
        fo.d dVar;
        long j3;
        qh qhVar = this.H;
        if (qhVar == null) {
            return;
        }
        boolean z2 = true;
        this.L = this.K && a(qhVar.n(), this.f58044s);
        long j4 = 0;
        this.f58028d0 = 0L;
        fo foVarN = qhVar.n();
        if (foVarN.c()) {
            i3 = 0;
        } else {
            int iT = qhVar.t();
            boolean z3 = this.L;
            int i4 = z3 ? 0 : iT;
            int iB = z3 ? foVarN.b() - 1 : iT;
            i3 = 0;
            long j5 = 0;
            while (true) {
                if (i4 > iB) {
                    break;
                }
                if (i4 == iT) {
                    this.f58028d0 = t2.b(j5);
                }
                foVarN.a(i4, this.f58044s);
                fo.d dVar2 = this.f58044s;
                if (dVar2.f59763o == -9223372036854775807L) {
                    b1.b(this.L ^ z2);
                    break;
                }
                int i5 = dVar2.f59764p;
                while (true) {
                    dVar = this.f58044s;
                    if (i5 <= dVar.f59765q) {
                        foVarN.a(i5, this.f58043r);
                        int iF = this.f58043r.f();
                        int iA = this.f58043r.a();
                        while (iF < iA) {
                            long jB = this.f58043r.b(iF);
                            if (jB == Long.MIN_VALUE) {
                                j3 = j4;
                                long j6 = this.f58043r.f59738d;
                                if (j6 == -9223372036854775807L) {
                                    iF++;
                                    j4 = j3;
                                } else {
                                    jB = j6;
                                }
                            } else {
                                j3 = j4;
                            }
                            long jE = jB + this.f58043r.e();
                            if (jE >= j3) {
                                long[] jArr = this.W;
                                if (i3 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.W = Arrays.copyOf(jArr, length);
                                    this.f58022a0 = Arrays.copyOf(this.f58022a0, length);
                                }
                                this.W[i3] = t2.b(j5 + jE);
                                this.f58022a0[i3] = this.f58043r.e(iF);
                                i3++;
                            }
                            iF++;
                            j4 = j3;
                        }
                        i5++;
                    }
                }
                j5 += dVar.f59763o;
                i4++;
                j4 = j4;
                z2 = true;
            }
            j4 = j5;
        }
        long jB2 = t2.b(j4);
        TextView textView = this.f58038m;
        if (textView != null) {
            textView.setText(xp.a(this.f58041p, this.f58042q, jB2));
        }
        i iVar = this.f58040o;
        if (iVar != null) {
            iVar.setDuration(jB2);
            int length2 = this.f58024b0.length;
            int i6 = i3 + length2;
            long[] jArr2 = this.W;
            if (i6 > jArr2.length) {
                this.W = Arrays.copyOf(jArr2, i6);
                this.f58022a0 = Arrays.copyOf(this.f58022a0, i6);
            }
            System.arraycopy(this.f58024b0, 0, this.W, i3, length2);
            System.arraycopy(this.f58026c0, 0, this.f58022a0, i3, length2);
            this.f58040o.a(this.W, this.f58022a0, i6);
        }
        k();
    }

    public void g() {
        if (!c()) {
            setVisibility(0);
            Iterator it = this.f58023b.iterator();
            while (it.hasNext()) {
                ((e) it.next()).d(getVisibility());
            }
            h();
            e();
            d();
        }
        b();
    }

    private static boolean a(fo foVar, fo.d dVar) {
        if (foVar.b() > 100) {
            return false;
        }
        int iB = foVar.b();
        for (int i3 = 0; i3 < iB; i3++) {
            if (foVar.a(i3, dVar).f59763o == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    public boolean c() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(qh qhVar) {
        this.I.b(qhVar, false);
    }

    public void b(e eVar) {
        this.f58023b.remove(eVar);
    }

    private boolean a(qh qhVar, int i3, long j3) {
        return this.I.a(qhVar, i3, j3);
    }

    private void b() {
        removeCallbacks(this.f58046u);
        if (this.N > 0) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long j3 = this.N;
            this.V = jUptimeMillis + j3;
            if (this.J) {
                postDelayed(this.f58046u, j3);
                return;
            }
            return;
        }
        this.V = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(qh qhVar, long j3) {
        int iT;
        fo foVarN = qhVar.n();
        if (this.L && !foVarN.c()) {
            int iB = foVarN.b();
            iT = 0;
            while (true) {
                long jD = foVarN.a(iT, this.f58044s).d();
                if (j3 < jD) {
                    break;
                }
                if (iT == iB - 1) {
                    j3 = jD;
                    break;
                } else {
                    j3 -= jD;
                    iT++;
                }
            }
        } else {
            iT = qhVar.t();
        }
        a(qhVar, iT, j3);
        k();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class c implements qh.e, i.a, View.OnClickListener {
        private c() {
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public void a(qh qhVar, qh.d dVar) {
            if (dVar.a(4, 5)) {
                d.this.j();
            }
            if (dVar.a(4, 5, 7)) {
                d.this.k();
            }
            if (dVar.a(8)) {
                d.this.l();
            }
            if (dVar.a(9)) {
                d.this.m();
            }
            if (dVar.a(8, 9, 11, 0, 13)) {
                d.this.i();
            }
            if (dVar.a(11, 0)) {
                d.this.n();
            }
        }

        @Override // com.applovin.exoplayer2.ui.i.a
        public void b(i iVar, long j3) {
            if (d.this.f58039n != null) {
                d.this.f58039n.setText(xp.a(d.this.f58041p, d.this.f58042q, j3));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            qh qhVar = d.this.H;
            if (qhVar == null) {
                return;
            }
            if (d.this.f58027d == view) {
                d.this.I.a(qhVar);
                return;
            }
            if (d.this.f58025c == view) {
                d.this.I.e(qhVar);
                return;
            }
            if (d.this.f58033h == view) {
                if (qhVar.o() != 4) {
                    d.this.I.d(qhVar);
                    return;
                }
                return;
            }
            if (d.this.f58034i == view) {
                d.this.I.c(qhVar);
                return;
            }
            if (d.this.f58030f == view) {
                d.this.b(qhVar);
                return;
            }
            if (d.this.f58032g == view) {
                d.this.a(qhVar);
            } else if (d.this.f58035j == view) {
                d.this.I.a(qhVar, ui.a(qhVar.m(), d.this.P));
            } else if (d.this.f58036k == view) {
                d.this.I.a(qhVar, !qhVar.r());
            }
        }

        @Override // com.applovin.exoplayer2.ui.i.a
        public void a(i iVar, long j3) {
            d.this.M = true;
            if (d.this.f58039n != null) {
                d.this.f58039n.setText(xp.a(d.this.f58041p, d.this.f58042q, j3));
            }
        }

        @Override // com.applovin.exoplayer2.ui.i.a
        public void a(i iVar, long j3, boolean z2) {
            d.this.M = false;
            if (z2 || d.this.H == null) {
                return;
            }
            d dVar = d.this;
            dVar.a(dVar.H, j3);
        }
    }

    public void a(e eVar) {
        b1.a(eVar);
        this.f58023b.add(eVar);
    }

    public void a() {
        if (c()) {
            setVisibility(8);
            Iterator it = this.f58023b.iterator();
            while (it.hasNext()) {
                ((e) it.next()).d(getVisibility());
            }
            removeCallbacks(this.f58045t);
            removeCallbacks(this.f58046u);
            this.V = -9223372036854775807L;
        }
    }

    public void setProgressUpdateListener(InterfaceC0096d interfaceC0096d) {
    }

    private void a(boolean z2, boolean z3, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z3);
        view.setAlpha(z3 ? this.D : this.E);
        view.setVisibility(z2 ? 0 : 8);
    }

    public boolean a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        qh qhVar = this.H;
        if (qhVar == null || !a(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (qhVar.o() == 4) {
                return true;
            }
            this.I.d(qhVar);
            return true;
        }
        if (keyCode == 89) {
            this.I.c(qhVar);
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            c(qhVar);
            return true;
        }
        if (keyCode == 87) {
            this.I.a(qhVar);
            return true;
        }
        if (keyCode == 88) {
            this.I.e(qhVar);
            return true;
        }
        if (keyCode == 126) {
            b(qhVar);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        a(qhVar);
        return true;
    }

    private static int a(TypedArray typedArray, int i3) {
        return typedArray.getInt(R.styleable.AppLovinPlayerControlView_al_repeat_toggle_modes, i3);
    }
}
