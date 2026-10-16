package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.FontFamily;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class FontFamilyResolverImpl implements FontFamily.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PlatformFontLoader f29162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PlatformResolveInterceptor f29163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TypefaceRequestCache f29164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FontListFontFamilyTypefaceAdapter f29165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PlatformFontFamilyTypefaceAdapter f29166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function1 f29167f;

    public FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter) {
        this.f29162a = platformFontLoader;
        this.f29163b = platformResolveInterceptor;
        this.f29164c = typefaceRequestCache;
        this.f29165d = fontListFontFamilyTypefaceAdapter;
        this.f29166e = platformFontFamilyTypefaceAdapter;
        this.f29167f = new Function1<TypefaceRequest, Object>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$createDefaultTypeface$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(TypefaceRequest typefaceRequest) {
                return this.f29168a.i(TypefaceRequest.b(typefaceRequest, null, null, 0, 0, null, 30, null)).getValue();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State i(final TypefaceRequest typefaceRequest) {
        return this.f29164c.d(typefaceRequest, new Function1<Function1<? super TypefaceResult, ? extends Unit>, TypefaceResult>() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$resolve$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final TypefaceResult invoke(Function1 function1) {
                TypefaceResult typefaceResultC = this.f29177a.f29165d.c(typefaceRequest, this.f29177a.g(), function1, this.f29177a.f29167f);
                if (typefaceResultC != null) {
                    return typefaceResultC;
                }
                TypefaceResult typefaceResultA = this.f29177a.f29166e.a(typefaceRequest, this.f29177a.g(), function1, this.f29177a.f29167f);
                if (typefaceResultA != null) {
                    return typefaceResultA;
                }
                throw new IllegalStateException("Could not load font");
            }
        });
    }

    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    public State a(FontFamily fontFamily, FontWeight fontWeight, int i3, int i4) {
        return i(new TypefaceRequest(this.f29163b.d(fontFamily), this.f29163b.a(fontWeight), this.f29163b.b(i3), this.f29163b.c(i4), this.f29162a.a(), null));
    }

    public final PlatformFontLoader g() {
        return this.f29162a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object h(androidx.compose.ui.text.font.FontFamily r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r14 instanceof androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1
            if (r0 == 0) goto L13
            r0 = r14
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r0 = (androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1) r0
            int r1 = r0.f29173f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29173f = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r0 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.f29171c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f29173f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r13 = r0.f29170b
            androidx.compose.ui.text.font.FontFamily r13 = (androidx.compose.ui.text.font.FontFamily) r13
            java.lang.Object r0 = r0.f29169a
            androidx.compose.ui.text.font.FontFamilyResolverImpl r0 = (androidx.compose.ui.text.font.FontFamilyResolverImpl) r0
            kotlin.ResultKt.b(r14)
            goto L55
        L31:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L39:
            kotlin.ResultKt.b(r14)
            boolean r14 = r13 instanceof androidx.compose.ui.text.font.FontListFontFamily
            if (r14 != 0) goto L43
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        L43:
            androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter r14 = r12.f29165d
            androidx.compose.ui.text.font.PlatformFontLoader r2 = r12.f29162a
            r0.f29169a = r12
            r0.f29170b = r13
            r0.f29173f = r3
            java.lang.Object r14 = r14.b(r13, r2, r0)
            if (r14 != r1) goto L54
            return r1
        L54:
            r0 = r12
        L55:
            r14 = r13
            androidx.compose.ui.text.font.FontListFontFamily r14 = (androidx.compose.ui.text.font.FontListFontFamily) r14
            java.util.List r14 = r14.l()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r14.size()
            r1.<init>(r2)
            r2 = r14
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            r3 = 0
        L6d:
            if (r3 >= r2) goto La7
            java.lang.Object r4 = r14.get(r3)
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.ui.text.font.Font) r4
            androidx.compose.ui.text.font.TypefaceRequest r5 = new androidx.compose.ui.text.font.TypefaceRequest
            androidx.compose.ui.text.font.PlatformResolveInterceptor r6 = r0.f29163b
            androidx.compose.ui.text.font.FontFamily r6 = r6.d(r13)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r7 = r0.f29163b
            androidx.compose.ui.text.font.FontWeight r8 = r4.b()
            androidx.compose.ui.text.font.FontWeight r7 = r7.a(r8)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r8 = r0.f29163b
            int r4 = r4.d()
            int r8 = r8.b(r4)
            androidx.compose.ui.text.font.FontSynthesis$Companion r4 = androidx.compose.ui.text.font.FontSynthesis.f29215b
            int r9 = r4.a()
            androidx.compose.ui.text.font.PlatformFontLoader r4 = r0.f29162a
            java.lang.Object r10 = r4.a()
            r11 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r1.add(r5)
            int r3 = r3 + 1
            goto L6d
        La7:
            androidx.compose.ui.text.font.TypefaceRequestCache r13 = r0.f29164c
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2 r14 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2
            r14.<init>()
            r13.c(r1, r14)
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontFamilyResolverImpl.h(androidx.compose.ui.text.font.FontFamily, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformFontLoader, (i3 & 2) != 0 ? PlatformResolveInterceptor.f29261a.a() : platformResolveInterceptor, (i3 & 4) != 0 ? FontFamilyResolverKt.b() : typefaceRequestCache, (i3 & 8) != 0 ? new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.a(), null, 2, 0 == true ? 1 : 0) : fontListFontFamilyTypefaceAdapter, (i3 & 16) != 0 ? new PlatformFontFamilyTypefaceAdapter() : platformFontFamilyTypefaceAdapter);
    }
}
