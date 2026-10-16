package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ActionBarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AppCompatActivity f49495f;

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    protected void c(Drawable drawable, int i3) {
        ActionBar supportActionBar = this.f49495f.getSupportActionBar();
        if (supportActionBar == null) {
            throw new IllegalStateException(("Activity " + this.f49495f + " does not have an ActionBar set via setSupportActionBar()").toString());
        }
        supportActionBar.t(drawable != null);
        ActionBarDrawerToggle.Delegate drawerToggleDelegate = this.f49495f.getDrawerToggleDelegate();
        if (drawerToggleDelegate != null) {
            drawerToggleDelegate.b(drawable, i3);
            return;
        }
        throw new IllegalStateException(("Activity " + this.f49495f + " does not have a DrawerToggleDelegate set").toString());
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    protected void d(CharSequence charSequence) {
        ActionBar supportActionBar = this.f49495f.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.A(charSequence);
            return;
        }
        throw new IllegalStateException(("Activity " + this.f49495f + " does not have an ActionBar set via setSupportActionBar()").toString());
    }
}
