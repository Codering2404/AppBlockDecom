package cz.mobilesoft.coreblock.scene.dashboard.shortcuts.do_not_delete_me;

import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.do_not_delete_me.DoNotDeleteMeActivity;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
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
public final class DoNotDeleteMeActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f101475g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f101476h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f101477f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) DoNotDeleteMeActivity.class);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(DoNotDeleteMeActivity doNotDeleteMeActivity) {
        AnswersHelper.f128199a.E1();
        doNotDeleteMeActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(DoNotDeleteMeActivity doNotDeleteMeActivity) {
        AnswersHelper.f128199a.F1();
        doNotDeleteMeActivity.setResult(-1);
        doNotDeleteMeActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(DoNotDeleteMeActivity doNotDeleteMeActivity) {
        doNotDeleteMeActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(DoNotDeleteMeActivity doNotDeleteMeActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        doNotDeleteMeActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(1728900845);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1728900845, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.shortcuts.do_not_delete_me.DoNotDeleteMeActivity.RootCompose (DoNotDeleteMeActivity.kt:20)");
            }
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: u0.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DoNotDeleteMeActivity.o0(this.f147474a);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
            boolean zI2 = composerK.I(this);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: u0.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DoNotDeleteMeActivity.p0(this.f147475a);
                    }
                };
                composerK.w(objG2);
            }
            Function0 function02 = (Function0) objG2;
            boolean zI3 = composerK.I(this);
            Object objG3 = composerK.G();
            if (zI3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: u0.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DoNotDeleteMeActivity.q0(this.f147476a);
                    }
                };
                composerK.w(objG3);
            }
            DoNotDeleteMeScreenKt.c(function0, function02, (Function0) objG3, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: u0.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DoNotDeleteMeActivity.s0(this.f147477a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f101477f;
    }
}
