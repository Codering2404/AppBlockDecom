package kotlin.text;

import com.google.android.gms.common.api.Api;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class HexFormat {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f140532d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HexFormat f140533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HexFormat f140534f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f140535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BytesHexFormat f140536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NumberHexFormat f140537c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BytesHexFormat {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Companion f140538j = new Companion(null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final BytesHexFormat f140539k = new BytesHexFormat(Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, "  ", "", "", "");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f140540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f140541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f140542c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f140543d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f140544e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f140545f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f140546g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f140547h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f140548i;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Builder {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final BytesHexFormat a() {
                return BytesHexFormat.f140539k;
            }

            private Companion() {
            }
        }

        public BytesHexFormat(int i3, int i4, String groupSeparator, String byteSeparator, String bytePrefix, String byteSuffix) {
            Intrinsics.checkNotNullParameter(groupSeparator, "groupSeparator");
            Intrinsics.checkNotNullParameter(byteSeparator, "byteSeparator");
            Intrinsics.checkNotNullParameter(bytePrefix, "bytePrefix");
            Intrinsics.checkNotNullParameter(byteSuffix, "byteSuffix");
            this.f140540a = i3;
            this.f140541b = i4;
            this.f140542c = groupSeparator;
            this.f140543d = byteSeparator;
            this.f140544e = bytePrefix;
            this.f140545f = byteSuffix;
            this.f140546g = i3 == Integer.MAX_VALUE && i4 == Integer.MAX_VALUE;
            this.f140547h = bytePrefix.length() == 0 && byteSuffix.length() == 0 && byteSeparator.length() <= 1;
            this.f140548i = HexFormatKt.b(groupSeparator) || HexFormatKt.b(byteSeparator) || HexFormatKt.b(bytePrefix) || HexFormatKt.b(byteSuffix);
        }

        public final StringBuilder b(StringBuilder sb, String indent) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(indent, "indent");
            sb.append(indent);
            sb.append("bytesPerLine = ");
            sb.append(this.f140540a);
            sb.append(",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytesPerGroup = ");
            sb.append(this.f140541b);
            sb.append(",");
            sb.append('\n');
            sb.append(indent);
            sb.append("groupSeparator = \"");
            sb.append(this.f140542c);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSeparator = \"");
            sb.append(this.f140543d);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytePrefix = \"");
            sb.append(this.f140544e);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSuffix = \"");
            sb.append(this.f140545f);
            sb.append("\"");
            return sb;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BytesHexFormat(");
            sb.append('\n');
            b(sb, "    ").append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HexFormat a() {
            return HexFormat.f140533e;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NumberHexFormat {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Companion f140549h = new Companion(null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final NumberHexFormat f140550i = new NumberHexFormat("", "", false, 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f140551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f140552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f140553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f140554d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f140555e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f140556f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f140557g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Builder {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final NumberHexFormat a() {
                return NumberHexFormat.f140550i;
            }

            private Companion() {
            }
        }

        public NumberHexFormat(String prefix, String suffix, boolean z2, int i3) {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(suffix, "suffix");
            this.f140551a = prefix;
            this.f140552b = suffix;
            this.f140553c = z2;
            this.f140554d = i3;
            boolean z3 = prefix.length() == 0 && suffix.length() == 0;
            this.f140555e = z3;
            this.f140556f = z3 && i3 == 1;
            this.f140557g = HexFormatKt.b(prefix) || HexFormatKt.b(suffix);
        }

        public final StringBuilder b(StringBuilder sb, String indent) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(indent, "indent");
            sb.append(indent);
            sb.append("prefix = \"");
            sb.append(this.f140551a);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("suffix = \"");
            sb.append(this.f140552b);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("removeLeadingZeros = ");
            sb.append(this.f140553c);
            sb.append(',');
            sb.append('\n');
            sb.append(indent);
            sb.append("minLength = ");
            sb.append(this.f140554d);
            return sb;
        }

        public final boolean c() {
            return this.f140557g;
        }

        public final String d() {
            return this.f140551a;
        }

        public final String e() {
            return this.f140552b;
        }

        public final boolean f() {
            return this.f140555e;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NumberHexFormat(");
            sb.append('\n');
            b(sb, "    ").append('\n');
            sb.append(")");
            return sb.toString();
        }
    }

    static {
        BytesHexFormat.Companion companion = BytesHexFormat.f140538j;
        BytesHexFormat bytesHexFormatA = companion.a();
        NumberHexFormat.Companion companion2 = NumberHexFormat.f140549h;
        f140533e = new HexFormat(false, bytesHexFormatA, companion2.a());
        f140534f = new HexFormat(true, companion.a(), companion2.a());
    }

    public HexFormat(boolean z2, BytesHexFormat bytes, NumberHexFormat number) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(number, "number");
        this.f140535a = z2;
        this.f140536b = bytes;
        this.f140537c = number;
    }

    public final NumberHexFormat b() {
        return this.f140537c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HexFormat(");
        sb.append('\n');
        sb.append("    upperCase = ");
        sb.append(this.f140535a);
        sb.append(",");
        sb.append('\n');
        sb.append("    bytes = BytesHexFormat(");
        sb.append('\n');
        this.f140536b.b(sb, "        ").append('\n');
        sb.append("    ),");
        sb.append('\n');
        sb.append("    number = NumberHexFormat(");
        sb.append('\n');
        this.f140537c.b(sb, "        ").append('\n');
        sb.append("    )");
        sb.append('\n');
        sb.append(")");
        return sb.toString();
    }
}
