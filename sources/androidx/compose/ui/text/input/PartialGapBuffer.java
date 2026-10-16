package androidx.compose.ui.text.input;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
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
public final class PartialGapBuffer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f29397e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f29398f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GapBuffer f29400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29401c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29402d = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PartialGapBuffer(String str) {
        this.f29399a = str;
    }

    public final char a(int i3) {
        GapBuffer gapBuffer = this.f29400b;
        if (gapBuffer == null) {
            return this.f29399a.charAt(i3);
        }
        if (i3 < this.f29401c) {
            return this.f29399a.charAt(i3);
        }
        int iE = gapBuffer.e();
        int i4 = this.f29401c;
        return i3 < iE + i4 ? gapBuffer.d(i3 - i4) : this.f29399a.charAt(i3 - ((iE - this.f29402d) + i4));
    }

    public final int b() {
        GapBuffer gapBuffer = this.f29400b;
        return gapBuffer == null ? this.f29399a.length() : (this.f29399a.length() - (this.f29402d - this.f29401c)) + gapBuffer.e();
    }

    public final void c(int i3, int i4, String str) {
        if (!(i3 <= i4)) {
            InlineClassHelperKt.a("start index must be less than or equal to end index: " + i3 + " > " + i4);
        }
        if (!(i3 >= 0)) {
            InlineClassHelperKt.a("start must be non-negative, but was " + i3);
        }
        GapBuffer gapBuffer = this.f29400b;
        if (gapBuffer != null) {
            int i5 = this.f29401c;
            int i6 = i3 - i5;
            int i7 = i4 - i5;
            if (i6 >= 0 && i7 <= gapBuffer.e()) {
                gapBuffer.g(i6, i7, str);
                return;
            }
            this.f29399a = toString();
            this.f29400b = null;
            this.f29401c = -1;
            this.f29402d = -1;
            c(i3, i4, str);
            return;
        }
        int iMax = Math.max(255, str.length() + ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        char[] cArr = new char[iMax];
        int iMin = Math.min(i3, 64);
        int iMin2 = Math.min(this.f29399a.length() - i4, 64);
        int i8 = i3 - iMin;
        GapBuffer_jvmKt.a(this.f29399a, cArr, 0, i8, i3);
        int i9 = iMax - iMin2;
        int i10 = iMin2 + i4;
        GapBuffer_jvmKt.a(this.f29399a, cArr, i9, i4, i10);
        GapBufferKt.b(str, cArr, iMin);
        this.f29400b = new GapBuffer(cArr, iMin + str.length(), i9);
        this.f29401c = i8;
        this.f29402d = i10;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public String toString() {
        GapBuffer gapBuffer = this.f29400b;
        if (gapBuffer == null) {
            return this.f29399a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) this.f29399a, 0, this.f29401c);
        gapBuffer.a(sb);
        String str = this.f29399a;
        sb.append((CharSequence) str, this.f29402d, str.length());
        return sb.toString();
    }
}
