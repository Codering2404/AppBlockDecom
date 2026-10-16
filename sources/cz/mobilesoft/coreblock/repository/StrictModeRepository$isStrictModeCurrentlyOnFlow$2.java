package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithIntervals;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.StrictModeRepository$isStrictModeCurrentlyOnFlow$2", f = "StrictModeRepository.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeRepository$isStrictModeCurrentlyOnFlow$2 extends SuspendLambda implements Function3<List<? extends ProfileWithIntervals>, Unit, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f98306b;

    StrictModeRepository$isStrictModeCurrentlyOnFlow$2(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(List list, Unit unit, Continuation continuation) {
        StrictModeRepository$isStrictModeCurrentlyOnFlow$2 strictModeRepository$isStrictModeCurrentlyOnFlow$2 = new StrictModeRepository$isStrictModeCurrentlyOnFlow$2(continuation);
        strictModeRepository$isStrictModeCurrentlyOnFlow$2.f98306b = list;
        return strictModeRepository$isStrictModeCurrentlyOnFlow$2.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list = (List) this.f98306b;
        IntrinsicsKt.f();
        if (this.f98305a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        List list2 = list;
        boolean z2 = false;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ProfileWithIntervals profileWithIntervals = (ProfileWithIntervals) it.next();
                if (ProfileHelper.C(ProfileHelper.f129250a, profileWithIntervals.b(), profileWithIntervals.a(), null, 2, null)) {
                    z2 = true;
                    break;
                }
            }
        }
        return Boxing.a(z2);
    }
}
