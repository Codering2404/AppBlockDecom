package androidx.compose.ui.autofill;

import androidx.compose.ui.geometry.Rect;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
@Deprecated
@Metadata
public final class AutofillNode {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f25217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f25218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f25219f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f25220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f25221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f25222c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        f25217d = companion;
        f25218e = 8;
        f25219f = companion;
    }

    public final List a() {
        return this.f25220a;
    }

    public final Rect b() {
        return this.f25221b;
    }

    public final Function1 c() {
        return this.f25222c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutofillNode)) {
            return false;
        }
        AutofillNode autofillNode = (AutofillNode) obj;
        return Intrinsics.areEqual(this.f25220a, autofillNode.f25220a) && Intrinsics.areEqual(this.f25221b, autofillNode.f25221b) && this.f25222c == autofillNode.f25222c;
    }

    public int hashCode() {
        int iHashCode = this.f25220a.hashCode() * 31;
        Rect rect = this.f25221b;
        int iHashCode2 = (iHashCode + (rect != null ? rect.hashCode() : 0)) * 31;
        Function1 function1 = this.f25222c;
        return iHashCode2 + (function1 != null ? function1.hashCode() : 0);
    }
}
