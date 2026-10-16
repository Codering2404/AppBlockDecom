package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.applovin.exoplayer2.ui.AspectRatioFrameLayout;
import com.applovin.exoplayer2.ui.d;
import com.applovin.impl.b1;
import com.applovin.impl.db;
import com.applovin.impl.fo;
import com.applovin.impl.hf;
import com.applovin.impl.po;
import com.applovin.impl.qh;
import com.applovin.impl.rk;
import com.applovin.impl.rq;
import com.applovin.impl.s4;
import com.applovin.impl.s7;
import com.applovin.impl.so;
import com.applovin.impl.t;
import com.applovin.impl.to;
import com.applovin.impl.ud;
import com.applovin.impl.xp;
import com.applovin.impl.xq;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class e extends FrameLayout {
    private boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f58053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AspectRatioFrameLayout f58054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f58055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f58056d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f58057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ImageView f58058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SubtitleView f58059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View f58060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TextView f58061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final d f58062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final FrameLayout f58063l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final FrameLayout f58064m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private qh f58065n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f58066o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private d.e f58067p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f58068q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Drawable f58069r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f58070s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f58071t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private CharSequence f58072u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f58073v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f58074w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f58075x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f58076y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f58077z;

    public e(Context context) {
        this(context, null);
    }

    private boolean a(int i3) {
        return i3 == 19 || i3 == 270 || i3 == 22 || i3 == 271 || i3 == 20 || i3 == 269 || i3 == 21 || i3 == 268 || i3 == 23;
    }

    private boolean m() {
        if (!this.f58068q) {
            return false;
        }
        b1.b(this.f58058g);
        return true;
    }

    private boolean n() {
        if (!this.f58066o) {
            return false;
        }
        b1.b(this.f58062k);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        qh qhVar = this.f58065n;
        if (qhVar != null && qhVar.d()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean zA = a(keyEvent.getKeyCode());
        if (zA && n() && !this.f58062k.c()) {
            a(true);
            return true;
        }
        if (a(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            a(true);
            return true;
        }
        if (zA && n()) {
            a(true);
        }
        return false;
    }

    public List<t> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f58064m;
        if (frameLayout != null) {
            arrayList.add(new t(frameLayout, 3, "Transparent overlay does not impact viewability"));
        }
        d dVar = this.f58062k;
        if (dVar != null) {
            arrayList.add(new t(dVar, 0));
        }
        return db.a((Collection) arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) b1.a(this.f58063l, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f58074w;
    }

    public boolean getControllerHideOnTouch() {
        return this.f58076y;
    }

    public int getControllerShowTimeoutMs() {
        return this.f58073v;
    }

    public Drawable getDefaultArtwork() {
        return this.f58069r;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.f58064m;
    }

    public qh getPlayer() {
        return this.f58065n;
    }

    public int getResizeMode() {
        b1.b(this.f58054b);
        return this.f58054b.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.f58059h;
    }

    public boolean getUseArtwork() {
        return this.f58068q;
    }

    public boolean getUseController() {
        return this.f58066o;
    }

    public View getVideoSurfaceView() {
        return this.f58056d;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!n() || this.f58065n == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.A = true;
            return true;
        }
        if (action != 1 || !this.A) {
            return false;
        }
        this.A = false;
        performClick();
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!n() || this.f58065n == null) {
            return false;
        }
        a(true);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return g();
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.b bVar) {
        b1.b(this.f58054b);
        this.f58054b.setAspectRatioListener(bVar);
    }

    @Deprecated
    public void setControlDispatcher(s4 s4Var) {
        b1.b(this.f58062k);
        this.f58062k.setControlDispatcher(s4Var);
    }

    public void setControllerAutoShow(boolean z2) {
        this.f58074w = z2;
    }

    public void setControllerHideDuringAds(boolean z2) {
        this.f58075x = z2;
    }

    public void setControllerHideOnTouch(boolean z2) {
        b1.b(this.f58062k);
        this.f58076y = z2;
        j();
    }

    public void setControllerShowTimeoutMs(int i3) {
        b1.b(this.f58062k);
        this.f58073v = i3;
        if (this.f58062k.c()) {
            f();
        }
    }

    public void setControllerVisibilityListener(d.e eVar) {
        b1.b(this.f58062k);
        d.e eVar2 = this.f58067p;
        if (eVar2 == eVar) {
            return;
        }
        if (eVar2 != null) {
            this.f58062k.b(eVar2);
        }
        this.f58067p = eVar;
        if (eVar != null) {
            this.f58062k.a(eVar);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        b1.b(this.f58061j != null);
        this.f58072u = charSequence;
        l();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.f58069r != drawable) {
            this.f58069r = drawable;
            c(false);
        }
    }

    public void setErrorMessageProvider(s7 s7Var) {
        if (s7Var != null) {
            l();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z2) {
        if (this.f58071t != z2) {
            this.f58071t = z2;
            c(false);
        }
    }

    public void setPlayer(qh qhVar) {
        b1.b(Looper.myLooper() == Looper.getMainLooper());
        b1.a(qhVar == null || qhVar.p() == Looper.getMainLooper());
        qh qhVar2 = this.f58065n;
        if (qhVar2 == qhVar) {
            return;
        }
        if (qhVar2 != null) {
            qhVar2.a(this.f58053a);
            if (qhVar2.b(26)) {
                View view = this.f58056d;
                if (view instanceof TextureView) {
                    qhVar2.b((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    qhVar2.b((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.f58059h;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f58065n = qhVar;
        if (n()) {
            this.f58062k.setPlayer(qhVar);
        }
        i();
        l();
        c(true);
        if (qhVar == null) {
            c();
            return;
        }
        if (qhVar.b(26)) {
            View view2 = this.f58056d;
            if (view2 instanceof TextureView) {
                qhVar.a((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                qhVar.a((SurfaceView) view2);
            }
            h();
        }
        if (this.f58059h != null && qhVar.b(27)) {
            this.f58059h.setCues(qhVar.x());
        }
        qhVar.b(this.f58053a);
        a(false);
    }

    public void setRepeatToggleModes(int i3) {
        b1.b(this.f58062k);
        this.f58062k.setRepeatToggleModes(i3);
    }

    public void setResizeMode(int i3) {
        b1.b(this.f58054b);
        this.f58054b.setResizeMode(i3);
    }

    public void setShowBuffering(int i3) {
        if (this.f58070s != i3) {
            this.f58070s = i3;
            i();
        }
    }

    public void setShowFastForwardButton(boolean z2) {
        b1.b(this.f58062k);
        this.f58062k.setShowFastForwardButton(z2);
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        b1.b(this.f58062k);
        this.f58062k.setShowMultiWindowTimeBar(z2);
    }

    public void setShowNextButton(boolean z2) {
        b1.b(this.f58062k);
        this.f58062k.setShowNextButton(z2);
    }

    public void setShowPreviousButton(boolean z2) {
        b1.b(this.f58062k);
        this.f58062k.setShowPreviousButton(z2);
    }

    public void setShowRewindButton(boolean z2) {
        b1.b(this.f58062k);
        this.f58062k.setShowRewindButton(z2);
    }

    public void setShowShuffleButton(boolean z2) {
        b1.b(this.f58062k);
        this.f58062k.setShowShuffleButton(z2);
    }

    public void setShutterBackgroundColor(int i3) {
        View view = this.f58055c;
        if (view != null) {
            view.setBackgroundColor(i3);
        }
    }

    public void setUseArtwork(boolean z2) {
        b1.b((z2 && this.f58058g == null) ? false : true);
        if (this.f58068q != z2) {
            this.f58068q = z2;
            c(false);
        }
    }

    public void setUseController(boolean z2) {
        b1.b((z2 && this.f58062k == null) ? false : true);
        if (this.f58066o == z2) {
            return;
        }
        this.f58066o = z2;
        if (n()) {
            this.f58062k.setPlayer(this.f58065n);
        } else {
            d dVar = this.f58062k;
            if (dVar != null) {
                dVar.a();
                this.f58062k.setPlayer(null);
            }
        }
        j();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        View view = this.f58056d;
        if (view instanceof SurfaceView) {
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class a implements qh.e, View.OnLayoutChangeListener, View.OnClickListener, d.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final fo.b f58078a = new fo.b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f58079b;

        public a() {
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public void a(qh.f fVar, qh.f fVar2, int i3) {
            if (e.this.d() && e.this.f58075x) {
                e.this.c();
            }
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public void b(int i3) {
            e.this.i();
            e.this.l();
            e.this.k();
        }

        @Override // com.applovin.exoplayer2.ui.d.e
        public void d(int i3) {
            e.this.j();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.g();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            e.b((TextureView) view, e.this.f58077z);
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public void a(po poVar, to toVar) {
            qh qhVar = (qh) b1.a(e.this.f58065n);
            fo foVarN = qhVar.n();
            if (foVarN.c()) {
                this.f58079b = null;
            } else if (!qhVar.k().a()) {
                this.f58079b = foVarN.a(qhVar.v(), this.f58078a, true).f59736b;
            } else {
                Object obj = this.f58079b;
                if (obj != null) {
                    int iA = foVarN.a(obj);
                    if (iA != -1) {
                        if (qhVar.t() == foVarN.a(iA, this.f58078a).f59737c) {
                            return;
                        }
                    }
                    this.f58079b = null;
                }
            }
            e.this.c(false);
        }

        @Override // com.applovin.impl.qh.e
        public void a(xq xqVar) {
            e.this.h();
        }

        @Override // com.applovin.impl.qh.e
        public void a(List list) {
            if (e.this.f58059h != null) {
                e.this.f58059h.setCues(list);
            }
        }

        @Override // com.applovin.impl.qh.e
        public void a() {
            if (e.this.f58055c != null) {
                e.this.f58055c.setVisibility(4);
            }
        }

        @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
        public void a(boolean z2, int i3) {
            e.this.i();
            e.this.k();
        }
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean a(ud udVar) {
        byte[] bArr = udVar.f64184l;
        if (bArr == null) {
            return false;
        }
        return a(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    private void b(boolean z2) {
        if (n()) {
            this.f58062k.setShowTimeoutMs(z2 ? 0 : this.f58073v);
            this.f58062k.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        qh qhVar = this.f58065n;
        return qhVar != null && qhVar.d() && this.f58065n.l();
    }

    private boolean e() {
        qh qhVar = this.f58065n;
        if (qhVar == null) {
            return true;
        }
        int iO = qhVar.o();
        if (this.f58074w) {
            return iO == 1 || iO == 4 || !this.f58065n.l();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (!n() || this.f58065n == null) {
            return false;
        }
        if (!this.f58062k.c()) {
            a(true);
        } else if (this.f58076y) {
            this.f58062k.a();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        qh qhVar = this.f58065n;
        xq xqVarZ = qhVar != null ? qhVar.z() : xq.f65042f;
        int i3 = xqVarZ.f65044a;
        int i4 = xqVarZ.f65045b;
        int i5 = xqVarZ.f65046c;
        float f3 = (i4 == 0 || i3 == 0) ? 0.0f : (i3 * xqVarZ.f65047d) / i4;
        View view = this.f58056d;
        if (view instanceof TextureView) {
            if (f3 > 0.0f && (i5 == 90 || i5 == 270)) {
                f3 = 1.0f / f3;
            }
            if (this.f58077z != 0) {
                view.removeOnLayoutChangeListener(this.f58053a);
            }
            this.f58077z = i5;
            if (i5 != 0) {
                this.f58056d.addOnLayoutChangeListener(this.f58053a);
            }
            b((TextureView) this.f58056d, this.f58077z);
        }
        a(this.f58054b, this.f58057f ? 0.0f : f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i() {
        /*
            r4 = this;
            android.view.View r0 = r4.f58060i
            if (r0 == 0) goto L2b
            com.applovin.impl.qh r0 = r4.f58065n
            r1 = 0
            if (r0 == 0) goto L20
            int r0 = r0.o()
            r2 = 2
            if (r0 != r2) goto L20
            int r0 = r4.f58070s
            r3 = 1
            if (r0 == r2) goto L21
            if (r0 != r3) goto L20
            com.applovin.impl.qh r0 = r4.f58065n
            boolean r0 = r0.l()
            if (r0 == 0) goto L20
            goto L21
        L20:
            r3 = r1
        L21:
            android.view.View r0 = r4.f58060i
            if (r3 == 0) goto L26
            goto L28
        L26:
            r1 = 8
        L28:
            r0.setVisibility(r1)
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.e.i():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        d dVar = this.f58062k;
        if (dVar == null || !this.f58066o) {
            setContentDescription(null);
        } else if (dVar.getVisibility() == 0) {
            setContentDescription(this.f58076y ? getResources().getString(R.string.al_exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R.string.al_exo_controls_show));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (d() && this.f58075x) {
            c();
        } else {
            a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        TextView textView = this.f58061j;
        if (textView != null) {
            CharSequence charSequence = this.f58072u;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f58061j.setVisibility(0);
            } else {
                qh qhVar = this.f58065n;
                if (qhVar != null) {
                    qhVar.c();
                }
                this.f58061j.setVisibility(8);
            }
        }
    }

    public void c() {
        d dVar = this.f58062k;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void f() {
        b(e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Context context, AttributeSet attributeSet, int i3) {
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i5;
        int integer;
        int i6;
        int i7;
        boolean z6;
        int i8;
        boolean z7;
        boolean z8;
        int i9;
        boolean z9;
        super(context, attributeSet, i3);
        a aVar = new a();
        this.f58053a = aVar;
        if (isInEditMode()) {
            this.f58054b = null;
            this.f58055c = null;
            this.f58056d = null;
            this.f58057f = false;
            this.f58058g = null;
            this.f58059h = null;
            this.f58060i = null;
            this.f58061j = null;
            this.f58062k = null;
            this.f58063l = null;
            this.f58064m = null;
            ImageView imageView = new ImageView(context);
            if (xp.f65027a >= 23) {
                b(getResources(), imageView);
            } else {
                a(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i10 = R.layout.applovin_exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AppLovinPlayerView, i3, 0);
            try {
                int i11 = R.styleable.AppLovinPlayerView_al_shutter_background_color;
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i11);
                int color = typedArrayObtainStyledAttributes.getColor(i11, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppLovinPlayerView_al_player_layout_id, i10);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppLovinPlayerView_al_default_artwork, 0);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_use_controller, true);
                int i12 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerView_al_surface_type, 1);
                int i13 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerView_al_resize_mode, 0);
                int i14 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinPlayerView_al_show_timeout, 5000);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_hide_on_touch, true);
                boolean z13 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_auto_show, true);
                integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.AppLovinPlayerView_al_show_buffering, 0);
                this.f58071t = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_keep_content_on_player_reset, this.f58071t);
                boolean z14 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppLovinPlayerView_al_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                i10 = resourceId;
                i5 = i14;
                z7 = z14;
                z5 = z11;
                i4 = i12;
                i6 = i13;
                z4 = z10;
                i8 = resourceId2;
                i7 = color;
                z6 = zHasValue;
                z3 = z12;
                z2 = z13;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i4 = 1;
            z2 = true;
            z3 = true;
            z4 = true;
            z5 = true;
            i5 = 5000;
            integer = 0;
            i6 = 0;
            i7 = 0;
            z6 = false;
            i8 = 0;
            z7 = true;
        }
        LayoutInflater.from(context).inflate(i10, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.id.al_exo_content_frame);
        this.f58054b = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            a(aspectRatioFrameLayout, i6);
        }
        View viewFindViewById = findViewById(R.id.al_exo_shutter);
        this.f58055c = viewFindViewById;
        if (viewFindViewById != null && z6) {
            viewFindViewById.setBackgroundColor(i7);
        }
        if (aspectRatioFrameLayout != null && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i4 == 2) {
                this.f58056d = new TextureView(context);
            } else if (i4 == 3) {
                try {
                    int i15 = rk.f62854n;
                    this.f58056d = (View) rk.class.getConstructor(Context.class).newInstance(context);
                    z9 = true;
                    this.f58056d.setLayoutParams(layoutParams);
                    this.f58056d.setOnClickListener(aVar);
                    this.f58056d.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f58056d, 0);
                    z8 = z9;
                } catch (Exception e3) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e3);
                }
            } else if (i4 != 4) {
                this.f58056d = new SurfaceView(context);
            } else {
                try {
                    int i16 = rq.f62904b;
                    this.f58056d = (View) rq.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e4) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e4);
                }
            }
            z9 = false;
            this.f58056d.setLayoutParams(layoutParams);
            this.f58056d.setOnClickListener(aVar);
            this.f58056d.setClickable(false);
            aspectRatioFrameLayout.addView(this.f58056d, 0);
            z8 = z9;
        } else {
            this.f58056d = null;
            z8 = false;
        }
        this.f58057f = z8;
        this.f58063l = (FrameLayout) findViewById(R.id.al_exo_ad_overlay);
        this.f58064m = (FrameLayout) findViewById(R.id.al_exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R.id.al_exo_artwork);
        this.f58058g = imageView2;
        this.f58068q = z4 && imageView2 != null;
        if (i8 != 0) {
            this.f58069r = ContextCompat.getDrawable(getContext(), i8);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.id.al_exo_subtitles);
        this.f58059h = subtitleView;
        if (subtitleView != null) {
            subtitleView.c();
            subtitleView.d();
        }
        View viewFindViewById2 = findViewById(R.id.al_exo_buffering);
        this.f58060i = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.f58070s = integer;
        TextView textView = (TextView) findViewById(R.id.al_exo_error_message);
        this.f58061j = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i17 = R.id.al_exo_controller;
        d dVar = (d) findViewById(i17);
        View viewFindViewById3 = findViewById(R.id.al_exo_controller_placeholder);
        if (dVar != null) {
            this.f58062k = dVar;
            i9 = 0;
        } else if (viewFindViewById3 != null) {
            i9 = 0;
            d dVar2 = new d(context, null, 0, attributeSet);
            this.f58062k = dVar2;
            dVar2.setId(i17);
            dVar2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(dVar2, iIndexOfChild);
        } else {
            i9 = 0;
            this.f58062k = null;
        }
        d dVar3 = this.f58062k;
        this.f58073v = dVar3 != null ? i5 : i9;
        this.f58076y = z3;
        this.f58074w = z2;
        this.f58075x = z7;
        this.f58066o = (!z5 || dVar3 == null) ? i9 : 1;
        c();
        j();
        d dVar4 = this.f58062k;
        if (dVar4 != null) {
            dVar4.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z2) {
        qh qhVar = this.f58065n;
        if (qhVar != null && !qhVar.k().a()) {
            if (z2 && !this.f58071t) {
                a();
            }
            to toVarA = qhVar.A();
            for (int i3 = 0; i3 < toVarA.f63984a; i3++) {
                so soVarA = toVarA.a(i3);
                if (soVarA != null) {
                    for (int i4 = 0; i4 < soVarA.b(); i4++) {
                        if (hf.e(soVarA.a(i4).f59394m) == 2) {
                            b();
                            return;
                        }
                    }
                }
            }
            a();
            if (m() && (a(qhVar.C()) || a(this.f58069r))) {
                return;
            }
            b();
            return;
        }
        if (this.f58071t) {
            return;
        }
        b();
        a();
    }

    private void b() {
        ImageView imageView = this.f58058g;
        if (imageView != null) {
            imageView.setImageResource(android.R.color.transparent);
            this.f58058g.setVisibility(4);
        }
    }

    private static void b(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.applovin_exo_edit_mode_logo, null));
        imageView.setBackgroundColor(resources.getColor(R.color.al_exo_edit_mode_background_color, null));
    }

    public boolean a(KeyEvent keyEvent) {
        return n() && this.f58062k.a(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(TextureView textureView, int i3) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i3 != 0) {
            float f3 = width / 2.0f;
            float f4 = height / 2.0f;
            matrix.postRotate(i3, f3, f4);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f3, f4);
        }
        textureView.setTransform(matrix);
    }

    protected void a(AspectRatioFrameLayout aspectRatioFrameLayout, float f3) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f3);
        }
    }

    private void a(boolean z2) {
        if (!(d() && this.f58075x) && n()) {
            boolean z3 = this.f58062k.c() && this.f58062k.getShowTimeoutMs() <= 0;
            boolean zE = e();
            if (z2 || z3 || zE) {
                b(zE);
            }
        }
    }

    private boolean a(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                a(this.f58054b, intrinsicWidth / intrinsicHeight);
                this.f58058g.setImageDrawable(drawable);
                this.f58058g.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private void a() {
        View view = this.f58055c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void a(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(R.drawable.applovin_exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(R.color.al_exo_edit_mode_background_color));
    }

    private static void a(AspectRatioFrameLayout aspectRatioFrameLayout, int i3) {
        aspectRatioFrameLayout.setResizeMode(i3);
    }
}
