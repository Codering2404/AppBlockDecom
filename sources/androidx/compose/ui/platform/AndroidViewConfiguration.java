package androidx.compose.ui.platform;

import android.os.Build;
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
public final class AndroidViewConfiguration implements ViewConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.view.ViewConfiguration f27914a;

    public AndroidViewConfiguration(android.view.ViewConfiguration viewConfiguration) {
        this.f27914a = viewConfiguration;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public long a() {
        return android.view.ViewConfiguration.getDoubleTapTimeout();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public long b() {
        return 40L;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public long c() {
        return android.view.ViewConfiguration.getLongPressTimeout();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public float d() {
        return Build.VERSION.SDK_INT >= 34 ? AndroidViewConfigurationApi34.f27915a.b(this.f27914a) : super.d();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public float f() {
        return this.f27914a.getScaledMaximumFlingVelocity();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public float g() {
        return this.f27914a.getScaledTouchSlop();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public float h() {
        return Build.VERSION.SDK_INT >= 34 ? AndroidViewConfigurationApi34.f27915a.a(this.f27914a) : super.h();
    }
}
