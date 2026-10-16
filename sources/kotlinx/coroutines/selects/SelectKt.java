package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class SelectKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function3 f142605a = new Function3() { // from class: kotlinx.coroutines.selects.SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1
        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj, Object obj2, Object obj3) {
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Symbol f142606b = new Symbol("STATE_REG");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Symbol f142607c = new Symbol("STATE_COMPLETED");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Symbol f142608d = new Symbol("STATE_CANCELLED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Symbol f142609e = new Symbol("NO_RESULT");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Symbol f142610f = new Symbol("PARAM_CLAUSE_0");

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrySelectDetailedResult a(int i3) {
        if (i3 == 0) {
            return TrySelectDetailedResult.f142612a;
        }
        if (i3 == 1) {
            return TrySelectDetailedResult.f142613b;
        }
        if (i3 == 2) {
            return TrySelectDetailedResult.f142614c;
        }
        if (i3 == 3) {
            return TrySelectDetailedResult.f142615d;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i3).toString());
    }

    public static final Symbol i() {
        return f142610f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(CancellableContinuation cancellableContinuation, Function3 function3) {
        Object objQ = cancellableContinuation.Q(Unit.f139807a, null, function3);
        if (objQ == null) {
            return false;
        }
        cancellableContinuation.R(objQ);
        return true;
    }
}
