package cz.mobilesoft.coreblock.scene.premium;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$initialize$4", f = "PremiumScreenViewModel.kt", l = {168, 169, 170, 195}, m = "emit", v = 1)
final class PremiumScreenViewModel$initialize$4$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f112412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f112413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f112414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f112415d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f112416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f112417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f112418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f112419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    /* synthetic */ Object f112420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ PremiumScreenViewModel$initialize$4 f112421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f112422l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumScreenViewModel$initialize$4$emit$1(PremiumScreenViewModel$initialize$4 premiumScreenViewModel$initialize$4, Continuation continuation) {
        super(continuation);
        this.f112421k = premiumScreenViewModel$initialize$4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f112420j = obj;
        this.f112422l |= Integer.MIN_VALUE;
        return this.f112421k.emit(null, this);
    }
}
