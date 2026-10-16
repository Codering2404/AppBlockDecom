package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class KeyboardOptions {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f9764h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final KeyboardOptions f9765i = new KeyboardOptions(0, null, 0, 0, null, null, null, 127, null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final KeyboardOptions f9766j = new KeyboardOptions(0, Boolean.FALSE, KeyboardType.f29379b.f(), 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, 121, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Boolean f9768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9770d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PlatformImeOptions f9771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Boolean f9772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LocaleList f9773g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KeyboardOptions a() {
            return KeyboardOptions.f9765i;
        }

        public final KeyboardOptions b() {
            return KeyboardOptions.f9766j;
        }

        private Companion() {
        }
    }

    public /* synthetic */ KeyboardOptions(int i3, Boolean bool, int i4, int i5, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, bool, i4, i5, platformImeOptions, bool2, localeList);
    }

    public static /* synthetic */ KeyboardOptions d(KeyboardOptions keyboardOptions, int i3, Boolean bool, int i4, int i5, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i6, Object obj) {
        LocaleList localeList2;
        Boolean bool3;
        int i7;
        PlatformImeOptions platformImeOptions2;
        Boolean bool4;
        int i8;
        KeyboardOptions keyboardOptions2;
        int i9;
        if ((i6 & 1) != 0) {
            i3 = keyboardOptions.f9767a;
        }
        if ((i6 & 2) != 0) {
            bool = keyboardOptions.f9768b;
        }
        if ((i6 & 4) != 0) {
            i4 = keyboardOptions.f9769c;
        }
        if ((i6 & 8) != 0) {
            i5 = keyboardOptions.f9770d;
        }
        if ((i6 & 16) != 0) {
            platformImeOptions = keyboardOptions.f9771e;
        }
        if ((i6 & 32) != 0) {
            bool2 = null;
        }
        if ((i6 & 64) != 0) {
            localeList2 = null;
            platformImeOptions2 = platformImeOptions;
            bool3 = bool2;
            i8 = i4;
            i7 = i5;
            i9 = i3;
            bool4 = bool;
            keyboardOptions2 = keyboardOptions;
        } else {
            localeList2 = localeList;
            bool3 = bool2;
            i7 = i5;
            platformImeOptions2 = platformImeOptions;
            bool4 = bool;
            i8 = i4;
            keyboardOptions2 = keyboardOptions;
            i9 = i3;
        }
        return keyboardOptions2.c(i9, bool4, i8, i7, platformImeOptions2, bool3, localeList2);
    }

    private final boolean f() {
        Boolean bool = this.f9768b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private final int g() {
        KeyboardCapitalization keyboardCapitalizationF = KeyboardCapitalization.f(this.f9767a);
        int iL = keyboardCapitalizationF.l();
        KeyboardCapitalization.Companion companion = KeyboardCapitalization.f29372b;
        if (KeyboardCapitalization.i(iL, companion.d())) {
            keyboardCapitalizationF = null;
        }
        return keyboardCapitalizationF != null ? keyboardCapitalizationF.l() : companion.b();
    }

    private final LocaleList h() {
        LocaleList localeList = this.f9773g;
        return localeList == null ? LocaleList.f29471c.b() : localeList;
    }

    private final int k() {
        KeyboardType keyboardTypeK = KeyboardType.k(this.f9769c);
        int iQ = keyboardTypeK.q();
        KeyboardType.Companion companion = KeyboardType.f29379b;
        if (KeyboardType.n(iQ, companion.i())) {
            keyboardTypeK = null;
        }
        return keyboardTypeK != null ? keyboardTypeK.q() : companion.h();
    }

    private final boolean m() {
        return KeyboardCapitalization.i(this.f9767a, KeyboardCapitalization.f29372b.d()) && this.f9768b == null && KeyboardType.n(this.f9769c, KeyboardType.f29379b.i()) && ImeAction.m(this.f9770d, ImeAction.f29348b.i()) && this.f9771e == null && this.f9772f == null && this.f9773g == null;
    }

    public final KeyboardOptions c(int i3, Boolean bool, int i4, int i5, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList) {
        return new KeyboardOptions(i3, bool, i4, i5, platformImeOptions, bool2, localeList, null);
    }

    public final KeyboardOptions e(KeyboardOptions keyboardOptions) {
        if (keyboardOptions == null || keyboardOptions.m() || Intrinsics.areEqual(keyboardOptions, this)) {
            return this;
        }
        if (m()) {
            return keyboardOptions;
        }
        KeyboardCapitalization keyboardCapitalizationF = KeyboardCapitalization.f(this.f9767a);
        if (KeyboardCapitalization.i(keyboardCapitalizationF.l(), KeyboardCapitalization.f29372b.d())) {
            keyboardCapitalizationF = null;
        }
        int iL = keyboardCapitalizationF != null ? keyboardCapitalizationF.l() : keyboardOptions.f9767a;
        Boolean bool = this.f9768b;
        if (bool == null) {
            bool = keyboardOptions.f9768b;
        }
        Boolean bool2 = bool;
        KeyboardType keyboardTypeK = KeyboardType.k(this.f9769c);
        if (KeyboardType.n(keyboardTypeK.q(), KeyboardType.f29379b.i())) {
            keyboardTypeK = null;
        }
        int iQ = keyboardTypeK != null ? keyboardTypeK.q() : keyboardOptions.f9769c;
        ImeAction imeActionJ = ImeAction.j(this.f9770d);
        ImeAction imeAction = ImeAction.m(imeActionJ.p(), ImeAction.f29348b.i()) ? null : imeActionJ;
        int iP = imeAction != null ? imeAction.p() : keyboardOptions.f9770d;
        PlatformImeOptions platformImeOptions = this.f9771e;
        if (platformImeOptions == null) {
            platformImeOptions = keyboardOptions.f9771e;
        }
        PlatformImeOptions platformImeOptions2 = platformImeOptions;
        Boolean bool3 = this.f9772f;
        if (bool3 == null) {
            bool3 = keyboardOptions.f9772f;
        }
        Boolean bool4 = bool3;
        LocaleList localeList = this.f9773g;
        if (localeList == null) {
            localeList = keyboardOptions.f9773g;
        }
        return new KeyboardOptions(iL, bool2, iQ, iP, platformImeOptions2, bool4, localeList, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) obj;
        return KeyboardCapitalization.i(this.f9767a, keyboardOptions.f9767a) && Intrinsics.areEqual(this.f9768b, keyboardOptions.f9768b) && KeyboardType.n(this.f9769c, keyboardOptions.f9769c) && ImeAction.m(this.f9770d, keyboardOptions.f9770d) && Intrinsics.areEqual(this.f9771e, keyboardOptions.f9771e) && Intrinsics.areEqual(this.f9772f, keyboardOptions.f9772f) && Intrinsics.areEqual(this.f9773g, keyboardOptions.f9773g);
    }

    public int hashCode() {
        int iJ = KeyboardCapitalization.j(this.f9767a) * 31;
        Boolean bool = this.f9768b;
        int iHashCode = (((((iJ + (bool != null ? bool.hashCode() : 0)) * 31) + KeyboardType.o(this.f9769c)) * 31) + ImeAction.n(this.f9770d)) * 31;
        PlatformImeOptions platformImeOptions = this.f9771e;
        int iHashCode2 = (iHashCode + (platformImeOptions != null ? platformImeOptions.hashCode() : 0)) * 31;
        Boolean bool2 = this.f9772f;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        LocaleList localeList = this.f9773g;
        return iHashCode3 + (localeList != null ? localeList.hashCode() : 0);
    }

    public final int i() {
        ImeAction imeActionJ = ImeAction.j(this.f9770d);
        int iP = imeActionJ.p();
        ImeAction.Companion companion = ImeAction.f29348b;
        if (ImeAction.m(iP, companion.i())) {
            imeActionJ = null;
        }
        return imeActionJ != null ? imeActionJ.p() : companion.a();
    }

    public final int j() {
        return this.f9769c;
    }

    public final boolean l() {
        Boolean bool = this.f9772f;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public final ImeOptions n(boolean z2) {
        return new ImeOptions(z2, g(), f(), k(), i(), this.f9771e, h(), null);
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) KeyboardCapitalization.k(this.f9767a)) + ", autoCorrectEnabled=" + this.f9768b + ", keyboardType=" + ((Object) KeyboardType.p(this.f9769c)) + ", imeAction=" + ((Object) ImeAction.o(this.f9770d)) + ", platformImeOptions=" + this.f9771e + "showKeyboardOnFocus=" + this.f9772f + ", hintLocales=" + this.f9773g + ')';
    }

    private KeyboardOptions(int i3, Boolean bool, int i4, int i5, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList) {
        this.f9767a = i3;
        this.f9768b = bool;
        this.f9769c = i4;
        this.f9770d = i5;
        this.f9771e = platformImeOptions;
        this.f9772f = bool2;
        this.f9773g = localeList;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ KeyboardOptions(int i3, Boolean bool, int i4, int i5, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        int iD = (i6 & 1) != 0 ? KeyboardCapitalization.f29372b.d() : i3;
        Boolean bool3 = (i6 & 2) != 0 ? null : bool;
        int i7 = (i6 & 4) != 0 ? KeyboardType.f29379b.i() : i4;
        int i8 = (i6 & 8) != 0 ? ImeAction.f29348b.i() : i5;
        PlatformImeOptions platformImeOptions2 = (i6 & 16) != 0 ? null : platformImeOptions;
        Boolean bool4 = (i6 & 32) != 0 ? null : bool2;
        this(iD, bool3, i7, i8, platformImeOptions2, bool4, (i6 & 64) == 0 ? localeList : null, null);
    }
}
