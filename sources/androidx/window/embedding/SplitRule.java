package androidx.window.embedding;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.WindowMetrics;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class SplitRule extends EmbeddingRule {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f54296h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final EmbeddingAspectRatio f54297i = EmbeddingAspectRatio.f54193c.a(1.4f);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final EmbeddingAspectRatio f54298j = EmbeddingAspectRatio.f54194d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f54299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f54300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f54301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EmbeddingAspectRatio f54302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EmbeddingAspectRatio f54303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SplitAttributes f54304g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Api30Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api30Impl f54305a = new Api30Impl();

        private Api30Impl() {
        }

        public final Rect a(WindowMetrics windowMetrics) {
            Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
            Rect bounds = windowMetrics.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "windowMetrics.bounds");
            return bounds;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Api34Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api34Impl f54306a = new Api34Impl();

        private Api34Impl() {
        }

        public final float a(WindowMetrics windowMetrics, Context context) {
            Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                return windowMetrics.getDensity();
            } catch (NoSuchMethodError unused) {
                return context.getResources().getDisplayMetrics().density;
            }
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
    public static final class FinishBehavior {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Companion f54307c = new Companion(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final FinishBehavior f54308d = new FinishBehavior("NEVER", 0);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final FinishBehavior f54309e = new FinishBehavior("ALWAYS", 1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final FinishBehavior f54310f = new FinishBehavior("ADJACENT", 2);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f54311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f54312b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        private FinishBehavior(String str, int i3) {
            this.f54311a = str;
            this.f54312b = i3;
        }

        public String toString() {
            return this.f54311a;
        }
    }

    private final int d(float f3, int i3) {
        return (int) ((i3 * f3) + 0.5f);
    }

    public final boolean b(float f3, Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        if (iWidth != 0 && iHeight != 0) {
            int iD = d(f3, this.f54299b);
            int iD2 = d(f3, this.f54300c);
            int iD3 = d(f3, this.f54301d);
            boolean z2 = this.f54299b == 0 || iWidth >= iD;
            boolean z3 = this.f54300c == 0 || iHeight >= iD2;
            boolean z4 = this.f54301d == 0 || Math.min(iWidth, iHeight) >= iD3;
            boolean z5 = iHeight < iWidth ? Intrinsics.areEqual(this.f54303f, EmbeddingAspectRatio.f54194d) || (((float) iWidth) * 1.0f) / ((float) iHeight) <= this.f54303f.a() : Intrinsics.areEqual(this.f54302e, EmbeddingAspectRatio.f54194d) || (((float) iHeight) * 1.0f) / ((float) iWidth) <= this.f54302e.a();
            if (z2 && z3 && z4 && z5) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(Context context, WindowMetrics parentMetrics) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parentMetrics, "parentMetrics");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 <= 30) {
            return false;
        }
        return b(i3 <= 33 ? context.getResources().getDisplayMetrics().density : Api34Impl.f54306a.a(parentMetrics, context), Api30Impl.f54305a.a(parentMetrics));
    }

    public final SplitAttributes e() {
        return this.f54304g;
    }

    @Override // androidx.window.embedding.EmbeddingRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitRule) || !super.equals(obj)) {
            return false;
        }
        SplitRule splitRule = (SplitRule) obj;
        return this.f54299b == splitRule.f54299b && this.f54300c == splitRule.f54300c && this.f54301d == splitRule.f54301d && Intrinsics.areEqual(this.f54302e, splitRule.f54302e) && Intrinsics.areEqual(this.f54303f, splitRule.f54303f) && Intrinsics.areEqual(this.f54304g, splitRule.f54304g);
    }

    public final EmbeddingAspectRatio f() {
        return this.f54303f;
    }

    public final EmbeddingAspectRatio g() {
        return this.f54302e;
    }

    public final int h() {
        return this.f54300c;
    }

    @Override // androidx.window.embedding.EmbeddingRule
    public int hashCode() {
        return (((((((((((super.hashCode() * 31) + this.f54299b) * 31) + this.f54300c) * 31) + this.f54301d) * 31) + this.f54302e.hashCode()) * 31) + this.f54303f.hashCode()) * 31) + this.f54304g.hashCode();
    }

    public final int i() {
        return this.f54301d;
    }

    public final int j() {
        return this.f54299b;
    }

    public String toString() {
        return SplitRule.class.getSimpleName() + "{ tag=" + a() + ", defaultSplitAttributes=" + this.f54304g + ", minWidthDp=" + this.f54299b + ", minHeightDp=" + this.f54300c + ", minSmallestWidthDp=" + this.f54301d + ", maxAspectRatioInPortrait=" + this.f54302e + ", maxAspectRatioInLandscape=" + this.f54303f + '}';
    }
}
