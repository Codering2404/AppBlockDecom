package cz.mobilesoft.coreblock.repository;

import com.revenuecat.purchases.CustomerInfo;
import cz.mobilesoft.coreblock.enums.PremiumDevState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$special$$inlined$flatMapLatest$1", f = "PremiumRepositoryV2.kt", l = {195, 196, 198, 189}, m = "invokeSuspend", v = 1)
public final class PremiumRepositoryV2$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super PremiumState>, Triple<? extends Boolean, ? extends CustomerInfo, ? extends PremiumDevState>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f97810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f97811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PremiumRepositoryV2 f97812d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f97813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f97814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f97815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f97816i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f97817j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f97818k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PremiumRepositoryV2$special$$inlined$flatMapLatest$1(Continuation continuation, PremiumRepositoryV2 premiumRepositoryV2) {
        super(3, continuation);
        this.f97812d = premiumRepositoryV2;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(FlowCollector flowCollector, Object obj, Continuation continuation) {
        PremiumRepositoryV2$special$$inlined$flatMapLatest$1 premiumRepositoryV2$special$$inlined$flatMapLatest$1 = new PremiumRepositoryV2$special$$inlined$flatMapLatest$1(continuation, this.f97812d);
        premiumRepositoryV2$special$$inlined$flatMapLatest$1.f97810b = flowCollector;
        premiumRepositoryV2$special$$inlined$flatMapLatest$1.f97811c = obj;
        return premiumRepositoryV2$special$$inlined$flatMapLatest$1.invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0185, code lost:
    
        if (kotlinx.coroutines.flow.FlowKt.A(r9, r14, r13) == r0) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0151  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$special$$inlined$flatMapLatest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
