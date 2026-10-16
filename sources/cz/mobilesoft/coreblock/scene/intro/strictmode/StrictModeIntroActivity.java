package cz.mobilesoft.coreblock.scene.intro.strictmode;

import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StrictModeIntroActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f105009i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f105010j = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f105011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f105012g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.h0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return StrictModeIntroActivity.w0(this.f105135a);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f105013h = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.i0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(StrictModeIntroActivity.v0(this.f105144a));
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, Integer num, StrictModeIntroNavigation strictModeIntroNavigation, boolean z2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                num = null;
            }
            if ((i3 & 4) != 0) {
                strictModeIntroNavigation = StrictModeIntroNavigation.Start;
            }
            if ((i3 & 8) != 0) {
                z2 = true;
            }
            return companion.a(context, num, strictModeIntroNavigation, z2);
        }

        public final Intent a(Context context, Integer num, StrictModeIntroNavigation startScreen, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(startScreen, "startScreen");
            Intent intent = new Intent(context, (Class<?>) StrictModeIntroActivity.class);
            intent.putExtra("PROFILE_TYPE_COMBINATIONS", num);
            intent.putExtra("STRICT_MODE_INTRO_START_SCREEN", startScreen);
            intent.putExtra("SHOW_PREMIUM", z2);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(StrictModeIntroActivity strictModeIntroActivity) {
        AnswersHelper.f128199a.H7();
        strictModeIntroActivity.s0();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(StrictModeIntroActivity strictModeIntroActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        strictModeIntroActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void s0() {
        if (t0()) {
            CoroutinesHelperExtKt.e(this, new StrictModeIntroActivity$close$1(this, null));
        } else {
            setResult(-1);
            finish();
        }
    }

    private final boolean t0() {
        return ((Boolean) this.f105013h.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer u0() {
        return (Integer) this.f105012g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v0(StrictModeIntroActivity strictModeIntroActivity) {
        Intent intent = strictModeIntroActivity.getIntent();
        if (intent != null) {
            return intent.getBooleanExtra("SHOW_PREMIUM", true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer w0(StrictModeIntroActivity strictModeIntroActivity) {
        Intent intent = strictModeIntroActivity.getIntent();
        if (intent != null) {
            return Integer.valueOf(intent.getIntExtra("PROFILE_TYPE_COMBINATIONS", 0));
        }
        return null;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(897849962);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(897849962, i4, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroActivity.RootCompose (StrictModeIntroActivity.kt:42)");
            }
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.j0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroActivity.o0(this.f105152a);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Intent intent = getIntent();
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("STRICT_MODE_INTRO_START_SCREEN") : null;
            StrictModeIntroNavigation strictModeIntroNavigation = serializableExtra instanceof StrictModeIntroNavigation ? (StrictModeIntroNavigation) serializableExtra : null;
            if (strictModeIntroNavigation == null) {
                strictModeIntroNavigation = StrictModeIntroNavigation.Start;
            }
            StrictModeIntroScreenKt.B1(function0, strictModeIntroNavigation, composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeIntroActivity.p0(this.f105158a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f105011f;
    }
}
