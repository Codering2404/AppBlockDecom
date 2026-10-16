package okhttp3;

import com.google.android.gms.common.api.Api;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class CacheControl {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Companion f143911n = new Companion(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final CacheControl f143912o = new Builder().d().a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final CacheControl f143913p = new Builder().f().c(Api.BaseClientBuilder.API_PRIORITY_OTHER, TimeUnit.SECONDS).a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f143914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f143915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f143916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f143917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f143918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f143919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f143920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f143921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f143922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f143923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f143924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f143925l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f143926m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f143927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f143928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f143929c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f143930d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f143931e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f143932f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f143933g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f143934h;

        private final int b(long j3) {
            return j3 > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) j3;
        }

        public final CacheControl a() {
            return new CacheControl(this.f143927a, this.f143928b, this.f143929c, -1, false, false, false, this.f143930d, this.f143931e, this.f143932f, this.f143933g, this.f143934h, null, null);
        }

        public final Builder c(int i3, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (i3 < 0) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("maxStale < 0: ", Integer.valueOf(i3)).toString());
            }
            this.f143930d = b(timeUnit.toSeconds(i3));
            return this;
        }

        public final Builder d() {
            this.f143927a = true;
            return this;
        }

        public final Builder e() {
            this.f143928b = true;
            return this;
        }

        public final Builder f() {
            this.f143932f = true;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int a(String str, String str2, int i3) {
            int length = str.length();
            while (i3 < length) {
                int i4 = i3 + 1;
                if (StringsKt.Z(str2, str.charAt(i3), false, 2, null)) {
                    return i3;
                }
                i3 = i4;
            }
            return str.length();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okhttp3.CacheControl b(okhttp3.Headers r33) {
            /*
                Method dump skipped, instruction units count: 433
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.CacheControl.Companion.b(okhttp3.Headers):okhttp3.CacheControl");
        }

        private Companion() {
        }
    }

    public /* synthetic */ CacheControl(boolean z2, boolean z3, int i3, int i4, boolean z4, boolean z5, boolean z6, int i5, int i6, boolean z7, boolean z8, boolean z9, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, z3, i3, i4, z4, z5, z6, i5, i6, z7, z8, z9, str);
    }

    public final boolean a() {
        return this.f143925l;
    }

    public final boolean b() {
        return this.f143918e;
    }

    public final boolean c() {
        return this.f143919f;
    }

    public final int d() {
        return this.f143916c;
    }

    public final int e() {
        return this.f143921h;
    }

    public final int f() {
        return this.f143922i;
    }

    public final boolean g() {
        return this.f143920g;
    }

    public final boolean h() {
        return this.f143914a;
    }

    public final boolean i() {
        return this.f143915b;
    }

    public final boolean j() {
        return this.f143924k;
    }

    public final boolean k() {
        return this.f143923j;
    }

    public final int l() {
        return this.f143917d;
    }

    public String toString() {
        String str = this.f143926m;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (h()) {
            sb.append("no-cache, ");
        }
        if (i()) {
            sb.append("no-store, ");
        }
        if (d() != -1) {
            sb.append("max-age=");
            sb.append(d());
            sb.append(", ");
        }
        if (l() != -1) {
            sb.append("s-maxage=");
            sb.append(l());
            sb.append(", ");
        }
        if (b()) {
            sb.append("private, ");
        }
        if (c()) {
            sb.append("public, ");
        }
        if (g()) {
            sb.append("must-revalidate, ");
        }
        if (e() != -1) {
            sb.append("max-stale=");
            sb.append(e());
            sb.append(", ");
        }
        if (f() != -1) {
            sb.append("min-fresh=");
            sb.append(f());
            sb.append(", ");
        }
        if (k()) {
            sb.append("only-if-cached, ");
        }
        if (j()) {
            sb.append("no-transform, ");
        }
        if (a()) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        this.f143926m = string;
        return string;
    }

    private CacheControl(boolean z2, boolean z3, int i3, int i4, boolean z4, boolean z5, boolean z6, int i5, int i6, boolean z7, boolean z8, boolean z9, String str) {
        this.f143914a = z2;
        this.f143915b = z3;
        this.f143916c = i3;
        this.f143917d = i4;
        this.f143918e = z4;
        this.f143919f = z5;
        this.f143920g = z6;
        this.f143921h = i5;
        this.f143922i = i6;
        this.f143923j = z7;
        this.f143924k = z8;
        this.f143925l = z9;
        this.f143926m = str;
    }
}
