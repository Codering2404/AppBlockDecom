package androidx.compose.ui.text.font;

import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TypefaceRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FontFamily f29274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FontWeight f29275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f29276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f29277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f29278e;

    public /* synthetic */ TypefaceRequest(FontFamily fontFamily, FontWeight fontWeight, int i3, int i4, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontFamily, fontWeight, i3, i4, obj);
    }

    public static /* synthetic */ TypefaceRequest b(TypefaceRequest typefaceRequest, FontFamily fontFamily, FontWeight fontWeight, int i3, int i4, Object obj, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            fontFamily = typefaceRequest.f29274a;
        }
        if ((i5 & 2) != 0) {
            fontWeight = typefaceRequest.f29275b;
        }
        if ((i5 & 4) != 0) {
            i3 = typefaceRequest.f29276c;
        }
        if ((i5 & 8) != 0) {
            i4 = typefaceRequest.f29277d;
        }
        if ((i5 & 16) != 0) {
            obj = typefaceRequest.f29278e;
        }
        Object obj3 = obj;
        int i6 = i3;
        return typefaceRequest.a(fontFamily, fontWeight, i6, i4, obj3);
    }

    public final TypefaceRequest a(FontFamily fontFamily, FontWeight fontWeight, int i3, int i4, Object obj) {
        return new TypefaceRequest(fontFamily, fontWeight, i3, i4, obj, null);
    }

    public final FontFamily c() {
        return this.f29274a;
    }

    public final int d() {
        return this.f29276c;
    }

    public final int e() {
        return this.f29277d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypefaceRequest)) {
            return false;
        }
        TypefaceRequest typefaceRequest = (TypefaceRequest) obj;
        return Intrinsics.areEqual(this.f29274a, typefaceRequest.f29274a) && Intrinsics.areEqual(this.f29275b, typefaceRequest.f29275b) && FontStyle.f(this.f29276c, typefaceRequest.f29276c) && FontSynthesis.h(this.f29277d, typefaceRequest.f29277d) && Intrinsics.areEqual(this.f29278e, typefaceRequest.f29278e);
    }

    public final FontWeight f() {
        return this.f29275b;
    }

    public int hashCode() {
        FontFamily fontFamily = this.f29274a;
        int iHashCode = (((((((fontFamily == null ? 0 : fontFamily.hashCode()) * 31) + this.f29275b.hashCode()) * 31) + FontStyle.g(this.f29276c)) * 31) + FontSynthesis.i(this.f29277d)) * 31;
        Object obj = this.f29278e;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "TypefaceRequest(fontFamily=" + this.f29274a + ", fontWeight=" + this.f29275b + ", fontStyle=" + ((Object) FontStyle.h(this.f29276c)) + ", fontSynthesis=" + ((Object) FontSynthesis.l(this.f29277d)) + ", resourceLoaderCacheKey=" + this.f29278e + ')';
    }

    private TypefaceRequest(FontFamily fontFamily, FontWeight fontWeight, int i3, int i4, Object obj) {
        this.f29274a = fontFamily;
        this.f29275b = fontWeight;
        this.f29276c = i3;
        this.f29277d = i4;
        this.f29278e = obj;
    }
}
