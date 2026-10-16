package cz.mobilesoft.coreblock.scene.streaks.banner;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter;
import cz.mobilesoft.coreblock.scene.streaks.StreakWeekDayStatus;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

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
public final class StreakTopBannerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f120614a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120620a;

        static {
            int[] iArr = new int[StreakDailyPresenter.WeekDayStatus.values().length];
            try {
                iArr[StreakDailyPresenter.WeekDayStatus.Obtained.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StreakDailyPresenter.WeekDayStatus.Rest.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StreakDailyPresenter.WeekDayStatus.Inactive.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StreakDailyPresenter.WeekDayStatus.Future.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f120620a = iArr;
        }
    }

    static {
        Duration.Companion companion = Duration.f140631b;
        f120614a = DurationKt.s(5, DurationUnit.f140641f);
    }

    private static final StreakWeekDayStatus A(StreakDailyPresenter.WeekDayStatus weekDayStatus) {
        int i3 = WhenMappings.f120620a[weekDayStatus.ordinal()];
        if (i3 == 1) {
            return StreakWeekDayStatus.Obtained;
        }
        if (i3 == 2) {
            return StreakWeekDayStatus.Rest;
        }
        if (i3 == 3) {
            return StreakWeekDayStatus.Inactive;
        }
        if (i3 == 4) {
            return StreakWeekDayStatus.Future;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(final cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter.Presentation.Banner r17, final kotlin.jvm.functions.Function0 r18, final kotlin.jvm.functions.Function0 r19, androidx.compose.ui.Modifier r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.banner.StreakTopBannerKt.g(cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter$Presentation$Banner, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final StreakDailyPresenter.Presentation.Banner h(MutableState mutableState) {
        return (StreakDailyPresenter.Presentation.Banner) mutableState.getValue();
    }

    private static final void i(MutableState mutableState, StreakDailyPresenter.Presentation.Banner banner) {
        mutableState.setValue(banner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(int i3) {
        return -i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(int i3) {
        return -i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(MutableState mutableState, Function0 function0, Function0 function02, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(1488842127, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.banner.StreakTopBanner.<anonymous> (StreakTopBanner.kt:84)");
        }
        StreakDailyPresenter.Presentation.Banner bannerH = h(mutableState);
        if (bannerH == null) {
            composer.a0(-31434759);
            composer.U();
        } else {
            composer.a0(-31434758);
            n(bannerH, function0, function02, false, composer, 0, 8);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(StreakDailyPresenter.Presentation.Banner banner, Function0 function0, Function0 function02, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        g(banner, function0, function02, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void n(final cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter.Presentation.Banner r70, final kotlin.jvm.functions.Function0 r71, final kotlin.jvm.functions.Function0 r72, boolean r73, androidx.compose.runtime.Composer r74, final int r75, final int r76) {
        /*
            Method dump skipped, instruction units count: 1461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.banner.StreakTopBannerKt.n(cz.mobilesoft.coreblock.scene.streaks.StreakDailyPresenter$Presentation$Banner, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(StreakDailyPresenter.Presentation.Banner banner, Function0 function0, Function0 function02, boolean z2, int i3, int i4, Composer composer, int i5) {
        n(banner, function0, function02, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 p(State state) {
        return (Function0) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float q(MutableFloatState mutableFloatState) {
        return mutableFloatState.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MutableFloatState mutableFloatState, float f3) {
        mutableFloatState.s(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset s(MutableFloatState mutableFloatState, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        return IntOffset.c(IntOffset.f((((long) MathKt.d(q(mutableFloatState))) & 4294967295L) | (((long) 0) << 32)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakDailyPresenter.Presentation.Banner z(boolean z2) {
        StreakDailyPresenter.WeekDayStatus weekDayStatus = StreakDailyPresenter.WeekDayStatus.Obtained;
        return new StreakDailyPresenter.Presentation.Banner(2, z2, CollectionsKt.listOf((Object[]) new StreakDailyPresenter.WeekDayStatus[]{weekDayStatus, weekDayStatus, StreakDailyPresenter.WeekDayStatus.Rest, weekDayStatus, weekDayStatus, StreakDailyPresenter.WeekDayStatus.Inactive, StreakDailyPresenter.WeekDayStatus.Future}));
    }
}
