package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
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
public final class CoroutineId extends AbstractCoroutineContextElement implements ThreadContextElement<String> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Key f140912b = new Key(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f140913a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Key implements CoroutineContext.Key<CoroutineId> {
        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Key() {
        }
    }

    public final long M() {
        return this.f140913a;
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void F(CoroutineContext coroutineContext, String str) {
        Thread.currentThread().setName(str);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public String V(CoroutineContext coroutineContext) {
        String strM;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.f140914b);
        if (coroutineName == null || (strM = coroutineName.M()) == null) {
            strM = "coroutine";
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        int iU0 = StringsKt.u0(name, " @", 0, false, 6, null);
        if (iU0 < 0) {
            iU0 = name.length();
        }
        StringBuilder sb = new StringBuilder(strM.length() + iU0 + 10);
        String strSubstring = name.substring(0, iU0);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        sb.append(" @");
        sb.append(strM);
        sb.append('#');
        sb.append(this.f140913a);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        threadCurrentThread.setName(string);
        return name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CoroutineId) && this.f140913a == ((CoroutineId) obj).f140913a;
    }

    public int hashCode() {
        return Long.hashCode(this.f140913a);
    }

    public String toString() {
        return "CoroutineId(" + this.f140913a + ')';
    }
}
