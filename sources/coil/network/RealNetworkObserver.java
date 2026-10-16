package coil.network;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import coil.network.NetworkObserver;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
final class RealNetworkObserver implements NetworkObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConnectivityManager f55999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NetworkObserver.Listener f56000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RealNetworkObserver$networkCallback$1 f56001c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.net.ConnectivityManager$NetworkCallback, coil.network.RealNetworkObserver$networkCallback$1] */
    public RealNetworkObserver(ConnectivityManager connectivityManager, NetworkObserver.Listener listener) {
        this.f55999a = connectivityManager;
        this.f56000b = listener;
        ?? r4 = new ConnectivityManager.NetworkCallback() { // from class: coil.network.RealNetworkObserver$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                this.f56002a.d(network, true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                this.f56002a.d(network, false);
            }
        };
        this.f56001c = r4;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), (ConnectivityManager.NetworkCallback) r4);
    }

    private final boolean c(Network network) {
        NetworkCapabilities networkCapabilities = this.f55999a.getNetworkCapabilities(network);
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Network network, boolean z2) {
        Network[] allNetworks = this.f55999a.getAllNetworks();
        int length = allNetworks.length;
        boolean z3 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            Network network2 = allNetworks[i3];
            if (Intrinsics.areEqual(network2, network) ? z2 : c(network2)) {
                z3 = true;
                break;
            }
            i3++;
        }
        this.f56000b.a(z3);
    }

    @Override // coil.network.NetworkObserver
    public boolean a() {
        for (Network network : this.f55999a.getAllNetworks()) {
            if (c(network)) {
                return true;
            }
        }
        return false;
    }

    @Override // coil.network.NetworkObserver
    public void shutdown() {
        this.f55999a.unregisterNetworkCallback(this.f56001c);
    }
}
