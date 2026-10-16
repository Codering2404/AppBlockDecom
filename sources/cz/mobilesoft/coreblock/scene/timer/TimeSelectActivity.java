package cz.mobilesoft.coreblock.scene.timer;

import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.timer.TimeSelectActivity;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timeselector.TimeSelectScreenKt;
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
public final class TimeSelectActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f122957f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f122958g = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, long j3, Long l3, TimePickerConfig timePickerConfig, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) TimeSelectActivity.class);
            intent.putExtra("MILLIS", j3);
            intent.putExtra("EXTENDED_TIME", l3);
            intent.putExtra("TIME_PICKER_CONFIG", timePickerConfig);
            intent.putExtra("SHOW_ENDS_AT", z2);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(TimeSelectActivity timeSelectActivity, long j3) {
        Intent intent = new Intent();
        intent.putExtra("MILLIS", j3);
        timeSelectActivity.setResult(-1, intent);
        timeSelectActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(TimeSelectActivity timeSelectActivity) {
        timeSelectActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(TimeSelectActivity timeSelectActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        timeSelectActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-134005895);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-134005895, i4, -1, "cz.mobilesoft.coreblock.scene.timer.TimeSelectActivity.RootCompose (TimeSelectActivity.kt:34)");
            }
            long longExtra = getIntent().getLongExtra("MILLIS", 0L);
            Long lValueOf = Long.valueOf(getIntent().getLongExtra("EXTENDED_TIME", 0L));
            if (lValueOf.longValue() <= 0) {
                lValueOf = null;
            }
            Long l3 = lValueOf;
            TimePickerConfig timePickerConfigB = (TimePickerConfig) getIntent().getSerializableExtra("TIME_PICKER_CONFIG");
            if (timePickerConfigB == null) {
                timePickerConfigB = TimePickerConfig.f133036h.b();
            }
            boolean booleanExtra = getIntent().getBooleanExtra("SHOW_ENDS_AT", false);
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: c2.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TimeSelectActivity.n0(this.f55400a, ((Long) obj).longValue());
                    }
                };
                composerK.w(objG);
            }
            Function1 function1 = (Function1) objG;
            boolean zI2 = composerK.I(this);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: c2.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TimeSelectActivity.o0(this.f55401a);
                    }
                };
                composerK.w(objG2);
            }
            TimeSelectScreenKt.E(function1, (Function0) objG2, timePickerConfigB, longExtra, l3, booleanExtra, composerK, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: c2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeSelectActivity.p0(this.f55402a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
