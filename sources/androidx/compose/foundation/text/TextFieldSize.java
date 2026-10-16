package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class TextFieldSize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LayoutDirection f10018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Density f10019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FontFamily.Resolver f10020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextStyle f10021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f10022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f10023f = a();

    public TextFieldSize(LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, TextStyle textStyle, Object obj) {
        this.f10018a = layoutDirection;
        this.f10019b = density;
        this.f10020c = resolver;
        this.f10021d = textStyle;
        this.f10022e = obj;
    }

    private final long a() {
        return TextFieldDelegateKt.b(this.f10021d, this.f10019b, this.f10020c, null, 0, 24, null);
    }

    public final long b() {
        return this.f10023f;
    }

    public final void c(LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, TextStyle textStyle, Object obj) {
        if (layoutDirection == this.f10018a && Intrinsics.areEqual(density, this.f10019b) && Intrinsics.areEqual(resolver, this.f10020c) && Intrinsics.areEqual(textStyle, this.f10021d) && Intrinsics.areEqual(obj, this.f10022e)) {
            return;
        }
        this.f10018a = layoutDirection;
        this.f10019b = density;
        this.f10020c = resolver;
        this.f10021d = textStyle;
        this.f10022e = obj;
        this.f10023f = a();
    }
}
