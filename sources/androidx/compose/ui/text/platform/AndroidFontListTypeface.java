package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.font.FontSynthesis_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
@Metadata
public final class AndroidFontListTypeface implements AndroidTypeface {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Companion f29476c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f29477d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final FontMatcher f29478e = new FontMatcher();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FontMatcher f29479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f29480b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    public Typeface a(FontWeight fontWeight, int i3, int i4) {
        Font font = (Font) CollectionsKt.firstOrNull(this.f29479a.a(new ArrayList(this.f29480b.keySet()), fontWeight, i3));
        if (font == null) {
            InlineClassHelperKt.d("Could not load font");
            throw new KotlinNothingValueException();
        }
        Typeface typeface = (Typeface) this.f29480b.get(font);
        if (typeface == null) {
            InlineClassHelperKt.d("Could not load typeface");
            throw new KotlinNothingValueException();
        }
        Object objA = FontSynthesis_androidKt.a(i4, typeface, font, fontWeight, i3);
        Intrinsics.checkNotNull(objA, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) objA;
    }
}
