package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
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
public abstract class ButtonType {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Big extends ButtonType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImageVector f130309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Color f130310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f130311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f130312d;

        public /* synthetic */ Big(ImageVector imageVector, Color color, String str, float f3, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageVector, color, str, f3);
        }

        public final float a() {
            return this.f130312d;
        }

        public final Color b() {
            return this.f130310b;
        }

        public final ImageVector c() {
            return this.f130309a;
        }

        public final String d() {
            return this.f130311c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Big)) {
                return false;
            }
            Big big = (Big) obj;
            return Intrinsics.areEqual(this.f130309a, big.f130309a) && Intrinsics.areEqual(this.f130310b, big.f130310b) && Intrinsics.areEqual(this.f130311c, big.f130311c) && Dp.i(this.f130312d, big.f130312d);
        }

        public int hashCode() {
            ImageVector imageVector = this.f130309a;
            int iHashCode = (imageVector == null ? 0 : imageVector.hashCode()) * 31;
            Color color = this.f130310b;
            return ((((iHashCode + (color != null ? Color.z(color.B()) : 0)) * 31) + this.f130311c.hashCode()) * 31) + Dp.j(this.f130312d);
        }

        public String toString() {
            return "Big(imageVector=" + this.f130309a + ", iconTint=" + this.f130310b + ", text=" + this.f130311c + ", height=" + Dp.k(this.f130312d) + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Big(ImageVector imageVector, Color color, String text, float f3) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f130309a = imageVector;
            this.f130310b = color;
            this.f130311c = text;
            this.f130312d = f3;
        }

        public /* synthetic */ Big(ImageVector imageVector, Color color, String str, float f3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : imageVector, (i3 & 2) != 0 ? null : color, str, (i3 & 8) != 0 ? Dp.g(56) : f3, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BigRound extends ButtonType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImageVector f130313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Color f130314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f130315c;

        public /* synthetic */ BigRound(ImageVector imageVector, Color color, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageVector, color, str);
        }

        public final Color a() {
            return this.f130314b;
        }

        public final ImageVector b() {
            return this.f130313a;
        }

        public final String c() {
            return this.f130315c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BigRound)) {
                return false;
            }
            BigRound bigRound = (BigRound) obj;
            return Intrinsics.areEqual(this.f130313a, bigRound.f130313a) && Intrinsics.areEqual(this.f130314b, bigRound.f130314b) && Intrinsics.areEqual(this.f130315c, bigRound.f130315c);
        }

        public int hashCode() {
            ImageVector imageVector = this.f130313a;
            int iHashCode = (imageVector == null ? 0 : imageVector.hashCode()) * 31;
            Color color = this.f130314b;
            int iZ = (iHashCode + (color == null ? 0 : Color.z(color.B()))) * 31;
            String str = this.f130315c;
            return iZ + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "BigRound(imageVector=" + this.f130313a + ", iconTint=" + this.f130314b + ", text=" + this.f130315c + ")";
        }

        private BigRound(ImageVector imageVector, Color color, String str) {
            super(null);
            this.f130313a = imageVector;
            this.f130314b = color;
            this.f130315c = str;
        }

        public /* synthetic */ BigRound(ImageVector imageVector, Color color, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : imageVector, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? null : str, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EmptyWrapperBig extends ButtonType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PaddingValues f130316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function3 f130317b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmptyWrapperBig(PaddingValues padding, Function3 content) {
            super(null);
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(content, "content");
            this.f130316a = padding;
            this.f130317b = content;
        }

        public final Function3 a() {
            return this.f130317b;
        }

        public final PaddingValues b() {
            return this.f130316a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EmptyWrapperBig)) {
                return false;
            }
            EmptyWrapperBig emptyWrapperBig = (EmptyWrapperBig) obj;
            return Intrinsics.areEqual(this.f130316a, emptyWrapperBig.f130316a) && Intrinsics.areEqual(this.f130317b, emptyWrapperBig.f130317b);
        }

        public int hashCode() {
            return (this.f130316a.hashCode() * 31) + this.f130317b.hashCode();
        }

        public String toString() {
            return "EmptyWrapperBig(padding=" + this.f130316a + ", content=" + this.f130317b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EmptyWrapperSmall extends ButtonType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PaddingValues f130318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function3 f130319b;

        public final Function3 a() {
            return this.f130319b;
        }

        public final PaddingValues b() {
            return this.f130318a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EmptyWrapperSmall)) {
                return false;
            }
            EmptyWrapperSmall emptyWrapperSmall = (EmptyWrapperSmall) obj;
            return Intrinsics.areEqual(this.f130318a, emptyWrapperSmall.f130318a) && Intrinsics.areEqual(this.f130319b, emptyWrapperSmall.f130319b);
        }

        public int hashCode() {
            return (this.f130318a.hashCode() * 31) + this.f130319b.hashCode();
        }

        public String toString() {
            return "EmptyWrapperSmall(padding=" + this.f130318a + ", content=" + this.f130319b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MediumRound extends ButtonType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImageVector f130320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Color f130321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f130322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Dp f130323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f130324e;

        public /* synthetic */ MediumRound(ImageVector imageVector, Color color, String str, Dp dp, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageVector, color, str, dp, z2);
        }

        public final Dp a() {
            return this.f130323d;
        }

        public final Color b() {
            return this.f130321b;
        }

        public final ImageVector c() {
            return this.f130320a;
        }

        public final boolean d() {
            return this.f130324e;
        }

        public final String e() {
            return this.f130322c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediumRound)) {
                return false;
            }
            MediumRound mediumRound = (MediumRound) obj;
            return Intrinsics.areEqual(this.f130320a, mediumRound.f130320a) && Intrinsics.areEqual(this.f130321b, mediumRound.f130321b) && Intrinsics.areEqual(this.f130322c, mediumRound.f130322c) && Intrinsics.areEqual(this.f130323d, mediumRound.f130323d) && this.f130324e == mediumRound.f130324e;
        }

        public int hashCode() {
            ImageVector imageVector = this.f130320a;
            int iHashCode = (imageVector == null ? 0 : imageVector.hashCode()) * 31;
            Color color = this.f130321b;
            int iZ = (iHashCode + (color == null ? 0 : Color.z(color.B()))) * 31;
            String str = this.f130322c;
            int iHashCode2 = (iZ + (str == null ? 0 : str.hashCode())) * 31;
            Dp dp = this.f130323d;
            return ((iHashCode2 + (dp != null ? Dp.j(dp.l()) : 0)) * 31) + Boolean.hashCode(this.f130324e);
        }

        private MediumRound(ImageVector imageVector, Color color, String str, Dp dp, boolean z2) {
            super(null);
            this.f130320a = imageVector;
            this.f130321b = color;
            this.f130322c = str;
            this.f130323d = dp;
            this.f130324e = z2;
        }

        public String toString() {
            return "MediumRound(imageVector=" + this.f130320a + ", iconTint=" + this.f130321b + ", text=" + this.f130322c + ", horizontalPadding=" + this.f130323d + qRMDmh.pfMiXAU + this.f130324e + ")";
        }

        public /* synthetic */ MediumRound(ImageVector imageVector, Color color, String str, Dp dp, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : imageVector, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : dp, (i3 & 16) != 0 ? false : z2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigationButton extends ButtonType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f130325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ImageVector f130326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Color f130327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f130328d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f130329e;

        public final Color a() {
            return this.f130327c;
        }

        public final boolean b() {
            return this.f130329e;
        }

        public final boolean c() {
            return this.f130328d;
        }

        public final ImageVector d() {
            return this.f130326b;
        }

        public final String e() {
            return this.f130325a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NavigationButton)) {
                return false;
            }
            NavigationButton navigationButton = (NavigationButton) obj;
            return Intrinsics.areEqual(this.f130325a, navigationButton.f130325a) && Intrinsics.areEqual(this.f130326b, navigationButton.f130326b) && Intrinsics.areEqual(this.f130327c, navigationButton.f130327c) && this.f130328d == navigationButton.f130328d && this.f130329e == navigationButton.f130329e;
        }

        public int hashCode() {
            int iHashCode = this.f130325a.hashCode() * 31;
            ImageVector imageVector = this.f130326b;
            int iHashCode2 = (iHashCode + (imageVector == null ? 0 : imageVector.hashCode())) * 31;
            Color color = this.f130327c;
            return ((((iHashCode2 + (color != null ? Color.z(color.B()) : 0)) * 31) + Boolean.hashCode(this.f130328d)) * 31) + Boolean.hashCode(this.f130329e);
        }

        public String toString() {
            return "NavigationButton(text=" + this.f130325a + ", startImageVector=" + this.f130326b + ", customStartIconAndTextColor=" + this.f130327c + ", showForwardChevron=" + this.f130328d + ", showBackChevron=" + this.f130329e + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Small extends ButtonType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImageVector f130333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Color f130334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f130335c;

        public final Color a() {
            return this.f130334b;
        }

        public final ImageVector b() {
            return this.f130333a;
        }

        public final String c() {
            return this.f130335c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Small)) {
                return false;
            }
            Small small = (Small) obj;
            return Intrinsics.areEqual(this.f130333a, small.f130333a) && Intrinsics.areEqual(this.f130334b, small.f130334b) && Intrinsics.areEqual(this.f130335c, small.f130335c);
        }

        public int hashCode() {
            ImageVector imageVector = this.f130333a;
            int iHashCode = (imageVector == null ? 0 : imageVector.hashCode()) * 31;
            Color color = this.f130334b;
            int iZ = (iHashCode + (color == null ? 0 : Color.z(color.B()))) * 31;
            String str = this.f130335c;
            return iZ + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Small(imageVector=" + this.f130333a + ", iconTint=" + this.f130334b + ", text=" + this.f130335c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SmallRound extends ButtonType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImageVector f130336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Color f130337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f130338c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Dp f130339d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f130340e;

        public /* synthetic */ SmallRound(ImageVector imageVector, Color color, String str, Dp dp, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageVector, color, str, dp, z2);
        }

        public final Dp a() {
            return this.f130339d;
        }

        public final Color b() {
            return this.f130337b;
        }

        public final ImageVector c() {
            return this.f130336a;
        }

        public final boolean d() {
            return this.f130340e;
        }

        public final String e() {
            return this.f130338c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SmallRound)) {
                return false;
            }
            SmallRound smallRound = (SmallRound) obj;
            return Intrinsics.areEqual(this.f130336a, smallRound.f130336a) && Intrinsics.areEqual(this.f130337b, smallRound.f130337b) && Intrinsics.areEqual(this.f130338c, smallRound.f130338c) && Intrinsics.areEqual(this.f130339d, smallRound.f130339d) && this.f130340e == smallRound.f130340e;
        }

        public int hashCode() {
            ImageVector imageVector = this.f130336a;
            int iHashCode = (imageVector == null ? 0 : imageVector.hashCode()) * 31;
            Color color = this.f130337b;
            int iZ = (iHashCode + (color == null ? 0 : Color.z(color.B()))) * 31;
            String str = this.f130338c;
            int iHashCode2 = (iZ + (str == null ? 0 : str.hashCode())) * 31;
            Dp dp = this.f130339d;
            return ((iHashCode2 + (dp != null ? Dp.j(dp.l()) : 0)) * 31) + Boolean.hashCode(this.f130340e);
        }

        public String toString() {
            return "SmallRound(imageVector=" + this.f130336a + ", iconTint=" + this.f130337b + ", text=" + this.f130338c + ", horizontalPadding=" + this.f130339d + ", showForwardChevron=" + this.f130340e + ")";
        }

        private SmallRound(ImageVector imageVector, Color color, String str, Dp dp, boolean z2) {
            super(null);
            this.f130336a = imageVector;
            this.f130337b = color;
            this.f130338c = str;
            this.f130339d = dp;
            this.f130340e = z2;
        }

        public /* synthetic */ SmallRound(ImageVector imageVector, Color color, String str, Dp dp, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : imageVector, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : dp, (i3 & 16) != 0 ? false : z2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Squared extends ButtonType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImageVector f130341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Color f130342b;

        public final ImageVector a() {
            return this.f130341a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Squared)) {
                return false;
            }
            Squared squared = (Squared) obj;
            return Intrinsics.areEqual(this.f130341a, squared.f130341a) && Intrinsics.areEqual(this.f130342b, squared.f130342b);
        }

        public int hashCode() {
            ImageVector imageVector = this.f130341a;
            int iHashCode = (imageVector == null ? 0 : imageVector.hashCode()) * 31;
            Color color = this.f130342b;
            return iHashCode + (color != null ? Color.z(color.B()) : 0);
        }

        public String toString() {
            return "Squared(imageVector=" + this.f130341a + ", iconTint=" + this.f130342b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TinyRound extends ButtonType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImageVector f130343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Color f130344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f130345c;

        public /* synthetic */ TinyRound(ImageVector imageVector, Color color, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(imageVector, color, str);
        }

        public final Color a() {
            return this.f130344b;
        }

        public final ImageVector b() {
            return this.f130343a;
        }

        public final String c() {
            return this.f130345c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TinyRound)) {
                return false;
            }
            TinyRound tinyRound = (TinyRound) obj;
            return Intrinsics.areEqual(this.f130343a, tinyRound.f130343a) && Intrinsics.areEqual(this.f130344b, tinyRound.f130344b) && Intrinsics.areEqual(this.f130345c, tinyRound.f130345c);
        }

        public int hashCode() {
            ImageVector imageVector = this.f130343a;
            int iHashCode = (imageVector == null ? 0 : imageVector.hashCode()) * 31;
            Color color = this.f130344b;
            return ((iHashCode + (color != null ? Color.z(color.B()) : 0)) * 31) + this.f130345c.hashCode();
        }

        public String toString() {
            return "TinyRound(imageVector=" + this.f130343a + ", iconTint=" + this.f130344b + ", text=" + this.f130345c + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private TinyRound(ImageVector imageVector, Color color, String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f130343a = imageVector;
            this.f130344b = color;
            this.f130345c = text;
        }

        public /* synthetic */ TinyRound(ImageVector imageVector, Color color, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : imageVector, (i3 & 2) != 0 ? null : color, str, null);
        }
    }

    public /* synthetic */ ButtonType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ButtonType() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ProgressButton extends ButtonType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f130330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextStyle f130331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f130332c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProgressButton(String text, TextStyle textStyle, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.f130330a = text;
            this.f130331b = textStyle;
            this.f130332c = z2;
        }

        public final boolean a() {
            return this.f130332c;
        }

        public final String b() {
            return this.f130330a;
        }

        public final TextStyle c() {
            return this.f130331b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProgressButton)) {
                return false;
            }
            ProgressButton progressButton = (ProgressButton) obj;
            return Intrinsics.areEqual(this.f130330a, progressButton.f130330a) && Intrinsics.areEqual(this.f130331b, progressButton.f130331b) && this.f130332c == progressButton.f130332c;
        }

        public int hashCode() {
            int iHashCode = this.f130330a.hashCode() * 31;
            TextStyle textStyle = this.f130331b;
            return ((iHashCode + (textStyle == null ? 0 : textStyle.hashCode())) * 31) + Boolean.hashCode(this.f130332c);
        }

        public String toString() {
            return "ProgressButton(text=" + this.f130330a + ", textStyle=" + this.f130331b + ", inProgress=" + this.f130332c + ")";
        }

        public /* synthetic */ ProgressButton(String str, TextStyle textStyle, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : textStyle, z2);
        }
    }
}
