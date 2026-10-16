package cz.mobilesoft.appblock.view;

import com.facebook.internal.FacebookRequestErrorClassification;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider", f = "LockScreenProvider.kt", l = {315, 318, 322, 323, 329, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 352, 383, 406}, m = "init", v = 1)
final class LockScreenProvider$init$3 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f95204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f95205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f95206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f95207d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f95208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f95209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f95210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f95211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f95212j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    /* synthetic */ Object f95213k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95214l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f95215m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$init$3(LockScreenProvider lockScreenProvider, Continuation continuation) {
        super(continuation);
        this.f95214l = lockScreenProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f95213k = obj;
        this.f95215m |= Integer.MIN_VALUE;
        return this.f95214l.i0(null, this);
    }
}
