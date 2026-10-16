package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

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
public final class SemanticsPropertyKey<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f28565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f28566c;

    public SemanticsPropertyKey(String str, Function2 function2) {
        this.f28564a = str;
        this.f28565b = function2;
    }

    public final String a() {
        return this.f28564a;
    }

    public final boolean b() {
        return this.f28566c;
    }

    public final Object c(Object obj, Object obj2) {
        return this.f28565b.invoke(obj, obj2);
    }

    public final void d(SemanticsPropertyReceiver semanticsPropertyReceiver, KProperty kProperty, Object obj) {
        semanticsPropertyReceiver.a(this, obj);
    }

    public String toString() {
        return "AccessibilityKey: " + this.f28564a;
    }

    public /* synthetic */ SemanticsPropertyKey(String str, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? new Function2<T, T, T>() { // from class: androidx.compose.ui.semantics.SemanticsPropertyKey.1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return obj == null ? obj2 : obj;
            }
        } : function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SemanticsPropertyKey(String str, boolean z2) {
        this(str, null, 2, 0 == true ? 1 : 0);
        this.f28566c = z2;
    }

    public SemanticsPropertyKey(String str, boolean z2, Function2 function2) {
        this(str, function2);
        this.f28566c = z2;
    }
}
