package androidx.compose.ui.text.font;

import androidx.collection.LruCache;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class TypefaceRequestCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SynchronizedObject f29279a = new SynchronizedObject();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LruCache f29280b = new LruCache(16);

    public final SynchronizedObject b() {
        return this.f29279a;
    }

    public final void c(List list, Function1 function1) {
        TypefaceResult typefaceResult;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            TypefaceRequest typefaceRequest = (TypefaceRequest) list.get(i3);
            synchronized (this.f29279a) {
                typefaceResult = (TypefaceResult) this.f29280b.get(typefaceRequest);
            }
            if (typefaceResult == null) {
                try {
                    TypefaceResult typefaceResult2 = (TypefaceResult) function1.invoke(typefaceRequest);
                    if (typefaceResult2 instanceof TypefaceResult.Async) {
                        continue;
                    }
                } catch (Exception e3) {
                    throw new IllegalStateException("Could not load font", e3);
                }
            }
        }
    }

    public final State d(final TypefaceRequest typefaceRequest, Function1 function1) {
        synchronized (this.f29279a) {
            TypefaceResult typefaceResult = (TypefaceResult) this.f29280b.get(typefaceRequest);
            if (typefaceResult != null) {
                if (typefaceResult.h()) {
                    return typefaceResult;
                }
            }
            try {
                TypefaceResult typefaceResult2 = (TypefaceResult) function1.invoke(new Function1<TypefaceResult, Unit>() { // from class: androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void c(TypefaceResult typefaceResult3) {
                        SynchronizedObject synchronizedObjectB = this.f29281a.b();
                        TypefaceRequestCache typefaceRequestCache = this.f29281a;
                        TypefaceRequest typefaceRequest2 = typefaceRequest;
                        synchronized (synchronizedObjectB) {
                            try {
                                if (typefaceResult3.h()) {
                                    typefaceRequestCache.f29280b.put(typefaceRequest2, typefaceResult3);
                                } else {
                                    typefaceRequestCache.f29280b.remove(typefaceRequest2);
                                }
                                Unit unit = Unit.f139807a;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        c((TypefaceResult) obj);
                        return Unit.f139807a;
                    }
                });
                synchronized (this.f29279a) {
                    try {
                        if (this.f29280b.get(typefaceRequest) == null && typefaceResult2.h()) {
                            this.f29280b.put(typefaceRequest, typefaceResult2);
                        }
                        Unit unit = Unit.f139807a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return typefaceResult2;
            } catch (Exception e3) {
                throw new IllegalStateException("Could not load font", e3);
            }
        }
    }
}
