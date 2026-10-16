package cz.mobilesoft.coreblock.view.timepicker.config;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
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
public final class TimePickerConfiguration {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Companion f133137r = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f133138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f133139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Shape f133140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f133141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f133142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f133143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f133144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f133145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f133146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Shape f133147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f133148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f133149l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f133150m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final TextStyle f133151n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final TextStyle f133152o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final FontWeight f133153p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final FontWeight f133154q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TimePickerConfiguration a(Composer composer, int i3) {
            if (ComposerKt.M()) {
                ComposerKt.U(901504709, i3, -1, "cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration.Companion.getDefault (TimePickerConfiguration.kt:45)");
            }
            long jX = ComposeColorsKt.j(composer, 0).X();
            float f3 = 16;
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(Dp.g(f3));
            float fG = Dp.g(f3);
            float fG2 = Dp.g(f3);
            float fG3 = Dp.g(f3);
            float fG4 = Dp.g(200);
            float fG5 = Dp.g(30);
            long jV = ComposeColorsKt.j(composer, 0).v();
            RoundedCornerShape roundedCornerShapeD2 = RoundedCornerShapeKt.d(Dp.g(8));
            long jL = ComposeColorsKt.j(composer, 0).L();
            long jP = ComposeColorsKt.j(composer, 0).p();
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i4 = MaterialTheme.f13092b;
            TextStyle textStyleG = materialTheme.c(composer, i4).g();
            TextStyle textStyleH = materialTheme.c(composer, i4).h();
            FontWeight.Companion companion = FontWeight.f29233b;
            int i5 = 7;
            TimePickerConfiguration timePickerConfiguration = new TimePickerConfiguration(i5, jX, roundedCornerShapeD, fG, fG2, fG3, fG4, fG5, jV, roundedCornerShapeD2, jL, jP, 1.0f, textStyleG, textStyleH, companion.b(), companion.g(), null);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            return timePickerConfiguration;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TimePickerConfiguration(int i3, long j3, Shape shape, float f3, float f4, float f5, float f6, float f7, long j4, Shape shape2, long j5, long j6, float f8, TextStyle textStyle, TextStyle textStyle2, FontWeight fontWeight, FontWeight fontWeight2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, j3, shape, f3, f4, f5, f6, f7, j4, shape2, j5, j6, f8, textStyle, textStyle2, fontWeight, fontWeight2);
    }

    public static /* synthetic */ TimePickerConfiguration b(TimePickerConfiguration timePickerConfiguration, int i3, long j3, Shape shape, float f3, float f4, float f5, float f6, float f7, long j4, Shape shape2, long j5, long j6, float f8, TextStyle textStyle, TextStyle textStyle2, FontWeight fontWeight, FontWeight fontWeight2, int i4, Object obj) {
        FontWeight fontWeight3;
        FontWeight fontWeight4;
        int i5 = (i4 & 1) != 0 ? timePickerConfiguration.f133138a : i3;
        long j7 = (i4 & 2) != 0 ? timePickerConfiguration.f133139b : j3;
        Shape shape3 = (i4 & 4) != 0 ? timePickerConfiguration.f133140c : shape;
        float f9 = (i4 & 8) != 0 ? timePickerConfiguration.f133141d : f3;
        float f10 = (i4 & 16) != 0 ? timePickerConfiguration.f133142e : f4;
        float f11 = (i4 & 32) != 0 ? timePickerConfiguration.f133143f : f5;
        float f12 = (i4 & 64) != 0 ? timePickerConfiguration.f133144g : f6;
        float f13 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? timePickerConfiguration.f133145h : f7;
        long j8 = (i4 & Function.MAX_NARGS) != 0 ? timePickerConfiguration.f133146i : j4;
        Shape shape4 = (i4 & 512) != 0 ? timePickerConfiguration.f133147j : shape2;
        long j9 = (i4 & 1024) != 0 ? timePickerConfiguration.f133148k : j5;
        int i6 = i5;
        long j10 = j7;
        long j11 = (i4 & 2048) != 0 ? timePickerConfiguration.f133149l : j6;
        float f14 = (i4 & 4096) != 0 ? timePickerConfiguration.f133150m : f8;
        long j12 = j11;
        TextStyle textStyle3 = (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? timePickerConfiguration.f133151n : textStyle;
        TextStyle textStyle4 = (i4 & 16384) != 0 ? timePickerConfiguration.f133152o : textStyle2;
        FontWeight fontWeight5 = (i4 & 32768) != 0 ? timePickerConfiguration.f133153p : fontWeight;
        if ((i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0) {
            fontWeight4 = fontWeight5;
            fontWeight3 = timePickerConfiguration.f133154q;
        } else {
            fontWeight3 = fontWeight2;
            fontWeight4 = fontWeight5;
        }
        return timePickerConfiguration.a(i6, j10, shape3, f9, f10, f11, f12, f13, j8, shape4, j9, j12, f14, textStyle3, textStyle4, fontWeight4, fontWeight3);
    }

    public final TimePickerConfiguration a(int i3, long j3, Shape contentShape, float f3, float f4, float f5, float f6, float f7, long j4, Shape selectedAreaShape, long j5, long j6, float f8, TextStyle textStyle, TextStyle selectedTextTextStyle, FontWeight fontWeightSelected, FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(contentShape, "contentShape");
        Intrinsics.checkNotNullParameter(selectedAreaShape, "selectedAreaShape");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(selectedTextTextStyle, "selectedTextTextStyle");
        Intrinsics.checkNotNullParameter(fontWeightSelected, "fontWeightSelected");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return new TimePickerConfiguration(i3, j3, contentShape, f3, f4, f5, f6, f7, j4, selectedAreaShape, j5, j6, f8, textStyle, selectedTextTextStyle, fontWeightSelected, fontWeight, null);
    }

    public final float c() {
        return this.f133143f;
    }

    public final long d() {
        return this.f133139b;
    }

    public final float e() {
        return this.f133141d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimePickerConfiguration)) {
            return false;
        }
        TimePickerConfiguration timePickerConfiguration = (TimePickerConfiguration) obj;
        return this.f133138a == timePickerConfiguration.f133138a && Color.t(this.f133139b, timePickerConfiguration.f133139b) && Intrinsics.areEqual(this.f133140c, timePickerConfiguration.f133140c) && Dp.i(this.f133141d, timePickerConfiguration.f133141d) && Dp.i(this.f133142e, timePickerConfiguration.f133142e) && Dp.i(this.f133143f, timePickerConfiguration.f133143f) && Dp.i(this.f133144g, timePickerConfiguration.f133144g) && Dp.i(this.f133145h, timePickerConfiguration.f133145h) && Color.t(this.f133146i, timePickerConfiguration.f133146i) && Intrinsics.areEqual(this.f133147j, timePickerConfiguration.f133147j) && Color.t(this.f133148k, timePickerConfiguration.f133148k) && Color.t(this.f133149l, timePickerConfiguration.f133149l) && Float.compare(this.f133150m, timePickerConfiguration.f133150m) == 0 && Intrinsics.areEqual(this.f133151n, timePickerConfiguration.f133151n) && Intrinsics.areEqual(this.f133152o, timePickerConfiguration.f133152o) && Intrinsics.areEqual(this.f133153p, timePickerConfiguration.f133153p) && Intrinsics.areEqual(this.f133154q, timePickerConfiguration.f133154q);
    }

    public final Shape f() {
        return this.f133140c;
    }

    public final float g() {
        return this.f133142e;
    }

    public final FontWeight h() {
        return this.f133154q;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((Integer.hashCode(this.f133138a) * 31) + Color.z(this.f133139b)) * 31) + this.f133140c.hashCode()) * 31) + Dp.j(this.f133141d)) * 31) + Dp.j(this.f133142e)) * 31) + Dp.j(this.f133143f)) * 31) + Dp.j(this.f133144g)) * 31) + Dp.j(this.f133145h)) * 31) + Color.z(this.f133146i)) * 31) + this.f133147j.hashCode()) * 31) + Color.z(this.f133148k)) * 31) + Color.z(this.f133149l)) * 31) + Float.hashCode(this.f133150m)) * 31) + this.f133151n.hashCode()) * 31) + this.f133152o.hashCode()) * 31) + this.f133153p.hashCode()) * 31) + this.f133154q.hashCode();
    }

    public final FontWeight i() {
        return this.f133153p;
    }

    public final int j() {
        return this.f133138a;
    }

    public final float k() {
        return this.f133144g;
    }

    public final long l() {
        return this.f133146i;
    }

    public final float m() {
        return this.f133145h;
    }

    public final Shape n() {
        return this.f133147j;
    }

    public final float o() {
        return this.f133150m;
    }

    public final TextStyle p() {
        return this.f133152o;
    }

    public final long q() {
        return this.f133149l;
    }

    public final long r() {
        return this.f133148k;
    }

    public final TextStyle s() {
        return this.f133151n;
    }

    public String toString() {
        return "TimePickerConfiguration(numberOfTimeRowsDisplayed=" + this.f133138a + ", contentBackgroundColor=" + Color.A(this.f133139b) + ", contentShape=" + this.f133140c + ", contentHorizontalPadding=" + Dp.k(this.f133141d) + ", contentVerticalPadding=" + Dp.k(this.f133142e) + ", columnsHorizontalPadding=" + Dp.k(this.f133143f) + ", pickerHeight=" + Dp.k(this.f133144g) + ", selectedAreaHeight=" + Dp.k(this.f133145h) + ", selectedAreaBgColor=" + Color.A(this.f133146i) + ", selectedAreaShape=" + this.f133147j + ", textColorSelected=" + Color.A(this.f133148k) + ", textColor=" + Color.A(this.f133149l) + ", selectedScaleFactor=" + this.f133150m + ", textStyle=" + this.f133151n + ", selectedTextTextStyle=" + this.f133152o + ", fontWeightSelected=" + this.f133153p + ", fontWeight=" + this.f133154q + ")";
    }

    private TimePickerConfiguration(int i3, long j3, Shape contentShape, float f3, float f4, float f5, float f6, float f7, long j4, Shape selectedAreaShape, long j5, long j6, float f8, TextStyle textStyle, TextStyle selectedTextTextStyle, FontWeight fontWeightSelected, FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(contentShape, "contentShape");
        Intrinsics.checkNotNullParameter(selectedAreaShape, "selectedAreaShape");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(selectedTextTextStyle, "selectedTextTextStyle");
        Intrinsics.checkNotNullParameter(fontWeightSelected, "fontWeightSelected");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        this.f133138a = i3;
        this.f133139b = j3;
        this.f133140c = contentShape;
        this.f133141d = f3;
        this.f133142e = f4;
        this.f133143f = f5;
        this.f133144g = f6;
        this.f133145h = f7;
        this.f133146i = j4;
        this.f133147j = selectedAreaShape;
        this.f133148k = j5;
        this.f133149l = j6;
        this.f133150m = f8;
        this.f133151n = textStyle;
        this.f133152o = selectedTextTextStyle;
        this.f133153p = fontWeightSelected;
        this.f133154q = fontWeight;
    }
}
