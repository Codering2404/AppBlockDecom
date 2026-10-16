package com.facebook.ads;

import android.content.Context;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.common.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class BidderTokenProvider {
    public static String getBidderToken(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null.");
        return DynamicLoaderFactory.makeLoader(context).createBidderTokenProviderApi().getBidderToken(context);
    }
}
