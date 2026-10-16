package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.internal.NativeProtocol;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.at, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1289at extends WebViewClient {
    public static byte[] A05;
    public final WeakReference<C1648gi> A02;
    public final WeakReference<InterfaceC1286aq> A03;
    public final WeakReference<C1281al> A04;
    public final InterfaceC1285ap A01 = new InterfaceC1285ap() { // from class: com.facebook.ads.redexgen.X.M4
        @Override // com.facebook.ads.redexgen.core.InterfaceC1285ap
        public final boolean AAf(String str) {
            return C1289at.A04(str);
        }
    };
    public WeakReference<InterfaceC1287ar> A00 = new WeakReference<>(null);

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{Ascii.FS, Ascii.US, Ascii.DC2, 8, 9, 71, Ascii.US, 17, Ascii.FS, 19, Ascii.SYN, 37, 42, Ascii.ESC, 37, 39, 48, Framer.STDIN_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 48, 61, Ascii.FF, 3, 9, Ascii.US, 2, 4, 9, 67, 4, 3, Ascii.EM, 8, 3, Ascii.EM, 67, Ascii.FF, Ascii.SO, Ascii.EM, 4, 2, 3, 67, 59, 36, 40, 58, 119, Framer.EXIT_FRAME_PREFIX, 114, 100, 121, Ascii.DEL, 114, 56, Ascii.DEL, Framer.EXIT_FRAME_PREFIX, 98, 115, Framer.EXIT_FRAME_PREFIX, 98, 56, 117, 119, 98, 115, 113, 121, 100, 111, 56, 84, 68, 89, 65, 69, 87, 84, 90, 83, 117, 101, Framer.EXIT_FRAME_PREFIX, 96, 100, 114, 101, 72, 113, 118, 123, 123, 117, 118, 116, 124, 72, 98, 101, 123, 51, 54, 35, 54, 97, 102, 124, 109, 102, 124, 2, 5, Ascii.ESC, 77, 87, Ascii.US, Ascii.CR, 10, 55, Ascii.RS, 1, Ascii.CR, Ascii.US};
    }

    public C1289at(WeakReference<C1648gi> weakReference, WeakReference<InterfaceC1286aq> weakReference2, WeakReference<C1281al> weakReference3) {
        this.A02 = weakReference;
        this.A03 = weakReference2;
        this.A04 = weakReference3;
    }

    private void A02(String str, C1648gi c1648gi) {
        c1648gi.A08().ABC(A00(11, 11, 104), AbstractC1060Td.A09, new C1061Te(A00(111, 5, 91) + str));
    }

    private boolean A03(WebView webView, String str) {
        Intent intent;
        String strA00 = A00(116, 8, 68);
        C1648gi c1648gi = this.A02.get();
        if (c1648gi != null) {
            if ((M3.A0A && (TextUtils.isEmpty(str) || A00(0, 11, 81).equals(str))) || !this.A01.AAf(str)) {
                return true;
            }
            try {
                Uri uri = XB.A00(str);
                String scheme = uri.getScheme();
                try {
                    boolean zA14 = C1098Up.A14(c1648gi);
                    String strA002 = A00(48, 33, 58);
                    String strA003 = A00(22, 26, 65);
                    String strA004 = A00(105, 6, 36);
                    if (zA14) {
                        if (!M3.A0D.contains(scheme) && !A00(101, 4, 123).equals(scheme)) {
                            if (strA004.equalsIgnoreCase(scheme)) {
                                intent = Intent.parseUri(str, 1);
                                intent.setComponent(null);
                                intent.setSelector(null);
                            } else {
                                intent = new Intent(strA003, uri);
                            }
                            intent.addCategory(strA002);
                            if (Build.VERSION.SDK_INT >= 30) {
                                intent.setFlags(268436480);
                            } else {
                                intent.setFlags(268435456);
                            }
                            try {
                                if (!C1152Wu.A0D(c1648gi, intent)) {
                                    A02(str, c1648gi);
                                }
                                return true;
                            } catch (C1150Ws unused) {
                                if (strA004.equals(scheme)) {
                                    String stringExtra = intent.getStringExtra(A00(81, 20, 59));
                                    if (!TextUtils.isEmpty(stringExtra)) {
                                        if (!C1152Wu.A0D(c1648gi, new Intent(strA003, XB.A00(stringExtra)))) {
                                            A02(str, c1648gi);
                                        }
                                        return true;
                                    }
                                }
                                C1061Te c1061Te = new C1061Te(A00(111, 5, 91) + str);
                                c1061Te.A05(1);
                                c1648gi.A08().ABD(A00(11, 11, 104), AbstractC1060Td.A06, c1061Te);
                                return true;
                            }
                        }
                        return false;
                    }
                    if (!M3.A0A || !strA004.equalsIgnoreCase(scheme)) {
                        if ((M3.A0A && AbstractC1157Xb.A04(str)) || !M3.A0D.contains(scheme)) {
                            return C1152Wu.A0D(c1648gi, new Intent(strA003, uri));
                        }
                    } else {
                        Intent uri2 = Intent.parseUri(str, 1);
                        uri2.addCategory(strA002);
                        uri2.setComponent(null);
                        uri2.setSelector(null);
                        if (c1648gi.getPackageManager().resolveActivity(uri2, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != null && C1152Wu.A0D(c1648gi, uri2)) {
                            webView.goBack();
                            return true;
                        }
                    }
                } catch (Exception e3) {
                    c1648gi.A08().ABD(strA00, AbstractC1060Td.A2d, new C1061Te(e3));
                    c1648gi.A0F().AA2(e3.toString());
                }
                return false;
            } catch (SecurityException e4) {
                c1648gi.A08().ABD(strA00, AbstractC1060Td.A2d, new C1061Te(e4));
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean A04(String str) {
        return true;
    }

    public final void A05(WeakReference<InterfaceC1287ar> weakReference) {
        this.A00 = weakReference;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        C1281al timingLogger = this.A04.get();
        if (timingLogger != null) {
            timingLogger.A03();
        }
        InterfaceC1286aq interfaceC1286aq = this.A03.get();
        if (interfaceC1286aq != null) {
            interfaceC1286aq.AF7(str);
        }
        InterfaceC1287ar interfaceC1287ar = this.A00.get();
        if (interfaceC1287ar != null) {
            interfaceC1287ar.ADB(webView.canGoBack());
            interfaceC1287ar.ADx(webView.canGoForward());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        InterfaceC1286aq listener = this.A03.get();
        if (listener != null) {
            listener.AF9(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i3, String str, String str2) {
        super.onReceivedError(webView, i3, str, str2);
        C1648gi c1648gi = this.A02.get();
        if (c1648gi != null) {
            StringBuilder sb = new StringBuilder();
            String strA00 = A00(0, 0, 109);
            String errorMessage = AbstractC1157Xb.A01(i3, sb.append(strA00).append(str).toString(), strA00 + str2);
            c1648gi.A0F().A9z(errorMessage);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        C1648gi c1648gi = this.A02.get();
        if (c1648gi != null) {
            int errorCode = webResourceError.getErrorCode();
            StringBuilder sb = new StringBuilder();
            String strA00 = A00(0, 0, 109);
            String errorMessage = AbstractC1157Xb.A01(errorCode, sb.append(strA00).append((Object) webResourceError.getDescription()).toString(), strA00 + webResourceRequest.getUrl());
            c1648gi.A0F().A9z(errorMessage);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        C1648gi context = this.A02.get();
        if (context != null) {
            context.A0F().AA0();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        C1648gi context = this.A02.get();
        if (context != null) {
            context.A0F().AA1();
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbstractC1294ay.A0D(AbstractC1060Td.A2e);
        InterfaceC1286aq listener = this.A03.get();
        if (listener != null) {
            listener.AFe();
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return A03(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return A03(webView, str);
    }
}
