package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.style.ResolvedTextDirection;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextFieldHandleState {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f10714f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final TextFieldHandleState f10715g = new TextFieldHandleState(false, Offset.f25596b.b(), 0.0f, ResolvedTextDirection.f29612a, false, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f10718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ResolvedTextDirection f10719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f10720e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextFieldHandleState a() {
            return TextFieldHandleState.f10715g;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextFieldHandleState(boolean z2, long j3, float f3, ResolvedTextDirection resolvedTextDirection, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, j3, f3, resolvedTextDirection, z3);
    }

    public final ResolvedTextDirection b() {
        return this.f10719d;
    }

    public final boolean c() {
        return this.f10720e;
    }

    public final float d() {
        return this.f10718c;
    }

    public final long e() {
        return this.f10717b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldHandleState)) {
            return false;
        }
        TextFieldHandleState textFieldHandleState = (TextFieldHandleState) obj;
        return this.f10716a == textFieldHandleState.f10716a && Offset.j(this.f10717b, textFieldHandleState.f10717b) && Float.compare(this.f10718c, textFieldHandleState.f10718c) == 0 && this.f10719d == textFieldHandleState.f10719d && this.f10720e == textFieldHandleState.f10720e;
    }

    public final boolean f() {
        return this.f10716a;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.f10716a) * 31) + Offset.o(this.f10717b)) * 31) + Float.hashCode(this.f10718c)) * 31) + this.f10719d.hashCode()) * 31) + Boolean.hashCode(this.f10720e);
    }

    public String toString() {
        return "TextFieldHandleState(visible=" + this.f10716a + ", position=" + ((Object) Offset.s(this.f10717b)) + ", lineHeight=" + this.f10718c + ", direction=" + this.f10719d + ", handlesCrossed=" + this.f10720e + ')';
    }

    private TextFieldHandleState(boolean z2, long j3, float f3, ResolvedTextDirection resolvedTextDirection, boolean z3) {
        this.f10716a = z2;
        this.f10717b = j3;
        this.f10718c = f3;
        this.f10719d = resolvedTextDirection;
        this.f10720e = z3;
    }
}
