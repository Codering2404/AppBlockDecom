package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.Navigator;
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
@Navigator.Name("NoOp")
@Metadata
public final class NoOpNavigator extends Navigator<NavDestination> {
    @Override // androidx.navigation.Navigator
    public NavDestination c() {
        return new NavDestination(this);
    }

    @Override // androidx.navigation.Navigator
    public NavDestination f(NavDestination destination, Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return destination;
    }

    @Override // androidx.navigation.Navigator
    public boolean o() {
        return true;
    }
}
