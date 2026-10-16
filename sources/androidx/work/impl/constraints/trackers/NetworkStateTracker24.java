package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
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
public final class NetworkStateTracker24 extends ConstraintTracker<NetworkState> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConnectivityManager f54903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final NetworkStateTracker24$networkCallback$1 f54904g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1] */
    public NetworkStateTracker24(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        Object systemService = d().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f54903f = (ConnectivityManager) systemService;
        this.f54904g = new ConnectivityManager.NetworkCallback() { // from class: androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
                Intrinsics.checkNotNullParameter(network, "network");
                Intrinsics.checkNotNullParameter(capabilities, "capabilities");
                Logger.e().a(NetworkStateTrackerKt.f54906a, "Network capabilities changed: " + capabilities);
                NetworkStateTracker24 networkStateTracker24 = this.f54905a;
                networkStateTracker24.g(NetworkStateTrackerKt.c(networkStateTracker24.f54903f));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                Logger.e().a(NetworkStateTrackerKt.f54906a, "Network connection lost");
                NetworkStateTracker24 networkStateTracker24 = this.f54905a;
                networkStateTracker24.g(NetworkStateTrackerKt.c(networkStateTracker24.f54903f));
            }
        };
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void h() {
        try {
            Logger.e().a(NetworkStateTrackerKt.f54906a, "Registering network callback");
            NetworkApi24.a(this.f54903f, this.f54904g);
        } catch (IllegalArgumentException e3) {
            Logger.e().d(NetworkStateTrackerKt.f54906a, "Received exception while registering network callback", e3);
        } catch (SecurityException e4) {
            Logger.e().d(NetworkStateTrackerKt.f54906a, "Received exception while registering network callback", e4);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void i() {
        try {
            Logger.e().a(NetworkStateTrackerKt.f54906a, "Unregistering network callback");
            NetworkApi21.c(this.f54903f, this.f54904g);
        } catch (IllegalArgumentException e3) {
            Logger.e().d(NetworkStateTrackerKt.f54906a, "Received exception while unregistering network callback", e3);
        } catch (SecurityException e4) {
            Logger.e().d(NetworkStateTrackerKt.f54906a, "Received exception while unregistering network callback", e4);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public NetworkState e() {
        return NetworkStateTrackerKt.c(this.f54903f);
    }
}
