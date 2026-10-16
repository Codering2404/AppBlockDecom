package com.superwall.sdk.paywall.manager;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.superwall.sdk.misc.ActivityProvider;
import com.superwall.sdk.network.device.DeviceHelper;
import com.superwall.sdk.paywall.view.LoadingView;
import com.superwall.sdk.paywall.view.PaywallPurchaseLoadingView;
import com.superwall.sdk.paywall.view.PaywallShimmerView;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.paywall.view.ShimmerView;
import com.superwall.sdk.paywall.view.ViewStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaywallViewCache {
    private volatile String _activePaywallVcKey;
    private final ActivityProvider activityProvider;
    private final Context appCtx;
    private final DeviceHelper deviceHelper;
    private final Integer loadingColor;
    private final LoadingView loadingView;
    private final ShimmerView shimmerView;
    private final ViewStorage store;

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallViewCache(Context appCtx, ViewStorage store, ActivityProvider activityProvider, DeviceHelper deviceHelper, Integer num) {
        Intrinsics.checkNotNullParameter(appCtx, "appCtx");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        Intrinsics.checkNotNullParameter(deviceHelper, "deviceHelper");
        this.appCtx = appCtx;
        this.store = store;
        this.activityProvider = activityProvider;
        this.deviceHelper = deviceHelper;
        this.loadingColor = num;
        LoadingView loadingView = new LoadingView(getCtx(), null, 0, 0, num, 14, null);
        this.loadingView = loadingView;
        ShimmerView shimmerView = new ShimmerView(getCtx(), null, 2, 0 == true ? 1 : 0);
        this.shimmerView = shimmerView;
        store.storeView(LoadingView.TAG, loadingView);
        store.storeView(ShimmerView.TAG, shimmerView);
    }

    private final Context getCtx() {
        Activity currentActivity = this.activityProvider.getCurrentActivity();
        return currentActivity != null ? currentActivity : this.appCtx;
    }

    public final PaywallPurchaseLoadingView acquireLoadingView() {
        KeyEvent.Callback callbackRetrieveView = this.store.retrieveView(LoadingView.TAG);
        if (callbackRetrieveView != null) {
            return (PaywallPurchaseLoadingView) callbackRetrieveView;
        }
        LoadingView loadingView = new LoadingView(getCtx(), null, 0, 0, this.loadingColor, 14, null);
        this.store.storeView(LoadingView.TAG, loadingView);
        return loadingView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PaywallShimmerView acquireShimmerView() {
        View viewRetrieveView = this.store.retrieveView(ShimmerView.TAG);
        if (viewRetrieveView != null) {
            return (PaywallShimmerView) viewRetrieveView;
        }
        ShimmerView shimmerView = new ShimmerView(getCtx(), null, 2, 0 == true ? 1 : 0);
        this.store.storeView(ShimmerView.TAG, shimmerView);
        return shimmerView;
    }

    public final String getActivePaywallVcKey() {
        return this._activePaywallVcKey;
    }

    public final PaywallView getActivePaywallView() {
        String str = this._activePaywallVcKey;
        if (str != null) {
            return (PaywallView) this.store.retrieveView(str);
        }
        return null;
    }

    public final List<PaywallView> getAllPaywallViews() {
        List<View> listAll = this.store.all();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listAll) {
            if (obj instanceof PaywallView) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toList(arrayList);
    }

    public final PaywallView getPaywallView(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return (PaywallView) this.store.retrieveView(key);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void removeAll() {
        Set<String> setKeySet = this.store.getViews().keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        for (String str : setKeySet) {
            if (!Intrinsics.areEqual(str, this._activePaywallVcKey)) {
                ViewStorage viewStorage = this.store;
                Intrinsics.checkNotNull(str);
                viewStorage.removeView(str);
            }
        }
    }

    public final void removePaywallView(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.store.removeView(PaywallCacheLogic.INSTANCE.key(identifier, this.deviceHelper.getLocale()));
    }

    public final void save(PaywallView paywallView, String identifier) {
        Intrinsics.checkNotNullParameter(paywallView, "paywallView");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.store.storeView(PaywallCacheLogic.INSTANCE.key(identifier, this.deviceHelper.getLocale()), paywallView);
    }

    public final void setActivePaywallVcKey(String str) {
        this._activePaywallVcKey = str;
    }

    public /* synthetic */ PaywallViewCache(Context context, ViewStorage viewStorage, ActivityProvider activityProvider, DeviceHelper deviceHelper, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewStorage, activityProvider, deviceHelper, (i3 & 16) != 0 ? null : num);
    }
}
