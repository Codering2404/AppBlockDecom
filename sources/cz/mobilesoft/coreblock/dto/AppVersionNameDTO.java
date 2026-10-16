package cz.mobilesoft.coreblock.dto;

import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AppVersionNameDTO implements Serializable, Comparable<AppVersionNameDTO> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReadWriteProperty f96894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReadWriteProperty f96895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReadWriteProperty f96896c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f96891f = {Reflection.e(new MutablePropertyReference1Impl(AppVersionNameDTO.class, "major", "getMajor()I", 0)), Reflection.e(new MutablePropertyReference1Impl(AppVersionNameDTO.class, "minor", "getMinor()I", 0)), Reflection.e(new MutablePropertyReference1Impl(AppVersionNameDTO.class, "fix", "getFix()I", 0))};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f96890d = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f96892g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Lazy f96893h = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.dto.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AppVersionNameDTO.b();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppVersionNameDTO a() {
            return b(LockieApplication.f95358c);
        }

        public final AppVersionNameDTO b(String str) {
            MatchResult matchResultE;
            String value;
            if (str != null && (matchResultE = Regex.e(new Regex("^\\d+\\.\\d+\\.\\d+"), str, 0, 2, null)) != null && (value = matchResultE.getValue()) != null) {
                AppVersionNameDTO appVersionNameDTO = new AppVersionNameDTO();
                try {
                    appVersionNameDTO.j(value);
                    return appVersionNameDTO;
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    CrashHelper.j(new IllegalArgumentException("VersionName in an unexpected format of " + str));
                }
            }
            return null;
        }

        public final AppVersionNameDTO c() {
            return (AppVersionNameDTO) AppVersionNameDTO.f96893h.getValue();
        }

        private Companion() {
        }
    }

    public AppVersionNameDTO() {
        Delegates delegates = Delegates.f140171a;
        this.f96894a = delegates.a();
        this.f96895b = delegates.a();
        this.f96896c = delegates.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppVersionNameDTO b() {
        AppVersionNameDTO appVersionNameDTO = new AppVersionNameDTO();
        appVersionNameDTO.l(0);
        appVersionNameDTO.m(0);
        appVersionNameDTO.k(0);
        return appVersionNameDTO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String str) {
        List listV0 = StringsKt.V0(StringsKt.t1(str).toString(), new String[]{"."}, false, 0, 6, null);
        if (listV0.size() != 3) {
            throw new IllegalArgumentException("\"" + str + "\" does not have 3 numbers separated by dots");
        }
        Integer numU = StringsKt.u((String) listV0.get(0));
        if (numU == null) {
            throw new IllegalArgumentException("\"" + str + "\" and its first part \"" + listV0.get(0) + "\" was not a number");
        }
        l(numU.intValue());
        Integer numU2 = StringsKt.u((String) listV0.get(1));
        if (numU2 == null) {
            throw new IllegalArgumentException("\"" + str + "\" and its second part \"" + listV0.get(1) + "\" was not a number");
        }
        m(numU2.intValue());
        Integer numU3 = StringsKt.u((String) listV0.get(2));
        if (numU3 != null) {
            k(numU3.intValue());
            return;
        }
        throw new IllegalArgumentException("\"" + str + "\" and its third part \"" + listV0.get(2) + "\" was not a number");
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(AppVersionNameDTO other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iCompare = Intrinsics.compare(h(), other.h());
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompare2 = Intrinsics.compare(i(), other.i());
        return iCompare2 != 0 ? iCompare2 : Intrinsics.compare(g(), other.g());
    }

    public boolean equals(Object obj) {
        return (obj instanceof AppVersionNameDTO) && compareTo((AppVersionNameDTO) obj) == 0;
    }

    public final int f(AppVersionNameDTO other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iCompare = Intrinsics.compare(h(), other.h());
        return iCompare != 0 ? iCompare : Intrinsics.compare(i(), other.i());
    }

    public final int g() {
        return ((Number) this.f96896c.a(this, f96891f[2])).intValue();
    }

    public final int h() {
        return ((Number) this.f96894a.a(this, f96891f[0])).intValue();
    }

    public final int i() {
        return ((Number) this.f96895b.a(this, f96891f[1])).intValue();
    }

    public final void k(int i3) {
        this.f96896c.b(this, f96891f[2], Integer.valueOf(i3));
    }

    public final void l(int i3) {
        this.f96894a.b(this, f96891f[0], Integer.valueOf(i3));
    }

    public final void m(int i3) {
        this.f96895b.b(this, f96891f[1], Integer.valueOf(i3));
    }

    public String toString() {
        return h() + "." + i() + "." + g();
    }

    public AppVersionNameDTO(int i3, int i4) {
        this();
        l(i3);
        m(i4);
        k(0);
    }

    public AppVersionNameDTO(int i3, int i4, int i5) {
        this();
        l(i3);
        m(i4);
        k(i5);
    }
}
