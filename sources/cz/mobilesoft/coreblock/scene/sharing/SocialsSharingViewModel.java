package cz.mobilesoft.coreblock.scene.sharing;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.provider.Telephony;
import com.facebook.internal.NativeProtocol;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.sharing.SocialsSharingViewEvent;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate;
import cz.mobilesoft.coreblock.scene.sharing.intents.ShareIntentTarget;
import cz.mobilesoft.coreblock.scene.sharing.intents.ShareIntentTargetsKt;
import cz.mobilesoft.coreblock.scene.sharing.intents.ShareableAppInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SocialsSharingViewModel extends BaseStatefulViewModel<SocialsSharingViewState, SocialsSharingViewEvent, SocialsSharingViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f119359o = new Companion(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f119360p = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f119361a;

        static {
            int[] iArr = new int[SocialsSharePayload.PeriodType.values().length];
            try {
                iArr[SocialsSharePayload.PeriodType.Day.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SocialsSharePayload.PeriodType.Week.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SocialsSharePayload.PeriodType.Trend.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SocialsSharePayload.PeriodType.WeeklyReport.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f119361a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialsSharingViewModel(Application application, final SocialsSharePayload graphPayload) {
        super(application, new SocialsSharingViewState(0, graphPayload, null, null, null, null, 61, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(graphPayload, "graphPayload");
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.sharing.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SocialsSharingViewModel.X0(this.f119598a, graphPayload, (SocialsSharingViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SocialsSharingViewState X0(SocialsSharingViewModel socialsSharingViewModel, SocialsSharePayload socialsSharePayload, SocialsSharingViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SocialsSharingViewState.b(updateState, 0, null, ShareFormattingKt.b(socialsSharePayload, socialsSharingViewModel.A0()), ShareFormattingKt.a(socialsSharePayload), socialsSharingViewModel.h1(), socialsSharingViewModel.f1(socialsSharePayload.n()), 3, null);
    }

    private final List Y0(final List list) {
        final String strG1 = g1();
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        List listS = SequencesKt.S(SequencesKt.P(SequencesKt.N(CollectionsKt.asSequence(ShareIntentTargetsKt.a()), new Function1() { // from class: cz.mobilesoft.coreblock.scene.sharing.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SocialsSharingViewModel.Z0(this.f119600a, list, strG1, linkedHashSet, (ShareIntentTarget) obj);
            }
        }), 5));
        if (listS.size() >= 5) {
            return listS;
        }
        final String packageName = A0().getPackageName();
        return CollectionsKt.plus((Collection) listS, (Iterable) SequencesKt.S(SequencesKt.P(SequencesKt.v(SequencesKt.A(SequencesKt.A(CollectionsKt.asSequence(list), new Function1() { // from class: cz.mobilesoft.coreblock.scene.sharing.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SocialsSharingViewModel.a1(packageName, (ShareableAppInfo) obj));
            }
        }), new Function1() { // from class: cz.mobilesoft.coreblock.scene.sharing.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SocialsSharingViewModel.b1(linkedHashSet, (ShareableAppInfo) obj));
            }
        }), new Function1() { // from class: cz.mobilesoft.coreblock.scene.sharing.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SocialsSharingViewModel.c1((ShareableAppInfo) obj);
            }
        }), 5 - listS.size())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShareableAppInfo Z0(SocialsSharingViewModel socialsSharingViewModel, List list, String str, LinkedHashSet linkedHashSet, ShareIntentTarget target) {
        Intrinsics.checkNotNullParameter(target, "target");
        ShareableAppInfo shareableAppInfoD1 = socialsSharingViewModel.d1(target, list, str);
        if (shareableAppInfoD1 == null) {
            return null;
        }
        if (linkedHashSet.add(shareableAppInfoD1.d() + "/" + shareableAppInfoD1.a())) {
            return shareableAppInfoD1;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a1(String str, ShareableAppInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !Intrinsics.areEqual(it.d(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c1(ShareableAppInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.d();
    }

    private final ShareableAppInfo d1(ShareIntentTarget shareIntentTarget, List list, String str) {
        Object obj = null;
        if (shareIntentTarget instanceof ShareIntentTarget.ActivityExact) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                ShareableAppInfo shareableAppInfo = (ShareableAppInfo) next;
                ShareIntentTarget.ActivityExact activityExact = (ShareIntentTarget.ActivityExact) shareIntentTarget;
                if (StringsKt.F(shareableAppInfo.d(), activityExact.b(), true) && StringsKt.F(shareableAppInfo.a(), activityExact.a(), true)) {
                    obj = next;
                    break;
                }
            }
            return (ShareableAppInfo) obj;
        }
        if (shareIntentTarget instanceof ShareIntentTarget.PackageFirst) {
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                if (StringsKt.F(((ShareableAppInfo) next2).d(), ((ShareIntentTarget.PackageFirst) shareIntentTarget).a(), true)) {
                    obj = next2;
                    break;
                }
            }
            return (ShareableAppInfo) obj;
        }
        if (!Intrinsics.areEqual(shareIntentTarget, ShareIntentTarget.DefaultSms.f119453a)) {
            throw new NoWhenBranchMatchedException();
        }
        if (str == null) {
            return null;
        }
        Iterator it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next3 = it3.next();
            if (StringsKt.F(((ShareableAppInfo) next3).d(), str, true)) {
                obj = next3;
                break;
            }
        }
        return (ShareableAppInfo) obj;
    }

    private final List e1(PackageManager packageManager) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        List<ResolveInfo> list = listQueryIntentActivities;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ResolveInfo resolveInfo : list) {
            Intrinsics.checkNotNull(resolveInfo);
            arrayList.add(k1(resolveInfo, packageManager));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ShareableAppInfo shareableAppInfo = (ShareableAppInfo) obj;
            if (hashSet.add(shareableAppInfo.d() + "/" + shareableAppInfo.a())) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private final List f1(SocialsSharePayload.PeriodType periodType) {
        int i3 = WhenMappings.f119361a[periodType.ordinal()];
        if (i3 == 1 || i3 == 2) {
            return CollectionsKt.listOf((Object[]) new SocialShareTemplate[]{SocialShareTemplate.ScreenTimeSquare, SocialShareTemplate.ScreenTimePortrait, SocialShareTemplate.ScreenTimeTransparent});
        }
        if (i3 == 3) {
            return CollectionsKt.listOf((Object[]) new SocialShareTemplate[]{SocialShareTemplate.UpsDownsSquare, SocialShareTemplate.UpsDownsPortrait, SocialShareTemplate.UpsDownsTransparent});
        }
        if (i3 == 4) {
            return CollectionsKt.listOf(SocialShareTemplate.WeeklyReportPortrait);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String g1() {
        Object objB;
        try {
            Result.Companion companion = Result.f139772b;
            objB = Result.b(Telephony.Sms.getDefaultSmsPackage(A0()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (String) objB;
    }

    private final List h1() {
        PackageManager packageManager = A0().getPackageManager();
        Intrinsics.checkNotNull(packageManager);
        return Y0(e1(packageManager));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SocialsSharingViewState j1(SocialsSharingViewEvent socialsSharingViewEvent, SocialsSharingViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SocialsSharingViewState.b(updateState, ((SocialsSharingViewEvent.OnPageChanged) socialsSharingViewEvent).a(), null, null, null, null, null, 62, null);
    }

    private final ShareableAppInfo k1(ResolveInfo resolveInfo, PackageManager packageManager) {
        String string = resolveInfo.loadLabel(packageManager).toString();
        Drawable drawableLoadIcon = resolveInfo.loadIcon(packageManager);
        Intrinsics.checkNotNullExpressionValue(drawableLoadIcon, "loadIcon(...)");
        String packageName = resolveInfo.activityInfo.packageName;
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        String name = resolveInfo.activityInfo.name;
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return new ShareableAppInfo(string, drawableLoadIcon, packageName, name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void O0(final SocialsSharingViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event instanceof SocialsSharingViewEvent.OnPageChanged)) {
            throw new NoWhenBranchMatchedException();
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.sharing.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SocialsSharingViewModel.j1(event, (SocialsSharingViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b1(LinkedHashSet linkedHashSet, ShareableAppInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return linkedHashSet.add(it.d() + YznnJpHcAmeoW.ZUMoOmcD + it.a());
    }
}
