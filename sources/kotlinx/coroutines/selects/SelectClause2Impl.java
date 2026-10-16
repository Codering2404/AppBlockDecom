package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class SelectClause2Impl<P, Q> implements SelectClause2<P, Q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f142579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function3 f142580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function3 f142581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function3 f142582d;

    public SelectClause2Impl(Object obj, Function3 function3, Function3 function32, Function3 function33) {
        this.f142579a = obj;
        this.f142580b = function3;
        this.f142581c = function32;
        this.f142582d = function33;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 a() {
        return this.f142580b;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public Function3 c() {
        return this.f142581c;
    }

    public /* synthetic */ SelectClause2Impl(Object obj, Function3 function3, Function3 function32, Function3 function33, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function3, function32, (i3 & 8) != 0 ? null : function33);
    }
}
