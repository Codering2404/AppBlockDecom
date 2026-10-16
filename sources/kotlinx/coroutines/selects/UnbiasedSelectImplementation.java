package kotlinx.coroutines.selects;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectImplementation;

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
public class UnbiasedSelectImplementation<R> extends SelectImplementation<R> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f142621h;

    static /* synthetic */ Object C(UnbiasedSelectImplementation unbiasedSelectImplementation, Continuation continuation) {
        unbiasedSelectImplementation.D();
        return super.p(continuation);
    }

    private final void D() {
        try {
            Collections.shuffle(this.f142621h);
            Iterator it = this.f142621h.iterator();
            while (it.hasNext()) {
                SelectImplementation.x(this, (SelectImplementation.ClauseData) it.next(), false, 1, null);
            }
        } finally {
            this.f142621h.clear();
        }
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.SelectBuilder
    public void a(SelectClause0 selectClause0, Function1 function1) {
        this.f142621h.add(new SelectImplementation.ClauseData(selectClause0.d(), selectClause0.a(), selectClause0.c(), SelectKt.i(), function1, selectClause0.b()));
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation, kotlinx.coroutines.selects.SelectBuilder
    public void g(SelectClause1 selectClause1, Function2 function2) {
        this.f142621h.add(new SelectImplementation.ClauseData(selectClause1.d(), selectClause1.a(), selectClause1.c(), null, function2, selectClause1.b()));
    }

    @Override // kotlinx.coroutines.selects.SelectImplementation
    public Object p(Continuation continuation) {
        return C(this, continuation);
    }
}
