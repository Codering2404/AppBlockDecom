package androidx.webkit.internal;

import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebMessageAdapter implements WebMessageBoundaryInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f53945b = {"WEB_MESSAGE_ARRAY_BUFFER"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebMessageCompat f53946a;

    private static WebMessagePortCompat[] a(InvocationHandler[] invocationHandlerArr) {
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[invocationHandlerArr.length];
        for (int i3 = 0; i3 < invocationHandlerArr.length; i3++) {
            webMessagePortCompatArr[i3] = new WebMessagePortImpl(invocationHandlerArr[i3]);
        }
        return webMessagePortCompatArr;
    }

    public static WebMessageCompat b(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        WebMessagePortCompat[] webMessagePortCompatArrA = a(webMessageBoundaryInterface.getPorts());
        if (!WebViewFeatureInternal.C.d()) {
            return new WebMessageCompat(webMessageBoundaryInterface.getData(), webMessagePortCompatArrA);
        }
        WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
        int type = webMessagePayloadBoundaryInterface.getType();
        if (type == 0) {
            return new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsString(), webMessagePortCompatArrA);
        }
        if (type != 1) {
            return null;
        }
        return new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsArrayBuffer(), webMessagePortCompatArrA);
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public String getData() {
        return this.f53946a.c();
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public InvocationHandler getMessagePayload() {
        WebMessagePayloadAdapter webMessagePayloadAdapter;
        int iE = this.f53946a.e();
        if (iE == 0) {
            webMessagePayloadAdapter = new WebMessagePayloadAdapter(this.f53946a.c());
        } else {
            if (iE != 1) {
                throw new IllegalStateException("Unknown web message payload type: " + this.f53946a.e());
            }
            byte[] bArrB = this.f53946a.b();
            Objects.requireNonNull(bArrB);
            webMessagePayloadAdapter = new WebMessagePayloadAdapter(bArrB);
        }
        return BoundaryInterfaceReflectionUtil.c(webMessagePayloadAdapter);
    }

    @Override // org.chromium.support_lib_boundary.WebMessageBoundaryInterface
    public InvocationHandler[] getPorts() {
        WebMessagePortCompat[] webMessagePortCompatArrD = this.f53946a.d();
        if (webMessagePortCompatArrD == null) {
            return null;
        }
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[webMessagePortCompatArrD.length];
        for (int i3 = 0; i3 < webMessagePortCompatArrD.length; i3++) {
            invocationHandlerArr[i3] = webMessagePortCompatArrD[i3].a();
        }
        return invocationHandlerArr;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        return f53945b;
    }
}
