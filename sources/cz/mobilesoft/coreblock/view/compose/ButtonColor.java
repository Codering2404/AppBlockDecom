package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class ButtonColor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f130302f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f130303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Color f130304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f130305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Dp f130306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Color f130307e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Accent extends ButtonColor {
        public /* synthetic */ Accent(boolean z2, Color color, boolean z3, Dp dp, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, color, z3, dp);
        }

        @Override // cz.mobilesoft.coreblock.view.compose.ButtonColor
        public long a(Composer composer, int i3) {
            composer.a0(382122006);
            if (ComposerKt.M()) {
                ComposerKt.U(382122006, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.Accent.<get-backgroundColor> (ComposeButtons.kt:206)");
            }
            long jB = ComposeColorsKt.j(composer, 0).b();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jB;
        }

        @Override // cz.mobilesoft.coreblock.view.compose.ButtonColor
        public long f(Composer composer, int i3) {
            composer.a0(-1308950380);
            if (ComposerKt.M()) {
                ComposerKt.U(-1308950380, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.Accent.<get-textColor> (ComposeButtons.kt:210)");
            }
            long jQ0 = ComposeColorsKt.j(composer, 0).q0();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jQ0;
        }

        private Accent(boolean z2, Color color, boolean z3, Dp dp) {
            super(z2, color, z3, dp, null, 16, null);
        }

        public /* synthetic */ Accent(boolean z2, Color color, boolean z3, Dp dp, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? true : z3, (i3 & 8) != 0 ? null : dp, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Custom extends ButtonColor {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Color f130308g;

        public /* synthetic */ Custom(boolean z2, Color color, boolean z3, Color color2, Dp dp, Color color3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, color, z3, color2, dp, color3);
        }

        @Override // cz.mobilesoft.coreblock.view.compose.ButtonColor
        public long a(Composer composer, int i3) {
            long jB;
            composer.a0(1971788541);
            if (ComposerKt.M()) {
                ComposerKt.U(1971788541, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.Custom.<get-backgroundColor> (ComposeButtons.kt:262)");
            }
            Color color = this.f130308g;
            if (color == null) {
                composer.a0(808212164);
                jB = ComposeColorsKt.j(composer, 0).l0();
                composer.U();
            } else {
                composer.a0(808211420);
                composer.U();
                jB = color.B();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jB;
        }

        private Custom(boolean z2, Color color, boolean z3, Color color2, Dp dp, Color color3) {
            super(z2, color, z3, dp, color3, null);
            this.f130308g = color2;
        }

        public /* synthetic */ Custom(boolean z2, Color color, boolean z3, Color color2, Dp dp, Color color3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? null : color, (i3 & 4) == 0 ? z3 : true, (i3 & 8) != 0 ? null : color2, (i3 & 16) != 0 ? null : dp, (i3 & 32) == 0 ? color3 : null, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Disabled extends ButtonColor {
        public /* synthetic */ Disabled(boolean z2, Color color, boolean z3, Dp dp, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, color, z3, dp);
        }

        @Override // cz.mobilesoft.coreblock.view.compose.ButtonColor
        public long a(Composer composer, int i3) {
            composer.a0(57375240);
            if (ComposerKt.M()) {
                ComposerKt.U(57375240, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.Disabled.<get-backgroundColor> (ComposeButtons.kt:329)");
            }
            long jU = ComposeColorsKt.j(composer, 0).u();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jU;
        }

        @Override // cz.mobilesoft.coreblock.view.compose.ButtonColor
        public long f(Composer composer, int i3) {
            composer.a0(-1565549818);
            if (ComposerKt.M()) {
                ComposerKt.U(-1565549818, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.Disabled.<get-textColor> (ComposeButtons.kt:333)");
            }
            long jS = ComposeColorsKt.j(composer, 0).s();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jS;
        }

        private Disabled(boolean z2, Color color, boolean z3, Dp dp) {
            super(z2, color, z3, dp, null, 16, null);
        }

        public /* synthetic */ Disabled(boolean z2, Color color, boolean z3, Dp dp, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? true : z3, (i3 & 8) != 0 ? null : dp, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ExtraLight extends ButtonColor {
        public /* synthetic */ ExtraLight(boolean z2, Color color, boolean z3, Dp dp, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, color, z3, dp);
        }

        @Override // cz.mobilesoft.coreblock.view.compose.ButtonColor
        public long a(Composer composer, int i3) {
            composer.a0(2066090162);
            if (ComposerKt.M()) {
                ComposerKt.U(2066090162, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.ExtraLight.<get-backgroundColor> (ComposeButtons.kt:308)");
            }
            long jV = ComposeColorsKt.j(composer, 0).v();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jV;
        }

        @Override // cz.mobilesoft.coreblock.view.compose.ButtonColor
        public long f(Composer composer, int i3) {
            composer.a0(1508237872);
            if (ComposerKt.M()) {
                ComposerKt.U(1508237872, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.ExtraLight.<get-textColor> (ComposeButtons.kt:312)");
            }
            long jP = ComposeColorsKt.j(composer, 0).p();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jP;
        }

        private ExtraLight(boolean z2, Color color, boolean z3, Dp dp) {
            super(z2, color, z3, dp, null, 16, null);
        }

        public /* synthetic */ ExtraLight(boolean z2, Color color, boolean z3, Dp dp, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? true : z3, (i3 & 8) != 0 ? null : dp, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Light extends ButtonColor {
        public /* synthetic */ Light(boolean z2, Color color, boolean z3, Dp dp, Color color2, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, color, z3, dp, color2);
        }

        @Override // cz.mobilesoft.coreblock.view.compose.ButtonColor
        public long a(Composer composer, int i3) {
            composer.a0(1589365448);
            if (ComposerKt.M()) {
                ComposerKt.U(1589365448, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.Light.<get-backgroundColor> (ComposeButtons.kt:293)");
            }
            long jI = ComposeColorsKt.j(composer, 0).i();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jI;
        }

        private Light(boolean z2, Color color, boolean z3, Dp dp, Color color2) {
            super(z2, color, z3, dp, color2, null);
        }

        public /* synthetic */ Light(boolean z2, Color color, boolean z3, Dp dp, Color color2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? true : z3, (i3 & 8) != 0 ? null : dp, (i3 & 16) != 0 ? null : color2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Premium extends ButtonColor {
        public /* synthetic */ Premium(boolean z2, Color color, boolean z3, Dp dp, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, color, z3, dp);
        }

        @Override // cz.mobilesoft.coreblock.view.compose.ButtonColor
        public long a(Composer composer, int i3) {
            composer.a0(-1336557303);
            if (ComposerKt.M()) {
                ComposerKt.U(-1336557303, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.Premium.<get-backgroundColor> (ComposeButtons.kt:225)");
            }
            long jY = ComposeColorsKt.j(composer, 0).Y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jY;
        }

        @Override // cz.mobilesoft.coreblock.view.compose.ButtonColor
        public long f(Composer composer, int i3) {
            composer.a0(2074773579);
            if (ComposerKt.M()) {
                ComposerKt.U(2074773579, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.Premium.<get-textColor> (ComposeButtons.kt:229)");
            }
            long jQ0 = ComposeColorsKt.j(composer, 0).q0();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jQ0;
        }

        private Premium(boolean z2, Color color, boolean z3, Dp dp) {
            super(z2, color, z3, dp, null, 16, null);
        }

        public /* synthetic */ Premium(boolean z2, Color color, boolean z3, Dp dp, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? true : z3, (i3 & 8) != 0 ? null : dp, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Surface extends ButtonColor {
        public /* synthetic */ Surface(boolean z2, Color color, boolean z3, Dp dp, Color color2, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, color, z3, dp, color2);
        }

        @Override // cz.mobilesoft.coreblock.view.compose.ButtonColor
        public long a(Composer composer, int i3) {
            composer.a0(1018856927);
            if (ComposerKt.M()) {
                ComposerKt.U(1018856927, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.Surface.<get-backgroundColor> (ComposeButtons.kt:245)");
            }
            long jL0 = ComposeColorsKt.j(composer, 0).l0();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jL0;
        }

        private Surface(boolean z2, Color color, boolean z3, Dp dp, Color color2) {
            super(z2, color, z3, dp, color2, null);
        }

        public /* synthetic */ Surface(boolean z2, Color color, boolean z3, Dp dp, Color color2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? true : z3, (i3 & 8) != 0 ? null : dp, (i3 & 16) != 0 ? null : color2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SurfaceContrast extends ButtonColor {
        public /* synthetic */ SurfaceContrast(boolean z2, Color color, boolean z3, Dp dp, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, color, z3, dp);
        }

        @Override // cz.mobilesoft.coreblock.view.compose.ButtonColor
        public long a(Composer composer, int i3) {
            composer.a0(1691916417);
            if (ComposerKt.M()) {
                ComposerKt.U(1691916417, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.SurfaceContrast.<get-backgroundColor> (ComposeButtons.kt:277)");
            }
            long jL0 = ComposeColorsKt.j(composer, 0).l0();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jL0;
        }

        private SurfaceContrast(boolean z2, Color color, boolean z3, Dp dp) {
            super(z2, color, z3, dp, null, 16, null);
        }

        public /* synthetic */ SurfaceContrast(boolean z2, Color color, boolean z3, Dp dp, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? true : z3, (i3 & 8) != 0 ? null : dp, null);
        }
    }

    public /* synthetic */ ButtonColor(boolean z2, Color color, boolean z3, Dp dp, Color color2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, color, z3, dp, color2);
    }

    public abstract long a(Composer composer, int i3);

    public final Color b() {
        return this.f130304b;
    }

    public final Dp c() {
        return this.f130306d;
    }

    public final boolean d() {
        return this.f130305c;
    }

    public final boolean e() {
        return this.f130303a;
    }

    public long f(Composer composer, int i3) {
        long jB;
        composer.a0(-519877704);
        if (ComposerKt.M()) {
            ComposerKt.U(-519877704, i3, -1, "cz.mobilesoft.coreblock.view.compose.ButtonColor.<get-textColor> (ComposeButtons.kt:192)");
        }
        Color color = this.f130307e;
        if (color == null) {
            composer.a0(-1386265692);
            jB = ComposeColorsKt.j(composer, 0).p();
            composer.U();
        } else {
            composer.a0(-1386266281);
            composer.U();
            jB = color.B();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return jB;
    }

    private ButtonColor(boolean z2, Color color, boolean z3, Dp dp, Color color2) {
        this.f130303a = z2;
        this.f130304b = color;
        this.f130305c = z3;
        this.f130306d = dp;
        this.f130307e = color2;
    }

    public /* synthetic */ ButtonColor(boolean z2, Color color, boolean z3, Dp dp, Color color2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2, color, z3, dp, (i3 & 16) != 0 ? null : color2, null);
    }
}
