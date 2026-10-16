package com.singular.sdk.internal.InstallReferrer;

import android.content.Context;
import androidx.glance.session.ecY.lisODU;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.singular.sdk.internal.SLReflectionUtils;
import com.singular.sdk.internal.SingularLog;
import com.singular.sdk.internal.Utils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SLReflectionInstallReferrer implements InvocationHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SingularLog f92585e = SingularLog.f(SLReflectionInstallReferrer.class.getSimpleName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f92586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f92587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f92588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SLInstallReferrerCompletionHandler f92589d;

    /* JADX INFO: renamed from: com.singular.sdk.internal.InstallReferrer.SLReflectionInstallReferrer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f92590a;

        static {
            int[] iArr = new int[InstallReferrerCodes.values().length];
            f92590a = iArr;
            try {
                iArr[InstallReferrerCodes.STATUS_OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f92590a[InstallReferrerCodes.STATUS_FEATURE_NOT_SUPPORTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f92590a[InstallReferrerCodes.STATUS_SERVICE_UNAVAILABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum InstallReferrerCodes {
        STATUS_OK(0),
        STATUS_FEATURE_NOT_SUPPORTED(1),
        STATUS_SERVICE_UNAVAILABLE(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f92595a;

        InstallReferrerCodes(int i3) {
            this.f92595a = i3;
        }
    }

    public SLReflectionInstallReferrer(Context context, String str, SLInstallReferrerCompletionHandler sLInstallReferrerCompletionHandler) {
        this.f92586a = context;
        this.f92589d = sLInstallReferrerCompletionHandler;
        this.f92588c = str;
    }

    private void a() {
        Object obj = this.f92587b;
        if (obj == null) {
            f92585e.a("closeReferrerClient: referrer client is null, nothing to close");
            return;
        }
        try {
            SLReflectionUtils.f(obj, "endConnection", null, new Object[0]);
        } catch (Exception e3) {
            f92585e.c("closeReferrerClient error: " + Utils.l(e3));
        }
        this.f92587b = null;
    }

    private Object b(Context context) {
        try {
            return SLReflectionUtils.f(SLReflectionUtils.h(this.f92588c + ".InstallReferrerClient", InAppPurchaseConstants.METHOD_NEW_BUILDER, new Class[]{Context.class}, context), InAppPurchaseConstants.METHOD_BUILD, null, new Object[0]);
        } catch (Throwable th) {
            SingularLog singularLog = f92585e;
            singularLog.e("could not create install referrer client %s", th.getMessage());
            singularLog.c("createInstallReferrerClient: returning null, failed to create install referrer client for package: " + this.f92588c);
            return null;
        }
    }

    private Object c(Class cls) {
        try {
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, this);
        } catch (Exception e3) {
            f92585e.e("InstallReferrer proxy exception %s", e3.getMessage());
            return null;
        }
    }

    private long d(Object obj) {
        if (obj == null) {
            f92585e.a("getInstallBeginTimestampSeconds: referrer details is null, returning default");
            return -1L;
        }
        try {
            return ((Long) SLReflectionUtils.f(obj, "getInstallBeginTimestampSeconds", null, new Object[0])).longValue();
        } catch (Exception e3) {
            f92585e.c("getInstallBeginTimestampSeconds error: " + Utils.l(e3));
            return -1L;
        }
    }

    private Object e() {
        Object obj = this.f92587b;
        if (obj == null) {
            f92585e.c("getInstallReferrer: referrer client is null");
            return null;
        }
        try {
            return SLReflectionUtils.f(obj, "getInstallReferrer", null, new Object[0]);
        } catch (Exception e3) {
            SingularLog singularLog = f92585e;
            singularLog.c("getInstallReferrer error: " + Utils.l(e3));
            singularLog.c("getInstallReferrer: returning null, failed to get install referrer details");
            return null;
        }
    }

    private Class f() {
        try {
            return Class.forName(this.f92588c + ".InstallReferrerStateListener");
        } catch (Exception e3) {
            SingularLog singularLog = f92585e;
            singularLog.e("getInstallReferrerStateListenerClass %s", e3.getMessage());
            singularLog.c("getInstallReferrerStateListenerClass: returning null, failed to get listener class for package: " + this.f92588c);
            return null;
        }
    }

    private long g(Object obj) {
        if (obj == null) {
            f92585e.a("getReferrerClickTimestampSeconds: referrer details is null, returning default");
            return -1L;
        }
        try {
            return ((Long) SLReflectionUtils.f(obj, "getReferrerClickTimestampSeconds", null, new Object[0])).longValue();
        } catch (Exception e3) {
            f92585e.c("getReferrerClickTimestampSeconds error: " + Utils.l(e3));
            return -1L;
        }
    }

    private String h(Object obj) {
        if (obj == null) {
            f92585e.a("getStringInstallReferrer: referrer details is null");
            return null;
        }
        try {
            return (String) SLReflectionUtils.f(obj, "getInstallReferrer", null, new Object[0]);
        } catch (Exception e3) {
            SingularLog singularLog = f92585e;
            singularLog.c("getStringInstallReferrer error: " + Utils.l(e3));
            singularLog.c("getStringInstallReferrer: returning null, failed to extract install referrer string from referrer details");
            return null;
        }
    }

    private void k(Class cls, Object obj) {
        try {
            SLReflectionUtils.f(this.f92587b, InAppPurchaseConstants.METHOD_START_CONNECTION, new Class[]{cls}, obj);
        } catch (Exception e3) {
            f92585e.e("startConnection error %s", e3.getMessage());
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        try {
        } catch (Throwable th) {
            f92585e.e("invoke error %s", th.getMessage());
        }
        if (method == null) {
            f92585e.c("InstallReferrer invoke method null");
            return null;
        }
        String name = method.getName();
        if (name == null) {
            f92585e.c("InstallReferrer invoke method name null");
            return null;
        }
        if (name.equals("onInstallReferrerSetupFinished")) {
            if (objArr != null && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (!(obj2 instanceof Integer)) {
                    f92585e.c("onInstallReferrerSetupFinished invalid arg");
                    return null;
                }
                i(((Integer) obj2).intValue());
            }
            f92585e.c("onInstallReferrerSetupFinished invalid args");
            return null;
        }
        if (name.equals("onInstallReferrerServiceDisconnected")) {
            f92585e.a("onInstallReferrerServiceDisconnected");
            a();
        }
        return null;
    }

    public void j() {
        Context context = this.f92586a;
        if (context == null) {
            f92585e.c("context can not be null");
            this.f92589d.a(null);
            return;
        }
        Object objB = b(context);
        this.f92587b = objB;
        if (objB == null) {
            f92585e.c("startConnection: referrer client is null, cannot start connection");
            this.f92589d.a(null);
            return;
        }
        Class clsF = f();
        if (clsF == null) {
            f92585e.c("startConnection: listener class is null, cannot create listener proxy");
            this.f92589d.a(null);
            return;
        }
        Object objC = c(clsF);
        if (objC != null) {
            k(clsF, objC);
        } else {
            f92585e.c("startConnection: listener proxy is null, cannot start connection");
            this.f92589d.a(null);
        }
    }

    private void i(int i3) {
        int i4 = AnonymousClass1.f92590a[InstallReferrerCodes.values()[i3].ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    f92585e.b("Unexpected response code of install referrer response %d", Integer.valueOf(i3));
                    this.f92589d.a(null);
                    return;
                } else {
                    f92585e.a("STATUS_SERVICE_UNAVAILABLE");
                    this.f92589d.a(null);
                    return;
                }
            }
            f92585e.a("STATUS_FEATURE_NOT_SUPPORTED");
            this.f92589d.a(null);
            return;
        }
        try {
            Object objE = e();
            HashMap map = new HashMap();
            map.put(lisODU.SGVE, h(objE));
            map.put("click_time", Long.valueOf(g(objE)));
            map.put("install_time", Long.valueOf(d(objE)));
            this.f92589d.a(map);
        } catch (Exception e3) {
            f92585e.e("Couldn't get install referrer %s", e3.getMessage());
        }
    }
}
