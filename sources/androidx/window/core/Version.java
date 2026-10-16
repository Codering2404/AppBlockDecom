package androidx.window.core;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Version implements Comparable<Version> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f54150g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Version f54151h = new Version(0, 0, 0, "");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Version f54152i = new Version(0, 1, 0, "");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Version f54153j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Version f54154k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f54155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f54156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f54157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f54158d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f54159f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Version a() {
            return Version.f54152i;
        }

        public final Version b(String str) {
            String strGroup;
            if (str != null && !StringsKt.p0(str)) {
                Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
                if (matcher.matches() && (strGroup = matcher.group(1)) != null) {
                    int i3 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    if (strGroup2 != null) {
                        int i4 = Integer.parseInt(strGroup2);
                        String strGroup3 = matcher.group(3);
                        if (strGroup3 != null) {
                            int i5 = Integer.parseInt(strGroup3);
                            String description = matcher.group(4) != null ? matcher.group(4) : "";
                            Intrinsics.checkNotNullExpressionValue(description, "description");
                            return new Version(i3, i4, i5, description, null);
                        }
                    }
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        f54153j = version;
        f54154k = version;
    }

    public /* synthetic */ Version(int i3, int i4, int i5, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, i5, str);
    }

    private final BigInteger c() {
        Object value = this.f54159f.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(Version other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return c().compareTo(other.c());
    }

    public final int d() {
        return this.f54155a;
    }

    public final int e() {
        return this.f54156b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        return this.f54155a == version.f54155a && this.f54156b == version.f54156b && this.f54157c == version.f54157c;
    }

    public final int f() {
        return this.f54157c;
    }

    public int hashCode() {
        return ((((527 + this.f54155a) * 31) + this.f54156b) * 31) + this.f54157c;
    }

    public String toString() {
        String str;
        if (StringsKt.p0(this.f54158d)) {
            str = "";
        } else {
            str = '-' + this.f54158d;
        }
        return this.f54155a + '.' + this.f54156b + '.' + this.f54157c + str;
    }

    private Version(int i3, int i4, int i5, String str) {
        this.f54155a = i3;
        this.f54156b = i4;
        this.f54157c = i5;
        this.f54158d = str;
        this.f54159f = LazyKt.b(new Function0<BigInteger>() { // from class: androidx.window.core.Version$bigInteger$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final BigInteger invoke() {
                return BigInteger.valueOf(this.f54160a.d()).shiftLeft(32).or(BigInteger.valueOf(this.f54160a.e())).shiftLeft(32).or(BigInteger.valueOf(this.f54160a.f()));
            }
        });
    }
}
