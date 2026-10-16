package androidx.datastore.core.okio;

import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.datastore.core.okio.OkioReadScope", f = "OkioStorage.kt", l = {SensibleDefaults.X_OFFSET, 187}, m = "readData$suspendImpl")
final class OkioReadScope$readData$1<T> extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f35847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f35848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f35849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ OkioReadScope f35850d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f35851f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OkioReadScope$readData$1(OkioReadScope okioReadScope, Continuation continuation) {
        super(continuation);
        this.f35850d = okioReadScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f35849c = obj;
        this.f35851f |= Integer.MIN_VALUE;
        return OkioReadScope.j(this.f35850d, this);
    }
}
