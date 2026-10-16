package cz.mobilesoft.coreblock.util;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.rest.RestClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class NetworkHelperKt {
    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.U(str, "http", false, 2, null)) {
            return str;
        }
        String strW = RestClient.f98457a.w();
        if (StringsKt.U(str, "/", false, 2, null)) {
            str = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        }
        return strW + ((Object) str);
    }

    public static final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return false;
            }
            return networkCapabilities.hasCapability(12);
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }

    public static final boolean c(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3);
    }

    public static final RequestBuilder d(RequestManager requestManager, String source, int i3, int i4) {
        Intrinsics.checkNotNullParameter(requestManager, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        RequestBuilder requestBuilderA = ((RequestBuilder) ((RequestBuilder) requestManager.a(PictureDrawable.class).K0(a(source)).b0(i3)).k(i4)).a(RequestOptions.v0(DiskCacheStrategy.f66405a));
        Intrinsics.checkNotNullExpressionValue(requestBuilderA, "apply(...)");
        return requestBuilderA;
    }

    public static /* synthetic */ RequestBuilder e(RequestManager requestManager, String str, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = R.drawable.f95490a0;
        }
        if ((i5 & 4) != 0) {
            i4 = R.drawable.f95490a0;
        }
        return d(requestManager, str, i3, i4);
    }
}
