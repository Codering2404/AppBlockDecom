package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

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
@DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1", f = "FontListFontFamilyTypefaceAdapter.kt", l = {109}, m = "invokeSuspend")
final class FontListFontFamilyTypefaceAdapter$preload$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f29194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FontListFontFamilyTypefaceAdapter f29195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Font f29196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PlatformFontLoader f29197d;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1", f = "FontListFontFamilyTypefaceAdapter.kt", l = {111}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Font f29199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PlatformFontLoader f29200c;

        /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1$1", f = "FontListFontFamilyTypefaceAdapter.kt", l = {112}, m = "invokeSuspend")
        static final class C00711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f29201a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ PlatformFontLoader f29202b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Font f29203c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00711(PlatformFontLoader platformFontLoader, Font font, Continuation continuation) {
                super(2, continuation);
                this.f29202b = platformFontLoader;
                this.f29203c = font;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00711(this.f29202b, this.f29203c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f29201a;
                if (i3 != 0) {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return obj;
                }
                ResultKt.b(obj);
                PlatformFontLoader platformFontLoader = this.f29202b;
                Font font = this.f29203c;
                this.f29201a = 1;
                Object objC = platformFontLoader.c(font, this);
                return objC == objF ? objF : objC;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C00711) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Font font, PlatformFontLoader platformFontLoader, Continuation continuation) {
            super(1, continuation);
            this.f29199b = font;
            this.f29200c = platformFontLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f29199b, this.f29200c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f29198a;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    C00711 c00711 = new C00711(this.f29200c, this.f29199b, null);
                    this.f29198a = 1;
                    obj = TimeoutKt.c(15000L, c00711, this);
                    if (obj == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                if (obj != null) {
                    return obj;
                }
                throw new IllegalStateException("Unable to load font " + this.f29199b);
            } catch (Exception e3) {
                throw new IllegalStateException("Unable to load font " + this.f29199b, e3);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontListFontFamilyTypefaceAdapter$preload$3$2$1(FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, Font font, PlatformFontLoader platformFontLoader, Continuation continuation) {
        super(2, continuation);
        this.f29195b = fontListFontFamilyTypefaceAdapter;
        this.f29196c = font;
        this.f29197d = platformFontLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FontListFontFamilyTypefaceAdapter$preload$3$2$1(this.f29195b, this.f29196c, this.f29197d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f29194a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        AsyncTypefaceCache asyncTypefaceCache = this.f29195b.f29186a;
        Font font = this.f29196c;
        PlatformFontLoader platformFontLoader = this.f29197d;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(font, platformFontLoader, null);
        this.f29194a = 1;
        Object objG = asyncTypefaceCache.g(font, platformFontLoader, true, anonymousClass1, this);
        return objG == objF ? objF : objG;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FontListFontFamilyTypefaceAdapter$preload$3$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
