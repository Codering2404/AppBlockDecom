package cz.mobilesoft.coreblock.scene.strictmode3.followschedules;

import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ScheduleSelectActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f122020f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f122021g = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, StrictModeAccessMethod strictModeAccessMethod, long[] scheduleIds, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scheduleIds, "scheduleIds");
            Intent intent = new Intent(context, (Class<?>) ScheduleSelectActivity.class);
            intent.putExtra("ACCESS_METHOD", strictModeAccessMethod);
            intent.putExtra("PROFILE_IDS", scheduleIds);
            intent.putExtra("IS_ENABLED", z2);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(ScheduleSelectActivity scheduleSelectActivity, long[] scheduleIds, AccessMethodConfiguration.Schedules.SchedulesBlockingMode blockingMode) {
        Intrinsics.checkNotNullParameter(scheduleIds, "scheduleIds");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intent intent = new Intent();
        intent.putExtra("PROFILE_IDS", scheduleIds);
        intent.putExtra("SCHEDULE_BLOCKING_MODE", blockingMode);
        scheduleSelectActivity.setResult(-1, intent);
        scheduleSelectActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(ScheduleSelectActivity scheduleSelectActivity) {
        scheduleSelectActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(ScheduleSelectActivity scheduleSelectActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        scheduleSelectActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-1648314746);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1648314746, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectActivity.RootCompose (ScheduleSelectActivity.kt:30)");
            }
            Serializable serializableExtra = getIntent().getSerializableExtra("ACCESS_METHOD");
            StrictModeAccessMethod strictModeAccessMethod = serializableExtra instanceof StrictModeAccessMethod ? (StrictModeAccessMethod) serializableExtra : null;
            long[] longArrayExtra = getIntent().getLongArrayExtra("PROFILE_IDS");
            if (longArrayExtra == null) {
                longArrayExtra = new long[0];
            }
            long[] jArr = longArrayExtra;
            boolean booleanExtra = getIntent().getBooleanExtra("IS_ENABLED", true);
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.j
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScheduleSelectActivity.n0(this.f122160a, (long[]) obj, (AccessMethodConfiguration.Schedules.SchedulesBlockingMode) obj2);
                    }
                };
                composerK.w(objG);
            }
            Function2 function2 = (Function2) objG;
            boolean zI2 = composerK.I(this);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScheduleSelectActivity.o0(this.f122161a);
                    }
                };
                composerK.w(objG2);
            }
            ScheduleSelectScreenKt.P(strictModeAccessMethod, jArr, booleanExtra, function2, (Function0) objG2, composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSelectActivity.p0(this.f122162a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
