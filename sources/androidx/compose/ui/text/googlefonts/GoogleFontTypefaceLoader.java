package androidx.compose.ui.text.googlefonts;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.ui.text.font.AndroidFont;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuationImpl;

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
@Metadata
public final class GoogleFontTypefaceLoader implements AndroidFont.TypefaceLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GoogleFontTypefaceLoader f29300a = new GoogleFontTypefaceLoader();

    private GoogleFontTypefaceLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler d() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        return HandlerHelper.f29303a.a(looperMyLooper);
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    public Object a(Context context, AndroidFont androidFont, Continuation continuation) {
        return e(context, androidFont, DefaultFontsContractCompatLoader.f29286a, continuation);
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    public Typeface b(Context context, AndroidFont androidFont) {
        throw new IllegalStateException(("GoogleFont only support async loading: " + androidFont).toString());
    }

    public final Object e(Context context, final AndroidFont androidFont, FontsContractCompatLoader fontsContractCompatLoader, Continuation continuation) {
        if (!(androidFont instanceof GoogleFontImpl)) {
            throw new IllegalArgumentException(("Only GoogleFontImpl supported (actual " + androidFont + ')').toString());
        }
        GoogleFontImpl googleFontImpl = (GoogleFontImpl) androidFont;
        FontRequest fontRequestG = googleFontImpl.g();
        int i3 = googleFontImpl.i();
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        fontsContractCompatLoader.a(context, fontRequestG, i3, f29300a.d(), new FontsContractCompat.FontRequestCallback() { // from class: androidx.compose.ui.text.googlefonts.GoogleFontTypefaceLoader$awaitLoad$4$callback$1
            @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
            public void a(int i4) {
                cancellableContinuationImpl.cancel(new IllegalStateException("Failed to load " + androidFont + " (reason=" + i4 + ", " + GoogleFontKt.c(i4) + ')'));
            }

            @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
            public void b(Typeface typeface) {
                cancellableContinuationImpl.resumeWith(Result.b(typeface));
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }
}
