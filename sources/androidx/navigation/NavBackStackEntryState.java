package androidx.navigation;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.internal.NavBackStackEntryStateImpl;
import androidx.navigation.internal.NavContext;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavBackStackEntryState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavBackStackEntryStateImpl f48797a;

    public NavBackStackEntryState(NavBackStackEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.f48797a = new NavBackStackEntryStateImpl(entry, entry.d().o());
    }

    public final Bundle a() {
        return this.f48797a.a();
    }

    public final int b() {
        return this.f48797a.b();
    }

    public final String c() {
        return this.f48797a.c();
    }

    public final NavBackStackEntry d(NavContext context, NavDestination destination, Lifecycle.State hostLifecycleState, NavControllerViewModel navControllerViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(hostLifecycleState, "hostLifecycleState");
        Bundle bundleA = a();
        return this.f48797a.d(context, destination, bundleA != null ? e(bundleA, context) : null, hostLifecycleState, navControllerViewModel);
    }

    public final Bundle e(Bundle args, NavContext context) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(context, "context");
        Context contextB = context.b();
        args.setClassLoader(contextB != null ? contextB.getClassLoader() : null);
        return args;
    }

    public final Bundle f() {
        return this.f48797a.e();
    }

    public NavBackStackEntryState(Bundle state) {
        Intrinsics.checkNotNullParameter(state, "state");
        state.setClassLoader(NavBackStackEntryState.class.getClassLoader());
        this.f48797a = new NavBackStackEntryStateImpl(state);
    }
}
