package cz.mobilesoft.coreblock.base.activity;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import cz.mobilesoft.coreblock.util.view.GradientUtils;
import cz.mobilesoft.coreblock.util.view.ViewHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class BaseComposeActivity extends BaseLockableActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f96312d = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f96313b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Color f96314c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(final BaseComposeActivity baseComposeActivity, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-492329619, i3, -1, "cz.mobilesoft.coreblock.base.activity.BaseComposeActivity.onCreate.<anonymous> (BaseComposeActivity.kt:47)");
            }
            ComposeThemesKt.b(null, ComposableLambdaKt.e(-1471599204, true, new Function2() { // from class: cz.mobilesoft.coreblock.base.activity.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseComposeActivity.h0(this.f96326a, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(final BaseComposeActivity baseComposeActivity, Composer composer, int i3) {
        long jB;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1471599204, i3, -1, "cz.mobilesoft.coreblock.base.activity.BaseComposeActivity.onCreate.<anonymous>.<anonymous> (BaseComposeActivity.kt:48)");
            }
            final WindowInsets windowInsetsC = WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6);
            Color colorD0 = baseComposeActivity.d0();
            if (colorD0 == null) {
                composer.a0(-1162589402);
                jB = MaterialTheme.f13091a.a(composer, MaterialTheme.f13092b).c();
                composer.U();
            } else {
                composer.a0(-1162590642);
                composer.U();
                jB = colorD0.B();
            }
            long j3 = jB;
            Modifier.Companion companion = Modifier.b8;
            boolean zF0 = baseComposeActivity.f0();
            boolean Z = composer.Z(windowInsetsC);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.base.activity.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseComposeActivity.i0(windowInsetsC, (Modifier) obj);
                    }
                };
                composer.w(objG);
            }
            ScaffoldKt.a(ComposableExtKt.r(companion, zF0, (Function1) objG), null, null, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, j3, 0L, ComposableLambdaKt.e(1269259994, true, new Function3() { // from class: cz.mobilesoft.coreblock.base.activity.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BaseComposeActivity.j0(this.f96328a, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 0, 12582912, 98302);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier i0(WindowInsets windowInsets, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return WindowInsetsPaddingKt.d(applyIf, windowInsets);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(BaseComposeActivity baseComposeActivity, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1269259994, i3, -1, "cz.mobilesoft.coreblock.base.activity.BaseComposeActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (BaseComposeActivity.kt:52)");
            }
            baseComposeActivity.c0(it, composer, i3 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public abstract void c0(PaddingValues paddingValues, Composer composer, int i3);

    protected Color d0() {
        return this.f96314c;
    }

    protected boolean f0() {
        return this.f96313b;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.b(this, null, null, 3, null);
        String stringExtra = getIntent().getStringExtra("NOTIFICATION_OPENED_EVENT_NAME");
        if (stringExtra != null) {
            AnswersHelper.f128199a.K2(stringExtra);
            getIntent().removeExtra("NOTIFICATION_OPENED_EVENT_NAME");
        }
        if (!ViewHelper.e(this)) {
            GradientUtils.a(this);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        ComponentActivityKt.b(this, null, ComposableLambdaKt.c(-492329619, true, new Function2() { // from class: cz.mobilesoft.coreblock.base.activity.d
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BaseComposeActivity.g0(this.f96325a, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }
}
