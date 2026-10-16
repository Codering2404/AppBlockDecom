package androidx.compose.ui.semantics;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
@JvmInline
public final class Role {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f28457b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f28458c = k(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f28459d = k(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f28460e = k(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f28461f = k(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f28462g = k(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f28463h = k(5);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f28464i = k(6);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f28465j = k(7);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f28466k = k(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28467a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return Role.f28458c;
        }

        public final int b() {
            return Role.f28466k;
        }

        public final int c() {
            return Role.f28459d;
        }

        public final int d() {
            return Role.f28464i;
        }

        public final int e() {
            return Role.f28463h;
        }

        public final int f() {
            return Role.f28461f;
        }

        public final int g() {
            return Role.f28460e;
        }

        public final int h() {
            return Role.f28462g;
        }

        public final int i() {
            return Role.f28465j;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Role(int i3) {
        this.f28467a = i3;
    }

    public static final /* synthetic */ Role j(int i3) {
        return new Role(i3);
    }

    public static boolean l(int i3, Object obj) {
        return (obj instanceof Role) && i3 == ((Role) obj).p();
    }

    public static final boolean m(int i3, int i4) {
        return i3 == i4;
    }

    public static int n(int i3) {
        return Integer.hashCode(i3);
    }

    public static String o(int i3) {
        return m(i3, f28458c) ? "Button" : m(i3, f28459d) ? "Checkbox" : m(i3, f28460e) ? "Switch" : m(i3, f28461f) ? "RadioButton" : m(i3, f28462g) ? "Tab" : m(i3, f28463h) ? "Image" : m(i3, f28464i) ? "DropdownList" : m(i3, f28465j) ? "Picker" : m(i3, f28466k) ? "Carousel" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public boolean equals(Object obj) {
        return l(this.f28467a, obj);
    }

    public int hashCode() {
        return n(this.f28467a);
    }

    public final /* synthetic */ int p() {
        return this.f28467a;
    }

    public String toString() {
        return o(this.f28467a);
    }

    private static int k(int i3) {
        return i3;
    }
}
