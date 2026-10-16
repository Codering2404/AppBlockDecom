package androidx.compose.ui.text.input;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
@Metadata
public final class TextInputSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextInputService f29455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PlatformTextInputService f29456b;

    public TextInputSession(TextInputService textInputService, PlatformTextInputService platformTextInputService) {
        this.f29455a = textInputService;
        this.f29456b = platformTextInputService;
    }

    public final void a() {
        this.f29455a.g(this);
    }

    public final boolean b() {
        return Intrinsics.areEqual(this.f29455a.a(), this);
    }

    public final boolean c(Rect rect) {
        boolean zB = b();
        if (zB) {
            this.f29456b.h(rect);
        }
        return zB;
    }

    public final boolean d(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        boolean zB = b();
        if (zB) {
            this.f29456b.d(textFieldValue, textFieldValue2);
        }
        return zB;
    }

    public final boolean e(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Function1 function1, Rect rect, Rect rect2) {
        boolean zB = b();
        if (zB) {
            this.f29456b.g(textFieldValue, offsetMapping, textLayoutResult, function1, rect, rect2);
        }
        return zB;
    }
}
