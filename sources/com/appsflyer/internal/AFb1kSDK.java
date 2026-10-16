package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import com.appsflyer.AFLogger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AFb1kSDK<T> {
    private final String[] AFInAppEventParameterName;
    public final FutureTask<T> AFInAppEventType = new FutureTask<>(new Callable<T>() { // from class: com.appsflyer.internal.AFb1kSDK.5
        @Override // java.util.concurrent.Callable
        public final T call() {
            if (AFb1kSDK.this.valueOf()) {
                return (T) AFb1kSDK.this.AFKeystoreWrapper();
            }
            return null;
        }
    });
    public final String AFKeystoreWrapper;
    public final Context valueOf;
    public final AFc1ySDK values;

    public AFb1kSDK(Context context, AFc1ySDK aFc1ySDK, String str, String... strArr) {
        this.valueOf = context;
        this.AFKeystoreWrapper = str;
        this.AFInAppEventParameterName = strArr;
        this.values = aFc1ySDK;
    }

    public T AFInAppEventParameterName() {
        try {
            return this.AFInAppEventType.get(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e3) {
            AFLogger.afErrorLog(e3.getMessage(), e3);
            return null;
        }
    }

    protected abstract T AFKeystoreWrapper();

    public final boolean valueOf() {
        try {
            ProviderInfo providerInfoResolveContentProvider = this.valueOf.getPackageManager().resolveContentProvider(this.AFKeystoreWrapper, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            if (providerInfoResolveContentProvider != null) {
                if (Arrays.asList(this.AFInAppEventParameterName).contains(AFa1fSDK.AFInAppEventParameterName(this.valueOf.getPackageManager(), ((PackageItemInfo) providerInfoResolveContentProvider).packageName))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException | CertificateException e3) {
            AFLogger.afErrorLog(e3.getMessage(), e3);
            return false;
        }
    }
}
