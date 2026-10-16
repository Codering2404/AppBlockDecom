package cz.mobilesoft.coreblock.scene.statistics;

import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet$canItemBeSelected$2$existingWebRelations$1", f = "StatisticsProfileListBottomSheet.kt", l = {138}, m = "invokeSuspend", v = 1)
final class StatisticsProfileListBottomSheet$canItemBeSelected$2$existingWebRelations$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f119702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StatisticsProfileListBottomSheet f119703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProfileViewDTO f119704c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsProfileListBottomSheet$canItemBeSelected$2$existingWebRelations$1(StatisticsProfileListBottomSheet statisticsProfileListBottomSheet, ProfileViewDTO profileViewDTO, Continuation continuation) {
        super(2, continuation);
        this.f119703b = statisticsProfileListBottomSheet;
        this.f119704c = profileViewDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StatisticsProfileListBottomSheet$canItemBeSelected$2$existingWebRelations$1(this.f119703b, this.f119704c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f119702a;
        if (i3 == 0) {
            ResultKt.b(obj);
            WebsiteProfileRelationDao websiteProfileRelationDaoU0 = this.f119703b.U0();
            long jK = this.f119704c.k();
            this.f119702a = 1;
            obj = websiteProfileRelationDaoU0.R(jK, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Iterable iterable = (Iterable) obj;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(((WebsiteProfileRelation) it.next()).c());
        }
        return arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StatisticsProfileListBottomSheet$canItemBeSelected$2$existingWebRelations$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
