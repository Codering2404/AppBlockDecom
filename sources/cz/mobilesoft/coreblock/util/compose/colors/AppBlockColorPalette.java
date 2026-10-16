package cz.mobilesoft.coreblock.util.compose.colors;

import androidx.compose.material.Colors;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public class AppBlockColorPalette {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f128253a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f128255b = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$iconBackground$2
        public final long c() {
            return ColorKt.d(4281084974L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f128257c = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$secondaryButtonBackground$2
        public final long c() {
            return Color.r(ColorKt.b(787213301), 0.18f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f128259d = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$main$2
        public final long c() {
            return ColorKt.d(4281545523L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f128261e = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$mainSecondary$2
        public final long c() {
            return Color.r(this.f128347a.L(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f128263f = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$mainTertiary$2
        public final long c() {
            return Color.r(this.f128348a.L(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f128265g = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$mainDisabled$2
        public final long c() {
            return Color.r(this.f128344a.L(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f128267h = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$mainLight$2
        public final long c() {
            return Color.r(this.f128346a.L(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f128269i = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$mainExtraLight$2
        public final long c() {
            return Color.r(this.f128345a.L(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f128271j = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$accentGradient$2
        public final long c() {
            return ColorKt.d(4280636363L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f128273k = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$critical$2
        public final long c() {
            return ColorKt.d(4292673598L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f128275l = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$green$2
        public final long c() {
            return ColorKt.d(4281648985L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f128277m = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$purple$2
        public final long c() {
            return ColorKt.d(4288104447L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f128279n = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$orange$2
        public final long c() {
            return ColorKt.d(4294939904L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f128281o = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$streakBoltStart$2
        public final long c() {
            return ColorKt.d(4294948409L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f128283p = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$streakBoltEnd$2
        public final long c() {
            return ColorKt.d(4294931513L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f128285q = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$red$2
        public final long c() {
            return ColorKt.d(4294916912L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f128287r = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$white$2
        public final long c() {
            return ColorKt.d(4294967295L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f128289s = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$infoBoxBorder$2
        public final long c() {
            return Color.r(this.f128335a.L(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f128291t = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$popupBackground$2
        public final long c() {
            return this.f128356a.l0();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f128293u = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$darkOnlyPopupBackground$2
        public final long c() {
            return ColorKt.d(4280361252L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f128295v = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$shimmer$2
        public final long c() {
            return this.f128365a.s();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f128297w = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$scrimColor$2
        public final long c() {
            return Color.r(Color.f25715b.a(), 0.48f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f128299x = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$lockScreenBackground$2
        public final long c() {
            return ColorKt.d(4278258978L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f128300y = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$lockScreenBackgroundSemiLight$2
        public final long c() {
            return ColorKt.d(4278593887L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f128301z = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$lockScreenBackgroundLight$2
        public final long c() {
            return ColorKt.d(4278797469L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy A = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$btnPermission$2
        public final long c() {
            return ColorKt.d(4294111991L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy B = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$categoriesBackground$2
        public final long c() {
            return this.f128310a.q0();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy C = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$tabDivider$2
        public final long c() {
            return ColorKt.b(775699523);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy D = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$ratingYellow$2
        public final long c() {
            return ColorKt.d(4294953984L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy E = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$moodVeryDistracted$2
        public final long c() {
            return ColorKt.d(4293467747L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy F = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$moodSomewhatDistracted$2
        public final long c() {
            return ColorKt.d(4286865335L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy G = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$moodNeutral$2
        public final long c() {
            return this.f128350a.b();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy H = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$moodSomewhatInControl$2
        public final long c() {
            return ColorKt.d(4281511596L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy I = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$moodInControl$2
        public final long c() {
            return this.f128349a.A();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy J = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$graphBarBackground$2
        public final long c() {
            return Color.r(ColorKt.d(4282137667L), 0.18f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy K = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$graphBarProductive$2
        public final long c() {
            return ColorKt.d(4281648985L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy L = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$graphBarDistractive$2
        public final long c() {
            return ColorKt.d(4288104447L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy M = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$graphBarNeutral$2
        public final long c() {
            return ColorKt.d(4281308927L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy N = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$insightsAppTypeButtonBackground$2
        public final long c() {
            return ColorKt.d(4294967295L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy O = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$insightsAppTypeButtonFaceBackground$2
        public final long c() {
            return this.f128337a.z();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy P = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$insightsAverageTextBackground$2
        public final long c() {
            return ColorKt.d(4281084974L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy Q = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$accent$2
        public final long c() {
            return ColorKt.d(4281308927L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy R = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$background$2
        public final long c() {
            return ColorKt.d(4293718524L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy S = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$backgroundAlt$2
        public final long c() {
            return ColorKt.d(4293718524L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy T = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$surface$2
        public final long c() {
            return Color.f25715b.l();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy U = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$overlaySurface$2
        public final long c() {
            return Color.f25715b.l();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy V = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$errorBackground$2
        public final long c() {
            return ColorKt.d(4294959583L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy W = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$accentBackground$2
        public final long c() {
            return ColorKt.d(4292472575L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy X = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$tweaksBackground$2
        public final long c() {
            return ColorKt.d(4292868581L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy Y = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$primaryButton$2
        public final long c() {
            return this.f128358a.b();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy Z = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$secondaryButton$2
        public final long c() {
            return Color.r(ColorKt.d(4282137667L), 0.08f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final Lazy f128254a0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$disabledButton$2
        public final long c() {
            return Color.r(ColorKt.d(4282137667L), 0.08f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final Lazy f128256b0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$elementDark$2
        public final long c() {
            return Color.f25715b.l();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final Lazy f128258c0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$elementDark2$2
        public final long c() {
            return Color.r(ColorKt.d(4293651445L), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final Lazy f128260d0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$elementLight$2
        public final long c() {
            return Color.f25715b.a();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final Lazy f128262e0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$elementLight2$2
        public final long c() {
            return Color.r(ColorKt.d(4282137667L), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final Lazy f128264f0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$elementLight2DarkModeOnly$2
        public final long c() {
            return Color.r(ColorKt.d(4293651445L), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final Lazy f128266g0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$elementLight3DarkModeOnly$2
        public final long c() {
            return Color.r(ColorKt.d(4293651445L), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final Lazy f128268h0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$elementLight3$2
        public final long c() {
            return Color.r(ColorKt.d(4282137667L), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final Lazy f128270i0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$elementLight4$2
        public final long c() {
            return Color.r(ColorKt.d(4282137667L), 0.18f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final Lazy f128272j0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$elementLight5$2
        public final long c() {
            return Color.r(ColorKt.d(4282137667L), 0.08f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final Lazy f128274k0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$elementLight5DarkModeOnly$2
        public final long c() {
            return Color.r(ColorKt.d(4293651445L), 0.08f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final Lazy f128276l0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$premium$2
        public final long c() {
            return ColorKt.d(4294939904L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final Lazy f128278m0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$strictMode$2
        public final long c() {
            return ColorKt.d(4288104447L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final Lazy f128280n0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$lockedMode$2
        public final long c() {
            return ColorKt.d(4291348680L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final Lazy f128282o0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$info$2
        public final long c() {
            return ColorKt.d(4290150656L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final Lazy f128284p0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$warning$2
        public final long c() {
            return ColorKt.d(4292492856L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private final Lazy f128286q0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$error$2
        public final long c() {
            return ColorKt.d(4294916912L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private final Lazy f128288r0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$success$2
        public final long c() {
            return ColorKt.d(4281648985L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private final Lazy f128290s0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$grey400$2
        public final long c() {
            return ColorKt.d(4286940811L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private final Lazy f128292t0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$grey500$2
        public final long c() {
            return ColorKt.d(4285164400L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private final Lazy f128294u0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$blue200$2
        public final long c() {
            return ColorKt.d(4290569215L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private final Lazy f128296v0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette$blue600$2
        public final long c() {
            return ColorKt.d(4279990517L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private final Lazy f128298w0 = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.compose.colors.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AppBlockColorPalette.t0(this.f128415a);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final List t0(AppBlockColorPalette appBlockColorPalette) {
        return CollectionsKt.listOf((Object[]) new Color[]{Color.n(Color.r(appBlockColorPalette.u(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null)), Color.n(Color.r(appBlockColorPalette.u(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null))});
    }

    public long A() {
        return ((Color) this.f128275l.getValue()).B();
    }

    public long B() {
        return ((Color) this.f128292t0.getValue()).B();
    }

    public long C() {
        return ((Color) this.f128255b.getValue()).B();
    }

    public long D() {
        return ((Color) this.f128282o0.getValue()).B();
    }

    public long E() {
        return ((Color) this.N.getValue()).B();
    }

    public long F() {
        return ((Color) this.O.getValue()).B();
    }

    public long G() {
        return ((Color) this.P.getValue()).B();
    }

    public long H() {
        return ((Color) this.f128299x.getValue()).B();
    }

    public long I() {
        return ((Color) this.f128301z.getValue()).B();
    }

    public long J() {
        return ((Color) this.f128300y.getValue()).B();
    }

    public long K() {
        return ((Color) this.f128280n0.getValue()).B();
    }

    public long L() {
        return ((Color) this.f128259d.getValue()).B();
    }

    public long M() {
        return ((Color) this.f128265g.getValue()).B();
    }

    public long N() {
        return ((Color) this.f128267h.getValue()).B();
    }

    public long O() {
        return ((Color) this.f128261e.getValue()).B();
    }

    public long P() {
        return ((Color) this.f128263f.getValue()).B();
    }

    public long Q() {
        return ((Color) this.I.getValue()).B();
    }

    public long R() {
        return ((Color) this.G.getValue()).B();
    }

    public long S() {
        return ((Color) this.F.getValue()).B();
    }

    public long T() {
        return ((Color) this.H.getValue()).B();
    }

    public long U() {
        return ((Color) this.E.getValue()).B();
    }

    public long V() {
        return ((Color) this.f128279n.getValue()).B();
    }

    public long W() {
        return ((Color) this.U.getValue()).B();
    }

    public long X() {
        return ((Color) this.f128291t.getValue()).B();
    }

    public long Y() {
        return ((Color) this.f128276l0.getValue()).B();
    }

    public long Z() {
        return ((Color) this.Y.getValue()).B();
    }

    public long a0() {
        return ((Color) this.f128277m.getValue()).B();
    }

    public long b() {
        return ((Color) this.Q.getValue()).B();
    }

    public long b0() {
        return ((Color) this.D.getValue()).B();
    }

    public long c() {
        return ((Color) this.W.getValue()).B();
    }

    public long c0() {
        return ((Color) this.f128285q.getValue()).B();
    }

    public long d() {
        return ((Color) this.f128271j.getValue()).B();
    }

    public long d0() {
        return ((Color) this.f128297w.getValue()).B();
    }

    public long e() {
        return ((Color) this.R.getValue()).B();
    }

    public long e0() {
        return ((Color) this.Z.getValue()).B();
    }

    public long f() {
        return ((Color) this.S.getValue()).B();
    }

    public long f0() {
        return ((Color) this.f128257c.getValue()).B();
    }

    public long g() {
        return ((Color) this.f128294u0.getValue()).B();
    }

    public long g0() {
        return ((Color) this.f128295v.getValue()).B();
    }

    public long h() {
        return ((Color) this.f128296v0.getValue()).B();
    }

    public long h0() {
        return ((Color) this.f128283p.getValue()).B();
    }

    public long i() {
        return ((Color) this.A.getValue()).B();
    }

    public long i0() {
        return ((Color) this.f128281o.getValue()).B();
    }

    public long j() {
        return ((Color) this.B.getValue()).B();
    }

    public long j0() {
        return ((Color) this.f128278m0.getValue()).B();
    }

    public long k() {
        return ((Color) this.f128273k.getValue()).B();
    }

    public long k0() {
        return ((Color) this.f128288r0.getValue()).B();
    }

    public long l() {
        return ((Color) this.f128293u.getValue()).B();
    }

    public long l0() {
        return ((Color) this.T.getValue()).B();
    }

    public long m() {
        return ((Color) this.f128254a0.getValue()).B();
    }

    public long m0() {
        return ((Color) this.C.getValue()).B();
    }

    public long n() {
        return ((Color) this.f128256b0.getValue()).B();
    }

    public List n0() {
        return (List) this.f128298w0.getValue();
    }

    public long o() {
        return ((Color) this.f128258c0.getValue()).B();
    }

    public long o0() {
        return ((Color) this.X.getValue()).B();
    }

    public long p() {
        return ((Color) this.f128260d0.getValue()).B();
    }

    public long p0() {
        return ((Color) this.f128284p0.getValue()).B();
    }

    public long q() {
        return ((Color) this.f128262e0.getValue()).B();
    }

    public long q0() {
        return ((Color) this.f128287r.getValue()).B();
    }

    public long r() {
        return ((Color) this.f128264f0.getValue()).B();
    }

    public boolean r0() {
        return this.f128253a;
    }

    public long s() {
        return ((Color) this.f128268h0.getValue()).B();
    }

    public final Colors s0() {
        return new Colors(b(), b(), b(), b(), e(), l0(), k(), l0(), l0(), L(), L(), L(), r0(), null);
    }

    public long t() {
        return ((Color) this.f128266g0.getValue()).B();
    }

    public long u() {
        return ((Color) this.f128270i0.getValue()).B();
    }

    public long v() {
        return ((Color) this.f128272j0.getValue()).B();
    }

    public long w() {
        return ((Color) this.f128274k0.getValue()).B();
    }

    public long x() {
        return ((Color) this.f128286q0.getValue()).B();
    }

    public long y() {
        return ((Color) this.V.getValue()).B();
    }

    public long z() {
        return ((Color) this.J.getValue()).B();
    }
}
