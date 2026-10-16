package androidx.navigation.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import com.google.android.material.navigation.NavigationView;
import java.lang.ref.WeakReference;
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
public final class NavigationUI$setupWithNavController$7 implements NavController.OnDestinationChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f49508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ NavController f49509b;

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public void a(NavController controller, NavDestination destination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(destination, "destination");
        NavigationView navigationView = (NavigationView) this.f49508a.get();
        if (navigationView == null) {
            this.f49509b.W(this);
            return;
        }
        if (destination instanceof FloatingWindow) {
            return;
        }
        Menu menu = navigationView.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        int size = menu.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = menu.getItem(i3);
            item.setChecked(NavigationUI.a(destination, item.getItemId()));
        }
    }
}
