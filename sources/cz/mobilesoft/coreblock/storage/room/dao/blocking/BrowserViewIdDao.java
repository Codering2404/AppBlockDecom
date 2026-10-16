package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import android.content.Context;
import com.facebook.stetho.common.Utf8Charset;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.BrowserConfigJson;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.BrowserConfigJsonKt;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public abstract class BrowserViewIdDao implements BaseDao<BrowserViewId>, KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f124988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f124989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Gson f124990c;

    /* JADX WARN: Multi-variable type inference failed */
    public BrowserViewIdDao() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f124988a = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f124989b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr2, objArr3);
            }
        });
        this.f124990c = new Gson();
    }

    private final CoreDataStore L() {
        return (CoreDataStore) this.f124988a.getValue();
    }

    private final EventDataStore N() {
        return (EventDataStore) this.f124989b.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0089 A[LOOP:0: B:24:0x0083->B:26:0x0089, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object P(cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$getUnsupportedBrowserPackageNames$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$getUnsupportedBrowserPackageNames$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$getUnsupportedBrowserPackageNames$1) r0
            int r1 = r0.f124995f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124995f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$getUnsupportedBrowserPackageNames$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$getUnsupportedBrowserPackageNames$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f124993c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124995f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.f124992b
            java.util.Set r6 = (java.util.Set) r6
            java.lang.Object r0 = r0.f124991a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao) r0
            kotlin.ResultKt.b(r7)
            goto L72
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.f124991a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao) r6
            kotlin.ResultKt.b(r7)
            goto L5a
        L44:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r7 = r6.L()
            kotlinx.coroutines.flow.Flow r7 = r7.l2()
            r0.f124991a = r6
            r0.f124995f = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L5a
            goto L6e
        L5a:
            java.util.Set r7 = (java.util.Set) r7
            cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId$ViewType r2 = cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId.ViewType.URL_BAR
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f124991a = r4
            r0.f124992b = r7
            r0.f124995f = r3
            java.lang.Object r6 = r6.K(r2, r0)
            if (r6 != r1) goto L6f
        L6e:
            return r1
        L6f:
            r5 = r7
            r7 = r6
            r6 = r5
        L72:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r1)
            r0.<init>(r1)
            java.util.Iterator r7 = r7.iterator()
        L83:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L97
            java.lang.Object r1 = r7.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId r1 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId) r1
            java.lang.String r1 = r1.getPackageName()
            r0.add(r1)
            goto L83
        L97:
            java.util.Set r7 = kotlin.collections.CollectionsKt.toSet(r0)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
        La6:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto Lbd
            java.lang.Object r1 = r6.next()
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = r7.contains(r2)
            if (r2 != 0) goto La6
            r0.add(r1)
            goto La6
        Lbd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao.P(cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object S(BrowserViewIdDao browserViewIdDao, Context context, String str, BrowserViewId.ViewType viewType, Continuation continuation) {
        Object objT = browserViewIdDao.t(browserViewIdDao.W(context, str, viewType), continuation);
        return objT == IntrinsicsKt.f() ? objT : Unit.f139807a;
    }

    private final String V(Context context, String str) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStreamOpen, Utf8Charset.NAME);
            String strH = TextStreamsKt.h(inputStreamReader);
            inputStreamReader.close();
            inputStreamOpen.close();
            return strH;
        } catch (IOException e3) {
            e3.printStackTrace();
            CrashHelper.j(e3);
            return null;
        }
    }

    private final List W(Context context, String str, BrowserViewId.ViewType viewType) {
        String strV = V(context, str);
        if (strV == null || strV.length() == 0) {
            return CollectionsKt.emptyList();
        }
        try {
            Object objK = this.f124990c.k(strV, new TypeToken<List<? extends BrowserConfigJson>>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$parseAllDefaultFromJson$listType$1
            }.d());
            Intrinsics.checkNotNullExpressionValue(objK, "fromJson(...)");
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) objK).iterator();
            while (it.hasNext()) {
                BrowserViewId browserViewIdA = BrowserConfigJsonKt.a((BrowserConfigJson) it.next(), viewType);
                if (browserViewIdA != null) {
                    arrayList.add(browserViewIdA);
                }
            }
            return arrayList;
        } catch (Exception e3) {
            e3.printStackTrace();
            CrashHelper.j(e3);
            return CollectionsKt.emptyList();
        }
    }

    public abstract Flow J();

    public abstract Object K(BrowserViewId.ViewType viewType, Continuation continuation);

    public abstract Object M(BrowserViewId.ViewType viewType, Continuation continuation);

    public Object O(Continuation continuation) {
        return P(this, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Q(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$hasUrlBars$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$hasUrlBars$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$hasUrlBars$1) r0
            int r1 = r0.f124998c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124998c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$hasUrlBars$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao$hasUrlBars$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f124996a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124998c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId$ViewType r5 = cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId.ViewType.URL_BAR
            r0.f124998c = r3
            java.lang.Object r5 = r4.M(r5, r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r5 <= 0) goto L48
            goto L49
        L48:
            r3 = 0
        L49:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao.Q(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object R(Context context, String str, BrowserViewId.ViewType viewType, Continuation continuation) {
        return S(this, context, str, viewType, continuation);
    }

    public final Object T(Context context, Continuation continuation) {
        Object objR = R(context, "incognito_view_ids.json", BrowserViewId.ViewType.INCOGNITO_BADGE, continuation);
        return objR == IntrinsicsKt.f() ? objR : Unit.f139807a;
    }

    public final Object U(Context context, Continuation continuation) {
        Object objR = R(context, "browser_view_ids.json", BrowserViewId.ViewType.URL_BAR, continuation);
        return objR == IntrinsicsKt.f() ? objR : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0116, code lost:
    
        if (r12.a0(r0) != r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object X(java.lang.String r10, cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId.ViewType r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.BrowserViewIdDao.X(java.lang.String, cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId$ViewType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
