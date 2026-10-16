package androidx.compose.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
final class UnprojectedRipple extends RippleDrawable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f15441f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f15442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Color f15443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f15444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15445d;

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
    private static final class MRadiusHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MRadiusHelper f15446a = new MRadiusHelper();

        private MRadiusHelper() {
        }

        public final void a(RippleDrawable rippleDrawable, int i3) {
            rippleDrawable.setRadius(i3);
        }
    }

    public UnprojectedRipple(boolean z2) {
        super(ColorStateList.valueOf(-16777216), null, z2 ? new ColorDrawable(-1) : null);
        this.f15442a = z2;
    }

    private final long a(long j3, float f3) {
        return Color.r(j3, RangesKt.j(f3, 1.0f), 0.0f, 0.0f, 0.0f, 14, null);
    }

    public final void b(long j3, float f3) {
        long jA = a(j3, f3);
        Color color = this.f15443b;
        if (color == null ? false : Color.t(color.B(), jA)) {
            return;
        }
        this.f15443b = Color.n(jA);
        setColor(ColorStateList.valueOf(ColorKt.k(jA)));
    }

    public final void c(int i3) {
        Integer num = this.f15444c;
        if (num != null && num.intValue() == i3) {
            return;
        }
        this.f15444c = Integer.valueOf(i3);
        MRadiusHelper.f15446a.a(this, i3);
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        if (!this.f15442a) {
            this.f15445d = true;
        }
        Rect dirtyBounds = super.getDirtyBounds();
        this.f15445d = false;
        return dirtyBounds;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isProjected() {
        return this.f15445d;
    }
}
