package com.google.android.gms.ads.nativead;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzfb;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzblq;
import com.google.android.gms.internal.ads.zzbls;
import com.google.android.gms.internal.ads.zzbmi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class NativeAdView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f70563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbmi f70564b;

    public NativeAdView(Context context) {
        super(context);
        this.f70563a = e(context);
        this.f70564b = f();
    }

    private final void d(String str, View view) {
        zzbmi zzbmiVar = this.f70564b;
        if (zzbmiVar == null) {
            return;
        }
        try {
            zzbmiVar.zzb(str, ObjectWrapper.i5(view));
        } catch (RemoteException e3) {
            zzo.d("Unable to call setAssetView on delegate", e3);
        }
    }

    private final FrameLayout e(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzbmi f() {
        if (isInEditMode()) {
            return null;
        }
        FrameLayout frameLayout = this.f70563a;
        return zzay.b().e(frameLayout.getContext(), this, frameLayout);
    }

    protected final View a(String str) {
        zzbmi zzbmiVar = this.f70564b;
        if (zzbmiVar != null) {
            try {
                IObjectWrapper iObjectWrapperZzc = zzbmiVar.zzc(str);
                if (iObjectWrapperZzc != null) {
                    return (View) ObjectWrapper.h5(iObjectWrapperZzc);
                }
            } catch (RemoteException e3) {
                zzo.d("Unable to call getAssetView on delegate", e3);
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        super.bringChildToFront(this.f70563a);
    }

    final /* synthetic */ void b(MediaContent mediaContent) {
        zzbmi zzbmiVar = this.f70564b;
        if (zzbmiVar == null) {
            return;
        }
        try {
            if (mediaContent instanceof zzfb) {
                zzbmiVar.zzdE(((zzfb) mediaContent).b());
            } else if (mediaContent == null) {
                zzbmiVar.zzdE(null);
            } else {
                zzo.a("Use MediaContent provided by NativeAd.getMediaContent");
            }
        } catch (RemoteException e3) {
            zzo.d("Unable to call setMediaContent on delegate", e3);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.f70563a;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    final /* synthetic */ void c(ImageView.ScaleType scaleType) {
        zzbmi zzbmiVar = this.f70564b;
        if (zzbmiVar == null || scaleType == null) {
            return;
        }
        try {
            zzbmiVar.zzdC(ObjectWrapper.i5(scaleType));
        } catch (RemoteException e3) {
            zzo.d("Unable to call setMediaViewImageScaleType on delegate", e3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzbmi zzbmiVar = this.f70564b;
        if (zzbmiVar != null) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmY)).booleanValue()) {
                try {
                    zzbmiVar.zzdD(ObjectWrapper.i5(motionEvent));
                } catch (RemoteException e3) {
                    zzo.d("Unable to call handleTouchEvent on delegate", e3);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public AdChoicesView getAdChoicesView() {
        View viewA = a("3011");
        if (viewA instanceof AdChoicesView) {
            return (AdChoicesView) viewA;
        }
        return null;
    }

    public final View getAdvertiserView() {
        return a("3005");
    }

    public final View getBodyView() {
        return a("3004");
    }

    public final View getCallToActionView() {
        return a("3002");
    }

    public final View getHeadlineView() {
        return a("3001");
    }

    public final View getIconView() {
        return a("3003");
    }

    public final View getImageView() {
        return a("3008");
    }

    public final MediaView getMediaView() {
        View viewA = a("3010");
        if (viewA instanceof MediaView) {
            return (MediaView) viewA;
        }
        if (viewA == null) {
            return null;
        }
        zzo.a("View is not an instance of MediaView");
        return null;
    }

    public final View getPriceView() {
        return a("3007");
    }

    public final View getStarRatingView() {
        return a("3009");
    }

    public final View getStoreView() {
        return a("3006");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        zzbmi zzbmiVar = this.f70564b;
        if (zzbmiVar == null) {
            return;
        }
        try {
            zzbmiVar.zzf(ObjectWrapper.i5(view), i3);
        } catch (RemoteException e3) {
            zzo.d("Unable to call onVisibilityChanged on delegate", e3);
        }
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f70563a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.f70563a == view) {
            return;
        }
        super.removeView(view);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        d("3011", adChoicesView);
    }

    public final void setAdvertiserView(View view) {
        d("3005", view);
    }

    public final void setBodyView(View view) {
        d("3004", view);
    }

    public final void setCallToActionView(View view) {
        d("3002", view);
    }

    public final void setClickConfirmingView(View view) {
        zzbmi zzbmiVar = this.f70564b;
        if (zzbmiVar == null) {
            return;
        }
        try {
            zzbmiVar.zzdB(ObjectWrapper.i5(view));
        } catch (RemoteException e3) {
            zzo.d("Unable to call setClickConfirmingView on delegate", e3);
        }
    }

    public final void setHeadlineView(View view) {
        d("3001", view);
    }

    public final void setIconView(View view) {
        d("3003", view);
    }

    public final void setImageView(View view) {
        d("3008", view);
    }

    public final void setMediaView(MediaView mediaView) {
        d("3010", mediaView);
        if (mediaView == null) {
            return;
        }
        mediaView.a(new zzblq() { // from class: com.google.android.gms.ads.nativead.zzb
            @Override // com.google.android.gms.internal.ads.zzblq
            public final /* synthetic */ void zza(MediaContent mediaContent) {
                this.f70566a.b(mediaContent);
            }
        });
        mediaView.b(new zzbls() { // from class: com.google.android.gms.ads.nativead.zza
            @Override // com.google.android.gms.internal.ads.zzbls
            public final /* synthetic */ void zza(ImageView.ScaleType scaleType) {
                this.f70565a.c(scaleType);
            }
        });
    }

    public void setNativeAd(NativeAd nativeAd) {
        zzbmi zzbmiVar = this.f70564b;
        if (zzbmiVar == null) {
            return;
        }
        try {
            zzbmiVar.zzd((IObjectWrapper) nativeAd.zza());
        } catch (RemoteException e3) {
            zzo.d("Unable to call setNativeAd on delegate", e3);
        }
    }

    public final void setPriceView(View view) {
        d("3007", view);
    }

    public final void setStarRatingView(View view) {
        d("3009", view);
    }

    public final void setStoreView(View view) {
        d("3006", view);
    }
}
