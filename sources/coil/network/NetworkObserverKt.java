package coil.network;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.core.content.ContextCompat;
import coil.network.NetworkObserver;
import coil.util.Contexts;
import coil.util.Logger;
import coil.util.Logs;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class NetworkObserverKt {
    public static final NetworkObserver a(Context context, NetworkObserver.Listener listener, Logger logger) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, ConnectivityManager.class);
        if (connectivityManager == null || !Contexts.e(context, "android.permission.ACCESS_NETWORK_STATE")) {
            if (logger != null && logger.getLevel() <= 5) {
                logger.a("NetworkObserver", 5, "Unable to register network observer.", null);
            }
            return new EmptyNetworkObserver();
        }
        try {
            return new RealNetworkObserver(connectivityManager, listener);
        } catch (Exception e3) {
            if (logger != null) {
                Logs.a(logger, "NetworkObserver", new RuntimeException("Failed to register network observer.", e3));
            }
            return new EmptyNetworkObserver();
        }
    }
}
