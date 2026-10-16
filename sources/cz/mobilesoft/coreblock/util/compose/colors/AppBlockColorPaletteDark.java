package cz.mobilesoft.coreblock.util.compose.colors;

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
public final class AppBlockColorPaletteDark extends AppBlockColorPalette {

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private final boolean f128379x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private final Lazy f128380y0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$main$2
        public final long c() {
            return ColorKt.d(4294967295L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private final Lazy f128381z0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$accentGradient$2
        public final long c() {
            return ColorKt.d(4278221567L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy A0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$critical$2
        public final long c() {
            return ColorKt.d(4292885317L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy B0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$popupBackground$2
        public final long c() {
            return ColorKt.d(4280032286L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy C0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$shimmer$2
        public final long c() {
            return this.f128409a.s();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy D0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$btnPermission$2
        public final long c() {
            return ColorKt.d(4281084974L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy E0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$categoriesBackground$2
        public final long c() {
            return ColorKt.d(4280032286L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy F0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$tabDivider$2
        public final long c() {
            return ColorKt.b(787213301);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy G0 = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.compose.colors.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AppBlockColorPaletteDark.v0();
        }
    });
    private final Lazy H0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$graphBarBackground$2
        public final long c() {
            return ColorKt.d(4293651445L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy I0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$insightsAppTypeButtonBackground$2
        public final long c() {
            return ColorKt.d(4280032286L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy J0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$insightsAppTypeButtonFaceBackground$2
        public final long c() {
            return Color.r(this.f128402a.z(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy K0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$insightsAverageTextBackground$2
        public final long c() {
            return ColorKt.d(4293651445L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy L0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$background$2
        public final long c() {
            return Color.f25715b.a();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy M0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$backgroundAlt$2
        public final long c() {
            return ColorKt.d(4280229666L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy N0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$surface$2
        public final long c() {
            return ColorKt.d(4280229666L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy O0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$overlaySurface$2
        public final long c() {
            return ColorKt.d(4281084974L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy P0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$errorBackground$2
        public final long c() {
            return ColorKt.d(4281796099L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy Q0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$accentBackground$2
        public final long c() {
            return ColorKt.d(4279116101L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy R0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$tweaksBackground$2
        public final long c() {
            return ColorKt.d(4278659089L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy S0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$secondaryButton$2
        public final long c() {
            return Color.r(ColorKt.d(4282137667L), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy T0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$disabledButton$2
        public final long c() {
            return Color.r(ColorKt.d(4282137667L), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy U0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$elementDark$2
        public final long c() {
            return Color.f25715b.a();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy V0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$elementDark2$2
        public final long c() {
            return Color.r(ColorKt.d(4282137667L), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy W0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$elementLight$2
        public final long c() {
            return Color.f25715b.l();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy X0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$elementLight2$2
        public final long c() {
            return Color.r(ColorKt.d(4293651445L), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy Y0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$elementLight3$2
        public final long c() {
            return Color.r(ColorKt.d(4293651445L), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });
    private final Lazy Z0 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$elementLight4$2
        public final long c() {
            return Color.r(ColorKt.d(4293651445L), 0.18f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private final Lazy f128375a1 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$elementLight5$2
        public final long c() {
            return Color.r(ColorKt.d(4293651445L), 0.08f, 0.0f, 0.0f, 0.0f, 14, null);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private final Lazy f128376b1 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$info$2
        public final long c() {
            return ColorKt.d(4293904230L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private final Lazy f128377c1 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$lockedMode$2
        public final long c() {
            return ColorKt.d(4284111450L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    private final Lazy f128378d1 = LazyKt.b(new Function0<Color>() { // from class: cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPaletteDark$blue200$2
        public final long c() {
            return ColorKt.d(4279116101L);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.n(c());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final List v0() {
        return CollectionsKt.listOf((Object[]) new Color[]{Color.n(ColorKt.d(4281479730L)), Color.n(ColorKt.b(3289650))});
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long D() {
        return ((Color) this.f128376b1.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long E() {
        return ((Color) this.I0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long F() {
        return ((Color) this.J0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long G() {
        return ((Color) this.K0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long K() {
        return ((Color) this.f128377c1.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long L() {
        return ((Color) this.f128380y0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long W() {
        return ((Color) this.O0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long X() {
        return ((Color) this.B0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long c() {
        return ((Color) this.Q0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long d() {
        return ((Color) this.f128381z0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long e() {
        return ((Color) this.L0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long e0() {
        return ((Color) this.S0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long f() {
        return ((Color) this.M0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long g() {
        return ((Color) this.f128378d1.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long g0() {
        return ((Color) this.C0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long i() {
        return ((Color) this.D0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long j() {
        return ((Color) this.E0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long k() {
        return ((Color) this.A0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long l0() {
        return ((Color) this.N0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long m() {
        return ((Color) this.T0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long m0() {
        return ((Color) this.F0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long n() {
        return ((Color) this.U0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public List n0() {
        return (List) this.G0.getValue();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long o() {
        return ((Color) this.V0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long o0() {
        return ((Color) this.R0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long p() {
        return ((Color) this.W0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long q() {
        return ((Color) this.X0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public boolean r0() {
        return this.f128379x0;
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long s() {
        return ((Color) this.Y0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long u() {
        return ((Color) this.Z0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long v() {
        return ((Color) this.f128375a1.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long y() {
        return ((Color) this.P0.getValue()).B();
    }

    @Override // cz.mobilesoft.coreblock.util.compose.colors.AppBlockColorPalette
    public long z() {
        return ((Color) this.H0.getValue()).B();
    }
}
