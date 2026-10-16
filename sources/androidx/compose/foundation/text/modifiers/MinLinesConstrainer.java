package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MinLinesConstrainer {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f11000h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f11001i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static MinLinesConstrainer f11002j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutDirection f11003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextStyle f11004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Density f11005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FontFamily.Resolver f11006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextStyle f11007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f11008f = Float.NaN;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f11009g = Float.NaN;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MinLinesConstrainer a(MinLinesConstrainer minLinesConstrainer, LayoutDirection layoutDirection, TextStyle textStyle, Density density, FontFamily.Resolver resolver) {
            if (minLinesConstrainer != null && layoutDirection == minLinesConstrainer.g() && Intrinsics.areEqual(TextStyleKt.d(textStyle, layoutDirection), minLinesConstrainer.f()) && density.getDensity() == minLinesConstrainer.d().getDensity() && resolver == minLinesConstrainer.e()) {
                return minLinesConstrainer;
            }
            MinLinesConstrainer minLinesConstrainer2 = MinLinesConstrainer.f11002j;
            if (minLinesConstrainer2 != null && layoutDirection == minLinesConstrainer2.g() && Intrinsics.areEqual(TextStyleKt.d(textStyle, layoutDirection), minLinesConstrainer2.f()) && density.getDensity() == minLinesConstrainer2.d().getDensity() && resolver == minLinesConstrainer2.e()) {
                return minLinesConstrainer2;
            }
            MinLinesConstrainer minLinesConstrainer3 = new MinLinesConstrainer(layoutDirection, TextStyleKt.d(textStyle, layoutDirection), DensityKt.a(density.getDensity(), density.K1()), resolver);
            MinLinesConstrainer.f11002j = minLinesConstrainer3;
            return minLinesConstrainer3;
        }

        private Companion() {
        }
    }

    public MinLinesConstrainer(LayoutDirection layoutDirection, TextStyle textStyle, Density density, FontFamily.Resolver resolver) {
        this.f11003a = layoutDirection;
        this.f11004b = textStyle;
        this.f11005c = density;
        this.f11006d = resolver;
        this.f11007e = TextStyleKt.d(textStyle, layoutDirection);
    }

    public final long c(long j3, int i3) {
        float f3 = this.f11009g;
        float f4 = this.f11008f;
        if (Float.isNaN(f3) || Float.isNaN(f4)) {
            String str = MinLinesConstrainerKt.f11010a;
            TextStyle textStyle = this.f11007e;
            long jB = ConstraintsKt.b(0, 0, 0, 0, 15, null);
            Density density = this.f11005c;
            FontFamily.Resolver resolver = this.f11006d;
            TextOverflow.Companion companion = TextOverflow.f29661b;
            float height = ParagraphKt.a(str, textStyle, jB, density, resolver, (64 & 32) != 0 ? CollectionsKt.emptyList() : null, (64 & 64) != 0 ? CollectionsKt.emptyList() : null, (64 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Integer.MAX_VALUE : 1, (64 & Function.MAX_NARGS) != 0 ? TextOverflow.f29661b.a() : companion.a()).getHeight();
            float height2 = ParagraphKt.a(MinLinesConstrainerKt.f11011b, this.f11007e, ConstraintsKt.b(0, 0, 0, 0, 15, null), this.f11005c, this.f11006d, (64 & 32) != 0 ? CollectionsKt.emptyList() : null, (64 & 64) != 0 ? CollectionsKt.emptyList() : null, (64 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Integer.MAX_VALUE : 2, (64 & Function.MAX_NARGS) != 0 ? TextOverflow.f29661b.a() : companion.a()).getHeight() - height;
            this.f11009g = height;
            this.f11008f = height2;
            f4 = height2;
            f3 = height;
        }
        return ConstraintsKt.a(Constraints.n(j3), Constraints.l(j3), i3 != 1 ? RangesKt.k(RangesKt.f(Math.round(f3 + (f4 * (i3 - 1))), 0), Constraints.k(j3)) : Constraints.m(j3), Constraints.k(j3));
    }

    public final Density d() {
        return this.f11005c;
    }

    public final FontFamily.Resolver e() {
        return this.f11006d;
    }

    public final TextStyle f() {
        return this.f11004b;
    }

    public final LayoutDirection g() {
        return this.f11003a;
    }
}
