package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

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
public final class AndroidFontLoader implements PlatformFontLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f29091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f29092b;

    public AndroidFontLoader(Context context) {
        this.f29091a = context.getApplicationContext();
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object a() {
        return this.f29092b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(androidx.compose.ui.text.font.Font r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = (androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1) r0
            int r1 = r0.f29097f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29097f = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = new androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f29095c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f29097f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.f29094b
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            java.lang.Object r0 = r0.f29093a
            androidx.compose.ui.text.font.AndroidFontLoader r0 = (androidx.compose.ui.text.font.AndroidFontLoader) r0
            kotlin.ResultKt.b(r7)
            goto L70
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.b(r7)
            return r7
        L40:
            kotlin.ResultKt.b(r7)
            boolean r7 = r6 instanceof androidx.compose.ui.text.font.AndroidFont
            if (r7 == 0) goto L59
            androidx.compose.ui.text.font.AndroidFont r6 = (androidx.compose.ui.text.font.AndroidFont) r6
            androidx.compose.ui.text.font.AndroidFont$TypefaceLoader r7 = r6.a()
            android.content.Context r2 = r5.f29091a
            r0.f29097f = r4
            java.lang.Object r6 = r7.a(r2, r6, r0)
            if (r6 != r1) goto L58
            goto L6e
        L58:
            return r6
        L59:
            boolean r7 = r6 instanceof androidx.compose.ui.text.font.ResourceFont
            if (r7 == 0) goto L7f
            r7 = r6
            androidx.compose.ui.text.font.ResourceFont r7 = (androidx.compose.ui.text.font.ResourceFont) r7
            android.content.Context r2 = r5.f29091a
            r0.f29093a = r5
            r0.f29094b = r6
            r0.f29097f = r3
            java.lang.Object r7 = androidx.compose.ui.text.font.AndroidFontLoader_androidKt.b(r7, r2, r0)
            if (r7 != r1) goto L6f
        L6e:
            return r1
        L6f:
            r0 = r5
        L70:
            android.graphics.Typeface r7 = (android.graphics.Typeface) r7
            androidx.compose.ui.text.font.ResourceFont r6 = (androidx.compose.ui.text.font.ResourceFont) r6
            androidx.compose.ui.text.font.FontVariation$Settings r6 = r6.e()
            android.content.Context r0 = r0.f29091a
            android.graphics.Typeface r6 = androidx.compose.ui.text.font.PlatformTypefaces_androidKt.c(r7, r6, r0)
            return r6
        L7f:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown font type: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AndroidFontLoader.c(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public android.graphics.Typeface b(Font font) {
        Object objB;
        android.graphics.Typeface typefaceC;
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            return androidFont.a().b(this.f29091a, androidFont);
        }
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        int iC = font.c();
        FontLoadingStrategy.Companion companion = FontLoadingStrategy.f29206b;
        if (FontLoadingStrategy.f(iC, companion.b())) {
            typefaceC = AndroidFontLoader_androidKt.c((ResourceFont) font, this.f29091a);
        } else {
            if (!FontLoadingStrategy.f(iC, companion.c())) {
                if (FontLoadingStrategy.f(iC, companion.a())) {
                    throw new UnsupportedOperationException("Unsupported Async font load path");
                }
                throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.h(font.c())));
            }
            try {
                Result.Companion companion2 = Result.f139772b;
                objB = Result.b(AndroidFontLoader_androidKt.c((ResourceFont) font, this.f29091a));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.f139772b;
                objB = Result.b(ResultKt.a(th));
            }
            typefaceC = (android.graphics.Typeface) (Result.g(objB) ? null : objB);
        }
        return PlatformTypefaces_androidKt.c(typefaceC, ((ResourceFont) font).e(), this.f29091a);
    }
}
