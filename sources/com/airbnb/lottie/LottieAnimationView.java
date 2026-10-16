package com.airbnb.lottie;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f56266s = "LottieAnimationView";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final LottieListener f56267t = new LottieListener() { // from class: com.airbnb.lottie.b
        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(Object obj) {
            LottieAnimationView.d((Throwable) obj);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LottieListener f56268d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LottieListener f56269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LottieListener f56270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f56271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LottieDrawable f56272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f56273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f56274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f56275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f56276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f56277n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Set f56278o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Set f56279p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private LottieTask f56280q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private LottieComposition f56281r;

    /* JADX INFO: renamed from: com.airbnb.lottie.LottieAnimationView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements LottieListener<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f56282a;

        @Override // com.airbnb.lottie.LottieListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (this.f56282a.f56271h != 0) {
                LottieAnimationView lottieAnimationView = this.f56282a;
                lottieAnimationView.setImageResource(lottieAnimationView.f56271h);
            }
            (this.f56282a.f56270g == null ? LottieAnimationView.f56267t : this.f56282a.f56270g).onResult(th);
        }
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.LottieAnimationView$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends LottieValueCallback<Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SimpleLottieValueCallback f56283d;

        @Override // com.airbnb.lottie.value.LottieValueCallback
        public Object a(LottieFrameInfo lottieFrameInfo) {
            return this.f56283d.a(lottieFrameInfo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.airbnb.lottie.LottieAnimationView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f56284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f56285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f56286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f56287d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f56288f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f56289g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f56290h;

        /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f56284a);
            parcel.writeFloat(this.f56286c);
            parcel.writeInt(this.f56287d ? 1 : 0);
            parcel.writeString(this.f56288f);
            parcel.writeInt(this.f56289g);
            parcel.writeInt(this.f56290h);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f56284a = parcel.readString();
            this.f56286c = parcel.readFloat();
            this.f56287d = parcel.readInt() == 1;
            this.f56288f = parcel.readString();
            this.f56289g = parcel.readInt();
            this.f56290h = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum UserActionTaken {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public static /* synthetic */ LottieResult c(LottieAnimationView lottieAnimationView, String str) {
        return lottieAnimationView.f56277n ? LottieCompositionFactory.l(lottieAnimationView.getContext(), str) : LottieCompositionFactory.m(lottieAnimationView.getContext(), str, null);
    }

    public static /* synthetic */ void d(Throwable th) {
        if (!Utils.j(th)) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
        Logger.d("Unable to load composition.", th);
    }

    public static /* synthetic */ LottieResult e(LottieAnimationView lottieAnimationView, int i3) {
        return lottieAnimationView.f56277n ? LottieCompositionFactory.u(lottieAnimationView.getContext(), i3) : LottieCompositionFactory.v(lottieAnimationView.getContext(), i3, null);
    }

    private void i() {
        LottieTask lottieTask = this.f56280q;
        if (lottieTask != null) {
            lottieTask.i(this.f56268d);
            this.f56280q.h(this.f56269f);
        }
    }

    private void j() {
        this.f56281r = null;
        this.f56272i.s();
    }

    private LottieTask k(final String str) {
        return isInEditMode() ? new LottieTask(new Callable() { // from class: com.airbnb.lottie.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieAnimationView.c(this.f56429a, str);
            }
        }, true) : this.f56277n ? LottieCompositionFactory.j(getContext(), str) : LottieCompositionFactory.k(getContext(), str, null);
    }

    private LottieTask l(final int i3) {
        return isInEditMode() ? new LottieTask(new Callable() { // from class: com.airbnb.lottie.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieAnimationView.e(this.f56643a, i3);
            }
        }, true) : this.f56277n ? LottieCompositionFactory.s(getContext(), i3) : LottieCompositionFactory.t(getContext(), i3, null);
    }

    private void r() {
        boolean zM = m();
        setImageDrawable(null);
        setImageDrawable(this.f56272i);
        if (zM) {
            this.f56272i.d0();
        }
    }

    private void s(float f3, boolean z2) {
        if (z2) {
            this.f56278o.add(UserActionTaken.SET_PROGRESS);
        }
        this.f56272i.A0(f3);
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        this.f56278o.add(UserActionTaken.SET_ANIMATION);
        j();
        i();
        this.f56280q = lottieTask.d(this.f56268d).c(this.f56269f);
    }

    public boolean getClipToCompositionBounds() {
        return this.f56272i.C();
    }

    public LottieComposition getComposition() {
        return this.f56281r;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.f56281r;
        if (lottieComposition != null) {
            return (long) lottieComposition.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f56272i.G();
    }

    public String getImageAssetsFolder() {
        return this.f56272i.I();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f56272i.K();
    }

    public float getMaxFrame() {
        return this.f56272i.L();
    }

    public float getMinFrame() {
        return this.f56272i.M();
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.f56272i.N();
    }

    public float getProgress() {
        return this.f56272i.O();
    }

    public RenderMode getRenderMode() {
        return this.f56272i.P();
    }

    public int getRepeatCount() {
        return this.f56272i.Q();
    }

    public int getRepeatMode() {
        return this.f56272i.R();
    }

    public float getSpeed() {
        return this.f56272i.S();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof LottieDrawable) && ((LottieDrawable) drawable).P() == RenderMode.SOFTWARE) {
            this.f56272i.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.f56272i;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean m() {
        return this.f56272i.W();
    }

    public void n() {
        this.f56276m = false;
        this.f56272i.Z();
    }

    public void o() {
        this.f56278o.add(UserActionTaken.PLAY_OPTION);
        this.f56272i.a0();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.f56276m) {
            return;
        }
        this.f56272i.a0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i3;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f56273j = savedState.f56284a;
        Set set = this.f56278o;
        UserActionTaken userActionTaken = UserActionTaken.SET_ANIMATION;
        if (!set.contains(userActionTaken) && !TextUtils.isEmpty(this.f56273j)) {
            setAnimation(this.f56273j);
        }
        this.f56274k = savedState.f56285b;
        if (!this.f56278o.contains(userActionTaken) && (i3 = this.f56274k) != 0) {
            setAnimation(i3);
        }
        if (!this.f56278o.contains(UserActionTaken.SET_PROGRESS)) {
            s(savedState.f56286c, false);
        }
        if (!this.f56278o.contains(UserActionTaken.PLAY_OPTION) && savedState.f56287d) {
            o();
        }
        if (!this.f56278o.contains(UserActionTaken.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.f56288f);
        }
        if (!this.f56278o.contains(UserActionTaken.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f56289g);
        }
        if (this.f56278o.contains(UserActionTaken.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(savedState.f56290h);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f56284a = this.f56273j;
        savedState.f56285b = this.f56274k;
        savedState.f56286c = this.f56272i.O();
        savedState.f56287d = this.f56272i.X();
        savedState.f56288f = this.f56272i.I();
        savedState.f56289g = this.f56272i.R();
        savedState.f56290h = this.f56272i.Q();
        return savedState;
    }

    public void p(InputStream inputStream, String str) {
        setCompositionTask(LottieCompositionFactory.n(inputStream, str));
    }

    public void q(String str, String str2) {
        p(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setAnimation(int i3) {
        this.f56274k = i3;
        this.f56273j = null;
        setCompositionTask(l(i3));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        q(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f56277n ? LottieCompositionFactory.w(getContext(), str) : LottieCompositionFactory.x(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z2) {
        this.f56272i.f0(z2);
    }

    public void setCacheComposition(boolean z2) {
        this.f56277n = z2;
    }

    public void setClipToCompositionBounds(boolean z2) {
        this.f56272i.g0(z2);
    }

    public void setComposition(LottieComposition lottieComposition) {
        if (L.f56253a) {
            Log.v(f56266s, "Set Composition \n" + lottieComposition);
        }
        this.f56272i.setCallback(this);
        this.f56281r = lottieComposition;
        this.f56275l = true;
        boolean zH0 = this.f56272i.h0(lottieComposition);
        this.f56275l = false;
        if (getDrawable() != this.f56272i || zH0) {
            if (!zH0) {
                r();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator it = this.f56279p.iterator();
            while (it.hasNext()) {
                ((LottieOnCompositionLoadedListener) it.next()).a(lottieComposition);
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.f56272i.i0(str);
    }

    public void setFailureListener(LottieListener<Throwable> lottieListener) {
        this.f56270g = lottieListener;
    }

    public void setFallbackResource(int i3) {
        this.f56271h = i3;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.f56272i.j0(fontAssetDelegate);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.f56272i.k0(map);
    }

    public void setFrame(int i3) {
        this.f56272i.l0(i3);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z2) {
        this.f56272i.m0(z2);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.f56272i.n0(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String str) {
        this.f56272i.o0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        i();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        i();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        i();
        super.setImageResource(i3);
    }

    public void setMaintainOriginalImageBounds(boolean z2) {
        this.f56272i.p0(z2);
    }

    public void setMaxFrame(int i3) {
        this.f56272i.q0(i3);
    }

    public void setMaxProgress(float f3) {
        this.f56272i.s0(f3);
    }

    public void setMinAndMaxFrame(String str) {
        this.f56272i.u0(str);
    }

    public void setMinFrame(int i3) {
        this.f56272i.v0(i3);
    }

    public void setMinProgress(float f3) {
        this.f56272i.x0(f3);
    }

    public void setOutlineMasksAndMattes(boolean z2) {
        this.f56272i.y0(z2);
    }

    public void setPerformanceTrackingEnabled(boolean z2) {
        this.f56272i.z0(z2);
    }

    public void setProgress(float f3) {
        s(f3, true);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f56272i.B0(renderMode);
    }

    public void setRepeatCount(int i3) {
        this.f56278o.add(UserActionTaken.SET_REPEAT_COUNT);
        this.f56272i.C0(i3);
    }

    public void setRepeatMode(int i3) {
        this.f56278o.add(UserActionTaken.SET_REPEAT_MODE);
        this.f56272i.D0(i3);
    }

    public void setSafeMode(boolean z2) {
        this.f56272i.E0(z2);
    }

    public void setSpeed(float f3) {
        this.f56272i.F0(f3);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.f56272i.G0(textDelegate);
    }

    public void setUseCompositionFrameRate(boolean z2) {
        this.f56272i.H0(z2);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable;
        if (!this.f56275l && drawable == (lottieDrawable = this.f56272i) && lottieDrawable.W()) {
            n();
        } else if (!this.f56275l && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable2 = (LottieDrawable) drawable;
            if (lottieDrawable2.W()) {
                lottieDrawable2.Z();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void setMaxFrame(String str) {
        this.f56272i.r0(str);
    }

    public void setMinFrame(String str) {
        this.f56272i.w0(str);
    }

    public void setAnimation(String str) {
        this.f56273j = str;
        this.f56274k = 0;
        setCompositionTask(k(str));
    }
}
