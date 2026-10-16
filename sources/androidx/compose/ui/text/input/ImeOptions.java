package androidx.compose.ui.text.input;

import androidx.compose.ui.text.intl.LocaleList;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ImeOptions {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f29359h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ImeOptions f29360i = new ImeOptions(false, 0, false, 0, 0, null, null, 127, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f29361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f29363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f29364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f29365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PlatformImeOptions f29366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LocaleList f29367g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImeOptions a() {
            return ImeOptions.f29360i;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ImeOptions(boolean z2, int i3, boolean z3, int i4, int i5, PlatformImeOptions platformImeOptions, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, i3, z3, i4, i5, platformImeOptions, localeList);
    }

    public final boolean b() {
        return this.f29363c;
    }

    public final int c() {
        return this.f29362b;
    }

    public final LocaleList d() {
        return this.f29367g;
    }

    public final int e() {
        return this.f29365e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImeOptions)) {
            return false;
        }
        ImeOptions imeOptions = (ImeOptions) obj;
        return this.f29361a == imeOptions.f29361a && KeyboardCapitalization.i(this.f29362b, imeOptions.f29362b) && this.f29363c == imeOptions.f29363c && KeyboardType.n(this.f29364d, imeOptions.f29364d) && ImeAction.m(this.f29365e, imeOptions.f29365e) && Intrinsics.areEqual(this.f29366f, imeOptions.f29366f) && Intrinsics.areEqual(this.f29367g, imeOptions.f29367g);
    }

    public final int f() {
        return this.f29364d;
    }

    public final PlatformImeOptions g() {
        return this.f29366f;
    }

    public final boolean h() {
        return this.f29361a;
    }

    public int hashCode() {
        int iHashCode = ((((((((Boolean.hashCode(this.f29361a) * 31) + KeyboardCapitalization.j(this.f29362b)) * 31) + Boolean.hashCode(this.f29363c)) * 31) + KeyboardType.o(this.f29364d)) * 31) + ImeAction.n(this.f29365e)) * 31;
        PlatformImeOptions platformImeOptions = this.f29366f;
        return ((iHashCode + (platformImeOptions != null ? platformImeOptions.hashCode() : 0)) * 31) + this.f29367g.hashCode();
    }

    public String toString() {
        return "ImeOptions(singleLine=" + this.f29361a + ", capitalization=" + ((Object) KeyboardCapitalization.k(this.f29362b)) + ", autoCorrect=" + this.f29363c + ", keyboardType=" + ((Object) KeyboardType.p(this.f29364d)) + ", imeAction=" + ((Object) ImeAction.o(this.f29365e)) + ", platformImeOptions=" + this.f29366f + ", hintLocales=" + this.f29367g + ')';
    }

    private ImeOptions(boolean z2, int i3, boolean z3, int i4, int i5, PlatformImeOptions platformImeOptions, LocaleList localeList) {
        this.f29361a = z2;
        this.f29362b = i3;
        this.f29363c = z3;
        this.f29364d = i4;
        this.f29365e = i5;
        this.f29366f = platformImeOptions;
        this.f29367g = localeList;
    }

    public /* synthetic */ ImeOptions(boolean z2, int i3, boolean z3, int i4, int i5, PlatformImeOptions platformImeOptions, LocaleList localeList, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? false : z2, (i6 & 2) != 0 ? KeyboardCapitalization.f29372b.b() : i3, (i6 & 4) != 0 ? true : z3, (i6 & 8) != 0 ? KeyboardType.f29379b.h() : i4, (i6 & 16) != 0 ? ImeAction.f29348b.a() : i5, (i6 & 32) != 0 ? null : platformImeOptions, (i6 & 64) != 0 ? LocaleList.f29471c.b() : localeList, null);
    }
}
