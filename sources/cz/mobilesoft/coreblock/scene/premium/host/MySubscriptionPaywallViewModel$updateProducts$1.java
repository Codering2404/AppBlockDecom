package cz.mobilesoft.coreblock.scene.premium.host;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.host.MySubscriptionPaywallViewModel", f = "MySubscriptionPaywallViewModel.kt", l = {114, 173, 174}, m = "updateProducts", v = 1)
final class MySubscriptionPaywallViewModel$updateProducts$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f113151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f113152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f113153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f113154d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f113155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f113156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f113157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f113158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f113159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f113160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f113161l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    /* synthetic */ Object f113162m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ MySubscriptionPaywallViewModel f113163n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f113164o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MySubscriptionPaywallViewModel$updateProducts$1(MySubscriptionPaywallViewModel mySubscriptionPaywallViewModel, Continuation continuation) {
        super(continuation);
        this.f113163n = mySubscriptionPaywallViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f113162m = obj;
        this.f113164o |= Integer.MIN_VALUE;
        return this.f113163n.u2(null, null, null, this);
    }
}
