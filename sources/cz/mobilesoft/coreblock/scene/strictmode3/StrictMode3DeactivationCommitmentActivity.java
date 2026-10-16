package cz.mobilesoft.coreblock.scene.strictmode3;

import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.StrictModeDeactivation;
import cz.mobilesoft.coreblock.enums.StrictModeDeactivationTime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StrictMode3DeactivationCommitmentActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f121099g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f121100h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f121101f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, int i3, long j3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) StrictMode3DeactivationCommitmentActivity.class);
            intent.putExtra("STRICT_MODE_DEACTIVATION_TIME", i3);
            intent.putExtra("STRICT_MODE_ACTIVE_SINCE", j3);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(StrictMode3DeactivationCommitmentActivity strictMode3DeactivationCommitmentActivity) {
        strictMode3DeactivationCommitmentActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(StrictMode3DeactivationCommitmentActivity strictMode3DeactivationCommitmentActivity, StrictModeDeactivation deactivation) {
        Intrinsics.checkNotNullParameter(deactivation, "deactivation");
        Intent intent = new Intent();
        intent.putExtra("STRICT_MODE_DEACTIVATION", deactivation);
        Unit unit = Unit.f139807a;
        strictMode3DeactivationCommitmentActivity.setResult(-1, intent);
        strictMode3DeactivationCommitmentActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(StrictMode3DeactivationCommitmentActivity strictMode3DeactivationCommitmentActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        strictMode3DeactivationCommitmentActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(1295261698);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1295261698, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3DeactivationCommitmentActivity.RootCompose (StrictMode3DeactivationCommitmentScreen.kt:74)");
            }
            int intExtra = getIntent().getIntExtra("STRICT_MODE_DEACTIVATION_TIME", (int) StrictModeDeactivationTime.Companion.b().getTimeInMinutes());
            long longExtra = getIntent().getLongExtra("STRICT_MODE_ACTIVE_SINCE", 0L);
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictMode3DeactivationCommitmentActivity.n0(this.f122379a);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
            boolean zI2 = composerK.I(this);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3DeactivationCommitmentActivity.o0(this.f122385a, (StrictModeDeactivation) obj);
                    }
                };
                composerK.w(objG2);
            }
            StrictMode3DeactivationCommitmentScreenKt.h(intExtra, longExtra, function0, (Function1) objG2, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3DeactivationCommitmentActivity.p0(this.f122392a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f121101f;
    }
}
