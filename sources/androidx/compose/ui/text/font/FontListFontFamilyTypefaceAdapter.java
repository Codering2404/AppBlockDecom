package androidx.compose.ui.text.font;

import androidx.collection.MutableScatterSet;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.DispatcherKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

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
public final class FontListFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f29182c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f29183d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final FontMatcher f29184e = new FontMatcher();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final CoroutineExceptionHandler f29185f = new FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.u8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AsyncTypefaceCache f29186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CoroutineScope f29187b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache, CoroutineContext coroutineContext) {
        this.f29186a = asyncTypefaceCache;
        this.f29187b = CoroutineScopeKt.a(f29185f.plus(DispatcherKt.a()).plus(coroutineContext).plus(SupervisorKt.a((Job) coroutineContext.get(Job.v8))));
    }

    public final Object b(FontFamily fontFamily, PlatformFontLoader platformFontLoader, Continuation continuation) {
        FontFamily fontFamily2 = fontFamily;
        if (!(fontFamily2 instanceof FontListFontFamily)) {
            return Unit.f139807a;
        }
        FontListFontFamily fontListFontFamily = (FontListFontFamily) fontFamily2;
        List listL = fontListFontFamily.l();
        List listL2 = fontListFontFamily.l();
        ArrayList arrayList = new ArrayList(listL2.size());
        int size = listL2.size();
        for (int i3 = 0; i3 < size; i3++) {
            Font font = (Font) listL2.get(i3);
            if (FontLoadingStrategy.f(font.c(), FontLoadingStrategy.f29206b.a())) {
                arrayList.add(TuplesKt.a(font.b(), FontStyle.c(font.d())));
            }
        }
        MutableScatterSet mutableScatterSet = new MutableScatterSet(arrayList.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Object obj = arrayList.get(i4);
            if (mutableScatterSet.i((Pair) obj)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int size3 = arrayList2.size();
        int i5 = 0;
        while (i5 < size3) {
            Pair pair = (Pair) arrayList2.get(i5);
            FontWeight fontWeight = (FontWeight) pair.a();
            int i6 = ((FontStyle) pair.b()).i();
            List list = (List) FontListFontFamilyTypefaceAdapterKt.b(f29184e.a(listL, fontWeight, i6), new TypefaceRequest(fontFamily2, fontWeight, i6, FontSynthesis.f29215b.a(), platformFontLoader.a(), null), this.f29186a, platformFontLoader, new Function1<TypefaceRequest, Unit>() { // from class: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c((TypefaceRequest) obj2);
                    return Unit.f139807a;
                }

                public final void c(TypefaceRequest typefaceRequest) {
                }
            }).a();
            if (list != null) {
                arrayList3.add(CollectionsKt.first(list));
            }
            i5++;
            fontFamily2 = fontFamily;
        }
        Object objF = CoroutineScopeKt.f(new FontListFontFamilyTypefaceAdapter$preload$3(arrayList3, this, platformFontLoader, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public TypefaceResult c(TypefaceRequest typefaceRequest, PlatformFontLoader platformFontLoader, Function1 function1, Function1 function12) {
        if (!(typefaceRequest.c() instanceof FontListFontFamily)) {
            return null;
        }
        Pair pairB = FontListFontFamilyTypefaceAdapterKt.b(f29184e.a(((FontListFontFamily) typefaceRequest.c()).l(), typefaceRequest.f(), typefaceRequest.d()), typefaceRequest, this.f29186a, platformFontLoader, function12);
        List list = (List) pairB.a();
        Object objB = pairB.b();
        if (list == null) {
            return new TypefaceResult.Immutable(objB, false, 2, null);
        }
        AsyncFontListLoader asyncFontListLoader = new AsyncFontListLoader(list, objB, typefaceRequest, this.f29186a, function1, platformFontLoader);
        BuildersKt__Builders_commonKt.d(this.f29187b, null, CoroutineStart.f140919d, new FontListFontFamilyTypefaceAdapter$resolve$1(asyncFontListLoader, null), 1, null);
        return new TypefaceResult.Async(asyncFontListLoader);
    }

    public /* synthetic */ FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache, CoroutineContext coroutineContext, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new AsyncTypefaceCache() : asyncTypefaceCache, (i3 & 2) != 0 ? EmptyCoroutineContext.f139889a : coroutineContext);
    }
}
