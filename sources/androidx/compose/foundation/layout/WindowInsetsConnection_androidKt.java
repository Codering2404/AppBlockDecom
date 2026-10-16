package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class WindowInsetsConnection_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f7174a = ViewConfiguration.getScrollFriction();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final double f7175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final double f7176c;

    static {
        double dLog = Math.log(0.78d) / Math.log(0.9d);
        f7175b = dLog;
        f7176c = dLog - 1.0d;
    }

    public static final NestedScrollConnection d(AndroidWindowInsets androidWindowInsets, int i3, Composer composer, int i4) {
        composer.a0(-1011341039);
        if (ComposerKt.M()) {
            ComposerKt.U(-1011341039, i4, -1, "androidx.compose.foundation.layout.rememberWindowInsetsConnection (WindowInsetsConnection.android.kt:105)");
        }
        if (Build.VERSION.SDK_INT < 30) {
            DoNothingNestedScrollConnection doNothingNestedScrollConnection = DoNothingNestedScrollConnection.f6761a;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return doNothingNestedScrollConnection;
        }
        SideCalculator sideCalculatorA = SideCalculator.f7104a.a(i3, (LayoutDirection) composer.q(CompositionLocalsKt.m()));
        View view = (View) composer.q(AndroidCompositionLocals_androidKt.j());
        Density density = (Density) composer.q(CompositionLocalsKt.f());
        boolean Z = ((((i4 & 14) ^ 6) > 4 && composer.Z(androidWindowInsets)) || (i4 & 6) == 4) | composer.Z(view) | composer.Z(sideCalculatorA) | composer.Z(density);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new WindowInsetsNestedScrollConnection(androidWindowInsets, view, sideCalculatorA, density);
            composer.w(objG);
        }
        final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = (WindowInsetsNestedScrollConnection) objG;
        boolean zI = composer.I(windowInsetsNestedScrollConnection);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.layout.WindowInsetsConnection_androidKt$rememberWindowInsetsConnection$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection2 = windowInsetsNestedScrollConnection;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.layout.WindowInsetsConnection_androidKt$rememberWindowInsetsConnection$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            windowInsetsNestedScrollConnection2.j();
                        }
                    };
                }
            };
            composer.w(objG2);
        }
        EffectsKt.c(windowInsetsNestedScrollConnection, (Function1) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return windowInsetsNestedScrollConnection;
    }
}
