package cz.mobilesoft.coreblock.scene.intro.quickblock;

import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.scene.schedule.detail.App;
import cz.mobilesoft.coreblock.scene.schedule.detail.WebOrKeyword;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithBlockedItems;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ExtensionsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewModel$updateAppList$1", f = "QuickBlockBlockingTestViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class QuickBlockBlockingTestViewModel$updateAppList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f104767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ QuickBlockBlockingTestViewModel f104768b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockBlockingTestViewModel$updateAppList$1(QuickBlockBlockingTestViewModel quickBlockBlockingTestViewModel, Continuation continuation) {
        super(2, continuation);
        this.f104768b = quickBlockBlockingTestViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockBlockingTestViewState y(List list, QuickBlockProfileDTO quickBlockProfileDTO, List list2, QuickBlockBlockingTestViewState quickBlockBlockingTestViewState) {
        return quickBlockBlockingTestViewState.a(ExtensionsKt.h(list), Boolean.valueOf(quickBlockProfileDTO.h().i()), ExtensionsKt.h(list2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockBlockingTestViewState z(QuickBlockBlockingTestViewState quickBlockBlockingTestViewState) {
        return quickBlockBlockingTestViewState.a(null, null, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new QuickBlockBlockingTestViewModel$updateAppList$1(this.f104768b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f104767a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        final QuickBlockProfileDTO quickBlockProfileDTOQ = this.f104768b.W0().q();
        if (quickBlockProfileDTOQ != null) {
            QuickBlockBlockingTestViewModel quickBlockBlockingTestViewModel = this.f104768b;
            List<ProfileWithBlockedItems.ApplicationProfileRelationWithApplication> listA = quickBlockProfileDTOQ.a();
            final ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
            for (ProfileWithBlockedItems.ApplicationProfileRelationWithApplication applicationProfileRelationWithApplication : listA) {
                arrayList.add(new App(applicationProfileRelationWithApplication.d(), applicationProfileRelationWithApplication.c(), ExtensionsKt.a()));
            }
            List listSortedWith = CollectionsKt.sortedWith(quickBlockProfileDTOQ.m(), new Comparator() { // from class: cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewModel$updateAppList$1$invokeSuspend$lambda$0$$inlined$compareBy$1
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    WebsiteProfileRelation.BlockingType blockingTypeA = ((WebsiteProfileRelation) obj2).a();
                    WebsiteProfileRelation.BlockingType blockingType = WebsiteProfileRelation.BlockingType.DOMAIN;
                    return ComparisonsKt.d(Boolean.valueOf(blockingTypeA != blockingType), Boolean.valueOf(((WebsiteProfileRelation) obj3).a() != blockingType));
                }
            });
            final ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
            Iterator it = listSortedWith.iterator();
            while (it.hasNext()) {
                arrayList2.add(new WebOrKeyword(((WebsiteProfileRelation) it.next()).c()));
            }
            quickBlockBlockingTestViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.quickblock.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return QuickBlockBlockingTestViewModel$updateAppList$1.y(arrayList, quickBlockProfileDTOQ, arrayList2, (QuickBlockBlockingTestViewState) obj2);
                }
            });
        } else {
            this.f104768b.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.quickblock.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return QuickBlockBlockingTestViewModel$updateAppList$1.z((QuickBlockBlockingTestViewState) obj2);
                }
            });
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((QuickBlockBlockingTestViewModel$updateAppList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
