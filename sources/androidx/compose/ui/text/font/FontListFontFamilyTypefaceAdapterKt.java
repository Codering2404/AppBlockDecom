package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.AsyncTypefaceCache;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

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
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair b(List list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1 function1) {
        Object objInvoke;
        Object objInvoke2;
        Object objB;
        Object objG;
        int size = list.size();
        List listMutableListOf = null;
        for (int i3 = 0; i3 < size; i3++) {
            Font font = (Font) list.get(i3);
            int iC = font.c();
            FontLoadingStrategy.Companion companion = FontLoadingStrategy.f29206b;
            if (FontLoadingStrategy.f(iC, companion.b())) {
                synchronized (asyncTypefaceCache.f29134d) {
                    try {
                        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.a());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.f29132b.get(key);
                        if (asyncTypefaceResult == null) {
                            asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.f29133c.e(key);
                        }
                        if (asyncTypefaceResult != null) {
                            objInvoke2 = asyncTypefaceResult.g();
                        } else {
                            Unit unit = Unit.f139807a;
                            try {
                                objInvoke = platformFontLoader.b(font);
                            } catch (Exception unused) {
                                objInvoke = function1.invoke(typefaceRequest);
                            }
                            Object obj = objInvoke;
                            AsyncTypefaceCache.f(asyncTypefaceCache, font, platformFontLoader, obj, false, 8, null);
                            objInvoke2 = obj;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (objInvoke2 == null) {
                    objInvoke2 = function1.invoke(typefaceRequest);
                }
                return TuplesKt.a(listMutableListOf, FontSynthesis_androidKt.a(typefaceRequest.e(), objInvoke2, font, typefaceRequest.f(), typefaceRequest.d()));
            }
            if (FontLoadingStrategy.f(iC, companion.c())) {
                synchronized (asyncTypefaceCache.f29134d) {
                    try {
                        AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.a());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.f29132b.get(key2);
                        if (asyncTypefaceResult2 == null) {
                            asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.f29133c.e(key2);
                        }
                        if (asyncTypefaceResult2 != null) {
                            objG = asyncTypefaceResult2.g();
                        } else {
                            Unit unit2 = Unit.f139807a;
                            try {
                                Result.Companion companion2 = Result.f139772b;
                                objB = Result.b(platformFontLoader.b(font));
                            } catch (Throwable th2) {
                                Result.Companion companion3 = Result.f139772b;
                                objB = Result.b(ResultKt.a(th2));
                            }
                            Object obj2 = Result.g(objB) ? null : objB;
                            AsyncTypefaceCache.f(asyncTypefaceCache, font, platformFontLoader, obj2, false, 8, null);
                            objG = obj2;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (objG != null) {
                    return TuplesKt.a(listMutableListOf, FontSynthesis_androidKt.a(typefaceRequest.e(), objG, font, typefaceRequest.f(), typefaceRequest.d()));
                }
            } else {
                if (!FontLoadingStrategy.f(iC, companion.a())) {
                    throw new IllegalStateException("Unknown font type " + font);
                }
                AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResultD = asyncTypefaceCache.d(font, platformFontLoader);
                if (asyncTypefaceResultD != null) {
                    if (!AsyncTypefaceCache.AsyncTypefaceResult.e(asyncTypefaceResultD.g()) && asyncTypefaceResultD.g() != null) {
                        return TuplesKt.a(listMutableListOf, FontSynthesis_androidKt.a(typefaceRequest.e(), asyncTypefaceResultD.g(), font, typefaceRequest.f(), typefaceRequest.d()));
                    }
                } else if (listMutableListOf == null) {
                    listMutableListOf = CollectionsKt.mutableListOf(font);
                } else {
                    listMutableListOf.add(font);
                }
            }
        }
        return TuplesKt.a(listMutableListOf, function1.invoke(typefaceRequest));
    }
}
