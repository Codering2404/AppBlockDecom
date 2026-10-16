package cz.mobilesoft.coreblock.view.graph;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.List;
import kotlin.Metadata;
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
public final class GraphConfiguration {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Companion f132742q = new Companion(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f132743r = 8;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final long f132744s = ColorKt.d(4281308927L);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final long f132745t = ColorKt.d(4294913839L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f132746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f132747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f132748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f132749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f132750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f132751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Color f132752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Color f132753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Color f132754i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CustomAverageLabel f132755j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f132756k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f132757l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final GraphOverlay f132758m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f132759n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Dp f132760o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final TextUnit f132761p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GraphConfiguration a() {
            return new GraphConfiguration(false, false, false, false, false, false, null, null, null, null, false, false, null, false, null, null, 65535, null);
        }

        public final GraphConfiguration b() {
            return new GraphConfiguration(false, false, false, false, false, false, null, null, null, null, false, false, null, true, null, null, 57343, null);
        }

        public final long c() {
            return GraphConfiguration.f132744s;
        }

        public final long d() {
            return GraphConfiguration.f132745t;
        }

        public final long e(Composer composer, int i3) {
            if (ComposerKt.M()) {
                ComposerKt.U(-790204902, i3, -1, "cz.mobilesoft.coreblock.view.graph.GraphConfiguration.Companion.<get-emptyBarColor> (GraphConfiguration.kt:132)");
            }
            long jR = Color.r(ComposeColorsKt.j(composer, 0).z(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            return jR;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomAverageLabel {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f132762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Color f132763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f132764c;

        public /* synthetic */ CustomAverageLabel(String str, Color color, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, color, z2);
        }

        public final boolean a() {
            return this.f132764c;
        }

        public final Color b() {
            return this.f132763b;
        }

        public final String c() {
            return this.f132762a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomAverageLabel)) {
                return false;
            }
            CustomAverageLabel customAverageLabel = (CustomAverageLabel) obj;
            return Intrinsics.areEqual(this.f132762a, customAverageLabel.f132762a) && Intrinsics.areEqual(this.f132763b, customAverageLabel.f132763b) && this.f132764c == customAverageLabel.f132764c;
        }

        public int hashCode() {
            int iHashCode = this.f132762a.hashCode() * 31;
            Color color = this.f132763b;
            return ((iHashCode + (color == null ? 0 : Color.z(color.B()))) * 31) + Boolean.hashCode(this.f132764c);
        }

        public String toString() {
            return "CustomAverageLabel(label=" + this.f132762a + ", color=" + this.f132763b + ", alignToEnd=" + this.f132764c + ")";
        }

        private CustomAverageLabel(String label, Color color, boolean z2) {
            Intrinsics.checkNotNullParameter(label, "label");
            this.f132762a = label;
            this.f132763b = color;
            this.f132764c = z2;
        }

        public /* synthetic */ CustomAverageLabel(String str, Color color, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? false : z2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GraphOverlay {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f132765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f132766b;

        public /* synthetic */ GraphOverlay(long j3, List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, list);
        }

        public final long a() {
            return this.f132765a;
        }

        public final List b() {
            return this.f132766b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GraphOverlay)) {
                return false;
            }
            GraphOverlay graphOverlay = (GraphOverlay) obj;
            return Color.t(this.f132765a, graphOverlay.f132765a) && Intrinsics.areEqual(this.f132766b, graphOverlay.f132766b);
        }

        public int hashCode() {
            return (Color.z(this.f132765a) * 31) + this.f132766b.hashCode();
        }

        public String toString() {
            return "GraphOverlay(color=" + Color.A(this.f132765a) + ", intervals=" + this.f132766b + ")";
        }

        private GraphOverlay(long j3, List intervals) {
            Intrinsics.checkNotNullParameter(intervals, "intervals");
            this.f132765a = j3;
            this.f132766b = intervals;
        }
    }

    public /* synthetic */ GraphConfiguration(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Color color, Color color2, Color color3, CustomAverageLabel customAverageLabel, boolean z8, boolean z9, GraphOverlay graphOverlay, boolean z10, Dp dp, TextUnit textUnit, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, z3, z4, z5, z6, z7, color, color2, color3, customAverageLabel, z8, z9, graphOverlay, z10, dp, textUnit);
    }

    public final TextUnit c() {
        return this.f132761p;
    }

    public final CustomAverageLabel d() {
        return this.f132755j;
    }

    public final Color e() {
        return this.f132754i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphConfiguration)) {
            return false;
        }
        GraphConfiguration graphConfiguration = (GraphConfiguration) obj;
        return this.f132746a == graphConfiguration.f132746a && this.f132747b == graphConfiguration.f132747b && this.f132748c == graphConfiguration.f132748c && this.f132749d == graphConfiguration.f132749d && this.f132750e == graphConfiguration.f132750e && this.f132751f == graphConfiguration.f132751f && Intrinsics.areEqual(this.f132752g, graphConfiguration.f132752g) && Intrinsics.areEqual(this.f132753h, graphConfiguration.f132753h) && Intrinsics.areEqual(this.f132754i, graphConfiguration.f132754i) && Intrinsics.areEqual(this.f132755j, graphConfiguration.f132755j) && this.f132756k == graphConfiguration.f132756k && this.f132757l == graphConfiguration.f132757l && Intrinsics.areEqual(this.f132758m, graphConfiguration.f132758m) && this.f132759n == graphConfiguration.f132759n && Intrinsics.areEqual(this.f132760o, graphConfiguration.f132760o) && Intrinsics.areEqual(this.f132761p, graphConfiguration.f132761p);
    }

    public final Color f() {
        return this.f132752g;
    }

    public final Dp g() {
        return this.f132760o;
    }

    public final Color h() {
        return this.f132753h;
    }

    public int hashCode() {
        int iHashCode = ((((((((((Boolean.hashCode(this.f132746a) * 31) + Boolean.hashCode(this.f132747b)) * 31) + Boolean.hashCode(this.f132748c)) * 31) + Boolean.hashCode(this.f132749d)) * 31) + Boolean.hashCode(this.f132750e)) * 31) + Boolean.hashCode(this.f132751f)) * 31;
        Color color = this.f132752g;
        int iZ = (iHashCode + (color == null ? 0 : Color.z(color.B()))) * 31;
        Color color2 = this.f132753h;
        int iZ2 = (iZ + (color2 == null ? 0 : Color.z(color2.B()))) * 31;
        Color color3 = this.f132754i;
        int iZ3 = (iZ2 + (color3 == null ? 0 : Color.z(color3.B()))) * 31;
        CustomAverageLabel customAverageLabel = this.f132755j;
        int iHashCode2 = (((((iZ3 + (customAverageLabel == null ? 0 : customAverageLabel.hashCode())) * 31) + Boolean.hashCode(this.f132756k)) * 31) + Boolean.hashCode(this.f132757l)) * 31;
        GraphOverlay graphOverlay = this.f132758m;
        int iHashCode3 = (((iHashCode2 + (graphOverlay == null ? 0 : graphOverlay.hashCode())) * 31) + Boolean.hashCode(this.f132759n)) * 31;
        Dp dp = this.f132760o;
        int iJ = (iHashCode3 + (dp == null ? 0 : Dp.j(dp.l()))) * 31;
        TextUnit textUnit = this.f132761p;
        return iJ + (textUnit != null ? TextUnit.i(textUnit.m()) : 0);
    }

    public final GraphOverlay i() {
        return this.f132758m;
    }

    public final boolean j() {
        return this.f132750e;
    }

    public final boolean k() {
        return this.f132746a;
    }

    public final boolean l() {
        return this.f132748c;
    }

    public final boolean m() {
        return this.f132756k;
    }

    public final boolean n() {
        return this.f132749d;
    }

    public final boolean o() {
        return this.f132747b;
    }

    public final boolean p() {
        return this.f132759n;
    }

    public final boolean q() {
        return this.f132757l;
    }

    public String toString() {
        return "GraphConfiguration(showBackground=" + this.f132746a + ", showVerticalLabelsAndAxis=" + this.f132747b + ", showHorizontalLabels=" + this.f132748c + ", showScreenTimeOnHorizontalAxis=" + this.f132749d + ", showAverageLine=" + this.f132750e + ", comparisonAverageLine=" + this.f132751f + ", customColor=" + this.f132752g + ", gradientColor=" + this.f132753h + ", customAverageLineColor=" + this.f132754i + ", customAverageLabel=" + this.f132755j + ", showPeak=" + this.f132756k + ", withCurrentTime=" + this.f132757l + ", graphOverlay=" + this.f132758m + ", tinyVerticalLabels=" + this.f132759n + ", customSpaceBetweenBars=" + this.f132760o + ", axisLabelTextSize=" + this.f132761p + ")";
    }

    private GraphConfiguration(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Color color, Color color2, Color color3, CustomAverageLabel customAverageLabel, boolean z8, boolean z9, GraphOverlay graphOverlay, boolean z10, Dp dp, TextUnit textUnit) {
        this.f132746a = z2;
        this.f132747b = z3;
        this.f132748c = z4;
        this.f132749d = z5;
        this.f132750e = z6;
        this.f132751f = z7;
        this.f132752g = color;
        this.f132753h = color2;
        this.f132754i = color3;
        this.f132755j = customAverageLabel;
        this.f132756k = z8;
        this.f132757l = z9;
        this.f132758m = graphOverlay;
        this.f132759n = z10;
        this.f132760o = dp;
        this.f132761p = textUnit;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GraphConfiguration(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Color color, Color color2, Color color3, CustomAverageLabel customAverageLabel, boolean z8, boolean z9, GraphOverlay graphOverlay, boolean z10, Dp dp, TextUnit textUnit, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z11 = (i3 & 1) != 0 ? true : z2;
        boolean z12 = (i3 & 2) != 0 ? true : z3;
        boolean z13 = (i3 & 4) != 0 ? true : z4;
        boolean z14 = (i3 & 8) != 0 ? false : z5;
        boolean z15 = (i3 & 16) == 0 ? z6 : true;
        boolean z16 = (i3 & 32) != 0 ? false : z7;
        Color color4 = (i3 & 64) != 0 ? null : color;
        Color color5 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : color2;
        Color color6 = (i3 & Function.MAX_NARGS) != 0 ? null : color3;
        CustomAverageLabel customAverageLabel2 = (i3 & 512) != 0 ? null : customAverageLabel;
        boolean z17 = (i3 & 1024) != 0 ? false : z8;
        boolean z18 = (i3 & 2048) != 0 ? false : z9;
        GraphOverlay graphOverlay2 = (i3 & 4096) != 0 ? null : graphOverlay;
        boolean z19 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z10;
        this(z11, z12, z13, z14, z15, z16, color4, color5, color6, customAverageLabel2, z17, z18, graphOverlay2, z19, (i3 & 16384) != 0 ? null : dp, (i3 & 32768) != 0 ? null : textUnit, null);
    }
}
