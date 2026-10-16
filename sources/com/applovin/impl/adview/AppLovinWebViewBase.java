package com.applovin.impl.adview;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.z3;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinWebViewBase extends WebView {
    public AppLovinWebViewBase(Context context) {
        super(context);
    }

    protected void applySettings(com.applovin.impl.sdk.ad.b bVar) {
        Boolean boolM;
        loadUrl("about:blank");
        int iV0 = bVar.v0();
        if (iV0 >= 0) {
            setLayerType(iV0, null);
        }
        if (z3.d()) {
            getSettings().setMediaPlaybackRequiresUserGesture(bVar.H());
        }
        if (z3.e() && bVar.L0()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        m mVarW0 = bVar.w0();
        if (mVarW0 != null) {
            WebSettings settings = getSettings();
            WebSettings.PluginState pluginStateB = mVarW0.b();
            if (pluginStateB != null) {
                settings.setPluginState(pluginStateB);
            }
            Boolean boolE = mVarW0.e();
            if (boolE != null) {
                settings.setAllowFileAccess(boolE.booleanValue());
            }
            Boolean boolI = mVarW0.i();
            if (boolI != null) {
                settings.setLoadWithOverviewMode(boolI.booleanValue());
            }
            Boolean boolQ = mVarW0.q();
            if (boolQ != null) {
                settings.setUseWideViewPort(boolQ.booleanValue());
            }
            Boolean boolD = mVarW0.d();
            if (boolD != null) {
                settings.setAllowContentAccess(boolD.booleanValue());
            }
            Boolean boolP = mVarW0.p();
            if (boolP != null) {
                settings.setBuiltInZoomControls(boolP.booleanValue());
            }
            Boolean boolH = mVarW0.h();
            if (boolH != null) {
                settings.setDisplayZoomControls(boolH.booleanValue());
            }
            Boolean boolL = mVarW0.l();
            if (boolL != null) {
                settings.setSaveFormData(boolL.booleanValue());
            }
            Boolean boolC = mVarW0.c();
            if (boolC != null) {
                settings.setGeolocationEnabled(boolC.booleanValue());
            }
            Boolean boolJ = mVarW0.j();
            if (boolJ != null) {
                settings.setNeedInitialFocus(boolJ.booleanValue());
            }
            Boolean boolF = mVarW0.f();
            if (boolF != null) {
                settings.setAllowFileAccessFromFileURLs(boolF.booleanValue());
            }
            Boolean boolG = mVarW0.g();
            if (boolG != null) {
                settings.setAllowUniversalAccessFromFileURLs(boolG.booleanValue());
            }
            Boolean boolO = mVarW0.o();
            if (boolO != null) {
                settings.setLoadsImagesAutomatically(boolO.booleanValue());
            }
            Boolean boolN = mVarW0.n();
            if (boolN != null) {
                settings.setBlockNetworkImage(boolN.booleanValue());
            }
            if (z3.f()) {
                Integer numA = mVarW0.a();
                if (numA != null) {
                    settings.setMixedContentMode(numA.intValue());
                }
                if (z3.g()) {
                    Boolean boolK = mVarW0.k();
                    if (boolK != null) {
                        settings.setOffscreenPreRaster(boolK.booleanValue());
                    }
                    if (!z3.l() || (boolM = mVarW0.m()) == null) {
                        return;
                    }
                    settings.setAlgorithmicDarkeningAllowed(boolM.booleanValue());
                }
            }
        }
    }
}
