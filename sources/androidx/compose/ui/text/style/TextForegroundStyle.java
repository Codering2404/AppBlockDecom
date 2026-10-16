package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public interface TextForegroundStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f29638a = Companion.f29639a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f29639a = new Companion();

        private Companion() {
        }

        public final TextForegroundStyle a(Brush brush, float f3) {
            if (brush == null) {
                return Unspecified.f29640b;
            }
            if (brush instanceof SolidColor) {
                return b(TextDrawStyleKt.c(((SolidColor) brush).a(), f3));
            }
            if (brush instanceof ShaderBrush) {
                return new BrushStyle((ShaderBrush) brush, f3);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final TextForegroundStyle b(long j3) {
            return j3 != 16 ? new ColorStyle(j3, null) : Unspecified.f29640b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Unspecified implements TextForegroundStyle {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Unspecified f29640b = new Unspecified();

        private Unspecified() {
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public float a() {
            return Float.NaN;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public long d() {
            return Color.f25715b.k();
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public Brush e() {
            return null;
        }
    }

    float a();

    default TextForegroundStyle b(Function0 function0) {
        return !Intrinsics.areEqual(this, Unspecified.f29640b) ? this : (TextForegroundStyle) function0.invoke();
    }

    default TextForegroundStyle c(TextForegroundStyle textForegroundStyle) {
        boolean z2 = textForegroundStyle instanceof BrushStyle;
        return (z2 && (this instanceof BrushStyle)) ? new BrushStyle(((BrushStyle) textForegroundStyle).f(), TextDrawStyleKt.d(textForegroundStyle.a(), new Function0<Float>() { // from class: androidx.compose.ui.text.style.TextForegroundStyle$merge$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.f29641a.a());
            }
        })) : (!z2 || (this instanceof BrushStyle)) ? (z2 || !(this instanceof BrushStyle)) ? textForegroundStyle.b(new Function0<TextForegroundStyle>() { // from class: androidx.compose.ui.text.style.TextForegroundStyle$merge$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TextForegroundStyle invoke() {
                return this.f29642a;
            }
        }) : this : textForegroundStyle;
    }

    long d();

    Brush e();
}
