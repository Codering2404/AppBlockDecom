package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DualColorImageGenerator;
import com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DualColorImageGenerator {
    private static final int DEFAULT_IMAGE_SIZE = 200;
    public static final DualColorImageGenerator INSTANCE = new DualColorImageGenerator();
    private static final Lazy redGreen$delegate = LazyKt.b(new Function0<PreviewAppIcon>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DualColorImageGenerator$redGreen$2
        @Override // kotlin.jvm.functions.Function0
        public final DualColorImageGenerator.PreviewAppIcon invoke() {
            DualColorImageGenerator dualColorImageGenerator = DualColorImageGenerator.INSTANCE;
            Color.Companion companion = Color.f25715b;
            DualColorImageGenerator.PreviewAppIcon previewAppIconM1113createRFnl5yQ$default = DualColorImageGenerator.m1113createRFnl5yQ$default(dualColorImageGenerator, companion.i(), companion.f(), 0, 0, 12, null);
            if (previewAppIconM1113createRFnl5yQ$default != null) {
                return previewAppIconM1113createRFnl5yQ$default;
            }
            throw new IllegalStateException("Failed to generate redGreen preview icon");
        }
    });
    private static final Lazy blueGreen$delegate = LazyKt.b(new Function0<PreviewAppIcon>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DualColorImageGenerator$blueGreen$2
        @Override // kotlin.jvm.functions.Function0
        public final DualColorImageGenerator.PreviewAppIcon invoke() {
            DualColorImageGenerator dualColorImageGenerator = DualColorImageGenerator.INSTANCE;
            Color.Companion companion = Color.f25715b;
            DualColorImageGenerator.PreviewAppIcon previewAppIconM1113createRFnl5yQ$default = DualColorImageGenerator.m1113createRFnl5yQ$default(dualColorImageGenerator, companion.b(), companion.f(), 0, 0, 12, null);
            if (previewAppIconM1113createRFnl5yQ$default != null) {
                return previewAppIconM1113createRFnl5yQ$default;
            }
            throw new IllegalStateException("Failed to generate blueGreen preview icon");
        }
    });
    private static final Lazy purpleOrange$delegate = LazyKt.b(new Function0<PreviewAppIcon>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DualColorImageGenerator$purpleOrange$2
        @Override // kotlin.jvm.functions.Function0
        public final DualColorImageGenerator.PreviewAppIcon invoke() {
            DualColorImageGenerator.PreviewAppIcon previewAppIconM1113createRFnl5yQ$default = DualColorImageGenerator.m1113createRFnl5yQ$default(DualColorImageGenerator.INSTANCE, ColorKt.d(4286578816L), ColorKt.d(4294944000L), 0, 0, 12, null);
            if (previewAppIconM1113createRFnl5yQ$default != null) {
                return previewAppIconM1113createRFnl5yQ$default;
            }
            throw new IllegalStateException("Failed to generate purpleOrange preview icon");
        }
    });
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PreviewAppIcon {
        public static final int $stable = 8;
        private final Bitmap bitmap;
        private final List<Color> prominentColors;

        public PreviewAppIcon(Bitmap bitmap, List<Color> prominentColors) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(prominentColors, "prominentColors");
            this.bitmap = bitmap;
            this.prominentColors = prominentColors;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PreviewAppIcon copy$default(PreviewAppIcon previewAppIcon, Bitmap bitmap, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                bitmap = previewAppIcon.bitmap;
            }
            if ((i3 & 2) != 0) {
                list = previewAppIcon.prominentColors;
            }
            return previewAppIcon.copy(bitmap, list);
        }

        public final Bitmap component1() {
            return this.bitmap;
        }

        public final List<Color> component2() {
            return this.prominentColors;
        }

        public final PreviewAppIcon copy(Bitmap bitmap, List<Color> prominentColors) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(prominentColors, "prominentColors");
            return new PreviewAppIcon(bitmap, prominentColors);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PreviewAppIcon)) {
                return false;
            }
            PreviewAppIcon previewAppIcon = (PreviewAppIcon) obj;
            return Intrinsics.areEqual(this.bitmap, previewAppIcon.bitmap) && Intrinsics.areEqual(this.prominentColors, previewAppIcon.prominentColors);
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final List<Color> getProminentColors() {
            return this.prominentColors;
        }

        public int hashCode() {
            return (this.bitmap.hashCode() * 31) + this.prominentColors.hashCode();
        }

        public String toString() {
            return "PreviewAppIcon(bitmap=" + this.bitmap + ", prominentColors=" + this.prominentColors + ')';
        }
    }

    private DualColorImageGenerator() {
    }

    /* JADX INFO: renamed from: create-RFnl5yQ$default, reason: not valid java name */
    public static /* synthetic */ PreviewAppIcon m1113createRFnl5yQ$default(DualColorImageGenerator dualColorImageGenerator, long j3, long j4, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 200;
        }
        if ((i5 & 8) != 0) {
            i4 = 200;
        }
        return dualColorImageGenerator.m1114createRFnl5yQ(j3, j4, i3, i4);
    }

    private final Bitmap createBitmap(int i3, int i4, int i5, int i6) {
        if (i5 <= 0 || i6 <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, heig… Bitmap.Config.ARGB_8888)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        float f3 = i5;
        float f4 = f3 / 2.0f;
        paint.setColor(i3);
        float f5 = i6;
        canvas.drawRect(0.0f, 0.0f, f4, f5, paint);
        paint.setColor(i4);
        canvas.drawRect(f4, 0.0f, f3, f5, paint);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: renamed from: create-RFnl5yQ, reason: not valid java name */
    public final PreviewAppIcon m1114createRFnl5yQ(long j3, long j4, int i3, int i4) {
        Bitmap bitmapCreateBitmap = createBitmap(ColorKt.k(j3), ColorKt.k(j4), i3, i4);
        if (bitmapCreateBitmap == null) {
            return null;
        }
        return new PreviewAppIcon(bitmapCreateBitmap, AppStyleExtractor.INSTANCE.extractProminentColors$revenuecatui_defaultsBc8Release(bitmapCreateBitmap, 2));
    }

    public final PreviewAppIcon getBlueGreen() {
        return (PreviewAppIcon) blueGreen$delegate.getValue();
    }

    public final PreviewAppIcon getPurpleOrange() {
        return (PreviewAppIcon) purpleOrange$delegate.getValue();
    }

    public final PreviewAppIcon getRedGreen() {
        return (PreviewAppIcon) redGreen$delegate.getValue();
    }

    public static /* synthetic */ void getPurpleOrange$annotations() {
    }
}
